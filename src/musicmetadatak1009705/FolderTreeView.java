/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmetadatak1009705;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 *
 * http://stackoverflow.com/questions/26690247/how-to-make-directories-expandable-in-javafx-treeview
 * http://www.java2s.com/Tutorials/Java/JavaFX/0660__JavaFX_Tree_View.htm
 *
 * @author Scorchgid
 */
public class FolderTreeView {

    int x = 0;
    private MainView mainView;
    private TreeView<File> treeViewFile = new TreeView<>();
    TreeItem<File> root = new TreeItem<>();

    public TreeView<File> getTreeViewFile() {
        return treeViewFile;
    }

    public void setTreeViewFile(TreeView<File> treeViewFile) {
        this.treeViewFile = treeViewFile;
    }

    public VBox treeStack() throws IOException {
        VBox vbox = new VBox();
        File[] drives = File.listRoots();
        ArrayList<TreeItem> treeItems = new ArrayList<>();
        for (File dir : drives) {
            treeItems.add(createNode(dir));
        }
        TreeView<File> tree = proxyCreateNode(treeItems);
        vbox.getChildren().add(tree);
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
                        System.out.println("Adding " + childFile.getAbsolutePath());
                        children.add(createNode(childFile));
                    }
                    return children;
                }
                return FXCollections.emptyObservableList();
            }
        };
    }
}
