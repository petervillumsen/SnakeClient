package sdk;

/**
 * Created by Peter Villumsen on 15/10/15.
 * This class contains the same as the Gamer class on the server side
 * This class represents an object of a Gamer with all the attributes of a Gamer
 */

//Class starts
public class Gamer extends User
{
    //Declaring variables used in the class
    private int score;
    private int totalScore;
    private int kills;
    private String controls;
    private boolean winner;

    /**
     * Getter for winner
     * @return winner
     */
    public boolean isWinner()
    {
        return winner;
    }

    /**
     * Setter for winner
     * @param winner sets the winner
     */
    public void setWinner(boolean winner)
    {
        this.winner = winner;
    }

    /**
     * Getter for score
     * @return score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Setter for score
     * @param score sets score
     */
    public void setScore(int score)
    {
        this.score = score;
    }

    /**
     * Getter for totalScore
     * @return totalScore
     */
    public int getTotalScore()
    {
        return totalScore;
    }

    /**
     * Setter for totelScore
     * @param totalScore sets totalScore
     */
    public void setTotalScore(int totalScore)
    {
        this.totalScore = totalScore;
    }

    /**
     * Getter for kills
     * @return kills
     */
    public int getKills()
    {
        return kills;
    }

    /**
     * Setter for kills
     * @param kills sets kills
     */
    public void setKills(int kills)
    {
        this.kills = kills;
    }

    /**
     * Getter for controls
     * @return controls
     */
    public String getControls()
    {
        return controls;
    }

    /**
     * Setter for controls
     * @param controls sets controls
     */
    public void setControls(String controls)
    {
        this.controls = controls;
    }
}
