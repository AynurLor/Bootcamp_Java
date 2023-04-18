package edu.school21.sockets.server;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.models.User;
import edu.school21.sockets.services.UserService;
import edu.school21.sockets.services.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static  Socket clientSocket;
    private ServerSocket server = null;
    private static BufferedReader in;
    private PrintWriter out;
    private UserService service;
    private AnnotationConfigApplicationContext ctx;



    public Server(Integer port) {
        try {
            server = new ServerSocket(port);
            clientSocket = server.accept();
            try {
                // принимаем сообщения
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // отправляем сообщения
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                // ввод бинов с конфигом бд
                ctx = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);
                service = ctx.getBean(UserServiceImpl.class);
                out.println("Hello from Server!");
                String regisCommand = in.readLine();

                while (!regisCommand.equalsIgnoreCase("SignUp")) {
                    out.println("Please write again");
                    System.out.println(regisCommand);
                    regisCommand = in.readLine();
                }

                out.println("Enter username:");
                String userName = in.readLine();

                out.println("Enter password:");
                String password = in.readLine();

                User user = new User(userName, password);
                if (service.signUp(user)) {
                    out.println("Successful!");
                } else {
                    out.println("User not found");
                }
                System.out.println(userName + " " + password);

            } finally {
                // потоки тоже хорошо бы закрыть
                clientSocket.close();
                in.close();
                out.close();
            }
            server.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
