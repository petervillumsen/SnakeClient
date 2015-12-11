package UI;

/**
 * Created by Peter Villumsen on 30/11/15.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class DeleteGameScreen extends JPanel
{
    //Declaring variables
    private JLabel lblDelete;
    private JLabel lblDeleteGame;
    private JTextField textFieldGameID;
    private JButton btnBack;
    private JButton btnDeleteGame;
    private JLabel lblGameDeleted;
    private JLabel lblWrongInput;
    private String gameID;

    /**
     * Create the panel.
     */
    public DeleteGameScreen()
    {
        setLayout(null);
        setBackground(new Color(0, 102, 0));
        setBounds(100, 100, 529, 475);

        lblDelete = new JLabel("Delete Game");
        lblDelete.setForeground(Color.WHITE);
        lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
        lblDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblDelete.setBounds(167, 10, 200, 50);
        add(lblDelete);

        lblDeleteGame = new JLabel("Game to delete");
        lblDeleteGame.setForeground(Color.WHITE);
        lblDeleteGame.setBounds(125, 88, 108, 16);
        add(lblDeleteGame);

        textFieldGameID = new JTextField();
        textFieldGameID.setBounds(245, 82, 134, 28);
        add(textFieldGameID);
        textFieldGameID.setColumns(10);

        btnBack = new JButton();
        btnBack.setIcon(new ImageIcon(DeleteGameScreen.class.getResource("/Resources/BackButton.png")));
        btnBack.setBounds(16, 10, 42, 38);
        add(btnBack);

        btnDeleteGame = new JButton("Delete Now");
        btnDeleteGame.setBounds(245, 150, 134, 38);
        add(btnDeleteGame);

        lblGameDeleted = new JLabel("Game Deleted");
        lblGameDeleted.setForeground(new Color(255, 204, 51));
        lblGameDeleted.setHorizontalAlignment(SwingConstants.CENTER);
        lblGameDeleted.setBounds(116, 336, 309, 16);
        lblGameDeleted.setVisible(false);
        add(lblGameDeleted);

        lblWrongInput = new JLabel("Wrong input");
        lblWrongInput.setForeground(new Color(255, 204, 51));
        lblWrongInput.setHorizontalAlignment(SwingConstants.CENTER);
        lblWrongInput.setBounds(116, 336, 309, 16);
        lblWrongInput.setVisible(false);
        add(lblWrongInput);

    }
    public JLabel getLblWrongInput() {
        return lblWrongInput;
    }

    public JLabel getLblGameDeleted() {
        return lblGameDeleted;
    }

    public JTextField getTextFieldGameID() {
        gameID = textFieldGameID.getText();
        return textFieldGameID;
    }
    public JButton getBtnBack()
    {
        return btnBack;
    }//metode slut

    public JButton getBtnDeleteGame()
    {
        return btnDeleteGame;
    }

    public void addActionListener(ActionListener l)
    {
        btnBack.addActionListener(l);
        btnDeleteGame.addActionListener(l);
    }
}

