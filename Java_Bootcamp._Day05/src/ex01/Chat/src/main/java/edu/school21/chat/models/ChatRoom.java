package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class ChatRoom {
  private Integer id;
  private String name;
  private User owner;
  private ArrayList<Message> messageList;

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

  public ChatRoom(Integer id, String name, User owner, ArrayList<Message> messageList) {
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
