package pac.command;

import pac.CommandType;

import java.util.List;



/**
 *
 * This class represents a download command, which is a type of command that is used to download a file from a specified URL.
 * It extends the Command class and implements the getUrl, getOutput, and getOptions methods.
 */
public class DownloadCommand extends Command {
    private final String url;
    private final String output;
    private final List<Character> options;


    /**
     * Constructs a DownloadCommand object with the specified URL, output, and options.
     *
     * @param url      the URL to block
     * @param output   the output to be displayed after the command is executed
     * @param options  the list of options to be used with the command
     */
    public DownloadCommand(String url, String output, List<Character> options) {
        super(CommandType.DOWNLOAD);
        this.url = url;
        this.output = output;
        this.options = options;
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
     * Returns the output associated with this command.
     *
     * @return the output
     */
    @Override
    public String getOutput() {
        return output;
    }

    /**
     * Returns the list of options associated with this command.
     *
     * @return the list of options
     */
    @Override
    public List<Character> getOptions() {
        return options;
    }
}
