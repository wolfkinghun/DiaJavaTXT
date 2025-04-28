# 📽️ Diafilm Projekt

---

## 📚 Feladatleírás

A `diafilm.csv` fájl különböző diafilmek adatait tartalmazza az alábbi formátumban:

- Adatok elválasztója: pontosvessző (`;`)
- Fájl kódolása: `utf-8`
- **Figyelem**: az első sor fejléc!

Készítsünk egy **Diafilm** nevű projektet, és oldjuk meg az alábbi feladatokat!

---

## 🛠️ Feladatok

### 0. Adatbeolvasás és alapstatisztikák
- Olvassuk be a fájl adatait egy megfelelő adatszerkezetbe. (2 pont)
- Jelenítsük meg:
  - A beolvasott adatok számát.
  - A fekete-fehér diafilmek számát. (1 pont)

---

### 1. Legrégebbi diafilm
- Írjuk ki a legrégebbi diafilm címét és készítésének évét! (1 pont)
- Listázzuk az ugyanebben az évben készült többi diafilmet is (a legrégebbin kívül)! (2 pont)

---

### 2. Átlagos kockaszámok
- Határozzuk meg a 2000 előtti diafilmek átlagos kockaszámát! (1 pont)
- Határozzuk meg a 2000 után vagy akkortól készült diafilmek átlagát is! (1 pont)

---

### 3. Évtizedes statisztika
- Készítsünk statisztikát az egyes évtizedekben készült diafilmek számáról! (2 pont)

---

### 4. Legtöbb kocka
- Írjuk ki:
  - Melyik évben készült a legtöbb kocka összesen? (2 pont)
  - Melyik évben készült a második legtöbb kocka? (1 pont)

---

### 5. Fájlba írás
- Mentsük a **200x** években (azaz 2000-2009 közötti) készült diafilmek adatait egy `200x.txt` fájlba, a mintának megfelelő formában! (2 pont)

---

## 📝 Minta kimenet

```text
0) 705 diafilm adata beolvasva
   Közülük 141 még fekete-fehér

1) A legrégebbi diafilm: A cár és a madár (1950)
   De ugyanebben az évben készült még:
   - Mese az aranykakasról (1950)
   - Buksi (1950)
   - Az öntelt veréb (1950)

2) A 2000 előtt készült diafilmek átlagos kockaszáma: 38,7
   A később készült diafilmeknél az átlag: 29,4

3) Az egyes évtizedekben készült diafilmek száma:
   1950-1959 : 254 darab
   1960-1969 : 126 darab
   1970-1979 : 118 darab
   1980-1989 : 181 darab
   1990-1999 : 15 darab
   2000-2009 : 6 darab
   2010-2019 : 5 darab

4) A legtöbb kocka (3053 db) készítésének éve: 1957
   A második legtöbb kocka (2016 db) éve: 1958

5) A 200x évben megjelent diák adatai elmentve (200x.txt)
