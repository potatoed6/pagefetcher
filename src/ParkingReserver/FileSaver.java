package ParkingReserver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSaver {
    public void saveFile(String file) {
        if (file == null) {
            System.out.println("ERROR: File is null!");
            return;
        }

        String fileName = "saved_page";

        Path target = Path.of(fileName);

        try {
            Files.writeString(target, file);
            System.out.println("Successfully saved " + fileName + " at " + target.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("ERROR: Couldn't save file: " + e.getMessage());
        }
    }
}
