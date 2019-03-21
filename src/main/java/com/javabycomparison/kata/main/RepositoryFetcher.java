package com.javabycomparison.kata.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class RepositoryFetcher {
  String reposRoot = "./repos/";

  // JC Use Domain Terminology
  public void loadProjectFiles(String url) throws GitAPIException {
    // JC Avoid NullPointerException in Conditionals
    if (url.trim() == null || url.trim().isEmpty() || !url.contains("https://")) {
      // Invalid url!
      return;
    }

    String destinationFile = reposRoot + url.split("/")[url.split("/").length - 1] + "/";
    deleteStaleDir(determinePathExistence(destinationFile));

    Git.cloneRepository().setURI(url).setDirectory(new File(destinationFile)).call().close();
  }

  // JC Avoid Optional Fields or Parameters
  private void deleteStaleDir(Optional<Path> destinationDir) {
    if (destinationDir.isPresent()) {
      try {
        // JC Avoid Side Effects
        Files.walk(destinationDir.get())
            // JC Favor Method References Over Lambdas
            .map(path -> path.toFile())
            // JC Document Design Decisions
            .sorted((o1, o2) -> -o1.compareTo(o2))
            // JC Favor Method References Over Lambdas
            .forEach(file -> file.delete());
      } catch (IOException e) {
        // JC Explain Empty Catch
      }
    }
  }

  private Optional<Path> determinePathExistence(String destinationFile) {
    if (Files.exists(Paths.get(destinationFile))) {
      return Optional.of(Paths.get(destinationFile));
    } else {
      return Optional.empty();
    }
  }
}
