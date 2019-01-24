/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesos;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author DELL
 */
public class Computer {
    private Papan papan;
    private ComponentTitik titik;
    private ArrayList<ComponentTitik> availableTitik;
    private Random randomGenerator;
    
    public Computer(Papan papan){
        this.papan = papan;
        this.availableTitik = new ArrayList<ComponentTitik>();
        randomGenerator =  new Random();
    }
    
    public ComponentTitik getBestMove(){
        getAvailableMove();
        int index = randomGenerator.nextInt(availableTitik.size());
        titik = availableTitik.get(index);
        return titik;
    } 
    public ArrayList<ComponentTitik> getAvailableMove(){
        for(int i = 0;i<papan.getCol();i++){
            for(int j = 0;j<papan.getRow();j++){
                if(papan.getTitik(i, j)==' '){
                    availableTitik.add(new ComponentTitik(i,j));
                }
            }
        }
        return availableTitik;
    }
}
