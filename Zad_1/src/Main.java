// import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę numerycznie");
        int pobranaLiczba = scanner.nextInt();
        scanner.close();
        System.out.println("Podana liczba to: " + pobranaLiczba);
        System.out.println("Słownie: " + Numery.konwertujNaTekst(pobranaLiczba));
        */
        int ileLiter = 0;
        for (int i = 1; i <= 1000; i++) {
            ileLiter += Numery.konwertujNaTekst(i).replace(" ","").length();
        }
        System.out.println("Liczby od 1 do 1000 wypisane słownie zawierają :" + ileLiter);
    }
}
class Numery {
    private static String jedenDziewiec(int liczba) {
        return switch (liczba) {
            case 1 -> "jeden";
            case 2 -> "dwa";
            case 3 -> "trzy";
            case 4 -> "cztery";
            case 5 -> "pięć";
            case 6 -> "sześć";
            case 7 -> "siedem";
            case 8 -> "osiem";
            case 9 -> "dziewięć";
            default -> null;
        };
    }

    private static String dziesiecDziewietnascie(int n) {
        return switch (n) {
            case 10 -> "dziesięć";
            case 11 -> "jedenaście";
            case 12 -> "dwanaście";
            case 13 -> "trzynaście";
            case 14 -> "czternaście";
            case 15 -> "piętnaście";
            case 16 -> "szesnaście";
            case 17 -> "siedemnaście";
            case 18 -> "osiemnaście";
            case 19 -> "dziewiętnaście";
            default -> null;
        };
    }

    private static String dziesiecDziewiecdziesiat(int n) {
        return switch (n) {
            case 1 -> "dziesięć";
            case 2 -> "dwadzieścia";
            case 3 -> "trzydzieści";
            case 4 -> "czterdzieści";
            case 5 -> "pięćdziesiąt";
            case 6 -> "sześćdziesiąt";
            case 7 -> "siedemdziesiąt";
            case 8 -> "osiemdziesiąt";
            case 9 -> "dziewięćdziesiąt";
            default -> null;
        };
    }

    private static String stoDziewiecset(int n) {
        return switch (n) {
            case 1 -> "sto";
            case 2 -> "dwieście";
            case 3 -> "trzysta";
            case 4 -> "czterysta";
            case 5 -> "pięćset";
            case 6 -> "sześćset";
            case 7 -> "siedemset";
            case 8 -> "osiemset";
            case 9 -> "dziewięćset";
            default -> null;
        };
    }

    private static String tysiac(int n) {
        if (n < 1) {
            return null;
        } else if (n == 1) {
            return "tysiąc";
        } else if (n <= 4) {
            return jedenDziewiec(n) + " tysiące";
        } else if (n <= 9) {
            return jedenDziewiec(n) + " tysięcy";
        } else {
            return null;
        }
    }

    public static String konwertujNaTekst(int liczba) {
        if (liczba < 1 || liczba > 9999) {
            return null;
        } else if (liczba < 10) {
            return jedenDziewiec(liczba);
        } else if (liczba < 20) {
            return dziesiecDziewietnascie(liczba);
        } else if (liczba < 100) {
            int dziesiatki = liczba / 10;
            int jednosci = liczba % 10;
            if (jednosci == 0) {
                return dziesiecDziewiecdziesiat(dziesiatki);
            } else {
                return dziesiecDziewiecdziesiat(dziesiatki) + " " + jedenDziewiec(jednosci);
            }
        } else if (liczba < 1000) {
            int setki = liczba / 100;
            int reszta = liczba % 100;
            if (reszta==0) {
                return stoDziewiecset(setki);
            } else {
                return stoDziewiecset(setki) +" "+ konwertujNaTekst(reszta);
            }
        } else {
            int tys = liczba / 1000;
            int reszta = liczba % 1000;
            if (reszta == 0) {
                return tysiac(tys);
            } else if (reszta < 10) {
                return tysiac(tys) + " " + jedenDziewiec(reszta);
            } else if (reszta < 20) {
                return tysiac(tys) + " " + dziesiecDziewietnascie(reszta);
            } else {
                return tysiac(tys) + " " + konwertujNaTekst(reszta);
            }
        }
    }
}