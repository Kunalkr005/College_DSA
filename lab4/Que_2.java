import java.util.Arrays;
public class Que_2 {


    
    static int binarySearch(int arr[], int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key)
                return mid + 1;

            else if (arr[mid] < key)
                low = mid + 1;

            else
                high = mid - 1;
        }
        return low;
    }

    
    static void binaryInsertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];

            
            int pos = binarySearch(arr, key, 0, i - 1);

            
            int j = i - 1;
            while (j >= pos) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[pos] = key;
        }
    }

    public static void main(String[] args) {
        int arr[] = {37, 23, 0, 17, 12, 72, 31};

        System.out.println("Original Array: " + Arrays.toString(arr));

        binaryInsertionSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
