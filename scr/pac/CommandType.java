package pac;

/**
 * An enumeration representing the different command types that can be parsed by the CommandParser.
 */
public enum CommandType {

    BLOCK("b"),    // Block command
    UNBLOCK("u"),  // Unblock command
    PRINT("p"),    // Print command
    DOWNLOAD("d"), // Download command
    QUIT("q"),     // Quit command
    INVALID("");   // Invalid command

    private final String commandCode;

    /**
     * Constructor for the enumeration. Sets the command code.
     *
     * @param code the code associated with the command type
     */
    CommandType(String code) {
        this.commandCode = code;
    }

    /**
     * Gets the command code associated with this command type.
     *
     * @return the command code associated with this command type
     */
    public String getCommandCode() {
        return commandCode;
    }

}
