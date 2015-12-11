package UI;

/**
 * Created by Peter Villumsen on 30/11/15.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateGameScreen extends JPanel
{
    //Declaring variabler
    private JLabel lblCreateGame;
    private JLabel lblGameName;
    private JButton btnBack;
    private JLabel lblControls;
    private JTextField textFieldGameName;
    private JTextField textFieldControls;
    private JLabel lblInstructions;
    private JButton btnStartGameNow;

    private JLabel lblNoControls;
    private JLabel lblGameWasCreated;

    public CreateGameScreen()
    {
        setLayout(null);
        setBackground(new Color(0, 102, 0));
        setBounds(100, 100, 529, 475);

        lblCreateGame = new JLabel("Create Game");
        lblCreateGame.setForeground(Color.WHITE);
        lblCreateGame.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreateGame.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblCreateGame.setBounds(167, 10, 200, 50);
        add(lblCreateGame);


        lblGameName = new JLabel("Game name: ");
        lblGameName.setForeground(Color.WHITE);
        lblGameName.setBounds(123, 84, 89, 16);
        add(lblGameName);


        btnBack = new JButton();
        btnBack.setIcon(new ImageIcon(CreateGameScreen.class.getResource("/Resources/BackButton.png")));
        btnBack.setBounds(31, 23, 40, 40);
        add(btnBack);

        lblControls = new JLabel("Enter controls:");
        lblControls.setForeground(Color.WHITE);
        lblControls.setBounds(123, 356, 118, 16);
        add(lblControls);

        textFieldGameName = new JTextField();
        textFieldGameName.setBounds(253, 82, 134, 28);
        add(textFieldGameName);
        textFieldGameName.setColumns(10);

        textFieldControls = new JTextField();
        textFieldControls.setBounds(253, 354, 134, 28);
        add(textFieldControls);
        textFieldControls.setColumns(10);

        lblInstructions = new JLabel("");
        lblInstructions.setIcon(new ImageIcon(CreateGameScreen.class.getResource("/Resources/control.png")));
        lblInstructions.setBounds(180, 122, 288, 208);
        add(lblInstructions);

        btnStartGameNow = new JButton("Start game now");
        btnStartGameNow.setBounds(253, 406, 132, 28);
        add(btnStartGameNow);

        lblGameWasCreated = new JLabel("Game was created!");
        lblGameWasCreated.setForeground(new Color(255, 255, 0));
        lblGameWasCreated.setBounds(263, 378, 134, 16);
        lblGameWasCreated.setVisible(false);
        add(lblGameWasCreated);

        lblNoControls = new JLabel("Please enter Controls and Game Name");
        lblNoControls.setForeground(new Color(255, 204, 51));
        lblNoControls.setHorizontalAlignment(SwingConstants.CENTER);
        lblNoControls.setBounds(150, 378, 300, 16);
        lblNoControls.setVisible(false);
        add(lblNoControls);

    }

    /**
     * Getters and Setters for this class
     */
    public JButton getBtnStartGameNow()
    {
        return btnStartGameNow;
    }

    public JButton getBtnBack()
    {
        return btnBack;
    }//metode slut

    public JLabel getLblGameWasCreated() {
        return lblGameWasCreated;
    }

    public JTextField getGameName()
    {

        return textFieldGameName;
    }

    public JTextField getControls()
    {
        return textFieldControls;
    }

    public void addActionListener(ActionListener l)
    {
        btnStartGameNow.addActionListener(l);
        btnBack.addActionListener(l);
    }

    public JLabel getLblNoControls() {
        return lblNoControls;
    }

    public JTextField getTextFieldControls() {
        return textFieldControls;
    }

    public JTextField gettextFieldGameName() {
        return textFieldGameName;
    }
}//klasse slut

