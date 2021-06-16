package com.kodilla.cards.repository;

import com.kodilla.cards.dto.Card;
import com.kodilla.cards.dto.CardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Override
    List<Card> findAll();

    @Override
    Card save(Card task);

    @Override
    Optional<Card> findById(Long id);

    List<CardDto> findByIddto(Long id);

    void deleteById(Long id);

}