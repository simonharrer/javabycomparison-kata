package com.javabycomparison.kata.analysis;

import java.util.Collections;

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

  // JC Document Using Examples
  // JC Structure JavaDoc of Methods
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

  public String printFileName(int length) {
    // JC Favor Format over Concatenation
    return String.join("", Collections.nCopies(Math.max(length - this.name.length(), 0), " "))
        + this.name;
  }

  public String printLanguage(int length) {
    String language;
    // JC Always Use Braces
    if (this.type == 0) language = "Java";
    else if (type == 1) language = "Python";
    else language = "other";
    // JC Favor Format over Concatenation
    return String.join("", Collections.nCopies(Math.max(length - language.length(), 0), " "))
        + language;
  }

  public String printLOC(int length) {
    // JC Favor Format over Concatenation
    return String.join(
            "", Collections.nCopies(Math.max(length - String.valueOf(this.LOC).length(), 0), " "))
        + this.LOC;
  }

  public String printCommentLOC(int length) {
    // JC Favor Format over Concatenation
    return String.join(
            "",
            Collections.nCopies(
                Math.max(length - String.valueOf(this.commentLOC).length(), 0), " "))
        + this.commentLOC;
  }

  public String printNumMethodLOC(int length) {
    // JC Favor Format over Concatenation
    return String.join(
            "",
            Collections.nCopies(Math.max(length - String.valueOf(this.numMethod).length(), 0), " "))
        + this.numMethod;
  }

  public String printNImportsLOC(int length) {
    // JC Favor Format over Concatenation
    return String.join(
            "",
            Collections.nCopies(Math.max(length - String.valueOf(this.nImports).length(), 0), " "))
        + this.nImports;
  }

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
    return print();
  }
}
