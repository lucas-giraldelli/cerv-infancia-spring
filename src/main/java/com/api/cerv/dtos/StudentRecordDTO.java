package com.api.cerv.dtos;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record StudentRecordDTO(
    @NotNull String name,
    @NotNull LocalDate dob,
    @NotNull String childAssociate,
    @NotNull String associatePhone,
    String associateKinship,
    String momName,
    String dadName,
    String allergy,
    UUID address,
    UUID level) {

}
