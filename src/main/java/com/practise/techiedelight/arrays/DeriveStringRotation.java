package com.practise.techiedelight.arrays;

/*
https://www.techiedelight.com/check-strings-can-derived-circularly-rotating/
Input:

X = ABCD
Y = DABC

Output: Yes

Y can be derived from X by right-rotating it by 1 unit

 */
public class DeriveStringRotation {

    public static void main(String[] args)
    {
        String X = "ABCD";
        String Y = "DABC";

        if (check(X, Y)) {
            System.out.println("Given strings can be derived from each other");
        }
        else {
            System.out.println("Given strings cannot be derived from each other");
        }
    }
    public static boolean check(String X, String Y) {
        if ( X == null || Y == null){
            return false;
        }
        if(X.length() != Y.length()) {
            return false;
        }
        for(int i=0; i< X.length()-1;i++) {
            X = X.charAt(X.length()-1) + X.substring(0, X.length()-1);
            if(X.compareTo(Y) == 0) {
                return true;
            }
        }
        return false;
    }
}
