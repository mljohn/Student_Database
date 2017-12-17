/**
 * File: StudentDB
 * Author: Michelle John
 * Date 17 Dec 2017
 * Purpose: Week 8 Student DB Project
 */
package main;

import java.util.HashMap;
import java.util.Map;

import exceptions.StudentDBException;

/**
 * The {@link HashMap} implementation of a student database for this application.
 */
public class StudentDB {
  
  private static final String STUDENT_EXISTS_MESSAGE = "That student ID already exists.";

  private static final String STUDENT_NOT_EXIST_MESSAGE = "That student does not exist in the database";
  
  private static Map<Long, Student> studentDB = new HashMap<>();

  /**
   * Method that adds a {@link Student} to the hashmap.
   * 
   * @param id the id of the student to insert
   * @param student the student information to insert
   * @throws StudentDBException if the action cannot be completed
   */
  public static void insertStudent(long id, Student student) throws StudentDBException {
    if (studentDB.containsKey(id)) {
      throw new StudentDBException(STUDENT_EXISTS_MESSAGE);
    }
    studentDB.put(id, student);
  }
  
  /**
   * Method that deletes a {@link Student} from the hashmap.
   * 
   * @param id the id of the student to remove
   * @throws StudentDBException if the action cannot be completed
   */
  public static void deleteStudent(long id) throws StudentDBException {
    if (!studentDB.containsKey(id)) {
      throw new StudentDBException(STUDENT_NOT_EXIST_MESSAGE);
    }
    studentDB.remove(id);
  }
  
  /**
   * Method that finds a {@link Student} based off the id.
   * 
   * @param id the student id
   * @return the {@link Student}
   * @throws StudentDBException if the action cannot be completed
   */
  public static Student findStudent(long id) throws StudentDBException {
    if (!studentDB.containsKey(id)) {
      throw new StudentDBException(STUDENT_NOT_EXIST_MESSAGE);
    }
    return studentDB.get(id);
  }
  
  /**
   * Method that updates a {@link Student}.
   * 
   * @param id the student's id
   * @return the {@link Student} to update
   * @throws StudentDBException if the action cannot be completed
   */
  public static Student updateStudent(long id) throws StudentDBException {
    if (!studentDB.containsKey(id)) {
      throw new StudentDBException(STUDENT_NOT_EXIST_MESSAGE);
    }
    return studentDB.get(id);
  }
}
