package edu.school21.chat.repositories;

import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
  private final DataSource ds;

  public MessagesRepositoryJdbcImpl(DataSource ds) {
    this.ds = ds;
  }

  @Override
  public Optional<Message> findById(Long id) throws SQLException {
    Optional<Message> optionalMessage;
    Connection connection = ds.getConnection();
    Statement statement = connection.createStatement();
    String query = "Select * from message where id = " + id;
    ResultSet resultSet = statement.executeQuery(query);
    resultSet.next();
    User user = new User(1, "sdfsd", "sdfs", null, null);
    ChatRoom chatRoom = new ChatRoom(1, "chatroom", null, null);
    optionalMessage = Optional.of(new Message(resultSet.getInt(1), user, chatRoom, resultSet.toString(), LocalDateTime.of(2014, 9, 19, 14, 5, 20)));
    return optionalMessage;
//    Integer id, User author, ChatRoom room, String text, LocalDateTime date
  }
}
