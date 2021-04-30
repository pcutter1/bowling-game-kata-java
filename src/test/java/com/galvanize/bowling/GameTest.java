package com.galvanize.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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

   assertFalse(game.getRollScores().isEmpty());

  }

}