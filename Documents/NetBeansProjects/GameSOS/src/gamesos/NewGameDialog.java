/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesos;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class NewGameDialog extends JPanel {

//   public static void main(String[] args)
//   {
//
//      NewGameDialog input = new NewGameDialog();
//      input.setLocationRelativeTo(null);
//      input.setVisible(true);
//
//   }
   private ButtonGroup group;
   public NewGameDialog() 
   {
      this.setMinimumSize(new Dimension(500, 500));
      
      group = new ButtonGroup();
      
      JRadioButton papan3 = new JRadioButton("3");
      JRadioButton papan5 = new JRadioButton("5");
      JRadioButton papan7 = new JRadioButton("7");
      
      this.setLayout(new GridLayout(3, 1, 5, 5));

      papan3.setActionCommand("3");
      papan5.setActionCommand("5");
      papan7.setActionCommand("7");
      
      group.add(papan3);
      group.add(papan5);
      group.add(papan7);
      this.add(papan3);
      this.add(papan5);
      this.add(papan7);
      
      ItemListener il = new VoteItemListener();
        papan3.addItemListener(il);
        papan5.addItemListener(il);
        papan7.addItemListener(il);
   }

   public ButtonGroup getGroup() {
        return group;
    }
}