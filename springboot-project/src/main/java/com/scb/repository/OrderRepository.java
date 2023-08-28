package com.scb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
