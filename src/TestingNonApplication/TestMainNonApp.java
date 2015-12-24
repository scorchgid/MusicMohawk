/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingNonApplication;

import Testing.TestMain;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Scorchgid
 */
public class TestMainNonApp {

    /**
     * This class exists as Extends Application refused to end the main method
     * without a forced close. This was the only was to do so
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //outputTestFileScan();
        //testListRoots();
        stackOverflowFileMp3Scan(new File("D:\\"));
    }

    public static void testListRoots() {
        File[] drives = File.listRoots();
        for (File file : drives) {
            System.out.println(file.toString());
            /* Printed out:
             C:\
             D:\
             */
        }
    }

    /**
     * File Testing
     * -------------------------------------------------------------------
     */
    public static void nanoTestFileScane() {
        File[] drives = File.listRoots();

        long startTime1 = System.nanoTime();
        for (File file : drives) {
            hyperAVAJAVAFileMp3Scan(file);
        }
        long estimatedTime1 = System.nanoTime() - startTime1;

        long startTime2 = System.nanoTime();
        for (File file : drives) {
            hyperStackOverflowFileMp3Scan(file);
        }
        long estimatedTime2 = System.nanoTime() - startTime2;

        System.out.println("Estimated time 1: " + estimatedTime1);
        System.out.println("Estimated time 2: " + estimatedTime2);
        long smallestTime = Math.min(estimatedTime1, estimatedTime2);
        System.out.println("Shortest Time: " + smallestTime);
    }

    /**
     * Estimated time 1: 51862817803
     * http://www.avajava.com/tutorials/lessons/how-do-i-get-all-files-with-certain-extensions-in-a-directory-including-subdirectories.html
     *
     * @param dir
     * @return
     */
    public static List<File> hyperAVAJAVAFileMp3Scan(File dir) {
        try {
            String[] extensions = new String[]{"mp3"};
            dir.getCanonicalPath();
            List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
            for (File file : files) {
                file.getCanonicalPath();
            }
            return files;
        } catch (IOException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Estimated time 2: 6606614221 Faster time
     * http://stackoverflow.com/questions/6251762/java-search-file-according-to-its-name-in-directory-and-subdirectories
     *
     * @param root
     * @return
     */
    public static Collection hyperStackOverflowFileMp3Scan(File root) {
        String fileName = ".mp3";

        try {
            boolean recursive = true;
            Collection files = FileUtils.listFiles(root, null, recursive);
            for (Iterator iterator = files.iterator(); iterator.hasNext();) {
                File file = (File) iterator.next();
                if (file.getName().endsWith(fileName)) {
                    file.getAbsolutePath();
                }
            }
            return files;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Orginal method with Console print lines
     */
    public static void outputTestFileScan() {
        File[] drives = File.listRoots();
        List<File> files = hyperAVAJAVAFileMp3Scan(drives[1]);
        List<File> files2 = hammerBack(files);
        for(File file :files2)
        {
            System.out.println(file.toString());
        }
        /*for (File file : drives) {
         aVAJAVAFileMp3Scan(file);
         }
         for (File file : drives) {
         stackOverflowFileMp3Scan(file);
         }*/
    }

    /**
     * Getting all .mp3 files in D:\K3NoteBackup\SD Card\Music\Disney\Big Hero 6
     * (2014) OST including those in subdirectories file: D:\K3NoteBackup\SD
     * Card\Music\Disney\Big Hero 6 (2014) OST\11 The Streets of San
     * Fransokyo.mp3 file: D:\K3NoteBackup\SD Card\Music\Disney\Big Hero 6
     * (2014) OST\17 Big Hero 6.mp3
     *
     * @param dir
     * @return
     */
    public static boolean aVAJAVAFileMp3Scan(File dir) {
        try {
            String[] extensions = new String[]{"mp3"};
            System.out.println("Getting all .mp3 files in " + dir.getCanonicalPath()
                    + " including those in subdirectories");
            List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
            for (File file : files) {
                System.out.println("file: " + file.getCanonicalPath());
            }
            return true;

        } catch (IOException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    /**
     * I have started Test recursive D:\K3NoteBackup\SD Card\Music\Disney\Big
     * Hero 6 (2014) OST\11 The Streets of San Fransokyo.mp3 D:\K3NoteBackup\SD
     * Card\Music\Disney\Big Hero 6 (2014) OST\17 Big Hero 6.mp3
     *
     * @param root
     */
    public static void stackOverflowFileMp3Scan(File root) {
        System.out.println("I have started Test recursive");
        String fileName = ".mp3";
        try {
            boolean recursive = true;
            Collection files = FileUtils.listFiles(root, null, recursive);
            for (Iterator iterator = files.iterator(); iterator.hasNext();) {
                File file = (File) iterator.next();
                if (file.getName().endsWith(fileName)) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
        }
    }

    public static List<File> hammerBack(List<File> files) {
        List<File> returnedList = null;
        /*for (File file : files) {
            String stringFile = file.toString();
            stringFile = stringFile.substring(0, stringFile.lastIndexOf("\\"));
            returnedList.add(new File(stringFile));
        }*/
        return returnedList;
    }
}
