/*
  Find the longest palindromic substring.
*/

import java.util.*;
class Main {
    public static void printMatrix(int[][] dp){
      int n = dp[0].length;
      System.out.println("\n\nThe dp matrix: \n");
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          System.out.print(dp[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println();
    }

    public static String longestPalindrome(String s) {
      int n = s.length();
      int dp[][] = new int[n][n];
      
      for(int i=0;i<n;i++) dp[i][i] = 1;
      
      int left = 0,right = 0;
      
      int len = 2;
      
      int row = 0;
      int col = 1;
      while(len <= n){
        // row -> 0 to (n-1) - len + 1
        // col -> len - 1 to (n-1)
        int c = len -1;
        for(int r = 0; r<= n-len; r++){
            
          if(c-r == 1 && s.charAt(c) == s.charAt(r)){
            dp[r][c] = 1;
            left = r;
            right = c;
          }
          else{
            if(s.charAt(c) == s.charAt(r) && dp[r+1][c-1] == 1){
              dp[r][c] = 1;
              left = r;
              right = c;
            }
          }
          c++;
        }
        len++;
      }

      printMatrix(dp);
      
      return s.substring(left,right+1);
        
    }

    public static void main(String args[]){
      System.out.print("Enter the input string :   ");
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      System.out.println("Longest Palindromic Substring : "+longestPalindrome(s));
    }
}