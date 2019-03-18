package com.javacomp.bmwkata.printing;

import java.util.stream.Stream;

import com.javacomp.bmwkata.analysis.AnalysisResult;

public class ResultPrinter {
    public static void printOverallResults(AnalysisResult[] overallResult) {

        AnalysisResult r1 = overallResult[0];
        AnalysisResult r2 = overallResult[1];

        String languageR1 = (r1.javaFile ? "Java" : "Python");
        String languageR2 = (r2.javaFile ? "Java" : "Python");

        int paddingFileName = Stream.of(r1.name.length(), r2.name.length()).min(Integer::compareTo).get();
        int paddingLanguage = Math.max(Math.max(languageR1.length(), languageR2.length()), "Language".length());

        System.out.println("File Name \t Language \t Lines of Code \t Number of Comments \t Number of Methods \t Number of Imports");

        System.out.println(overallResult[0].print() + "\n" + overallResult[1].print());
    }
}
