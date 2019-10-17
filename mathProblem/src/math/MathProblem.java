/*
Author: Kishan Patel
E-mail: kpp5282@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 4
Due date: 4/4/2019
File: MathProblem.java
Purpose: Java GUI application that helps an elementary school
student learn addition, subtraction, and multiplication
Compiler/IDE: IntelliJ IDEA
Operating
system: Macbook Pro
Reference(s): Java 8 API - Oracle Documentation
(http://docs.oracle.com/javase/8/docs/api/);
(Include ALL additional references (Web page, etc.) here.)
https://stackoverflow.com/questions/18037576/how-do-i-check-if-the-user-is-pressing-a-key
*/
package math;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class MathProblem {

    private JFrame frmMathHelper;
    private JTextField Answer;
    JLabel lblQuestion;
    JLabel lblRightOrWrong;
    int ans, num1, num2, tries;
    String ques;

    /** This launches the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MathProblem window = new MathProblem();
                    window.frmMathHelper.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /** This creates the application.
     */
    public MathProblem() {
        initialize();
        run(1, 3);

    }
    /** This method allows you to input answer.
     */
    private void run(int low, int high) {
        lblRightOrWrong.setText("Please enter your answer.");
        ques = (generateProblem(low, high));
        lblQuestion.setText(ques);
        tries = 1;

    }
    /** This method generates the problem.
     */
    public String generateProblem(int low, int high) {
        String str = "How much is ";
        num1 = (int) (Math.random() * high) + low;
        ans = num1;
        str += num1;
        int ops = (int) (Math.random() * 3) + 1;
        str += operator(ops);
        num2 = (int) (Math.random() * high) + low;
        str += num2 + "?";
        return str;
    }
    /** This method checks the answer put in.
     */
    private void checkAnswer(String userAnswer) {
        String input = userAnswer;
        try {
            int num = Integer.parseInt(input);
            if (getAnswer() == num) {
                lblRightOrWrong.setText("Very good! it only took you " + tries + " try.");
                tries = 1;
            } else if (getAnswer() != num) {
                lblRightOrWrong.setText("I'm sorry, but no. Please try again.");
                tries++;
            }
        } catch (Exception e) {
            lblRightOrWrong.setText("I'm sorry, but no. Please try again.");
            tries++;
        }
    }
    /** This method gets the correct answer
     */
    private int getAnswer() {
        int sol = 0 ;
        if (ques.contains("plus")) {
            sol = num1 + num2;
        }
        if (ques.contains("minus")) {
            sol = num1 - num2;
        }
        if (ques.contains("times")) {
            sol = num1 * num2;
        }
        return sol;
    }
    /** This method makes sure its the right operation
     */
    private String operator(int op) {
        String str = " ";
        if (op == 1) {
            str += "plus ";
        } else if (op == 2) {
            str += "minus ";
        } else if (op == 3) {
            str += "times ";
        }
        return str;
    }

    /** This method initialize the contents of the frame.
     */
    private void initialize() {
        frmMathHelper = new JFrame();
        frmMathHelper.setTitle("Math Helper");
        frmMathHelper.getContentPane().setBackground(Color.CYAN);
        frmMathHelper.getContentPane().setForeground(Color.CYAN);
        frmMathHelper.setBounds(100, 100, 450, 175);
        frmMathHelper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMathHelper.getContentPane().setLayout(null);

        lblQuestion = new JLabel("Question");
        lblQuestion.setFont(new Font("Chalkduster", Font.BOLD, 13));
        lblQuestion.setBounds(135, 16, 315, 16);
        frmMathHelper.getContentPane().add(lblQuestion);

        lblRightOrWrong = new JLabel("Please enter your answer.");
        lblRightOrWrong.setFont(new Font("Chalkduster", Font.BOLD, 11));
        lblRightOrWrong.setBounds(10, 60, 315, 26);
        frmMathHelper.getContentPane().add(lblRightOrWrong);

        Answer = new JTextField();
        Answer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    checkAnswer(Answer.getText());
                }
            }
        });
        Answer.setBounds(250, 60, 130, 26);
        frmMathHelper.getContentPane().add(Answer);
        Answer.setColumns(10);

        JButton btnNewProblem = new JButton("New Problem");
        btnNewProblem.setFont(new Font("Chalkduster", Font.BOLD, 10));
        btnNewProblem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                run(1, 10);
            }
        });
        btnNewProblem.setBounds(167, 120, 117, 29);
        frmMathHelper.getContentPane().add(btnNewProblem);
    }
}
