package org.tnsif.accenture.c2tc.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.tnsif.accenture.c2tc.college.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
}
