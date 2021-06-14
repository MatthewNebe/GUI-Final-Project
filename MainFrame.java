import javax.swing.*; //imports java swing components
import java.awt.*; //imports java awt components
import java.awt.event.*; //imports java awt event components

//pieces together the main viewing frame//
public class MainFrame extends JFrame
{
    public DetailsPanel detailsPanel; //makes the detailesPanel variable
    public MainFrame(String title)
    {
        super(title);

        //set layout manager//
        setLayout(new BorderLayout()); 

        //code for text area//
        JTextArea textArea = new JTextArea(); //makes a text area variable
        textArea.setBackground(Color.BLACK); //sets background color of the text area on the right
        textArea.setForeground(Color.WHITE);//sets text or middle text area to white
        Font font = new Font("Arial", Font.BOLD, 40);//Arial
        Font font2 = new Font("Arial", Font.BOLD, 15);//Arial
        textArea.setFont(font); //sets font of middle text area

        //code for button(click me)//
        JButton button = new JButton("Clear Console"); //makes a button 
        button.setBackground(Color.BLACK); //sets the background color of the bottom button
        button.setForeground(Color.WHITE); //sets the foreground color of the bottom button

        //code for text pane on the right//
        JTextPane textPane = new JTextPane(); //creates a new prefilled text area on the right
        textPane.setText("Hello Welcome :)\n" + "This is my Encoder/Decoder\n" + "Author: Matthew Nebe"); //sets text in the right pane
        textPane.setBackground(Color.BLACK); //sets color of the background of the pane
        textPane.setForeground(Color.WHITE); //sets color of the text on the pane
        textPane.setFont(font2); //sets font of the right text pane
        textPane.setSize(200, 500);

        detailsPanel = new DetailsPanel(); //creates detals panel

        //this method adds a listener to listener list in the details panel class
        detailsPanel.addDetailsListener(new DetailListener() 
        {
            public void detailEventOccured(DetailEvent event)
            {
                String text = event.getText(); //this gets the text that will be printed from the method where it is made
                textArea.append(text); //prints text in the box on the right
            }
        });

        //Section to add components to GUI//
        Container c = getContentPane(); //makes a conainer to add components into
        c.add(textArea, BorderLayout.CENTER); //adds the text area in the center
        c.add(button, BorderLayout.SOUTH); //adds the button at the bottom (south)
        c.add(detailsPanel, BorderLayout.WEST); //adds the details panel on the left (west)
        c.add(textPane, BorderLayout.EAST); //adds the text pane to the right
        detailsPanel.setBackground(Color.BLACK); //sets the background color of the details panel
        detailsPanel.setForeground(Color.WHITE); //sets the foreground color of the details panel

        //this method adds a listener to the clear console button and runs the code inside when clicked//
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                textArea.setText(" "); //if button pressed clears console
            }
        });
    }
}
//end//