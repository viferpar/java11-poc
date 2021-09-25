package es.viferpar.java11.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class SampleImpl implements Sample {

  @Override
  public void doSomething() {

    log.info("Doing something especial");

  }

}
