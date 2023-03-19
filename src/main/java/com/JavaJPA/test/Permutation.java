package com.JavaJPA.test;

public class Permutation {
  static void swap(int arr[], int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  static void reverse(int[] arr, int start, int end){
    while(start<end){
      swap(arr, start,end);
      start ++;
      end --;
    }
  }
  static void nextPermutations(int [] arr) {
    int n = arr.length;
    int i, j;
    for (i = n - 2; i >= 0; i--) {
      if (arr[i] < arr[i + 1])
        break;
    }
    if (i < 0) {
      reverse(arr, 0, arr.length - 1);
    } else {
      for (j = n - 1; j > i; j--) {
        if (arr[j] > arr[i]) {
          break;
        }
      }
      swap(arr, i, j);
      reverse(arr, i + 1, arr.length - 1);
    }
  }
  static int factorial(int n){
    if(n==1)
      return 1;
    return n*factorial(n-1);
  }
  public static void main(String[] args) {
    int [] arr = new int[]{1,2,4,5,6};
    int fact = factorial(6);
    System.out.println("fact = " + fact);
    while(fact!=0){
      nextPermutations(arr);
      for(int i:arr){
        System.out.print(i);
      }
      System.out.println("");
      fact --;
    }
  }
}
