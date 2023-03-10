package com.JavaJPA.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Station {
  @Id
  @Column
  private Integer station_id;
  @Column
  private String station_name;
  @Column
  private String station_image;
  @Column
  private Float station_pricing;
  @Column
  private String station_address;

}
