/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import java.io.File;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Scorchgid
 */
public class JavaFXTreeView extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Launch");
        launch(args);
    }
    int x = 0;

    private TreeItem<File> createNode(final File f) {
        System.out.println("About to return create node " + x);
        x++;
        return new TreeItem<File>(f) {
            private boolean isLeaf;
            private boolean isFirstTimeChildren = true;
            private boolean isFirstTimeLeaf = true;

            @Override
            public ObservableList<TreeItem<File>> getChildren() {
                System.out.println("ObservableList 1 ");
                if (isFirstTimeChildren) {
                    System.out.println("ObservableList 2 " + super.getChildren().toString());
                    isFirstTimeChildren = false;
                    super.getChildren().setAll(buildChildren(this));
                }
                return super.getChildren();
            }

            @Override
            public boolean isLeaf() {
                System.out.println("is Leaf Get Path " + x + " " + f.getPath());
                if (isFirstTimeLeaf) {
                    isFirstTimeLeaf = false;
                    File f = (File) getValue();
                    System.out.println("is Leaf Get Absolute " + x + " " + f.getAbsolutePath());
                    isLeaf = f.isFile();
                }
                return isLeaf;
            }

            private ObservableList<TreeItem<File>> buildChildren(
                    TreeItem<File> TreeItem) {
                System.out.println("ObservableList Tree" + TreeItem.getValue().toString());
                File f = TreeItem.getValue();
                if (f == null) {
                    return FXCollections.emptyObservableList();
                }
                if (f.isFile()) {
                    return FXCollections.emptyObservableList();
                }
                System.out.println("File File List");
                File[] files = f.listFiles();
                if (files != null) {
                    ObservableList<TreeItem<File>> children = FXCollections
                            .observableArrayList();
                    for (File childFile : files) {
                        children.add(createNode(childFile));
                    }
                    return children;
                }
                return FXCollections.emptyObservableList();
            }
        };
    }

    public TreeView<File> proxyCreateNode(ArrayList<TreeItem> arrayListTreeItem) {
        TreeItem<File> proxyItem = new TreeItem<>();
        for (TreeItem<File> item : arrayListTreeItem) {
            proxyItem.getChildren().addAll(item);
        }
        //proxyItem.getChildren().addAll(arrayListTreeItem);
        TreeView<File> tree = new TreeView<>(proxyItem);
        tree.setShowRoot(false);
        return tree;
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group(), 300, 300);
        VBox vbox = new VBox();
        File[] drives = File.listRoots();
        ArrayList<TreeItem> treeItems = new ArrayList<>();
        /*        File[] drives = File.listRoots();
         for (File dir : drives) {
         TreeItem<File> root = createNode(dir);
         System.out.println("Finished Root, creating instance of treeView");
         TreeView treeView = new TreeView<File>(root); 
         vbox.getChildren().add(treeView);
         }*/
        for (File dir : drives) {
            treeItems.add(createNode(dir));
        }
//        TreeItem<File> rootA = createNode(new File("C:\\"));
        //      TreeItem<File> rootB = createNode(new File("D:\\"));

        TreeView<File> tree = proxyCreateNode(treeItems);
        vbox.getChildren().add(tree);

        System.out.println("Group scene getChildren add vbox");
        ((Group) scene.getRoot()).getChildren().add(vbox);
        System.out.println("Set the scene");
        stage.setScene(scene);
        stage.show();
    }
}
