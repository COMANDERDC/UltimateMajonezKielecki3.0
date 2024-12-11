package org.example.ketchup;

import org.example.ketchup.models.Game;
import org.example.ketchup.repositories.GameRepository;
import org.example.ketchup.services.GameService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GameServiceUnitTest {

    private final GameRepository gameRepository = Mockito.mock(GameRepository.class);
    private final GameService gameService = new GameService(gameRepository);

    @Test
    void testGetGameById() {
        Game game = new Game();
        game.setId("1");
        game.setTitle("Test Game");

        when(gameRepository.findById("1")).thenReturn(Optional.of(game));

        Optional<Game> result = gameService.getGameById("1");

        assertEquals("Test Game", result.orElseThrow().getTitle());
        verify(gameRepository, times(1)).findById("1");
    }

    @Test
    void testCreateGame() {
        Game game = new Game();
        game.setTitle("New Game");

        when(gameRepository.save(game)).thenReturn(game);

        Game result = gameService.createGame(game);

        assertEquals("New Game", result.getTitle());
        verify(gameRepository, times(1)).save(game);
    }
}
