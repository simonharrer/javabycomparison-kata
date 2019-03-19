package com.javabycomparison.kata.printing;

import com.javabycomparison.kata.analysis.ResultData;
import com.javabycomparison.kata.analysis.ResultDataPrinter;
import java.util.Collections;

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
    // JC Avoid Abbreviations
    ResultDataPrinter rdp = new ResultDataPrinter();
    stringBuilderForFirstResult.append(rdp.printFileName(r1, calculateFileNameLength(r1, r2)));
    stringBuilderForSecondResult.append(rdp.printFileName(r2, calculateFileNameLength(r1, r2)));
    stringBuilderForHeader
        .append(
            String.join(
                "",
                Collections.nCopies(
                    Math.max(calculateLanguageLength(r1, r2) - LANGUAGE.length(), 0), " ")))
        .append(LANGUAGE);
    stringBuilderForFirstResult.append(rdp.printLanguage(r1, calculateLanguageLength(r1, r2)));
    stringBuilderForSecondResult.append(rdp.printLanguage(r2, calculateLanguageLength(r1, r2)));
    stringBuilderForHeader
        .append(
            String.join(
                "",
                Collections.nCopies(Math.max(calculateLOCLength(r1, r2) - LOC.length(), 0), " ")))
        .append(LOC);
    stringBuilderForFirstResult.append(rdp.printLOC(r1, calculateLOCLength(r1, r2)));
    stringBuilderForSecondResult.append(rdp.printLOC(r2, calculateLOCLength(r1, r2)));
    stringBuilderForHeader
        .append(
            String.join(
                "",
                Collections.nCopies(
                    Math.max(calculateCommentLOCLength(r1, r2) - COMMENT_LOC.length(), 0), " ")))
        .append(COMMENT_LOC);
    stringBuilderForFirstResult.append(rdp.printCommentLOC(r1, calculateCommentLOCLength(r1, r2)));
    stringBuilderForSecondResult.append(rdp.printCommentLOC(r2, calculateCommentLOCLength(r1, r2)));
    stringBuilderForHeader
        .append(
            String.join(
                "",
                Collections.nCopies(
                    Math.max(calculateNumMethodsLength(r1, r2) - NUM_METHODS.length(), 0), " ")))
        .append(NUM_METHODS);
    stringBuilderForFirstResult.append(
        rdp.printNumMethodLOC(r1, calculateNumMethodsLength(r1, r2)));
    stringBuilderForSecondResult.append(
        rdp.printNumMethodLOC(r2, calculateNumMethodsLength(r1, r2)));
    stringBuilderForHeader
        .append(
            String.join(
                "",
                Collections.nCopies(
                    Math.max(calculateNImportsLength(r1, r2) - N_IMPORTS.length(), 0), " ")))
        .append(N_IMPORTS);
    stringBuilderForFirstResult.append(rdp.printNImportsLOC(r1, calculateNImportsLength(r1, r2)));
    stringBuilderForSecondResult.append(rdp.printNImportsLOC(r2, calculateNImportsLength(r1, r2)));
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
