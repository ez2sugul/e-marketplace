package com.skplanet.sqe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skplanet.sqe.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

}
