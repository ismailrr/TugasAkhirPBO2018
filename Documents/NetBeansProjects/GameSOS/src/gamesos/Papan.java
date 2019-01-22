/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesos;

/*
        h*
* Kelas papan merupakan kelas yang menyimpan informasi/kondisi papan, kelas ini bukan merupakan kelas yang mencetak wujud papannya
**/

class Papan {
	//TODO : variabel-variabel yang dibutuhkan
    private int row;
    private int col;
    private int size;
    private char[][] papan;

	public Papan(int row,int col) {
		this.row = row;
		this.col = col;
		papan = new char[row][col];
                
		resetPapan();
	}

	public void resetPapan() {
		for(int i = 0; i<row; i++) {
			for(int j = 0; j<col; j++) {
				setTitik(i,j,' '); // meng-kosongkan papan
			}
		}
	}

	public char[][] getPapan() {
		return papan;
	}

	public void setPapan(char[][] papan) {
		this.papan = papan;
	}

	public char getTitik(int row,int col) {
		return papan[row][col];
	}

	public void setTitik(int row,int col,char color) {
		papan[row][col] = color;
	}

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
        
        
        
}