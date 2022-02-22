package gitlet;

import java.io.File;

public class Command {
    public void MakeCommit(String n) {
        Commit c = new Commit(n);
    }
    public void MakeBlob(String name, String version, File f) {
        Blob b = new Blob(name, version, f);
    }
    public void SaveCommit(File to, Commit c) {
        Utils.writeObject(to, c);
    }
    public void SaveBlob(File to, Blob b) {
        Utils.writeObject(to, b);
    }
    public Commit ReadCommit(File from, Commit c) {
        Commit g = Utils.readObject(from, Commit.class);
        return g;
    }
    public Blob ReadBlob(File from, Blob b) {
        Blob g = Utils.readObject(from, Blob.class);
        return g;
    }
}
