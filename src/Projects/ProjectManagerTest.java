package Projects;

import java.util.List;

public class ProjectManagerTest
{
  public static void main(String[] args) {
    // Create ProjectManager
    ProjectManager projectManager = new ProjectManager();

    // Create projects
    Commercial commercialProject = projectManager.createDefaultCommercialProject();
    Residential residentialProject = projectManager.createDefaultResidentialProject();
    Industrial industrialProject = projectManager.createDefaultIndustrialProject();
    RoadConstruction roadConstructionProject = projectManager.createDefaultRoadConstructionProject();

    // Add projects to ProjectManager
    projectManager.addProject(commercialProject, false);
    projectManager.addProject(residentialProject, true);
    projectManager.addProject(industrialProject, false);
    projectManager.addProject(roadConstructionProject, true);

    // Display all projects
    List<Project> allProjects = projectManager.getAllProjects();
    for (Project project : allProjects) {
      System.out.println(project.generateProgressReport());
    }

    // Test finding project by ID
    double projectIdToFind = residentialProject.getId();
    Project foundProject = projectManager.findProjectById(projectIdToFind);
    if (foundProject != null) {
      System.out.println("\nFound Project by ID: " + foundProject.generateProgressReport());
    } else {
      System.out.println("\nProject with ID " + projectIdToFind + " not found.");
    }

    // Test finding project by type
    String projectTypeToFind = "Commercial";
    List<Project> projectsByType = projectManager.getProjectsByType(projectTypeToFind);
    System.out.println("\nProjects of type " + projectTypeToFind + ":");
    for (Project project : projectsByType) {
      System.out.println(project.generateProgressReport());
    }
  }
}
