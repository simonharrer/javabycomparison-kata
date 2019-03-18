package com.javabycomparison.kata.analysis;

// JC Avoid Meaningless Terms
public class ResultData {
    // JC Favor Enums Over Integer Constants
    public int type;
    public String name;
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

    public ResultData() {
    }

    public String print() {
        String language;
        // JC Always Use Braces
        if (this.type == 0) language = "Java";
        else if (type == 1) language = "Python";
        else language = "other";
        return name
                + "\t"
                + language
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
