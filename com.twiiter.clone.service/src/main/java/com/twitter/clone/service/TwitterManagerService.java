package com.twitter.clone.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.clone.dao.model.PostDetailsEntity;
import com.twitter.clone.dao.model.UserFollowingMappingEntity;
import com.twitter.clone.service.interfaces.ITwitterManagerService;
import com.twitter.clone.service.model.TwitterApiResponse;

@Service
public class TwitterManagerService implements ITwitterManagerService {

  @Autowired
  private PostDetailService postDetailService;

  @Autowired
  private UserDetailService userDetailService;

  @Autowired
  private UserFollowingMappingService userFollowingMappingService;

  @Override
  public TwitterApiResponse createPost(Long userId, String postData) {
    TwitterApiResponse twitterApiResponse = new TwitterApiResponse();

    Date myDate = new Date();
    DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String mdy = df2.format(myDate);
    try {
      if (postData != null && userId != null) {
        PostDetailsEntity postDetailsEntity = new PostDetailsEntity();
        postDetailsEntity.setPostData(postData);
        postDetailsEntity.setUserId(userId);
        postDetailsEntity.setIsActive(true);
        postDetailsEntity.setTotalLikes(0L);
        postDetailsEntity.setCreatedOn(mdy);
        postDetailService.createPost(postDetailsEntity);
        twitterApiResponse.setError(false);
        twitterApiResponse.setMessage("Post successfully created");
      }
    } catch (Exception e) {
      twitterApiResponse.setError(true);
      twitterApiResponse.setMessage(e.toString());
    }
    return twitterApiResponse;

  }

  @Override
  public TwitterApiResponse searchUser(String userName) {
    TwitterApiResponse twitterApiResponse = new TwitterApiResponse();
    long userId = 0l;

    try {
      if (userName != null) {
        userId = userDetailService.getUser(userName).getId();
        if (userId > 0) {
          twitterApiResponse.setError(false);
          twitterApiResponse.setMessage("User Found with" + userId);
        }
      }
    } catch (Exception e) {
      twitterApiResponse.setError(true);
      twitterApiResponse.setMessage(e.toString());
    }
    return null;
  }

  @Override
  public TwitterApiResponse FollowUser(Long userId, Long userIdToBeFollowed) {
    TwitterApiResponse twitterApiResponse = new TwitterApiResponse();
    // to add check whether these userid exist or not
    try {
      UserFollowingMappingEntity userFollowingMappingEntity = new UserFollowingMappingEntity();

      userFollowingMappingEntity.setBaseUserId(userId);
      userFollowingMappingEntity.setFollowedUserId(userIdToBeFollowed);
      userFollowingMappingEntity.setIsActive(true);
      userFollowingMappingEntity.setCreatedOn(new Date());
      userFollowingMappingService.createUserfollowingMapping(userFollowingMappingEntity);
      twitterApiResponse.setError(false);
      twitterApiResponse.setMessage("User Successfully followed");
    } catch (Exception e) {
      twitterApiResponse.setError(true);
      twitterApiResponse.setMessage(e.toString());
    }
    return twitterApiResponse;
  }

  @Override
  public TwitterApiResponse LikeaPost(Long postId, Long userId) {
    TwitterApiResponse twitterApiResponse = new TwitterApiResponse();
    try {
      if (postId != null && userId != null) {
        if (postDetailService.likePost(postId, userId)) {
          twitterApiResponse.setError(false);
          twitterApiResponse.setMessage("post successfully liked");
        }
      }
    } catch (Exception e) {
      twitterApiResponse.setError(true);
      twitterApiResponse.setMessage(e.toString());
    }
    return twitterApiResponse;
  }

  @Override
  public List<PostDetailsEntity> ListAllPosts(Long userId) {
    TwitterApiResponse twitterApiResponse = new TwitterApiResponse();
    List<PostDetailsEntity> postDetailsEntityList = new ArrayList<>();

    if (userId != null) {
      postDetailsEntityList = postDetailService.getAllPostByUserId(userId);
    }

    return postDetailsEntityList;
  }



}
