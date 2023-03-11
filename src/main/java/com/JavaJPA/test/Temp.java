package com.JavaJPA.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Temp {
  private String date;
  private String city;
  private Integer min;
  private Integer max;
}
