/**
 * File: StudentDBTextArea
 * Author: Michelle John
 * Date 17 Dec 2017
 * Purpose: Week 8 Student DB Project
 */
package utils;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

import javax.swing.JTextArea;

/**
 * Class that extends {@link JTextArea} and is customized for this application.
 */
public class StudentDBTextArea extends JTextArea {

  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @param editable if the text area should be editable
   */
  public StudentDBTextArea(boolean editable) {
    super();
    setEditable(editable);
    setBackground(WHITE);
    setForeground(BLACK);
  }
}
