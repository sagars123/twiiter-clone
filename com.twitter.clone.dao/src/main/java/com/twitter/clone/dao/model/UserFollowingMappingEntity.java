package com.twitter.clone.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "user_following mapping")
public class UserFollowingMappingEntity implements Serializable{

  /**
   * 
   */
  
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long baseUserId;
  private Long followedUserId;
  private Boolean isActive;
  private Date createdOn;
  private Date updatedOn;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Long getBaseUserId() {
    return baseUserId;
  }
  public void setBaseUserId(Long baseUserId) {
    this.baseUserId = baseUserId;
  }
  public Long getFollowedUserId() {
    return followedUserId;
  }
  public void setFollowedUserId(Long followedUserId) {
    this.followedUserId = followedUserId;
  }
  public Boolean getIsActive() {
    return isActive;
  }
  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }
  public Date getCreatedOn() {
    return createdOn;
  }
  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }
  public Date getUpdatedOn() {
    return updatedOn;
  }
  public void setUpdatedOn(Date updatedOn) {
    this.updatedOn = updatedOn;
  }
  @Override
  public String toString() {
    return "UserFollowingMappingEntity [id=" + id + ", baseUserId=" + baseUserId
        + ", followedUserId=" + followedUserId + ", isActive=" + isActive + ", createdOn="
        + createdOn + ", updatedOn=" + updatedOn + "]";
  }
  
  

}
