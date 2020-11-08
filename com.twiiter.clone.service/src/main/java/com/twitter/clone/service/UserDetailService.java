package com.twitter.clone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.clone.dao.interfaces.IUserDetailRepository;
import com.twitter.clone.dao.model.UserDetailEntity;
import com.twitter.clone.service.interfaces.IUserDetailsService;

@Service
public class UserDetailService implements IUserDetailsService {

  @Autowired
  private IUserDetailRepository userDetailRepository;

  @Override
  public Long createUser(UserDetailEntity entity) {

    userDetailRepository.save(entity);
    return entity.getId();
  }

  @Override
  public UserDetailEntity getUser(String userName) {
    return userDetailRepository.getEntityByUserName(userName);
  }

}
