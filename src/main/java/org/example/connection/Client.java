package org.example.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    private String host;
    private int port;

    public Client(String host, int port){
        this.host = host;
        this.port = port;
    }

    public void start(){
        try(Socket socket = new Socket(host, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in)){

            String inputLine;

            while (true){
                System.out.println("Wpisz wiadomosc (q aby zakonczyc): ");
                inputLine = scanner.nextLine();

                if("q".equals(inputLine)){
                    break;
                }

                out.println(inputLine);
                String response = in.readLine();
                System.out.println("Odpowiedz serwera: " + response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
