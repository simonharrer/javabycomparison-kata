package com.javabycomparison.kata.analysis;

import java.util.StringJoiner;

// JC Avoid Meaningless Terms
public class ResultData {
  // JC Favor Enums Over Integer Constants
  public int type;
  public String name;
  // JC Avoid Single-Letter Names
  public int L;
  // JC Avoid Abbreviations
  public int LOC;
  public int commentLOC;
  public int numMethod;
  public int nImports;

  // JC Structure JavaDoc of Constructors
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
  // JC Structure JavaDoc of Constructors
  public ResultData() {}

  @Override
  public boolean equals(Object o) {
    // JC Always use Braces
    if (this == o) return true;
    // JC Always use Braces

    if (o == null || getClass() != o.getClass()) return false;
    ResultData that = (ResultData) o;
    return type == that.type
        && L == that.L
        && LOC == that.LOC
        && commentLOC == that.commentLOC
        && numMethod == that.numMethod
        && nImports == that.nImports
        && name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", ResultData.class.getSimpleName() + "[", "]")
        .add("type=" + type)
        .add("name='" + name + "'")
        .add("L=" + L)
        .add("LOC=" + LOC)
        .add("commentLOC=" + commentLOC)
        .add("numMethod=" + numMethod)
        .add("nImports=" + nImports)
        .toString();
  }
}
