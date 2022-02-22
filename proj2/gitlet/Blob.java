package gitlet;

import java.io.File;
import java.io.Serializable;

/** Represents a gitlet blob object.
 * The saved contents of files.
 * Since Gitlet saves many versions of files, a single file might correspond to multiple blobs:
 * each being tracked in a different commit.
 *
 *  @author Gily
 */
public class Blob implements Serializable {
    /** The name of this Blob. */
    private String name;
    /** The version of this Blob. */
    private String version;
    /** The file */
    private File file;
    /** The sha1 of this Commit. */
    private String sha1;

    public Blob (String n, String v, File f) {
        name = n;
        version = v;
        file = f;
        sha1 = Utils.sha1(name, version, file);
    }
}
