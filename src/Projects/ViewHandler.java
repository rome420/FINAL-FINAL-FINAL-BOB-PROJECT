package Projects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
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
      System.out.println("Root component type: " + root.getClass().getSimpleName());

      // Print additional information if needed
      System.out.println("UserData: " + root.getUserData());

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
      System.out.println("Loading FXML: " + fxmlFile);
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      System.out.println("FXML loaded successfully: " + fxmlFile);

      projectsViewController = loader.getController();
      if (projectsViewController != null) {
        projectsViewController.init(this, model, root);
      } else {
        System.err.println("Error: projectsViewController is null");
      }
    } catch (IOException e) {
      System.err.println("Error loading FXML: " + fxmlFile);
      e.printStackTrace();
    }
    return root;
  }

  private Region loadProjectsMenuView() {
    Region root = null;
    try {
      System.out.println("Loading FXML: ProjectsMenu.fxml");
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("ProjectsMenu.fxml"));
      root = loader.load();
      System.out.println("FXML loaded successfully: ProjectsMenu.fxml");

      projectsViewController = loader.getController();
      if (projectsViewController != null) {
        projectsViewController.init(this, model, root);
      } else {
        System.err.println("Error: projectsViewController is null");
      }
    } catch (IOException e) {
      System.err.println("Error loading FXML: ProjectsMenu.fxml");
      e.printStackTrace();
    }
    return root;
  }

  private Region loadAddMenuView() {
    return loadSimpleGUIView("AddMenu.fxml");
  }

  public void openProjectsMenuView() {
    Region root = loadProjectsMenuView();
    if (root != null) {
      currentScene.setRoot(root);
      primaryStage.setTitle("Projects Menu");
      primaryStage.setScene(currentScene);
      primaryStage.setWidth(root.getPrefWidth());
      primaryStage.setHeight(root.getPrefHeight());
      primaryStage.show();
    }
  }

  public void openAddMenuView() {
    Region root = loadAddMenuView();
    if (root != null) {
      Stage addMenuStage = new Stage();
      addMenuStage.initModality(Modality.APPLICATION_MODAL);
      addMenuStage.setTitle("Add Project");
      addMenuStage.setScene(new Scene(root));
      addMenuStage.showAndWait();
    }
  }

  public void closeView() {
    primaryStage.close();
  }

  public ProjectsViewController getProjectsViewController() {
    return projectsViewController;
  }
}
