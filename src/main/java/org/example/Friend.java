package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Friend {
  String name;

  int age;

  @JsonProperty("my-favorite")
  Favorite favorite;
}
