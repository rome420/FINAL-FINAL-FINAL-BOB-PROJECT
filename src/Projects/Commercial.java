package Projects;

/**
 * A class representing a Commercial project, extending the Project class.
 * @author
 * @version 1.0 - December 2023
 */
class Commercial extends Project
{
  private double squareMeters;
  private int numberOfFloors;
  private String buildingUse;

  /**
   * Twelve-argument constructor to Commercial type of project
   * @param projectType     The type of the project
   * @param startDate       The start date of the project
   * @param endDate         The end date of the project
   * @param expecteDuration The expected duration of the project
   * @param estimatedDate   The estimated date to complete of the project
   * @param estimatedPrice  The estimated cost of the project
   * @param projectStatus   The status of the project
   * @param projectId       The unique identifier for the project
   * @param manHoursUsed    The number of man-hours used in the project
   * @param squareMeters    The square meters of the commercial building
   * @param numberOfFloors  The number of floors in the commercial building
   * @param buildingUse     The designated use of the commercial building
   */
  public Commercial(String projectType, MyDate startDate, MyDate endDate, MyDate expecteDuration,
      MyDate estimatedDate, double estimatedPrice, String projectStatus, int projectId, double manHoursUsed,
      double squareMeters, int numberOfFloors, String buildingUse)
  {
    super(projectType, startDate, endDate, expecteDuration, estimatedDate,
        estimatedPrice, projectStatus, projectId, manHoursUsed);
    this.squareMeters = squareMeters;
    this.numberOfFloors = 1;
    this.buildingUse = buildingUse;
  }

  /**
   * Getter of the square meters of the commercial building
   *
   * @return the square meters
   */
  public double getSquareMeters()
  {
    return squareMeters;
  }

  /**
   * Sets the square meters of the commercial building
   *
   * @param squareMeters The square meters to set
   */
  public void setSquareMeters(double squareMeters)
  {
    this.squareMeters = squareMeters;
  }

  /**
   * Getter for the number of floors in the commercial building
   *
   * @return The number of floors
   */
  public int getNumberOfFloors()
  {
    return numberOfFloors;
  }

  /**
   * Sets the number of floors in the commercial building
   *
   * @param numberOfFloors The number of floors to set
   */
  public void setNumberOfFloors(int numberOfFloors)
  {
    this.numberOfFloors = numberOfFloors;
  }

  /**
   * Getter for the designated using of the building
   *
   * @return The building use
   */
  public String getBuildingUse()
  {
    return buildingUse;
  }

  /**
   * Sets the designated use of the building
   *
   * @param buildingUse The building use to set
   */
  public void setBuildingUse(String buildingUse)
  {
    this.buildingUse = buildingUse;
  }

  /**
   * A string method representation of the Commercial project
   *
   * @return A string containing details about the Commercial project
   */
  @Override public String toString()
  {
    StringBuilder result = new StringBuilder();
    result.append("Square Meters: ").append(this.getSquareMeters()).append("\n");
    result.append("Number of Floors: ").append(this.getNumberOfFloors()).append("\n");
    result.append("Building Use: ").append(this.getBuildingUse()).append("\n");
    // ... (other details specific to Commercial class)
    return result.toString();
  }

}


