package com.javabycomparison.kata.analysis;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class JavaAnalyzerTest {

  @Test
  void analyze() throws IOException {
    JavaAnalyzer javaAnalyzer = new JavaAnalyzer(null);
    // JC Use Meaningful Assertions
    assertNotNull(javaAnalyzer);
    assertNull(javaAnalyzer.analyze());
  }
}
