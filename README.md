# Dokumentacja wymagań dla aplikacji korepetytorskiej

## 1. Wprowadzenie

### 1.1 Cel projektu
Stworzenie aplikacji webowej umożliwiającej korepetytom efektywne zarządzanie zajęciami, uczniami i materiałami dydaktycznymi, a uczniom rezerwację terminów zajęć, wykonywanie zadań i testów oraz monitorowanie własnych postępów.

### 1.2 Grupy użytkowników
- **Korepetytorzy** (nauczyciele) - prowadzący zajęcia, zarządzający kalendarzem i materiałami
- **Uczniowie** - osoby korzystające z korepetycji, rezerwujące terminy i wykonujące zadania
- **Administratorzy systemu** - zarządzający całą platformą

## 2. Architektura systemu

### 2.1 Komponenty techniczne
- **Backend**: Spring Boot (Java)
- **Frontend**: Wybór technologii (np. React, Angular, Vue.js)
- **Baza danych**: Relacyjna (np. PostgreSQL, MySQL)
- **API**: RESTful
- **Autentykacja**: JWT (JSON Web Tokens)
- **Opcjonalnie**: Integracja z zewnętrznymi API (Google Calendar, systemy płatności)

### 2.2 Schemat architektury
```
+----------------+      +----------------+      +----------------+
|                |      |                |      |                |
|    Frontend    |<---->|    Backend     |<---->|  Baza danych   |
|                |      |  (Spring Boot) |      |                |
+----------------+      +----------------+      +----------------+
                               ^
                               |
                        +----------------+
                        |   Zewnętrzne   |
                        |      API       |
                        +----------------+
```

## 3. Szczegółowe wymagania funkcjonalne

### 3.1 System autentykacji i zarządzania użytkownikami

#### 3.1.1 Rejestracja i logowanie
- Rejestracja nauczycieli i uczniów poprzez formularz zawierający:
  - Imię i nazwisko
  - Adres e-mail (unikalny w systemie)
  - Hasło (z wymaganiami bezpieczeństwa)
  - Rola w systemie (nauczyciel/uczeń)
  - Akceptacja regulaminu i polityki prywatności
- Logowanie za pomocą e-maila i hasła
- Odzyskiwanie hasła poprzez link weryfikacyjny wysyłany na e-mail
- Automatyczne wylogowanie po określonym czasie nieaktywności

#### 3.1.2 Zarządzanie profilem
- Edycja danych profilu:
  - Dane osobowe
  - Zdjęcie profilowe
  - Krótki opis/bio (dla nauczycieli)
  - Przedmioty nauczania (dla nauczycieli)
  - Informacje kontaktowe
- Zmiana hasła
- Ustawienia powiadomień
- Usunięcie konta (z potwierdzeniem)

#### 3.1.3 Zarządzanie relacjami nauczyciel-uczeń
- Nauczyciel może zapraszać uczniów do swojej grupy poprzez:
  - Link zaproszeniowy
  - Kod zaproszeniowy
  - Zaproszenie na adres e-mail
- Uczeń może dołączyć do grupy nauczyciela poprzez:
  - Akceptację zaproszenia
  - Wpisanie kodu zaproszeniowego
  - Wyszukanie nauczyciela i wysłanie prośby o dołączenie
- Uczeń może być przypisany do wielu nauczycieli
- Nauczyciel może usunąć ucznia ze swojej grupy
- Uczeń może opuścić grupę nauczyciela

### 3.2 Kalendarz i zarządzanie zajęciami

#### 3.2.1 Kalendarz nauczyciela
- Widok kalendarza z różnymi perspektywami (dzień, tydzień, miesiąc)
- Definiowanie stałych godzin dostępności
- Dodawanie jednorazowych terminów zajęć
- Blokowanie terminów (niedostępnych dla rezerwacji)
- Definiowanie długości standardowej lekcji (np. 45, 60, 90 minut)
- Ustawianie maksymalnej liczby uczniów na zajęciach (zajęcia indywidualne/grupowe)
- Oznaczanie zajęć różnymi kolorami (np. według przedmiotu)
- Powtarzające się terminy zajęć (cykliczne)

