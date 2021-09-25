package es.viferpar.java11.service;

public interface Sample {

  void doSomething();

  public default String doSomethingCommon() {
    return getCommonPhrase();
  }

  private String getCommonPhrase() {
    return "Common phrase";
  }

}
