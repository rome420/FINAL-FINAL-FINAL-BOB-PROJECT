// ProjectsModel.java
package Model;

import Projects.ProjectManager;
import Projects.ViewHandler;
import Projects.Project;
import java.util.List;

public interface ProjectsModel {
  void setViewHandler(ViewHandler viewHandler);

  // Add this method to get the ProjectManager
  ProjectManager getProjectManager();

  // Other methods in your interface
  List<Project> getAllProjects();

  Project findProjectById(double projectId);

  // ... other methods ...
}