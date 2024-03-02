package com.jpa.gkp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.gkp.models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
    
}
