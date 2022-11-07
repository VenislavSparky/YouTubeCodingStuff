package A_03_JavaGamesAndApps.TicTacToeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.BatchUpdateException;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();

    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[][] buttons = new JButton[3][3];
    boolean playerOneTurn;

    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(72, 70, 70));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(110, 50, 169));

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c] = new JButton();
                buttonPanel.add(buttons[r][c]);
                buttons[r][c].setFont(new Font("MV Boli", Font.BOLD, 120));
                buttons[r][c].setFocusable(false);
                buttons[r][c].addActionListener(this);
            }

        }

        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (e.getSource() == buttons[r][c]) {
                    if (playerOneTurn) {
                        if (buttons[r][c].getText() == "") {
                            buttons[r][c].setForeground(new Color(255, 0, 0));
                            buttons[r][c].setText("X");
                            playerOneTurn = false;
                            textField.setText("O  turn!");
                            check(buttons, "O");
                        }
                    } else {
                        if (buttons[r][c].getText() == "") {
                            buttons[r][c].setForeground(new Color(0, 0, 255));
                            buttons[r][c].setText("O");
                            playerOneTurn = true;
                            textField.setText("X turn!");
                            check(buttons, "X");
                        }
                    }
                }
            }
        }
    }

    public void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0) {
            playerOneTurn = true;
            textField.setText("X turn!");
        } else {
            playerOneTurn = false;
            textField.setText("O turn!");
        }
    }

    public void check(JButton[][] buttons, String player) {
        if (checkDiagonal(buttons, player) || checkRowCol(buttons, player))
            textField.setText(player + " wins!");
    }

    private static boolean checkDiagonal(JButton[][] buttons, String player) {
        int foundOnMainDiagonal = 0;
        int foundOnSecondaryDiagonal = 0;

        for (int r = 0; r < 3; r++) {
            if (buttons[r][r].getText().equals(player)) {
                foundOnMainDiagonal++;
            }
            if (buttons[r][2 - r].getText().equals(player)) {
                foundOnSecondaryDiagonal++;
            }
            if (foundOnMainDiagonal == 3 || foundOnSecondaryDiagonal == 3) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRowCol(JButton[][] buttons, String player) {
        for (int r = 0; r < 3; r++) {
            int foundOnRow = 0;
            int foundOnCol = 0;

            for (int c = 0; c < 3; c++) {
                if (buttons[r][c].getText().equals(player)) {
                    foundOnRow += 1;
                }
                if (buttons[c][r].getText().equals(player)) {
                    foundOnCol += 1;
                }
                if (foundOnRow == 3 || foundOnCol == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
