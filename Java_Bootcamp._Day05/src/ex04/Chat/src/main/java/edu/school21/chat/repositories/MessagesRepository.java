package edu.school21.chat.repositories;

import edu.school21.chat.exception.NotSavedSubEntityException;
import edu.school21.chat.models.Message;

import java.sql.SQLException;
import java.util.Optional;

public interface MessagesRepository {
  Optional<Message> findById(Long id) throws SQLException;
  void save(Message message) throws SQLException, NotSavedSubEntityException;
  boolean update(Message message) throws SQLException;

}


