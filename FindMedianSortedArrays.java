/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/


public class FindMedianSortedArrays {
    public static void main(String[] args) {
        FindMedianSortedArrays app = new FindMedianSortedArrays();
        System.out.println(app.findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4}));
    }

    // Merge sort method - O(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = 0, n = 0, k = 0, mergedLen = nums1.length + nums2.length;
        boolean isEvenLen = mergedLen % 2 == 0;
        int halfLen = (mergedLen + (isEvenLen ? 2 : 1)) / 2;
        int[] merged = new int[halfLen];

        while(m+n < halfLen && m < nums1.length && n < nums2.length) {
            if(nums1[m] < nums2[n]) { merged[k++] = nums1[m++]; }
            else { merged[k++] = nums2[n++]; }
        }

        while(m+n < halfLen && m < nums1.length) {
            merged[k++] = nums1[m++];
        }

        while(m+n < halfLen && n < nums2.length) {
            merged[k++] = nums2[n++];
        }

        return isEvenLen ? (double) (merged[halfLen - 1] + merged[halfLen - 2]) /2 : merged[halfLen -1];
    }
}
