package sdk;

/**
 * Created by ejer on 19/11/15.
 */

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ServerConnection {

    public ServerConnection(){
        this.hostAddress = "http://localhost";
        this.port = 8887;
    }

    private String hostAddress;
    private int port;

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }

    public String get(String path){

        try {
            Client client = Client.create();

            WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
            ClientResponse response = webResource.type("application/json").get(ClientResponse.class);


            String output = response.getEntity(String.class);
            System.out.println(output);

           // int response =response.getStatus();

            if (response.getStatus() != 0) {
                return output;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public int post(String json, String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        int message = response.getStatus();

        String output = response.getEntity(String.class);
        System.out.println(output);

        return message;

    }

      public int put(String json, String path)
    {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);


        int responser = response.getStatus();

        return responser;
    }

    public int delete (String path)
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        int responser = response.getStatus();
        return responser;
    }
}
