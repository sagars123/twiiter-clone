package com.twitter.clone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.clone.dao.interfaces.IUserFollowingMappingRepository;
import com.twitter.clone.dao.model.UserFollowingMappingEntity;
import com.twitter.clone.service.interfaces.IUserFollowingMappingService;

@Service
public class UserFollowingMappingService implements IUserFollowingMappingService {

  @Autowired
  private IUserFollowingMappingRepository userFollowingMappingRepository;

  @Override
  public Long createUserfollowingMapping(UserFollowingMappingEntity entity) {

    userFollowingMappingRepository.save(entity);
    return entity.getId();
  }


}
