/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.cloudsquare.java.CaaS;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * @author inaba
 */
public class PropertyData {
    public Properties properties = new Properties();
    private Properties propertiesTypeDefinition = new Properties();

    public PropertyData(String filePath) {
        try(BufferedReader bufferedReader =  Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8);) {
            properties.load(bufferedReader);
//            for(Map.Entry<Object, Object> entry : properties.entrySet()) {
//                Object key = entry.getKey();
//                Object val = entry.getValue();
//                System.out.println(key + ":" + val);
//            }
        }
        catch(Exception e) {
            System.err.println(e);
        }
    }

    public PropertyData(String filePath, String typeDefinitionFilePath) {
        try(BufferedReader bufferedReader =  Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8);) {
            properties.load(bufferedReader);
        }
        catch(Exception e) {
            System.err.println(e);
        }
        try(BufferedReader bufferedReader =  Files.newBufferedReader(Paths.get(typeDefinitionFilePath), StandardCharsets.UTF_8);) {
            propertiesTypeDefinition.load(bufferedReader);
        }
        catch(Exception e) {
            System.err.println(e);
        }
        this.validateProperty();
    }
    
    public int getIntValue(String key, int defaultValue) {
        int result = defaultValue;
        String value = this.properties.getProperty(key);
        if(value != null) {
            try {
                int changeValue = Integer.parseInt(value);
                result = changeValue;
            }
            catch(NumberFormatException e) {
                System.err.println("Unable to convert String to Int.:" + value);
            }
        }
        return result;
    }
    
    public Integer getIntValue(String key) {
        Integer result = null;
        String value = this.properties.getProperty(key);
        if(value != null) {
            try {
                int changeValue = Integer.parseInt(value);
                result = changeValue;
            }
            catch(NumberFormatException e) {
                System.err.println("Unable to convert String to Int.:" + value);
            }
        }
        return result;
    }

    public void validateProperty() {
        this.properties.entrySet().forEach(entry -> {
            String key = (String)entry.getKey();
            String type = (String)this.propertiesTypeDefinition.get(key + Constant.TYPE_DEFINITION_TYPE);
            System.out.println(String.format("Target Propety: %s, %s", key, type));
            switch(type) {
                case Constant.TYPE_DEFINITION_TYPE_INT:
                    if(this.getIntValue(key) == null) {
                        System.out.println("Not change Int.");
                        this.properties.remove(key);
                    }
                    break;
            }
        });
        
    }
    
}
