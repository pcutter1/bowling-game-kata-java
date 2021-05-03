package com.galvanize.bowling;

import java.util.ArrayList;

public class Game {

  private int score;
  private final ArrayList<Integer> rollScores = new ArrayList<>();
  private int rollScoreIndex = 1;
  private int frameRollIndex = 1;

  public Game() {

  }

  public void rollBall(int pinsHit){
    rollScores.add(pinsHit);
    updateScore(frameRollIndex, pinsHit);
    if (frameRollIndex % 2 == 1 && pinsHit == 10){
      frameRollIndex++;
    }
    updateRollCount();
  }

  void updateRollCount(){
    rollScoreIndex++;
    frameRollIndex++;
  }

  void updateScore(int rollIndex, int pinsHit) {

    int totalAdd = pinsHit;

    if (rollIndex > 2 && rollIndex % 2 == 1
        && rollScores.get(rollIndex - 2) + rollScores.get(rollIndex -3) == 10){
      totalAdd+= pinsHit;
    }

    if (rollIndex > 2 && rollIndex % 2 == 1 && rollScores.get(rollIndex -3) == 10) {
      totalAdd += rollScores.get(rollScoreIndex - 1) + pinsHit;
    }


    score += totalAdd;
  }

  public int getRollScoreIndex() {
    return rollScoreIndex;
  }

  public ArrayList<Integer> getRollScores() {
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