#### 3.2.2 Rezerwacja zajęć przez uczniów
- Przeglądanie dostępnych terminów nauczyciela
- Filtrowanie terminów według parametrów (data, czas trwania, przedmiot)
- Rezerwacja wybranego terminu
- Anulowanie rezerwacji (z możliwością ustawienia przez nauczyciela limitu czasowego na anulowanie)
- Widok własnego kalendarza zajęć (wszystkie zarezerwowane terminy)
- Historia odbytych zajęć

#### 3.2.3 Zarządzanie zajęciami
- Potwierdzanie obecności ucznia na zajęciach
- Dodawanie notatek do zajęć (widocznych lub nie dla ucznia)
- Przypisywanie materiałów do zajęć
- Przesuwanie/anulowanie zajęć z powiadomieniem ucznia
- Statystyki zajęć (obecności, tematy, etc.)

### 3.3 System materiałów dydaktycznych

#### 3.3.1 Syllabussy i plany zajęć
- Tworzenie syllabusu kursu/przedmiotu zawierającego:
  - Cele kursu
  - Tematy zajęć
  - Materiały i zasoby
  - Harmonogram
- Przypisywanie syllabusów do uczniów/grup
- Śledzenie postępu realizacji syllabusu
- Edycja i aktualizacja syllabusów

#### 3.3.2 Materiały dydaktyczne
- Dodawanie materiałów różnych typów:
  - Pliki (PDF, DOC, PPT, etc.)
  - Linki do zasobów zewnętrznych
  - Notatki tekstowe
  - Grafiki i ilustracje
- Organizowanie materiałów w foldery i kategorie
- Udostępnianie materiałów uczniom
- Ustawianie widoczności materiałów (dla konkretnych uczniów/grup)

### 3.4 System testów i zadań

#### 3.4.1 Tworzenie testów i quizów
- Kreator testów z różnymi typami pytań:
  - Jednokrotnego wyboru
  - Wielokrotnego wyboru
  - Prawda/fałsz
  - Krótka odpowiedź tekstowa
  - Dłuższa wypowiedź
  - Dopasowanie elementów
- Ustawianie czasu na rozwiązanie testu
- Definiowanie punktacji za pytania
- Możliwość dodawania multimediów do pytań (obrazki, dźwięki)
- Losowa kolejność pytań
- Tworzenie banku pytań do wielokrotnego wykorzystania

#### 3.4.2 Przypisywanie i rozwiązywanie testów
- Przypisywanie testów do uczniów/grup
- Ustawianie terminu rozpoczęcia i zakończenia dostępności testu
- Rozwiązywanie testów online przez uczniów
- Zapisywanie stanu testu w trakcie rozwiązywania
- Automatyczne sprawdzanie testów (z wyjątkiem pytań otwartych)
- Ręczne sprawdzanie i ocenianie pytań otwartych przez nauczyciela

#### 3.4.3 Zadania domowe
- Tworzenie zadań domowych:
  - Opis zadania
  - Termin wykonania
  - Załączniki i materiały pomocnicze
  - Forma oddania (przesłanie pliku, odpowiedź tekstowa, etc.)
- Przypisywanie zadań uczniom
- Przesyłanie rozwiązań przez uczniów
- Ocenianie i komentowanie zadań przez nauczyciela
- Śledzenie statusu zadań (przypisane, w trakcie, oddane, ocenione)

### 3.5 System komunikacji

#### 3.5.1 Wiadomości wewnętrzne
- Wysyłanie wiadomości tekstowych pomiędzy nauczycielem a uczniem
- Historia konwersacji
- Powiadomienia o nowych wiadomościach
- Dodawanie załączników do wiadomości

#### 3.5.2 Powiadomienia
- Powiadomienia w aplikacji (dzwonek)
- Powiadomienia e-mail (opcjonalne) o:
  - Nadchodzących zajęciach
  - Zmianach w terminie zajęć
  - Nowych przypisanych zadaniach/testach
  - Ocenach i komentarzach
  - Nowych wiadomościach
- Powiadomienia SMS (opcjonalne, jako funkcja premium)
- Konfigurowanie preferencji powiadomień przez użytkowników

### 3.6 Statystyki i raporty

#### 3.6.1 Statystyki dla nauczyciela
- Frekwencja uczniów
- Postępy w realizacji syllabusów
- Wyniki testów i zadań
- Aktywność uczniów
- Raporty finansowe (w przypadku implementacji płatności)

