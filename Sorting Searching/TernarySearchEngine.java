public class TernarySearchEngine {

    public int ternarySearch(int[] arr, int key) {
        int l = 0, r = arr.length - 1;
        while (r >= l) {
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;
            if (arr[mid1] == key) return mid1;
            if (arr[mid2] == key) return mid2;
            if (key < arr[mid1]) r = mid1 - 1;
            else if (key > arr[mid2]) l = mid2 + 1;
            else {
                l = mid1 + 1;
                r = mid2 - 1;
            }
        }
        return -1;
    }
}
