import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();

    public void mainMenu() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Witamy w naszej księgarni wybierz opcję");
            System.out.println("1 Książki");
            System.out.println("2 Czytelnicy ");
            System.out.println("3 Dodaj wartości testowe ");
            System.out.println("9 Wyjdź");
            int userChose = scanner.nextInt();
            switch (userChose) {
                case 1 -> bookMenu();
                case 2 -> guestMenu();
                case 3 -> library.addExample();
                case 9 -> shouldContinue = false;
                default -> System.out.println("Nieznana opcja");
            }

        }
    }

    private void guestMenu() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Menu Czytelników:");
            System.out.println("1 Wypożycz książkę");
            System.out.println("2 Zwróć książkę");
            System.out.println("3 Wyświetl listę czytelników");
            System.out.println("4 Wyświetl wypożyczone książki czytelnika");
            System.out.println("9 Powrót");

            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1 -> library.borrowBook();
                case 2 -> library.returnBook();
                case 3 -> library.showBorrowers();
                case 4 -> library.showBorrowerBooks();
                case 9 -> shouldContinue = false;
                default -> System.out.println("Nieznana opcja");

            }
        }
    }

    public void bookMenu() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Menu książek:");
            System.out.println("1 Wyświetl listę książek");
            System.out.println("2 Dodaj książkę");
            System.out.println("3 Usuń książkę");
            System.out.println("4 Aktualizuj książkę");
            System.out.println("5 Przejdź do menu wyszukiwania książek");
            System.out.println("9 Powrót");

            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1 -> library.showBooks();
                case 2 -> library.addBooks();
                case 3 -> library.deleteBook();
                case 4 -> library.updateBook();
                case 5 -> bookSearchMenu();
                case 9 -> shouldContinue = false;
                default -> System.out.println("Nieznana opcja");

            }
        }
    }

    public void bookSearchMenu() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Menu wyszukiwania książek:");
            System.out.println("1 Wyszukaj książkę po tytule");
            System.out.println("2 Wyszukaj książkę po autorze");
            System.out.println("3 Wyszukaj książkę po gatunku");
            System.out.println("4 Wyszukaj wypożyczone książki");
            System.out.println("9 Powrót");

            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1 -> library.showBookByTitle();
                case 2 -> library.showBookByAutor();
                case 3 -> library.showBookByGenre();
                case 4 -> library.showBorrowedBooks();
                case 9 -> shouldContinue = false;
                default -> System.out.println("Nieznana opcja");

            }
        }
    }
}
