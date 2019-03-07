package com.javabycomparison.kata.search;

import com.javabycomparison.kata.analysis.AnalysisResult;
import com.javabycomparison.kata.analysis.JavaLyzer;
import com.javabycomparison.kata.analysis.PythonLyzer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SearchClient {

  public List<AnalysisResult> collectAllFiles(String directoryPath) {
    List<AnalysisResult> resultsList = new LinkedList<>();
    try {
      // JC Always Close Resources
      for (Path file : Files.walk(Paths.get(directoryPath)).collect(Collectors.toSet())) {
        // JC Avoid Compute-Intense Operations During Iteration
        if (Pattern.matches(".*\\.java", file.toString())) {
          // JC Favor Logging over Console Output
          // JC Favor Format Over Concatenation
          System.out.println("File " + file.toString() + " is a Java file. It will be analyzed.");
          AnalysisResult analysisResult = new JavaLyzer(file).analyze();
          resultsList.add(analysisResult);
          // JC Avoid Compute-Intense Operations During Iteration
        } else if (Pattern.matches(".*\\.py", file.getFileName().toString())) {
          // JC Favor Logging over Console Output
          // JC Favor Format Over Concatenation
          System.out.println("File " + file.toString() + " is a Python file. It will be analyzed.");
          final AnalysisResult analysisResult = new PythonLyzer(file).analyze();
          resultsList.add(analysisResult);
        } else {
          // JC Favor Logging over Console Output
          // JC Favor Format Over Concatenation
          System.out.println(
              "File "
                  + file.toString()
                  + " is neither a Java file nor a Python file. It will not be analyzed.");
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
