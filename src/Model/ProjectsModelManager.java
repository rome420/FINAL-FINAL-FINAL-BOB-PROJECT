
package Model;

import Projects.Project;
import Projects.ProjectManager;
import Projects.ViewHandler;

import java.util.List;

public class ProjectsModelManager implements ProjectsModel {
  private ProjectManager projectManager;

  public ProjectsModelManager() {
    this.projectManager = new ProjectManager();
  }

  @Override
  public ProjectManager getProjectManager() {
    return projectManager;
  }

  @Override
  public List<Project> getAllProjects() {
    // Implement the method to get all projects
    return projectManager.getAllProjects();
  }

  @Override
  public Project findProjectById(double projectId) {
    // Implement the method to find a project by ID
    return projectManager.findProjectById(projectId);
  }

  // ... other methods ...

  @Override
  public void setViewHandler(ViewHandler viewHandler) {
    // Implement the method to set the view handler
  }

}