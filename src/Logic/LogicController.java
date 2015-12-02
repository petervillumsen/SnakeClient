package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import UI.Screen;
import sdk.Logic;

public class LogicController
{
    public Screen screen;
    public Logic logic;

    /**
     * kontruktør. laver objekt af database og screen.
     */
    public LogicController()
    {
        logic = new Logic();
        screen = new Screen();
        screen.setVisible(true);
    }//konstruktør slut

    /**
     * metoden Main klassen kalder for at starte programmet
     */
    public void run()
    {
        // injection af listeners i panels
        screen.loginScreen.addActionListener(new LoginActionListener());
        screen.menuScreen.addActionListener(new MenuScreenActionListener());
        screen.createGameScreen.addActionListener(new CreateGameScreenActionListener());
        screen.deleteGameScreen.addActionListener(new DeleteGameScreenActionListener());
        screen.highScoreScreen.addActionListener(new HighScoreScreenActionListener());

        // vis startskaerm
        screen.show(Screen.LOGINSCREEN);
    }


    private class LoginActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //der trykked på login knap
            if (e.getSource() == screen.getLogin().getBtnLogin())
            {
                if(logic.login(screen.getLogin().getTxtUsername(), screen.getLogin().getTxtPassword()))
                screen.show(Screen.MENUSCREEN);
            }
            else
            {
                screen.getLogin().getLblError().setVisible(true);
            }
        }//if listener slut
    }//actionPerformed slut

    private class MenuScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            if(e.getSource() == screen.getMenuScreen().getBtnCreateGame())
            {
                screen.show(Screen.CREATEGAMESCREEN);
            }
            if(e.getSource() == screen.getMenuScreen().getBtnDeleteGame())
            {
                screen.show(Screen.DELETEGAMESCREEN);
            }
            if(e.getSource() == screen.getMenuScreen().getBtnHighScores())
            {
                screen.show(Screen.HIGHSCORESCREEN);
            }
            if(e.getSource() == screen.getMenuScreen().getBtnLogout())
            {
                screen.show(Screen.LOGINSCREEN);
            }
        }
    }

    private class CreateGameScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            if(e.getSource() == screen.getCreateGameScreen().getBtnBack())
            {
                screen.show(Screen.MENUSCREEN);
            }

            if(e.getSource() == screen.getCreateGameScreen().getBtnStartGameNow())
            {
                //SKAL ÆNDRES TIL WHAT EVER START GAME ER!!!
                screen.show(Screen.MENUSCREEN);
            }
        }
    }

    private class DeleteGameScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            if(e.getSource() == screen.getDeleteGameScreen().getBtnBack())
            {
                screen.show(Screen.MENUSCREEN);
            }
            if(e.getSource() == screen.getDeleteGameScreen().getBtnDeleteGame())
            {
                //SKAL ÆNDRES TIL WHAT EVER START GAME ER!!!
                screen.show(Screen.MENUSCREEN);
            }
        }
    }

    private class HighScoreScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            if(e.getSource() == screen.getHighScoreScreen().getBtnBack())
            {
                screen.show(Screen.MENUSCREEN);
            }
        }
    }
}//inner class slit



   








