package UI;

/**
 * Created by ejer on 19/11/15.
 */
public class TESTGUICONTROLLER {

    private MyFrame myFrame;
    private ContainerPanel containerPanel;


    public TESTGUICONTROLLER()
    {
        myFrame = new MyFrame();

    }


    public void injectListeners()
    {
        // Login, logout and forgot password actionlisteners
        //ContainerPanel.getLoginPanel().addActionListener(new LoginActionListener());

    }

    public MyFrame getMyframe()
    {
        return myFrame;
    }


}
