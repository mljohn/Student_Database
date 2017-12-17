/**
 * File: StudentDBGui
 * Author: Michelle John
 * Date 17 Dec 2017
 * Purpose: Week 8 Student DB Project
 */
package main;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static main.StudentDB.deleteStudent;
import static main.StudentDB.findStudent;
import static main.StudentDB.insertStudent;
import static main.StudentDB.updateStudent;
import static utils.StudentDBConstants.DELETE;
import static utils.StudentDBConstants.FIND;
import static utils.StudentDBConstants.INSERT;
import static utils.StudentDBConstants.UPDATE;
import static utils.StudentDBConstants.getCredits;
import static utils.StudentDBConstants.getGrades;
import static utils.StudentDBConstants.getSelections;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import exceptions.InvalidGradeException;
import exceptions.StudentDBException;
import utils.StudentDBFrame;
import utils.StudentDBTextArea;

/**
 * Main class. Starts the Student DB GUI.
 */
public class StudentDBGui {

  private static final String STUDENT_DB_EXCEPTION = "Student DB Exception";
  private static final String STUDENT_ID_CANNOT_BE_PARSED = "Student ID Cannot Be Parsed";

  public static void main(String[] args) {

    StudentDBGui studentDBGui = new StudentDBGui();
    studentDBGui.buildStudentDBGui();
  }

