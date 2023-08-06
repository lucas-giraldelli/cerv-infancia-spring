package com.api.cerv.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TB_STUDENT")
public class StudentModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private String name;

  private LocalDate dob;

  private String childAssociate;

  private String associatePhone;

  private String associateKinship;

  private String momName;

  private String dadName;

  private String allergy;

  @OneToOne
  @JoinColumn(name = "address_id")
  private AddressModel address;

  private UUID levelId;

}
