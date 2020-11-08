package com.twitter.clone.service.interfaces;

import com.twitter.clone.dao.model.UserDetailEntity;

public interface IUserDetailsService {
  
  public Long createUser(UserDetailEntity entity);
  public UserDetailEntity getUser(String userName);
    

}
