import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[50];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100); 
        }

        Arrays.sort(array);

        System.out.println("Arreglo ordenado: " + Arrays.toString(array));

    
        int target = array[rand.nextInt(array.length)];
        System.out.println("Elemento a buscar: " + target);

        int result = binarySearch(array, target, 0, array.length - 1);

        System.out.println("Elemento encontrado en el índice: " + result);
    }

    public static int binarySearch(int[] array, int target, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                return binarySearch(array, target, mid + 1, high);
            } else {
                return binarySearch(array, target, low, mid - 1);
            }
        }
        return -1; // Este punto nunca se alcanzará porque asumimos que el elemento siempre está presente
    }
}
