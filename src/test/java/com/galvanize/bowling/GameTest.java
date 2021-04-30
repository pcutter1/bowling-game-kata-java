package com.galvanize.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GameTest {

  @Test
  public void testCreateNewGame(){

    int expected = 0;

    int actual = new Game().score;

    assertEquals(expected, actual, "Testing the starting score is 0 for a new game");
  }

  @Test
  public void testBallRollRecorded(){

    Game game = new Game();
    game.rollBall();

    assertTrue(game.frames)

  }

}