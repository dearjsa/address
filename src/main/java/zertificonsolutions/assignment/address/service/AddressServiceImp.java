package zertificonsolutions.assignment.address.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zertificonsolutions.assignment.address.entity.Address;
import zertificonsolutions.assignment.address.entity.NotFoundException;
import zertificonsolutions.assignment.address.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AddressServiceImp implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImp(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        address = addressRepository.save(address);
        log.info("Created address {}", address);
        return address;
    }

    @Override
    public Address update(Long id, Address updatedAddress) {
        Address savedAddress = findById(id);
        String originalAddress = savedAddress.toString();
        savedAddress.updateFrom(updatedAddress);
        log.info("Updated address {} to {}", originalAddress, savedAddress);
        return addressRepository.save(savedAddress);
    }

    @Override
    public void delete(Long id) {
        Address address = findById(id);
        addressRepository.delete(address);
        log.info("Deleted address id {}", id);
    }

    @Override
    public List<Address> findAddress(String firsName, String lastName, String emailAddress) {
        firsName = firsName != null ? firsName.toLowerCase() : null;
        lastName = lastName != null ? lastName.toLowerCase() : null;
        emailAddress = emailAddress != null ? emailAddress.toLowerCase() : null;
        return addressRepository.findAddress(firsName, lastName, emailAddress);
    }

    private Address findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if (!address.isPresent()) {
            log.warn("Could not found address with id {}", id);
            throw new NotFoundException("Could not found address with id: " + id);
    }
        return address.get();
    }
}
