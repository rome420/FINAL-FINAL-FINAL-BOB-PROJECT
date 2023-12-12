
package Model;

import java.util.ArrayList;
import java.util.List;

// Import the Project class
import Projects.Project;
import Projects.ViewHandler;

import javax.swing.text.View;

public class ProjectsModelManager implements ProjectsModel {
  private List<Project> projects;
  private ViewHandler viewHandler;

  public ProjectsModelManager() {
    this.projects = new ArrayList<>();
    // Initialize projects or load them from a data source if needed
  }


  public List<Project> getProjects() {
    return projects;
  }

  public void addProject(Project project) {
    projects.add(project);
  }


  public void removeProject(Project project) {
    projects.remove(project);
  }


  public void setViewHandler(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
  }

  // Implement other methods if needed
}