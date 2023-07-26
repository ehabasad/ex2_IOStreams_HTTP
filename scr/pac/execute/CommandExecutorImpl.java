package pac.execute;

import pac.command.Command;
import pac.option.BlockingOptionFactory;

/**
 * This class provides a concrete implementation of the CommandExecutor abstract
 * class. It uses the BlockedSites and BlockingOptionFactory classes to perform
 * specific actions related to blocking and unblocking URLs.
 *
 * The class overrides the execute() method of the CommandExecutor class to
 * handle different types of commands. If the command type is DOWNLOAD, the
 * BlockingOptionFactory is used to create blocking options for the command, and
 * the command URL and output are also passed to the BlockingOptionFactory. If
 * the command type is BLOCK, the blockedSites instance variable is used to
 * block the specified URL. If the command type is UNBLOCK, the blockedSites
 * instance variable is used to unblock the specified URL. If the command type
 * is PRINT, the BlockedSites class is used to print a list of all currently
 * blocked URLs. If the command type is QUIT, the program is exited.
 *
 * The constructor initializes the blockedSites and blockingOptionFactory
 * instance variables by creating new instances of the BlockedSites and
 * BlockingOptionFactory classes, respectively.
 */
public class CommandExecutorImpl extends CommandExecutor {
    private final BlockedSites blockedSites;
    private final BlockingOptionFactory blockingOptionFactory;

    /**
     * Creates a new CommandExecutorImpl instance by initializing the blockedSites
     * and blockingOptionFactory instance variables with new instances of the
     * BlockedSites and BlockingOptionFactory classes, respectively.
     */
    CommandExecutorImpl() {
        blockingOptionFactory = new BlockingOptionFactory();
        blockedSites = new BlockedSites();

    }

    /**
     * Executes the given Command. The method uses a switch statement to determine
     * which action to take based on the type of the command. If the command type is
     * DOWNLOAD, the BlockingOptionFactory is used to create blocking options for
     * the command, and the command URL and output are also passed to the
     * BlockingOptionFactory. If the command type is BLOCK, the blockedSites
     * instance variable is used to block the specified URL. If the command type is
     * UNBLOCK, the blockedSites instance variable is used to unblock the specified
     * URL. If the command type is PRINT, the BlockedSites class is used to print a
     * list of all currently blocked URLs. If the command type is QUIT, the program
     * is exited. If the command type is not recognized, a message is printed to the
     * console indicating that the command is invalid.
     *
     * @param command the Command to execute
     */
    @Override
    public void execute(Command command) {
        switch (command.getType()) {
            case DOWNLOAD -> {
                blockingOptionFactory.BlockingOptionFactory(command.getOptions());
                blockingOptionFactory.BlockingOptionFactory(command.getUrl(), command.getOutput());
            }
            case BLOCK -> blockedSites.block(command.getUrl());
            case UNBLOCK -> blockedSites.unblock(command.getUrl());
            case PRINT -> BlockedSites.printBlockedUrls();
            case QUIT -> {
                System.out.println("Exiting program...");
                System.exit(0);
            }
            default -> System.out.println("invalid command");
        }
    }
}
