package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

public class Server {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Server!!");

        int portNumber = Integer.parseInt(args[0]);

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept(); // blokovacia funcia na vytvorenie servera čaká
            System.out.println(" Nove spojenie: "+ clientSocket.getInetAddress().toString());
            PrintWriter out = // + clientSocket.getInetAddress().toString()
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

           String inputLine, outputLine;
            System.out.println("Ahoj client.");
            while ((inputLine = in.readLine()) != null) {
                outputLine = inputLine;
                out.println(outputLine);
                if (outputLine.equals("Bye."))
                    break;
            }
        }
         catch (IOException e) {
            e.printStackTrace();
        }



    }
}
