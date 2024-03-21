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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class Entity {
    @Id
    String id;
    @NonNull
    String name;
    @NonNull
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
