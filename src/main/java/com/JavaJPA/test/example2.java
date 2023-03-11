package com.JavaJPA.test;

public class example2 {
  static int isSubstring(String ref, String input){
    if(ref.length()==0)
      return -1;
    return ref.indexOf(input);
  }

  public static void main(String[] args) {
    String ref = "lifesight";
    String input1 = "ifesightl";
    String input2 = "seightlif";
    String mainString = ref+ref;
    if(isSubstring(mainString,input1)>0){
      System.out.println("Input1 Is a rotated String");
    }else{
      System.out.println("Input1 False");
    }
    if(isSubstring(mainString,input2)>0){
      System.out.println("Input2 Is a rotated String");
    }else{
      System.out.println("Input2 False");
    }
  }
}
