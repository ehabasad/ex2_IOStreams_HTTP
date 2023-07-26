package pac.command;

import pac.CommandType;

import java.util.List;

/**
 * This class represents a block command, which is a type of command that is used to block a specific URL.
 * It extends the Command class and implements the getUrl methods.
 */
public class BlockCommand extends Command {
    private final String url;

    /**
     * Constructs a BlockCommand object with the specified URL, output, and options.
     *
     * @param url  the URL to block
     */
    public BlockCommand(String url) {
        super(CommandType.BLOCK);
        this.url = url;
    }
    /**
     * Returns the URL associated with this command.
     *
     * @return the URL
     */
    @Override
    public String getUrl() {
        return url;
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
