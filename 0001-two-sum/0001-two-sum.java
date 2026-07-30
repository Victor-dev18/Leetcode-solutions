import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 1. Store numbers and their original indices
        int[][] numWithIndex = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numWithIndex[i][0] = nums[i];
            numWithIndex[i][1] = i;
        }
        
        // 2. Sort the array based on the numbers
        Arrays.sort(numWithIndex, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 3. Initialize two pointers
        int left = 0;
        int right = nums.length - 1;
        
        // 4. Move pointers based on the sum
        while (left < right) {
            int currentSum = numWithIndex[left][0] + numWithIndex[right][0];
            
            if (currentSum == target) {
                return new int[] { numWithIndex[left][1], numWithIndex[right][1] };
            } else if (currentSum < target) {
                left++; // Sum is too small, move left pointer right
            } else {
                right--; // Sum is too big, move right pointer left
            }
        }
        
        return new int[] {}; 
    }
}
