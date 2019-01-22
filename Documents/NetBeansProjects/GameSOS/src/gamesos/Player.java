/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesos;

/**
 *
 * @author DELL
 */
public class Player {
    private String nama;
    private int point;
    
    public Player(String nama){
        this.nama = nama;
        this.point = 0;
    }
    
    public int getPoint(){
            return this.point;
    }
        
    public void setPoint(int point){
        this.point = point;
    }
    
    public String getNama(){
            return this.nama;
    }
        
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void IncrementPoint(){
        this.point++;
    }
}
