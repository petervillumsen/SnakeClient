package sdk;

/**
 * Created by Peter Villumsen on 19/11/15.
 */

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * This class handles the connection to the server. In this class there are
 * post, get, put and delete requests. The requests are made with Json.
 */

public class ServerConnection {

    /**
     * Constructor for the serverConnection Class
     */
    public ServerConnection(){
        this.hostAddress = "http://localhost";
        this.port = 8887;
    }

    //Declaring variables
    private String hostAddress;
    private int port;

    /**
     * Getter for hostAddress
     * @return hostAddress
     */
    public String getHostAddress() {
        return hostAddress;
    }

    /**
     * Getter for port
     * @return port
     */
    public int getPort() {
        return port;
    }

    /**
     * Method that gets something from the server
     * @param path is the path of what we want off of the server
     * @return message
     */
    public String get(String path){

        try {
            Client client = Client.create();

            WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
            ClientResponse response = webResource.type("application/json").get(ClientResponse.class);


            String output = response.getEntity(String.class);

            if (response.getStatus() != 0) {
                return output;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Method for posting something to the Server
     * @param json is the object we sent to the Server
     * @param path is the path where we wnat to post
     * @return message
     */
    public int post(String json, String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        int message = response.getStatus();

        String output = response.getEntity(String.class);

        return message;

    }

    /**
     * Method for putting something to the Server
     * @param json the object we sent to the Server
     * @param path the is the path where we want to put something
     * @return responser
     */
      public int put(String json, String path)
    {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);


        int responser = response.getStatus();

        return responser;
    }

    /**
     * Method that deletes something from the Server
     * @param path the path where we want to delete something
     * @return responser
     */
    public int delete (String path)
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        int responser = response.getStatus();
        return responser;
    }
}
