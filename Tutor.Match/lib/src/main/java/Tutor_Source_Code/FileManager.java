package Tutor_Source_Code;

import java.io.File;
import java.io.IOException;

public class FileManager {
    // Specify the directory
    private String directoryName = "data";

    public FileManager() {
        // Create the directory if it doesn't exist
        File directory = new File(directoryName);
        if (!directory.exists()) {
            boolean directoryCreated = directory.mkdirs();
            if (!directoryCreated) {
                System.err.println("Failed to create the directory.");
            } else {
                System.out.println("Directory created: " + directory.getAbsolutePath());
            }
        }
    }

    public File createOrAccessFile(String fileName) {
        File file = new File(directoryName, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
                // If the file is newly created, you can initialize it with default data if needed.
            } else {
                System.out.println("File already exists: " + file.getAbsolutePath());
                // If the file already exists, you can read and process it as needed.
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to create or access the file.");
        }
        return file;
    }
}
