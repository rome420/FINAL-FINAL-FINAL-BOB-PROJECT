package Projects;

import java.util.List;

public class ProjectListTest
{

  public static void main(String[] args) {
    // Creating instances of MyDate for the projects
    MyDate startDate5 = new MyDate(1, 1, 2001);
    MyDate startDate6 = new MyDate(1, 2, 2001);
    MyDate startDate7 = new MyDate(1, 3, 2001);
    MyDate startDate8 = new MyDate(1, 4, 2001);

    ProjectManager projectManager = new ProjectManager();

    // Creating an instance of ProjectList
    ProjectList projectList = new ProjectList();

    // Creating projects and adding them to the list
    Project project1 = createDefaultProject("Commercial");
    Project project2 = createDefaultProject("Residential");
    Project project3 =createDefaultProject("Industrial");
    Project project4 =createDefaultProject("RoadConstruction");

    Project project5 = projectManager.createProjectForCustomer("Commercial",startDate5);
    Project project6 = projectManager.createProjectForCustomer("Residential",startDate6);
    Project project7 =projectManager.createProjectForCustomer("Industrial",startDate7);
    Project project8 =projectManager.createProjectForCustomer("RoadConstruction",startDate8);

    projectList.addProject(project1, false);
    projectList.addProject(project2, true);
    projectList.addProject(project3, false);
    projectList.addProject(project4, true);
    projectList.addProject(project5, false);
    projectList.addProject(project6, true);
    projectList.addProject(project7, false);
    projectList.addProject(project8, true);


    // Displaying completed and unfinished projects
    System.out.println("Completed Projects:");
    displayProjects(projectList.getCompletedProjects());

    System.out.println("\nUnfinished Projects:");
    displayProjects(projectList.getUnfinishedProjects());

    // Retrieving a project by ID
    double projectIdToRetrieve = project1.getId();
    Project retrievedProject = projectList.retrieveProjectById(projectIdToRetrieve);
    if (retrievedProject != null) {
      System.out.println("\nFound Project by ID: " + retrievedProject.generateProgressReport());
    } else {
      System.out.println("\nProject with ID " + projectIdToRetrieve + " not found.");
    }

    // Removing a project
    double projectIdToRemove = project2.getId();
    projectList.removeProject(project2, false);

    // Displaying updated lists
    System.out.println("\nUpdated Unfinished Projects after removal:");
    displayProjects(projectList.getUnfinishedProjects());
  }

  private static void displayProjects(List<Project> projects) {
    for (Project project : projects) {
      System.out.println(project.generateProgressReport());
      System.out.println();
    }
  }

  private static Project createDefaultProject(String projectType) {
    ProjectManager projectManager = new ProjectManager();
    return projectManager.createDefaultProject(projectType);
  }
}
