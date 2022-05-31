package com.revature.skate.services;

import com.revature.skate.daos.DeckDAO;
import com.revature.skate.daos.UserDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecksServiceTest {
    DecksService deck = new DecksService(new DeckDAO());
    @Test
    void register() {
        assertNotNull(deck);
    }

    @Test
    void getAllDecks() {
        assertNotNull(deck);
    }
}