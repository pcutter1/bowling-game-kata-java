package com.galvanize.bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameTest {

  @Test
  public void testCreateNewGame(){

    int expected = 0;

    int actual = new Game().getScore();

    assertEquals(expected, actual, "Testing the starting score is 0 for a new game");
  }

  @Test
  public void testBallRollRecorded(){

    Game game = new Game();
    game.rollBall(0);
    game.rollBall(5);
    int expected = 5;
    int actual = game.getRollScores().get(1);
   assertFalse(game.getRollScores().isEmpty());
   assertEquals(expected, actual, "Testing if pins hit are properly stored");
  }

  @Test
  public void testAllGutters() {
    Game game = new Game();
    for (int i = 0; i < 20; i += 1) {
      game.rollBall(0);
    }
    int expected = 0;
    int actual = game.getScore();
    assertEquals(expected, actual, "Testing 20 gutter game score is 0");
  }

  @Test
  public void testAllOnes() {
    Game game = new Game();
    for (int i = 0; i < 20; i += 1) {
      game.rollBall(1);
    }
    int expected = 20;
    int actual = game.getScore();
    assertEquals(expected, actual, "Testing 20 one-pin rolls game score will be 20");
  }

  @Test
  public void testOneSpare() {
    Game game = new Game();
    game.rollBall(5);
    game.rollBall(5);
    game.rollBall(3);
    game.rollBall(3);

    for (int i = 0; i < 17; i++) {
      game.rollBall(0);
    }

    int expected = 19;
    int actual = game.getScore();
    assertEquals(expected, actual, "Testing score of a game with Spare logic");
  }


}