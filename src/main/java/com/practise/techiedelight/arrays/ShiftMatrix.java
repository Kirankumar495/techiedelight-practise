package com.practise.techiedelight.arrays;
/*
https://techiedelight.com/practice/?problem=ShiftMatrix
Given an `M × N` integer matrix, shift all its elements by `1` in spiral order.
Input:
[
	[ 1,  2,  3,  4, 5],[16, 17, 18, 19, 6],[15, 24, 25, 20, 7],[14, 23, 22, 21, 8],[13, 12, 11, 10, 9]
]
Output:
[
	[25,  1,  2,  3, 4],[15, 16, 17, 18, 5],[14, 23, 24, 19, 6],[13, 22, 21, 20, 7],[12, 11, 10,  9, 8]
]
*/
public class ShiftMatrix {
    public static void main(String[] args){
        int[][] mat = {{1,  2,  3,  4, 5},{16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},{14, 23, 22, 21, 8},{13, 12, 11, 10, 9}};
        shiftMatrix(mat);
    }
    public static void shiftMatrix(int[][] mat)
    {
        if(mat == null || mat.length == 0){
            return;
        }
        int top =0;
        int bottom = mat.length-1;
        int left =0;
        int right = mat[0].length-1;
        int prev = mat[0][0];
        int current =0;
        while(true){
            if(left > right){
                break;
            }
            // top row
            for(int i=left ; i<= right ;i++){
                current = mat[top][i];
                mat[top][i] = prev;
                prev = current;
            }
            top++;

            if (top > bottom) {
                break;
            }
            // right column
            for(int i = top; i<= bottom; i++){
                current = mat[i][right];
                mat[i][right] = prev;
                prev = current;
            }
            right--;
            if (left > right) {
                break;
            }
            // bottom row
            for(int i=right; i >= left; i--){
                current = mat[bottom][i];
                mat[bottom][i] = prev;
                prev = current;
            }
            bottom--;

            if (top > bottom) {
                break;
            }
            //left column
            for(int i=bottom; i>=top; i--){
                current = mat[i][left];
                mat[i][left] = prev;
                prev = current;
            }
            left++;
        }
        mat[0][0] = prev;
    }
}
