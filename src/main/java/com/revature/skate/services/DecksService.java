package com.revature.skate.services;

import com.revature.skate.daos.DeckDAO;
import com.revature.skate.models.Decks;

import java.util.List;

public class DecksService {
    private final DeckDAO deckDAO;

    public DecksService(DeckDAO deckDAO) {
        this.deckDAO = deckDAO;
    }

    public void register(Decks deck) {
        deckDAO.save(deck);
    }
    public List<Decks> getAllDecks(){

        return deckDAO.getAll();
    }
}
