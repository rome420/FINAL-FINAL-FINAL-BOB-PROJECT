package Projects;

/**
 * Represents a Residential project, extending Project class.
 * This class includes additional attributes specific to Residential projects.
 * @author
 * @version 1.0 - December 2023
 */
class Residential extends Project
{
  private double squareMeters;
  private int numberOfKitchens;
  private int numberOfBathrooms;
  private int otherRoomsWithPlumbing;
  private boolean isNewBuild;

  /**
   * A fourteen-argument constructor of a Residential project
   * @param projectType            The type of the project
   * @param startDate              The start date of the project
   * @param endDate                The end date of the project
   * @param expectedDuration       The expected duration of the project
   * @param estimatedDate          The estimated completion date of the project
   * @param estimatedPrice         The estimated cost of the project
   * @param projectStatus          The status of the project
   * @param projectId              The unique identifier for the project
   * @param manHoursUsed           The number of man-hours used in the project
   * @param squareMeters           The square meters of the residential building
   * @param numberOfKitchens       The number of kitchens in the residential building
   * @param numberOfBathrooms      The number of bathrooms in the residential building
   * @param otherRoomsWithPlumbing The number of other rooms with plumbing in the residential building
   * @param isNewBuild             Indicates whether the residential building is a new build
   */
  public Residential(String projectType, MyDate startDate, MyDate endDate, MyDate expectedDuration, MyDate estimatedDate,
      double estimatedPrice, String projectStatus, int projectId, double manHoursUsed,
      double squareMeters,int numberOfKitchens, int numberOfBathrooms,
      int otherRoomsWithPlumbing, boolean isNewBuild) {
    super(projectType, startDate, endDate, estimatedDate, expectedDuration, estimatedPrice, projectStatus, projectId, manHoursUsed);
    this.squareMeters = squareMeters;
    this.numberOfKitchens = 1;
    this.numberOfBathrooms = 1;
    this.otherRoomsWithPlumbing = otherRoomsWithPlumbing;
    this.isNewBuild = true;

  }


  /**
   * Getter of the square meters of the residential building.
   *
   * @return The square meters.
   */
  public double getSquareMeters() {
    return squareMeters;
  }

  /**
   * Getter of the number of kitchens in the residential building.
   *
   * @return The number of kitchens.
   */
  public int getNumberOfKitchens() {
    return numberOfKitchens;
  }

  /**
   * Getter of the number of bathrooms in the residential building.
   *
   * @return The number of bathrooms.
   */
  public int getNumberOfBathrooms() {
    return numberOfBathrooms;
  }

  /**
   * Getter of the number of other rooms with plumbing in the residential building.
   *
   * @return The number of other rooms with plumbing.
   */
  public int getOtherRoomsWithPlumbing() {
    return otherRoomsWithPlumbing;
  }

  /**
   * Checks if the residential building is a new build.
   *
   * @return True if it's a new build, false otherwise.
   */
  public boolean getIsNewBuild() {
    return isNewBuild;
  }


  /**
   * Sets the square meters of the residential building.
   *
   * @param squareMeters The square meters to set.
   */
  public void setSquareMeters(double squareMeters) {
    this.squareMeters = squareMeters;
  }

  /**
   * Sets the number of kitchens in the residential building.
   *
   * @param numberOfKitchens The number of kitchens to set.
   */
  public void setNumberOfKitchens(int numberOfKitchens) {
    this.numberOfKitchens = numberOfKitchens;
  }

  /**
   * Sets the number of bathrooms in the residential building.
   *
   * @param numberOfBathrooms The number of bathrooms to set.
   */
  public void setNumberOfBathrooms(int numberOfBathrooms) {
    this.numberOfBathrooms = numberOfBathrooms;
  }

  /**
   * Sets the number of other rooms with plumbing in the residential building.
   *
   * @param otherRoomsWithPlumbing The number of other rooms with plumbing to set.
   */
  public void setOtherRoomsWithPlumbing(int otherRoomsWithPlumbing) {
    this.otherRoomsWithPlumbing = otherRoomsWithPlumbing;
  }

  /**
   * Sets whether the residential building is a new build.
   *
   * @param isNewBuild True if it's a new build, false otherwise.
   */
  public void setNewBuild(boolean isNewBuild) {
    this.isNewBuild = isNewBuild;
  }


  /**
   * A string method representation of the Residential project.
   *
   * @return A string containing details about the Residential project.
   */
  @Override public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append("Square Meters: ").append(squareMeters).append("\n");
    sb.append("Number of Kitchens: ").append(numberOfKitchens).append("\n");
    sb.append("Number of Bathrooms: ").append(numberOfBathrooms).append("\n");
    sb.append("Other Rooms with Plumbing: ").append(otherRoomsWithPlumbing).append("\n");
    sb.append("Is New Build: ").append(isNewBuild).append("\n");
    return sb.toString();
  }

}