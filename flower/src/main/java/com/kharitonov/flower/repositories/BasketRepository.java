package com.kharitonov.flower.repositories;

import com.kharitonov.flower.entities.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<BasketEntity, Long> {
}
