package sdk;

/**
 * Created by ejer on 19/11/15.
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;



public class Logic {

    ServerConnection serverConnection = new ServerConnection();

    private static User currentUser;

    public Logic(){
        currentUser = new User();

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

        System.out.printf(json);

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
    public static ArrayList<User> getUser(){

        ServerConnection serverConnection = new ServerConnection();

        String json = serverConnection.get("users/");

        //henyer users ned i en arrayList
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
        int json = serverConnection.put(new Gson().toJson(game),"games/join/");
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

        int response = serverConnection.post(json,"games/");

        if(response==201){
            return true;
        }

        return false;
    }


    public int deleteGame(int gameId){
        int json = serverConnection.delete("games/" + gameId + "/");
        return json;
    }
}