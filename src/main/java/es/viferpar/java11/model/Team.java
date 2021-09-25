package es.viferpar.java11.model;

import java.util.HashMap;
import java.util.Map;
import lombok.ToString;

@ToString
public class Team {

  private Map<String, String> members;

  public Team() {
    members = new HashMap<>();
  }

  public void add(String member) {
    members.put(member, member);
  }

  public void remove(String member) {
    members.remove(member);
  }

}
