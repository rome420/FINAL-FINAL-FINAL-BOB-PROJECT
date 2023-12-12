package Projects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProjectManager
{
  private List<Project> projects;

  private ViewHandler viewHandler;



  public ProjectManager()
  {
    projects = new ArrayList<>();

  }

  public ProjectManager(ViewHandler viewHandler) {
    this.viewHandler = viewHandler;
  }

  public void setViewHandler(ViewHandler viewHandler) {
    this.viewHandler = viewHandler;
  }

  // Project-related methods

  public void addProject(Project project, boolean isFinished) {
    projects.add(project);
    project.setFinishedProjects(isFinished);

    if (viewHandler != null && viewHandler.getProjectsViewController() != null) {
      // Update the TableView in the UI
      viewHandler.getProjectsViewController().addProjectToTableView(project);
      viewHandler.getProjectsViewController().projectAdded(project, isFinished);
    } else {
      System.err.println("Error: viewHandler or ProjectsViewController is not initialized");
    }
  }

  public void removeProject(Project project, boolean isFinished)
  {
    projects.remove(project);
    project.setFinishedProjects(isFinished);
  }

  public List<Project> getAllProjects()
  {
    return projects;
  }

  public Project findProjectById(double projectId)
  {
    for (Project project : projects)
    {
      if (project.getId() == projectId)
      {
        return project;
      }
    }
    return null;
  }



  public List<Project> getProjectsByType(String projectType)
  {
    List<Project> projectsByType = new ArrayList<>();

    for (Project project : projects)
    {
      if (projectType.equalsIgnoreCase("Commercial") && project instanceof Commercial)
      {
        projectsByType.add(project);
      }
      else if (projectType.equalsIgnoreCase("Industrial") && project instanceof Industrial)
      {
        projectsByType.add(project);
      }
      else if (projectType.equalsIgnoreCase("RoadConstruction") && project instanceof RoadConstruction)
      {
        projectsByType.add(project);
      }
      else if (projectType.equalsIgnoreCase("Residential") && project instanceof Residential)
      {
        projectsByType.add(project);
      }
    }

    return projectsByType;
  }

  public Commercial createDefaultCommercialProject()
  {
    // You can set default values for Commercial projects here
    Commercial commercial = new Commercial("Commercial", new MyDate(26, 8, 2001), new MyDate(0,
        0, 0000), new MyDate(0),new MyDate(0,0,0000), 0, "New Build", 0, 0, 0, 1, "Default Building Use");

    // Set specific default values for Commercial
    double estimatedPrice = 500000;
    MyDate expectedDuration = new MyDate(18);

    // Validate the estimated price and duration
    if (estimatedPrice >= 500000 && estimatedPrice <= 2000000
        && expectedDuration.getMonth() >= 12 && expectedDuration.getMonth() <= 24)
    {
      commercial.setEstimatedPrice(estimatedPrice);
      commercial.setExpectedDuration(expectedDuration);
      commercial.calculateAndSetEstimatedDate();
    }
    else
    {
      commercial.setEstimatedPrice(0);
      commercial.setExpectedDuration(new MyDate(0)); // Use the new method to set duration directly
    }
    return commercial;
  }

  public static void displayCommercialDetails(Commercial commercialProject) {
    System.out.println("Square Meters: " + commercialProject.getSquareMeters());
    System.out.println("Number of Floors: " + commercialProject.getNumberOfFloors());
    System.out.println("Building Use: " + commercialProject.getBuildingUse());
  }

  public void updateCommercialDetails(
      Commercial commercialProject, MyDate expectedDuration, double estimatedPrice,
      double squareMeters, int numberOfFloors, String buildingUse) {
    if (estimatedPrice >= 500000 && estimatedPrice <= 2000000
        && expectedDuration.getMonth() >= 12 && expectedDuration.getMonth() <= 24
        && squareMeters >= 0 && numberOfFloors >= 0) {
      commercialProject.setEstimatedPrice(estimatedPrice);
      commercialProject.setExpectedDuration(expectedDuration);
      commercialProject.setSquareMeters(squareMeters);
      commercialProject.setNumberOfFloors(numberOfFloors);
      commercialProject.setBuildingUse(buildingUse);
      // Update other details as needed
    } else {
      // Handle invalid values as needed
    }
  }




  public Residential createDefaultResidentialProject() {
      Residential residential = new Residential("Residential",
          new MyDate(26, 8, 2001), new MyDate(0, 0, 0000), new MyDate(0), new MyDate(00,00,0000),0,
          "in-progress", 0, 0, 0, 1, 1, 1, true);

      double estimatedPrice = 100000;
      MyDate expectedDuration = new MyDate(0,9,0);

      if (estimatedPrice >= 100000 && estimatedPrice <= 500000
          && expectedDuration.getMonth() >= 6 && expectedDuration.getMonth() <= 12) {
        residential.setEstimatedPrice(estimatedPrice);
        residential.setExpectedDuration(expectedDuration);
        residential.calculateAndSetEstimatedDate();

      } else {
        residential.setEstimatedPrice(0);
        residential.setExpectedDuration(new MyDate(0)); // Use the new method to set duration directly
      }

      return residential;
    }
  public static void displayResidentialDetails(Residential residentialProject) {
    System.out.println("Square Meters: " + residentialProject.getSquareMeters());
    System.out.println("Number of Kitchens: " + residentialProject.getNumberOfKitchens());
    System.out.println("Number of Bathrooms: " + residentialProject.getNumberOfBathrooms());
    System.out.println("Other Rooms with Plumbing: " + residentialProject.getOtherRoomsWithPlumbing());
    System.out.println("Is New Build: " + residentialProject.getIsNewBuild());
  }

  public void updateResidentialDetails(Residential residentialProject,
      MyDate expectedDuration, double estimatedPrice,
      double squareMeters,int numberOfKitchens, int numberOfBathrooms,
      int otherRoomsWithPlumbing, boolean isNewBuild){
      if (estimatedPrice >= 100000 && estimatedPrice <= 500000
          && expectedDuration.getMonth() >= 6 && expectedDuration.getMonth() <= 12)
      {
        residentialProject.setEstimatedPrice(estimatedPrice);
        residentialProject.setExpectedDuration(expectedDuration);
        residentialProject.setSquareMeters(squareMeters);
        residentialProject.setNumberOfKitchens(numberOfKitchens);
        residentialProject.setNumberOfBathrooms(numberOfBathrooms);
        residentialProject.setOtherRoomsWithPlumbing(otherRoomsWithPlumbing);
        residentialProject.setNewBuild(isNewBuild);
        // Update other details as needed
      }
      else
      {

      }
    }




  public Industrial createDefaultIndustrialProject() {
    // You can set default values for Industrial projects here
    Industrial industrial = new Industrial("Industrial", new MyDate(26, 8, 2001), new MyDate(0, 0, 0000), new MyDate(0),
        new MyDate(0,0,0000),0, "New Build", 0, 0, 0, "null");

    // Set specific default values for Industrial
    double estimatedPrice = 2000000; // Set the default estimated price to 8000000
    MyDate expectedDuration = new MyDate(30);
    // Validate the estimated price and duration
    if (estimatedPrice >= 2000000 && estimatedPrice <= 10000000
        && expectedDuration.getMonth() >= 24 && expectedDuration.getMonth() <= 36) {
      industrial.setEstimatedPrice(estimatedPrice);
      industrial.setExpectedDuration(expectedDuration);
    } else {
      industrial.setEstimatedPrice(0);
      industrial.setExpectedDuration(new MyDate(0));
      industrial.calculateAndSetEstimatedDate();
    }

    return industrial;
  }
  public static void displayIndustrialDetails(Industrial industrialProject) {
    System.out.println("Square Meters: " + industrialProject.getSquareMeters());
    System.out.println("Facility Type: " + industrialProject.getFacilityType());
  }
  public void updateIndustrialDetails(
      Industrial industrialProject, MyDate expectedDuration, double estimatedPrice,
      double squareMeters, String facilityType) {
    if (estimatedPrice >= 2000000 && estimatedPrice <= 10000000
        && expectedDuration.getMonth() >= 24 && expectedDuration.getMonth() <= 36) {
      industrialProject.setEstimatedPrice(estimatedPrice);
      industrialProject.setExpectedDuration(expectedDuration);
      industrialProject.setSquareMeters(squareMeters);
      industrialProject.setFacilityType(facilityType);
      // Update other details as needed
    } else {
      // invalid value maybe squaremeters<0
    }
  }




  public RoadConstruction createDefaultRoadConstructionProject() {
    // You can set default values for Road Construction projects here
    RoadConstruction roadConstruction = new RoadConstruction(
        "RoadConstruction", new MyDate(26, 8, 2001), new MyDate(0, 0, 0000), new MyDate(0),
        new MyDate(0,0,0000),0, "New Build", 0, 0, 0, 10, 0, "none");

    double estimatedPrice = 1000000; // Set the default estimated price to 3000000
    MyDate expectedDuration = new MyDate(18); // Set the default duration to 18 months

    if (estimatedPrice >= 1000000 && estimatedPrice <= 5000000
        && expectedDuration.getMonth() >= 12 && expectedDuration.getMonth() <= 24) {
      roadConstruction.setEstimatedPrice(estimatedPrice);
      roadConstruction.setExpectedDuration(expectedDuration);
    } else {
      roadConstruction.setEstimatedPrice(0);
      roadConstruction.setExpectedDuration(new MyDate(0));
      roadConstruction.setExpectedDuration(expectedDuration);

    }

    return roadConstruction;
  }
  public static void displayRoadConstructionDetails(
      RoadConstruction roadConstructionProject) {
    System.out.println("Road Length (km): " + roadConstructionProject.getRoadLengthKilometers());
    System.out.println("Road Width (m): " + roadConstructionProject.getRoadWidthMeters());
    System.out.println("Number of Road Alterations: " + roadConstructionProject.getNumberOfRoadAlterations());
    System.out.println("Challenges: " + roadConstructionProject.getChallenges());
  }

  public void updateRoadConstructionDetails(
      RoadConstruction roadConstructionProject, MyDate expectedDuration, double estimatedPrice,
      double roadLengthKilometers, double roadWidthMeters, int numberOfRoadAlterations, String challenges)
  {
    if (estimatedPrice >= 1000000 && estimatedPrice <= 5000000
        && expectedDuration.getMonth() >= 12 && expectedDuration.getMonth() <= 24
        && roadLengthKilometers >= 0 && roadWidthMeters >= 0)
    {
      roadConstructionProject.setEstimatedPrice(estimatedPrice);
      roadConstructionProject.setExpectedDuration(expectedDuration);
      roadConstructionProject.setRoadLengthKilometers(roadLengthKilometers);
      roadConstructionProject.setRoadWidthMeters(roadWidthMeters);
      roadConstructionProject.setNumberOfRoadAlterations(numberOfRoadAlterations);
      roadConstructionProject.setChallenges(challenges);
      // Update other details as needed
    }
    else
    {
      // Handle invalid values as needed
    }
  }


  public Project createDefaultProject(String projectType) {
    Project project;

    switch (projectType) {
      case "RoadConstruction":
        project = createDefaultRoadConstructionProject();
        break;
      case "Residential":
        project = createDefaultResidentialProject();
        break;
      case "Commercial":
        project = createDefaultCommercialProject();
        break;
      case "Industrial":
        project = createDefaultIndustrialProject();
        break;

      default:
        throw new IllegalArgumentException("Unknown project type: " + projectType);
    }

    return project;
  }
  public Project createProjectForCustomer(String projectType, MyDate startDate) {
    Project project = createDefaultProject(projectType);
    project.setStartDate(startDate);

    // Additional settings or validations if needed

    addProject(project, false); // Assuming the project is not finished initially
    return project;
  }

  public void saveProjectsToHTML(String fileName) {
    try {
      StringBuilder htmlData = new StringBuilder();
      htmlData.append("<html>\n");
      htmlData.append("<head><title>Projects</title></head>\n");
      htmlData.append("<body>\n");

      for (Project project : projects) {
        htmlData.append("  <div class=\"project\">\n");
        htmlData.append("    <h2>Project ID: ").append(project.getId()).append("</h2>\n");
        htmlData.append("    <p>Type: ").append(project.getProjectType()).append("</p>\n");
        htmlData.append("    <p>Start Date: ").append(project.getStartDate()).append("</p>\n");
        htmlData.append("    <p>End Date: ").append(project.getEndDate()).append("</p>\n");
        htmlData.append("    <p>Expected Duration: ").append(project.expectedDuration()).append("</p>\n");
        htmlData.append("    <p>Estimated Date: ").append(project.getEstimatedDate()).append("</p>\n");
        htmlData.append("    <p>Estimated Price: $").append(project.getEstimatedPrice()).append("</p>\n");
        htmlData.append("    <p>Project Status: ").append(project.getProjectStatus()).append("</p>\n");
        htmlData.append("    <p>Is Finished: ").append(project.isFinished()).append("</p>\n");
        htmlData.append("    <p>Man Hours Used: ").append(project.getManHoursUsed()).append("</p>\n");

        // Add type-specific details based on project type
        if (project instanceof Residential) {
          displayResidentialData(htmlData, (Residential) project);
        } else if (project instanceof Commercial) {
          displayCommercialData(htmlData, (Commercial) project);
        } else if (project instanceof Industrial) {
          displayIndustrialData(htmlData, (Industrial) project);
        } else if (project instanceof RoadConstruction) {
          displayRoadConstructionData(htmlData, (RoadConstruction) project);
        }

        htmlData.append("  </div>\n");
      }

      htmlData.append("</body>\n");
      htmlData.append("</html>");

      // Write the HTML data to a file
      Files.write(Paths.get(fileName), htmlData.toString().getBytes());

      System.out.println("Projects saved to HTML file: " + fileName);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void displayResidentialData(StringBuilder htmlData, Residential residential) {
    htmlData.append("    <p>Square Meters: ").append(residential.getSquareMeters()).append("</p>\n");
    htmlData.append("    <p>Number of Kitchens: ").append(residential.getNumberOfKitchens()).append("</p>\n");
    htmlData.append("    <p>Number of Bathrooms: ").append(residential.getNumberOfBathrooms()).append("</p>\n");
    htmlData.append("    <p>Other Rooms with Plumbing: ").append(residential.getOtherRoomsWithPlumbing()).append("</p>\n");
    htmlData.append("    <p>Is New Build: ").append(residential.getIsNewBuild()).append("</p>\n");
  }

  private void displayCommercialData(StringBuilder htmlData, Commercial commercial) {
    htmlData.append("    <p>Square Meters: ").append(commercial.getSquareMeters()).append("</p>\n");
    htmlData.append("    <p>Number of Floors: ").append(commercial.getNumberOfFloors()).append("</p>\n");
    htmlData.append("    <p>Building Use: ").append(commercial.getBuildingUse()).append("</p>\n");
  }

  private void displayIndustrialData(StringBuilder htmlData, Industrial industrial) {
    htmlData.append("    <p>Square Meters: ").append(industrial.getSquareMeters()).append("</p>\n");
    htmlData.append("    <p>Facility Type: ").append(industrial.getFacilityType()).append("</p>\n");
  }

  private void displayRoadConstructionData(StringBuilder htmlData, RoadConstruction roadConstruction) {
    htmlData.append("    <p>Road Length (km): ").append(roadConstruction.getRoadLengthKilometers()).append("</p>\n");
    htmlData.append("    <p>Road Width (m): ").append(roadConstruction.getRoadWidthMeters()).append("</p>\n");
    htmlData.append("    <p>Number of Road Alterations: ").append(roadConstruction.getNumberOfRoadAlterations()).append("</p>\n");
    htmlData.append("    <p>Challenges: ").append(roadConstruction.getChallenges()).append("</p>\n");
  }

  private Element createProjectElement(Document doc, Project project) {
    Element projectElement = doc.createElement("project");

    // Add project attributes
    projectElement.setAttribute("id", String.valueOf(project.getId()));
    projectElement.setAttribute("type", project.getProjectType());
    // Add other project attributes as needed

    // Add child elements for project details
    appendChildElement(doc, projectElement, "start_date", project.getStartDate().toString());
    appendChildElement(doc, projectElement, "end_date", project.getEndDate().toString());
    // Add other child elements as needed

    return projectElement;
  }

  private void appendChildElement(Document doc, Element parent, String tagName, String textContent) {
    Element childElement = doc.createElement(tagName);
    childElement.appendChild(doc.createTextNode(textContent));
    parent.appendChild(childElement);
  }

}