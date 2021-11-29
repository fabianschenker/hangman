# Game Hangman
**Informatik II & Software Engineering - Projekt**

Team: Mattéo Sophys, Lara Cotti, Fabian Schenker, Matthias Gass, Max Knauber, Romain Bornex


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
und Informatik II erstellt. Die Aufgabe war es, ein beliebiges Java
Programm zu erstellen, das mit unseren Programmierungskenntnissen 
umgesetzt werden kann. Zudem soll mit JavaFX eine Benutzeroberfläche
erstellt werden. 
Als Gruppe haben wir uns entschieden, das Spiel Hangman umzusetzen.

## 2. Ziele

Während des Projekts sollen wir lernen, wie wir die erworbenen Kompetenzen 
aus den zwei Fächern Programmieren und Software Engineering zusammen
verknüpfen können. Das Projekt soll in 2 Sprints umgesetzt werden
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



## 5. Kurze Bedienungsanleitung

Das Ziel des Spiels Hangman ist es, mit möglichst wenig Versuchen ein unbekanntes Wort zu erraten. Dabei wird zu Beginn nur die Anzahl Buchstaben angezeigt, aus denen das Wort besteht.
Nun kann man versuchen mit den 26 Buchstaben des Alphabets das Wort zu erraten. Wenn man einen richtigen Buchstaben erraten hat, dann wird die Position im Wort mit dem Buchstaben ersetzt.
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
| 20 | Erstellen eines Maven Projekts mit einer HelloWorld Anwendung. |  | hoch | 0 |
| 30 | Die verwendeten Buchstaben soll in einem Feld dargestellt werden. | Art der Umsetzung von US 06. | hoch | 8 |
| 31 | Die Hangman Grafik soll Schrittweise in 11 Elementen auf dem Bildschirm dargestellt werden. | Art der Umsetzung von US 07. | mittel | 6 |
| 32 | Die Darstellung der Buchstabenfelder soll durch ein Wort in Grossbuchstaben in einem Feld dargestellt werden | Art der Umsetzung von US 05. | hoch | 6 |
| 65 | Spaghetti Code Aufräumen | Kommentare, logische Struktur, Code vereinfachen. | tief | 0 |
| 66 | Maven Test Projekt |  | tief | 0 |
| 67 | Klasse zur Eingabe von neuen Wörtern | Um die Wortdatenbank direkt aus dem Programm erweitern zu können | tief | 0 |
| 69 | UML |  | tief | 8 |

- Die User Storys Nummerierung wurde zur Übersicht von der fortlaufenden Jira-Nummerierung übernommen.


## 7. Releaseplan

|  Release 1 | Release 2  | Ausbaustufe 1 | Ausbaustufe 2 |
|------------|------------|---------------|---------------|
|    US 03   |    US 07   |     US 67     |Datenbank
|    US 04   |    US 08   |
|    US 05   |    US 12   |
|    US 06   |    US 30   |
|    US 09   |    US 31   |
|    US 10   |    US 32   |
|    US 11   |    US 65   |
|    US 20   |    US 66   |
|      -     |    US 69   |



US = User Storys



## 8. Dokumentation Sprint 1

###Task Liste der User Storys

| User Story | Tasks  | Geschätzter Aufwand in Minuten| 
|------------|------------|---------------|
|    US 03   |  Klasse Wort erstellen zum auslesen der Datenbank | 210 |
|    US 04   |  Scanner erstellen, Klein in Grossbuchstaben, Nur erster Buchstabe in Char Einlesen | 120 |
|    US 05   |  Kontrolle Buchstabe korrekt, Eingabe Buchstabe in unbekanntes Wort | 180 |
|    US 06   |  Kontrolle Buchstabe falsch, Eingabe Buchstabe in Vektor "Falsch"  | 150 |
|    US 09   |  .txt file erstellen, zufälliges Auslesen eines Wortes   | 150 |
|    US 10   |  Vergleich zu Wort/Falsch, Kontrolle Gültig/Ungültig, Ausgabe Fehler  | 60 |
|    US 11   |  User Sprache Deutsch   | immer |
|    US 20   |  Erstellen Maven Projekt zur Vorbereitung | 60 |


## 9. Dokumentation Sprint 2


Bild 1
![](https://github.com/fabianschenker/hangman/blob/dev/Diagrams/Controller_readEingabe.png)

Bild 2
![](https://github.com/fabianschenker/hangman/blob/dev/Diagrams/Controller_start.png)

Bild 3
![](https://github.com/fabianschenker/hangman/blob/dev/Diagrams/hangman1.png)



## 10. Fazit



