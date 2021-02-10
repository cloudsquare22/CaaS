/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.cloudsquare.java.CaaS;

import java.io.Console;
import jp.cloudsquare.java.BuiltInHttpServer.HttpServer;

/**
 *
 * @author inaba
 */
public class Main {
    static public PropertyData caasPropertyData;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        caasPropertyData = new PropertyData(Constant.FILE_CAAS);
        int port = Main.caasPropertyData.getIntValue("restserver.port", 8080);
        CaaS.instance.start();
        System.out.println("CaaS start");
        
        HttpRequestProcessHandler httpRequestProcessHandler = new HttpRequestProcessHandler();
        HttpServer restServer = new HttpServer(port, "REST IF", httpRequestProcessHandler);
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
