package Projects;

import javafx.application.Application;
import javafx.stage.Stage;
import Model.ProjectsModelManager;
public class main extends Application {

  public static void main(String[] args) {
    // Create an instance of ProjectsModelManager, the class that implements ProjectsModel
    ProjectsModelManager model = new ProjectsModelManager();

    // Create an instance of ViewHandler
    ViewHandler viewHandler = new ViewHandler(model);

    // Create an instance of ProjectManager and pass the viewHandler to it
    ProjectManager projectManager = new ProjectManager(viewHandler);

    // Launch the JavaFX application
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    // This is where you can start your JavaFX application
    // You can use primaryStage to set up your UI components
  }
}