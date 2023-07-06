package com.phonecontacts.repository;

import com.phonecontacts.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PhoneRepository")
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
