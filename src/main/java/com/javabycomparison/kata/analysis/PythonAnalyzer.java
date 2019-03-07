package com.javabycomparison.kata.analysis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PythonAnalyzer implements Analyzer {
  private final Path file;

  public PythonAnalyzer(Path file) {
    this.file = file;
  }

  @Override
  public ResultData analyze() throws IOException {

    int imports = 0;
    int LoC = 0;
    int methods = 0;
    int commentsLoC = 0;

    List<String> fileContents = Files.readAllLines(this.file);

    for (String line : fileContents) {
      LoC += 1;
      if (line.trim().startsWith("import")) {
        imports += 1;
      }
      if (line.trim().startsWith("from")) {
        imports += 1;
      } else if (line.trim().startsWith("#")) {
        commentsLoC += 1;
      } else if (line.trim().startsWith("def")) {
        methods += 1;
      }
    }

    return new ResultData(1, this.file.toString(), LoC, commentsLoC, methods, imports);
  }
}
