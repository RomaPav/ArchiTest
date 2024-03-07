package com.example.lab4.dto;/*
  @author   user
  @project   lab4
  @class  EntityDTO
  @version  1.0.0 
  @since 07.03.2024 - 00.20
*/

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EntityDTO {
    String id;
    @NonNull
    String name;
    @NonNull
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
