package com.twitter.clone.service.interfaces;

import java.util.List;

import com.twitter.clone.dao.model.PostDetailsEntity;
import com.twitter.clone.service.model.TwitterApiResponse;

public interface ITwitterManagerService {
  /**
   * 
   * @param userId
   * @param postData
   */
  public TwitterApiResponse createPost(Long userId, String postData);

  /**
   * 
   * @param userName
   * @return
   */
  public TwitterApiResponse searchUser(String userName);

  /**
   * 
   * @param userId
   * @param userIdToBeFollowed
   * @return
   */
  public TwitterApiResponse FollowUser(Long userId, Long userIdToBeFollowed);

  /**
   * 
   * @param postId
   * @param userId
   * @return
   */
  public TwitterApiResponse LikeaPost(Long postId, Long userId);

  /**
   * 
   * @param userId
   * @return
   */
  public List<PostDetailsEntity> ListAllPosts(Long userId);


}
