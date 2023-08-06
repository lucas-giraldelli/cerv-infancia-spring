package com.api.cerv.models;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TB_ADDRESS")
public class AddressModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private String street;

  private String number;

  private String neighborhood;

  private String complement;

  private String zipcode;

  @JsonIgnore
  @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
  private StudentModel student;

}
