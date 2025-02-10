
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

public class FileConverter {

    public static void main(String[] args) {
        try {
            Path sourceDir = Paths.get(".");
            Path currentFile = Paths.get(FileConverter.class.getSimpleName() + ".java");
            Map<String, List<Path>> filesByFolder = new HashMap<>();

            Files.walk(sourceDir)
                    .filter(path -> path.toString().endsWith(".java"))
                    .filter(path -> !path.getFileName().equals(currentFile)) // Skip FileConverter.java
                    .filter(path -> !path.toString().contains("miniprojects"))
                    .forEach(javaFile -> {
                        String folderName = javaFile.getParent().getFileName().toString();
                        filesByFolder.computeIfAbsent(folderName, k -> new ArrayList<>())
                                .add(javaFile);
                    });

            // Process each folder
            filesByFolder.forEach((folderName, javaFiles) -> {
                if (javaFiles.isEmpty()) {
                    return;  // Skip empty folders
                }
                String zipFileName = folderName + ".zip";
                try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName))) {
                    for (Path javaFile : javaFiles) {
                        try {
                            String fileName = javaFile.getFileName().toString();
                            String txtFileName = folderName + "_"
                                    + fileName.substring(0, fileName.length() - 5) + ".txt";

                            String content = Files.readString(javaFile);
                            String newContent = folderName + "\n\n" + content;

                            ZipEntry entry = new ZipEntry(txtFileName);
                            zos.putNextEntry(entry);
                            zos.write(newContent.getBytes());
                            zos.closeEntry();

                            System.out.println("Processed: " + txtFileName + " -> " + zipFileName);
                        } catch (IOException e) {
                            System.err.println("Error processing " + javaFile + ": " + e.getMessage());
                        }
                    }
                    System.out.println("\nCreated zip file: " + zipFileName);
                } catch (IOException e) {
                    System.err.println("Error creating zip file " + zipFileName + ": " + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
