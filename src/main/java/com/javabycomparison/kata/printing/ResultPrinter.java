package com.javabycomparison.kata.printing;

import java.util.Collections;

import com.javabycomparison.kata.analysis.ResultData;

public class ResultPrinter {
  // JC Remove Superfluous Comments
  // These are the Strings of the metrics
  private static final String FILE_NAME = "File Name";
  private static final String LANGUAGE = "  Language";
  private static final String LOC = "  Lines of Code";
  private static final String COMMENT_LOC = "  Number of Comments";
  private static final String NUM_METHODS = "  Number of Methods";
  private static final String N_IMPORTS = "  Number of Imports";

  // JC Document Using Examples
  // JC Structure JavaDoc of Methods
  public static void printOverallResults(ResultData[] overallResult) {

    // JC Avoid Meaningless Terms
    // JC Avoid Abbreviations
    ResultData r1 = overallResult[0];
    // JC Avoid Meaningless Terms
    // JC Avoid Abbreviations
    ResultData r2 = overallResult[1];

    // JC Avoid Meaningless Terms
    StringBuilder stringBuilderForHeader = new StringBuilder();
    // JC Avoid Meaningless Terms
    StringBuilder stringBuilderForFirstResult = new StringBuilder();
    // JC Avoid Meaningless Terms
    StringBuilder stringBuilderForSecondResult = new StringBuilder();
    // JC Group with New Lines
    stringBuilderForHeader
        .append(
            String.join(
                "",
                Collections.nCopies(
                    Math.max(calculateFileNameLength(r1, r2) - FILE_NAME.length(), 0), " ")))
        .append(FILE_NAME);
    stringBuilderForFirstResult.append(r1.printFileName(calculateFileNameLength(r1, r2)));
    stringBuilderForSecondResult.append(r2.printFileName(calculateFileNameLength(r1, r2)));
    stringBuilderForHeader
        .append(
            String.join(
                "",
                Collections.nCopies(
                    Math.max(calculateLanguageLength(r1, r2) - LANGUAGE.length(), 0), " ")))
        .append(LANGUAGE);
    stringBuilderForFirstResult.append(r1.printLanguage(calculateLanguageLength(r1, r2)));
    stringBuilderForSecondResult.append(r2.printLanguage(calculateLanguageLength(r1, r2)));
    stringBuilderForHeader
        .append(
            String.join(
                "",
                Collections.nCopies(Math.max(calculateLOCLength(r1, r2) - LOC.length(), 0), " ")))
        .append(LOC);
    stringBuilderForFirstResult.append(r1.printLOC(calculateLOCLength(r1, r2)));
    stringBuilderForSecondResult.append(r2.printLOC(calculateLOCLength(r1, r2)));
    stringBuilderForHeader
        .append(
            String.join(
                "",
                Collections.nCopies(
                    Math.max(calculateCommentLOCLength(r1, r2) - COMMENT_LOC.length(), 0), " ")))
        .append(COMMENT_LOC);
    stringBuilderForFirstResult.append(r1.printCommentLOC(calculateCommentLOCLength(r1, r2)));
    stringBuilderForSecondResult.append(r2.printCommentLOC(calculateCommentLOCLength(r1, r2)));
    stringBuilderForHeader
        .append(
            String.join(
                "",
                Collections.nCopies(
                    Math.max(calculateNumMethodsLength(r1, r2) - NUM_METHODS.length(), 0), " ")))
        .append(NUM_METHODS);
    stringBuilderForFirstResult.append(r1.printNumMethodLOC(calculateNumMethodsLength(r1, r2)));
    stringBuilderForSecondResult.append(r2.printNumMethodLOC(calculateNumMethodsLength(r1, r2)));
    stringBuilderForHeader
        .append(
            String.join(
                "",
                Collections.nCopies(
                    Math.max(calculateNImportsLength(r1, r2) - N_IMPORTS.length(), 0), " ")))
        .append(N_IMPORTS);
    stringBuilderForFirstResult.append(r1.printNImportsLOC(calculateNImportsLength(r1, r2)));
    stringBuilderForSecondResult.append(r2.printNImportsLOC(calculateNImportsLength(r1, r2)));
    System.out.println(stringBuilderForHeader.toString());
    System.out.println(stringBuilderForFirstResult.toString());
    System.out.println(stringBuilderForSecondResult.toString());
  }

  // JC Avoid Abbreviations
  private static int calculateFileNameLength(ResultData r1, ResultData r2) {
    // JC Favor Functional over Imperative Style
    // JC Favor Java API over DIY
    // JC Replace Comments with Utility Methods
    // returns the length of the longest string of the three
    return Math.max(
        Math.max(String.valueOf(r1.name).length(), String.valueOf(r2.name).length()),
        FILE_NAME.length());
  }

  // JC Avoid Abbreviations
  private static int calculateLanguageLength(ResultData r1, ResultData r2) {
    // JC Avoid Unnecessary Comparisons
    String languageR1 = (r1.type == 0) == true ? "Java" : "Python";
    // JC Avoid Unnecessary Comparisons
    String languageR2 = (r2.type == 0) == true ? "Java" : "Python";

    // JC Favor Functional over Imperative Style
    // JC Replace Comments with Utility Methods
    // returns the length of the longest string of the three
    return Math.max(Math.max(languageR1.length(), languageR2.length()), LANGUAGE.length());
  }

  // JC Avoid Abbreviations
  private static int calculateLOCLength(ResultData r1, ResultData r2) {
    // JC Favor Functional over Imperative Style
    // JC Replace Comments with Utility Methods
    // returns the length of the longest string of the three
    return Math.max(
        Math.max(String.valueOf(r1.LOC).length(), String.valueOf(r2.LOC).length()), LOC.length());
  }

  // JC Avoid Abbreviations
  private static int calculateCommentLOCLength(ResultData r1, ResultData r2) {
    // JC Favor Functional over Imperative Style
    // JC Replace Comments with Utility Methods
    // returns the length of the longest string of the three
    return Math.max(
        Math.max(String.valueOf(r1.commentLOC).length(), String.valueOf(r2.commentLOC).length()),
        COMMENT_LOC.length());
  }

  // JC Avoid Abbreviations
  private static int calculateNumMethodsLength(ResultData r1, ResultData r2) {
    // JC Favor Functional over Imperative Style
    // JC Replace Comments with Utility Methods
    // returns the length of the longest string of the three
    return Math.max(
        Math.max(String.valueOf(r1.numMethod).length(), String.valueOf(r2.numMethod).length()),
        NUM_METHODS.length());
  }

  // JC Avoid Abbreviations
  private static int calculateNImportsLength(ResultData r1, ResultData r2) {
    // JC Favor Functional over Imperative Style
    // JC Replace Comments with Utility Methods
    // returns the length of the longest string of the three
    return Math.max(
        Math.max(String.valueOf(r1.nImports).length(), String.valueOf(r2.nImports).length()),
        N_IMPORTS.length());
  }
}
