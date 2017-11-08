package io.github.tdurova;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Game.
 */
public class GameTest
{
    private Game game;

    private void rollRemaining(int n, int pins) {
        for (int i = 0; i < n ; i++) {
            game.roll(pins);
        }
    }

    @BeforeEach
    public void setUp() {
        this.game = new Game();
    }

    @Test
    public void given_TenFramePlayed_WhenOnlyOnePinIsRolledEachTime_ThenTheFinalIsScoreTen() {
        for (int frame = 0 ; frame < 10 ; frame++) {
            game.roll(1);
            game.roll(0);
        }
        assertEquals(10, game.scoreGame());
    }

    @Test
    public void shouldScoreAFrameOfZero() {
        game.roll(0);
        game.roll(0);
        assertEquals(0,game.scoreGame());
    }

    @Test
    public void rollAllFrames(){
        for (int i = 0 ; i < 20 ; i++) {
            game.roll(1);
        }
        assertEquals(20, game.scoreGame());
    }

    @Test
    public void shouldReturnASpare() {
        game.roll(6);
        game.roll(4);
        game.roll(5);
        rollRemaining(18,0);
        assertEquals(20,game.scoreGame());
    }

    @Test
    public void shouldReturnAStrike() {
        game.roll(10);
        game.roll(4);
        game.roll(3);

        rollRemaining(17,0);
        assertEquals(24,game.scoreGame());
    }

    @Test
    public void gutterGame() {
        rollRemaining(20, 0);

        assertEquals(game.scoreGame(), 0);
    }

    @Test
    public void allOnes() {
        rollRemaining(20, 1);

        assertEquals(game.scoreGame(), 20);
    }

    @Test
    public void oneSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollRemaining( 17, 0);

        assertEquals(game.scoreGame(), 16);
    }

    @Test
    public void falseSpare() {
        // if the scores that total to 10 are not in the same frame, it is not a spare.
        game.roll(0);
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollRemaining( 16, 0);

        assertEquals(game.scoreGame(), 13);
    }

    @Test
    public void oneStrike() {
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollRemaining( 16, 0);

        assertEquals(game.scoreGame(), 24);
    }

    @Test
    public void gutterAndTenMeansSpare() {
        game.roll(0);
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollRemaining( 16, 0);

        assertEquals(game.scoreGame(), 20);
    }

    @Test
    public void strikeFollowedBySpare() {
        game.roll(10);
        game.roll(3);
        game.roll(7);
        game.roll(4);
        game.roll(4);
        rollRemaining( 14, 0);

        assertEquals(game.scoreGame(), 42);
    }

    @Test
    public void strikeFollowedByStrike() {
        game.roll(10);
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollRemaining( 14, 0);

        assertEquals(game.scoreGame(), 47);
    }

    @Test
    public void spareFollowedBySpare() {
        game.roll(3);
        game.roll(7);
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollRemaining( 14, 0);

        assertEquals(game.scoreGame(), 44);
    }

    @Test
    public void spareFollowedByStrike() {
        game.roll(3);
        game.roll(7);
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollRemaining( 14, 0);

        assertEquals(game.scoreGame(), 44);
    }

    @Test
    public void lasFrameNormalCase() {
        rollRemaining(18, 0);
        game.roll(3);
        game.roll(4);

        assertEquals(game.scoreGame(), 7);
    }

    @Test
    public void lastFrameSpare() {
        rollRemaining(18, 0);
        game.roll(3);
        game.roll(7);
        game.roll(9);

        assertEquals(game.scoreGame(), 19);
    }

    @Test
    public void lastFrameStrike() {
        rollRemaining(18, 0);
        game.roll(10);
        game.roll(3);
        game.roll(4);

        assertEquals(game.scoreGame(), 17);
    }

    @Test
    public void lastFrameStrikeFollowedByspare() {
        rollRemaining(18, 0);
        game.roll(10);
        game.roll(3);
        game.roll(7);

        assertEquals(game.scoreGame(), 20);
    }

    @Test
    public void perfectGame() {
        rollRemaining(12, 10);

        assertEquals(game.scoreGame(), 300);
    }
}
