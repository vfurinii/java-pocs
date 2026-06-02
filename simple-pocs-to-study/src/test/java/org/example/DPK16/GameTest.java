package org.example.DPK16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void shouldStartWith10MosquitosAnd1Exterminator() {
        Exterminator exterminator = new Exterminator();
        Game game = new Game(exterminator);

        Mosquito[] mosquitos = game.getMosquitos();

        assertNotNull(mosquitos);
        assertEquals(10, mosquitos.length);

        for (Mosquito mosquito : mosquitos) {
            assertNotNull(mosquito);
        }

        assertNotNull(game.getExterminator());
    }

    @Test
    void shouldCreateMatrix100x100() {
        Game game = new Game(new Exterminator());

        assertNotNull(game.getMatrix());
        assertEquals(100, game.getMatrix().length);
        assertEquals(100, game.getMatrix()[0].length);
    }
}