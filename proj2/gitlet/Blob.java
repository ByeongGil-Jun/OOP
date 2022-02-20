package gitlet;

import java.io.File;

/** Represents a gitlet blob object.
 * The saved contents of files.
 * Since Gitlet saves many versions of files, a single file might correspond to multiple blobs:
 * each being tracked in a different commit.
 *
 *  @author Gily
 */
public class Blob {
    /** The name of this Blob. */
    private String name;
    /** The version of this Commit. */
    private String version;
    /** The sha1 of this Commit. */
    private String sha1;

    public String Blob(String n, String v) {
        name = n;
        version = v;
        sha1 = Utils.sha1(name, version);
        return sha1;
    }
}
