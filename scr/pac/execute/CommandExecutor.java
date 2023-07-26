package pac.execute;

import pac.command.Command;

/**
 * This abstract class provides a framework for executing commands. Subclasses of
 * CommandExecutor can be created to provide specific behavior for executing
 * different types of commands. The class uses lazy initialization to create a
 * single instance of the CommandExecutorImpl class, which is assumed to be a
 * concrete implementation of this abstract class. This allows for a single
 * instance of CommandExecutor to be shared across the application, providing
 * consistent behavior and reducing memory usage. The execute() method is
 * abstract and must be implemented by subclasses to provide specific behavior
 * for executing different types of commands.
 */
public abstract class CommandExecutor {
    private static CommandExecutor instance;

    /**
     * Returns the single instance of CommandExecutor. If the instance does not
     * exist, a new instance of the CommandExecutorImpl class is created using
     * lazy initialization.
     *
     * @return the single instance of CommandExecutor
     */
    public static CommandExecutor getInstance() {
        if (instance == null) {
            instance = new CommandExecutorImpl();
        }
        return instance;
    }

    /**
     * Executes the given Command. This method is intended to be implemented by
     * subclasses to provide specific behavior for executing different types of
     * commands.
     *
     * @param command the Command to execute
     */
    public abstract void execute(Command command);
}
