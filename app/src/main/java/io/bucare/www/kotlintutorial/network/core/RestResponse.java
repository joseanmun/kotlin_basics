/*
 * Copyright (c) 2016 AXA Group Solutions. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.bucare.www.kotlintutorial.network.core;

import retrofit2.Response;

/**
 * Created by jofre on 4/07/16.
 */
public class RestResponse<T> {
  private final boolean isSuccessful;
  private T body;
  private RestError error;

  public RestResponse(boolean isSuccessful, T body, RestError error) {
    this.isSuccessful = isSuccessful;
    this.body = body;
    this.error = error;
  }

  public RestResponse(Response<T> response) {
    boolean isCallSuccessful, isBodySuccessful = false;
    isCallSuccessful = response.isSuccessful();

    if (isCallSuccessful) {
      body = response.body();
      isBodySuccessful = ((BaseResponse) body).isSuccesful();
      if (!isBodySuccessful) {
        error = new RestError(((BaseResponse) body).getStatus()
                                  .getCode(),
                              ((BaseResponse) body).getStatus()
                                  .getMessage());
      }
    } else {
      error = new RestError(response.code(),
                            response.message());
    }
    isSuccessful = isCallSuccessful && isBodySuccessful;
  }

  public RestResponse(Exception e) {
    isSuccessful = false;
    error = new RestError(e);
  }

  public boolean isSuccessful() {
    return isSuccessful;
  }

  public T getBody() {
    return body;
  }

  public RestError getError() {
    return error;
  }
}
