package pac.option;
import java.net.URLConnection;

/**
 * This class represents a blocking option that blocks any URL connections with content type starting with "image/".
 * It implements the BlockingOption interface, which requires the implementation of the shouldBlock() method.
 * When shouldBlock() is called with a URLConnection object, this class checks the content type of the connection
 * and returns true if it starts with "image/". In this case, it also prints "denied" to the console to indicate
 * that the connection was blocked. If the content type is not an image, shouldBlock() returns false and the
 * connection is not blocked.
 * This class is intended to be used as part of a larger system for controlling access to web content.
 */

class BlockImagesOption implements BlockingOption {

    /**
     * @param connection the URL connection to check
     * @return true if the connection should be blocked, false otherwise
     */
    @Override
    public boolean shouldBlock(URLConnection connection) {
        String contentType = connection.getContentType();
        if (contentType != null)
            if (contentType.startsWith("image/")){
                System.out.println("denied");
                return true;
            }
        return false;
    }

}
