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
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author inaba
 */
public class PropertyData {
    public Properties properties = new Properties();

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
}
