package pac.option;


import java.net.URLConnection;

/**
 * This class provides an implementation of the BlockingOption interface that
 * blocks cookies for a URL connection. It overrides the shouldBlock() method of
 * the interface to check the connection's "Set-Cookie" header field for any
 * cookies, and returns true if the header is present (i.e., if there are
 * cookies to block).
 *
 * If the "Set-Cookie" header is present, a message is printed to the console
 * indicating that the cookies have been denied. If the header is not present,
 * the method returns false to indicate that cookies should not be blocked.
 */
class BlockCookiesOption implements BlockingOption {

    /**
     * Checks whether the given URL connection should have cookies blocked based on
     * its "Set-Cookie" header field. If the header field is present, the method
     * prints a message to the console indicating that cookies have been denied and
     * returns true. Otherwise, it returns false.
     *
     * @param connection the URLConnection to check for cookies
     * @return true if cookies should be blocked, false otherwise
     */
    @Override
    public boolean shouldBlock(URLConnection connection) {
        String cookieHeader = connection.getHeaderField("Set-Cookie");
        if (cookieHeader != null) {
            System.out.println("denied");
            return true;
        }
        else
            return false;
    }

}