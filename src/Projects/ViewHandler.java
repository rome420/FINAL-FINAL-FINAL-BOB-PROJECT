package Projects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

import Model.ProjectsModel;

public class ViewHandler {

  private Scene currentScene;
  private Stage primaryStage;

  private ProjectsModel model;

  private ProjectsViewController projectsViewController;

  public ViewHandler(ProjectsModel model) {
    this.currentScene = new Scene(new Region());
    this.model = model;
  }

  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    openView();
    primaryStage.show();  // Make sure to call show() to display the stage
  }

  private void openView() {
    try {
      Region root = loadSimpleGUIView("ProjectsMenu.fxml");
      currentScene.setRoot(root);
      String title = "";
      if (root.getUserData() != null) {
        title += root.getUserData();
      }
      primaryStage.setTitle(title);
      primaryStage.setScene(currentScene);
      primaryStage.setWidth(root.getPrefWidth());
      primaryStage.setHeight(root.getPrefHeight());
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private Region loadSimpleGUIView(String fxmlFile) {
    Region root = null;
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      projectsViewController = loader.getController();
      if (projectsViewController != null) {
        projectsViewController.init(this, model, root);
      } else {
        System.err.println("Error: projectsViewController is null");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return root;
  }

  public void closeView() {
    primaryStage.close();
  }

  public ProjectsViewController getProjectsViewController() {
    return projectsViewController;
  }
}
