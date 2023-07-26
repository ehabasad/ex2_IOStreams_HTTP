package pac.execute;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * A class that manages a list of blocked URLs.
 */
class BlockedSites {
    // Set to store the blocked URLs
    private final Set<String> blockedUrls = new HashSet<>();
    // Name of the file where the blocked URLs are saved
    private final String fileName = "blocked.txt";

    /**
     * Constructor for the BlockedSites class.
     * Initializes the blockedUrls set by loading the list of blocked URLs from the file.
     */
    BlockedSites() {
        loadBlockedUrls();
    }

    /**
     * Adds a URL to the blockedUrls set.
     * @param url The URL to block.
     */
    void block(String url) {
        if (!isValidUrl(url)) {
            System.out.println("invalid URL");
            return;
        } else if(isBlocked(url)) {
            System.out.println("URL already blocked");
            return;
        } if (blockedUrls.add(url)) {
            saveBlockedUrls();
            System.out.println("URL blocked successfully.");
        } else {
            System.out.println("cannot write blocked.txt");
        }

    }

    /**
     * Removes a URL from the blockedUrls set.
     * @param url The URL to unblock.
     */
    void unblock(String url) {
        if (isBlocked(url)){
            if(blockedUrls.remove(url)){
                saveBlockedUrls();
                System.out.println("URL unblocked successfully.");
            } else {
                System.out.println("cannot write blocked.txt");
            }
        } else {
            System.out.println("invalid command");
        }
    }

    /**
     * Checks if a URL is blocked.
     * @param url The URL to check.
     * @return true if the URL is blocked, false otherwise.
     */
    boolean isBlocked(String url) {
        return blockedUrls.contains(url);
    }

    /**
     * Reads the list of blocked URLs from the blocked.txt file and returns it as a List.
     * @return The list of blocked URLs.
     */
    public static List<String> getBlockedUrls() {
        List<String> blockedUrls = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("blocked.txt"))) {
            while (scanner.hasNextLine()) {
                String url = scanner.nextLine().trim();
                if (!url.isEmpty()) {
                    blockedUrls.add(url);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("cannot read blocked.txt");
        }

        return blockedUrls;
    }

    /**
     * Loads the list of blocked URLs from the blocked.txt file into the blockedUrls set.
     */
    private void loadBlockedUrls() {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    blockedUrls.add(line.trim());
                }
                reader.close();
            }
        } catch (IOException e) {
            System.out.println("cannot read blocked.txt");
        }
    }

    /**
     * Writes the list of blocked URLs from the blockedUrls set to the blocked.txt file.
     */
    private void saveBlockedUrls() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (String url : blockedUrls) {
                writer.write(url);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("cannot write blocked.txt");
        }
    }

    /**
     * prints the list of blocked URLs to the console, sorted alphabetically.
     * If the list is empty, it prints a message indicating that there are no blocked URLs.
     */
    public static void printBlockedUrls() {
        try {
            List<String> blockedUrls = getBlockedUrls();
            if (!blockedUrls.isEmpty()) {
                System.out.println("Blocked URLs :");
                Collections.sort(blockedUrls);
                for (String url : blockedUrls) {
                    System.out.println(url);
                }
            }
        } catch (Exception e) {
            System.out.println("cannot read blocked.txt");
        }
    }

    /**
     * checks if the given string url is a valid URL.
     * @param url The URL to check.
     * @return true if the url is vaild
     */
    private boolean isValidUrl(String url) {
        try {
            new URL(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
