package com.javabycomparison.kata.search;

import com.javabycomparison.kata.analysis.AnalyzerImpl;
import com.javabycomparison.kata.analysis.JavaAnalyzer;
import com.javabycomparison.kata.analysis.PythonAnalyzer;
import com.javabycomparison.kata.analysis.ResultData;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SearchClient {

  // JC Favor Abstract Over Concrete Types
  public LinkedList<ResultData> collectAllFiles(String directoryPath) {
    LinkedList<ResultData> resultsList = new LinkedList<>();
    try {
      // JC Always Close Resources
      for (Path file : Files.walk(Paths.get(directoryPath)).collect(Collectors.toSet())) {
        // JC Avoid Compute-Intense Operations During Iteration
        if (Pattern.matches(".*\\.java", file.toString())) {
          // JC Favor Logging over Console Output
          // JC Favor Format Over Concatenation
          System.out.println("File " + file.toString() + " is a Java file. It will be analyzed.");
          ResultData resultData = new JavaAnalyzer(file).analyze();
          resultsList.add(resultData);
          // JC Avoid Compute-Intense Operations During Iteration
        } else if (Pattern.matches(".*\\.py", file.getFileName().toString())) {
          // JC Favor Logging over Console Output
          // JC Favor Format Over Concatenation
          System.out.println("File " + file.toString() + " is a Python file. It will be analyzed.");
          final ResultData resultData = new PythonAnalyzer(file).analyze();
          resultsList.add(resultData);
        } else {
          // JC Favor Logging over Console Output
          // JC Favor Format Over Concatenation
          System.out.println(
              "File " + file.toString() + " is neither a Java file nor a Python file.");
          resultsList.add(new AnalyzerImpl(file).analyze());
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
}
