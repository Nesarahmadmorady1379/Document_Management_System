package com.Documents.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Documents.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    }

	



