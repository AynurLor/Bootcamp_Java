package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class ChatRoom {
  private
  long id;
  private String name;
  private User owner;
  private ArrayList<Message> messageList;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public ArrayList<Message> getMessageList() {
    return messageList;
  }

  public void setMessageList(ArrayList<Message> messageList) {
    this.messageList = messageList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ChatRoom chatRoom = (ChatRoom) o;
    return Objects.equals(id, chatRoom.id) && Objects.equals(name, chatRoom.name) && Objects.equals(owner, chatRoom.owner) && Objects.equals(messageList, chatRoom.messageList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, owner, messageList);
  }

  public ChatRoom(long id, String name, User owner, ArrayList<Message> messageList) {
    this.id = id;
    this.name = name;
    this.owner = owner;
    this.messageList = messageList;
  }

  @Override
  public String toString() {
    return "ChatRoom{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", owner=" + owner +
      ", messageList=" + messageList +
      '}';
  }
}
