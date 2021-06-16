package com.kodilla.cards.controller;

import com.kodilla.cards.dto.Card;
import com.kodilla.cards.dto.CardDto;
import com.kodilla.cards.mapper.CardMapper;
import com.kodilla.cards.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1/cards")
@RequiredArgsConstructor
public class CardsController {

    @Value("${application.allow-get-cards}")
    private boolean allowGetCards;

    private final CardService cardService;

    private final CardMapper cardMapper;

    @GetMapping(value = "/{customerId}")
    public GetCardsResponse getCards(@PathVariable("customerId") Long customerId) {
        log.info("Get cards for customerId: {}", customerId);
        if(!allowGetCards) {
            log.info("Getting cards is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting cards is disabled");
        }

        List<CardDto> cards = cardMapper.mapToCardDtoList(List.of(cardService.getCard(customerId).orElse(new Card())));
        log.info("Card TEST!");
//        CardDto cards = cardMapper.mapToCardDto(cardService.getCard(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

//        return GetCardsResponse.of(cards);
        return null;
    }

}