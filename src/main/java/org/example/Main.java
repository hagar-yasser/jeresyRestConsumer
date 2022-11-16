package org.example;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Customer;

import java.util.HashMap;

public class Main {
    static void getAllCustomers(){
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget
                    = client.target("http://localhost:8080/jeresyRestProducer/webapi");
            WebTarget customersWebTarget
                    = webTarget.path("getAllCustomers");
            Invocation.Builder invocationBuilder
                    = customersWebTarget.request(MediaType.APPLICATION_JSON);
            Response response
                    = invocationBuilder.get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("Request Processing Failed : HTTP error code : "
                        + response.getStatus());
            }
            System.out.println(response.readEntity(HashMap.class));

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    static void createCustomer(Customer customer,String id){
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget
                    = client.target("http://localhost:8080/jeresyRestProducer/webapi");
            WebTarget customersWebTarget
                    = webTarget.path("createCustomer").path(id);
            Invocation.Builder invocationBuilder
                    = customersWebTarget.request(MediaType.APPLICATION_JSON);
            Response response
                    = invocationBuilder.post(Entity.entity(customer,MediaType.APPLICATION_JSON));

            if (response.getStatus() != 200) {
                throw new RuntimeException("Request Processing Failed : HTTP error code : "
                        + response.getStatusInfo());
            }
            System.out.println(response.getStatusInfo());

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    static void updateCustomer(Customer customer,String id){
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget
                    = client.target("http://localhost:8080/jeresyRestProducer/webapi");
            WebTarget customersWebTarget
                    = webTarget.path("updateCustomer").path(id);
            Invocation.Builder invocationBuilder
                    = customersWebTarget.request(MediaType.APPLICATION_JSON);
            Response response
                    = invocationBuilder.put(Entity.entity(customer,MediaType.APPLICATION_JSON));

            if (response.getStatus() != 200) {
                throw new RuntimeException("Request Processing Failed : HTTP error code : "
                        + response.getStatusInfo());
            }
            System.out.println(response.getStatusInfo());

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    static void deleteCustomer(String id){
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget
                    = client.target("http://localhost:8080/jeresyRestProducer/webapi");
            WebTarget customersWebTarget
                    = webTarget.path("deleteCustomer").path(id);
            Invocation.Builder invocationBuilder
                    = customersWebTarget.request(MediaType.APPLICATION_JSON);
            Response response
                    = invocationBuilder.delete();

            if (response.getStatus() != 200) {
                throw new RuntimeException("Request Processing Failed : HTTP error code : "
                        + response.getStatusInfo());
            }
            System.out.println(response.getStatusInfo());

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    public static void main(String[] args) {
//        System.out.println("-------------ALL CUSTOMERS-------------");
//        getAllCustomers();
//        System.out.println("-------------CREATE CUSTOMER-------------");
//        createCustomer(new Customer("kdlafj",13,"firstName added","last Name added"),"id added");
        System.out.println("-------------ALL CUSTOMERS-------------");
        getAllCustomers();
        System.out.println("-------------Update CUSTOMER-------------");
        updateCustomer(new Customer("jkfdajl",24,"firstName updated","lastNameUpdated"),"id added");
        System.out.println("-------------ALL CUSTOMERS-------------");
        getAllCustomers();
        System.out.println("-------------DELETE CUSTOMER-------------");
        deleteCustomer("id added");
        System.out.println("-------------ALL CUSTOMERS-------------");
        getAllCustomers();


    }
}