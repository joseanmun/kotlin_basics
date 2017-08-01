/*
 * Copyright (c) 2016 AXA Group Solutions. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.bucare.www.kotlintutorial.domain.repository;

/**
 * Created by jofre on 7/07/16.
 */
public class RepositoryException extends Exception {
  private final int errorCode;

  public RepositoryException(int errorCode) {
    this.errorCode = errorCode;
  }

  public RepositoryException(String detailMessage, Throwable throwable, int errorCode) {
    super(detailMessage,
          throwable);
    this.errorCode = errorCode;
  }

  public RepositoryException(Throwable throwable, int errorCode) {
    super(throwable);
    this.errorCode = errorCode;
  }

  public RepositoryException(String detailMessage, int errorCode) {
    super(detailMessage);
    this.errorCode = errorCode;
  }

  public int getErrorCode() {
    return errorCode;
  }
}
