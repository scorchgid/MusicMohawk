/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmetadatak1009705;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import org.apache.commons.io.FileUtils;

/**
 * http://stackoverflow.com/questions/6251762/java-search-file-according-to-its-name-in-directory-and-subdirectories
 * http://stackoverflow.com/questions/26690247/how-to-make-directories-expandable-in-javafx-treeview
 * http://www.java2s.com/Tutorials/Java/JavaFX/0660__JavaFX_Tree_View.htm
 * http://stackoverflow.com/questions/22260032/set-two-root-nodes-for-treeview
 *
 * @author Scorchgid
 */
public class FolderTreeView {

    int x = 0;
    private final String fileName = ".mp3";
    private MainView mainView;
    private TreeView<File> treeViewFile = new TreeView<>();
    FileTreeView fileTreeView;

    public TreeView<File> getTreeViewFile() {
        return treeViewFile;
    }

    public FolderTreeView(FileTreeView fileTV){
        fileTreeView = fileTV;
    }
    
    public void setTreeViewFile(TreeView<File> treeViewFile) {
        this.treeViewFile = treeViewFile;
    }

    public VBox treeStack() throws IOException {
        VBox vbox = new VBox();
        File[] drives = File.listRoots();
        ArrayList<File> fileListing;
        /*for (File dir : drives) {
         System.out.println(dir.toString());
         fileListing = restrictingList(dir);
         }*/
        fileListing = restrictingList(new File("D:\\"));

        ArrayList<TreeItem> treeItems = new ArrayList<>();
        for (File dir : drives) {
            //System.out.println(dir.toString());
            treeItems.add(createNode(dir));
        }
        TreeView<File> tree = proxyCreateNode(treeItems);
        vbox.getChildren().add(tree);
        
        tree.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends TreeItem<File>> observable, TreeItem<File> oldValue, TreeItem<File> newValue) -> {
            System.out.println("Selected Text: " + newValue.getValue());
            TreeItem<File> selectedItem = newValue;
            System.out.println("Selected Text: " + selectedItem.getValue());
            try {
                //FileTreeView fileTreeView = new FileTreeView();
                System.out.println("File Tree View Event");
                fileTreeView.GetFilesFromFolder((newValue.getValue().toString()));
                //fileTreeView.SetFileTreeView();
            } catch (IOException ex) {
                System.err.println("Unable to pass fileTreeView Value \nPassed Value: "
                        + selectedItem.getValue().toString()
                        + "\r\nError Message:\r\n"
                        + ex.toString());
                Logger.getLogger(FolderTreeView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } /* @Override
        public void changed(
        ObservableValue<? extends TreeItem<File>> observable, TreeItem<String> old_val, TreeItem<File> new_val) {
        }*/ );
        return vbox;
    }

    // http://stackoverflow.com/questions/22260032/set-two-root-nodes-for-treeview
    public TreeView<File> proxyCreateNode(ArrayList<TreeItem> arrayListTreeItem) {
        TreeItem<File> proxyItem = new TreeItem<>();
        proxyItem.setExpanded(true);
        for (TreeItem<File> item : arrayListTreeItem) {
            proxyItem.getChildren().addAll(item);
        }
        TreeView<File> tree = new TreeView<>(proxyItem);
        tree.setShowRoot(false);
        return tree;
    }

    private ArrayList<File> restrictingList(File root) {
        ArrayList<File> fileArray = new ArrayList<>();
        boolean recursive = true;
        Collection files = FileUtils.listFiles(root, null, recursive);
        for (Iterator iterator = files.iterator(); iterator.hasNext();) {
            File file = (File) iterator.next();
            if (file.getName().endsWith(fileName)) {
                fileArray.add(file);
            }
        }
        return fileArray;
    }

    /*    @Override
     public void start(Stage stage) {
     Scene scene = new Scene(new Group(), 300, 300);

     TreeItem<File> root = createNode(new File("c:/"));
     TreeView treeView = new TreeView<File>(root);

     vbox.getChildren().add(treeView);
     ((Group) scene.getRoot()).getChildren().add(vbox);

     stage.setScene(scene);
     stage.show();
     }
     */
    private TreeItem<File> createNode(final File f) {
        return new TreeItem<File>(f) {
            private boolean isLeaf;
            private boolean isFirstTimeChildren = true;
            private boolean isFirstTimeLeaf = true;

            @Override
            public ObservableList<TreeItem<File>> getChildren() {
                if (isFirstTimeChildren) {
                    isFirstTimeChildren = false;
                    super.getChildren().setAll(buildChildren(this));
                }
                return super.getChildren();
            }

            @Override
            public boolean isLeaf() {
                if (isFirstTimeLeaf) {
                    isFirstTimeLeaf = false;
                    File f = (File) getValue();
                    isLeaf = f.isFile();
                }
                return isLeaf;
            }

            private ObservableList<TreeItem<File>> buildChildren(
                    TreeItem<File> TreeItem) {
                File f = TreeItem.getValue();
                if (f == null) {
                    return FXCollections.emptyObservableList();
                }
                if (f.isFile()) {
                    return FXCollections.emptyObservableList();
                }
                File[] files = f.listFiles();
                if (files != null) {
                    ObservableList<TreeItem<File>> children = FXCollections
                            .observableArrayList();
                    for (File childFile : files) {
                        //System.out.println("Adding " + childFile.getAbsolutePath());
                        if (childFile.isDirectory()) {
                            children.add(createNode(childFile));
                        }
                    }
                    return children;
                }
                return FXCollections.emptyObservableList();
            }
        };
    }
}
