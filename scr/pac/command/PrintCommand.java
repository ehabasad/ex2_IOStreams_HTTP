package pac.command;

import pac.CommandType;

import java.util.List;

/**
 * This class represents a print command, which is a type of command that is used to print output to the console.
 * It extends the Command class and implements the getUrl, getOutput, and getOptions methods.
 *
 */
public class PrintCommand extends Command {

    /**
     * Constructs a PrintCommand object.
     */
    public PrintCommand() {
        super(CommandType.PRINT);
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


