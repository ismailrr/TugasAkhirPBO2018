/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesos;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class MyFrame extends JFrame {
    // these are the components we need.
    private final JSplitPane splitPane;  // split the window in top and bottom
    private final JPanel topPanel;       // container panel for the top
    private final JPanel bottomPanel;    // container panel for the bottom
    private final JPanel inputPanel;      // under the text a container for all the input elements
    private final JPanel player1Panel;
    private final JPanel player2Panel;
    private final JButton buttonReset;         // and a "send" button
    private JLabel playerLabel1;      // under the text a container for all the input elements
    private JLabel playerLabel2;      // under the text a container for all the input elements
    private JLabel playerLabel1point;      // under the text a container for all the input elements
    private JLabel playerLabel2point;      // under the text a container for all the input elements
    private ButtonGroup group;
    private final JRadioButton radioS;
    private final JRadioButton radioO;
    private Controller controller;
    private JLabel turnLabel;      // under the text a container for all the input elements
    private JLabel turnLabelNama;      // under the text a container for all the input elements
    private JPanel turnLabelPanel;      // under the text a container for all the input elements
    
    public MyFrame(){

        // first, lets create the containers:
        // the splitPane devides the window in two components (here: top and bottom)
        // users can then move the devider and decide how much of the top component
        // and how much of the bottom component they want to see.
        splitPane = new JSplitPane();

        topPanel = new JPanel();         // our top component
        bottomPanel = new JPanel();      // our bottom component
        
        player1Panel = new JPanel();
        player2Panel = new JPanel();

        turnLabelPanel = new JPanel();
        
        // the input components will be put in a separate panel
        inputPanel = new JPanel();
        buttonReset = new JButton("send");    // and a button at the right, to send the text

        // now lets define the default size of our window and its layout:
        setPreferredSize(new Dimension(400, 550));     // let's open the window with a default size of 400x400 pixels
        // the contentPane is the container that holds all our components
        getContentPane().setLayout(new GridLayout());  // the default GridLayout is like a grid with 1 column and 1 row,
        // we only add one element to the window itself
        getContentPane().add(splitPane);               // due to the GridLayout, our splitPane will now fill the whole window
              
        // let's configure our splitPane:
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window verticaly
        
        splitPane.setBottomComponent(bottomPanel);            // and at the bottom we want our "bottomPanel"
        
        // our topPanel doesn't need anymore for this example. Whatever you want it to contain, you can add it here
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS)); // BoxLayout.Y_AXIS will arrange the content vertically
        playerLabel1 = new JLabel("Player 1 : ");
        playerLabel1point = new JLabel("0");
        playerLabel2 = new JLabel("Player 2 : ");
        playerLabel2point = new JLabel("0");
        playerLabel1.setAlignmentX(JLabel.RIGHT);
        playerLabel2.setAlignmentX(JLabel.RIGHT);
        bottomPanel.add(player1Panel);
        bottomPanel.add(player2Panel);
        player1Panel.add(playerLabel1);
        player1Panel.add(playerLabel1point);
        player2Panel.add(playerLabel2);
        player2Panel.add(playerLabel2point);
        
        //turn Label
        turnLabel = new JLabel("Giliran pemain : ");
        turnLabel.setAlignmentX(JLabel.RIGHT);
        bottomPanel.add(turnLabel);
        turnLabelNama = new JLabel("Player 1");
        turnLabelNama.setAlignmentX(JLabel.RIGHT);
        turnLabelPanel.add(turnLabel);
        turnLabelPanel.add(turnLabelNama);
        
        bottomPanel.add(turnLabelPanel);
        
        bottomPanel.add(inputPanel); // then we add the inputPanel to the bottomPanel, so it under the scrollPane / textArea
        
        
        // let's set the maximum size of the inputPanel, so it doesn't get too big when the user resizes the window
        inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));     // we set the max height to 75 and the max width to (almost) unlimited
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));   // X_Axis will arrange the content horizontally

        inputPanel.add(buttonReset);           // and right the "send" button
        
        //Setting radio Button
        group = new ButtonGroup();
        
        radioS = new JRadioButton("S");
        radioS.setMnemonic(KeyEvent.VK_S);
        radioS.setActionCommand("S");
        
        radioO = new JRadioButton("O");
        radioO.setMnemonic(KeyEvent.VK_O);
        radioO.setActionCommand("O");
        
        radioS.setSelected(true);
        
        group.add(radioS);
        group.add(radioO);
        inputPanel.add(radioS);
        inputPanel.add(radioO);
        
        ItemListener il = new VoteItemListener();
        radioS.addItemListener(il);
        radioO.addItemListener(il);
        
        
                
        pack();   //Memastikan load secara utuh
    }

    public ButtonGroup getGroup() {
        return group;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    public JLabel getPlayerLabel1() {
        return playerLabel1;
    }

    public void setPlayerLabel1(String nama) {
        this.playerLabel1.setText(nama);
    }

    public JLabel getPlayerLabel2() {
        return playerLabel2;
    }

    public void setPlayerLabel2(String nama) {
        this.playerLabel2.setText(nama);
    }

    public int getPlayerLabel1point() {
        return Integer.parseInt(playerLabel1point.getText());
    }

    public void setPlayerLabel1point(int point) {
        this.playerLabel1point.setText(Integer.toString(point));
    }

    public int getPlayerLabel2point() {
        return Integer.parseInt(playerLabel2point.getText());
    }

    public void setPlayerLabel2point(int point) {
        this.playerLabel2point.setText(Integer.toString(point));
    }

    public String getTurnLabelNama() {
        return turnLabelNama.getText();
    }

    public void setTurnLabelNama(String nama) {
        this.turnLabelNama.setText(nama);
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    
}
class VoteItemListener implements ItemListener {
      public void itemStateChanged(ItemEvent ex) {
        String item = ((AbstractButton) ex.getItemSelectable()).getActionCommand();
        boolean selected = (ex.getStateChange() == ItemEvent.SELECTED);
        System.out.println("ITEM Candidate Selected: " + selected + " Selection: " + item);
      }
    }
