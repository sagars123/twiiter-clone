package com.twitter.clone.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.clone.dao.model.PostDetailsEntity;
import com.twitter.clone.service.interfaces.ITwitterManagerService;
import com.twitter.clone.service.model.TwitterApiResponse;


@RestController
@RequestMapping("api/twitter")
public class TwitterController {

  @Autowired
  private ITwitterManagerService twitterManagerService;

  @PostMapping("/createpost")
  public @ResponseBody TwitterApiResponse createPost(@RequestBody String postData, @RequestBody Long userId) {
    return twitterManagerService.createPost(userId, postData);
  }

  @PostMapping("/searchuser")
  public @ResponseBody TwitterApiResponse searchUser(@RequestBody String userName) {
    return twitterManagerService.searchUser(userName);
  }

  @PostMapping("/followuser")
  public @ResponseBody TwitterApiResponse followUser(Long userId, Long userIdToBeFollowed) {
    return twitterManagerService.FollowUser(userId, userIdToBeFollowed);
  }

  @PostMapping("/likePost")
  public @ResponseBody TwitterApiResponse LikeAPost(Long postId, Long userId) {
    return twitterManagerService.LikeaPost(postId, userId);
  }

  @PostMapping("/listallpost")
  public @ResponseBody List<PostDetailsEntity> ListAllPosts(@RequestBody Long userId) {
    return twitterManagerService.ListAllPosts(userId);
  }

}
