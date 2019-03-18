package com.javabycomparison.kata.analysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JavaAnalyzer implements Analyzer {

  private final Path file;

  public JavaAnalyzer(Path file) {
    this.file = file;
  }

  @Override
  public ResultData analyze() throws IOException {
    if (file != null) {
      int imports = 0;
      int LoC = 0;
      int commentsLoC = 0;

      try {
        // JC Always Close Resources
        BufferedReader reader = Files.newBufferedReader(this.file);

        String line;
        while ((line = reader.readLine()) != null) {
          LoC += 1;
          if (line.trim().startsWith("import")) {
            imports += 1;
            // JC Simplify Boolean Expressions
          } else if (line.trim().startsWith("//")
              || line.trim().startsWith("*")
              || line.trim().startsWith("/*")) {
            commentsLoC += 1;
          }
        }
        // It is impossible to detect the number of methods at the moment.
        return new ResultData(0, this.file.toString(), LoC, commentsLoC, 0, imports);
      } catch (IOException ioe) {
        // JC Avoid Breaking the Cause Chain
        throw new IOException("There was a problem reading a file!");
      }
    } else {
      return null;
    }
  }
}
