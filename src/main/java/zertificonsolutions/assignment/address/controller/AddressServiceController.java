package zertificonsolutions.assignment.address.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zertificonsolutions.assignment.address.entity.Address;
import zertificonsolutions.assignment.address.service.AddressService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressServiceController {


    private final AddressService addressService;

    @PostMapping
    public AddressDto createAddress(@Valid @RequestBody AddressDto addressDto) {
        Address address = addressService.create(addressDto.asAddress());
        return AddressDto.convert(address);
    }

    @PutMapping("/edit/{id}")
    public AddressDto updateAddress(@PathVariable Long id,
                                    @RequestBody AddressDto addressDto) {
        Address address = addressService.update(id, addressDto.asAddress());
        return AddressDto.convert(address);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.delete(id);
    }

    @GetMapping("/search")
    public List<AddressDto> getAddressByEmail(@RequestParam(required = false) String firstName,
                                              @RequestParam(required = false) String lastName,
                                              @RequestParam(required = false) String emailAddress) {
        List<Address> addresses = addressService.findAddress(firstName, lastName, emailAddress);
        return addresses.stream()
                .map(AddressDto::convert)
                .collect(Collectors.toList());
    }

}
