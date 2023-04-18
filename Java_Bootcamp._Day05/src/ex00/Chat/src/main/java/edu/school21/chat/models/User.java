package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {
  private Integer id;
  private String login;
  private String password;
  private ArrayList<ChatRoom> creatRooms;
  private ArrayList<ChatRoom> chatRooms;

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", login='" + login + '\'' +
      ", password='" + password + '\'' +
      ", creatRooms=" + creatRooms +
      ", chatRooms=" + chatRooms +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(creatRooms, user.creatRooms) && Objects.equals(chatRooms, user.chatRooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, password, creatRooms, chatRooms);
  }

  public User(Integer id, String login, String password, ArrayList<ChatRoom> creatRooms, ArrayList<ChatRoom> chatRooms) {
    this.id = id;
    this.login = login;
    this.password = password;
    this.creatRooms = creatRooms;
    this.chatRooms = chatRooms;
  }
}
