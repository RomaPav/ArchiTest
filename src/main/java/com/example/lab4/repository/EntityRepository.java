package com.example.lab4.repository;/*
  @author   user
  @project   lab4
  @class  EntityRepository
  @version  1.0.0 
  @since 07.03.2024 - 00.17
*/

import com.example.lab4.model.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends MongoRepository<Entity, String> {
    public Entity getEntityById(String id);
}
