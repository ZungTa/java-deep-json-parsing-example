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
}