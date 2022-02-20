package gitlet;

import java.io.File;
import java.io.IOException;

import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author Gily
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");
    /** The commit directory. */
    public static final File Commit_DIR = join(GITLET_DIR, "commit");
    /** The blob directory. */
    public static final File Blob_DIR = join(GITLET_DIR, "blob");
    /** The staging directory. */
    public static final File Staging_DIR = join(GITLET_DIR, "staging");

    /* TODO: fill in the rest of this class. */
    public static void SetupPersistence() throws IOException {
        if (GITLET_DIR.exists()) {
            Utils.exitWithError("A Gitlet version-control system already exists in the current directory.");
        } else {
            GITLET_DIR.mkdir();
            Commit_DIR.mkdir();
            Blob_DIR.mkdir();
            Staging_DIR.mkdir();
        }
        //handle branch master
        Commit InitCommit = new Commit("initial commit");
    }

    public static void staging(String name) {
        /** if same file is exist, update just arrow
         *  else, make copy file in staging_dir and update arrow
         */
    }
}
