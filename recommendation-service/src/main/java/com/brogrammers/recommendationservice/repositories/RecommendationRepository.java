package com.brogrammers.recommendationservice.repositories;

import com.brogrammers.recommendationservice.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    Recommendation getRecommendationByLandId(Long id);
    List<Recommendation> getAllByLandId(Long id);
}