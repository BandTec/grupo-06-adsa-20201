package com.mycompany.API;

public class FormatUnit {
    
    public static Double toGigabyte(Long bytes) {
        return bytes / Math.pow(10, 9);
    }
    
    public static Double toGigahertz(Long hertz) {
        return hertz / Math.pow(10, 9);
    }
}
