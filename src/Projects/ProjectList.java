package Projects;

import java.util.ArrayList;
import java.util.List;

/**
 * The ProjectList class represents a list of completed and unfinished projects
 * It provides methods for adding, retrieving, and removing projects,
 * as well as searching for projects by ID, type, and marking projects as finished
 *
 * @author
 * @version 1.0 - December 2023
 */
public class ProjectList
{
  private List<Project> completedProjects = new ArrayList<>();
  private List<Project> unfinishedProjects = new ArrayList<>();

  /**
   * Default constructor for creating a ProjectList with empty lists for completed and unfinished projects
   *
   */
  public ProjectList(){
    completedProjects=new ArrayList<>();
    unfinishedProjects=new ArrayList<>();
  }

  /**
   * Getter for the list of completed projects
   *
   * @return The list of completed projects
   */
  public List<Project> getCompletedProjects() {
    return completedProjects;
  }

  /**
   * Getter for the list of unfinished projects
   *
   * @return The list of unfinished projects
   */
  public List<Project> getUnfinishedProjects() {
    return unfinishedProjects;
  }

  /**
   * Adds a project to either the completed or unfinished projects list
   *
   * @param project    The project to add
   * @param isFinished True if the project is finished, false otherwise
   */
  public void addProject(Project project, boolean isFinished) {
    if (isFinished) {
      completedProjects.add(project);
    } else {
      unfinishedProjects.add(project);
    }
  }

  /**
   * Retrieves a project from either the completed or unfinished projects list based on the specified ID
   *
   * @param id The ID of the project to retrieve
   * @return The project with the specified ID, or null if not found
   */
  public Project retrieveProjectById(double id) {
    for (Project p : completedProjects) {
      if (p.getId() == id) {
        return p;
      }
    }

    for (Project p : unfinishedProjects) {
      if (p.getId() == id) {
        return p;
      }
    }

    return null;
  }

  /**
   * Removes a project from either the completed or unfinished projects list
   *
   * @param project    The project to remove
   * @param isFinished True if the project is finished, false otherwise
   */
  public void removeProject(Project project, boolean isFinished) {
    if (isFinished) {
      completedProjects.remove(project);
    } else {
      unfinishedProjects.remove(project);
    }
  }

  /**
   * Searches for a project with the specified type in either the completed or unfinished projects list
   *
   * @param projectType The type of the project
   * @return The project with the specified type, or null if not found
   */
  public Project searchProjectByType(String projectType) {
    for (Project p : completedProjects) {
      if (p.getProjectType().equals(projectType)) {
        return p;
      }
    }

    for (Project p : unfinishedProjects) {
      if (p.getProjectType().equals(projectType)) {
        return p;
      }
    }

    return null;
  }

  /**
   * Marks a project as finished based on the specified project ID
   *
   * @param projectId The ID of the project to mark as finished
   */
  public void markProjectAsFinished(double projectId) {
    Project projectToMark = null;

    for (Project project : unfinishedProjects) {
      if (project.getId() == projectId) {
        projectToMark = project;
        break;
      }
    }

    if (projectToMark != null) {
      unfinishedProjects.remove(projectToMark);
      completedProjects.add(projectToMark);
    } else {
      System.out.println("Project with ID " + projectId + " not found in the unfinished projects list.");
    }
  }
}
