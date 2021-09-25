package es.viferpar.java11.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringTest {

  @Test
  void repeat() {
    Assertions.assertEquals("testtesttesttesttest", "test".repeat(5));
  }

  @Test
  void strip() {
    Assertions.assertEquals("test", "\r\n test \r\n".strip());
  }

  @Test
  void stripLeading() {
    Assertions.assertEquals("test ", "\r\n test ".stripLeading());
  }

  @Test
  void stripTrailing() {
    Assertions.assertEquals(" test", " test\r\n ".stripTrailing());
  }

  @Test
  void isBlank() {
    Assertions.assertTrue("".isBlank());
    Assertions.assertTrue(" ".isBlank());
    Assertions.assertTrue("  ".isBlank());

  }

  @Test
  void lines() {
    Assertions.assertEquals(3, "hola\r\nque\r\ntal".lines().count());
  }



}