#### 3.6.2 Statystyki dla ucznia
- Historia zajęć
- Postępy w nauce
- Wyniki testów i zadań
- Porównanie z poprzednimi okresami

## 4. Wymagania ponadpodstawowe (Should Have / Could Have)

### 4.1 Integracja z Google Calendar
- Synchronizacja zajęć z kalendarzem Google
- Automatyczne dodawanie zarezerwowanych terminów do kalendarza Google
- Importowanie zdarzeń z Google Calendar jako blokady terminów

### 4.2 System płatności
- Definiowanie cennika przez nauczyciela
- Różne modele płatności:
  - Za pojedyncze zajęcia
  - Pakiety zajęć (np. 10 lekcji)
  - Abonamenty miesięczne
- Integracja z systemami płatności online (np. Stripe, PayPal)
- Generowanie faktur/rachunków
- Raporty finansowe dla nauczyciela
- Historia płatności dla ucznia

### 4.3 Wideokonferencje
- Wbudowany system wideokonferencji
- Udostępnianie ekranu
- Tablica wirtualna
- Czat tekstowy podczas konferencji
- Nagrywanie sesji (opcjonalnie za zgodą uczestników)

### 4.4 System ocen i opinii
- Wystawianie ocen za testy, zadania i aktywność
- Skala ocen konfigurowalna przez nauczyciela
- Średnie ocen i trendy
- System wystawiania opinii i rekomendacji

## 5. Wymagania niefunkcjonalne

### 5.1 Bezpieczeństwo
- Szyfrowanie danych użytkowników
- Bezpieczne przechowywanie haseł (hashowanie)
- Ochrona przed atakami (CSRF, XSS, SQL Injection)
- Możliwość włączenia dwuskładnikowego uwierzytelniania (2FA)
- Regularne kopie zapasowe danych

### 5.2 Wydajność
- Szybki czas ładowania stron (<2 sekundy)
- Optymalizacja dla dużej liczby użytkowników
- Efektywne zarządzanie zasobami serwera
- Optymalizacja bazy danych (indeksy, zapytania)

### 5.3 Dostępność i kompatybilność
- Responsywny design (dostosowanie do różnych urządzeń)
- Kompatybilność z popularnymi przeglądarkami (Chrome, Firefox, Safari, Edge)
- Dostępność dla osób z niepełnosprawnościami (zgodność z WCAG 2.1)
- Wsparcie dla różnych języków (minimum polski i angielski)

### 5.4 Skalowalność
- Możliwość obsługi rosnącej liczby użytkowników
- Architektura umożliwiająca łatwe skalowanie poziome
- Modułowa struktura kodu ułatwiająca rozbudowę

## 6. Ograniczenia i założenia
- Aplikacja będzie dostępna przez przeglądarkę internetową
- Główny backend oparty na Spring Boot
- Dane przechowywane w relacyjnej bazie danych
- Zgodność z przepisami RODO dotyczącymi ochrony danych osobowych
- Aplikacja nie będzie zastępować systemów dedykowanych dla szkół (np. dzienników elektronicznych)

## 7. Definicje MVP (Minimum Viable Product)
Pierwsza wersja produktu powinna zawierać następujące funkcjonalności:

1. System rejestracji i logowania użytkowników
2. Podstawowy profil nauczyciela i ucznia
3. Kalendarz nauczyciela z możliwością dodawania dostępnych terminów
4. Rezerwacja terminów przez uczniów
5. Tworzenie prostych testów i quizów
6. Prosty system wiadomości wewnętrznych
7. Podstawowe statystyki dla nauczyciela

## 8. Kryteria akceptacji i miary sukcesu
- Wszystkie funkcjonalności "Must Have" działają zgodnie z wymaganiami
- Aplikacja jest stabilna i nie zawiera krytycznych błędów
- Czas ładowania stron nie przekracza 3 sekund
- Aplikacja działa poprawnie na urządzeniach mobilnych i desktopowych
- Proces rejestracji i rezerwacji zajęć nie przekracza 5 kroków
- 90% testowych użytkowników jest w stanie wykonać podstawowe zadania bez pomocy
