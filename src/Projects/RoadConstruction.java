package Projects;

/**
 * A class representing a Road Construction project, extending the Project class
 * This class includes additional attributes specific to Road Construction projects
 *
 * @author Ildo Mota
 * @version 1.0 December 2023
 */
public class RoadConstruction extends Project
{ // aa
  private double roadLengthKilometers;
  private double roadWidthMeters;
  private int numberOfRoadAlterations;
  private String challenges;

  /**
   * Thirteen-argument Constructor of a Road Construction project with specified attributes.
   *
   * @param projectType              The type of the project.
   * @param startDate                The start date of the project.
   * @param endDate                  The end date of the project.
   * @param expectedDuration         The expected duration of the project.
   * @param estimatedDate            The estimated completion date of the project.
   * @param estimatedPrice           The estimated cost of the project.
   * @param projectStatus            The status of the project.
   * @param projectId                The unique identifier for the project.
   * @param manHoursUsed             The number of man-hours used in the project.
   * @param roadLengthKilometers     The length of the road in kilometers.
   * @param roadWidthMeters          The width of the road in meters.
   * @param numberOfRoadAlterations  The number of alterations made to the road during construction.
   * @param challenges               The challenges faced during road construction.
   */
  public RoadConstruction(String projectType, MyDate startDate, MyDate endDate, MyDate expectedDuration,
      MyDate estimatedDate,
      double estimatedPrice, String projectStatus, int projectId, double manHoursUsed,
      double roadLengthKilometers,double roadWidthMeters,int numberOfRoadAlterations,String challenges) {
    super(projectType, startDate, endDate, expectedDuration,estimatedDate, estimatedPrice, projectStatus,projectId,manHoursUsed);

    this.roadLengthKilometers =roadLengthKilometers ;
    this.roadWidthMeters = roadWidthMeters;
    this.numberOfRoadAlterations = 0;
    this.challenges = "None";

  }

  /**
   * Getter of the length of the road in kilometers.
   *
   * @return The road length in kilometers.
   */
  public double getRoadLengthKilometers() {
    return roadLengthKilometers;
  }

  /**
   * Getter of the width of the road in meters.
   *
   * @return The road width in meters.
   */
  public double getRoadWidthMeters() {
    return roadWidthMeters;
  }

  /**
   * Getter the number of alterations made to the road during construction.
   *
   * @return The number of road alterations.
   */
  public int getNumberOfRoadAlterations() {
    return numberOfRoadAlterations;
  }

  /**
   * Getter the challenges faced during road construction.
   *
   * @return The challenges during road construction.
   */
  public String getChallenges() {
    return challenges;
  }



  /**
   * Sets the length of the road in kilometers.
   *
   * @param roadLengthKilometers The road length in kilometers to set.
   */
  public void setRoadLengthKilometers(double roadLengthKilometers) {
    this.roadLengthKilometers = roadLengthKilometers;
  }

  /**
   * Sets the width of the road in meters.
   *
   * @param roadWidthMeters The road width in meters to set.
   */
  public void setRoadWidthMeters(double roadWidthMeters) {
    this.roadWidthMeters = roadWidthMeters;
  }

  /**
   * Sets the number of alterations made to the road during construction.
   *
   * @param numberOfRoadAlterations The number of road alterations to set.
   */
  public void setNumberOfRoadAlterations(int numberOfRoadAlterations) {
    this.numberOfRoadAlterations = numberOfRoadAlterations;
  }

  /**
   * Sets the challenges faced during road construction.
   *
   * @param challenges The challenges during road construction to set.
   */
  public void setChallenges(String challenges) {
    this.challenges = challenges;
  }

  /**
   * A string method representation of the Road Construction project.
   *
   * @return A string containing details about the Road Construction project.
   */
  @Override public String toString()
  {
    StringBuilder result = new StringBuilder();
    result.append("Lenght of Road in Kilometers: ").append(this.getRoadLengthKilometers()).append("\n");
    result.append("Width of Road in Meters: ").append(this.getRoadWidthMeters()).append("\n");
    result.append("Number Of Road Alterations: ").append(this.getNumberOfRoadAlterations()).append("\n");
    result.append("Challenges: ").append(this.getChallenges()).append("\n");

    // ... (other details specific to Commercial class)
    return result.toString();
  }


}

