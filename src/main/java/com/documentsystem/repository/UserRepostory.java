package com.documentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.documentsystem.entity.User;


@Repository
public interface UserRepostory extends JpaRepository<User, String> {

    }