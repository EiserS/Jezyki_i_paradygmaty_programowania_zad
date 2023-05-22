import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Najdłuższa sekwencja dla cyfry: "+ collatzSequence());
    }

    public static int collatzSequence() {
        // Inicjalizacja zmiennych
        HashMap<Long, Long> memo = new HashMap<>(); // Pamięć sekwencji już obliczonych
        long max = 0;   // Maksymalna liczba kroków
        long index = 0; // Liczba dla której liczba kroków jest maksymalna

        // Przeglądaj liczby od 1 do 1000000
        for (long j = 1; j <= 1000000; j++) {
            long count = 1; // Inicjalizacja liczby kroków
            long i = j;     // Zapisz liczbę do obliczenia sekwencji Collatza

            // Oblicz sekwencję Collatza
            while (i > 1) {
                // Jeśli sekwencja nie została jeszcze obliczona, oblicz ją
                if (!memo.containsKey(i)) {
                    i = (i % 2 == 0) ? i / 2 : 3 * i + 1;
                    count++;
                } else {
                    // W przeciwnym razie zaktualizuj liczbę kroków sekwencji już obliczonej
                    count += memo.get(i) - 1;
                    break;
                }
            }

            // Zapisz wynik do pamięci
            memo.put(j, count);

            // Zaktualizuj maksymalną liczbę kroków i liczbę dla której jest ona osiągana
            if (max < count) {
                max = count;
                index = j;
            }
        }

        // Zwróć liczbę dla której liczba kroków jest maksymalna
        return (int) index;
    }
}