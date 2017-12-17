/**
 * File: StudentDBException
 * Author: Michelle John
 * Date 17 Dec 2017
 * Purpose: Week 8 Student DB Project
 */
package exceptions;

/**
 * Custom {@link Exception} that is thrown if a database action cannot be completed.
 */
public class StudentDBException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   */
  public StudentDBException() {
    super();
  }
  
  /**
   * Constructor.
   * 
   * @param message the message to show.
   */
  public StudentDBException(String message) {
    super(message);
  }
}
