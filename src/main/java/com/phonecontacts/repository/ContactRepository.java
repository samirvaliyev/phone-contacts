package com.phonecontacts.repository;

import com.phonecontacts.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ContactRepository")
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
