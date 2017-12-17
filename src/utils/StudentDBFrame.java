/**
 * File: StudentDBMainFrame
 * Author: Michelle John
 * Date 17 Dec 2017
 * Purpose: Week 8 Student DB Project
 */
package utils;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Class that extends {@link JFrame} and is customized for this application.
 */
public class StudentDBFrame extends JFrame {

  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @param title the title of the frame
   * @param width the width of the frame
   * @param height the height of the frame
   */
  public StudentDBFrame(String title, int width, int height) {
    super(title);
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout(5, 5));
  }
  
  /**
   * Shows the GUI.
   */
  public void display() {
    setVisible(true);
  }
}
