package com.bookmypark.api.booking.repository;

import com.bookmypark.api.booking.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

}
