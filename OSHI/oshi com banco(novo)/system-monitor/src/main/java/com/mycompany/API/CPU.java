package com.mycompany.API;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.TickType;

public class CPU {

    private final CentralProcessor cpu; // privada
    private long oldTicks[];
    
    public CPU() {
        this.cpu = new SystemInfo().getHardware().getProcessor();
        this.oldTicks = new long[TickType.values().length];
    }
    
    /**
     * Returns the max frequency of the CPU in GHz.
     * @return CPU max frequency.
     */
    public Double getFrequency() {
        return FormatUnit.toGigahertz(cpu.getMaxFreq());
    }
    
    /**
     * Returns the average of the CPU frequency in GHz.
     * @return The average of frequency.
     */
    public Double getCurrentFrequency() {
        Long freqSum = 0L;
        
        for (Long freq : cpu.getCurrentFreq()) {
            freqSum += freq;
        }
        
        return FormatUnit.toGigahertz(freqSum / cpu.getLogicalProcessorCount());
    }
    
    /**
     * Returns the current cpu percent usage.
     * @return current cpu percent.
     */
    public Double getCurrentPercent() {
        double d = cpu.getSystemCpuLoadBetweenTicks(oldTicks);
        oldTicks = cpu.getSystemCpuLoadTicks();
        return d * 100.0;
    }
}
