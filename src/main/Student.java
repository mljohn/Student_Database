/**
 * File: Student
 * Author: Michelle John
 * Date 17 Dec 2017
 * Purpose: Week 8 Student DB Project
 */
package main;

import static java.util.Objects.requireNonNull;
import static utils.StudentDBConstants.A_GRADE;
import static utils.StudentDBConstants.B_GRADE;
import static utils.StudentDBConstants.C_GRADE;
import static utils.StudentDBConstants.D_GRADE;
import static utils.StudentDBConstants.F_GRADE;

import exceptions.InvalidGradeException;

/**
 * Class to hold student information.
 */
public class Student {

  private String studentName;
  private String studentMajor;
  private int studentCreditHours;
  private double studentQualityPoints;

  /**
   * Constructor. 
   * 
   * @param studentName the student's name
   * @param studentMajor the student's major
   */
  public Student(String studentName, String studentMajor) {
    requireNonNull(studentName, "studentName can't be null");
    requireNonNull(studentMajor, "studentMajor can't be null");
    this.studentName = studentName;
    this.studentMajor = studentMajor;
    this.studentCreditHours = 0;
    this.studentQualityPoints = 0;
  }

  /**
   * Method that gets the grade and credit hours of the completed course and updates the credit hours and quality
   * points of the student.
   *  
   * @param grade the final grade of the student
   * @param creditHours the credit hours of the course
   * @throws InvalidGradeException if the grade given is invalid
   */
  public void courseCompleted(String grade, int creditHours) throws InvalidGradeException {
    double gradeAsNumber;
    studentCreditHours += creditHours;
    switch (grade) {
      case A_GRADE:
        gradeAsNumber = 4.0;
        break;
      case B_GRADE:
        gradeAsNumber = 3.0;
        break;
      case C_GRADE:
        gradeAsNumber = 2.0;
        break;
      case D_GRADE:
        gradeAsNumber = 1.0;
        break;
      case F_GRADE:
        gradeAsNumber = 0.0;
        break;
      default:
        // This should never happen.
        throw new InvalidGradeException("That is not a valid grade");
    }
    studentQualityPoints = gradeAsNumber * creditHours + studentQualityPoints;
  }

  /**
   * @return the student's name
   */
  public String getStudentName() {
    return studentName;
  }

  /**
   * @param studentName the student's name to set
   */
  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  /**
   * @return the student's major
   */
  public String getStudentMajor() {
    return studentMajor;
  }

  /**
   * @param studentMajor the major to set
   */
  public void setStudentMajor(String studentMajor) {
    this.studentMajor = studentMajor;
  }

  /**
   * @return the total credit hours completed by the student
   */
  public int getStudentCredits() {
    return studentCreditHours;
  }

  /**
   * @param studentCredits the total number of credits to set
   */
  public void setStudentCredits(int studentCredits) {
    this.studentCreditHours = studentCredits;
  }

  /**
   * @return the total quality points of the student
   */
  public double getStudentQualityPoints() {
    return studentQualityPoints;
  }

  /**
   * @param studentQualityPoints the total quality points to set
   */
  public void setStudentQualityPoints(double studentQualityPoints) {
    this.studentQualityPoints = studentQualityPoints;
  }
  
  /**
   * Method that uses the current completed credit hours and quality points to calculate the student's GPA.
   * 
   * @return the calculated GPA
   */
  public double calculateGpa() {
    return studentCreditHours == 0 ? 4.0 : studentQualityPoints / studentCreditHours;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Student name: ");
    sb.append(studentName)
    .append("\nMajor: ")
    .append(studentMajor)
    .append("\nGPA: ")
    .append(studentCreditHours == 0 ? 4.0 : calculateGpa());
    return sb.toString();
  }
}
