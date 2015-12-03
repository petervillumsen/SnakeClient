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

            int respone =response.getStatus();

            if (response.getStatus() != 0) {
                return output;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public Integer post(String json, String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

      //  if (response.getStatus() != 200 && response.getStatus() != 201) {
        //    throw new RuntimeException("Failed : HTTP error code : "
       //             + response.getStatus());
       // }

        int message = response.getStatus();

        String output = response.getEntity(String.class);
        System.out.println(output);

        return message;

    }
}