  /**
   * Builds and then displays the GUI.
   */
  private void buildStudentDBGui() {
    StudentDBFrame studentDBframe = new StudentDBFrame("Student Database", 325, 175);

    JPanel entryPanel = new JPanel(new GridLayout(5, 2, 5, 5));

    JPanel idPanel = new JPanel(new GridLayout(1, 2, 5, 5));
    JPanel namePanel = new JPanel(new GridLayout(1, 2, 5, 5));
    JPanel majorPanel = new JPanel(new GridLayout(1, 2, 5, 5));
    JPanel choosePanel = new JPanel(new GridLayout(1, 2, 5, 5));
    JPanel processPanel = new JPanel(new GridLayout(1, 2, 5, 5));

    JLabel idLabel = new JLabel("Student ID:");
    JLabel nameLabel = new JLabel("Name:");
    JLabel majorLabel = new JLabel("Major:");
    JLabel chooseLabel = new JLabel("Choose Selection:");

    JButton processButton = new JButton("Process Request");

    StudentDBTextArea idTextArea = new StudentDBTextArea(true);
    StudentDBTextArea nameTextArea = new StudentDBTextArea(true);
    StudentDBTextArea majorTextArea = new StudentDBTextArea(true);

    JComboBox<String> selectionBox = new JComboBox<>(getSelections());

    processButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        switch (selectionBox.getSelectedItem().toString()) {
          case INSERT:
            String idText = idTextArea.getText();
            String nameText = nameTextArea.getText();
            String majorText = majorTextArea.getText();
            if (idText.isEmpty() || idText == null 
                || nameText.isEmpty() || nameText == null 
                || majorText.isEmpty() || majorText == null) {
              showMessageDialog(studentDBframe, "Please enter all information.");
            } else {
              insertThisStudent(idText, nameText, majorText, studentDBframe);
            }
            break;
          case DELETE:
            idText = idTextArea.getText();
            if (idText.isEmpty() || idText == null) {
              showMessageDialog(studentDBframe, "Please enter the student id.");
            } else {
              deleteThisStudent(idText, studentDBframe); 
            }
            break;
          case FIND:
            idText = idTextArea.getText();
            if (idText.isEmpty() || idText == null) {
              showMessageDialog(studentDBframe, "Please enter the student id.");
            } else {
              findThisStudent(idText, studentDBframe);
            }
            break;
          case UPDATE:
            idText = idTextArea.getText();
            if (idText.isEmpty() || idText == null) {
              showMessageDialog(studentDBframe, "Please enter the student id.");
            } else {
              updateThisStudent(idText, studentDBframe);
            }
            break;
          default:
            // This should never happen
            showMessageDialog(studentDBframe, "Not a valid choice", "No Such Option", ERROR_MESSAGE);
        }
        idTextArea.setText(null);
        nameTextArea.setText(null);
        majorTextArea.setText(null);
      }

    });

    idPanel.add(idLabel);
    idPanel.add(idTextArea);
    namePanel.add(nameLabel);
    namePanel.add(nameTextArea);
    majorPanel.add(majorLabel);
    majorPanel.add(majorTextArea);
    choosePanel.add(chooseLabel);
    choosePanel.add(selectionBox);
    processPanel.add(processButton);
    processPanel.add(new JPanel());

    entryPanel.add(idPanel);
    entryPanel.add(namePanel);
    entryPanel.add(majorPanel);
    entryPanel.add(choosePanel);
    entryPanel.add(processPanel);

    studentDBframe.add(entryPanel, CENTER);
    studentDBframe.add(new JPanel(), SOUTH);
    studentDBframe.add(new JPanel(), EAST);
    studentDBframe.add(new JPanel(), WEST);
    studentDBframe.display();
  }

  /**
   * Inserts the entered data into the student database.
   * 
   * @param id the ID to insert
   * @param name the student's name to insert
   * @param major the student's major to insert
   * @param frame the frame to be the parent component for the {@link JOptionPane}
   */
  private void insertThisStudent(String id, String name, String major, StudentDBFrame frame) {
    long studentId;
    try {
      studentId = Long.parseLong(id);
      insertStudent(studentId, new Student(name, major));
      showMessageDialog(frame, "Student added.");
    } catch (NumberFormatException exception) {
      showMessageDialog(frame, exception.getMessage(), STUDENT_ID_CANNOT_BE_PARSED, ERROR_MESSAGE);
    } catch (StudentDBException exception) {
      showMessageDialog(frame, exception.getMessage(), STUDENT_DB_EXCEPTION, ERROR_MESSAGE);
    }
  }

  /**
   * Deletes the student if that student is in the database.
   * 
   * @param id the id of the student to delete from the database
   * @param frame the frame to be the parent component for the {@link JOptionPane}
   */
  private void deleteThisStudent(String id, StudentDBFrame frame) {
    long studentId;
    try {
      studentId = Long.parseLong(id);
      deleteStudent(studentId);
      showMessageDialog(frame, "Student deleted.");
    } catch (NumberFormatException exception) {
      showMessageDialog(frame, exception.getMessage(), STUDENT_ID_CANNOT_BE_PARSED, ERROR_MESSAGE);
    } catch (StudentDBException exception) {
      showMessageDialog(frame, exception.getMessage(), STUDENT_DB_EXCEPTION, ERROR_MESSAGE);
    }
  }

  /**
   * Finds the student in the database and displays that student's information.
   * 
   * @param id the id of the student to find
   * @param frame the frame to be the parent component for the {@link JOptionPane}
   */
  private void findThisStudent(String id, StudentDBFrame frame) {
    long studentId;
    try {
      studentId = Long.parseLong(id);
      Student foundStudent = findStudent(studentId);
      showMessageDialog(frame, foundStudent.toString());
    } catch (NumberFormatException exception) {
      showMessageDialog(frame, exception.getMessage(), STUDENT_ID_CANNOT_BE_PARSED, ERROR_MESSAGE);
    } catch (StudentDBException exception) {
      showMessageDialog(frame, exception.getMessage(), STUDENT_DB_EXCEPTION, ERROR_MESSAGE);
    }
  }

  /**
   * Updates the student if that student exists in the database.
   * 
   * @param id the id of the student to update
   * @param frame the frame to be the parent component for the {@link JOptionPane}
   */
  private void updateThisStudent(String id, StudentDBFrame frame) {
    long studentId;
    JLabel gradesLabel = new JLabel("Choose Grade:");
    JLabel creditsLabel = new JLabel("Choose Credits:");
    try {
      studentId = Long.parseLong(id);
      Student studentToUpdate = updateStudent(studentId);
      String grade = (String) (showInputDialog(frame, gradesLabel, "Choose Grade", QUESTION_MESSAGE, null, getGrades(),
          null));
      int credits = (int) showInputDialog(frame, creditsLabel, "Choose Credits", QUESTION_MESSAGE, null, getCredits(),
          null);
      studentToUpdate.courseCompleted(grade, credits);
      showMessageDialog(frame, "Student Updated.");
    } catch (NumberFormatException exception) {
      showMessageDialog(frame, exception.getMessage(), STUDENT_ID_CANNOT_BE_PARSED, ERROR_MESSAGE);
    } catch (StudentDBException exception) {
      showMessageDialog(frame, exception.getMessage(), STUDENT_DB_EXCEPTION, ERROR_MESSAGE);
    } catch (InvalidGradeException exception) {
      showMessageDialog(frame, exception.getMessage(), "Invalid Grade Exception", ERROR_MESSAGE);
    }
  }
}
