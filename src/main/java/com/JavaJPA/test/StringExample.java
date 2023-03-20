package com.JavaJPA.test;
import java.util.*;

public class StringExample {

// **Print the string in the following format**
//
//    1. Character following by its frequency.
//    2. Sort by its frequency, if frequency matches then sort by alphabetical order.
//
//    Eg:
//  Input string: “bcpppcbe”
//
//  o/p: “p3b2c2e1
  public static void main(String[] args) {
    HashMap<Character, Integer> map = new HashMap<>();
    LinkedHashMap<Character, Integer> lmap = new LinkedHashMap<>();
    String s ="bcpppcbe";
    for(int i=0;i<s.length();i++){
      if(map.containsKey(s.charAt(i)))
        map.put(s.charAt(i),map.get(s.charAt(i))+1);
      else
        map.put(s.charAt(i),1);
    }
    List<Integer> ll = new ArrayList<>();
    for(Map.Entry<Character, Integer> m: map.entrySet()){
      ll.add(m.getValue());
    }
    Collections.sort(ll, Collections.reverseOrder());
    for(int i=0;i<ll.size();i++){
      for(Map.Entry<Character, Integer> mm: map.entrySet()){
        if(mm.getValue().equals(ll.get(i))){
          lmap.put(mm.getKey(),mm.getValue());
        }
      }
    }
    System.out.println(lmap);
  }
}
