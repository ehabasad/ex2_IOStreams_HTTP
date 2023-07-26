package pac;


import pac.command.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides a static method for parsing user input into a Command object.
 */
public class CommandParser {

    /**
     * Parses the given user input into a Command object.
     *
     * @param input the user input to parse
     * @return a Command object corresponding to the user input
     * @throws Exception if the user input is invalid or cannot be parsed
     */
    public static Command parseCommand(String input) throws Exception {

        String[] tokens = input.trim().split("\\s+");
        if (tokens.length == 0) {
            throw new Exception("invalid command");
        }
        String command = tokens[0].toLowerCase();
        switch (command) {
            case "b":
                return parseBlockCommand(tokens);
            case "u":
                return parseUnblockCommand(tokens);
            case "p":
                return parsePrintCommand(tokens);
            case "d":
                return parseDownloadCommand(tokens);
            case "q":
                return new QuitCommand();
            default:
                throw new Exception("invalid command");
        }
    }

    /**
     * Parses a "block" command from the given tokens.
     *
     * @param tokens the tokens representing the command
     * @return a BlockCommand object corresponding to the command
     * @throws Exception if the command is invalid or cannot be parsed
     */
    private static Command parseBlockCommand(String[] tokens) throws Exception {
        if (tokens.length != 2) {
            throw new Exception("invalid command");
        }
        String url = tokens[1];
        validateUrl(url);
        return new BlockCommand(url);
    }

    /**
     * Parses an "unblock" command from the given tokens.
     *
     * @param tokens the tokens representing the command
     * @return an UnblockCommand object corresponding to the command
     * @throws Exception if the command is invalid or cannot be parsed
     */
    private static Command parseUnblockCommand(String[] tokens) throws Exception {
        if (tokens.length != 2) {
            throw new Exception("invalid command");
        }
        String url = tokens[1];
        validateUrl(url);
        return new UnblockCommand(url);
    }

    /**
     * Parses a "print" command from the given tokens.
     *
     * @param tokens the tokens representing the command
     * @return a PrintCommand object corresponding to the command
     * @throws Exception if the command is invalid or cannot be parsed
     */
    private static Command parsePrintCommand(String[] tokens) throws Exception {
        if (tokens.length != 1) {
            throw new Exception("invalid command");
        }
        return new PrintCommand();
    }

    /**
     * Parses a "download" command from the given tokens.
     *
     * @param tokens the tokens representing the command
     * @return a Download Command object corresponding to the command
     * @throws Exception if the command is invalid or cannot be parsed
     */
    private static Command parseDownloadCommand(String[] tokens) throws Exception {
        if (tokens.length < 3) {
            throw new Exception("invalid command");
        }
        List<Character> options = new ArrayList<>();;
        String url = "";
        String out = "";
        boolean exit = false;
        for (int i = 1; i < tokens.length; i++) {
            String optionStr = tokens[1];
            String token = tokens[i];


            if (!exit && tokens.length == 4) {
                if (optionStr.length() > 1 && optionStr.startsWith("-")) {
                    for (int j = 1; j < optionStr.length(); j++) {
                        char option = optionStr.charAt(j);
                        if (option == 'b' || option == 'c' || option == 'h'|| option == 'i')
                            options.add(option);
                        else
                            throw new Exception("invalid option");
                    }
                    exit = true;
                } else {
                    throw new Exception("invalid command");
                }
            }

            else if (url.isEmpty()) {
                url = token;
                assert url != null;
                validateUrl(url);
            } else {
                assert out != null;
                if (out.isEmpty()) {
                    out = token;
                } else {
                    throw new Exception("invalid command");
                }
            }
        }
        return new DownloadCommand(url, out , options );
    }

    /**
     * check if the url is validated
     * @param url check if the url is validated
     * @throws Exception if the command is invalid or cannot be parsed
     */
    private static void validateUrl(String url) throws Exception {
        if (!url.matches("^(http|https)://[a-zA-Z0-9]+([\\-\\.]{1}[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,5}(:[0-9]{1,5})?(/.*)?$")) {
            throw new Exception("invalid URL");
        }
    }

}

