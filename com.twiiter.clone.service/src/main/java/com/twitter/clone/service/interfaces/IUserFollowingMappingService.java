package com.twitter.clone.service.interfaces;

import com.twitter.clone.dao.model.UserFollowingMappingEntity;

public interface IUserFollowingMappingService {
  
  public Long createUserfollowingMapping(UserFollowingMappingEntity entity);
  

}
