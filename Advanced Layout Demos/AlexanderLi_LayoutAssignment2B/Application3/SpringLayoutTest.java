import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
/**
 * The SpringLayoutTest class creates the content for the JFrameMenu window, 
 * it contains an input method for outlining input and an output
 * method for processing and output. It puts constraints between labels to 
 * demonstates the properties of the Spring Layout.
 * @author Jake Mayer
 */ 
public class SpringLayoutTest extends JPanel
{
  /**
   * The constructor makes a call to the super 
   * constructor creating the panel with a Spring Layout.
   * It then runs the setup method to prepare the object
   * for user interaction.
   */
  public SpringLayoutTest()
  {
    super(new SpringLayout());
    setup();
  }
/*
 * This method creates a  Spring Layout, 2 JButtons a JTextField and two JLabels,
 * It then adds al but one of the buttons to this object and puts a constraint between 
 * one of the buttons and the JTextField and finally it adds an actionListener to
 * both of the buttons.
 * <p>
 * <b>Local variables: </b>
 * <p>
 * <b> s </b> This references this class' layout.
 * <p>
 * <b> go </b> This creates an instance of the JButton class labeled "Go".
 * <p>
 * <b> reset </b> This creates an instance of the JButton class labeled "Reset".
 * <p>
 * <b> inputField </b> This creates an instance of the JTextField class that is 40 characters long.
 * <p>
 * <b> labelA </b> This creates an instance of the JLabel class.
 * <p>
 * <b> labelA </b> This creates an instance of the JLabel class.
 * 
 */
  public void setup()
  {
    SpringLayout s=(SpringLayout)getLayout();
    JButton go = new JButton("Go");
    JButton reset = new JButton("Reset");
    JTextField inputField = new JTextField(40);
    JLabel labelA=new JLabel();
    JLabel labelB=new JLabel();
    inputField.setText("Please enter an Integer (for best results, stay between 20 and 25)");
    add(inputField);
    add(go);
    add(labelA);
    add(labelB);
    s.putConstraint(SpringLayout.WEST, inputField, 100, SpringLayout.WEST, reset);
    go.addActionListener(new ActionListener() { 
      /*
       * This method creates an int variable, it then adds some text to the labels (effectively making
       * them visible.) It then puts a constraint on the two labels and the inputField that spaces them 
       * apart equally. The go button is then set to invisible and the reset button is made visible (replacing
       * the go button with the reset button.)
       * <p>
       * <b>Local variables: </b>
       * <p>
       * <b> number </b> This holds an integer which will determine the spacing of the labels.
       */
      public void actionPerformed(ActionEvent e)
      { 
        try
        {
          int number = Integer.parseInt(inputField.getText());
          labelA.setText("These labels are spaced apart equally from the");
          labelB.setText("input field. Also try strectching the window.");
          s.putConstraint(SpringLayout.NORTH, labelA, number+10, SpringLayout.SOUTH, inputField);
          s.putConstraint(SpringLayout.NORTH, labelB, number+10, SpringLayout.SOUTH, labelA);
          inputField.setText("Hit \"Reset,\" then go back to the menu and select an option.");
          go.setVisible(false);
          reset.setVisible(true);
          add(reset);
          repaint();
          revalidate();
        }
        catch(NumberFormatException ex)
        {
          inputField.setText("Error, please enter a valid Integer");
        }
      }
    } );
    reset.addActionListener(new ActionListener() { 
      /*
       * This method makes this object invisible (effectively deleteing it.) 
       */
      public void actionPerformed(ActionEvent e)
      { 
        setVisible(false);
      }
    });
  }
}