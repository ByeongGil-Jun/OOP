package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author Gily
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        // TODO: what if args is empty?
        if (args.length == 0) {
            System.out.println("Please enter a command");
            System.exit(0);
        }
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                // TODO: handle the `add [filename]` command
                if (args.length > 1)
                    Utils.exitWithError("Incorrect operands");
                break;
            case "add":
                // TODO: handle the `init` command
                if (args.length > 1)
                    Utils.exitWithError("Incorrect operands");
                break;
            case "commit":
                // TODO: handle the 'commit [message]' command
                break;
            case "rm":
                // TODO: handle the `rm [file name]` command
                break;
            case "log":
                // TODO: handle the 'log' command
                if (args.length > 1)
                    Utils.exitWithError("Incorrect operands");
                break;
            case "status":
                // TODO: handle the 'status' command
                if (args.length > 1)
                    Utils.exitWithError("Incorrect operands");
                break;
            case "checkout":
                // TODO: handle the 'checkout -- [file name]' command
                // TODO: handle the 'checkout [commit id] -- [file name]' command
                // TODO: handle the 'checkout [branch name]' command
                if (args.length == 2) {

                } else if (args.length == 3 && args[2] == "--") {

                } else if (args.length == 4 && args[3] == "--") {

                } else {
                    Utils.exitWithError("Incorrect operands");
                }
                break;
            default:
                System.out.println("No command with that name exists.");
                System.exit(0);
                break;
            // TODO: FILL THE REST IN
        }
    }
}
