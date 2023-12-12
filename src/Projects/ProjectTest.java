package Projects;

import java.util.ArrayList;
import java.util.List;

public class ProjectTest {
  public static void main(String[] args) {

    /* there are multiple different projects created here i would say that project 5
    is the structure we should standardize but each of them have diffrent structures
    on how to create them and they all work*/

    ProjectManager projectManager = new ProjectManager();
    ProjectList projectList = new ProjectList();



    MyDate startDate5 = new MyDate(23, 3, 2003);
    Project project5 = projectManager.createProjectForCustomer("Industrial", startDate5);

    // Display initial details of project3
    System.out.println("\nBefore Update (Project 5):");
    System.out.println(project5.generateProgressReport());

    // Update details of project5

    // Check if it's a RoadConstruction project and update specific variables
    if (project5 instanceof RoadConstruction) {
      RoadConstruction roadConstructionProject1 = (RoadConstruction) project5;
      roadConstructionProject1.setRoadLengthKilometers(575);
      roadConstructionProject1.setRoadWidthMeters(40.75);
      roadConstructionProject1.setNumberOfRoadAlterations(4);
      roadConstructionProject1.setChallenges("steep hills tourdefranceEuesque");
    }



    // Display updated details of project3
    System.out.println("\nAfter Update (Project 5):");
    System.out.println(project5.generateProgressReport());



    for (Project p : projectList.getCompletedProjects()) {
      System.out.println(p.generateProgressReport());
      System.out.println("_____________________________________________________");
    }

    for (Project p : projectList.getUnfinishedProjects()) {
      System.out.println(p.generateProgressReport());
      System.out.println("_____________________________________________________");
    }

    projectManager.saveProjectsToHTML("projects.xml");

    projectList.addProject(project5, false);

    // Display information about projects in the list
    System.out.println("\nInformation about projects in the list:");
    displayProjects(projectList.getCompletedProjects(), "Completed Projects:");
    displayProjects(projectList.getUnfinishedProjects(), "Unfinished Projects:");

    projectManager.saveProjectsToHTML("projects.xml");
    System.out.println("New test");
    System.out.println(project5.expectedEndDuration());
    System.out.println(project5.getEndDate());
    System.out.println(project5.getId());
    System.out.println(project5.getManHoursUsed());
    System.out.println(project5.isFinished());
    System.out.println(project5.getEstimatedDate());

  }


  private static void displayProjects(List<Project> projects, String header) {
    System.out.println(header);
    for (Project project : projects) {
      System.out.println(project.generateProgressReport());
      System.out.println("_____________________________________________________");
    }

  }

}
