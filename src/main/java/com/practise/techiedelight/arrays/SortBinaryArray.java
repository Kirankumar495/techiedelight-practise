package com.practise.techiedelight.arrays;

/*
https://techiedelight.com/practice/?problem=SortBinaryArray
Given a binary array, in-place sort it in linear time and constant space. The output should contain all zeroes, followed by all ones.

Input : [1, 0, 1, 0, 1, 0, 0, 1]
Output: [0, 0, 0, 0, 1, 1, 1, 1]

Input : [1, 1]
Output: [1, 1]

*/
public class SortBinaryArray {
    public static void sortArray(int[] nums)
    {
        int startIndex =0;
        int oneCount = 0;
        for(int i=0; i< nums.length;i++){
            if(nums[i] == 1) {
                oneCount += 1;
            } else {
                nums[startIndex] = 0;
                startIndex += 1;
            }
        }
        if(oneCount == nums.length){
            return;
        } else{
            while(oneCount > 0){
                nums[startIndex] = 1;
                startIndex += 1;
                oneCount = oneCount-1;
            }
        }
    }
}
