package com.example.lab4.controller;/*
  @author   user
  @project   lab4
  @class  EntityController
  @version  1.0.0 
  @since 07.03.2024 - 00.17
*/

import com.example.lab4.service.EntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/entity")
@RequiredArgsConstructor
public class EntityController {
    private final EntityService entityService;
}
