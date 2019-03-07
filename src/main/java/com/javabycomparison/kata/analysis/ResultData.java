package com.javabycomparison.kata.analysis;

// JC Avoid Meaningless Terms
public class ResultData {
  // JC Favor Enums Over Integer Constants
  public int type;
  private String name;
  // JC Avoid Abbreviations
  public int L;
  public int LOC;
  public int commentLOC;
  public int numMethod;
  public int nImports;

  public ResultData(int type, String name, int LOC, int commentLOC, int numMethod, int nImports) {
    this.type = type;
    this.name = name;
    this.LOC = LOC;
    this.commentLOC = commentLOC;
    this.numMethod = numMethod;
    this.nImports = nImports;
  }

  // JC Remove Commented-Out Code
  /*
  public ResultData(boolean java){
      this.javaFile = java;

  }
  */

  public ResultData() {}

  public String print() {
    return name
        + "\t"
        + (this.type == 0 ? "Java" : type == 1 ? "Python" : "other")
        + "\t"
        + L
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
