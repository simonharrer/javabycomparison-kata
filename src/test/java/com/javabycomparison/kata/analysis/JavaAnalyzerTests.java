package com.javabycomparison.kata.analysis;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// JC Describe Your Tests
class JavaAnalyzerTests {

  @Test
  void analyze() throws IOException {
    JavaAnalyzer javaAnalyzer = new JavaAnalyzer(null);
    // JC Use Meaningful Assertions
    assertNotNull(javaAnalyzer);
    assertNull(javaAnalyzer.analyze());
  }

  // JC Let JUnit Handle Exceptions
  @Test
  void analyzeShouldThrowIOException() {
    JavaAnalyzer javaAnalyzer = new JavaAnalyzer(Paths.get("./XXX_unavailable_directory/"));
    try {
      javaAnalyzer.analyze();
      // JC Explain Empty Catch
    } catch (IOException ioe) {

    }
  }

  // JC Structure Tests Into Given-When-Then
  @Test
  void analyzeJavaFizzBuzz() throws IOException {
    Assertions.assertEquals(
        new ResultData(0, "./src/main/resources/java_files/FizzBuzz.java", 15, 4, 0, 0),
        new JavaAnalyzer(Paths.get("./src/main/resources/java_files/FizzBuzz.java")).analyze());
  }
}
