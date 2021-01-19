package zertificonsolutions.assignment.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zertificonsolutions.assignment.address.entity.Address;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select a from Address a " +
            "where (:firstName is null or a.firstName = :firstName) " +
            "and (:lastName is null or a.lastName = :lastName) " +
            "and (:emailAddress is null or a.emailAddress = :emailAddress)")
    List<Address> findAddress(@Param("firstName") String firstName,
                              @Param("lastName") String lastName,
                              @Param("emailAddress") String emailAddress);

}
