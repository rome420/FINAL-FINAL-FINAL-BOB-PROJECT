package Projects;

import Model.ProjectsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class ProjectsViewController
{

  private ViewHandler viewHandler;
  private ProjectsModel model;
  private Region root;

  @FXML
  private TextField search;

  @FXML
  private Button searchButton;

  @FXML
  private MenuButton categorizeBy;

  @FXML
  private Label projectsLabel;

  @FXML
  private TableView<Project> projectsTable;

  @FXML
  private Button addButton;

  @FXML
  private Button removeButton;

  @FXML
  private Button detailsButton;

  public void init(ViewHandler viewHandler, ProjectsModel model, Region root) {
    init(viewHandler, model, root, null);
  }



  public void init(ViewHandler viewHandler, ProjectsModel model, Region root, List<Project> projects) {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;

    // Additional initialization logic if needed

  }





  // Event handler for the "Add" button



  @FXML
  private void handleAddButton() {
    System.out.println("Add button clicked");
    try {
      // Load the AddMenu.fxml file using the loadAddMenuView method
      Region addMenuRoot = loadAddMenuView();

      // Create a new stage for the popup
      Stage stage = new Stage();
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setTitle("Add Project");
      stage.setScene(new Scene(addMenuRoot));

      // Show the popup and wait for it to be closed before returning
      stage.showAndWait();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private Region loadAddMenuView() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddMenu.fxml"));
    System.out.println("Loading FXML: AddMenu.fxml");
    return loader.load();
  }





}
