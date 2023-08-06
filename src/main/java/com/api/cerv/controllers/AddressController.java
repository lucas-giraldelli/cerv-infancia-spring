package com.api.cerv.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.cerv.dtos.AddressRecordDTO;
import com.api.cerv.models.AddressModel;
import com.api.cerv.services.AddressService;

import jakarta.validation.Valid;

@RestController
public class AddressController {

  @Autowired
  AddressService addressService;

  @PostMapping("/addresses")
  public ResponseEntity<AddressModel> saveAddress(@RequestBody @Valid AddressRecordDTO addressRecordDTO) {
    return ResponseEntity.status(
        HttpStatus.CREATED).body(
            addressService.saveAddress(addressRecordDTO));
  }

  @GetMapping("/addresses")
  public ResponseEntity<List<AddressModel>> getAllAddresses() {
    return ResponseEntity.status(HttpStatus.OK).body(addressService.getAllAddresses());
  }

  @PutMapping("/addresses/{id}")
  public ResponseEntity<Object> updateAddress(
      @PathVariable(value = "id") UUID id,
      @RequestBody @Valid AddressRecordDTO addressRecordDTO) {

    return addressService.updateAddress(id, addressRecordDTO);
  }

}
