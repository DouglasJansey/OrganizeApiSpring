package com.organize.myorganize.repository;

import com.organize.myorganize.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByEmail(String email);

    Optional<UserModel> findByPhone(int phone);
}
