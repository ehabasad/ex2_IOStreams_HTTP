package pac.option;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLConnection;

/**
 * This class provides an implementation of the BlockingOption interface that
 * blocks URLs listed in a file. It overrides the shouldBlock() method of the
 * interface to check whether the URL for a given URLConnection is listed in
 * the file "blocked.txt". If it is, the method returns true to indicate that
 * the URL should be blocked. If not, it returns false.
 *
 * If the URL is found in the "blocked.txt" file, a message is printed to the
 * console indicating that the URL has been denied access.
 */
public class BlockFileOption implements BlockingOption{

    /**
     * Determines whether the URL for the given URLConnection should be blocked
     * based on whether it is listed in the file "blocked.txt". If the URL is
     * listed, the method returns true to indicate that the URL should be blocked.
     * If not, it returns false.
     *
     * @param connection the URLConnection to check for blocked status
     * @return true if the URL should be blocked, false otherwise
     */
    @Override
    public boolean shouldBlock(URLConnection connection) {
        return isUrlBlocked(connection.getURL().toString());
    }

    /**
     * Reads the "blocked.txt" file and checks whether the given URL string is
     * listed in the file. If it is, the method returns true to indicate that
     * the URL should be blocked. If not, it returns false.
     *
     * If the URL is found in the "blocked.txt" file, a message is printed to the
     * console indicating that the URL has been denied access.
     *
     * @param urlStr the URL string to check for blocked status
     * @return true if the URL should be blocked, false otherwise
     */
    private boolean isUrlBlocked(String urlStr) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("blocked.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(urlStr)) {
                    reader.close();
                    System.out.println("denied");
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("cannot read blocked.txt");
        }
        return false;
    }
}
