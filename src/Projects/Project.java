package Projects;

/**
 * A class representing a construction project
 * @author
 * @version 1.0 - December 2023
 */
public class Project
{
  private static int lastAssignedId = 1000;
  private String projectType;
  private MyDate startDate;
  private MyDate endDate;
  private MyDate estimatedDate;
  private MyDate expectedDuration;
  private double estimatedPrice;
  private String projectStatus;
  private boolean isFinished;
  private int projectId;
  private double manHoursUsed;

  /**
   * Nine-argument constructor of a project
   * @param projectType         The type of the project
   * @param startDate           The start date of the project
   * @param endDate             The end date of the project
   * @param expectedDuration    The expected duration of the project
   * @param estimatedDate       The estimated completion date of the project
   * @param estimatedPrice      The estimated cost of the project
   * @param projectStatus       The status of the project
   * @param projectId           The unique identifier for the project
   * @param manHoursUsed        The number of man-hours used in the project
   */
  public Project(String projectType, MyDate startDate, MyDate endDate, MyDate expectedDuration,MyDate estimatedDate,double estimatedPrice, String projectStatus,
      int projectId, double manHoursUsed)
  {
    this.projectType = projectType;
    this.startDate = startDate;
    if (endDate == null) {
      this.endDate = new MyDate(); // You can set a default value or leave it as null
    } else {
      this.endDate = endDate;
    }
    this.expectedDuration = expectedDuration;
    this.estimatedPrice = estimatedPrice;
    this.projectStatus = projectStatus;
    // Assuming the default value for isFinished is false when a project is created
    this.isFinished = false;
    this.projectId = ++lastAssignedId;
    this.manHoursUsed = 0;
    this.estimatedDate=estimatedDate;
  }

  // Getter methods...
  /**
   * Getter of the type of the project.
   *
   * @return The project type.
   */
  public String getProjectType()
  {
    return projectType;
  }

  /**
   * Getter of the start date of the project.
   *
   * @return The start date.
   */
  public MyDate getStartDate()
  {
    return startDate;
  }

  /**
   * Getter of the end date of the project.
   *
   * @return The end date.
   */
  public MyDate getEndDate()
  {
    return endDate;
  }

  /**
   * Getter of the expected duration of the project.
   *
   * @return The expected duration.
   */
  public MyDate expectedDuration()
  {
    return expectedDuration;
  }

  /**
   * Getter of the estimated completion date of the project.
   *
   * @return The estimated completion date.
   */
  public MyDate getEstimatedDate(){return estimatedDate;}

  /**
   * Getter of the estimated cost of the project.
   *
   * @return The estimated cost.
   */
  public double getEstimatedPrice()
  {
    return estimatedPrice;
  }

  /**
   * Getter the status of the project.
   *
   * @return The project status.
   */
  public String getProjectStatus()
  {
    return projectStatus;
  }


  /**
   * Gets whether the project is finished.
   *
   * @return True if the project is finished, false otherwise.
   */
  public Boolean isFinished()
  {
    return isFinished;
  }

  /**
   * Getter of the unique identifier for the project.
   *
   * @return The project ID.
   */
  public int getId()
  {
    return projectId;
  }

  /**
   * Getter of the number of man-hours used in the project.
   *
   * @return The man-hours used.
   */
  public double getManHoursUsed()
  {
    return manHoursUsed;
  }

  // Setter methods...
  /**
   * Sets the type of the project.
   *
   * @param projectType The project type to set.
   */
  public void setProjectType(String projectType)
  {
    this.projectType = projectType;
  }



  /**
   * Sets the start date of the project.
   *
   * @param startDate The start date to set.
   */
  public void setStartDate(MyDate startDate) {
    this.startDate = startDate;
    calculateAndSetEstimatedDate(); // Recalculate estimated date when start date changes
  }

  /**
   * Sets the end date of the project.
   *
   * @param endDate The end date to set.
   * @throws IllegalArgumentException if the end date is before the start date.
   */
  public void setEndDate(MyDate endDate) throws IllegalArgumentException {
    if (startDate != null && endDate != null && endDate.isBefore(startDate)) {
      throw new IllegalArgumentException("End date cannot be before the start date");
    }
    this.endDate = endDate;
  }


