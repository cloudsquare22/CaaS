/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.cloudsquare.java.CaaS;

import jp.cloudsquare.java.BuiltInHttpServer.HttpServer;

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
        
        HttpRequestProcessHandler httpRequestProcessHandler = new HttpRequestProcessHandler();
        HttpServer restServer = new HttpServer(8080, "REST IF", httpRequestProcessHandler);
        restServer.start();

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
