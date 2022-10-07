package com.example.homeworksix.repository;

import com.example.homeworksix.model.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
}
