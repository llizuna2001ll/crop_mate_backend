package com.brogrammers.cropservice.repositories;

import com.brogrammers.cropservice.entities.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
}