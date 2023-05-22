abstract class Person {
    String name;
    String surname;
    String email;
    String phone;
    String login;
    String password;
    String position;

    protected Person(String name, String surname, String email, String phone, String login, String password, String position) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.position = position;
    }
    public void showInfo() {
        System.out.println("Name: " + name + "\nSurname: " + surname + "\nEmail: " + email + "\nPhone: " + phone + "\nLogin: " + login + "\nPassword: " + password + "\nPosition: " + position);
    }
}

class Client extends Person {
    int balance = 0;
    public Client(String name, String surname, String email, String phone, String login, String password, String position) {
        super(name, surname, email, phone, login, password, position);
    }
    public void changeLogin(String email, String login) {
        if(email.contains("@") && email.contains(".") && !email.contains(" ") && this.email.equals(email)) {
            this.login = login;
        } else {
            System.out.println("Wrong email!");
        }
    }
    public void changePassword(String login, String password) {
        if(password.length() >= 8 && password.length() <= 20 && !password.contains(" ") && this.login.equals(login)) {
            this.password = password;
        } else {
            System.out.println("Wrong login!");
        }
    }
    public void showBalance() {
        System.out.println("Balance: " + balance);
    }
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Balance: " + balance);
    }
}
class Employee extends Client{
    int salary;
    public Employee(String name, String surname, String email, String phone, String login, String password, String position) {
        super(name, surname, email, phone, login, password, position);
        this.position = "Employer";
        this.salary = 3000;
    }
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Salary: " + salary);
    }
    public void changeClientAccountBalance (Client client, int amount) {
        if (client.balance + amount >= 0)
            client.balance = amount;
        else{
            client.balance = 0;
        }
    }
}
final class Menager extends Employee {
    public Menager(String name, String surname, String email, String phone, String login, String password, String position) {
        super(name, surname, email, phone, login, password, position);
        this.position = "Menager";
        this.salary = 10000;
    }
    void changeEmployerSalary(Employee employer, int salary) {
        employer.salary = salary;
    }
}


