package es.viferpar.java11.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class OptionalTest {

  @Test
  void streamTest() {
    Optional<String> optional1 = Optional.of("Texto 1");
    Optional<String> optional2 = Optional.empty();
    Optional<String> optional3 = Optional.of("Texto 3");

    List<String> textos = Stream.of(optional1, optional2, optional3)
        .flatMap(optional -> optional.stream()).collect(Collectors.toList());

    Assertions.assertEquals(2, textos.size());
    Assertions.assertEquals("Texto 1", textos.get(0));
    Assertions.assertEquals("Texto 3", textos.get(1));

  }

  @Test
  void ifPresentOrElseTest() {
    Optional<String> optionalConUnTexto = Optional.of("Un texto");
    Optional<String> optionalVacio = Optional.empty();

    optionalConUnTexto.ifPresentOrElse(texto -> {
      log.info("El optional con texto debería pasar por el present");
      Assertions.assertEquals("Un texto", texto);
    }, () -> {
      throw new RuntimeException("El optional con texto nunca debería pasar por el else");
    });

    optionalVacio.ifPresentOrElse(texto -> {
      throw new RuntimeException("El optional vacío nunca debería pasar por el present");
    }, () -> log.info("El optional vacío debería pasar por el else"));

  }

  @Test
  void orTest() {
    Optional<String> optionalConUnTexto = Optional.of("Un texto");
    Optional<String> optionalVacio = Optional.empty();

    var orOptionalConUnTexto = optionalConUnTexto.or(() -> Optional.of("Optional vacío"));
    var orOptionalVacio = optionalVacio.or(() -> Optional.of("Optional vacío"));

    Assertions.assertEquals("Un texto", orOptionalConUnTexto.get());
    Assertions.assertEquals("Optional vacío", orOptionalVacio.get());
  }

  @Test
  void orElseThrowTest() throws Exception {

    Optional<String> optionalVacio = Optional.empty();

    Assertions.assertThrows(Exception.class, () -> {
      optionalVacio.orElseThrow(() -> new Exception("El optional era nulo"));
    });

  }

}
