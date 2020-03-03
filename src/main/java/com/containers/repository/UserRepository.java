package com.containers.repository;

import com.containers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT u FROM User u WHERE u.username LIKE '%' || :keyword || '%'"
            + " OR u.firstName LIKE '%' || :keyword || '%'"
            + " OR u.lastName LIKE '%' || :keyword || '%'")
    List<User> search(@Param("keyword") String keyword);

}
