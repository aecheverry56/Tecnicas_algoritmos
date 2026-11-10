import java.util.Random;

public class ContadorInversiones {

    private ContadorInversiones() {
        // Clase de utilidades: no se crean instancias.
    }

    private static long count(int[] a, int[] aux, int left, int mid, int right) {
        long numberOfInversions = 0;

        for (int k = left; k <= right; k++) {
            aux[k] = a[k];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > right) {
                a[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
                numberOfInversions += mid - i + 1;
            }
        }
        return numberOfInversions;
    }

    private static long getNumberOfInversions(int[] a, int[] aux, int left, int right) {
        if (right <= left) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        long numberOfInversions = 0;
        numberOfInversions += getNumberOfInversions(a, aux, left, mid);
        numberOfInversions += getNumberOfInversions(a, aux, mid + 1, right);
        numberOfInversions += count(a, aux, left, mid, right);
        return numberOfInversions;
    }

    public static long getNumberOfInversions(int[] a) {
        int[] aux = new int[a.length];
        return getNumberOfInversions(a, aux, 0, a.length - 1);
    }

    public static long getNumberOfInversionsNaive(int[] a) {
        long numberOfInversions = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    numberOfInversions++;
                }
            }
        }
        return numberOfInversions;
    }

    public static void stressTesting(int numberOfTests) {
        Random random = new Random(42);

        for (int test = 0; test < numberOfTests; test++) {
            int[] a = new int[10];
            for (int i = 0; i < a.length; i++) {
                a[i] = random.nextInt(100);
            }

            long expected = getNumberOfInversionsNaive(a);
            long actual = getNumberOfInversions(a.clone());
            if (expected != actual) {
                throw new IllegalStateException(
                        "Resultado distinto: esperado " + expected + ", obtenido " + actual);
            }
        }
    }
}
