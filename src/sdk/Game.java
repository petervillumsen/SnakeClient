package sdk;

import java.sql.Date;

/**
 * Created by Peter Villumsen on 12-10-2015.
 * This class contains the same as the Game class on the server side
 * This class represents an object of a Game with all the attributes of a Game
 */

//The class starts
public class Game
{
    //Declaring the variables needed for the game.
    private int gameId;
    private Gamer winner;
    private String name;
    private Gamer host;
    private Gamer opponent;
    private String status;
    private Date created;
    private int mapSize;

    public Game(){}

    /**
     * Getter for Created
     * @return Created
     */
    public Date getCreated()
    {
        return created;
    }

    /**
     * Setter for Created
     * @param created sets the date the game was created
     */
    public void setCreated(Date created)
    {
        this.created = created;
    }

    /**
     * Getter for mapSize
     * @return mapSize
     */
    public int getMapSize()
    {
        return mapSize;
    }

    /**
     * Setter for mapSize
     * @param mapSize sets the map size for a game
     */
    public void setMapSize(int mapSize)
    {
        this.mapSize = mapSize;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter for name
     * @param name sets the name of a game.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Getter for gameId
     * @return gameId
     */
    public int getGameId(){
        return gameId;
    }

    /**
     * Setter for gameId
     * @param gameId sets the id of a game.
     */
    public void setGameId(int gameId)
    {
        this.gameId = gameId;
    }

    /**
     * Getter for host
     * @return host
     */
    public Gamer getHost()
    {
        return host;
    }

    /**
     * Setter for host
     * @param host sets the host for the game
     */
    public void setHost(Gamer host)
    {
        this.host = host;
    }

    /**
     * Getter for opponent
     * @return opponent
     */
    public Gamer getOpponent()
    {
        return opponent;
    }

    /**
     * Setter for opponent
     * @param opponent sets the opponent for a game
     */
    public void setOpponent(Gamer opponent)
    {
        this.opponent = opponent;
    }

    /**
     * Getter for status
     * @return status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * Setter for status
     * @param status sets the status of the game
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * Getter for winner
     * @return winner
     */
    public Gamer getWinner()
    {
        return winner;
    }

    /**
     * Setter for winner
     * @param winner sets who won the game
     */
    public void setWinner(Gamer winner)
    {
        this.winner = winner;
    }
} //End of the class Game
