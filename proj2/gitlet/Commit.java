package gitlet;

// TODO: any imports you need here

import java.util.Date; // TODO: You'll likely use this in this class

/** Represents a gitlet commit object.
 *  Takes the version of the file as it exists in the head commit and puts it in the working directory,
 *  overwriting the version of the file that’s already there if there is one.
 *  The new version of the file is not staged.
 *
 * Takes the version of the file as it exists in the commit with the given id, and puts it in the working directory,
 * overwriting the version of the file that’s already there if there is one.
 * The new version of the file is not staged.
 *
 * Takes all files in the commit at the head of the given branch, and puts them in the working directory,
 * overwriting the versions of the files that are already there if they exist. Also, at the end of this command,
 * the given branch will now be considered the current branch (HEAD).
 * Any files that are tracked in the current branch but are not present in the checked-out branch are deleted.
 * The staging area is cleared, unless the checked-out branch is the current branch
 *
 *  @author Gily
 */
public class Commit {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private String message;

    /* TODO: fill in the rest of this class. */
    public void Commit(String mes) {
        message = mes;
    }
}
