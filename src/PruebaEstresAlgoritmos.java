import java.util.Random;

public class PruebaEstresAlgoritmos {
    private static final int TAMANO_ARREGLO_INVERSIONES = 200_000;
    private static final int MONTO_DINAMICO = 300_000;
    private static final int CANTIDAD_MONTOS_VORAZ = 250_000;
    private static final int MONTO_MAXIMO_VORAZ = 1_000;

    /* Evita que el resultado de las pruebas sea descartado por la JVM. */
    private static volatile long resultadoPrueba;

    private PruebaEstresAlgoritmos() {
        // Clase de utilidades: no se crean instancias.
    }

    public static void ejecutar() {
        System.out.println();
        System.out.println("=== Prueba de estres: tiempo y memoria ===");
        System.out.println("La memoria mostrada es una estimacion del heap usado.");

        medir("Divide y venceras - " + TAMANO_ARREGLO_INVERSIONES + " enteros", () -> {
            int[] datos = generarDatosMock(TAMANO_ARREGLO_INVERSIONES, 1_000_000);
            resultadoPrueba = ContadorInversiones.getNumberOfInversions(datos);
        });

        medir("Programacion dinamica - monto " + MONTO_DINAMICO, () ->
                resultadoPrueba = CambioMonedas.getChange(MONTO_DINAMICO));

        medir("Voraz - " + CANTIDAD_MONTOS_VORAZ + " montos mock", () -> {
            int[] montos = generarDatosMock(CANTIDAD_MONTOS_VORAZ, MONTO_MAXIMO_VORAZ);
            long totalMonedas = 0;

            for (int monto : montos) {
                totalMonedas += CambioMonedasVoraz.getChangeGreedy(monto);
            }
            resultadoPrueba = totalMonedas;
        });
    }

    private static void medir(String nombre, Runnable algoritmo) {
        liberarMemoriaAntesDeMedir();
        long memoriaAntes = memoriaUsada();
        long inicio = System.nanoTime();

        algoritmo.run();

        long tiempoNanosegundos = System.nanoTime() - inicio;
        long memoriaDespues = memoriaUsada();
        long memoriaConsumida = Math.max(0, memoriaDespues - memoriaAntes);

        System.out.printf("%s%n", nombre);
        System.out.printf("  Tiempo: %.3f ms%n", tiempoNanosegundos / 1_000_000.0);
        System.out.printf("  Memoria aproximada: %.2f MB%n", memoriaConsumida / 1_048_576.0);
    }

    private static int[] generarDatosMock(int cantidad, int valorMaximo) {
        Random random = new Random(12_345L);
        int[] datos = new int[cantidad];

        for (int i = 0; i < datos.length; i++) {
            datos[i] = random.nextInt(valorMaximo) + 1;
        }
        return datos;
    }

    private static long memoriaUsada() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static void liberarMemoriaAntesDeMedir() {
        System.gc();
    }
}
