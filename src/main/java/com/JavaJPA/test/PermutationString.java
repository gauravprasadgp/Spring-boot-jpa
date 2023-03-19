package com.JavaJPA.test;

import java.util.Arrays;
import java.util.List;

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
    List<Integer> ll = Arrays.asList(1,2,3,4,6);
    StringBuilder builder = new StringBuilder();
    ll.forEach(l-> builder.append(l));
    String str = "abc";
    permutation("",builder.toString());
  }
}
