package Projects;

import Model.ProjectsModelManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {

  public static void main(String[] args) {
    // Launch the JavaFX application from the main method
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    // Create an instance of ProjectsModelManager, the class that implements ProjectsModel
    ProjectsModelManager model = new ProjectsModelManager();

    // Create an instance of ViewHandler
    ViewHandler viewHandler = new ViewHandler(model);

    // Create an instance of ProjectManager and pass the viewHandler to it
    ProjectManager projectManager = new ProjectManager(viewHandler);

    // Start the JavaFX application
    viewHandler.start(primaryStage);
  }
}