package com.mycompany.API;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;

public class Disk {
    private List<HWDiskStore> disks;

    public Disk() {
        this.disks = Arrays.asList(new SystemInfo().getHardware()
                .getDiskStores())
                .stream()
                .filter(disk -> disk.getSize() > 0)
                .collect(Collectors.toList());
    }
    
    public String getName(Integer index) {
        String modelName = disks.get(index).getModel();
        return modelName.substring(0, modelName.indexOf("("));
    }
    
    public List<String> getPartitionsMountPoint(Integer index) {
        HWDiskStore disk = disks.get(index);
        List<String> mountPoints = new ArrayList<>();
        
        for (HWPartition partitions : disk.getPartitions()) {
            if (!partitions.getMountPoint().equals(""))
                mountPoints.add(partitions.getMountPoint());
        }
        
        return mountPoints;
    }
    
    public Double getDiskSize(Integer index) {
        return FormatUnit.toGigabyte(disks.get(index).getSize());
    }
    
    public Double getFreeSize(Integer index) {
        Long size = 0L;
        
        for (String point : getPartitionsMountPoint(index)) {
            File file = new File(point);
            size += file.getFreeSpace();
        }
        
        return FormatUnit.toGigabyte(size);
    }
    
    public Integer getDiskPercent(Integer index) {
        Double total = getDiskSize(index);
        Double used = getFreeSize(index);
        
        return Double.valueOf(100 - used * 100 / total).intValue();
    }
    
    public Integer getDiskCount() {
        return disks.size();
    }
}
