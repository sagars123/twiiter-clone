package com.twitter.clone.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.twitter.clone.dao.model.PostDetailsEntity;

@Repository
public interface IPostDetailsRepository extends CrudRepository<PostDetailsEntity, Long> {

  @Query("SELECT pde FROM PostDetailsEntity pde where id = :id")
  public PostDetailsEntity getEntityById(@Param("id") Long id);
  
  @Query("SELECT pde FROM PostDetailsEntity pde where userId = :userId")
  public List<PostDetailsEntity> getEntityByUserId(@Param("userId") Long userId);
  
}