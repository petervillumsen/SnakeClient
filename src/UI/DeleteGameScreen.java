package UI;

/**
 * Created by ejer on 30/11/15.
 */
    import java.awt.Color;
    import java.awt.Font;
    import java.awt.Image;
    import java.awt.event.ActionListener;
    import java.io.IOException;

    import javax.imageio.ImageIO;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.SwingConstants;
    import javax.swing.JTextField;
    import javax.swing.JButton;
    import javax.swing.ImageIcon;

    public class DeleteGameScreen extends JPanel
    {
        //instantiere variabler
        private JLabel lblDelete;
        private JLabel lblDeleteGame;
        private JTextField txtGameID;
        private JButton btnHome;

        /**
         * Create the panel.
         */
        public DeleteGameScreen()
        {
            setLayout(null);
            setBackground(new Color(0, 102, 0));

            //opretter,giver attributter og adder balance label
            lblDelete = new JLabel("Delete Game");
            lblDelete.setForeground(Color.WHITE);
            lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
            lblDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
            lblDelete.setBounds(167, 10, 200, 50);
            add(lblDelete);

            //opretter,giver attributter og adder your balance is label
            lblDeleteGame = new JLabel("Game to delete");
            lblDeleteGame.setForeground(Color.WHITE);
            lblDeleteGame.setBounds(125, 88, 108, 16);
            add(lblDeleteGame);

            //opretter,giver attributter og adder balance textfield
            txtGameID = new JTextField();
            txtGameID.setBounds(245, 82, 134, 28);
            txtGameID.setEditable(false);
            add(txtGameID);
            txtGameID.setColumns(10);

            //opretter,giver attributter og adder home knap
            btnHome = new JButton();
            try
            {
                Image imgHome = ImageIO.read(getClass().getResource("BackBottom.png"));
                btnHome.setIcon(new ImageIcon(imgHome));
            }
            catch (IOException ex)
            {
            }
            btnHome.setBounds(16, 10, 42, 38);
            add(btnHome);
        }//metode slut

        /**
         * Getter for lblBalance
         * @return lblBalance
         */
        public JLabel getLblBalance()
        {
            return lblDelete;
        }//metode slut

        /**
         * Getter forlblYourBalanceIs
         * @return lblYourBalanceIs
         */
        public JLabel getLblYourBalanceIs()
        {
            return lblDeleteGame;
        }//metode slut

        /**
         * Getter for lblYourBalanceIs
         * @return lblYourBalanceIs
         */
        public JTextField getTextField()
        {
            return txtGameID;
        }//metode slut

        /**
         * Getter for
         * @return
         */
        public JButton getBtnHome()
        {
            return btnHome;
        }//metode slut

        /**
         * opretter actionListernes for dette panel
         * @param l
         */
        public void addActionListener(ActionListener l)
        {
            btnHome.addActionListener(l);
        }//metode slut
    }//klasse slut
