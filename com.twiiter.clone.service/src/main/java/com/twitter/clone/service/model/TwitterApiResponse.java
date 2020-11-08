package com.twitter.clone.service.model;

import java.io.Serializable;

public class TwitterApiResponse implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private Boolean error;
  private String message;

  public Boolean getError() {
    return error;
  }

  public void setError(Boolean error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "TwitterApiResponse [error=" + error + ", message=" + message + "]";
  }


}
