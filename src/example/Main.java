package example;

/**
 * Created by ejer on 19/11/15.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sdk.Logic;

import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {

        Logic.login("doek4life", "abc123");
        Logic.createGame("battle_to_death",1);

    }
}
