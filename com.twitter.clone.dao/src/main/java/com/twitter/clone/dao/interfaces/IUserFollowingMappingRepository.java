package com.twitter.clone.dao.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.twitter.clone.dao.model.UserFollowingMappingEntity;

public interface IUserFollowingMappingRepository extends CrudRepository<UserFollowingMappingEntity, Long> {

  @Query("SELECT ufme FROM UserFollowingMappingEntity ufme where id = :id")
  public UserFollowingMappingEntity getEntityById(@Param("id") Long id);

}
