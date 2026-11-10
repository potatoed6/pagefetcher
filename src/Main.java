import ParkingReserver.FileSaver;
import ParkingReserver.PageFetcher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PageFetcher _pageFetcher = new PageFetcher();
        FileSaver _fileSaver = new FileSaver();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your URL: ");
        String page = scanner.nextLine();
        System.out.println("Trying to fetch...");

        String fetchedPage = _pageFetcher.fetchPage(page);

        _fileSaver.saveFile(fetchedPage);
    }

}




