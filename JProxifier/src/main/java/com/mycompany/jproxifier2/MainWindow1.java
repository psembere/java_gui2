/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.jproxifier2;

import com.jproxifier.controller.DownloadTableModel;
import com.jproxifier.controller.PluginTableModel;
import com.jproxifier.controller.RadioButtonRenderer;
import com.jproxifier.controller.RadioButtonEditor;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;



/**
 *
 * @author azochniak
 */
public class MainWindow1 extends JFrame /*JRibbonFrame*/ {

    /**
     * Creates new form MainWindow
     */
    DownloadTableModel model = new DownloadTableModel();
    public MainWindow1() {
        initComponents();
        //setSize(600, 400); //use preffered size instead.
        setTitle("JProxifier by AZ & PS - PWr 2014");
//        setLocationRelativeTo(null); //Center window in both axises.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment()
        .getMaximumWindowBounds();
        //setPreferredSize(new Dimension(r.width, r.height / 2));
        //setMinimumSize(new Dimension(r.width / 10, r.height / 2));
        pack();
        //setLocation(r.x, r.y);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        initRibbon();
        initTabs();

    }
         
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
    public void setDownloadingTable() {
       
        jTableDownloading.setModel(model);
        TableColumn column = null;
        for (int i = 0; i < 8; i++) {
            column = jTableDownloading.getColumnModel().getColumn(i);
            switch(i) {
                case 0:
                    column.setPreferredWidth(60);
                    break;
                case 1:                  
                    column.setPreferredWidth(140);
                    break;
                case 2:                  
                    column.setPreferredWidth(140);
                    break;
                case 3:                  
                    column.setPreferredWidth(80);
                    break;
                case 4:                                                                  
                    column.setPreferredWidth(70);
                    break;
                case 5:                                                                  
                    column.setPreferredWidth(50);
                    break;
                case 6:                                                                  
                    column.setPreferredWidth(60);
                    break;    
                case 7:                                                                  
                    column.setPreferredWidth(35);                 
                    break;  
                    
            }
        }
        //ButtonGroup group1 = new ButtonGroup();
        //group1.add((JRadioButton) jTableDownloading.getValueAt(0, 6));
        //group1.add((JRadioButton) jTableDownloading.getValueAt(0, 7));
        
    
        jTableDownloading.getColumnModel().getColumn(6).setCellRenderer(new RadioButtonRenderer());
        jTableDownloading.getColumnModel().getColumn(6).
                setCellEditor( new RadioButtonEditor(new JCheckBox()));
        jTableDownloading.getColumnModel().getColumn(7).setCellRenderer(new RadioButtonRenderer());
        jTableDownloading.getColumnModel().getColumn(7).
                setCellEditor( new RadioButtonEditor(new JCheckBox()));
        
        int val=model.getData().get(0).getProgress();
        jProgressBarDownload.setValue(val);
        //System.out.println(rowS);
            
        jTableDownloading.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            int rowS = jTableDownloading.getSelectedRow();
            int val=model.getData().get(rowS).getProgress();
            jProgressBarDownload.setValue(val);
            }
        });
       jTextFieldSearch.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) {
          //warn();
         //System.out.println("update");
        }
        public void removeUpdate(DocumentEvent e) {
          //System.out.println("remove");
        }
        public void insertUpdate(DocumentEvent e) {
          //System.out.println("insert");
        }
        
      });
        
        
                    
    }
    public void setPluginTable() {

        jTablePlugins.setModel(new PluginTableModel());       

        //JScrollPane scrollPane = new JScrollPane(jTablePlugins);
        //Add the scroll pane to this panel.
        //jTablePlugins.add(scrollPane);
        
    }
    public void setDowloadingTab() {
        setDownloadingTable();
       
    }
    public void initTabs() {
          
        setDowloadingTab();
        setPluginTable();
//        URL res = MainWindow.class.getResource("downloadall.gif");
        
        //ImageIcon icon = resizeIcon(new ImageIcon(res), 48/2, 48/2);
        //ImageIcon icon = new ImageIcon(res);
        //System.out.println(MainWindow.class.getResource("/downloadall.gif"));
        //ImageIcon icon = new ImageIcon(res);
//        JComponent panel1 = makeTextPanel("Panel #1");
//        JTabbedPane tabbedPane = jTabbedPane1;
        
//        tabbedPane.addTab("Tab 1", icon, panel1, "Does nothing");
//        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

//        JComponent panel2 = makeTextPanel("Panel #2");
//        tabbedPane.addTab("Tab 2", icon, panel2, "Does twice as much nothing");
//        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDownloading = new javax.swing.JTable();
        jProgressBarDownload = new javax.swing.JProgressBar();
        jTextFieldSearch = new javax.swing.JTextField();
        jPanelStartStopPanel = new javax.swing.JPanel();
        jButtonStartAll = new javax.swing.JButton();
        jButtonStopAll = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePlugins = new javax.swing.JTable();
        jSliderButton = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(600, 400));

        jTableDownloading.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane2.setViewportView(jTableDownloading);

        jTextFieldSearch.setText("search");

        jPanelStartStopPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Control"));

        jButtonStartAll.setText("Start all");

        jButtonStopAll.setText("Stop all");

        javax.swing.GroupLayout jPanelStartStopPanelLayout = new javax.swing.GroupLayout(jPanelStartStopPanel);
        jPanelStartStopPanel.setLayout(jPanelStartStopPanelLayout);
        jPanelStartStopPanelLayout.setHorizontalGroup(
            jPanelStartStopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStartStopPanelLayout.createSequentialGroup()
                .addComponent(jButtonStartAll, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStopAll)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelStartStopPanelLayout.setVerticalGroup(
            jPanelStartStopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStartStopPanelLayout.createSequentialGroup()
                .addGroup(jPanelStartStopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStopAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonStartAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(348, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jProgressBarDownload, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jScrollPane2)
            .addComponent(jPanelStartStopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelStartStopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBarDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane.addTab("Downloading", jPanel1);

        jScrollPane1.setViewportView(jTree1);

        jLabel2.setText("Here you can drag&drop files in order to group");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("File duplicates", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("File auto-grouping", jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Speed chart", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Settings", jPanel5);

        jTablePlugins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane3.setViewportView(jTablePlugins);
        if (jTablePlugins.getColumnModel().getColumnCount() > 0) {
            jTablePlugins.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Plugins", jPanel6);

        jSliderButton.setMaximum(1);

        jLabel1.setText("Override system's proxy");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSliderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jSliderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane))
        );

        setSize(new java.awt.Dimension(596, 455));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String s =jTextFieldSearch.getText();     
        for( int i=0; i<model.getData().size();i++) {
            if(model.getData().get(i).filename.equals(s)) {
                jTableDownloading.clearSelection();
                jTableDownloading.addRowSelectionInterval(i,i);
                int val=model.getData().get(i).getProgress();
                jProgressBarDownload.setValue(val);
                break;
            }          
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonStartAll;
    private javax.swing.JButton jButtonStopAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelStartStopPanel;
    private javax.swing.JProgressBar jProgressBarDownload;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSliderButton;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTableDownloading;
    private javax.swing.JTable jTablePlugins;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

    private ImageIcon resizeIcon(ImageIcon imageIcon, int imageW, int imageH) {
        Image img = imageIcon.getImage();  
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);  
        Graphics g = bi.createGraphics();  
        g.drawImage(img, 10, 10, imageW, imageH, null, null);  
        ImageIcon newIcon = new ImageIcon(bi);
        return newIcon;
    }
}
