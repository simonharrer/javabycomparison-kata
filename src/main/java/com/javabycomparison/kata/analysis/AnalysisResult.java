package com.javabycomparison.kata.analysis;

public class AnalysisResult {
  // JC Favor Enums Over Integer Constants
  public boolean javaFile;
  private String name;
  // JC Avoid Abbreviations
  public int LOC;
  public int commentLOC;
  public int numMethod;
  public int nImports;

  public AnalysisResult(
      boolean java, String name, int LOC, int commentLOC, int numMethod, int nImports) {
    this.javaFile = java;
    this.name = name;
    this.LOC = LOC;
    this.commentLOC = commentLOC;
    this.numMethod = numMethod;
    this.nImports = nImports;
  }

  // JC Remove Commented-Out Code
  /*
  public AnalysisResult(boolean java){
      this.javaFile = java;

  }
  */

  public AnalysisResult() {}

  public String print() {
    return name
        + "\t"
        + (this.javaFile ? "Java" : "Python")
        + "\t"
        + LOC
        + "\t"
        + commentLOC
        + "\t"
        + numMethod
        + "\t"
        + nImports;
  }
}
