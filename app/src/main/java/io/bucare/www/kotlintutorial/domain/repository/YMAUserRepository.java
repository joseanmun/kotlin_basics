package io.bucare.www.kotlintutorial.domain.repository;

import io.bucare.www.kotlintutorial.domain.model.User;

public interface YMAUserRepository {
  User get(String username) throws RepositoryException;
  boolean update(User user);
}
