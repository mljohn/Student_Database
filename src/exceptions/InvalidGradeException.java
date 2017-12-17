/**
 * File: InvalidGradeException
 * Author: Michelle John
 * Date 17 Dec 2017
 * Purpose: Week 8 Student DB Project
 */
package exceptions;

/**
 * Custom {@link Exception} that is thrown if a given grade is invalid. This exception should never happen.
 */
public class InvalidGradeException extends Exception {

  private static final long serialVersionUID = 1L;
 
  /**
   * Constructor.
   */
  public InvalidGradeException() {
    super();
  }

  /**
   * Constructor.
   * 
   * @param message the message to show
   */
  public InvalidGradeException(String message) {
    super(message);
  }
}
