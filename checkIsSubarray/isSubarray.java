package checkIsSubarray;
/**
 * Can be used to check if an array b[] is a subarray of a[]
 * This uses KMP algo whose time complexity is O(n + m) where n & m are lengths of the two arrays
 * should be used in cases where there are duplicate values. refer to example in main
 * if used in another class use like this : isSubarray.isBSubOfA(a, b)
 */


public class isSubarray {
    
    // public static void main(String[] args) {
    //     int[] a = { 2, 2, 2, 2, 2, 2, 3 };
    //     int [] b = { 2,2,2,3 };
    //     if (isBSubOfA(a, b))
    //         System.out.println("YEs");
    // }

    private static int[] buildLPS(int[] pat) {
        int[] lps = new int[pat.length];
        int i = 1, len = 0;
        while (i < pat.length) {
            if (pat[i] == pat[len]) {
                lps[i] = ++len;
                ++i;
            }
            else {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else ++i;
            }
        }
        return lps;
    }

    public static boolean isBSubOfA(int[] a, int[] b) {    
        int n = a.length;
        int m = b.length;
        int[] lps = buildLPS(b);
        int i = 0, j = 0;
        while (i < n) {
            if (a[i] == b[j]) {
                ++i;
                ++j;
                if (j == m)
                    return true;
            }
            else {
                if (j != 0)
                    j = lps[j - 1];
                else ++i;
            }
        }
        return false;
    }
}
