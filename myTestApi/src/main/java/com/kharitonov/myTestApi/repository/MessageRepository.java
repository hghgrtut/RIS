package com.kharitonov.myTestApi.repository;

import com.kharitonov.myTestApi.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Override
    List<Message> findAll();

    @Override
    <S extends Message> S save(S entity);

    @Override
    Optional<Message> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void delete(Message entity);
}
