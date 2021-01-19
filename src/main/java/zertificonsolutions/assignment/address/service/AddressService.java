package zertificonsolutions.assignment.address.service;

import zertificonsolutions.assignment.address.entity.Address;

import java.util.List;

public interface AddressService {

    Address create(Address address);

    Address update(Long id, Address address);

    void delete(Long id);

    List<Address> findAddress(String firsName, String lastName, String emailAddress);
}
