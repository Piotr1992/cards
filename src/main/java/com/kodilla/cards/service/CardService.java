package com.kodilla.cards.service;

import com.kodilla.cards.dto.Card;
import com.kodilla.cards.dto.CardDto;
import com.kodilla.cards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    public List<Card> getAllCards() {
        return repository.findAll();
    }

    public Optional<Card> getCard(final Long id) {
        return repository.findById(id);
    }

    public List<CardDto> getCardDto(final Long id) {
        return repository.findByIdDto(id);
    }

    public void save(Card card) {
        repository.save(card);
    }

}