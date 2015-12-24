/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 The following websites were used for this class
 1. http://stackoverflow.com/questions/3542018/how-can-i-get-list-of-all-drives-but-also-get-the-corresponding-drive-type-remo
 2. http://stackoverflow.com/questions/4852531/find-files-in-a-folder-using-java
 3. http://stackoverflow.com/questions/1384947/java-find-txt-files-in-specified-folder
https://github.com/mpatric/mp3agic-examples/blob/master/src/main/java/com/mpatric/mp3agic/example/Example.java
 */
package Testing;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FilenameFilter;

/**
 * Designed to pull in a list of all MP3 files in the system
 *
 * @author Scorchgid
 */
public class FileReader {

    public static List<String> getListOfMP3Files() {
        List<String> listOfFiles = new ArrayList<>();
        //1.
        File[] drives = File.listRoots();
        // C:\ D:\
        for (File rootDirectory : drives) {
            File dir = new File(rootDirectory.getPath());
            dir.list(new FilenameFilterImpl());
            
        return listOfFiles;
        }
        return null;
    }

    private static class FilenameFilterImpl implements FilenameFilter {

        public FilenameFilterImpl() {
        }

        @Override
        public boolean accept(File dir, String filename) {
            boolean endsWith = filename.endsWith(".mp3");
            return false;
        }
    }
}
