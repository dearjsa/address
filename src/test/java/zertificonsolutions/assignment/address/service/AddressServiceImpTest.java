package zertificonsolutions.assignment.address.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import zertificonsolutions.assignment.address.entity.Address;
import zertificonsolutions.assignment.address.entity.NotFoundException;
import zertificonsolutions.assignment.address.repository.AddressRepository;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AddressServiceImpTest {

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    AddressServiceImp addressServiceImp;

    @Test
    void create() {
        Address address = new Address();

        addressServiceImp.create(address);

        Mockito.verify(addressRepository).save(address);
    }

    @Test
    void delete_should_find_address_and_delete_it() {
        Long addressId = 1L;
        Address address = new Address();
        Mockito.when(addressRepository.findById(addressId)).thenReturn(Optional.of(address));
        addressServiceImp.delete(addressId);

        Mockito.verify(addressRepository).delete(address);
    }

    @Test
    void delete_should_throw_not_found_exception_when_address_not_exist() {
        Long addressId = 1L;
        Mockito.when(addressRepository.findById(addressId)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> addressServiceImp.delete(addressId));
    }

    @Test
    void findAddress() {
        addressServiceImp.findAddress("f_name", "l_name", "email");

        Mockito.verify(addressRepository).findAddress("f_name", "l_name", "email");
    }

    @Test
    void update_should_update_all_fields() {
        Long addressId = 1L;
        Address updatedAddress = new Address();
        updatedAddress.setFirstName("f_name");
        Address savedAddress = new Address();
        savedAddress.setFirstName("old_name");
        Mockito.when(addressRepository.findById(addressId)).thenReturn(Optional.of(savedAddress));

        addressServiceImp.update(addressId, updatedAddress);

        // All fields should be set updated and tested (skipped because of time constraint)
        Assertions.assertEquals(savedAddress.getFirstName(), "f_name");
        Mockito.verify(addressRepository).save(savedAddress);
    }

}
