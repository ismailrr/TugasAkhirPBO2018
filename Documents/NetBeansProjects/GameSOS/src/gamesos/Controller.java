/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesos;

/**
* kelas ini merupakan kelas yang menjadi controller pada game, dimana kelas ini akan menerima masukan dari klik mouse user
* dengan me-implements ActionListener, maka void actionPerformed harus ada pada kelas ini
* ActionPerformed yang akan melakukan respon untuk mouse klik user
**/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static java.nio.file.Files.lines;
import java.util.Arrays;
import javax.swing.*;

class Controller implements ActionListener {
	private Papan papan;
        private Player player1;
        private Player player2;
	private char color;
        private MyFrame myFrame;
        private int turn;
        private String winner;
        private boolean gameEnd;
        private static Character[] arrSOS;
        
	public Controller(Papan papan, String nama1, String nama2, MyFrame myFrame) {
            this.papan = papan;
                this.player1 = new Player(nama1);
                this.player2 = new Player(nama2);
                this.myFrame = myFrame;
                turn = 0;
                winner = "";
                arrSOS = new Character[] {'S','O','S'};
	}
        
	public void actionPerformed(ActionEvent e) {
                turn++;
		/* ActionEvent e merupakan objek yang telah ditrigger dengan klik mouse 
		   jadi kita bisa mengakses ComponentTitik yang mana yang diklik dengan casting terlebih dahulu*/
		ComponentTitik tmp = (ComponentTitik) e.getSource();
                
                this.color = myFrame.getGroup().getSelection().getActionCommand().charAt(0);
                
		if(papan.getTitik(tmp.getRow(),tmp.getCol()) == ' ') {
			papan.setTitik(tmp.getRow(),tmp.getCol(),color);
                        checkSOS(tmp.getRow(),tmp.getCol());
			//cek pemenang setelah menaruh bidak pada titik
			checkWinner();	
		}
                
                gameEnd = true;
                updateTurn();
                checkGameEnd();
	}

        public void checkGameEnd(){
            outerloop:
            for(int i = 0; i<papan.getRow(); i++) {
			for(int j = 0; j<papan.getCol(); j++) {
				if(papan.getTitik(i, j) == ' '){
                        gameEnd = false;
                        break outerloop;
                    }
		}
            }
            
            if(gameEnd){
                JOptionPane.showMessageDialog(null, "Game berakhir", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);   
            }
        }
        
	public String checkWinner() {
		if(player1.getPoint() > player2.getPoint()){
                    winner = player1.getNama();
                }
                else if(player1.getPoint() < player2.getPoint()){
                    winner = player1.getNama();
                }else{
                    winner = "DRAW";
                }
                return winner;
	}
        
        public void checkSOS(int row, int col){
            Character[] arrTmp = new Character[3];
            //Cek Horizontal
            outerloop:
            for(int i=-2; i<= 0;i++){
                for(int a = 0; a<=2 ;a++){
                    if(col+i+a>=0 && col+i+a<=papan.getCol()-1){
                        arrTmp[a] = papan.getTitik(row, col+i+a);
                    }
                } 
                if(compareArrays(arrTmp)){
                        updatePoint();
                        System.out.println("get point horinzontal");
                        break outerloop;
                }
            }
            arrTmp = new Character[3];
            //Cek Vertical
            outerloop2:
            for(int i=-2; i<= 0;i++){
                for(int a = 0; a<=2 ;a++){
                    if(row+i+a>=0 && row+i+a<=papan.getRow()-1){
                        arrTmp[a] = papan.getTitik(row+i+a, col);
                    }
                }
                if(compareArrays(arrTmp)){
                        updatePoint();
                        System.out.println("get point vertical");
                        break outerloop2;
                }
            }
            arrTmp = new Character[3];
            
            //Cek diagonal kiri atas ke kanan bawah
            outerloop3:
            for(int i=-2; i<= 0;i++){
                for(int a = 0; a<=2 ;a++){
                    if(row+i+a>=0 && row+i+a<=papan.getRow()-1 && col+i+a>=0 && col+i+a<=papan.getCol()-1){
                        arrTmp[a] = papan.getTitik(row+i+a, col+i+a);
                    }
                }
                if(compareArrays(arrTmp)){
                        updatePoint();
                        System.out.println("get point diagonal negatif");
                        break outerloop3;
                }
            }
            arrTmp = new Character[3];
            
            //Cek diagonal kanan atas ke kiri bawah
            outerloop4:
            for(int i=-2; i<= 0;i++){
                for(int a = 0; a<=2 ;a++){
                    if(row+i+a>=0 && row+i+a<=papan.getRow()-1 && col-i-a>=0 && col-i-a<=papan.getCol()-1){
                        arrTmp[a] = papan.getTitik(row+i+a, col-i-a);
                    }
                }   
                if(compareArrays(arrTmp)){
                        updatePoint();
                        System.out.println("get point diagonal positif");
                        break outerloop4;
                }
            }
            System.out.print("Isi arrTmp : ");
                for(int k=0;k<3;k++){
                    System.out.print(arrTmp[k]+"|");
                }
            System.out.println("=============================================================");
        }
        
        public static boolean compareArrays(Character[] arr1) {
            return Arrays.equals(arr1, arrSOS);
        }
        
        public void updatePoint(){
            if(turnCheck()){
                player1.IncrementPoint();
                myFrame.setPlayerLabel1point(player1.getPoint());
            }else{
                player2.IncrementPoint();
                myFrame.setPlayerLabel2point(player2.getPoint());
            }
        }
        
        public void updateTurn(){
            if(!turnCheck()){
                myFrame.setTurnLabelNama(player1.getNama());
            }else{
                myFrame.setTurnLabelNama(player2.getNama());
            }
        }
        
        public boolean turnCheck(){
            System.out.println("turn ke : "+turn);
            return turn%2 == 0 ? false : true;
        }
        
        public String getNamaPlayer1(){
            return this.player1.getNama();
        }
        
        public String getNamaPlayer2(){
            return this.player2.getNama();
        }
        
        public int getPointPlayer1(){
            return this.player1.getPoint();
        }
        
        public int getPointPlayer2(){
            return this.player2.getPoint();
        }
        
        public void getColor(char color){
            this.color = color;
        }
        
        public char getColor(){
            return this.color;
        }
}
