package edu.school21.chat.app;


//import com.zaxxer.hikari.HikariDataSource;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) throws SQLException {


    HikariDataSource ds = new HikariDataSource();
    ds.setJdbcUrl("jdbc:postgresql://localhost:5433/postgres");
    ds.setUsername("postgres");
    ds.setPassword("");

    MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);

    User creator = new User(1, "user", "user", new ArrayList(), new ArrayList());
    ChatRoom room = new ChatRoom(1, "room", creator, new ArrayList());
    Message message = new Message(null, creator, room, "Hello!", LocalDate.now());


    repository.save(message);

    System.out.println(message.getId()); // ex. id == 11
  }
}
