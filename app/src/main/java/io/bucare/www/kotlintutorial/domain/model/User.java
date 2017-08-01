/*
 * Copyright (c) 2016 AXA Group Solutions. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.bucare.www.kotlintutorial.domain.model;

/**
 * Created by joseanmun on 8/2/16.
 */
public class User {
  private int followers;
  private int followings;
  private int uId;
  private String name;
  private String position;
  private String company;
  private String username;
  private String profilePictureURL;
  private String email;

  public User() {
  }

  public int getFollowers() {
    return followers;
  }

  public User setFollowers(int followers) {
    this.followers = followers;
    return this;
  }

  public int getFollowings() {
    return followings;
  }

  public User setFollowings(int followings) {
    this.followings = followings;
    return this;
  }

  public int getuId() {
    return uId;
  }

  public User setuId(int uId) {
    this.uId = uId;
    return this;
  }

  public String getName() {
    return name;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public User setPosition(String position) {
    this.position = position;
    return this;
  }

  public String getCompany() {
    return company;
  }

  public User setCompany(String company) {
    this.company = company;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getProfilePictureURL() {
    return profilePictureURL;
  }

  public User setProfilePictureURL(String profilePictureURL) {
    this.profilePictureURL = profilePictureURL;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }
}
