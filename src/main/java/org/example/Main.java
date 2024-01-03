package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");

    ObjectMapper objectMapper = new ObjectMapper();

    File jsonDataFile = new File(System.getProperty("user.dir") + "/src/main/resources/json/data.json");

    System.out.println("User");
    printUser(objectMapper, jsonDataFile);

    System.out.println("User2");
    printUser2(objectMapper, jsonDataFile);
  }

  static void printUser(ObjectMapper objectMapper, File jsonDataFile) {
    User user;
    try {
      user = objectMapper.readValue(jsonDataFile, User.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    System.out.println("name: " + user.getName());
    System.out.println("age: " + user.getAge());

    for (int i=0; i<user.getFriends().size(); i++) {
      Friend friend = user.getFriends().get(i);
      String friendsIndex = "friends[" + i + "]";
      System.out.println(friendsIndex);
      System.out.println(friendsIndex + ".name: " + friend.getName());
      System.out.println(friendsIndex + ".age: " + friend.getAge());

      // favorite
      System.out.println(friendsIndex + ".my-favorite.foods: " + Arrays.toString(
          friend.getFavorite().getFoods()));
      System.out.println(friendsIndex + ".my-favorite.games: " + Arrays.toString(
          friend.getFavorite().getGames()));
    }
  }

  static void printUser2(ObjectMapper objectMapper, File jsonDataFile) {
    User2 user;
    try {
      user = objectMapper.readValue(jsonDataFile, User2.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    System.out.println("name: " + user.getName());
    System.out.println("age: " + user.getAge());

    for (int i=0; i<user.getFriends().size(); i++) {
      User2.Friend friend = user.getFriends().get(i);
      String friendsIndex = "friends[" + i + "]";
      System.out.println(friendsIndex);
      System.out.println(friendsIndex + ".name: " + friend.getName());
      System.out.println(friendsIndex + ".age: " + friend.getAge());

      // favorite
      System.out.println(friendsIndex + ".my-favorite.foods: " + friend.getFavorite().getFoods());
      System.out.println(friendsIndex + ".my-favorite.games: " + friend.getFavorite().getGames());
    }
  }
}