package com.practise.techiedelight.arrays;

import java.util.*;
/*
https://techiedelight.com/practice/?problem=ZeroSumII
Given an integer array, find all contiguous subarrays with zero-sum.

Input : [4, 2, -3, -1, 0, 4]
Output: {[-3, -1, 0, 4], [0]}

Input : [3, 4, -7, 3, 1, 3, 1, -4, -2, -2]
Output: {[3, 4, -7], [4, -7, 3], [-7, 3, 1, 3], [3, 1, -4], [3, 1, 3, 1, -4, -2, -2], [3, 4, -7, 3, 1, 3, 1, -4, -2, -2]}

Input : [0, 0]
Output: {[0], [0, 0]}

Input : [1, 2, 3]
Output: {}

Note: Since an input can have multiple subarrays with zero-sum, the solution should return a set containing all the distinct subarrays.

*/
public class FindAllSubArraysZeroSum {
    public static Set<List<Integer>> getAllZeroSumSubarrays(List<Integer> nums)
    {
        Set<List<Integer>> subarrays = new HashSet<>();
        int sumSoFar = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.size(); i++){
            sumSoFar += nums.get(i);
            if(sumSoFar == 0){
                subarrays.add(createList(nums, 0, i));
            }
            if(map.containsKey(sumSoFar)){
                List<Integer> starts = map.get(sumSoFar);
                for(int startIndex: starts){
                    subarrays.add(createList(nums, startIndex+1, i));
                }
            }
            else{
                map.put(sumSoFar, new ArrayList<>());
            }
            map.get(sumSoFar).add(i);
        }
        return subarrays;
    }

    private static List<Integer> createList(List<Integer> nums,int start, int end){
        List<Integer> res = new ArrayList<>();
        for(int i=start; i<=end;i++){
            res.add(nums.get(i));
        }
        return res;
    }
}
