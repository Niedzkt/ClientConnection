package org.example;

import org.example.connection.Client;

public class Main {
    public static void main(String[] args) {

        Client client = new Client("localhost", 1234);
        client.start();
    }
}