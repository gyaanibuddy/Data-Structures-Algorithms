/*
  Problem Statement : 
    To compute longest common subsequence for the given two strings.
  Language : JAVA
*/

import java.util.*;
class LCS {
  static void LCS(char c1[],char c2[]){
   int l1=c1.length;
   int l2=c2.length;

   int a[][]=new int[l1+1][l2+1];
   int path[][]=new int[l1+1][l2+1];
   //-1 -> left
   //1  -> top
   //0  -> diagonal
  
   for(int i=0;i<=l1;i++){
     for(int j=0;j<=l2;j++){
       if(i==0 || j==0){
         a[i][j]=0;
         continue;
       }

       if(c1[i-1] == c2[j-1]){
         a[i][j]=1+a[i-1][j-1];
         path[i][j]=0;
       }
       else{
         if(a[i][j-1]>=a[i-1][j]){
           a[i][j]=a[i][j-1];
           path[i][j]=-1;
         }
         else{
           a[i][j]=a[i-1][j];
           path[i][j]=1;
         }
       }
     }
   }

   System.out.println("\nDP Matrix:\n");
   printMatrix(a,l1,l2);
   System.out.println("\nPath Matrix:\n");
   printMatrix(path,l1,l2);

   StringBuilder sb = new StringBuilder("");
   int i=l1,j=l2;
   while(i>0 && j>0){
     if(path[i][j]==0){
       sb.append(c1[i-1]);
       i-=1;
       j-=1;
     }
     else if(path[i][j]==-1){
       j-=1;
     }
     else if(path[i][j]==1){
       i-=1;
     }
   }
   String lcs=sb.reverse().toString();
   System.out.println("\n\nThe LCS is found to be : "+lcs);
 }

  static void printMatrix(int[][] z,int row,int column){
    for(int i=0;i<=row;i++){
      for(int j=0;j<=column;j++){
        System.out.print(z[i][j]+" ");
      }
      System.out.println();
    }

    System.out.println("\n------------\n");
  }
  public static void main(String[] args) {
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter first string: ");
   String s1=sc.nextLine();
   System.out.println("Enter second string: ");
   String s2=sc.nextLine();
  
   char[] c1=s1.toCharArray();
   char[] c2=s2.toCharArray();

   LCS(c1,c2);

  
 }
}