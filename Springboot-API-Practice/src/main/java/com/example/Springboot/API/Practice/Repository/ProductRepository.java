package com.example.Springboot.API.Practice.Repository;

import com.example.Springboot.API.Practice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Repository interface for Product entity. **/

@org.springframework.stereotype.Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}