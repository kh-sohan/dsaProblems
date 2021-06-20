package QuickSelect;

public class QuickSelect {
    public static int kthSmallest(int arr[], int n, int k)
    {
        int begin = 0, end = n - 1, ans = -1;
        while (begin <= end) {
            int pivot = lomuto(arr, begin , end);
            if (pivot == k - 1) {
                ans = arr[pivot];
                break;
            }
            if (pivot < k)
                begin = pivot + 1;
            else end = pivot - 1;
        }
        return ans;
    }
    
    private static int lomuto (int[] arr, int begin, int end ) {
        int pivot = (int) (Math.floor(Math.random() * (end - begin + 1) + begin));  // swapping a random element of the array with the last element
        swap(arr, pivot, end);
        pivot = arr[end];       // and making it a pivot. Why do this randomised thing? Here you go : https://web.stanford.edu/class/archive/cs/cs161/cs161.1138/lectures/09/Small09.pdf
        int smallerThanPivot = begin - 1;
        for (int ind = begin; ind < end; ind++) {
            if (arr[ind] < pivot) {
                swap(arr, ind, ++smallerThanPivot);
            }
        }
        swap(arr, end, ++smallerThanPivot);
        return smallerThanPivot;
    }
    
    private static void swap(int[] arr, int ind1, int ind2) {
        arr[ind1] = arr[ind1] ^ arr[ind2] ^ (arr[ind2] = arr[ind1]);
    }
}
