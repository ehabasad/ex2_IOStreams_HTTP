package pac.option;

import java.net.URLConnection;

/**
 * This interface defines a blocking option for URL connections. Classes that implement this interface provide
 * options for blocking connections based on specific criteria, such as content type or URL source.
 * The interface requires the implementation of a single method, shouldBlock(), which takes a URLConnection object
 * as a parameter and returns a boolean value indicating whether or not the connection should be blocked.
 * Implementing classes must define the criteria for blocking connections based on their specific use case.
 * This interface is intended to be used as part of a larger system for controlling access to web content.
 */
interface BlockingOption {

    /**
     * @param connection the URL connection to check
     * @return true if the connection should be blocked, false otherwise
     */
    boolean shouldBlock(URLConnection connection);
}
