package com.phonecontacts.repository;

import com.phonecontacts.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("EmailRepository")
public interface EmailRepository extends JpaRepository<Email, Long> {
}
