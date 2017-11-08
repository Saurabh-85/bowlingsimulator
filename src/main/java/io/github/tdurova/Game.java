package io.github.tdurova;

public class Game
{
    private int[] rolls = new int[21];
    private int rollsIndex = 0;
    private int currentFrameIndex = 0;
    private boolean gameOver = false;


    /**
     * indicates game is over
     * @return boolean
     */
    public boolean isFinished() {
        return gameOver;
    }

    public void roll(int pins) {

        rolls[rollsIndex++] = pins;
    }

    public int scoreGame() {
        int score = 0;

        for (int frame = 0 ; frame < 10 ; frame++) {
            score += scoreFrame();
        }

        return score;
    }

    private int scoreFrame() {
        int score = 0;

        if (isSpare()) {
            score += addSpareBonus();
            currentFrameIndex += 2;
        } else if (isStrike()) {
            score += addStrikeBonus();
            currentFrameIndex++;
        } else {
            score += sumRolls();
            currentFrameIndex += 2;
        }

        return score;
    }

    private boolean isSpare() {
        return rolls[currentFrameIndex] + rolls[currentFrameIndex +1] == 10;
    }

    private boolean isStrike() {
        return rolls[currentFrameIndex] == 10;
    }

    private int addSpareBonus() {
        return 10 + rolls[currentFrameIndex +2];
    }

    private int addStrikeBonus() {
        return 10 + rolls[currentFrameIndex +1] + rolls[currentFrameIndex +2];
    }

    private int sumRolls() {
        return rolls[currentFrameIndex] + rolls[currentFrameIndex +1];
    }
}
