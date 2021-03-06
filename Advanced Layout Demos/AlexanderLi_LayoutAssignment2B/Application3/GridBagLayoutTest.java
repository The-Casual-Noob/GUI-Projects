import javax.swing.*;
import java.awt.event.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
/**
 * The GridBagLayoutTest class creates the content for the JFrameMenu window, 
 * it contains an input method for outlining input and an output
 * method for processing and output. It space buttons to demonstrate the
 * propeties of the Grid Bag Layout.
 * @author Jake Mayer
 */ 
public class GridBagLayoutTest extends JPanel
{
  /**
   * The constructor makes a call to the super 
   * constructor creating the panel with a Spring Layout.
   * It then runs the setup method to prepare the object
   * for user interaction.
   */
  public GridBagLayoutTest()
  {
    super();
    setup();
  }
  /**
   *  This method creates a 2 JButtons and a JTextField,
   * It then adds all but one of the buttons to this object and 
   * creates a GridBagConstraints object to set up the constrains for 
   * each grid. Afterwards it adds the text field and one of the buttons to 
   * this object.
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b> go </b> This creates an instance of the JButton class labeled "Go".
   * <p>
   * <b> reset </b> This creates an instance of the JButton class labeled "Reset".
   * <p>
   * <b> inputField </b> This creates an instance of the JTextField class that is 40 characters long.
   * <p>
   * <b> c </b> This creates an instance of the GridBagConstraints class.
   * */
  public void setup()
  {
    setLayout(new GridBagLayout());
    
    JButton go = new JButton("Go");
    JButton reset = new JButton("Reset");
    JTextField inputField = new JTextField(40);
    
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    
    go.setVisible(true);
    inputField.setText("Please enter an Integer (for best results, stay between 10 and 16)");
    
    add(inputField);
    add(go);
    go.addActionListener(new ActionListener() { 
       /*
       * This method creates an int variable. It then creates that many buttons.
       * The height constraints are then changed according to the buttons number the
       * go button is then set to invisible and the reset button is made visible (replacing
       * the go button with the reset button.)
       * <p>
       * <b>Local variables: </b>
       * <p>
       * <b> number </b> This holds an integer which will determine the spacing of the labels.
       */
      public void actionPerformed(ActionEvent e)
      { 
        add(reset,c);
        try
        {
          int number = Integer.parseInt(inputField.getText());
          for(int i=1;i<=number;i++)
          {
            c.gridx = i;
            c.ipady = i*20;
            add(new JButton(Integer.toString(i)),c);
            go.setVisible(false);
            inputField.setVisible(false);
          }
        }
        catch(NumberFormatException ex)
        {
          inputField.setText("Error, please enter a valid Integer");
        }
        reset.setVisible(true);
        repaint();
        revalidate();
      }
    }
    );
    reset.addActionListener(new ActionListener() { 
      /*
       * This meethod makes this object invisible (effectively deleteing it.) 
       */
      public void actionPerformed(ActionEvent e)
      { 
        setVisible(false);
      }
    }                      
    );
  }
}