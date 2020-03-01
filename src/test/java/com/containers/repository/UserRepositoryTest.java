package com.containers.repository;

import com.containers.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository sut;

    @Test
    public void shouldReturnUserWithUsernameWichni() {
        // when
        Optional<User> actual = sut.findById("wichni");

        // then
        assertThat(actual).isPresent();
    }

}