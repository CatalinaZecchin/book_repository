package com.bibliophile.book_repository.repository;

import com.bibliophile.book_repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
