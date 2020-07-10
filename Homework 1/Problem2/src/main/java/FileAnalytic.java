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
    Set<String> uniqueExtensions;
    int[] cntExtensions;
    int totalExtCnt;
    List<File> allFiles = new ArrayList();

    public FileAnalytic(String dirPath) {
        String home = System.getProperty("user.home");
        rootDir = new File(home + dirPath);
        System.out.println(rootDir.getAbsolutePath());

        try {

            walk(rootDir, allFiles);
            //System.out.println("Walk:" + allFiles.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setUniqueExtensions();
    }

    protected void handleFile(final File file, final int depth, final Collection results) throws IOException {
//        System.out.println("Found file: " + file.getAbsolutePath());
        results.add(file);
    }

    @Override
    protected boolean handleDirectory(File directory, int depth, Collection results) throws IOException {
//        System.out.println("Found directory: " + directory.getAbsolutePath());
        cntFolders++;
        return true;
    }

    public int getCntFiles() {
        return allFiles.size();
    }

    public int getCntFolders() {
        return cntFolders;
    }

    public int getCntUniqueExtensions() {
        return uniqueExtensions.size();
    }

    private void setUniqueExtensions() {
        uniqueExtensions = new HashSet<String>();
        for (File eachFile : allFiles) {
            String fname = eachFile.getName();
            int idx = fname.lastIndexOf('.');
            if (idx != -1) {
                String ext = fname.substring(idx);
//                System.out.println(ext);
                this.uniqueExtensions.add(ext);
            }
        }
    }

    //        Total number of files for each extension.

    public int[] getCntEachExtensions() {
        cntExtensions = new int[uniqueExtensions.size()];
        int i=0;
        for (Object n : uniqueExtensions) {
            // Apply filter
            IOFileFilter IFF = FileFilterUtils.and(FileFilterUtils.fileFileFilter(),
                    FileFilterUtils.suffixFileFilter(n.toString()));
            IOFileFilter DFF = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(),
                    HiddenFileFilter.VISIBLE);

            FileFilter filter = FileFilterUtils.or(DFF,IFF);
            UniqueExtensionCount U =new UniqueExtensionCount(filter,rootDir);
            cntExtensions[i++] = U.getCntFilterFiles();
            totalExtCnt += cntExtensions[i-1];
        }
        return cntExtensions;
    }

    public int getCntOfExtension(String ext) {
        getCntEachExtensions();
        IOFileFilter IFF = FileFilterUtils.and(FileFilterUtils.fileFileFilter(),
                FileFilterUtils.suffixFileFilter(ext));
        IOFileFilter DFF = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(),
                HiddenFileFilter.VISIBLE);

        FileFilter filter = FileFilterUtils.or(DFF, IFF);
        UniqueExtensionCount U = new UniqueExtensionCount(filter, rootDir);
        return U.getCntFilterFiles();
    }

    public Object[] getUniqueExtensions() {
        return uniqueExtensions.toArray();
    }


}