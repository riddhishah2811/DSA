//'main' method must be in a class 'Rextester'.
//openjdk version '11.0.5' 
// Coding Mohan -> YT Channel Understanding

import java.util.*;
import java.lang.*;

class Rextester
{
    static long CountOfSmallerOrEqualSumSubarray(Vector<Integer> arr, long sum) {
        int n = arr.size();

        long[] prefix_sum = new long[n + 1];
        for (int j = 1; j <= n; j++)
            prefix_sum[j] = prefix_sum[j - 1] + arr.get(j - 1);

        long result = 0;
        for (int j = 1; j <= n; j++) {
            long can = prefix_sum[j] - sum;
            //System.out.println("can:"+can);
            int ind = Arrays.binarySearch(prefix_sum, can);
            //System.out.println("ind:"+ind);
            // If the exact value is not found, get the insertion point
            if (ind < 0)
                ind = -ind - 1;

            result += (j - ind);
            //System.out.println(result);
        }
        return result;
    }

    static long GetKthLargest(Vector<Integer> arr, int k) {
        long l = 0, r = (long) 10;

        while (l < r) {
            long m = (l + r) / 2;
            long smaller_or_equal_m = CountOfSmallerOrEqualSumSubarray(arr, m);
            System.out.println("==");
            if (smaller_or_equal_m < k)
                l = m + 1;
            else
                r = m;
        }

        return l;
    }

    public static void main(String[] args) {
        Vector<Integer> arr = new Vector<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(GetKthLargest(arr, 6));
    }
}
// Output:
// 5

