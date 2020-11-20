package com.mycompany.Oshi;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

public class RAM {

    GlobalMemory ram;
    
    public RAM() {
        this.ram = new SystemInfo().getHardware().getMemory();
              

    }
    
    public Double getUsedMemory() {
        return (ram.getTotal() - ram.getAvailable()) / Math.pow(10, 9);
    }
    
    public Double getAvailableMemory() {
        return ram.getAvailable() / Math.pow(10, 9);
    }
    
    public Double getCurrentPercent() {
        Long total = ram.getTotal();
        Long used = total - ram.getAvailable();
        
        return (used * 100.0) / total;
    }
}
