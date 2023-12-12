// ProjectsModelManager.java
// ProjectsModelManager.java
package Model;

import java.util.ArrayList;
import java.util.List;

// Import the Project class
import Projects.Project;

public class ProjectsModelManager implements ProjectsModel {
  private List<Project> projects;

  public ProjectsModelManager() {
    this.projects = new ArrayList<>();
    // Initialize projects or load them from a data source if needed
  }

  @Override
  public List<Project> getProjects() {
    return projects;
  }

  @Override
  public void addProject(Project project) {
    projects.add(project);
  }

  @Override
  public void removeProject(Project project) {
    projects.remove(project);
  }

  // Implement other methods if needed
}
