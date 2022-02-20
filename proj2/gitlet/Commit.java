package gitlet;

// TODO: any imports you need here

import java.util.Date; // TODO: You'll likely use this in this class
import java.util.LinkedList;

/** Represents a gitlet commit object.
 *  Combinations of log messages, other metadata (commit date, author, etc.), a reference to a tree,
 *  and references to parent commits.
 *  The repository also maintains a mapping from branch heads to references to commits,
 *  so that certain important commits have symbolic names.
 *  file should represent blob's sha1.
 *  log should represent sha1 of prev commit.
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
    /** The date of this Commit. */
    private Date date;
    /** The author of this Commit. */
    private String author;
    /** The reference to a tree. */
    private String tree;
    /** The reference to a parent. */
    private String parent;
    /** The log of this Commit. */
    private String log;
    /** The file list of this Commit. */
    private LinkedList files = new LinkedList();

    /* TODO: fill in the rest of this class. */
    public Commit(String mes) {
        message = mes;
        date = new Date();
    }
    public Commit(String mes, String log) {
        message = mes;
        date = new Date();
    }
}
