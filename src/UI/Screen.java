package UI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Created by ejer on 30/11/15.
 */
public class Screen extends JFrame {



        //Tilegener ID
        public static final String LOGIN = "name_1";
        public static final String USERMENU = "name_2";



        //instantiere variabler
        public LoginScreen login;
        public  MenuScreen userMenu;




        private CardLayout c;

        private JPanel contentPane;

        /**
         * create the frame
         */
        public Screen()
        {
            //setter atributter
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 529, 475);
            contentPane = new JPanel();
            contentPane.setBackground(new Color(62, 77, 86));
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);

            //layout sættes til cardlayout
            contentPane.setLayout(new CardLayout(0, 0));

            //adder alle panels til dette contentpane

            login = new LoginScreen();
            contentPane.add(login, LOGIN);

            userMenu = new MenuScreen();
            contentPane.add(userMenu,USERMENU);





            c = (CardLayout) getContentPane().getLayout();

        }//metode slut

        /**
         * Getter for login
         * @return login
         */
        public LoginScreen getLogin()
        {
            return login;
        }//metode slut

        /**
         * Getter for userMenu
         * @return userMenu
         */
        public MenuScreen getUserMenu()
        {
            return userMenu;
        }//metode slut

        /**
         * denne metode sender de forskellige cards til framet.
         * @param card
         */
        public void show(String card)
        {
            c.show(this.getContentPane(), card);
        }//metode slut

        /**
         * Getter for umViewBalance
         * @return umViewBalance
         */


    }//klasse slut

