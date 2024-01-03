package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;

@Getter
public class User2 {

  String name;

  int age;

  List<Friend> friends;

  @Getter
  public static class Friend {
    String name;

    int age;

    @JsonProperty("my-favorite")
    Favorite favorite;

    @Getter
    public static class Favorite {
      List<String> foods;

      List<String> games;
    }
  }
}
