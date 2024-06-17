import java.util.Arrays;
import java.util.Random;

public class IterativeMergeSort {
    public static void main(String[] args) {
        // Crear un arreglo de 50 elementos aleatorios
        int[] array = new int[50];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100); // Números aleatorios entre 0 y 99
        }

        // Imprimir el arreglo original
        System.out.println("Arreglo original: " + Arrays.toString(array));

        // Ordenar el arreglo usando Merge Sort iterativo
        mergeSort(array);

        // Imprimir el arreglo ordenado
        System.out.println("Arreglo ordenado: " + Arrays.toString(array));
    }

    // Algoritmo de Merge Sort iterativo
    public static void mergeSort(int[] array) {
        int n = array.length;
        int[] temp = new int[n];

        for (int size = 1; size < n; size *= 2) {
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * size) {
                int mid = Math.min(leftStart + size - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * size - 1, n - 1);
                merge(array, temp, leftStart, mid, rightEnd);
            }
        }
    }

    // Función auxiliar para fusionar dos subarreglos
    public static void merge(int[] array, int[] temp, int leftStart, int mid, int rightEnd) {
        int leftEnd = mid;
        int rightStart = mid + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }
}
