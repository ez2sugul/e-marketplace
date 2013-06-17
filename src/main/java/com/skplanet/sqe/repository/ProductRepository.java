package com.skplanet.sqe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skplanet.sqe.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
