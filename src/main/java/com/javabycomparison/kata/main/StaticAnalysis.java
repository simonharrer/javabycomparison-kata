package com.javabycomparison.kata.main;

import java.util.LinkedList;

import com.javabycomparison.kata.analysis.ResultData;
import com.javabycomparison.kata.analysis.ResultDataPrinter;
import com.javabycomparison.kata.printing.ResultPrinter;
import com.javabycomparison.kata.search.SearchClient;

public class StaticAnalysis {

  public static void main(String... args) {
    analyze(args.length == 0 ? null : args[0], args.length == 2 ? args[1].equals("smry") : false);
  }

  // JC Split Method with Optional Parameters
  private static void analyze(String p, boolean smry) {
    StaticAnalysis analyzer = new StaticAnalysis();
    ResultData[] overallResult = analyzer.run(p == null ? "./src/" : p, smry);
    // JC Fail Fast
    // JC Avoid Negations
    if (overallResult != null) {
      ResultPrinter.printOverallResults(overallResult);
    } else {
      // JC Explain Cause in Message
      System.err.println("Something went terribly wrong");
    }
  }

  // JC Split Method with Boolean Parameters
  private ResultData[] run(String directoryPath, boolean smry) {
    LinkedList<ResultData> results = new SearchClient(smry).collectAllFiles(directoryPath);
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

        int LOC = 0;
        int commentLOC = 0;
        int numMethod = 0;
        int nImports = 0;

        // JC Favor For-Each Over For Loops
        for (int l = 0; l < results.size(); l = l + 1) {
          ResultData resultData = results.get(l);
          if (!smry) {
            System.out.println(new ResultDataPrinter().print(resultData));
          }
          if (resultData.type == 0) {
            javaLOC += resultData.LOC;
            javaCommentLOC += resultData.commentLOC;
            javaNumMethod += resultData.numMethod;
            javanImports += resultData.nImports;
          } else if (resultData.type == 1) {
            pyLOC += resultData.LOC;
            pyCommentLOC += resultData.commentLOC;
            pyNumMethod += resultData.numMethod;
            pynImports += resultData.nImports;
          } else {
            LOC += resultData.LOC;
            commentLOC += resultData.commentLOC;
            numMethod += resultData.numMethod;
            nImports += resultData.nImports;
          }
        }
        // JC Document Implementation Decisions
        return new ResultData[] {
          new ResultData(0, "Overall Java", javaLOC, javaCommentLOC, javaNumMethod, javanImports),
          new ResultData(1, "Overall Python", pyLOC, pyCommentLOC, pyNumMethod, pynImports),
          new ResultData(2, "Overall Other", LOC, commentLOC, numMethod, nImports),
        };
      } else {
        return new ResultData[] {new ResultData()};
      }

      // JC Fail Fast
    }
    // JC Explain Cause in Message
    System.err.println("There was a problem with the result!");

    return null;
  }
}
