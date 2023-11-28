package com.brogrammers.landservice.repositories;

import com.brogrammers.landservice.entities.Land;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandRepository extends JpaRepository<Land, Long> {
    Land findByUserId(Long id);
    List<Land> findAllByUserId(Long id);
}