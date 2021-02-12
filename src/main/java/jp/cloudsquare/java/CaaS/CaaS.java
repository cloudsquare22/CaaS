/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.cloudsquare.java.CaaS;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author inaba
 */
public class CaaS {
    
    static public CaaS instance = new CaaS();
    
    public PropertyData propertyDataFiles = null;
    public ConcurrentHashMap<String, PropertyData> propertyDataMap = new ConcurrentHashMap<>();

    public void start() {
        this.propertyDataFiles = new PropertyData(Constant.FILE_CAAS_PROPERTYFILES);
        propertyDataFiles.properties.entrySet().forEach(entry -> {
            String key = (String)entry.getKey();
            System.out.println("Target Propety:" + key);
            PropertyData propertyData = new PropertyData((String)entry.getValue());
            this.propertyDataMap.put(key, propertyData);
        });
    }
    
}
