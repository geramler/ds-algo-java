package arrays;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

    /**
     * Challenge: Best Time to Buy and Sell Stock
     *
     * Problem Statement:
     * You are given an array 'prices' where prices[i] is the price of a given stock
     * on day i. You want to maximize your profit by choosing a single day to buy
     * one stock and choosing a different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction.
     * If you cannot achieve any profit, return 0.
     *
     * Assumptions:
     * - You can only buy once and sell once.
     * - You must buy before you sell (buy day < sell day).
     * - If prices only decrease, return 0 (no transaction is made).
     *
     * Examples:
     *   Input:  prices = [7, 1, 5, 3, 6, 4]
     *   Output: 5
     *   Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6).
     *                profit = 6 - 1 = 5. Not 7 - 1 = 6, because selling must
     *                occur after buying.
     *
     *   Input:  prices = [7, 6, 4, 3, 1]
     *   Output: 0
     *   Explanation: Prices only decrease. No profitable transaction is possible.
     *
     *   Input:  prices = [1, 2]
     *   Output: 1
     *   Explanation: Buy at 1, sell at 2. profit = 1.
     *
     *
     * ---- HINTS ----
     *
     * Hint 1 — Start Simple (Brute Force):
     *   Try every possible pair of buy and sell days. The outer loop picks the
     *   buy day, the inner loop picks a sell day after the buy day. Track the
     *   maximum profit seen.
     *   Time Complexity: O(n^2)
     *   Space Complexity: O(1)
     *
     * Hint 2 — Think in Terms of "Lowest Price So Far":
     *   As you walk through the array from left to right, you only care about
     *   two things at each step:
     *     1. What is the lowest price I have seen so far?
     *     2. If I sell at today's price, what profit would I make?
     *
     *   profit = prices[i] - minPriceSoFar
     *
     *   Update minPriceSoFar and maxProfit as you go. This is a single pass.
     *   Time Complexity: O(n)
     *   Space Complexity: O(1)
     *
     * Hint 3 — Visualize the Prices:
     *   Draw the price chart. The problem is equivalent to finding the maximum
     *   positive difference between two points where the left point (buy) comes
     *   before the right point (sell). The "lowest point so far" approach is
     *   effectively scanning this difference from left to right.
     *
     * Hint 4 — Edge Cases to Consider:
     *   - Empty array or a single day → return 0 (can't buy and sell).
     *   - All decreasing prices → return 0.
     *   - All increasing prices → buy on day 0, sell on the last day.
     *   - The minimum price occurs after the maximum price → that pair is
     *     invalid because you can't sell before you buy. The one-pass
     *     approach naturally handles this.
     *
     * Hint 5 — Relate to Two-Pointer / Sliding Window:
     *   You can think of a left pointer (buy) and a right pointer (sell).
     *   - Start left = 0, right = 1.
     *   - If prices[right] > prices[left], compute profit and move right.
     *   - If prices[right] < prices[left], move left to right (found a new low).
     *   - Continue until right reaches the end.
     *   This is another way to achieve O(n) time and O(1) space.
     */
    public static int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if(prices[j] - prices[i] > result){
                    result = prices[j] - prices[i];
                }
            }
        }
        return result;
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test Case 1: Normal case
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int profit1 = maxProfit(prices1);
        System.out.println("prices: " + Arrays.toString(prices1));
        System.out.println("Max Profit: " + profit1);
        System.out.println("Expected: 5  (buy at 1, sell at 6)");
        System.out.println();

        // Test Case 2: Decreasing only
        int[] prices2 = {7, 6, 4, 3, 1};
        int profit2 = maxProfit(prices2);
        System.out.println("prices: " + Arrays.toString(prices2));
        System.out.println("Max Profit: " + profit2);
        System.out.println("Expected: 0  (no profitable transaction)");
        System.out.println();

        // Test Case 3: Two-element array
        int[] prices3 = {1, 2};
        int profit3 = maxProfit(prices3);
        System.out.println("prices: " + Arrays.toString(prices3));
        System.out.println("Max Profit: " + profit3);
        System.out.println("Expected: 1  (buy at 1, sell at 2)");
        System.out.println();

        // Test Case 4: Increasing only
        int[] prices4 = {1, 2, 3, 4, 5};
        int profit4 = maxProfit(prices4);
        System.out.println("prices: " + Arrays.toString(prices4));
        System.out.println("Max Profit: " + profit4);
        System.out.println("Expected: 4  (buy at 1, sell at 5)");
        System.out.println();

        // Test Case 5: Minimum after maximum (can't buy after selling)
        int[] prices5 = {5, 10, 2, 8};
        int profit5 = maxProfit(prices5);
        System.out.println("prices: " + Arrays.toString(prices5));
        System.out.println("Max Profit: " + profit5);
        System.out.println("Expected: 6  (buy at 2, sell at 8 — not 10-2=8 from invalid order)");
        System.out.println();

        // Test Case 6: Empty / single day
        int[] prices6 = {};
        int profit6 = maxProfit(prices6);
        System.out.println("prices: " + Arrays.toString(prices6));
        System.out.println("Max Profit: " + profit6);
        System.out.println("Expected: 0  (empty array)");
        System.out.println();

        int[] prices7 = {5};
        int profit7 = maxProfit(prices7);
        System.out.println("prices: " + Arrays.toString(prices7));
        System.out.println("Max Profit: " + profit7);
        System.out.println("Expected: 0  (single day)");
        System.out.println();

        // --- maxProfit2 (One-Pass) ---
        System.out.println("=== maxProfit2 (One-Pass) ===");

        // Test Case 7: Normal case
        int[] prices8 = {7, 1, 5, 3, 6, 4};
        int profit8 = maxProfit2(prices8);
        System.out.println("prices: " + Arrays.toString(prices8));
        System.out.println("Max Profit: " + profit8);
        System.out.println("Expected: 5  (buy at 1, sell at 6)");
        System.out.println();

        // Test Case 8: Decreasing only
        int[] prices9 = {7, 6, 4, 3, 1};
        int profit9 = maxProfit2(prices9);
        System.out.println("prices: " + Arrays.toString(prices9));
        System.out.println("Max Profit: " + profit9);
        System.out.println("Expected: 0  (no profitable transaction)");
        System.out.println();

        // Test Case 9: Two-element array
        int[] prices10 = {1, 2};
        int profit10 = maxProfit2(prices10);
        System.out.println("prices: " + Arrays.toString(prices10));
        System.out.println("Max Profit: " + profit10);
        System.out.println("Expected: 1  (buy at 1, sell at 2)");
        System.out.println();

        // Test Case 10: Increasing only
        int[] prices11 = {1, 2, 3, 4, 5};
        int profit11 = maxProfit2(prices11);
        System.out.println("prices: " + Arrays.toString(prices11));
        System.out.println("Max Profit: " + profit11);
        System.out.println("Expected: 4  (buy at 1, sell at 5)");
        System.out.println();

        // Test Case 11: Minimum after maximum
        int[] prices12 = {5, 10, 2, 8};
        int profit12 = maxProfit2(prices12);
        System.out.println("prices: " + Arrays.toString(prices12));
        System.out.println("Max Profit: " + profit12);
        System.out.println("Expected: 6  (buy at 2, sell at 8)");
        System.out.println();

        // Test Case 12: Empty / single day
        int[] prices13 = {};
        int profit13 = maxProfit2(prices13);
        System.out.println("prices: " + Arrays.toString(prices13));
        System.out.println("Max Profit: " + profit13);
        System.out.println("Expected: 0  (empty array)");
        System.out.println();

        int[] prices14 = {5};
        int profit14 = maxProfit2(prices14);
        System.out.println("prices: " + Arrays.toString(prices14));
        System.out.println("Max Profit: " + profit14);
        System.out.println("Expected: 0  (single day)");
    }
}