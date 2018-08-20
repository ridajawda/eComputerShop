package com.onlineclasses.demo.dao;

import com.onlineclasses.demo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUserName(String username);
    
}