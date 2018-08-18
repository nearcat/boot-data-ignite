package com.github.iyboklee.repository;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import com.github.iyboklee.model.User;

@RepositoryConfig(cacheName = "users_cache")
public interface UserRepository extends IgniteRepository<User, Long> {

    User findByName(String name);

}
