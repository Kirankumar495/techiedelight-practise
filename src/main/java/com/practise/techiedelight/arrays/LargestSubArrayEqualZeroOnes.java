package com.practise.techiedelight.arrays;

import sun.util.resources.cldr.lag.CalendarData_lag_TZ;

import java.util.*;
/*
Given a binary array containing 0’s and 1’s, find the largest contiguous subarray with equal numbers of 0’s and 1’s.
Input : [0, 0, 1, 0, 1, 0, 0]
Output: [0, 1, 0, 1] or [1, 0, 1, 0]
Input : [0, 0, 0, 0]
Output: []
*/
public class LargestSubArrayEqualZeroOnes {

    public static void main(String[] args){
        List<Integer> arrList = Arrays.asList(0,0,1,0,1,0,0);
        List<Integer> res = findLargestSubarray(arrList);
    }
    public static List<Integer> findLargestSubarray(List<Integer> nums) {
        List<Integer> largestSubarray = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sumSoFar = 0;
        int startIndex =0;
        int endIndex = 0;
        int length = -1;
        for(int i=0;i< nums.size(); i++) {
            sumSoFar += nums.get(i) == 0 ? -1:1;
            if(map.containsKey(sumSoFar)){
                int start = map.get(sumSoFar)+1;
                if((i-start+1) > (endIndex-startIndex+1)){
                    startIndex = start;
                    endIndex = i;
                    length = endIndex-startIndex+1;
                }
            } else {
                map.put(sumSoFar, i);
            }
        }
        if(length != -1) {
            for(int i=startIndex; i<=endIndex;i++){
                largestSubarray.add(nums.get(i));
            }
        }
        return largestSubarray;
    }
}
