package com.JavaJPA.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class example {
  static List<Temp> hTemp = new ArrayList<Temp>();
  public static Temp findMinTemp(String minMax){
    List<Temp> retTemp = new ArrayList<Temp>(hTemp);
    if(minMax.equalsIgnoreCase("min")){
      return hTemp.get(0);
    }
    else{
      Collections.max(retTemp, (tm1,tm2)-> tm1.getMax()-tm2.getMax());
      return retTemp.get(retTemp.size()-1);
    }
  }
  public static void main(String[] args) throws IOException {
    FileReader fileReader= new FileReader("src/main/resources/input.txt");
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String line = bufferedReader.readLine();
    while(line!=null){
      String[] stringArray= line.split(",");
      Temp temp = new Temp();
      temp.setDate(stringArray[0]);
      temp.setCity(stringArray[1]);
      temp.setMin(Integer.parseInt(stringArray[2].trim()));
      temp.setMax(Integer.parseInt(stringArray[3].trim()));
      hTemp.add(temp);
      line= bufferedReader.readLine();
    }
    Collections.sort(hTemp, (t1, t2)-> t1.getMin()-t2.getMin());
    System.out.println(findMinTemp("min"));
    System.out.println(findMinTemp("max"));
  }
}
