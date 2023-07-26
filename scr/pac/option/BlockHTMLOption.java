package pac.option;

import java.net.URLConnection;

/**
 * This class represents a blocking option that blocks any URL connections with content type "text/html".
 *  It implements the BlockingOption interface, which requires the implementation of the shouldBlock() method.
 *  When shouldBlock() is called with a URLConnection object, this class checks the content type of the connection
 *  and returns true if it starts with "text/html". In this case, it also prints "denied" to the console to indicate
 *  that the connection was blocked. If the content type is not "text/html", shouldBlock() returns false and the
 *  connection is not blocked.
 *  This class is intended to be used as part of a larger system for controlling access to web content.
 *
 */
class BlockHTMLOption implements BlockingOption {

    /**
     * Checks whether the given URL connection should have html blocked based on
     * its "text/html" header field. If the header field is present, the method
     * prints a message to the console indicating that html have been denied and
     * returns true. Otherwise, it returns false.
     *
     * @param connection the URLConnection to check for cookies
     * @return true if cookies should be blocked, false otherwise
     */
    @Override
    public boolean shouldBlock(URLConnection connection) {
        String contentType = connection.getContentType();
        if (contentType != null)
            if (contentType.startsWith("text/html")){
                System.out.println("denied");
                return true;
            }
        return false;
    }
}