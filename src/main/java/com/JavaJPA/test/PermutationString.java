package com.JavaJPA.test;

public class PermutationString {
  static void permutation(String curr, String rem){
    if(rem.length()==0){
      System.out.println(curr);
      return;
    }
      for(int i=0;i<rem.length();i++){
        char ch = rem.charAt(i);
        String ros = rem.substring(0,i) + rem.substring(i+1);
        permutation(curr +ch , ros);
      }
  }
  public static void main(String[] args) {
    String str = "abc";
    permutation("",str);
  }
}
