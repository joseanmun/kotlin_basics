/*
 * Copyright (c) 2016 AXA Group Solutions. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.bucare.www.kotlintutorial.domain;

/**
 * Created by jofre on 22/07/16.
 */
public class DomainConstants {
  private DomainConstants() {
  }

  public static final class Post {
    public static final int MAX_TEXT_LENGTH = 140;

    private Post() {
    }
  }

  public static final class DevApp {
    public static final int MAX_TAG_LENGTH = 20;
    public static final int MAX_TITLE_LENGTH = 20;
    public static final int MAX_SHORT_DESCR_LENGTH = 50;
    public static final int MAX_LONG_DESCR_LENGTH = 140;
    public static final int MAX_STORES_URL_LENGTH = 150;
    public static final String NOT_ALPHANUMERIC_PLUS_SPACE_REG_EXP = "[^a-zA-Z0-9 ]";

    private DevApp() {
    }
  }

  public static final class Tag {
    public static final char PREFIX = '#';
    public static final String VALID_REG_EXP = PREFIX + "[a-zA-Z0-9_]*";
    public static final String IDENTIFY_REG_EXP = "(^|\\s)" + PREFIX + "([a-zA-Z0-9_]+)";

    private Tag() {
    }
  }

  public static final class Mention {
    public static final char PREFIX = '@';
    public static final String VALID_REG_EXP = PREFIX + "[a-zA-Z0-9_]*";
    public static final String IDENTIFY_REG_EXP = "(^|\\s)" + PREFIX + "([a-zA-Z0-9_]+)";
    public static final int NOT_FOUND = -1;
    public static final int TYPE_DEVAPP = 0;
    public static final int TYPE_USER = 1;

    private Mention() {
    }
  }

  public static final class Suggestion {
    public static final int DELAY_IN_MILLIS = 500;
    public static final char END_SPACE = ' ';

    private Suggestion() {
    }
  }

  public static final class SearchBaseDevApps {
    public static final int DELAY_IN_MILLIS = 500;

    private SearchBaseDevApps() {
    }
  }
}
