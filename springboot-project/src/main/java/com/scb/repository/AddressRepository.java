package com.scb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
