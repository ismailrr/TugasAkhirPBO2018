
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesos;

/**
* kelas ini buat jadi Panel grid untuk titik-titiknya yang akan digambar
* tujuannya supaya lebih mudah menggambar titik2nya dan rapih
* panelnya juga langsung mengikuti ukuran frame yang telah diset di kelas Driver
**/
import java.awt.*;
import javax.swing.*;

class ComponentPapan extends JPanel {
	private Papan papan;
	private int row;
	private int col;
        private int turn;
        private Controller controller;

	public ComponentPapan(Papan papan,int row,int col, Controller controller) {
		this.papan = papan;
		this.row = row;
		this.col = col;
                this.controller = controller;
                
		//TODO : set layout Jpanel ini dengan grid berukuran row * col
                setLayout(new GridLayout(row,col));

		/* jadi, setiap titik punya tukang gambar yang bernama ComponentTitik. kemudian ComponentTitik tersebut dimasukkan kedalam grid ComponentPapan */
		
		for(int i = 0; i<row; i++)
			for(int j = 0; j<col; j++) {
				ComponentTitik tmp = new ComponentTitik(papan,i,j);
                                LinesComponent line = new LinesComponent(papan);
                                
				// memberikan Listener ke setiap titik, supaya kalo titiknya diteken akan men-trigger controllernya
				tmp.addActionListener(controller);
                                
				// memasukkan componentTitik tmp ke dalam grid, dan dimasukkan terurut dari atas kiri ke kanan bawah grid secara auto
				// jadi tinggal add, si objeknya bakal ngisi ke grid paling atas terkiri yang masih kosong
				add(tmp);
			}
	}
}