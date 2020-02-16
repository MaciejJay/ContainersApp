package com.containers.service;

import com.containers.exceptions.UserNotFoundException;
import com.containers.model.User;
import com.containers.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Autowired
    private UserService sut;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void shouldAddNewUser() {
        // given
        User user = new User("usernameTest", "firstNameTest",
                "lastNameTest", "eMailTest@test.com");

        // when
        User addedUser = sut.saveUser(user);

        // then
        assertThat(addedUser.getUsername()).isEqualTo("usernameTest");
    }

    @Test
    public void shouldFindUserByUsername() {
        // when
        User user = sut.getUserByUsername("username");

        // then
        assertThat(user.getUsername().equals("username"));
    }

    @Test
    public void shouldThrowUserNotFoundException() {
        // then
        assertThatThrownBy(
                () -> sut.getUserByUsername("thisUsernameDoesNotExist"))
                .isInstanceOf(UserNotFoundException.class);
    }
}