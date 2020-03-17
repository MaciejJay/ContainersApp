package com.containers.repository;

import com.containers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT u FROM User u WHERE u.wasReleased = false GROUP BY u.username")
    Set<User> findUsersByWasReleasedFalse();

    @Query(value = "SELECT u FROM User u WHERE u.wasReleased = true")
    Set<User> findUsersByWasReleasedTrue();

    @Transactional
    @Modifying
    @Query(value = "UPDATE User u " +
            "SET u.password=null, u.wasReleased=true\n" +
            "\tWHERE u.username = :username ")
    void deleteUserFromPrimaryListAndAddUserToWasReleasedList(String username);
}
