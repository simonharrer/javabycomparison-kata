package com.javacomp.bmwkata.analysis;

import java.io.IOException;
import java.nio.file.Path;

public abstract class AnaLyzer {

    public Path file;

    public abstract AnalysisResult analyze() throws IOException;
}
