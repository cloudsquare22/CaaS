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
        // TODO code application logic here
        PropertyData propertyDataFiles = new PropertyData("./caas_propertyfiles.properties");
        for(Map.Entry<Object, Object> entry : propertyDataFiles.properties.entrySet()) {
            System.out.println(entry.getKey());
            PropertyData propertyData = new PropertyData((String)entry.getValue());
        }
        
    }
    
}
