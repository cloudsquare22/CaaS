/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.cloudsquare.java.CaaS;

import java.util.Map;

/**
 *
 * @author inaba
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CaaS.instance.start();
        System.out.println("CaaS start");
        
        while(true) {
            try {
                Thread.sleep(1000);
            }
            catch(Exception e) {
                System.err.println(e);
            }
        }
        
    }
    
}
