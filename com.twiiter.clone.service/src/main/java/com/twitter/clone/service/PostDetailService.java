package com.twitter.clone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.clone.dao.interfaces.IPostDetailsRepository;
import com.twitter.clone.dao.model.PostDetailsEntity;
import com.twitter.clone.service.interfaces.IPostDetailService;

@Service
public class PostDetailService implements IPostDetailService {

  @Autowired
  private IPostDetailsRepository postDetailsRepository;


  @Override
  public Long createPost(PostDetailsEntity entity) {

    postDetailsRepository.save(entity);
    return entity.getId();
  }

  @Override
  public List<PostDetailsEntity> getAllPostByUserId(Long userId) {

    return postDetailsRepository.getEntityByUserId(userId);

  }

  @Override
  public Boolean likePost(Long postId, Long userId) {

    Long totalLikes;
    PostDetailsEntity postDetailsEntity = postDetailsRepository.getEntityById(postId);

    totalLikes = postDetailsEntity.getTotalLikes();
    totalLikes++;
    postDetailsEntity.setTotalLikes(totalLikes);

    // add update
    postDetailsRepository.save(postDetailsEntity);

    return true;
  }

}
