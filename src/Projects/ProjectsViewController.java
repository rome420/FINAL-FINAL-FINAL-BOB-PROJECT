package Projects;

import Model.ProjectsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

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
    initializeTable(projects);
  }

  public void addProjectToTableView(Project project) {
    projectsTable.getItems().add(project);
  }

  private void initializeTable(List<Project> projects) {
    // Initialize your table columns and data here
    // Assuming Project has appropriate getters (replace with actual getters)
    TableColumn<Project, String> nameColumn = new TableColumn<>("Name");
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<Project, String> typeColumn = new TableColumn<>("Type");
    typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

    TableColumn<Project, String> statusColumn = new TableColumn<>("Status");
    statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

    projectsTable.getColumns().addAll(nameColumn, typeColumn, statusColumn);

    // Add projects to the table if available
    if (projects != null) {
      ObservableList<Project> data = FXCollections.observableArrayList(projects);
      projectsTable.setItems(data);
    }
  }

  public void projectAdded(Project project, boolean isFinished) {
    // Add your logic to handle the projectAdded event
    // You can update the UI or perform any other necessary actions
    System.out.println("Project added: " + project.getId());
    System.out.println("Is Finished: " + isFinished);
  }

  // Event handler for the "Add" button
  @FXML
  private void handleAddButton() {
    // Add your logic for handling the "Add" button click
    System.out.println("Add button clicked");
  }

  // Event handler for the "Remove" button
  @FXML
  private void handleRemoveButton() {
    // Add your logic for handling the "Remove" button click
    System.out.println("Remove button clicked");
  }

  // Event handler for the "Details" button
  @FXML
  private void handleDetailsButton() {
    // Add your logic for handling the "Details" button click
    System.out.println("Details button clicked");
  }
}
