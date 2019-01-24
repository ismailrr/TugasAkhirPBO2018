/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesos;

/**
* Kelas componentTitik ini extends JButton supaya objeknya bisa diklik
* 1 objek dari kelas ini me-presentasikan 1 buah titik dari banyak titik di papan
**/

import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;

class ComponentTitik extends JButton {
	private Papan papan;
	private int row; //posisi baris titik
	private int col; //posisi kolom titik

        public ComponentTitik(int row, int col){
            this.row = row;
            this.col = col;
        }
        
	public ComponentTitik(Papan papan,int row,int col) {
		this.papan = papan;
		this.row = row;
		this.col = col;

	}
        
	//TODO: bikin method setter getter instance variable

	/* paintComponent merupakan override method
	   setiap component mempunyai method paintComponent yang berfungsi segabai alat si javanya menggambar*/
        @Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

                //mengambil ukuran papan
		// mengambil ukuran grid 1x1
		int w = super.getWidth();
		int h = super.getHeight();
		
		//jika ternyata pada titik row,col di papan masih kosong, tidak perlu menggambar oval
		if(papan.getTitik(row,col) == ' ') //char ' ' mempresentasikan titik Kosong/belum diisi
			return;

                int jarak=0;
                if(papan.getRow()==3){
                    jarak=62;
                }else if(papan.getRow()==5){
                    jarak=38;
                }else{
                    jarak=22;
                }
                
		//TODO : buat statement yang membedakan apakah titik yang akan digambar warna putih,atau warna hitam
		//hint : kelas Graphics punya method setColor()
                if(papan.getTitik(row,col) == 'S'){
                    g2.drawString("S", row+jarak, col+jarak);
                }else if(papan.getTitik(row,col) == 'O'){
                    g2.drawString("O", row+jarak, col+jarak);
                }

                g.setFont(new Font("TimesRoman", Font.PLAIN, 48)); 
	}
        
        public int getRow(){
            return this.row;
        }
        
        public int getCol(){
            return this.col;
        }
        
        public void setRow(int row){
            this.row = row;
        }
        
        public void setCol(int col){
            this.col = col;
        }
        
}