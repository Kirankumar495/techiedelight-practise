package com.practise.techiedelight.arrays;

import java.util.Arrays;

/*
https://techiedelight.com/practice/?problem=MaximumProductPair
Given an integer array, find a pair with the maximum product in it.
Each input can have multiple solutions. The output should match with either one of them.
Input : [-10, -3, 5, 6, -2]
Output: (-10, -3) or (-3, -10) or (5, 6) or (6, 5)
Input : [-4, 3, 2, 7, -5]
Output: (3, 7) or (7, 3)
If no pair exists, the solution should return null.
Input : [1]
Output: null

*/
public class MaxProductPair {
    /* The Pair<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Pair.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

    public static int[] findPair(int[] nums)
    {
        int[] result = new int[2];
        Arrays.sort(nums);
        if(nums.length > 1) {
            if(nums[0] * nums[1] > nums[nums.length-1]* nums[nums.length-2]){
                result[0] = nums[0];
                result[1] = nums[1];
            }
            else {
                result[0] = nums[nums.length-1];
                result[1] = nums[nums.length-2];
            }
            return result;
        }
        return null;
    }
}
