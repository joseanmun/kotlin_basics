package io.bucare.www.kotlintutorial.network.repository;

import io.bucare.www.kotlintutorial.domain.model.User;
import io.bucare.www.kotlintutorial.domain.repository.RepositoryException;
import io.bucare.www.kotlintutorial.domain.repository.YMAUserRepository;
import io.bucare.www.kotlintutorial.network.core.BaseResponse;
import io.bucare.www.kotlintutorial.network.core.RestResponse;
import io.bucare.www.kotlintutorial.network.model.RestUser;
import io.bucare.www.kotlintutorial.network.services.UserService;

public class YMAUserRepositoryImpl implements YMAUserRepository {
  private final UserService userService;

  public YMAUserRepositoryImpl(UserService userService) {
    this.userService = userService;
  }

  @Override public User get(String username) throws RepositoryException {
    RestResponse<BaseResponse<RestUser>> response = userService.getUser(username)
        .execute();
    if (!response.isSuccessful()) {
      if (!response.isSuccessful()) {
        throw new RepositoryException(response.getError()
                                          .getStrMessage(),
                                      response.getError()
                                          .getCode());
      }
    }
    return response.getBody()
        .getData()
        .toUser();
  }

  @Override public boolean update(User user) {
    RestUser restUser = new RestUser(user);
    final RestResponse<BaseResponse> response = userService.updateUser(restUser)
        .execute();
    return response.isSuccessful();
  }
}
