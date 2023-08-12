package com.api.cerv.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

  public Object updateAddress(UUID id,
      AddressRecordDTO addressRecordDTO,
      Optional<AddressModel> address0) {

    var addressModel = address0.get();

    BeanUtils.copyProperties(addressRecordDTO, addressModel);
    return addressRepository.save(addressModel);
  }

  public Optional<AddressModel> findAddressById(UUID id) {
    return addressRepository.findById(id);
  }
}
