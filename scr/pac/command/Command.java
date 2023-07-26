package pac.command;

import pac.CommandType;

import java.util.List;

/**
 * This is an abstract class that represents a command.
 * It defines the basic structure of a command object, including its type, URL, output, and options.
 *
 */
public abstract class Command {
    private final CommandType type;

    /**
     * Constructs a Command object with the specified type.
     *
     * @param type the type of the command
     */
    public Command(CommandType type) {
        this.type = type;
    }

    /**
     * Returns the type of this command.
     *
     * @return the type
     */
    public CommandType getType() {
        return type;
    }

    /**
     * Returns the URL associated with this command.
     *
     * @return the URL
     */
    public abstract String getUrl();

    /**
     * Returns the output associated with this command.
     *
     * @return the output
     */
    public abstract String getOutput();

    /**
     * Returns the list of options associated with this command.
     *
     * @return the list of options
     */
    public abstract List<Character> getOptions();
}
