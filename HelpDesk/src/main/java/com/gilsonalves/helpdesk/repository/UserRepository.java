package com.gilsonalves.helpdesk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gilsonalves.helpdesk.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

	User findByEmail(String email);
}
