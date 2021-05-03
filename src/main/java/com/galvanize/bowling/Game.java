package com.galvanize.bowling;

public class Game {

  private int score;
  private final int[] rollScores = new int[21];
  private int rollScoreIndex = 0;

  public Game() {

  }

  public void rollBall(int pinsHit){
    rollScores[rollScoreIndex++] = pinsHit;
  }

  public void rollBall(int... rollScores) {
    for (int pinsHit : rollScores) {
      rollBall(pinsHit);
    }
    updateScore();
  }

  public void updateScore() {
    int frameIndex = 0;
    int totalAdd = 0;
    for(int frame = 0; frame < 10; frame++) {
      if (rollScores[frameIndex] == 10 && frameIndex < 19) {
        totalAdd += rollScores[frameIndex] + rollScores[frameIndex + 1] + rollScores[frameIndex + 2];
        frameIndex++;
      } else if (frameIndex < 19 && rollScores[frameIndex] + rollScores[frameIndex + 1] == 10) {
          totalAdd += 10 + rollScores[frameIndex + 2];
          frameIndex++;
        } else {
        totalAdd += rollScores[frameIndex] + rollScores[frameIndex + 1];
        frameIndex ++;
      }
    }

    score += totalAdd;
  }

  public int getRollScoreIndex() {
    return rollScoreIndex;
  }

  public int[] getRollScores() {
    return rollScores;
  }

  public int getScore() {
    return score;
  }

//  public boolean spareBonusActive() {
//    return spareBonus;
//  }
//
//  public boolean strikeBonusActive() {
//    return strikeBonus;
//  }
}
