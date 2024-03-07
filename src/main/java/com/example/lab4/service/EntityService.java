package com.example.lab4.service;/*
  @author   user
  @project   lab4
  @class  EntityService
  @version  1.0.0 
  @since 07.03.2024 - 00.18
*/

import com.example.lab4.dto.EntityDTO;
import com.example.lab4.model.Entity;
import com.example.lab4.repository.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EntityService {
    private final EntityRepository entityRepository;
    private final ModelMapper modelMapper;

    public Entity create(EntityDTO entityDTO){
        Entity entity=modelMapper.map(entityDTO,Entity.class);
        entity.setCreatedAt(LocalDateTime.now());
        return entityRepository.save(entity);
    }
    public List<EntityDTO> getAll(){
        List<Entity> entities=entityRepository.findAll();
        return entities.stream().map(el->modelMapper.map(el,EntityDTO.class)).toList();
    }
    public EntityDTO getOne(String id){
        return modelMapper.map(entityRepository.getEntityById(id), EntityDTO.class);
    }
    public Entity update(EntityDTO entityDTO){
        Entity entity=modelMapper.map(entityDTO,Entity.class);
        entity.setUpdatedAt(LocalDateTime.now());
        return entityRepository.save(entity);
    }
    public void delete(EntityDTO entityDTO){
        Entity entity=modelMapper.map(entityDTO,Entity.class);
        entityRepository.delete(entity);
    }
}
