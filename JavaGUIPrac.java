/* 
This project is a Encoder and Decoder in a GUi with some added buttons and panels.
The simple encoder will set the first two letters as the last two and the reverse for the decoder
Author: Matthew Nebe
Date: 6/9/2021
*/
import javax.swing.*; //imports swing components
public class JavaGUIPrac
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() //allows for running of frame
        {
            public void run()
            {
                //basic settings for whole frame// //also creates the main frame//
                JFrame frame = new MainFrame ("Encoder/Decoder"); //creates new frame "Main Frame" with a title
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows the frame to be terminated when cross is clicked
                frame.setSize(1400,500); //sets the default size of "Main Frame" 
                frame.setVisible(true); //makes the frame visible
            }
        });
    }
}