/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesos;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

/**
*  kelas GameSOS merupakan main class yang bakal membuat sekaligus mengisi frame dengan objek-objek yang
*  telah dibuat nantinya
*  @author ?
**/

public class GameSOS {

//	public static void main(String args[]) {
//		
//		JFrame frame = new JFrame("GUI");
//                Papan papan = new Papan(4,4);
//                ComponentPapan componentPapan = new ComponentPapan(papan,4,4);
//		frame.setLayout(new BorderLayout());
//		frame.add(componentPapan); //TODO : hilangkan errornya
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(400,400); // untuk nge-set ukuran dari frame, contoh : frame.setSize(400,400);
//		frame.setVisible(true); // frame yang dibuat defaultnya belum ditampilkan, oleh karena itu harus diset visible
//	}
        
        public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                Scanner in = new Scanner(System.in);
                boolean gameStart = false;
                NewGameDialog input = new NewGameDialog();
                int n = JOptionPane.showOptionDialog(null, input,
                    "Radio Test", JOptionPane.YES_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
                int luas = 0;
                if (n == JOptionPane.YES_OPTION) {
                    luas = Integer.parseInt(input.getGroup().getSelection().getActionCommand());
                    gameStart = true;
                }
                else if (n == JOptionPane.NO_OPTION) {
                    // non stop game
                }
                else {
                    // the user closed the dialog without clicking an button
                }
                
                if(gameStart==true){
                    MyFrame myFrame = new MyFrame();
                    Papan papan = new Papan(luas,luas);
                    Controller controller =  new Controller(papan,"Player 1","Player 2",myFrame);
                    ComponentPapan componentPapan = new ComponentPapan(papan,luas,luas,controller); 
                    myFrame.getContentPane().add(componentPapan);
                    myFrame.getSplitPane().setTopComponent(componentPapan);                  // at the top we want our "topPanel"  
                    myFrame.getSplitPane().setDividerLocation(400);                    // the initial position of the divider is 200 (our window is 400 pixels high)
                    myFrame.setVisible(true);
                    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        });
    }
}