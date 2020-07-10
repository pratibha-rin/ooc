/*
        Total number of files.
        Total number of directory
        Total number of unique file extensions.
        List all unique file extensions. Do not list duplicates.
        Total number of files for each extension.
        Hint: use DirectoryWalker and FileFilter in Apache Common IO.
*/

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.*;

class FileAnalytic extends DirectoryWalker  {
    static File rootDir;
    int  cntFolders, cntUniqueExtensions;
    Set<String> uniqueExtensions; //like a array list but its a set, a set always has unique values
    int[] cntExtensions;
    int totalExtCnt;
    List<File> allFiles = new ArrayList();

    public FileAnalytic() {
        String home = System.getProperty("user.home"); //connect to user home directory 
        System.out.println(home);
        rootDir = new File(home + "/Desktop/docs");
        try {

            walk(rootDir, allFiles); //it walks through the root directory and gets all the filenames and places it in all files
                                    // allFiles are the collection of file objects
            //System.out.println("Walk:" + allFiles.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setUniqueExtensions();
    }

    @Override
    protected void handleFile(File file, int depth, Collection results) throws IOException {
        super.handleFile(file, depth, results);
        results.add(file); //when it gets a file it adds to the result, result is connected to allfiles
    }

    @Override
    protected boolean handleDirectory(File directory, int depth, Collection results) throws IOException {
//        System.out.println("Found directory: " + directory.getAbsolutePath());
        cntFolders++;
        return true;
    }

    public int getCntFiles() {
        return allFiles.size(); //size() is the function that tells you how many files there are
    }

    public int getCntFolders() {
        return cntFolders;
    }

    public int getCntUniqueExtensions() {
        return uniqueExtensions.size();
    }

    private void setUniqueExtensions() {
        uniqueExtensions = new HashSet<String>(); //hashset, a kind of set
        for (File eachFile : allFiles) {
            String fname = eachFile.getName();
            int idx = fname.lastIndexOf('.');
            if (idx != -1) {
                String ext = fname.substring(idx);
//                System.out.println(ext);
                this.uniqueExtensions.add(ext); //adding it to the main set
            }
        }
    }

    //        Total number of files for each extension.

    public int[] getCntEachExtensions() { //had to filter the records, had to walk again only with specific extension
        cntExtensions = new int[uniqueExtensions.size()];
        int i=0;
        for (Object ext : uniqueExtensions) {
            // Apply filter
            IOFileFilter IFF = FileFilterUtils.and(FileFilterUtils.fileFileFilter(), //
                    FileFilterUtils.suffixFileFilter(ext.toString()));
            IOFileFilter DFF = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(),
                    HiddenFileFilter.VISIBLE);

            FileFilter filter = FileFilterUtils.or(DFF,IFF);
            UniqueExtensionCount U =new UniqueExtensionCount(filter,rootDir);
            cntExtensions[i++] = U.getCntFilterFiles(); //cntextension is an array that gets a count for a particular extension
            totalExtCnt += cntExtensions[i-1];
        }
        return cntExtensions;
    }

    public Object[] getUniqueExtensions() {
        return uniqueExtensions.toArray();
    }


}