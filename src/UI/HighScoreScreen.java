package UI;

/**
 * Created by Peter Villumsen on 30/11/15.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HighScoreScreen extends JPanel
{
    //Declaring variables
    private JButton btnBack;
    private JLabel lblHighScore;
    private JTable table;

    public HighScoreScreen()
    {
        setLayout(null);
        setBackground(new Color(0, 102, 0));
        setBounds(100, 100, 529, 475);

        lblHighScore = new JLabel("High Score");
        lblHighScore.setForeground(Color.WHITE);
        lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblHighScore.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblHighScore.setBounds(167, 10, 200, 50);
        add(lblHighScore);

        btnBack = new JButton();
        btnBack.setIcon(new ImageIcon(HighScoreScreen.class.getResource("/Resources/BackButton.png")));
        btnBack.setBounds(16, 10, 42, 38);
        add(btnBack);

        table = new JTable();
        table.setBounds(83, 106, 365, 323);
        add(table);
    }

    public JTable getTable() {
        return table;
    }

    public JButton getBtnBack()
    {
        return btnBack;
    }

    public void addActionListener(ActionListener l)
    {
        btnBack.addActionListener(l);
    }
}
