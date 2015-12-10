package Logic;

import UI.Screen;
import sdk.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The class is the connection from the frontend to the backend.
 */

public class LogicController
{
    public Screen screen;
    public Logic logic;

    /**
     * Creating constructor, making object of screen.
     */
    public LogicController()
    {
        screen = new Screen();
        screen.setVisible(true);
        logic = new Logic();
    }//Contructor ended

    /**
     * Main class calls run to start the program.
     */
    public void run()
    {
        // injection of listeners to panels
        screen.loginScreen.addActionListener(new LoginActionListener());
        screen.menuScreen.addActionListener(new MenuScreenActionListener());
        screen.createGameScreen.addActionListener(new CreateGameScreenActionListener());
        screen.joinGameScreen.addActionListener(new JoinGameScreenActionListener());
        screen.deleteGameScreen.addActionListener(new DeleteGameScreenActionListener());
        screen.highScoreScreen.addActionListener(new HighScoreScreenActionListener());

        // Show login screen
        screen.show(Screen.LOGINSCREEN);
    }

    /**
     * Inner class LoginActionListener is used to login.
     */
    private class LoginActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Login button i pressed
            String password = screen.getLogin().getTxtPassword().getText();
            String username = screen.getLogin().getTxtUsername().getText();

            if (e.getSource() == screen.getLogin().getBtnLogin())
            {
                screen.getLogin().getLblError().setVisible(false);
                if(logic.login(username, password)) {
                    screen.show(Screen.MENUSCREEN);

                }else{
                    screen.getLogin().getLblError().setVisible(true);
                }
            }//if listener ended
        }//actionPerformed ended
    }//end of Inner class

    /**
     * MenuScreen panel Actionlisteners
     * Controls menu screen
     */
    private class MenuScreenActionListener implements ActionListener
    {
        /**
         * Method which listenes to all buttons on the menu screen, and when pushed sends the user to
         * the screen using screen.show()
         * All if statement are the same except logout which clears password and username in login screen.
         * @param e is an object of ActionEvent e
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //If statement for all buttons on menu screen

            if(e.getSource() == screen.getMenuScreen().getBtnCreateGame())
            {
                screen.show(Screen.CREATEGAMESCREEN);
            }
            if(e.getSource() == screen.getMenuScreen().getBtnJoinGame())
            {
                System.out.print("Når der klikkes fra menu " + logic.getCurrentUser().getId());
                screen.show(Screen.JOINGAMESCREEN);
            }
            if(e.getSource() == screen.getMenuScreen().getBtnDeleteGame())
            {
                screen.show(Screen.DELETEGAMESCREEN);
            }
            if(e.getSource() == screen.getMenuScreen().getBtnHighScores())
            {
                screen.show(Screen.HIGHSCORESCREEN);
                ArrayList<Score> highScores = logic.getHighScore();
                HighScoreTableModel highScoreTableModel = new HighScoreTableModel(highScores);
                screen.getHighScoreScreen().getTable().setModel(highScoreTableModel);

            }
            if(e.getSource() == screen.getMenuScreen().getBtnLogout())
            {
                screen.show(Screen.LOGINSCREEN);
                screen.getLogin().getTxtPassword().setText("");
                screen.getLogin().getTxtUsername().setText("");
            }
        }
    }

    /**
     * Inner class CreateGameScreenActionListener creats game.
     */
    private class CreateGameScreenActionListener implements ActionListener
    {
        /**
         * Method listens to buttons in Create Game Screen.
         * If the user press button back, user is returned to Menu Screen.
         * @param e is an object of ActionEvent e
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {

            String gameName = screen.createGameScreen.getGameName().getText();
            String moves = screen.createGameScreen.getControls().getText();

            if(e.getSource() == screen.getCreateGameScreen().getBtnBack())
            {
                screen.getCreateGameScreen().getControls().setText("");
                screen.getCreateGameScreen().getGameName().setText("");
                screen.show(Screen.MENUSCREEN);
            }

            if(e.getSource() == screen.getCreateGameScreen().getBtnStartGameNow())
            {
                if(logic.createGame(gameName, moves)) {


                }else {


                }

            }
        }
    }

    /**
     * Inner class JoinGameScreenActionlistener is used to join game.
     */
    private class JoinGameScreenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            /**
             * Method which listens to all buttons in the JoinGameScreen. If Back Button is pressed the user
             * is returned to MenuScreen and all fields and labels are reset. When the join game button is
             * pressed with correct information a label will appear to ensure the user that the game has been joined.
             * The controls entered by the user are set to the opponent controls and put on the game object which
             * is send to the server.
             * @param e is an object of ActionEvent
             */

            if(e.getSource() == screen.getJoinGameScreen().getBtnBack())
            {
                screen.getJoinGameScreen().getTextGameId().setText("");
                screen.getJoinGameScreen().getLblError().setVisible(false);
                screen.getJoinGameScreen().getLblNoControls().setVisible(false);
                screen.getJoinGameScreen().getLblGameJoined().setVisible(false);
                screen.show(Screen.MENUSCREEN);
            }

            //If the join game button is pressed
            if (e.getSource() == screen.getJoinGameScreen().getBtnJoin())
            {
                //If statement to check if there is an empty text field
                if(screen.getJoinGameScreen().getTextGameId().getText().equals("")
                        ||screen.getJoinGameScreen().getTextFieldEnterControls().getText().equals(""))

                {
                    //If there is an empty field an error label will show
                    screen.getJoinGameScreen().getLblNoControls().setVisible(true);
                    screen.getJoinGameScreen().getLblError().setVisible(false);
                    screen.getJoinGameScreen().getLblGameJoined().setVisible(false);
                }
                else
                {
                    //Saves the moves of the user
                    String moves = screen.getJoinGameScreen().getTextFieldEnterControls().getText();

                    //Creates a gamer opponent with id and controls of the currentUser
                    System.out.print(logic.getCurrentUser().getId());
                    Gamer opponent = new Gamer();
                    opponent.setId(logic.getCurrentUser().getId());
                    opponent.setControls(moves);

                    //Creates an object of game and sets the opponent and his controls.
                    Game game = new Game();
                    game.setOpponent(opponent);

                    //Searches for a game by the game name typed by the user
                    for (Game g : logic.openGames())
                    {
                        //For loop for finding an open game with the name that the user has entered
                        if (g.getName().equals(screen.getJoinGameScreen().getTextGameId().getText()))
                        {
                            game.setGameId(g.getGameId());
                        }
                    }
                    int response = logic.joinGame(game);
                    //If statement to check the response code from the server
                    if (response == 201)
                    {
                        //Starts the game
                        logic.startGame(game);
                        //If the game has been joined a confirm label will show
                        screen.getJoinGameScreen().getLblError().setVisible(false);
                        screen.getJoinGameScreen().getLblGameJoined().setVisible(true);
                        screen.getJoinGameScreen().getLblNoControls().setVisible(false);
                    } else if (response == 400)
                    {
                        //If the game was not joined an error label will show
                        screen.getJoinGameScreen().getLblError().setVisible(true);
                        screen.getJoinGameScreen().getLblGameJoined().setVisible(false);
                        screen.getJoinGameScreen().getLblNoControls().setVisible(false);
                    }
                }
            }
        }
    }
    /**
     * Inner class DeleteGameScreenActionlistener is used to Delete game.
     */
    private class DeleteGameScreenActionListener implements ActionListener
    {
        /**
         * Method that listenes to buttons i DeleteGameScreen. If Back Button is pressed the user is sent back
         * to MenuScreen, and labels and TextFields reset. If user enters a existing gameId a label to confirm will
         * appear.
         * This happens by a delete request sent to the server that if correct returns a response code 200,
         * if incorrect gameId the server will respond code 400 and a error label is shown.
         * Because the gameId is an int a try catch is made to ensure that the program do not crash if the user do
         * not enter an int.
         * @param e is an object of ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //If the user press Back Button
            if(e.getSource() == screen.getDeleteGameScreen().getBtnBack())
            {
                //Back to MenuScreen and reset all fields and labels
                screen.show(Screen.MENUSCREEN);
                screen.getDeleteGameScreen().getLblGameDeleted().setVisible(false);
                screen.getDeleteGameScreen().getLblWrongInput().setVisible(false);
                screen.getDeleteGameScreen().getTextFieldGameID().setText("");
            }

            try {
                //If the user press DeleteGame button.
                if (e.getSource() == screen.getDeleteGameScreen().getBtnDeleteGame()) {
                    //Gets text in GameId text field and parse it to an int, so it can be used to delete a game.
                    int gameId = Integer.parseInt(screen.getDeleteGameScreen().getTextFieldGameID().getText());
                    //Delete request send to the server
                    int response = logic.deleteGame(gameId);
                    //If response from server
                    if (response == 200) {
                        //Confirm label if game is deleted.
                        screen.getDeleteGameScreen().getLblGameDeleted().setVisible(true);
                        screen.getDeleteGameScreen().getLblWrongInput().setVisible(false);
                    }
                    //If response fromserver is 400
                    else if (response == 400) {
                        //Error label i shown if game was not deleted
                        screen.getDeleteGameScreen().getLblGameDeleted().setVisible(false);
                        screen.getDeleteGameScreen().getLblWrongInput().setVisible(true);
                    }
                }
            }
            //Catch if user entered wrong input
            catch (Exception error)
            {
                //If the user did not type in an int.
                screen.getDeleteGameScreen().getLblGameDeleted().setVisible(false);
                screen.getDeleteGameScreen().getLblWrongInput().setVisible(true);
            }
        }
    }
    /**
     * Inner class HighScoreScreenActionlistener is used to Show high scores.
     */
    private class HighScoreScreenActionListener implements ActionListener
    {
        /**
         * Method which listens to the Back button, if this button is pressed the user is sent back to the menu
         * @param e is an object of ActionListener
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // If the user presses Back button
            if (e.getSource() == screen.getHighScoreScreen().getBtnBack())
            {
                //The user is sent to MenuScreen
                screen.show(Screen.MENUSCREEN);
            }
        }
    }

    /**
     * Inner class HighScoreTableModel is used to show top high scores from the sever.
     * Class is used to get the variables in the JTable that are needed to show high score.
     * In this class it is also set which attributes that are to be shown in the JTable.
     * Username and Score are shown.
     * Extends AbstractTableModel.
     */
    public class HighScoreTableModel extends AbstractTableModel
    {
        //Initializing variables used
        private static final long serialVersionUID = 1l;
        private ArrayList<Score> highScores;
        private String[] columns = {"Username", "Score"};
        private int numberOfRows;

        /**
         * Setter for highScores, sets high scores to the Array high scores.
         * @param highScores is an ArrayList of Score.
         */
    public HighScoreTableModel(ArrayList<Score> highScores)
    {
        this.highScores = highScores;
        fireTableStructureChanged();
    }
        /**
         * Getter for columns.length, the method returns the number of columns
         * @return columns.length
         */
        @Override
        public int getColumnCount()
        {
            return columns.length;
        }

        /**
         * Method that returns the columnIndex
         * @param columnIndex returns the ColumnIndex
         * @return super.getColumnClass(columnIndex);
         */
        @Override
        public Class <?> getColumnClass(int columnIndex)
        {
            return super.getColumnClass(columnIndex);
        }

        /**
         * getter for numberOfRows, this method returns the number of rows
         * @return numberOfRows
         */
        @Override
        public  int getRowCount()
        {
            numberOfRows = highScores.size();
            return numberOfRows;
        }

        /**
         * Method that returns the number of columns.
         * @param columnIndex Number of columns
         * @return columns[columnIndex]
         */
        public String getColumnName(int columnIndex)
        {
            return columns[columnIndex];
        }

        /**
         * Method to get the username and belonging scores, by using the rowIndex and columnIndex
         * gotten from the get methods.
         * @param rowIndex is the rowIndex from the previous getter
         * @param columnIndex is the columnIndex from the previous getter
         * @return null
         */
        @Override
        public Object getValueAt (int rowIndex, int columnIndex)
        {
            switch (columnIndex)
            {
                case 0 :
                    return highScores.get(rowIndex).getGame().getWinner().getUsername();
                case 1 :
                    return highScores.get(rowIndex).getScore();
            }
            return null;
        }
    }
}//End of class



   








