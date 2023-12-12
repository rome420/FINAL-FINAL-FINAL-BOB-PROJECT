package Projects;

import Model.ProjectsModel;
import Model.ProjectsModelManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  private ProjectsModel model;

  public void start(Stage primaryStage)
  {
    model = new ProjectsModelManager();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}