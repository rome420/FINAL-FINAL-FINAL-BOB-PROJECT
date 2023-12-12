package Projects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddMenuController {

  @FXML
  private Label budgetLabel, durationLabel, buildingSizeLabel, kitchensLabel, bathroomsLabel, plumbingLabel, renovationLabel;

  @FXML
  private TextField budgetTextField, durationTextField, buildingSizeTextField, kitchensTextField, bathroomsTextField, plumbingTextField, renovationTextField;

  @FXML
  private void initialize() {
    // Set the initial visibility of labels and text fields to false
    setVisibility(false);
    setVisibilityTextField(false);
  }

  @FXML
  private void handleProjectTypeSelection(ActionEvent event) {
    MenuItem selectedType = (MenuItem) event.getSource();

    if (selectedType != null) {
      String projectType = selectedType.getText();

      // Hide all labels and text fields
      setVisibility(false);
      setVisibilityTextField(false);

      // Show labels and text fields based on the selected project type
      switch (projectType) {
        case "Residential":
          budgetLabel.setText("Budget");
          durationLabel.setText("Duration");
          buildingSizeLabel.setText("Size");
          kitchensLabel.setText("Number of Kitchens");
          bathroomsLabel.setText("Number of Bathrooms");
          plumbingLabel.setText("Other Rooms with Plumbing");
          renovationLabel.setText("New or Renovation");
          setVisibility(true);
          setVisibilityTextField(true);
          break;
        case "Commercial":
          budgetLabel.setText("Budget");
          durationLabel.setText("Duration");
          buildingSizeLabel.setText("Size");
          kitchensLabel.setText("Floors");
          bathroomsLabel.setText("Use of the Building");
          setVisibility(true);
          setVisibilityTextField(true);
          break;
        case "Industrial":
          budgetLabel.setText("Budget");
          durationLabel.setText("Duration");
          buildingSizeLabel.setText("Size");
          kitchensLabel.setText("Type of Facility");
          setVisibility(true);
          setVisibilityTextField(true);
          break;
        case "Road Construction":
          budgetLabel.setText("Budget");
          durationLabel.setText("Duration");
          buildingSizeLabel.setText("Length");
          kitchensLabel.setText("Width");
          bathroomsLabel.setText("Bridges or Tunnels");
          plumbingLabel.setText("Challenges");
          setVisibility(true);
          setVisibilityTextField(true);
          break;
      }
    }
  }

  @FXML
  private void setVisibility(boolean visible) {
    if (!visible) {
      // Reset the text of labels when hiding
      budgetLabel.setText("");
      durationLabel.setText("");
      buildingSizeLabel.setText("");
      kitchensLabel.setText("");
      bathroomsLabel.setText("");
      plumbingLabel.setText("");
      renovationLabel.setText("");
    }

    budgetLabel.setVisible(visible);
    durationLabel.setVisible(visible);
    buildingSizeLabel.setVisible(visible);
    kitchensLabel.setVisible(visible);
    bathroomsLabel.setVisible(visible);
    plumbingLabel.setVisible(visible);
    renovationLabel.setVisible(visible);
  }

  @FXML
  private void setVisibilityTextField(boolean visible) {
    budgetTextField.setVisible(visible);
    durationTextField.setVisible(visible);
    buildingSizeTextField.setVisible(visible);
    kitchensTextField.setVisible(visible);
    bathroomsTextField.setVisible(visible);
    plumbingTextField.setVisible(visible);
    renovationTextField.setVisible(visible);

    if (!visible) {
      clearTextFields();
    }
  }

  private void clearTextFields() {
    budgetTextField.clear();
    durationTextField.clear();
    buildingSizeTextField.clear();
    kitchensTextField.clear();
    bathroomsTextField.clear();
    plumbingTextField.clear();
    renovationTextField.clear();
  }
}
