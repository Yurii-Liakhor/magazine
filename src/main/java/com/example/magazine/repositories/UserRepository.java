package com.example.magazine.repositories;

import com.example.magazine.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserById(Long id);
    Long removeUserById(Long id);
    User findUserByLogin(String login);

    boolean existsUserByLogin(String login);
    //todo add user
}