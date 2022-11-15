package com.kharitonov.flower.repositories;

import com.kharitonov.flower.entities.FlowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<FlowerEntity, Long> {
}
