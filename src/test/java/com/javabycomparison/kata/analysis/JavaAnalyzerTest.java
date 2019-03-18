package com.javabycomparison.kata.analysis;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class JavaAnalyzerTest {

  @Test
  void analyze() throws IOException {
    JavaAnalyzer javaAnalyzer = new JavaAnalyzer(null);
    // JC Use Meaningful Assertions
    assertNotNull(javaAnalyzer);
    assertNull(javaAnalyzer.analyze());
  }
}
