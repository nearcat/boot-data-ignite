package com.github.iyboklee;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.github.iyboklee.model.User;
import com.github.iyboklee.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired private ConfigurableApplicationContext context;

    @Autowired private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        fillRepository();

        log.info(".... Find user by id");
        findOne(2L);

        log.info(".... Find user by name");
        findUser("Lee");

        log.info(".... Find all user");
        findAll();

        System.exit(SpringApplication.exit(context));
    }

    private void fillRepository() {
        Map<Long, User> users = new HashMap<>();
        users.put(1L, new User(1L, "Lee", 1000));
        users.put(2L, new User(2L, "Kim", 2000));
        users.put(3L, new User(3L, "Park", 3000));

        userRepository.save(users);
    }

    private void findOne(Long userId) {
        User user = userRepository.findOne(userId);

        log.info("Find user by `{}`: {}", userId, user);
    }

    private void findUser(String name) {
        User user = userRepository.findByName(name);

        log.info("Find user by `{}`: {}", name, user);
    }

    private void findAll() {
        for (User user : userRepository.findAll()) {
            log.info("{}", user);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
