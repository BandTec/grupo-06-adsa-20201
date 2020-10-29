/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

/**
 *
 * @author manoel
 */
public class Info extends javax.swing.JPanel {

    SystemInfo si = new SystemInfo();
    CentralProcessor.ProcessorIdentifier cpu = si.getHardware().getProcessor().getProcessorIdentifier();
    
    /**
     * Creates new form Info
     */
    public Info() {
        initComponents();
        
        lblOperatingSystem.setText(si.getOperatingSystem().toString());
        lblCPUName.setText(cpu.getName());
        lblCPUIdentifier.setText(cpu.getIdentifier());
        lblCPUMicroArchtecture.setText(cpu.getMicroarchitecture());
        lblCPUVendor.setText(cpu.getVendor());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblOperatingSystem = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCPUName = new javax.swing.JLabel();
        lblCPUIdentifier = new javax.swing.JLabel();
        lblCPUMicroArchtecture = new javax.swing.JLabel();
        lblCPUVendor = new javax.swing.JLabel();

        jLabel1.setText("Operating system:");

        lblOperatingSystem.setText(":");

        jLabel3.setText("Processor:");

        lblCPUName.setText(":");

        lblCPUIdentifier.setText(":");

        lblCPUMicroArchtecture.setText(":");

        lblCPUVendor.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCPUVendor)
                    .addComponent(lblCPUMicroArchtecture)
                    .addComponent(lblCPUIdentifier)
                    .addComponent(lblOperatingSystem)
                    .addComponent(lblCPUName))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblOperatingSystem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblCPUName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCPUIdentifier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCPUMicroArchtecture)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCPUVendor)
                .addContainerGap(110, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCPUIdentifier;
    private javax.swing.JLabel lblCPUMicroArchtecture;
    private javax.swing.JLabel lblCPUName;
    private javax.swing.JLabel lblCPUVendor;
    private javax.swing.JLabel lblOperatingSystem;
    // End of variables declaration//GEN-END:variables
}
