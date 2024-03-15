package com.shriram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.shriram.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
