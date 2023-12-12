package Projects;

import java.util.ArrayList;
import java.util.List;

public class ProjectList
{
  private List<Project> completedProjects = new ArrayList<>();
  private List<Project> unfinishedProjects = new ArrayList<>();

  public ProjectList(){
    completedProjects=new ArrayList<>();
    unfinishedProjects=new ArrayList<>();
  }

  public List<Project> getCompletedProjects() {
    return completedProjects;
  }

  public List<Project> getUnfinishedProjects() {
    return unfinishedProjects;
  }

  public void addProject(Project project, boolean isFinished) {
    if (isFinished) {
      completedProjects.add(project);
    } else {
      unfinishedProjects.add(project);
    }
  }

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

  public void removeProject(Project project, boolean isFinished) {
    if (isFinished) {
      completedProjects.remove(project);
    } else {
      unfinishedProjects.remove(project);
    }
  }

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
