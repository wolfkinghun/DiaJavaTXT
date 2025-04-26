package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public class Adat{
        String rendezveny;
        Integer ev;
        Integer kocka;
        String szines;

        public Adat(String sor){
            String[]s=sor.split(";");
            rendezveny=s[0];
            ev= Integer.parseInt(s[1]);
            kocka= Integer.parseInt(s[2]);
            szines = s[3];
        }
    }
    ArrayList<Adat> adatok=new ArrayList<Adat>();

    public void betolt(String fajlnev) {
        Scanner be = null;
        try {
            be = new Scanner(new File(fajlnev), "utf-8");
            be.nextLine();
            while (be.hasNextLine()) adatok.add(new Adat(be.nextLine()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public Main() {
        betolt("diafilm.csv");
        System.out.println("0) " + adatok.size() + " diafilm adata beolvasva");
        //1.feladat
        int min = 9999;
        ArrayList<Adat> legreg  = new ArrayList<>();
        for (Adat x:adatok
             ) {
            if(x.ev<min){
                legreg.clear();
                legreg.add(x);
                min=x.ev;
            }
        }
        legreg.clear();
        for (Adat x:adatok
             ) {
            if (x.ev.equals(min)){
                legreg.add(x);
            }
        }
        System.out.println(" 1) A legrégebbi diafilm:"+legreg.get(0).rendezveny+"("+legreg.get(0).ev+")");
        legreg.remove(0);
        for (Adat c: legreg
             ) {
            System.out.println("\t-"+c.rendezveny+"("+c.ev+")");
        }

        //2.feladat
        int db2000elott = 0;
        int db2000utan = 0;
        float db2000elottossz = 0;
        float db2000utanossz = 0;
        for (Adat x: adatok
             ) {
            if(x.ev>2000){
                db2000utan++;
                db2000utanossz+=x.ev;
            }
            else if(2000>x.ev){
                db2000elott++;
                db2000elottossz+=x.kocka;
            }
        }
        System.out.printf(" 2) A 2000 előtt készült diafilmek átlagos kockaszáma: %.2f%n",db2000elottossz/db2000elott);
        System.out.printf("  A később készült diafilmeknél az áltag: %.2f%n",db2000utanossz/db2000utan);
        //3.feladat
        TreeMap<Integer, Integer> evDarab = new TreeMap<>();
        for (Adat x : adatok) {
            int evtized = x.ev / 10;
            if (!evDarab.containsKey(evtized)) evDarab.put(evtized, 1); else evDarab.put(evtized, evDarab.get(evtized)+1);
        }
        System.out.printf("3) Az egyes évtizedekben készült diafilmek száma:\n");
        for (Integer evtized : evDarab.keySet()) {
            System.out.printf("   %d0-%d9 : %d darab\n", evtized, evtized, evDarab.get(evtized));
        }
        //4.feladat
        TreeMap<Integer, Integer> evKocka = new TreeMap<>();
        for (Adat f : adatok) {
            if (!evKocka.containsKey(f.ev)) evKocka.put(f.ev, f.kocka); else evKocka.put(f.ev, evKocka.get(f.ev)+f.kocka);
        }
        int legtobbEv = adatok.get(0).ev;

        for (Integer ev : evKocka.keySet()) {
            if (evKocka.get(ev) > evKocka.get(legtobbEv)) legtobbEv = ev;
        }
        System.out.printf("4) A legtöbb kocka (%d db) készítésének éve: %d\n", evKocka.get(legtobbEv), legtobbEv);

        int masodikEv = legtobbEv; evKocka.put(legtobbEv, 0);
        for (Integer ev : evKocka.keySet()) {
            if (evKocka.get(ev) > evKocka.get(masodikEv)) masodikEv = ev;
        }
        System.out.printf("   A második legtöbb kocka (%d db) éve: %d\n", evKocka.get(masodikEv), masodikEv);

        //5.feladat
        PrintWriter ki = null;

        try {
            ki = new PrintWriter(new File("200x.txt"), "UTF-8");

            for (Adat x : adatok) {
                if ((x.ev+"").contains("200")) {
                    ki.printf("%s; %d; %d;%s\r\n", x.rendezveny, x.ev, x.kocka,x.szines);
                }
            }
            System.out.printf("\n5) A 200x évben megjelent diák adatai elmentve (200x.txt)\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ki != null) {
                ki.close();
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}