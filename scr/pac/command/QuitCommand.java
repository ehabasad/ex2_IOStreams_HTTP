package pac.command;

import pac.CommandType;

import java.util.List;

/**
 * This class represents a quit command, which is a type of command that is used to quit the console.
 */
public class QuitCommand extends Command {

    /**
     * Constructs a QuitCommand object.
     */
    public QuitCommand() {
        super(CommandType.QUIT);
    }
    /**
     * Returns null because this command has no associated URL.
     *
     * @return null
     */
    @Override
    public String getUrl() {
        return null;
    }
    /**
     * Returns null because this command has no associated output.
     *
     * @return null
     */
    @Override
    public String getOutput() {
        return null;
    }

    /**
     * Returns null because this command has no associated options.
     *
     * @return null
     */
    @Override
    public List<Character> getOptions() {
        return null;
    }
}

