package com.javabycomparison.kata.analysis;

import java.io.IOException;

public interface Analyzer {

  // JC Structure JavaDoc of Classes and Interfaces
  /** This method analyzes code. */
  ResultData analyze() throws IOException;
}
