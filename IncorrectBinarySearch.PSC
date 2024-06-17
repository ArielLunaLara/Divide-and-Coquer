int IncorrectbinarySearch(int[] arr, int low, int high, int key) {
    if (low > high) {
        return -1; // Elemento no encontrado
    }
    int mid = low;
    if (arr[mid] == key) {
        return mid;
    }
    if (arr[mid] < key) {
        return binarySearch(arr, mid + 1, high, key);
    } else {
        return binarySearch(arr, low, mid - 1, key);
    }
}