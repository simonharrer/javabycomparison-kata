package com.javabycomparison.kata.search;

import com.javabycomparison.kata.analysis.AnalyzerImpl;
import com.javabycomparison.kata.analysis.JavaAnalyzer;
import com.javabycomparison.kata.analysis.PythonAnalyzer;
import com.javabycomparison.kata.analysis.ResultData;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SearchClient {

  private boolean smry;

  public SearchClient(boolean smry) {
    this.smry = smry;
  }

  // JC Favor Abstract Over Concrete Types
  // JC Structure JavaDoc of Methods
  public LinkedList<ResultData> collectAllFiles(String directoryPath) {
    LinkedList<ResultData> resultsList = new LinkedList<>();
    try {
      // JC Always Close Resources
      for (Path file :
          Files.walk(Paths.get(directoryPath))
              .filter(path -> !path.toString().contains(".git"))
              .filter(
                  path -> {
                    try {
                      return !Files.isHidden(path);
                      // JC Avoid Exceptions in Streams
                    } catch (IOException e) {
                      return false;
                    }
                  })
              .collect(Collectors.toSet())) {
        // JC Avoid Compute-Intense Operations During Iteration
        if (isJavaFile(file)) {
          // JC Favor Logging over Console Output
          // JC Favor Format Over Concatenation
          if (!smry) {
            System.out.println("File " + file.toString() + " is a Java file. It will be analyzed.");
          }
          ResultData resultData = new JavaAnalyzer(file).analyze();
          resultsList.add(resultData);
          // JC Avoid Compute-Intense Operations During Iteration
        } else if (isPythonFile(file)) {
          // JC Favor Logging over Console Output
          // JC Favor Format Over Concatenation
          if (!smry) {
            System.out.println(
                "File " + file.toString() + " is a Python file. It will be analyzed.");
          }
          final ResultData resultData = new PythonAnalyzer(file).analyze();
          resultsList.add(resultData);
        } else {
          // JC Avoid Negations
          if (!Files.isDirectory(file)) {
            // JC Favor Logging over Console Output
            // JC Favor Format Over Concatenation
            if (!smry) {
              System.out.println(
                  "File " + file.toString() + " is neither a Java file nor a Python file.");
            }
            resultsList.add(new AnalyzerImpl(file).analyze());
          } else {
            if (!smry) {
              System.out.println("Skipping directory " + file + ".");
            }
          }
        }
      }
      // JC Expose Cause in Variable
      // JC Always Catch Most Specific Exception
    } catch (Exception e) {
      e.printStackTrace();
      // JC Avoid Returning Null
      return null;
    }
    return resultsList;
  }

  private boolean isJavaFile(Path file) {
    // JC Return Boolean Expressions Directly
    if (file.toString().matches(".*\\.java")) {
      return true;
    } else {
      return false;
    }
  }

  private boolean isPythonFile(Path file) {
    // JC Return Boolean Expressions Directly
    // JC Ensure Code Symmetry
    if (file.getFileName().toString().matches(".*\\.py")) {
      return true;
    }
    return false;
  }
}
