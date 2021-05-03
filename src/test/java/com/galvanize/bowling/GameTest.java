package com.galvanize.bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  public void testUpdateRollCount() {

    Game game = new Game();
    game.rollBall(2);
    game.rollBall(4);
    game.rollBall(6);
    game.rollBall(7);

    int expected = 5;
    int actual = game.getRollScoreIndex();


    assertEquals(expected, actual, "After 4 rolls excluding strikes, frame count should be 5");
  }



//  @Test
//  public void testFrameExistence() {
//    Game game = new Game();
//    int expected = 10;
//    int actual = game.getFrames().length;
//
//    assertEquals(expected, actual, "testing the game is 10 frames long");
//  }

//  @Test
//  public void testRollBallAddToFrameRoll1() {
//    Game game = new Game();
//    game.rollBall(4);
//
//    int expected = 4;
//    int actual = game.getFrames()[0].roll1;
//
//    assertEquals(expected, actual, "testing to see if first roll goes into first frame roll1");
//  }

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

//  @Test
//  public void testSpareBonusTrigger(){
//    Game game = new Game();
//    game.rollBall(7);
//    game.rollBall(3);
//
//    boolean actual = game.spareBonusActive();
//
//    assertTrue(actual);
//  }

//  @Test
//  public void testStrikeBonusTrigger(){
//    Game game = new Game();
//    game.rollBall(10);
//
//
//    boolean actual = game.strikeBonusActive();
//
//    assertTrue(actual);
//  }
//
//  @Test
//  public void testStrikeBonusTrigger2(){
//    Game game = new Game();
//    game.rollBall(0);
//    game.rollBall(10);
//
//
//    boolean actual = game.strikeBonusActive();
//
//    assertFalse(actual);
//  }

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

  @Test
  public void testOneStrike() {

    Game game = new Game();
    game.rollBall(10);
    game.rollBall(3);
    game.rollBall(3);

    for (int i = 0; i < 16; i++) {
      game.rollBall(0);
    }

    int expected = 22;
    int actual = game.getScore();
    assertEquals(expected, actual, "Testing score of a game with Strike logic");

  }

  @Test
  public void testPerfectGame() {

    Game game = new Game();
    for (int i = 0; i < 10; i++) {
      game.rollBall(10);
    }

    int expected = 300;
    int actual = game.getScore();

    assertEquals(expected, actual, "10 consecutive strikes should yield a score of 300");
  }


}