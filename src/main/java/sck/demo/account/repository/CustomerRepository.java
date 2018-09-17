package sck.demo.account.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query(
            value = "SELECT * FROM Customer c WHERE c.id = ?1 AND c.salary >= 15000 AND c.age >= 20",
            nativeQuery = true)
    Customer findAccountById(int id);
}

