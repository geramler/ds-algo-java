package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Challenge: Two Sum
     *
     * Problem Statement:
     * Given an array of integers 'nums' and an integer 'target', return the indices
     * of the two numbers such that they add up to the target.
     *
     * Assumptions:
     * - Each input has exactly one solution.
     * - You may not use the same element twice.
     * - The answer can be returned in any order.
     *
     * Examples:
     *   Input:  nums = [2, 7, 11, 15], target = 9
     *   Output: [0, 1]
     *   Explanation: nums[0] + nums[1] = 2 + 7 = 9
     *
     *   Input:  nums = [3, 2, 4], target = 6
     *   Output: [1, 2]
     *   Explanation: nums[1] + nums[2] = 2 + 4 = 6
     *
     *   Input:  nums = [3, 3], target = 6
     *   Output: [0, 1]
     *   Explanation: nums[0] + nums[1] = 3 + 3 = 6
     *
     *
     * ---- HINTS ----
     *
     * Hint 1 — Start Simple (Brute Force):
     *   Use two nested loops. The outer loop picks the first number, the inner
     *   loop scans the remaining numbers to find the complement.
     *   Time Complexity: O(n^2)
     *   Space Complexity: O(1)
     *
     * Hint 2 — Optimize with a Hash Map:
     *   As you iterate through the array, ask yourself:
     *   "What number do I need to reach the target?"
     *   That number is: complement = target - currentNumber
     *
     *   If you've already seen the complement earlier in the array, you're done.
     *   Store each number's value → index in a HashMap as you go so you can
     *   look up the complement in O(1) time.
     *   Time Complexity: O(n)
     *   Space Complexity: O(n)
     *
     * Hint 3 — One-Pass vs Two-Pass:
     *   A two-pass approach: first, populate the HashMap with all numbers and
     *   their indices; second, scan the array again looking for the complement.
     *   A one-pass approach: build the HashMap and check for the complement
     *   in the same loop. One-pass is more elegant and avoids accidentally
     *   reusing the same element.
     *
     * Hint 4 — Edge Cases to Consider:
     *   - Duplicate values (e.g., [3, 3], target = 6). Make sure you don't
     *     return the same index twice.
     *   - Negative numbers in the array and/or a negative target.
     *   - An array with exactly two elements that sum to the target.
     *
     * Hint 5 — Think Before You Code:
     *   Draw it out on paper or whiteboard. Walk through the example
     *   nums = [2, 7, 11, 15], target = 9 step-by-step with the HashMap
     *   approach. Understanding the one-pass algorithm deeply will make
     *   the implementation trivial.
     */
    public static int[] twoSum(int[] nums, int target) {
        // Brute Force
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
               if(nums[i] + nums[j] == target){
                   return new int[]{i,j};
               }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        // --- twoSum (Brute Force) ---
        System.out.println("=== twoSum (Brute Force) ===");

        // Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("nums: " + Arrays.toString(nums1) + ", target: " + target1);
        System.out.println("Indices: " + Arrays.toString(result1));
        System.out.println("Expected: [0, 1]");
        System.out.println();

        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("nums: " + Arrays.toString(nums2) + ", target: " + target2);
        System.out.println("Indices: " + Arrays.toString(result2));
        System.out.println("Expected: [1, 2]");
        System.out.println();

        // Test Case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("nums: " + Arrays.toString(nums3) + ", target: " + target3);
        System.out.println("Indices: " + Arrays.toString(result3));
        System.out.println("Expected: [0, 1]");
        System.out.println();

        // --- twoSum2 (HashMap) ---
        System.out.println("=== twoSum2 (HashMap) ===");

        // Test Case 4: Basic case
        int[] nums4 = {2, 7, 11, 15};
        int target4 = 9;
        int[] result4 = twoSum2(nums4, target4);
        System.out.println("nums: " + Arrays.toString(nums4) + ", target: " + target4);
        System.out.println("Indices: " + Arrays.toString(result4));
        System.out.println("Expected: [0, 1]");
        System.out.println();

        // Test Case 5: Solution at end of array
        int[] nums5 = {3, 2, 4};
        int target5 = 6;
        int[] result5 = twoSum2(nums5, target5);
        System.out.println("nums: " + Arrays.toString(nums5) + ", target: " + target5);
        System.out.println("Indices: " + Arrays.toString(result5));
        System.out.println("Expected: [1, 2]");
        System.out.println();

        // Test Case 6: Duplicate values
        int[] nums6 = {3, 3};
        int target6 = 6;
        int[] result6 = twoSum2(nums6, target6);
        System.out.println("nums: " + Arrays.toString(nums6) + ", target: " + target6);
        System.out.println("Indices: " + Arrays.toString(result6));
        System.out.println("Expected: [0, 1]");
        System.out.println();
    }
}