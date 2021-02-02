/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.cloudsquare.java.CaaS;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author inaba
 */
public class CaaS {
    
    static public CaaS instance = new CaaS();
    
    public HashMap<String, PropertyData> propertyDataMap = new HashMap<>();

    public CaaS() {
    }
    
    public void start() {
        PropertyData propertyDataFiles = new PropertyData(Constant.FILE_CAAS_PROPERTYFILES);
        for(Map.Entry<Object, Object> entry : propertyDataFiles.properties.entrySet()) {
            String key = (String)entry.getKey();
            System.out.println("Target Propety:" + key);
            PropertyData propertyData = new PropertyData((String)entry.getValue());
            propertyDataMap.put(key, propertyData);
        }
    }
    
}
