package pac.option;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BlockingOptionFactory {

    // Size of the buffer for reading data in bytes
    private static final int BUFFER_SIZE = 4096;
    // Timeout in milliseconds for establishing the connection
    private static final int CONNECT_TIMEOUT = 5000;
    // Timeout in milliseconds for reading from the connection
    private static final int READ_TIMEOUT = 5000;
    private List<Character> denyingOptions;

    /**
     * Constructor for BlockingOptionFactory class
     *
     * @param denyingOptions a List of characters representing the options to be denied
     */
    public void BlockingOptionFactory(List<Character> denyingOptions) {
        this.denyingOptions = denyingOptions;
    }

    /**
     * Downloads a file from the specified URL and saves it with the specified file name.
     *
     * @param urlStr a String representing the URL of the file to download
     * @param fileName a String representing the file name to save the downloaded file
     */
    public void BlockingOptionFactory(String urlStr, String fileName) {
        try {
            // Create URL object
            URL url = new URL(urlStr);

            // Create HTTP connection
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setConnectTimeout(CONNECT_TIMEOUT); // Set connection timeout
            httpConn.setReadTimeout(READ_TIMEOUT); // Set read timeout

            // Check response code
            int responseCode = httpConn.getResponseCode();
            if (checkResponseCode(responseCode)) {
                System.out.println("<http codes other than 200>");
                return;
            }

            // Check if the requested URL is denied by one of the denying options
            boolean isDenied = isDenied(url.openConnection());
            if (isDenied) {
                return;
            }

            // Get input stream from connection
            InputStream inputStream = httpConn.getInputStream();

            // Create output stream to save downloaded file
            FileOutputStream outputStream = new FileOutputStream(fileName);

            // Read data from input stream and write to output stream
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Close streams
            outputStream.close();
            inputStream.close();

            System.out.println("Downloaded " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while downloading " + fileName + ": " + e.getMessage());
        }
    }

    /**
     * Checks the HTTP response code for errors
     *
     * @param responseCode an integer representing the HTTP response code
     * @return true if the response code is not HTTP_OK (200), false otherwise
     */
    private boolean checkResponseCode(int responseCode){
        return responseCode != HttpURLConnection.HTTP_OK;
    }

    /**
     * Checks if the requested URL is denied by one of the denying options
     *
     * @param connection a URLConnection object representing the connection to the URL
     * @return true if the URL is denied by one of the denying options, false otherwise
     */
    private boolean isDenied(URLConnection connection ) {

        for (Character option : denyingOptions) {
            switch (option) {
                case 'i' -> {
                    if(new BlockImagesOption().shouldBlock(connection)){
                        return true;
                    }
                }
                case 'c' -> {
                    if(new BlockCookiesOption().shouldBlock(connection)){
                        return true;
                    }
                }
                case 'h' -> {
                    if(new BlockHTMLOption().shouldBlock(connection)){
                        return true;
                    }
                }
                case 'b' -> {
                    if(new BlockFileOption().shouldBlock(connection)){
                        return true;
                    }
                }
                default ->{
                    System.out.println("invalid option");
                    return true;
                }
            }
        }
        return false;
    }

}