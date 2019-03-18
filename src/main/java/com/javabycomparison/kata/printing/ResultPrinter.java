package com.javabycomparison.kata.printing;

import java.util.Collections;
import java.util.stream.Stream;

import com.javabycomparison.kata.analysis.ResultData;

public class ResultPrinter {
    private static final String FILE_NAME = "File Name";

    public static void printOverallResults(ResultData[] overallResult) {

        ResultData r1 = overallResult[0];
        ResultData r2 = overallResult[1];

        System.out.println(
                FILE_NAME
                        + calculatePaddingFileName(r1, r2)
                        + "  Language "
                        + calculatePaddingLangauge(r1, r2)
                        + "  Lines of Code \t Number of Comments \t Number of Methods \t Number of Imports");

        System.out.println(overallResult[0].print() + "\n" + overallResult[1].print());
    }

    private static String calculatePaddingLangauge(ResultData r1, ResultData r2) {
        String languageR1 = (r1.type == 0 ? "Java" : "Python");
        String languageR2 = (r2.type == 0 ? "Java" : "Python");
        int asdf = Math.max(Math.max(languageR1.length(), languageR2.length()), "Language".length());
        return String.join("", Collections.nCopies(Math.max(asdf, 0), " "));
    }

    private static String calculatePaddingFileName(ResultData r1, ResultData r2) {
        int paddingFileName =
                Stream.of(("" + r1.name).length(), ("" + r2.name).length()).max(Integer::compareTo).get()
                        - FILE_NAME.length();
        return String.join("", Collections.nCopies(Math.max(paddingFileName, 0), " "));
    }
}
