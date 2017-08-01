package io.bucare.www.kotlintutorial.network.model;

import com.google.gson.annotations.SerializedName;
import io.bucare.www.kotlintutorial.domain.model.User;

public class RestUser {
  @SerializedName("uId") private int uId;
  @SerializedName("followers") private int followers;
  @SerializedName("followings") private int followings;
  @SerializedName("name") private String name;
  @SerializedName("position") private String position;
  @SerializedName("company") private String company;
  @SerializedName("username") private String username;
  @SerializedName("iconURL") private String profilePictureURL;
  @SerializedName("email") private String email;

  public RestUser(User user) {
    this.uId = user.getuId();
    this.name = user.getName();
    this.position = user.getPosition();
    this.company = user.getCompany();
    this.profilePictureURL = user.getProfilePictureURL();
    this.username = user.getUsername();
    this.email = user.getEmail();
  }

  public int getuId() {
    return uId;
  }

  public int getFollowers() {
    return followers;
  }

  public int getFollowings() {
    return followings;
  }

  public String getName() {
    return name;
  }

  public String getPosition() {
    return position;
  }

  public String getCompany() {
    return company;
  }

  public String getUsername() {
    return username;
  }

  public String getProfilePictureURL() {
    return profilePictureURL;
  }

  public String getEmail() {
    return email;
  }

  public User toUser() {
    return new User().setuId(getuId())
        .setName(getName())
        .setCompany(getCompany())
        .setEmail(getEmail())
        .setFollowers(getFollowers())
        .setFollowings(getFollowings())
        .setPosition(getPosition())
        .setProfilePictureURL(getProfilePictureURL())
        .setUsername(getUsername());
  }
}
