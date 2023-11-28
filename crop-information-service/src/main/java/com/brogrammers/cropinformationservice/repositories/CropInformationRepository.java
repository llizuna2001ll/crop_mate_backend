package com.brogrammers.cropinformationservice.repositories;

import com.brogrammers.cropinformationservice.entities.CropInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropInformationRepository extends JpaRepository<CropInformation, Long> {
}