import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
/**
 * The FlowLayoutTest demonstrates features of FlowLayout using an interactive display.
 * @author Alexander Li
 * @version 2019-03-29
 *
 */
public class FlowLayoutTest extends JPanel implements ActionListener{
 
 FlowLayout fl;
 JPanel controlPanel;
 JPanel displayPanel;
 /**
  * The class constructor calls the superclass constructor (JPanel), sets a BorderLayout, and
  * executes display() and control(), which create the display and its controls respectively.
  * It then sets it to visible.
  */
 public FlowLayoutTest(){
  super();
  this.setLayout(new BorderLayout());
  //Create a control panel below
  display();
  controls();
  this.setVisible(true);
 }
 
 /**
  * The display() method creates a JPanel containing 10 buttons in a flow layout.
  * The spacing and alignment of the flow layout can be changed. Those changes will
  * be reflected in the arrangement of the buttons in this JPanel. The displayPanel is
  * added to the FlowLayoutTest instance.
  */
 public void display(){
  fl = new FlowLayout();
  
  displayPanel = new JPanel(fl);
  JButton[] buttons = new JButton[10];
  for (int i = 0; i < buttons.length; i++){
   String buttonName = "Button " + (i+1);
   buttons[i] = new JButton(buttonName);
   displayPanel.add(buttons[i]);
  }
  
  this.add(displayPanel, BorderLayout.CENTER);
 }
 
 /**
  * The controls() method creates a JPanel containing a vertical box which stores other JPanels.
  * Each JPanel contains one row of control components. 
  * This method also adds ActionListeners to its buttons.
  * The control rows are added to the box, which is
  * added to the controlPanel, which is added to the FlowLayoutTest instance.
  */
 public void controls(){
  controlPanel = new JPanel(new GridLayout(1,1,0,0));
  JPanel row1Controls = new JPanel(new FlowLayout());
  JPanel row2Controls = new JPanel(new FlowLayout());
  JLabel hgapLabel = new JLabel("Horizontal spacing: ");
  JLabel vgapLabel = new JLabel("Vertical spacing: ");
  JTextField hgapField = new JTextField(10);
  JTextField vgapField = new JTextField(10);
  JButton setSpacingButton = new JButton("Set Spacing");
  hgapField.setText(Integer.toString(fl.getHgap()));
  vgapField.setText(Integer.toString(fl.getVgap()));
  setSpacingButton.addActionListener(this);
  setSpacingButton.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent ae){
    try{
     int hgap = Integer.parseInt(hgapField.getText());
     int vgap = Integer.parseInt(vgapField.getText());
     fl.setHgap(hgap);
     fl.setVgap(vgap);
     
    }catch(Exception e){
     JDialog errorDialog = new JDialog();
        errorDialog.setLayout(new FlowLayout());
        errorDialog.setTitle("Error: NumberFormatException");
        JLabel errorLabel = new JLabel();
        errorLabel.setHorizontalAlignment(JLabel.CENTER);
        errorLabel.setText("Enter a valid integer.");
        
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            errorDialog.dispose();
          }
        });
        errorDialog.add(errorLabel);
        errorDialog.add(closeButton);
        
        errorDialog.setSize(200,100);
        errorDialog.setResizable(false);
        errorDialog.setVisible(true);
     hgapField.setText(Integer.toString(fl.getHgap()));
     vgapField.setText(Integer.toString(fl.getVgap()));
    }
   }
  });
  
  
  
  JLabel alignLabel = new JLabel("Set Alignment");
  JButton alignLeftButton = new JButton("Left");
  JButton alignRightButton = new JButton("Right");
  JButton alignCenterButton = new JButton("Center");
  JButton toggleAlignOnBaselineButton = new JButton("Toggle Baseline");
  alignLeftButton.addActionListener(this);
  alignRightButton.addActionListener(this);
  alignCenterButton.addActionListener(this);
  toggleAlignOnBaselineButton.addActionListener(this);
  row1Controls.add(hgapLabel);
  row1Controls.add(hgapField);
  row1Controls.add(setSpacingButton);
  row1Controls.add(vgapLabel);
  row1Controls.add(vgapField);
  
  row2Controls.add(alignLabel);
  row2Controls.add(alignLeftButton);
  row2Controls.add(alignCenterButton);
  row2Controls.add(alignRightButton);
  row2Controls.add(toggleAlignOnBaselineButton);
  
  Box box1 = Box.createVerticalBox();
  
  box1.add(row1Controls);
  box1.add(row2Controls);
  controlPanel.add(box1);
  
  this.add(controlPanel, BorderLayout.PAGE_END);
 }
 
 /**
  * The actionPerformed() method determines the source of the ActionEvent and
  * executes the appropriate action
  */
 public void actionPerformed(ActionEvent ae){
  String action = ae.getActionCommand();
  switch(action){
  case "Left":
   fl.setAlignment(FlowLayout.LEFT);
   break;
  case "Right":
   fl.setAlignment(FlowLayout.RIGHT);
   break;
  case "Center":
   fl.setAlignment(FlowLayout.CENTER);
   break;
  case "Toggle Baseline":
   if (fl.getAlignOnBaseline()) fl.setAlignOnBaseline(false);
   else fl.setAlignOnBaseline(true);
  }
  displayPanel.revalidate();
  displayPanel.repaint();
 }
 
}
