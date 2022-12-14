package com.fztrck.apiLibrary.repository;

import com.fztrck.apiLibrary.model.entity.User;
import com.fztrck.apiLibrary.model.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository  extends JpaRepository<UserDetails, Long>{
    Optional<UserDetails> findByUserId(User user);
}
