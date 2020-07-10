/*
        Total number of files.
        Total number of directory
        Total number of unique file extensions.
        List all unique file extensions. Do not list duplicates.
        Total number of files for each extension.
        Hint: use DirectoryWalker and FileFilter in Apache Common IO.
*/

import org.apache.commons.io.DirectoryWalker;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.*;

class UniqueExtensionCount extends DirectoryWalker implements FileFilter {
    static File rootDir;

    List<File> allFiles = new ArrayList();

    public UniqueExtensionCount(FileFilter filter, File root) {
        super(filter,-1);
        rootDir = root;
        try {
            walk(rootDir, allFiles);
//            System.out.println("Walk:" + allFiles.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void handleFile(final File file, final int depth, final Collection results) throws IOException {
       // System.out.println("Found file: " + file.getAbsolutePath());
        results.add(file);
    }

    @Override
    protected boolean handleDirectory(File directory, int depth, Collection results) throws IOException {
        return super.handleDirectory(directory, depth, results);
    }

    public int getCntFilterFiles() {
        return allFiles.size();
    } //to get count of a specific function

    public boolean accept(File pathname) { return false; } 
    //when it keeps returning 0, have to use accept function, it tells if file should be accepted and do something or not
}