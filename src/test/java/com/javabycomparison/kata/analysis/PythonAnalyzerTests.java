package com.javabycomparison.kata.analysis;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PythonAnalyzerTests {

  // JC Favor Standalone Tests
  private ResultData pythonResult;

  @BeforeEach
  void analyzePython() throws IOException {
    pythonResult =
        new PythonAnalyzer(Paths.get("./src/main/resources/python_files/function.py")).analyze();
  }

  // JC Expected Before Actual Value
  @Test
  void analyzePythonFile() {
    Assertions.assertEquals(
        pythonResult,
        new ResultData(1, "./src/main/resources/python_files/function.py", 17, 3, 3, 1));
  }

  // JC Use Reasonable Tolerance Values
  @Test
  void analyzeFractionOfComments() {
    // JC Replace Magic Numbers with Constants
    Assertions.assertEquals(5.66, (float) pythonResult.LOC / pythonResult.commentLOC, 0.05);
  }
}
