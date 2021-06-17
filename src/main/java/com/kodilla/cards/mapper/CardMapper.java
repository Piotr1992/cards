package com.kodilla.cards.mapper;

import com.kodilla.cards.dto.Card;
import com.kodilla.cards.dto.CardDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardMapper {

    public CardDto mapToCardDto(final Card card) {
        return new CardDto(
                card.getIdDto(),
                card.getTypeCard()
        );
    }

    public List<CardDto> mapToCardDtoList(final List<Card> cardList) {
        return cardList.stream()
                .map(this::mapToCardDto)
                .collect(Collectors.toList());
    }

    public Card mapToCard(CardDto card) {
        return new Card(card.getId(), card.getTypeCard());
    }

}
