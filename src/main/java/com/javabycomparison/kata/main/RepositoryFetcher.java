package com.javabycomparison.kata.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class RepositoryFetcher {
  String reposRoot = "./src/main/resources/repos/";

  public void getRepository(String url) throws GitAPIException {

    String repoName = url.split("/")[url.split("/").length - 1];
    String destinationFile = reposRoot + repoName + "/";

    if (Files.exists(Paths.get(destinationFile))) {
      try {
        Files.walk(Paths.get(destinationFile))
            .map(path -> path.toFile())
            .sorted((o1, o2) -> -o1.compareTo(o2))
            .forEach(file -> file.delete());
        Files.deleteIfExists(Paths.get(destinationFile));
      } catch (IOException e) {
        // JC Explain Empty Catch
      }
    }
    Git.cloneRepository().setURI(url).setDirectory(new File(destinationFile)).call();
  }
}
