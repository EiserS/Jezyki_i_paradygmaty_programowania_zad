import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Library {
    Scanner scanner = new Scanner(System.in);
    private final ArrayList<Book> bookList = new ArrayList<>();
    private final ArrayList<Borrower> borrowerList = new ArrayList<>();
    private final HashMap<Integer, Book> borrowList = new HashMap<>();

    public void showBooks() {
        for (Book book : bookList) {
            book.showBook();
        }
    }

    public void addBooks() {
        System.out.println("Podaj tytuł książki:");
        String title = scanner.nextLine();
        System.out.println("Podaj autora książki:");
        String autor = scanner.nextLine();
        System.out.println("Podaj rok wydania:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj wydawnictwo książki:");
        String publisher = scanner.nextLine();
        System.out.println("Podaj numer ISBN książki:");
        String isbn = scanner.nextLine();
        System.out.println("Podaj gatunek książki:");
        String genre = scanner.nextLine();
        System.out.println("Podaj numer inwentarzowy:");
        String inventoryNumber = scanner.nextLine();
        if (!title.isBlank() && !autor.isBlank() && !publisher.isBlank() && !isbn.isBlank() && !genre.isBlank() && year != 0 && !inventoryNumber.isBlank()) {
            bookList.add(new Book(title, autor, year, publisher, isbn, genre, true, inventoryNumber));
        }
    }

    public void deleteBook() {
        System.out.println("Podaj numer inwentarzowy:");
        String inventoryNumber = scanner.nextLine();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getInventoryNumber().equals(inventoryNumber)) {
                System.out.println("Znaleziono książkę:");
                bookList.get(i).showBook();
                bookList.remove(i);
                System.out.println("Książka została usunięta z listy.");
                return;
            }
        }
        System.out.println("Nie znaleziono książki o podanym numerze ISBN.");
    }

    public void updateBook() {
        System.out.println("Podaj numer inwentarzowy:");
        String inventoryNumber = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getInventoryNumber().equals(inventoryNumber)) {
                System.out.println("Podaj nowy tytuł książki, jeżeli nie chcesz zmieniać kliknij ENTER:");
                String title = scanner.nextLine();
                if (!title.isBlank()) {
                    book.setTitle(title);
                }
                System.out.println("Podaj nowego autora książki, jeżeli nie chcesz zmieniać kliknij ENTER::");
                String autor = scanner.nextLine();
                if (!autor.isBlank()) {
                    book.setAuthor(autor);
                }
                System.out.println("Podaj nowy rok wydania, jeżeli nie chcesz zmieniać wpisz 0 i kliknij ENTER:");
                int year = Integer.parseInt(scanner.nextLine());
                if (year != 0) {
                    book.setYear(year);
                }
                System.out.println("Podaj nowe wydawnictwo książki, jeżeli nie chcesz zmieniać kliknij ENTER::");
                String publisher = scanner.nextLine();
                if (!publisher.isBlank()) {
                    book.setPublisher(publisher);
                }
                System.out.println("Podaj nowy gatunek książki, jeżeli nie chcesz zmieniać kliknij ENTER::");
                String genre = scanner.nextLine();
                if (!title.isBlank()) {
                    book.setGenre(genre);
                }
                System.out.println("Książka została zaktualizowana :");
                book.showBook();
                return;
            }
        }
        System.out.println("Nie znaleziono książki o podanym numerze ISBN.");

    }

    public void showBookByTitle() {
        System.out.println("Podaj Tytuł");
        String title = scanner.next();
        if (!title.isBlank()) {
            for (Book book : bookList) {
                if (book.getTitle().equals(title)) {
                    book.showBook();
                }
            }
            return;
        }
        System.out.println("Nie podano tytułu");
    }

    public void showBookByAutor() {
        System.out.println("Podaj Tytuł");
        String autor = scanner.next();
        if (!autor.isBlank()) {
            for (Book book : bookList) {
                if (book.getAuthor().equals(autor)) {
                    book.showBook();
                }
            }
            return;
        }
        System.out.println("Nie podano tytułu");
    }

    public void showBookByGenre() {
        System.out.println("Podaj Tytuł");
        String genre = scanner.next();
        if (!genre.isBlank()) {
            for (Book book : bookList) {
                if (book.getGenre().equals(genre)) {
                    book.showBook();
                }
            }
            return;
        }
        System.out.println("Nie podano tytułu");
    }

    public void addExample() {
        Book book1 = new Book("Pan Tadeusz", "Adam Mickiewicz", 1834, "Czytelnik", "9788373271891", "epopeja", true, "1");
        Book book2 = new Book("Lalka", "Bolesław Prus", 1890, "Biblioteka Polska", "9788373270184", "powieść", true, "2");
        Book book3 = new Book("Zbrodnia i kara", "Fiodor Dostojewski", 1866, "Wydawnictwo Literackie", "9788308036834", "powieść psychologiczna", true, "3");
        Book book4 = new Book("Ferdydurke", "Witold Gombrowicz", 1937, "Wydawnictwo Literackie", "9788308040589", "powieść groteskowa", true, "4");
        Borrower borrower1 = new Borrower("Jan", "Kowalski", "123-456-789", 12345);
        Borrower borrower2 = new Borrower("Anna", "Nowak", "987-654-321", 67890);
        Borrower borrower3 = new Borrower("Piotr", "Nowacki", "555-555-555", 24680);
        Borrower borrower4 = new Borrower("Katarzyna", "Wójcik", "111-222-333", 13579);
        Borrower borrower5 = new Borrower("Tomasz", "Mazur", "444-444-444", 86420);
        borrowerList.add(borrower1);
        borrowerList.add(borrower2);
        borrowerList.add(borrower3);
        borrowerList.add(borrower4);
        borrowerList.add(borrower5);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
    }

    public void borrowBook() {
        System.out.println("Podaj numer inwentarzowy książki którą chcesz wypożyczyć: ");
        String inventoryNumber = scanner.nextLine();
        System.out.println("Podaj numer karty bibliotecznej czytelnika który chce wypożyczyć książkę");
        int borrowerCard = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj na ile dni chcesz wypożyczyć książkę");
        int days = Integer.parseInt(scanner.nextLine());
        for (Book book : bookList
        ) {
            if (book.getInventoryNumber().equals(inventoryNumber)) {
                if (!book.isAvailable()) {
                    continue;
                }
                for (Borrower borrower : borrowerList
                ) {
                    if (borrower.getLibraryCardID() == borrowerCard) {

                        book.setBorrower(borrower);
                        book.setBorrowDate(LocalDate.now());
                        book.setDueDate(book.getBorrowDate().plusDays(days));

                        borrowList.put(borrower.getLibraryCardID(), book);

                        System.out.println("Książka \"" + book.getTitle() + "\" została wypożyczona przez " + borrower.getFirstName() + " " + borrower.getLastName() + ".");
                        System.out.println("Data wypożyczenia: " + book.getBorrowDate());
                        System.out.println("Do dnia: " + book.getDueDate());
                        book.setAvailable(false);
                    }
                }
            }
        }
    }

    public void returnBook() {
        System.out.println("Podaj numer Inwentarzowy książki którą chcesz zwrócić: ");
        String inventoryNumber = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getInventoryNumber().equals(inventoryNumber) && !book.isAvailable()) {
                if (book.getBorrower() == null) {
                    System.out.println("Ta książka nie została wypożyczona.");
                    return;
                }
                Borrower borrower = book.getBorrower();
                book.setBorrower(null);
                book.setBorrowDate(null);
                book.setDueDate(null);
                book.setAvailable(true);

                System.out.println("Książka \"" + book.getTitle() + "\" została zwrócona przez " + borrower.getFirstName() + " " + borrower.getLastName() + ".");
                return;
            }
        }
        System.out.println("Nie znaleziono książki o podanym numerze ISBN.");
    }

    public void showBorrowers() {
        for (Borrower borrower : borrowerList
        ) {
            borrower.showBorrower();
        }
    }

    public void showBorrowerBooks() {
        System.out.println("Podaj numer karty bibliotecznej czytelnika");
        int borrowerCard = Integer.parseInt(scanner.nextLine());
        for (Borrower borrower : borrowerList) {
                if (borrower.getLibraryCardID() == borrowerCard) {
                        borrowList.get(borrowerCard).showBook();
                }
        }
        System.out.println("Nie znaleziono czytelnika o podanym numerze karty bibliotecznej.");
    }
    public void showBorrowedBooks() {
        for (Book book : bookList
        ) {
            if (!book.isAvailable()) {
                book.showBook();
            }
        }
    }
}
