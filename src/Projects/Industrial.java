package Projects;

/**
 * A class representing an Industrial project, extending the Project class.
 * @author
 * @version 1.0 - December 2023
 */
class Industrial extends Project
{
  private double squareMeters;
  private String facilityType;

  /**
   * Eleven-argument constructor to an Industrial type of project
   * @param projectType       The type of the project
   * @param startDate         The start date of the project
   * @param endDate           The end date of the project
   * @param expectedDuration  The expected duration of the project
   * @param estimatedDate     The estimated date to complete of the project
   * @param estimatedPrice    The estimated cost of the project
   * @param projectStatus     The status of the project
   * @param projectId         The unique identifier for the project
   * @param manHoursUsed      The number of man-hours used in the project
   * @param squareMeters      The square meters of the commercial building
   * @param facilityType      The type of facility of the project
   */
  public Industrial(String projectType, MyDate startDate, MyDate endDate, MyDate expectedDuration,
      MyDate estimatedDate,
      double estimatedPrice, String projectStatus, int projectId, double manHoursUsed,
      double squareMeters,String facilityType) {
    super(projectType, startDate, endDate, expectedDuration,estimatedDate, estimatedPrice, projectStatus, projectId, manHoursUsed);
    this.squareMeters = squareMeters;
    this.facilityType=facilityType;
  }

  /**
   * Getter of the square meters of the project
   *
   * @return The square meters
   */
  public double getSquareMeters() {
    return squareMeters;
  }

  /**
   * Getter for the facility type of the project
   *
   * @return The facility type of the project
   */
  public String getFacilityType() {
    return facilityType;
  }

  /**
   * Sets the square meters of the Industrial project
   *
   * @param squareMeters The square meters to set
   */
  public void setSquareMeters(double squareMeters) {
    this.squareMeters = squareMeters;
  }

  /**
   * Sets the type of facilities of the Industrial project
   *
   * @param facilityType The facility project to set
   */
  public void setFacilityType(String facilityType) {
    this.facilityType = facilityType;
  }

  /**
   * A string method containing details about the Industrial project
   *
   * @return a string containing the details about the Industrial project
   */
  @Override public String toString()
  {
    StringBuilder result = new StringBuilder();
    result.append("Square Meters: ").append(this.getSquareMeters()).append("\n");
    result.append("Type Of Facility: ").append(this.getFacilityType()).append("\n");

    return result.toString();
  }

}