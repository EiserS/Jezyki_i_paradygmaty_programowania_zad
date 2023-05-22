public class Main {
    public static void main(String[] args) {

         Client client1 = new Client("John", "Smith", "john.smith@email.com",
                "+123456789", "johnsmith", "password", "Client");
        Client client2 = new Client("David", "Brown", "dawid.brown@email.com",
                "+987654321", "dawidbrown", "password", "Client");
        Employee employer1 = new Employee("Jack", "White", "jack.white@gmail.com", "+123456789",
                "jackwhite", "password", "Employer");
        Employee employer2 = new Employee("Michael", "Black", "michael.black@gmail.com", "+987654321",
                "michaelblack", "password", "Employer");
        Menager menager = new Menager("Tom", "Green", "tom.green@gmail.com", "+123456789",
                "tomgreen", "password", "Menager");

        client1.showInfo();
        System.out.println("--------------------");
        client2.showInfo();
        System.out.println("--------------------");
        employer1.showInfo();
        System.out.println("--------------------");
        employer2.showInfo();
        System.out.println("--------------------");
        menager.showInfo();
        System.out.println("--------------------");
        System.out.println("Zmiana stanu konta klienta 1: ");
        employer2.changeClientAccountBalance(client1, 3000);
        client1.showBalance();
        System.out.println("--------------------");
        System.out.println("Zmiana stanu konta klienta 2: ");
        employer2.changeClientAccountBalance(client2, 4000);
        client2.showBalance();
        System.out.println("--------------------");
        System.out.println("Zmiana wypłaty pracownika 1: ");
        menager.changeEmployerSalary(employer1, 5000);
        employer1.showInfo();
        System.out.println("--------------------");
        System.out.println("Zmiana loginu klienta 1 (Niepoprawny email): ");
        client1.changeLogin("sdsad", "johnsmith");
        System.out.println("--------------------");
        System.out.println("Zmiana loginu klienta 1 (poprawny email): ");
        client1.changeLogin("john.smith@email.com",
                "johnsmith2");
        client1.showInfo();
        System.out.println("--------------------");
        System.out.println("Zmiana hasła klienta 2 (poprawny login): ");
        client1.changePassword("johnsmith2", "password2");
        client1.showInfo();
        System.out.println("--------------------");
        System.out.println("Sprawdzenie czy klient jest obiektem klasy person");
        System.out.println(client1 instanceof Person);
        System.out.println("--------------------");
        System.out.println("Sprawdzenie czy pracownik jest obiektem klasy person");
        System.out.println(employer1 instanceof Person);
        System.out.println("--------------------");
        System.out.println("Sprawdzenie czy pracownik jest obiektem klasy menager");
        System.out.println(employer1 instanceof Menager);
        System.out.println("--------------------");
        System.out.println("Sprawdzenie czy menager jest obiektem klasy person");
        System.out.println(menager instanceof Person);
        System.out.println("--------------------");
        System.out.println("Sprawdzenie czy klient jest obiektem klasy client");
        System.out.println(client1 instanceof Client);
        System.out.println("--------------------");
        System.out.println("Sprawdzenie czy pracownik jest obiektem klasy client");
        System.out.println(employer1 instanceof Client);
        System.out.println("--------------------");
        System.out.println("Sprawdzenie czy client jest obiektem klasy menager");
        System.out.println(client1 instanceof Menager);
        System.out.println("--------------------");
    }
}