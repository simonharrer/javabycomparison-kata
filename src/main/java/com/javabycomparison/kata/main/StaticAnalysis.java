package com.javabycomparison.kata.main;

import com.javabycomparison.kata.analysis.AnalysisResult;
import com.javabycomparison.kata.search.SearchClient;
import java.util.List;

public class StaticAnalysis {

  public static void main(String[] args) {

    StaticAnalysis analyzer = new StaticAnalysis();

    AnalysisResult[] overallResult = analyzer.run("./src/");

    System.out.println(
        "File Name \t Language \t Lines of Code \t Number of Comments \t Number of Methods \t Number of Imports");
    System.out.println(overallResult[0].print() + "\n" + overallResult[1].print());
  }

  private AnalysisResult[] run(String directoryPath) {

    List<AnalysisResult> results = new SearchClient().collectAllFiles(directoryPath);
    if (results != null) {
      // JC Favor Java API Over DIY
      if (results.size() != 0) {
        int javaLOC = 0;
        int javaCommentLOC = 0;
        int javaNumMethod = 0;
        int javanImports = 0;

        int pyLOC = 0;
        int pyCommentLOC = 0;
        int pyNumMethod = 0;
        int pynImports = 0;

        // JC Favor For-Each Over For Loops
        for (int l = 0; l < results.size(); l = l + 1) {
          System.out.println(results.get(l).print());

          if (results.get(l).javaFile) {
            javaLOC += results.get(l).LOC;
            javaCommentLOC += results.get(l).commentLOC;
            javaNumMethod += results.get(l).numMethod;
            javanImports += results.get(l).nImports;
          } else {
            pyLOC += results.get(l).LOC;
            pyCommentLOC += results.get(l).commentLOC;
            pyNumMethod += results.get(l).numMethod;
            pynImports += results.get(l).nImports;
          }
        }

        return new AnalysisResult[] {
          new AnalysisResult(
              true, "Overall Java", javaLOC, javaCommentLOC, javaNumMethod, javanImports),
          new AnalysisResult(false, "Overall Python", pyLOC, pyCommentLOC, pyNumMethod, pynImports),
        };
      } else {
        return new AnalysisResult[] {new AnalysisResult()};
      }

      // JC Fail Fast
    }
    System.err.println("There was a problem with the result!");

    return null;
  }
}
