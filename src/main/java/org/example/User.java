package org.example;

import java.util.List;
import lombok.Getter;

@Getter
public class User {

  String name;

  int age;

  List<Friend> friends;
}
