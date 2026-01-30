# Labirynt z bombami

Projekt przedstawia prostą implementację labiryntu w Javie z wykorzystaniem biblioteki Swing.

Labirynt składa się z kwadratowych pokojów o stałym rozmiarze. Pomiędzy pokojami mogą znajdować się ściany oraz drzwi. W wybranych pokojach umieszczone są bomby. Gracz porusza się po labiryncie za pomocą klawiszy strzałek. Wejście na pole z bombą kończy grę.

## Funkcjonalności
- siatka pokojów o stałym rozmiarze
- ściany jako granice pokojów
- bomby umieszczone w wybranych pokojach
- gracz sterowany klawiszami strzałek
- zakończenie gry po wejściu na bombę

## Sterowanie
- strzałka w górę – ruch w górę
- strzałka w dół – ruch w dół
- strzałka w lewo – ruch w lewo
- strzałka w prawo – ruch w prawo

## Struktura projektu
- `App.java` – główna klasa aplikacji, obsługa okna i logiki gry
- `Room.java` – reprezentacja pokoju labiryntu
- `Wall.java` – ściana pokoju
- `Bomb.java` – bomba umieszczona w pokoju
- `Player.java` – gracz poruszający się po labiryncie
- `MapSite.java` – klasa bazowa elementów labiryntu
- `JMyPanel.java` – panel do rysowania labiryntu

## Wymagania
- Java JDK 17 lub nowsza
- system Windows / Linux / macOS

## Kompilacja
Będąc w katalogu głównym projektu:
```powershell
javac org\example\*.java

## Uruchomienie
gci -r *.class | rm
javac org\example\*.java
java org.example.App