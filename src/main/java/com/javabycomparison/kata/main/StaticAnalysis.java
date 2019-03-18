package com.javabycomparison.kata.main;

import java.util.LinkedList;

import com.javabycomparison.kata.analysis.ResultData;
import com.javabycomparison.kata.printing.ResultPrinter;
import com.javabycomparison.kata.search.SearchClient;

public class StaticAnalysis {

    public static void main(String[] args) {
        StaticAnalysis analyzer = new StaticAnalysis();
        ResultData[] overallResult = analyzer.run(args.length == 0 ? "./src/" : args[0]);
        // JC Fail Fast
        // JC Avoid Negations
        if (overallResult != null) {
            ResultPrinter.printOverallResults(overallResult);
        } else {
            System.err.println("Something went terribly wrong");
        }
    }

    private ResultData[] run(String directoryPath) {
        LinkedList<ResultData> results = new SearchClient().collectAllFiles(directoryPath);
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
                    System.out.println(results.get(l).print());

                    if (results.get(l).type == 0) {
                        javaLOC += results.get(l).LOC;
                        javaCommentLOC += results.get(l).commentLOC;
                        javaNumMethod += results.get(l).numMethod;
                        javanImports += results.get(l).nImports;
                    } else if (results.get(l).type == 1) {
                        pyLOC += results.get(l).LOC;
                        pyCommentLOC += results.get(l).commentLOC;
                        pyNumMethod += results.get(l).numMethod;
                        pynImports += results.get(l).nImports;
                    } else {
                        LOC += results.get(l).LOC;
                        commentLOC += results.get(l).commentLOC;
                        numMethod += results.get(l).numMethod;
                        nImports += results.get(l).nImports;
                    }
                }

                return new ResultData[]{
                        new ResultData(0, "Overall Java", javaLOC, javaCommentLOC, javaNumMethod, javanImports),
                        new ResultData(1, "Overall Python", pyLOC, pyCommentLOC, pyNumMethod, pynImports),
                        new ResultData(2, "Overall Other", LOC, commentLOC, numMethod, nImports),
                };
            } else {
                return new ResultData[]{new ResultData()};
            }

            // JC Fail Fast
        }
        System.err.println("There was a problem with the result!");

        return null;
    }
}
