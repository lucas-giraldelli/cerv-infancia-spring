package com.api.cerv.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.api.cerv.dtos.AddressRecordDTO;
import com.api.cerv.models.AddressModel;
import com.api.cerv.repositories.AddressRepository;

@Service
public class AddressService {
  @Autowired
  AddressRepository addressRepository;

  public AddressModel saveAddress(AddressRecordDTO addressRecordDTO) {
    var addressModel = new AddressModel();
    BeanUtils.copyProperties(addressRecordDTO, addressModel);
    return addressRepository.save(addressModel);
  }

  public List<AddressModel> getAllAddresses() {
    return addressRepository.findAll();
  }

  public ResponseEntity<Object> updateAddress(UUID id, AddressRecordDTO addressRecordDTO) {
    Optional<AddressModel> address0 = addressRepository.findById(id);
    if (address0.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address does not exist");
    }
    var addressModel = address0.get();
    BeanUtils.copyProperties(addressRecordDTO, addressModel);
    return ResponseEntity.status(HttpStatus.OK).body(addressRepository.save(addressModel));
  }

  public Optional<AddressModel> findById(UUID id) {
    return addressRepository.findById(id);
  }
}
