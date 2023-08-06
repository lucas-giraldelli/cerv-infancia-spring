package com.api.cerv.dtos;

import jakarta.validation.constraints.NotNull;

public record AddressRecordDTO(
    @NotNull String street,

    @NotNull String number,

    @NotNull String neighborhood,

    String complement,

    String zipcode) {

}
