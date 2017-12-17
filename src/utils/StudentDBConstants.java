/**
 * File: StudentDBConstants
 * Author: Michelle John
 * Date 17 Dec 2017
 * Purpose: Week 8 Student DB Project
 */
package utils;

/**
 * Class to hold constant values used in this application.
 */
public class StudentDBConstants {
  
  public static final String A_GRADE = "A";
  public static final String B_GRADE = "B";
  public static final String C_GRADE = "C";
  public static final String D_GRADE = "D";
  public static final String F_GRADE = "F";
  
  public static final String INSERT = "Insert";
  public static final String DELETE = "Delete";
  public static final String FIND = "Find";
  public static final String UPDATE = "Update";
  
  public static final int THREE_CREDITS = 3;
  public static final int SIX_CREDITS = 6;
  
  /**
   * Default constructor to prevent instantiation.
   */
  private StudentDBConstants() {}
  
  /**
   * Method to return a {@link String} array of valid grades.
   * 
   * @return an array of valid grades
   */
  public static String[] getGrades() {
    return new String[]{A_GRADE, B_GRADE, C_GRADE, D_GRADE, F_GRADE};
  }
  
  /**
   * Method to return a {@link String} array of valid database actions.
   * 
   * @return an array of valid database actions
   */
  public static String[] getSelections() {
    return new String[]{INSERT, DELETE, FIND, UPDATE};
  }
  
  /**
   * Method to return a {@link Integer} array of valid credit values.
   * 
   * @return an array of valid credit values
   */
  public static Integer[] getCredits() {
    return new Integer[]{THREE_CREDITS, SIX_CREDITS};
  }
}
