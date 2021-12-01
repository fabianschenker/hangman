# Game Hangman
### Informatik II & Software Engineering - Projekt

**Team:** Mattéo Sophys, Lara Cotti, Fabian Schenker, Matthias Gass, Max Knauber, Romain Bornex


## Inhaltsverzeichnis

1. [Einleitung](#1-einleitung)
2. [Ziele](#2-ziele)
3. [Randbedingungen](#3-randbedingungen)
4. [Build-Anleitung](#4-build-anleitung)
5. [Kurze Bedienungsanleitung](#5-kurze-bedienungsanleitung)
6. [User Stories](#6-user-storys)
7. [Releaseplan](#7-releaseplan)
8. [Dokumentation Sprint 1](#8-dokumentation-sprint-1)
    + Taskliste der User Storys
    + Anreicherung User Storys
    + UML Package, Klassen- und Sequenzdiagramm
    + Dokumentation wichtiger Code Snippets
    + Herleitung der Testfälle aus den User Storys
9. [Dokumentation Sprint 2](#9-dokumentation-sprint-2)
   + Taskliste der User Storys
   + Anreicherung User Storys
   + UML Package, Klassen- und Sequenzdiagramm
   + Dokumentation wichtiger Code Snippets
   + Herleitung der Testfälle aus den User Storys
10. [Fazit](#10-fazit)

## 1. Einleitung

Dieses Git-Repository wurde zur Dokumentation und Zusammenarbeit 
der Gruppe LAMAFAMAROMA in den Studienfächern Software Engineering
und Informatik II erstellt. 
Die Aufgabe war es, ein beliebiges Java Programm zu erstellen, das mit unseren Programmierungskenntnissen 
umgesetzt werden kann. 
Zudem soll mit JavaFX eine Benutzeroberfläche erstellt werden. 
Als Gruppe haben wir uns entschieden, das Spiel Hangman umzusetzen.

## 2. Ziele

Während des Projekts sollen wir lernen, wie wir die erworbenen Kompetenzen 
aus den zwei Fächern Programmieren und Software Engineering zusammen
verknüpfen können. 
Das Projekt soll in 2 Sprints umgesetzt werden
und über Jira koordiniert werden. Zusätzlich sollen die Rollen
Product Owner (PO) und Scrum Master (SM) von einem Gruppenmitglied übernommen
werden.

## 3. Randbedingungen

Das Programm soll in Java programmiert sein, wozu folgende Programme und Tools
zur Verfügung stehen:

Java: JDK 16.0 

Programmierumgebung: IntelliJ 

Build-Automatisierung: Maven 

Repository: Github 

Der Aufwand des Projektes wird gleichmässig auf alle Studierenden verteilt. 


## 4. Build Anleitung

git clone: [https://github.com/fabianschenker/hangman.git](https://github.com/fabianschenker/hangman.git)
#### Spiel mit IDE laufen lassen


1. Git Link zu unserem Repository kopieren. 
![](https://github.com/fabianschenker/hangman/blob/dev/images/1.jpg)
2. Im IntelliJ klicken sie auf File -> New -> Project from Version Control. 
![](https://github.com/fabianschenker/hangman/blob/dev/images/2.jpg)
3. Fügen Sie die Repo URL in das Feld ein und speichern Sie sie in *C:\HANGMAN* und klonen sie das ganze. 
![](https://github.com/fabianschenker/hangman/blob/dev/images/3.jpg)
4. Wählen Sie den neusten Release-Branch.
5. Stellen Sie sicher das im Terminal Java Version 16 aktiv ist.
6. Kontrollieren Sie dass Sie sich im Terminal auf *C:\HANGMAN* befinden.
7. Im Terminal, lassen Sie folgende Commands laufen:
    ```Javascript
   
       mvn clean javafx:jlink
       cd target/hangman-win/bin
       ./java -m com.example.hangman1/com.example.hangman1.RunGame
    
   ```



#### Spiel ohne IDE laufen lassen
1. Erstellen Sie im C:\ einen Ordner mit dem Namen HANGMAN
2. Laden Sie die Zip Datei aus dem Release Feld von Github herunter und entpacken Sie den Ordner in *C:\HANGMAN*
3. Suchen Sie im Ordner *C:\HANGMAN* die Verknüpfung zum Launcher hm-launcher.bat und führen sie diese aus.


## 5. Kurze Bedienungsanleitung

Das Ziel des Spiels Hangman ist es, mit möglichst wenig Versuchen ein unbekanntes Wort zu erraten. 
Dabei wird zu Beginn nur die Anzahl Buchstaben angezeigt, aus denen das Wort besteht. 
Nun kann man versuchen mit den 26 Buchstaben des Alphabets das Wort zu erraten. 
Wenn man einen richtigen Buchstaben erraten hat, dann wird die Position im Wort mit dem Buchstaben ersetzt. 
Wenn man nun aber einen falschen Buchstaben versucht, so wird ein Teil einer Hangman Figur gezeichnet. 
Das Spiel ist gewonnen, wenn man das Wort errät, bevor die elf Elemente der Hangman Figur auf dem Bildschirm dargestellt werden. 
Wenn die Hangman Figur zuvor fertiggestellt wird, ist das Spiel verloren.

## 6. User Storys

| User Story | Beschreibung | Akzeptanz Kriterien | Priorität | Story Points |
|----|----|----|----|----|
| 03 | Als Kunde möchte ich eine Anzeige der Wortlänge haben. | Damit der Spieler von Beginn an das Wort abschätzen kann. | hoch | 4 |
| 04 | Als Kunde möchte ich Buchstaben eingeben können, um die richtigen Buchstaben zu erraten. | Damit der Spieler mit dem Buchstaben eine Unterlinie ersetzten kann. | hoch | 8 |
| 05 | Als Kunde möchte ich korrekte Buchstaben anstelle des Platzhalters angezeigt bekommen. | Damit der Spieler sehen kann an welchen Positionen sich dieser Buchstaben im Wort befindet. | hoch | 9 |
| 06 | Als Kunde möchte ich falsche Buchstaben aufgelistet bekommen. | Damit der Spieler sehen kann welche nicht richtigen er schon verwendet hat. | hoch | 10 |
| 07 | Als Kunde möchte ich meinen Fortschritt durch eine Hangman Figur angezeigt bekommen. | Damit man sieht wie viele Fehlversuche man schon hatte. | hoch | 8 |
| 08 | Als Kunde möchte ich eine Meldung bekommen, wenn ich das Spiel gewonnen/verloren habe. | Damit der Spieler den Endstatus des Spiels angezeigt bekommt. | mittel | 6 |
| 09 | Als Supporter möchte ich eine hinterlegte Wort-Datenbank die angepasst werden kann. | Damit der Bearbeiter seine Wörter im Spiel ändern kann. | mittel | 4 |
| 10 | Als User möchte ich eine Meldung bei doppelter/ungültiger Dateneingabe. | Um zu sehen dass das Zeichen nicht geht oder schon benutzt worden ist. | mittel | 5 |
| 11 | Als User möchte ich als Spielsprache DEUTSCH definieren. | Damit die Wortwahl in der Wortliste sicher eindeutig ist.  | mittel | 2 |
| 12 | Als User möchte ich als Fehler-Anzahl für die Hangman Darstellung 11 definieren. Hügel, Pfahl, Pfahl, Querstrebe, Seil, Kopf, Körper, Arm, Arm, Bein, Bein | Damit klar ist wie viele Punkte dem Spieler noch fehlen. | mittel | 9 |
| 20 | Erstellen eines Maven Projekts mit einer HelloWorld Anwendung. | Um ein Grundgerüst für das Projekt zu erstellen | tief | 2 |
| 30 | Die verwendeten Buchstaben soll in einem Feld dargestellt werden. | Art der Umsetzung von US 06. | hoch | 8 |
| 31 | Die Hangman Grafik soll Schrittweise in 11 Elementen auf dem Bildschirm dargestellt werden. | Art der Umsetzung von US 07. | mittel | 6 |
| 32 | Die Darstellung der Buchstabenfelder soll durch ein Wort in Grossbuchstaben in einem Feld dargestellt werden | Art der Umsetzung von US 05. | hoch | 6 |
| 65 | Spaghetti Code Aufräumen | Kommentare, logische Struktur, Code vereinfachen. | mittel | 7 |
| 66 | Maven Test Projekt | Um Klassen und Methoden zu Testen | hoch | 08 |
| 67 | Klasse zur Eingabe von neuen Wörtern | Um die Wortdatenbank direkt aus dem Programm erweitern zu können | tief | 4 |
| 69 | UML | Um eine Übersicht über das Programm zu erhalten | tief | 8 |
| 77 | Build Projekt | Um über die Kommandozeile oder über vorgefertigte ZIP-Datei das Programm zu bilden, respektive zu entpacken und laufen zu lassen. | high | 8 |



- Die User Storys Nummerierung wurde zur Übersicht von der fortlaufenden Jira-Nummerierung übernommen.


## 7. Releaseplan

|  Release 1 | Release 2  | Ausbaustufe 1 | Ausbaustufe 2 |
|------------|------------|---------------|---------------|
|    US 03   |    US 07   |     US 67     |Datenbank
|    US 04   |    US 08   |Icon|Advanced Interfaces|
|    US 05   |    US 12   |-|Animations|
|    US 06   |    US 30   |
|    US 09   |    US 31   |
|    US 10   |    US 32   |
|    US 11   |    US 65   |
|    US 20   |    US 66   |
|      -     |    US 69   |
|      -     |    US 77   |



US = User Storys


## 8. Dokumentation Sprint 1

Zu Beginn des ersten Sprints hatten wir unser erstes Scrum-Meeting. Dabei ordneten wir unseren User Storys StoryPoints und Prioritäten zu.  
Danach teilten wir die User Storys jeweils einem Teammitglied zu, welches die Hauptverantwortung für diese Story trug. 
Jede Story hatte 1-5 Tasks, die benötigt wurden, um die Story zu vervollständigen.  
Wir kommunizierten untereinander welche Tasks eng miteinander zusammenarbeiteten und wer wen dadurch, falls nötig, unterstützen konnte. 
Jeder der Teilnehmer konnte seine Aufgaben pünktlich erfüllen und teilweise konnten wir bereits in ScreenBuilder Anwendungen vorgreifen.

### - Task Liste der User Storys

| User Story | Tasks  | Geschätzter Aufwand in Minuten| 
|------------|------------|---------------|
|    US 03   |  Klasse Wort erstellen zum auslesen der Datenbank | 210 |
|    US 04   |  Scanner erstellen, Klein in Grossbuchstaben, Nur erster Buchstabe in Char Einlesen | 120 |
|    US 05   |  Kontrolle Buchstabe korrekt, Eingabe Buchstabe in unbekanntes Wort | 180 |
|    US 06   |  Kontrolle Buchstabe falsch, Eingabe Buchstabe in Vektor "Falsch"  | 150 |
|    US 09   |  .txt file erstellen, zufälliges Auslesen eines Wortes   | 150 |
|    US 10   |  Vergleich zu Wort/Falsch, Kontrolle Gültig/Ungültig, Ausgabe Fehler  | 60 |
|    US 11   |  User Sprache Deutsch   | 30 |
|    US 20   |  Erstellen Maven Projekt zur Vorbereitung | 60 |


### - Anreicherung der User Storys für die Umsetzung

Erstellen Eingabe für Wort: 

Das Eingabefeld und der Enter Button der funktioniert. Auch das Wort wird schon mit Underlines angezeigt. 
![](https://github.com/fabianschenker/hangman/blob/dev/images/Screenshot%202021-12-01%20225309.jpg)

Spiel gewonnen: 

Die Darstellungen für "gewonnen" werden beim richtigen Wort angezeigt. 
![](https://github.com/fabianschenker/hangman/blob/dev/images/Screenshot%202021-12-01%20225319.jpg)


### - UML Package, Klassen- und Sequenzdiagramm
Wurde zu diesem Zeitpunkt noch nicht behandelt. Siehe [Dokumentation Sprint 2](#9-dokumentation-sprint-2) für die Dokumentation von Package und Diagrammen.

### - Dokumentation wichtiger Code Snippets 

**Überprüfung, ob der eingegebene Buchstabe bereits vorhanden ist** 
```Javascript
      static void doppelt(){
        for (int i = 0; i < richtig.length(); i++) {
            if (richtig.charAt(i) == Controller.ein) {
                counter--;
                }
            }
        }
```

**Überprüfen der Eingabe**
```Javascript
      Pattern p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
```

### - Herleitung der Testfälle aus den Akzeptanzkriterien der User Storys
Wurde zu diesem Zeitpunkt noch nicht behandelt. Siehe [Dokumentation Sprint 2](#9-dokumentation-sprint-2) für die Dokumentation der Testfälle.


## 9. Dokumentation Sprint 2

Auch den Sprint 2 konnten wir mit einem erfolgreichen SCRUM Meeting starten, bei dem wir neben den aufgeteilten UserStorys noch weitere hinzufügen konnten. 
Das Vergeben von Punkten und Aufgaben lief analog zum ersten Sprint.
Wir konnten auch in diesem Sprint unsere Ziele pünktlich erreichen.
Die Aufwandseinschätzung war zwar in diesem Sprint nicht mehr ganz so präzise, jedoch war die Gesamtzeit ungefähr die gleiche, was dies ausglich. 
Zudem hatten wir noch genug Zeit zur Verfügung um die Ausbaustufe 1 umzusetzen.


### Task Liste der User Storys

| User Story | Tasks | Geschätzter Aufwand in Minuten |
|------------|---------------|---------------|
|    US 07   |Fehlerzählung und Abfrage Fortschritt | 90 |
|    US 08   |SceneBuilder gewonnen/verloren kreieren, Abfrage gewonnen/verloren| 90 |
|    US 12   |Hangman Figur in SceneBuilder kreieren| 60 |
|    US 30   |SceneBuilder Auflistung verlorene Buchstaben, Abfrage verwendete Buchstaben| 120 |
|    US 31   |Anzeigebedingungen für Hangman Figur kreieren| 90 |
|    US 32   |Textfeld und Ausgabe für Wort| 90 |
|    US 65   |Aufräumen und Kürzen von längeren Code-Zeilen |120|
|    US 66   |Erstellen von Tests für Programm |210|
|    US 69   |Generieren von UML - Diagrammen der Programmstruktur|90|
|    US 77   |Build Projekt|240|

### - Anreicherung der User Storys für die Umsetzung

Startbildschirm: 

Der Startbildschirm wurde erstellt, um ein neues Wort direkt zu Beginn in die Wortliste einzufügen. 
![](https://github.com/fabianschenker/hangman/blob/dev/images/Screenshot%202021-12-01%20225357.jpg)

Worteingabe: 

Das Feld zur Worteingabe mit Anzeige der Eingabebedingungen. 
![](https://github.com/fabianschenker/hangman/blob/dev/images/Screenshot%202021-12-01%20225324.jpg)

### - UML Package, Klassen- und Sequenzdiagramm

erstes Sequenzdiagramm: 
![](https://github.com/fabianschenker/hangman/blob/dev/Diagrams/Controller_readEingabe.png)

zweites Sequenzdiagramm: 
![](https://github.com/fabianschenker/hangman/blob/dev/Diagrams/Controller_start.png)

Klassendiagramm: 
![](https://github.com/fabianschenker/hangman/blob/dev/Diagrams/hangman1.png)

### - Dokumentation wichtiger Code Snippets

**Aktion wenn Enter gedrückt wird** 
```Javascript
        public void readEingabe() {
            if(counter < 11 && startProgramm && !fertig) {
                    String e = meineEingabe.getText().toUpperCase();
                    if(e.equals(String.valueOf(random))){
                        GameEngine.counter = richtig.length();
                        victory();
                        erratenesWort.setText(String.valueOf(random));
                        meineEingabe.clear();
                    }else if(e.length()==1){
                        ein = e.charAt(0);
                        aufraeumen();
                        eingabeKontrollieren();
                        erratenesWort.setText(GameEngine.richtig);
                        falscheBuchstaben.setText(GameEngine.falsch);
                        progresImage();
                        victory();
                    }else{
                        makeVisibleL(ungueltigeEingabe);
                        meineEingabe.clear();
                        }
                    }
            }
```

**Fortschritt der Hangman Figur**
```Javascript
      if (!falsch.contains(Character.toString(input))) {
            Controller.counter++;
            falseLetters.add(input);
            falsch = ScreenOutput.buildFalse(falseLetters);
            }
```
### - Herleitung der Testfälle aus den Akzeptanzkriterien der User Storys

#### Beispiel aus der Testklasse GameEngineTest 

Um die Klasse test() zu testen, erzeugen wir ein randomWort um die Benutzereingabe zu simulieren
und lassen uns durch die entsprechende Funktion die Underlines anzeigen.
Wir lassen die Klasse Test() mit den vorherigen Parametern laufen und lassen uns die Positionen der A's darstellen
Durch AssertTrue sehen wir, ob die GameEngine.test() gut gelaufen ist.
Die Benutzung von assertAll() sorgt dafür, dass alle Funktionen durchlaufen werden und keine ausgelassen werden kann
```Javascript
         void test1() {
            Controller.random = "JAVATESTENISTSCHWER".toCharArray();
            Controller.underlines = Wort.buildUnderlines(Controller.random);
            Controller.ein = 'A';
            GameEngine.test();
            assertAll(
                    ()-> assertEquals(GameEngine.richtig,"_A_A_______________","GameEngine.richtig nicht korrekt"),
                    ()-> assertTrue(GameEngine.visible[1],"Erstes A nicht erkannt"),
                     ()-> assertTrue(GameEngine.visible[3],"Zweites A nicht erkannt")

            );
            }
```
#### Beispiel aus der Testklasse VergleichTest

Um die Klasse Vergleich zu testen, erstellen wir ein testword, dieses verpacken wir in einen char, suchen uns einen Buchstaben aus und notieren seine Position im Wort. 
Den zu erratenden Buchstaben speichern wir in einem Vektor. 
Über assertEquals testen wir die richtige Grösse des Testvektors und ob die Positionen des zu testenden Buchstabens richtig erfasst wurden.
```Javascript
      void position() {
            char[] testchar = "HUNDSGEMEIN".toCharArray();
            Vector<Integer> testvector = Vergleich.position(testchar, 'E');
            Assertions.assertAll(
            () -> assertEquals(testvector.size(), 2, "Anzahl richtige Buchstaben stimmt nicht"),
            //Integers in the vector "position" should be 6 and 8 =14
            () -> assertEquals(testvector.get(0) + testvector.get(1), 14, "Position nicht richtig erfasst"));
            }
```

## 10. Fazit

Durch das Projekt Hangman haben wir sehr viel gelernt und wir sind mit dem Resultat sehr zufrieden. 
Als besondere Herausforderung hat sich Github mit der Administration der ganzen Merges herausgestellt. 
Es erleichterte besonders die Zusammenarbeit zwischen den einzelnen Aufgaben und das parallele Arbeiten an gleichen Themen,
jedoch hat es sich für uns Beginner als knifflige Aufgabe herausgestellt alles ohne Verluste zu mergen. 
Des Weiteren waren es eher die kleinen Dinge, die am meisten Ehrgeiz in Anspruch nahmen wie z.B. das Einfügen des Logos für das Programm. 
Schlussendlich sind wir aber mit allen Aufgaben, die wir uns gestellt haben, fertig geworden und dürfen nun unser fertiges Projekt präsentieren. 


***
Projekt Hangman, Mechatronik Trinational, Promotion Franklin, Dez. 2021