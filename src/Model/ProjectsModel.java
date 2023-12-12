// ProjectsModel.java
package Model;

import java.util.List;
import Projects.Project;  // Import the Project class

public interface ProjectsModel {
  List<Project> getProjects();

  void addProject(Project project);

  void removeProject(Project project);

  // Add other necessary methods for your application
}
