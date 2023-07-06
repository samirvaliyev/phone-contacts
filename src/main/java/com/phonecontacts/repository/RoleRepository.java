package com.phonecontacts.repository;

import com.phonecontacts.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("RoleRepository")
public interface RoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findOneById(long id);
}
