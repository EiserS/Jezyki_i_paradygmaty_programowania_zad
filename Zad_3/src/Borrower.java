public class Borrower {
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final int libraryCardID;

    public Borrower(String firstName, String lastName, String phoneNumber, int libraryCardID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.libraryCardID = libraryCardID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getLibraryCardID() {
        return libraryCardID;
    }

    public void showBorrower() {
        System.out.println(" ");
        System.out.println("ID: " + this.libraryCardID);
        System.out.println("Imię: " + this.firstName);
        System.out.println("Nazwisko: " + this.lastName);
        System.out.println("Telefon: " + this.phoneNumber);
        System.out.println(" ");
    }
}
