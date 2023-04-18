package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {
  private long id;
  private String login;
  private String password;
  private ArrayList<ChatRoom> creatRooms;
  private ArrayList<ChatRoom> chatRooms;

  public User(User user_) {
    this.id = user_.id;
    this.login = user_.login;
    this.password = user_.password;
    this.creatRooms = user_.creatRooms;
    this.chatRooms = user_.chatRooms;
  }

  public long getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ArrayList<ChatRoom> getCreatRooms() {
    return creatRooms;
  }

  public void setCreatRooms(ArrayList<ChatRoom> creatRooms) {
    this.creatRooms = creatRooms;
  }

  public ArrayList<ChatRoom> getChatRooms() {
    return chatRooms;
  }

  public void setChatRooms(ArrayList<ChatRoom> chatRooms) {
    this.chatRooms = chatRooms;
  }

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

  public User(long id, String login, String password, ArrayList<ChatRoom> creatRooms, ArrayList<ChatRoom> chatRooms) {
    this.id = id;
    this.login = login;
    this.password = password;
    this.creatRooms = creatRooms;
    this.chatRooms = chatRooms;
  }
}
