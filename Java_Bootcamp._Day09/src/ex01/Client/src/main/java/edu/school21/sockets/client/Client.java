package edu.school21.sockets.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private PrintWriter out;

    public Client(Integer port) {
        try {
            try {

            clientSocket = new Socket("localhost", port);
            // чтение из потока ввода
            reader = new BufferedReader(new InputStreamReader(System.in));
            // принимаем поток от сервера
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // оправляем на серер
                out = new PrintWriter(clientSocket.getOutputStream(), true);

            String serverMsg = in.readLine();
            System.out.println(serverMsg);
            String word = reader.readLine();

            out.println(word);
            while (!(word.equalsIgnoreCase("SignUp"))) {
                    System.out.print(reader.readLine() + "\n> ");
                word = reader.readLine();
                out.println(word);
            }
            word = in.readLine();
            System.out.println(word + "\n>");
            String userName = reader.readLine();
            out.println(userName);

            word = in.readLine();
            System.out.println(word + "\n>");
            String password = reader.readLine();
            out.println(password);

            word = in.readLine();
            System.out.println(word);
            } finally {
                System.out.println("Client close");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
