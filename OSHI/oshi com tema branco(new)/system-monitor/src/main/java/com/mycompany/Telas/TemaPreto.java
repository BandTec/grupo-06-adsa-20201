package com.mycompany.Telas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.mycompany.Oshi.CPU;
import com.mycompany.Oshi.Disk;
import com.mycompany.Oshi.RAM;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import oshi.SystemInfo;

public class TemaPreto extends javax.swing.JFrame {

    java.util.Timer mTimer = new java.util.Timer();
    SystemInfo si = new SystemInfo();
    private CPU cpu = new CPU();
    private RAM ram = new RAM();
    private Disk disk = new Disk();
    private long velocidadeDaNet = si.getHardware().getNetworkIFs()[0].getSpeed() + si.getHardware().getNetworkIFs()[2].getSpeed() + si.getHardware().getNetworkIFs()[1].getSpeed();

    public TemaPreto() {

        initComponents();


        // codigo para poder personaï¿½izar a barra de progresso fonte externa         
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TemaPreto.class.getName()).log(Level.SEVERE, null, ex);
        }

        TimerTask task = new TimerTask() {

            @Override
            public void run() {

//                System.out.println(velocidadeDaNet);

                if (velocidadeDaNet <= 100000000) {
                    onLabel.setText("OFFLINE");

                } else {
                    onLabel.setText("ONLINE");

                }

            }
        };

        mTimer.scheduleAtFixedRate(task, 999, 999);

        ActionListener action;
        action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lblCPU.setText(String.format("%.2fGhz", cpu.getCurrentFrequency()));
                lblCPU1.setText(String.format("%.2fGhz", cpu.getFrequency()));//30
                // 40
                lblCPUPercent.setText(String.format("%.1f%%", cpu.getCurrentPercent()));
                
                lblRAM.setText(String.format("%.2fGB", ram.getUsedMemory()));
                lblRAM1.setText(String.format("%.2fGB", ram.getAvailableMemory()));
                lblRAMPercent.setText(String.format("%.1f%%", ram.getCurrentPercent()));
                
                lblNameDisk0.setText(disk.getName(0));
                lblTotalSpaceDisk0.setText(String.format("%.2fGB", disk.getDiskSize(0)));
                lblFreeSpaceDisk0.setText(String.format("%.2fGB", disk.getFreeSize(0)));
                pgbUsageDisk0.setValue(disk.getDiskPercent(0));
                
                if (disk.getDiskCount() > 1) {
                    lblNameDisk1.setText(disk.getName(1));
                    lblTotalSpaceDisk1.setText(String.format("%.2fGB", disk.getDiskSize(1)));
                    lblFreeSpaceDisk1.setText(String.format("%.2fGB", disk.getFreeSize(1)));
                    pgbUsageDisk1.setValue(disk.getDiskPercent(1));
                }
            }
        };

        Timer timer = new Timer(1000, action);
        timer.start();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        onLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblRAM = new javax.swing.JLabel();
        lblRAM1 = new javax.swing.JLabel();
        lblRAMPercent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblCPU = new javax.swing.JLabel();
        lblCPU1 = new javax.swing.JLabel();
        lblCPUPercent = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        pgbUsageDisk1 = new javax.swing.JProgressBar();
        lblTotalSpaceDisk1 = new javax.swing.JLabel();
        lblFreeSpaceDisk1 = new javax.swing.JLabel();
        lblNameDisk1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblTotalSpaceDisk0 = new javax.swing.JLabel();
        lblFreeSpaceDisk0 = new javax.swing.JLabel();
        pgbUsageDisk0 = new javax.swing.JProgressBar();
        lblNameDisk0 = new javax.swing.JLabel();

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("STATUS DE FUNCIONAMENTO");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("FUNCIONANDO");

        jPanel12.setBackground(new java.awt.Color(0, 153, 153));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ver mais");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(50, 50, 50))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel15.setText("Maximum");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Monitoramento das maquinas de recargas no Terminal");
        setBackground(new java.awt.Color(0, 0, 0));
        setLocation(new java.awt.Point(150, 120));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(38, 38, 38));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(29, 29, 32));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("STATUS DE FUNCIONAMENTO");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        onLabel.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        onLabel.setForeground(new java.awt.Color(0, 153, 153));
        onLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        onLabel.setText("ONLINE");
        jPanel3.add(onLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 240, 54));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 200, 10));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 153, 153));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Site");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 70, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Dashboard");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 80, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 153, 153));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Github");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 80, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 440));

        jPanel5.setBackground(new java.awt.Color(29, 29, 32));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Memoria");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Utilizado");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Disponível");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        lblRAM.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblRAM.setForeground(new java.awt.Color(0, 153, 153));
        lblRAM.setText("0.00 GB");
        jPanel5.add(lblRAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lblRAM1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblRAM1.setForeground(new java.awt.Color(0, 153, 153));
        lblRAM1.setText("0.00 GB");
        jPanel5.add(lblRAM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        lblRAMPercent.setFont(new java.awt.Font("Ubuntu", 1, 60)); // NOI18N
        lblRAMPercent.setForeground(new java.awt.Color(255, 255, 255));
        lblRAMPercent.setText("100.0%");
        jPanel5.add(lblRAMPercent, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 370, 220));

        jPanel4.setBackground(new java.awt.Color(29, 29, 32));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CPU");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 21, -1, -1));

        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Média");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 55, -1, -1));

        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Máximo");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        lblCPU.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblCPU.setForeground(new java.awt.Color(0, 153, 153));
        lblCPU.setText("0,00 GHz");
        jPanel4.add(lblCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lblCPU1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblCPU1.setForeground(new java.awt.Color(0, 153, 153));
        lblCPU1.setText("0,00 GHz");
        jPanel4.add(lblCPU1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 40));

        lblCPUPercent.setFont(new java.awt.Font("Ubuntu", 1, 60)); // NOI18N
        lblCPUPercent.setForeground(new java.awt.Color(255, 255, 255));
        lblCPUPercent.setText("100.0%");
        jPanel4.add(lblCPUPercent, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 410, 220));

        jPanel7.setBackground(new java.awt.Color(29, 29, 32));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Disco Externo");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setText("Disk 2");
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setText("Nome:");
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 204, 204));
        jLabel31.setText("Espaço Total:");
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(204, 204, 204));
        jLabel32.setText("Espaço Livre:");
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        pgbUsageDisk1.setBackground(new java.awt.Color(62, 62, 62));
        pgbUsageDisk1.setForeground(new java.awt.Color(0, 153, 153));
        pgbUsageDisk1.setBorderPainted(false);
        jPanel7.add(pgbUsageDisk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 230, 30));

        lblTotalSpaceDisk1.setForeground(new java.awt.Color(0, 153, 153));
        lblTotalSpaceDisk1.setText("0");
        jPanel7.add(lblTotalSpaceDisk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 130, -1));

        lblFreeSpaceDisk1.setForeground(new java.awt.Color(0, 153, 153));
        lblFreeSpaceDisk1.setText("0");
        jPanel7.add(lblFreeSpaceDisk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 130, -1));

        lblNameDisk1.setForeground(new java.awt.Color(0, 153, 153));
        lblNameDisk1.setText(":");
        jPanel7.add(lblNameDisk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 76, 200, 20));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 270, 210));

        jPanel8.setBackground(new java.awt.Color(29, 29, 32));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Configuração");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Tema Branco");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 140, 50));

        jPanel8.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, 190, 50));

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Processos");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 190, -1));

        jPanel16.setBackground(new java.awt.Color(0, 153, 153));
        jPanel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Sistema");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(50, 50, 50))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, -1));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 240, 210, 210));

        jPanel11.setBackground(new java.awt.Color(29, 29, 32));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 21, -1, -1));

        jLabel11.setBackground(new java.awt.Color(46, 98, 98));
        jLabel11.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("MachineTech Corporation© 2020 desing by: MachineTech & Source Company");
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 1070, 60));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 1070, 60));

        jPanel9.setBackground(new java.awt.Color(29, 29, 32));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Disco Local");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("Disk 1");
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setText("Nome:");
        jPanel9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setText("Espaço Total:");
        jPanel9.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 204, 204));
        jLabel28.setText("Espaço Livre:");
        jPanel9.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        lblTotalSpaceDisk0.setForeground(new java.awt.Color(0, 153, 153));
        lblTotalSpaceDisk0.setText("0");
        jPanel9.add(lblTotalSpaceDisk0, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 130, -1));

        lblFreeSpaceDisk0.setForeground(new java.awt.Color(0, 153, 153));
        lblFreeSpaceDisk0.setText("0");
        jPanel9.add(lblFreeSpaceDisk0, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 90, -1));

        pgbUsageDisk0.setBackground(new java.awt.Color(62, 62, 62));
        pgbUsageDisk0.setForeground(new java.awt.Color(0, 153, 153));
        pgbUsageDisk0.setBorderPainted(false);
        jPanel9.add(pgbUsageDisk0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 250, 30));

        lblNameDisk0.setForeground(new java.awt.Color(0, 153, 153));
        lblNameDisk0.setText(":");
        jPanel9.add(lblNameDisk0, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 76, 220, 20));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 290, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
       
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("file:///C:/Users/aluga.com/Desktop/repositorio/grupo-06-adsa-20201/MachineTech-%20Web%20site%20Responsivo/MachineTech-%20Web%20site%20Responsivo/Site/index.html"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(TemaPreto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TemaPreto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("não foi posivel acesar o site");
            JOptionPane.showMessageDialog(null, "não foi posivel acesar o site", "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);

        } 
      


    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("file:///C:/Users/aluga.com/Desktop/repositorio/grupo-06-adsa-20201/MachineTech-%20Web%20site%20Responsivo/MachineTech-%20Web%20site%20Responsivo/Site/login.html"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(TemaPreto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://github.com/BandTec/grupo-06-adsa-20201"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(TemaPreto.class.getName()).log(Level.SEVERE, null, ex);
                    }    }//GEN-LAST:event_jLabel23MouseClicked

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        JFrame frame = new JFrame();
        frame.setContentPane(new Info());
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        {
            JFrame frame = new JFrame();
            frame.setContentPane(new Processes());
            frame.pack();
            frame.setVisible(true);
                    }     }//GEN-LAST:event_jPanel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        JFrame frame = new JFrame();
        frame.setContentPane(new Processes());
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        new TemaBranco().setVisible(true);
        dispose();
        

    }//GEN-LAST:event_jPanel2MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        new TemaBranco().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel22MouseClicked
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TemaPreto().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCPU;
    private javax.swing.JLabel lblCPU1;
    private javax.swing.JLabel lblCPUPercent;
    private javax.swing.JLabel lblFreeSpaceDisk0;
    private javax.swing.JLabel lblFreeSpaceDisk1;
    private javax.swing.JLabel lblNameDisk0;
    private javax.swing.JLabel lblNameDisk1;
    private javax.swing.JLabel lblRAM;
    private javax.swing.JLabel lblRAM1;
    private javax.swing.JLabel lblRAMPercent;
    private javax.swing.JLabel lblTotalSpaceDisk0;
    private javax.swing.JLabel lblTotalSpaceDisk1;
    private javax.swing.JLabel onLabel;
    private javax.swing.JProgressBar pgbUsageDisk0;
    private javax.swing.JProgressBar pgbUsageDisk1;
    // End of variables declaration//GEN-END:variables
}
