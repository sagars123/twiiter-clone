package com.twitter.clone.service.interfaces;

import java.util.List;

import com.twitter.clone.dao.model.PostDetailsEntity;

public interface IPostDetailService {

  public Long createPost(PostDetailsEntity entity);

  public List<PostDetailsEntity> getAllPostByUserId(Long userId);

  public Boolean likePost(Long postId, Long userId);


}
