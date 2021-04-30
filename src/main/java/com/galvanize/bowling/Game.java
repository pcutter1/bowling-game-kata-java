package com.galvanize.bowling;

import java.util.ArrayList;

public class Game {

  private int score;
  private final ArrayList<Integer> rollScores = new ArrayList<>();

  public void rollBall(int pinsHit){
    rollScores.add(pinsHit);
  }


  public ArrayList<Integer> getRollScores() {
    return rollScores;
  }

  public int getScore() {
    return score;
  }
}
