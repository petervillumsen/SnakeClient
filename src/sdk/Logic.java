package sdk;

/**
 * Created by Peter Villumsen on 19/11/15.
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import UI.Screen;
import java.util.ArrayList;

/**
 * This class controls the different requests and paths that are sent to the server.
 * This class is used to connect to the Api class on the server.
 */

//Start of class
public class Logic {

    ServerConnection serverConnection = new ServerConnection();

    private static User currentUser;
    private Screen screen;

    public Logic(){
        currentUser = new User();
        screen = new Screen();

    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public boolean login(String username, String password){

        ServerConnection serverConnection = new ServerConnection();

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        String json = new Gson().toJson(user);

       serverConnection.post(json, "login/");

        if(serverConnection.post(json, "login/")==200){

            for (User users : sdk.Logic.getUser()){

                if (users.getUsername().equals(username)) {
                    currentUser = users;
                }
            }

            return true;
        }else {
            return false;
        }
    }
    public static void createUser(User user){

    }
    public static void deleteUser(int userId){

    }

    /**
     * Method using a get on the path users/ request to return all users and put them in an ArrayList.
     * @return users
     */
    public static ArrayList<User> getUser(){

        ServerConnection serverConnection = new ServerConnection();

        String json = serverConnection.get("users/");

        //gets users to arrayList
        ArrayList<User> users = new Gson().fromJson(json, new TypeToken<ArrayList<User>>(){}.getType());

        return users;
    }

    public ArrayList<Game> openGames()
    {
        String json = serverConnection.get("games/open/");

        ArrayList<Game> openGames = new Gson().fromJson(json, new TypeToken<ArrayList<Game>>(){}.getType());

        return openGames;
    }

    public int joinGame(Game game)
    {
        int json = serverConnection.put(new Gson().toJson(game), "games/join/");
        return json;
    }

    public int startGame (Game game)
    {
        int json = serverConnection.put(new Gson().toJson(game), "games/start/");
        return json;
    }

    public boolean createGame(String name, String moves){

        ServerConnection serverConnection = new ServerConnection();

        Gamer host = new Gamer();
        host.setId(currentUser.getId());
        host.setControls(moves);


        Game game = new Game();
        game.setName(name);
        game.setHost(host);
        game.setMapSize(15);


        String json = new Gson().toJson(game);

        int response = serverConnection.post(json, "games/");

        if(response==201){
            return true;

        }
        return false;
    }

    public int deleteGame(int gameId){
        int json = serverConnection.delete("games/" + gameId + "/");
        return json;
    }
    public ArrayList<Score> getHighScore()
    {
        String json = serverConnection.get("highScores/");
        ArrayList<Score> highScores = new Gson().fromJson(json, new TypeToken<ArrayList<Score>>() {}.getType());

        return highScores;
    }
}