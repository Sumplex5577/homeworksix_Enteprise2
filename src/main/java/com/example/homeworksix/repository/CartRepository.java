package com.example.homeworksix.repository;

import com.example.homeworksix.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
