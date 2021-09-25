package es.viferpar.java11.app;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import es.viferpar.java11.model.Team;
import es.viferpar.java11.service.Sample;
import es.viferpar.java11.service.SampleImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

  public static void main(String[] args) {

    // Type inference

    var name = "Alfred";
    var team = new Team();
    team.add("Joker");
    team.add("Robin");

    log.info("Hello {} my name is Batman and my team is composed by: {}", name, team);

    Map<Integer, Integer> map = Map.of(1, 2, 3, 4, 5, 6);
    map.forEach((var x, var y) -> log.info("{}", x + y));

    // Collections

    var list = List.of(1, 2, 3);
    var set = Set.of("a", "b", "c");
    var stream = Stream.of("a", "b", "c");
    var map2 = Map.of("clave 1", "valor 1", "clave 2", "valor 2");

    log.info("{}", list);
    log.info("{}", set);
    log.info("{}", stream.collect(Collectors.toList()));
    log.info("{}", map2);

    List<Integer> listCopyOf = List.copyOf(list);
    Set<String> setCopyOf = Set.copyOf(set);
    Map<String, String> mapCopyOf = Map.copyOf(map2);

    log.info("{}", listCopyOf);
    log.info("{}", setCopyOf);
    log.info("{}", mapCopyOf);

    List<String> toUnmodifiableList =
        Stream.of("a", "b", "c").collect(Collectors.toUnmodifiableList());
    Set<String> toUnmodifiableSet =
        Stream.of("g", "h", "i").collect(Collectors.toUnmodifiableSet());
    Map<Integer, Integer> toUnmodifiableMap =
        Stream.of(1, 2, 3).collect(Collectors.toUnmodifiableMap(num -> num, num -> num * 4));

    log.info("{}", toUnmodifiableList);
    log.info("{}", toUnmodifiableSet);
    log.info("{}", toUnmodifiableMap);

    // Streams

    log.info("Ejemplo takeWhile():");
    var takeWhileResult =
        Stream.of(1, 2, 3, 4, 5).takeWhile(value -> value < 3).collect(Collectors.toList());
    log.info("{}", takeWhileResult);

    log.info("Ejemplo dropWhile():");
    var dropWhileResult =
        Stream.of(1, 2, 3, 4, 5).dropWhile(value -> value < 3).collect(Collectors.toList());
    log.info("{}", dropWhileResult);

    log.info("Ejemplo iterate():");
    var iterateResult = Stream.iterate(1L, n -> n + 1).limit(10).collect(Collectors.toList());
    log.info("{}", iterateResult);

    log.info("Ejemplo ofNullable():");
    var example = "example";
    var ofNullableResult = Stream.ofNullable(example).collect(Collectors.toList());
    log.info("{}", ofNullableResult);
    String nullExample = null;
    var ofNullableNullResult = Stream.ofNullable(nullExample).collect(Collectors.toList());
    log.info("{}", ofNullableNullResult);

    // Interfaces

    Sample service = new SampleImpl();
    service.doSomething();
    log.info(service.doSomethingCommon());

    // Process

    var processHandle = ProcessHandle.current();
    var processInfo = processHandle.info();


    log.info("PID: {}", processHandle.pid());
    log.info("Arguments: {}", processInfo.arguments());
    log.info("Command: {}", processInfo.command());
    log.info("Instant: {}", processInfo.startInstant());
    log.info("Total CPU duration: {}", processInfo.totalCpuDuration());
    log.info("User: {}", processInfo.user());
    log.info("Descendants: {}", processHandle.descendants().count());
    log.info("Childrens size: {}", processHandle.children().count());

  }

}
