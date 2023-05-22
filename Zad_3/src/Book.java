import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private int year;
    private String publisher;
    private final String isbn;
    private String genre;
    private boolean isAvailable;
    private Borrower borrower;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private String InventoryNumber;

    public Book(String title, String author, int year, String publisher, String isbn, String genre, boolean isAvailable , String inventoryNumber) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.isbn = isbn;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.InventoryNumber = inventoryNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void showBook() {
        System.out.println(" ");
        System.out.println("Tytuł: " + this.title);
        System.out.println("Autor: " + this.author);
        System.out.println("Wydawnictwo: " + this.publisher);
        System.out.println("Rok wydania: " + this.year);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Gatunek: " + this.genre);
        System.out.println("Dostępna: " + (this.isAvailable ? "Dostępna " : "Niedostępna"));
        if (!isAvailable) showBorrower();
        System.out.println(" ");
    }

    private void showBorrower() {
        System.out.println("Dane osoby która wypożyczyła:");
        System.out.println("Imię: " + borrower.getFirstName());
        System.out.println("Nazwisko: " + borrower.getLastName());
        System.out.println("Telefon: " + borrower.getPhoneNumber());
        System.out.println("Data wypożyczenia od: " + borrowDate + " do: " + dueDate);
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Object getInventoryNumber() {
        return InventoryNumber;
    }
}
