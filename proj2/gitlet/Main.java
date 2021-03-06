package gitlet;

import java.io.IOException;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author Gily
 */
public class Main {
    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) throws IOException {
        // TODO: what if args is empty?
        if (args.length == 0) {
            System.out.println("Please enter a command");
            System.exit(0);
        }
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                // TODO: handle the `init` command
                validateNumArgs(args, 1);
                break;
            case "add":
                // TODO: handle the `add [filename]` command
                validateNumArgs(args, 2);
                Repository.StagingAdd(args[1]);
                break;
            case "commit":
                // TODO: handle the 'commit [message]' command
                break;
            case "rm":
                // TODO: handle the `rm [file name]` command
                break;
            case "log":
                // TODO: handle the 'log' command
                validateNumArgs(args, 1);
                break;
            case "status":
                // TODO: handle the 'status' command
                validateNumArgs(args, 1);
                break;
            case "checkout":
                // TODO: handle the 'checkout -- [file name]' command
                // TODO: handle the 'checkout [commit id] -- [file name]' command
                // TODO: handle the 'checkout [branch name]' command -> don't have to
                if (args.length == 3 && args[1] == "--") {

                } else if (args.length == 4 && args[2] == "--") {

                } else {
                    Utils.exitWithError("Incorrect operands");
                }
                break;
            default: Utils.exitWithError("No command with that name exists.");
                break;
            // TODO: FILL THE REST IN
        }
    }

    public static void validateNumArgs(String[] args, int n) {
        if (args.length != n) {
            Utils.exitWithError("Incorrect operands");
        }
    }
}