  /**
   * Sets the expected duration of the project.
   *
   * @param expectedDuration The expected duration to set.
   */
  public void setExpectedDuration(MyDate expectedDuration) {
    if (expectedDuration.getMonth() < 0) {
      throw new IllegalArgumentException("Expected duration months cannot be negative");
    }
    this.expectedDuration = expectedDuration; // Use expectedDuration instance variable
    calculateAndSetEstimatedDate(); // Recalculate estimated date when duration changes

  }

  public String expectedEndDuration(){
    return expectedDuration.expectedDuration();
  }

  /**
   * Calculates and sets the estimated completion date based on start date and expected duration.
   */
  public void calculateAndSetEstimatedDate() {
    // Ensure both startDate and expectedDuration are set
    if (startDate != null && expectedDuration != null) {
      this.estimatedDate = startDate.add(expectedDuration);
    }
  }

  /**
   * Sets the estimated cost of the project.
   *
   * @param estimatedPrice The estimated cost to set.
   * @throws IllegalArgumentException if the estimated price is negative.
   */
  public void setEstimatedPrice(double estimatedPrice) {
    if (estimatedPrice < 0) {
      throw new IllegalArgumentException("Estimated price cannot be negative");
    }
    this.estimatedPrice = estimatedPrice;
  }

  /**
   * Sets the status of the project.
   *
   * @param projectStatus The project status to set.
   */

  public void setProjectStatus(String projectStatus)
  {
    this.projectStatus = projectStatus;
  }

  /**
   * Sets whether the project is finished.
   *
   * @param isFinished True if the project is finished, false otherwise.
   */
  public void setFinishedProjects(boolean isFinished)
  {
    this.isFinished = isFinished;
  }

  /**
   * Sets the unique identifier for the project.
   *
   * @param projectId The project ID to set.
   */
  public void setProjectId(int projectId)
  {
    this.projectId = projectId;
  }

  /**
   * Sets the number of man-hours used in the project.
   *
   * @param manHoursUsed The man-hours used to set.
   * @throws IllegalArgumentException if man-hours used is negative.
   */
  public void setManHoursUsed(double manHoursUsed) throws IllegalArgumentException {
    if (manHoursUsed < 0) {
      throw new IllegalArgumentException("Man hours used cannot be negative");
    }
    this.manHoursUsed = manHoursUsed;
  }

  /**
   * Generates a progress report for the project.
   *
   * @return A string containing details about the project's progress.
   */
  public String generateProgressReport() {
    StringBuilder report = new StringBuilder();

    // Basic project information
    report.append("Project ID: ").append(projectId).append("\n");
    report.append("Project Type: ").append(projectType).append("\n");
    report.append("Start Date: ").append(startDate).append("\n");
    report.append("Expected Duration: ").append(expectedDuration).append("\n");
    report.append("Estimated Date: ").append(estimatedDate).append("\n");
    report.append("End Date: ").append(endDate).append("\n");
    report.append("Estimated Price: $").append(estimatedPrice).append("\n");
    report.append("Project Status: ").append(projectStatus).append("\n");
    report.append("Is Finished: ").append(isFinished).append("\n");
    report.append("Man Hours Used: ").append(manHoursUsed).append("\n");

    if (projectStatus.equalsIgnoreCase("in-progress")) {
      report.append("Project is in-progress.").append("\n");
    } else if (projectStatus.equalsIgnoreCase("completed")) {
      report.append("Project is completed.").append("\n");
    }

    // Append subclass-specific details
    if (this instanceof Residential) {
      report.append(((Residential) this).toString());
    } else if (this instanceof Commercial) {
      report.append(((Commercial) this).toString());
    } else if (this instanceof Industrial) {
      report.append(((Industrial) this).toString());
    } else if (this instanceof RoadConstruction) {
      report.append(((RoadConstruction) this).toString());
    }

    return report.toString();
  }


}