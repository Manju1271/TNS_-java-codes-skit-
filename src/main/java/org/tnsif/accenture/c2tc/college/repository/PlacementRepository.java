package org.tnsif.accenture.c2tc.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.tnsif.accenture.c2tc.college.entity.Placement;

@Repository
public interface PlacementRepository extends JpaRepository<Placement, Long> {
}
