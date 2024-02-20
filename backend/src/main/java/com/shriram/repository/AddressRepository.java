package com.shriram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shriram.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
