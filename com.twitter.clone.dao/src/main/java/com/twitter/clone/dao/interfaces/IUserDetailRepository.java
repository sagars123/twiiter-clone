package com.twitter.clone.dao.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.twitter.clone.dao.model.UserDetailEntity;

@Repository
public interface IUserDetailRepository extends CrudRepository<UserDetailEntity, Long> {

  @Query("SELECT ude FROM UserDetailEntity ude where id = :id")
  public UserDetailEntity getEntityById(@Param("id") Long id);
  
  @Query("SELECT ude FROM UserDetailEntity ude where userName = :userName")
  public UserDetailEntity getEntityByUserName(@Param("userName") String userName);
}
