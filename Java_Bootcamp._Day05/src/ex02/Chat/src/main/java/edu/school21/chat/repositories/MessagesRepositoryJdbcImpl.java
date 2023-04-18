package edu.school21.chat.repositories;

import edu.school21.chat.exception.NotSavedSubEntityException;
import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
  private final DataSource ds;

  public MessagesRepositoryJdbcImpl(DataSource ds) {
    this.ds = ds;
  }

  @Override
  public void save(Message message) throws NotSavedSubEntityException {

      String querySave = "insert into message(sender, room_id, text, time) values (" +
                          message.getAuthor().getId() + ", " +
                          message.getRoom().getId() + ", " +
                          "'" + message.getText() + "'" + ", " +
                          "'" + message.getDate() + "'" + ");";
    try {Connection connection = ds.getConnection();

      PreparedStatement statement = connection.prepareStatement(querySave, Statement.RETURN_GENERATED_KEYS);
      statement.execute();

      ResultSet key = statement.getGeneratedKeys();
      key.next();
      message.setId(key.getInt(1));
    } catch (SQLException e) {
      throw new NotSavedSubEntityException();
    }

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
    optionalMessage = Optional.of(new Message(resultSet.getInt(1), user, chatRoom, resultSet.toString(), LocalDate.of(2014, 9, 19)));

    return optionalMessage;


  }
}
