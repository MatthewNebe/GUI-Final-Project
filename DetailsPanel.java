import javax.swing.*; //imports all swing components
import javax.swing.border.TitledBorder;

import java.awt.*; //imports all awt components
import javax.swing.event.*; //imports all swing event components
import java.awt.event.*; //imports all java awt event components

//holds all details for the details panel// //main bulk of code//
public class DetailsPanel extends JPanel
{
    //bunch of global variables to use in encoding and decoding//
    String toEncode;
    String encoded;
    String fir2;
    String las2;
    String decoded;
    String las3;
    String fir3;

    public DetailsPanel()
    {
        //Code for font//
        Font font = new Font("Arial", Font.BOLD, 20);

        //code to create the listener list//
        final EventListenerList listenerList = new EventListenerList(); //created new list to hold listeners
        listenerList.getListenerCount(); //dead code to get rid of false never used(yellow mark)

        //code to change the panel size//
        Dimension size = getPreferredSize(); //sets size to "setpreferredsize"
        size.width = 400; //size holds both a height and width
        setPreferredSize(size);

        //LINES 32-64 ARE TO CREATE OR MODIFY THE TEXT LABELS/FIELDS AND BUTTONS//
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Encoder"); //creates a border arond the details panel area
        titledBorder.setTitleColor(Color.WHITE);
        //also titles the border//

        JLabel encodeLabel = new JLabel("Word(6+ Characters): "); // makes a new label
        encodeLabel.setForeground(Color.WHITE); //sets the color of the text label to white
        encodeLabel.setFont(font); //sets font of the label
        

        JTextField encodeField = new JTextField(10); //makes a new text box
        encodeField.setSize(50, 100); //sets text box size
        encodeField.setFont(font); //sets text box font
        encodeField.setBackground(Color.BLACK); //sets background color
        encodeField.setForeground(Color.WHITE); //sets text color in text box

        JLabel decodeLabel = new JLabel("Enter encoded word: "); //makes a new label for the decoded word field
        decodeLabel.setForeground(Color.WHITE); //sets the color of the text label to white
        decodeLabel.setFont(font); //sets font of the label

        JTextField decodeField = new JTextField(10); //decode text field
        decodeField.setSize(50, 100);//sets text box size
        decodeField.setFont(font); //sets text box font
        decodeField.setBackground(Color.BLACK); //sets background color
        decodeField.setForeground(Color.WHITE); //sets text color in text box

        JButton addBtn = new JButton("Encode"); //makes a new button "Encode"
        addBtn.setBackground(Color.BLACK); //sets background color of the encode button
        addBtn.setForeground(Color.WHITE); //sets the foreground color of the encode button

        JButton addBtn2 = new JButton("Decode"); //makes a new button "Decode"
        addBtn2.setBackground(Color.BLACK); //sets the background color of the decode button
        addBtn2.setForeground(Color.WHITE); //sets the foreground color of the decode button

        //this method handles the encoding using substring//
        addBtn.addActionListener(new ActionListener()//makes a listener for the encode button
        {
            public void actionPerformed(ActionEvent e)
            {
                toEncode = encodeField.getText();//gets text entered in the encode field

                //these if statements decide to either take the first and last two or three mattering on the length of the word//
                if(toEncode.length() <= 8)
                {
                    fir2 = toEncode.substring(0, 2);//gets first two letters
                    las2 = toEncode.substring(Math.max(toEncode.length() - 2, 0)); //gets last two letters
                    encoded = "Encoded Text: " + las2 + toEncode.substring(2, toEncode.length() -2) + fir2 + " \n"; //Builds the result was a string
                }
                else if(toEncode.length() >= 9)
                {
                    fir3 = toEncode.substring(0, 3);//gets first three letters
                    las3 = toEncode.substring(Math.max(toEncode.length() - 3, 0)); //gets last three letters
                    encoded = "Encoded Text: " + las3 + toEncode.substring(3, toEncode.length() -3) + fir3 + " \n"; //Builds the result was a string
                }
                fireDetailEvent(new DetailEvent(this, encoded));//This will print the result on the right
                System.out.println(encoded); //prints result into the console for check
            }
        });

        //this method handles decoding reversing the substring done in the encoding//
        addBtn2.addActionListener(new ActionListener()//adds a listener to the button and if clicked will run
        {
            public void actionPerformed(ActionEvent e)
            {
                String toDecode = las2 + toEncode.substring(2, toEncode.length() -2) + fir2; //makes word to decode
                decoded = "Decoded text: " + fir2 + toDecode.substring(2, toDecode.length() -2) + las2 + " \n"; //Builds result into a string
                fireDetailEvent(new DetailEvent(this, decoded)); //This will print the result on the right
                System.out.println(decoded); //prints result in console for check
            }
        });
         
        setLayout(new GridBagLayout()); //sets the layout for the details panel

        GridBagConstraints gc = new GridBagConstraints(); //makes a variable for the constraints 

        ///// FIRST ROW /////
        gc.anchor = GridBagConstraints.LINE_START; //keeps the following labels in the box

        gc.weightx = 0.5; //sets the text weight
        gc.weighty = 0.5; //sets text weight

        gc.gridx = 0; //sets the x for the encode label
        gc.gridy = 0; //sets the y for the encode label
        add(encodeLabel, gc); //sets x and y and adds the name label^^

        gc.anchor = GridBagConstraints.LINE_START; //sets where encode label will start

        gc.gridx = 1; //sets the x for the encode field
        gc.gridy = 0; //sets the y for the encode field
        add(encodeField, gc); //adds the encode field to the screen

        ///// SECOND ROW (ENCODE BUTTON) /////
        gc.weighty = 10; //sets the weight for the encode button

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1; //sets the encode button x
        gc.gridy = 1; //sets the encode button y
        add(addBtn, gc); //adds the encode button to the screen

        ///// THIRD ROW /////
        gc.anchor = GridBagConstraints.LINE_START; //sets where the labels will start

        gc.weightx = 0.5; //sets the text weight
        gc.weighty = 0.5; //sets text weight

        gc.gridx = 0; //sets the x for decode label
        gc.gridy = 3; //sets y for decode label
        add(decodeLabel, gc); //adds the Decode label to the screen

        gc.gridx = 1; //sets the x for the decodeField
        gc.gridy = 3; //sets the y for the decodeField
        add(decodeField, gc); //adds the decode field to the screen

        ///// FINAL ROW (DECODE BUTTON) /////
        gc.anchor = GridBagConstraints.FIRST_LINE_START; //sets line for button
        gc.weighty = 10; //sets weight for button
        gc.gridx = 1; //sets x for button
        gc.gridy = 4; //sets y for button
        add(addBtn2, gc); //adds the "Decode" button to the screen
    }

    public void fireDetailEvent(DetailEvent event) //this whole methos just gets the event you are calling (print)
    {
        Object[] listeners = listenerList.getListenerList();

        for(int i=0; i < listeners.length; i += 2) //iterates through pairs of listeners and their classes
        {
            if(listeners[i] == DetailListener.class) // if i is a listener and not a class
            {
                ((DetailListener)listeners[i+1]).detailEventOccured(event); //calls event occured
            }
        }
    }

    public void addDetailsListener(DetailListener listener) //adds a new listener to the listener list
    {
        listenerList.add(DetailListener.class, listener); 
    }
    public void removeDetailsListener(DetailListener listener) //removes listener from the listner list
    {
        listenerList.remove(DetailListener.class, listener);  
    }
}