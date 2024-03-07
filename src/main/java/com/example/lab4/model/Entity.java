package com.example.lab4.model;/*
  @author   user
  @project   lab4
  @class  Entity
  @version  1.0.0 
  @since 07.03.2024 - 00.14
*/

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document(collection = "Entity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Entity {
    @Id
    String id;
    String name;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
