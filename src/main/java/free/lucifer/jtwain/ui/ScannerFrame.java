/*
 * Copyright 2018 (c) Denis Andreev (lucifer).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package free.lucifer.jtwain.ui;

import free.lucifer.jtwain.Twain;
import free.lucifer.jtwain.TwainCapability;
import free.lucifer.jtwain.TwainIOMetadata;
import free.lucifer.jtwain.TwainListener;
import free.lucifer.jtwain.TwainScanner;
import free.lucifer.jtwain.TwainSource;
import free.lucifer.jtwain.exceptions.TwainException;
import free.lucifer.jtwain.ui.FlowPanel;
import free.lucifer.jtwain.ui.ImageComponent;
import free.lucifer.jtwain.ui.ScannerDefaultsFrame;
import free.lucifer.jtwain.variable.TwainArray;
import free.lucifer.jtwain.variable.TwainOneValue;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author lucifer
 */
public class ScannerFrame extends javax.swing.JFrame {

    /**
     * Creates new form ScannerFrame
     */
    public ScannerFrame() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        scanners = new javax.swing.JList<>();
        selectScanner = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        docSource = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        colorMode = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        dpi = new javax.swing.JComboBox<>();
        startScanning = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane(fp = new FlowPanel());
        cancelButton = new javax.swing.JButton();
        getCapList = new javax.swing.JButton();
        scanWithDefaultUI = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Сканеры");

        DefaultListModel<String> s = new DefaultListModel<>();
        scanners.setModel(s);
        try {
            for(String t : TwainSource.getProductNames()) {
                s.add(0, t);
            }
        } catch(Throwable e) {

        }
        jScrollPane1.setViewportView(scanners);

        selectScanner.setText("Выбрать сканер");
        selectScanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectScannerActionPerformed(evt);
            }
        });

        jLabel2.setText("Источник");

        docSource.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auto document feeder", "Flatbed" }));
        docSource.setEnabled(false);
        docSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docSourceActionPerformed(evt);
            }
        });

        jLabel3.setText("Режим цвета");

        colorMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Черно-белый", "Градации серого", "Цветной" }));
        colorMode.setEnabled(false);
        colorMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorModeActionPerformed(evt);
            }
        });

        jLabel4.setText("DPI");

        dpi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "50", "100", "150", "200", "300", "400", "500", "600" }));
        dpi.setEnabled(false);

        startScanning.setText("Сканировать");
        startScanning.setEnabled(false);
        startScanning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startScanningActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(BorderFactory.createBevelBorder(0));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        cancelButton.setText("Отмена");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        getCapList.setText("Прочитать таблицу настроек");
        getCapList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getCapListActionPerformed(evt);
            }
        });

        scanWithDefaultUI.setText("Не использовать системный UI");
        scanWithDefaultUI.setEnabled(false);
        scanWithDefaultUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanWithDefaultUIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(docSource, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(colorMode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startScanning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectScanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getCapList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(scanWithDefaultUI))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectScanner)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getCapList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(docSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startScanning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scanWithDefaultUI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectScannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectScannerActionPerformed
        String val = scanners.getSelectedValue();
        if (val == null) {
            return;
        }

        try {
            TwainScanner.getScanner().select(val);

            TwainSource ts = Twain.getSourceManager().selectSource(val);

            ts.open();
            ts.setState(4);

            if (!ts.isDeviceOnline()) {
                System.out.println("Device is not online");
                JOptionPane.showMessageDialog(this, "Устройство не в онлайне !!!", "TWAIN", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {

                TwainCapability tc = ts.getCapability(Twain.ICAP_XRESOLUTION);
                DefaultComboBoxModel<String> s = new DefaultComboBoxModel<>();
                for (Object t : tc.getItems()) {
                    s.addElement(String.format("%.0f", t));
                }
                dpi.setModel(s);

                tc = ts.getCapability(Twain.ICAP_PIXELTYPE);
                s = new DefaultComboBoxModel<>();
                for (Object t : tc.getItems()) {
                    String c = "Неизвестно";
                    int y = (Integer) t;
                    switch (y) {
                        case 0:
                            c = "Черно-белый";
                            break;
                        case 1:
                            c = "Градации серого";
                            break;
                        case 2:
                            c = "Цветной";
                            break;
                    }
                    s.addElement(String.format("%s", c));
                }

                colorMode.setModel(s);

                ts.setCapability(Twain.CAP_FEEDERENABLED, 1);

                s = new DefaultComboBoxModel<>();
                if (ts.getCapability(Twain.CAP_FEEDERENABLED).intValue() == 1) {
                    s.addElement("Auto document feeder");
                }
                s.addElement("Flatbed");

                docSource.setModel(s);
            } finally {
                ts.close();
                ts.setState(3);
            }

//            if (!TwainScanner.getScanner().getMetadata().getSource().isDeviceOnline()) {
//                System.out.println("Device is not online: " + val);
//                return;
//            }
            scanners.setEnabled(false);
            getCapList.setEnabled(false);
            selectScanner.setEnabled(false);
            scanWithDefaultUI.setEnabled(true);

            boolean set = scanWithDefaultUI.getSelectedObjects() != null;
            dpi.setEnabled(set);
            colorMode.setEnabled(set);
            docSource.setEnabled(set);

            startScanning.setEnabled(true);
            cancelButton.setEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_selectScannerActionPerformed

    private void docSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docSourceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docSourceActionPerformed

    private void colorModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colorModeActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Twain.done();
    }//GEN-LAST:event_formWindowClosed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        scanners.setEnabled(true);
        selectScanner.setEnabled(true);
        getCapList.setEnabled(true);

        scanWithDefaultUI.setEnabled(false);
        dpi.setEnabled(false);
        colorMode.setEnabled(false);
        docSource.setEnabled(false);

        startScanning.setEnabled(false);
        cancelButton.setEnabled(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

//    TwainScanner scanner;
    private void dumpCapatibilites(TwainSource ts) throws TwainException {
        Map<Integer, String> t = Twain.getMapCapCodeToName();

        TwainCapability[] tt = ts.getCapabilities();

        for (TwainCapability tc : tt) {
            if (tc.getCurrent() instanceof TwainArray) {
                Object c = null;
                Object d = null;
                try {
                    d = tc.getCurrent().getDefaultValue();
                } catch (Exception e) {
                }
                try {
                    c = tc.getCurrent().getCurrentValue();
                } catch (Exception e) {
                }

                System.out.println(String.format("%-10s %5x %5s %5s", t.get(tc.cap), tc.cap, d, c));

            } else {

                int d = -1;
                int c = -1;

                try {
                    d = tc.intDefaultValue();
                } catch (Exception e) {
                }
                try {
                    c = tc.intDefaultValue();
                } catch (Exception e) {
                }
                System.out.println(String.format("%-10s %5x %5d %5d", t.get(tc.cap), tc.cap, d, c));
            }
        }

    }
    private void startScanningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startScanningActionPerformed
        scanWithDefaultUI.setEnabled(false);
        cancelButton.setEnabled(false);
        startScanning.setEnabled(false);
        dpi.setEnabled(false);
        colorMode.setEnabled(false);
        docSource.setEnabled(false);
        try {
            final TwainScanner scanner = TwainScanner.getScanner();

            scanner.addListener(new TwainListener() {
                @Override
                public void update(TwainIOMetadata.Type type, TwainIOMetadata metadata) {
//                    System.out.println(type + " -> " + metadata.getState());
                    if (type == TwainIOMetadata.EXCEPTION) {
                        scanWithDefaultUI.setEnabled(true);
                        cancelButton.setEnabled(true);
                        startScanning.setEnabled(true);
                        boolean set = scanWithDefaultUI.getSelectedObjects() != null;
                        dpi.setEnabled(set);
                        colorMode.setEnabled(set);
                        docSource.setEnabled(set);
                        metadata.getException().printStackTrace();
                        return;
                    }
                    if (type == TwainIOMetadata.NEGOTIATE && metadata.getState() == 4) {

                        TwainSource ts = metadata.getSource();
                        ts.setXferMech(Twain.TWSX_NATIVE);
                        try {

                            if (ts.isUIControllable()) {
                                ts.setShowUI(scanWithDefaultUI.getSelectedObjects() == null);
                            } else {
//                                ts.setShowUI(true);
                            }

                            try {
                                ts.setShowProgressBar(true);
                            } catch (Exception e) {
                            }

                            fp.removeAll();
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    jScrollPane2.updateUI();
                                }
                            });

                            if (scanWithDefaultUI.getSelectedObjects() != null) {
                                ts.setResolution(Double.parseDouble((String) dpi.getSelectedItem()));

                                switch (colorMode.getSelectedIndex()) {
                                    case 0:
                                        ts.setCapability(Twain.ICAP_PIXELTYPE, 0);
                                        break;
                                    case 1:
                                        ts.setCapability(Twain.ICAP_PIXELTYPE, 1);
                                        break;
                                    case 2:
                                        ts.setCapability(Twain.ICAP_PIXELTYPE, 2);
                                        break;
                                }

                                if (docSource.getModel().getSize() > 1) {

                                    switch (docSource.getSelectedIndex()) {
                                        case 0:
                                            ts.setCapability(Twain.CAP_FEEDERENABLED, true);
                                            break;
                                        case 1:
                                            ts.setCapability(Twain.CAP_FEEDERENABLED, false);
                                            break;
                                    }
                                } else {
                                    ts.setCapability(Twain.CAP_FEEDERENABLED, false);
                                }
                            }
                        } catch (Exception e) {
                            cancelButton.setEnabled(true);
                            startScanning.setEnabled(true);
                            scanWithDefaultUI.setEnabled(true);
                            boolean set = scanWithDefaultUI.getSelectedObjects() != null;
                            dpi.setEnabled(set);
                            colorMode.setEnabled(set);
                            docSource.setEnabled(set);

                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            PrintStream ps = new PrintStream(baos);

                            e.printStackTrace(ps);

                            ps.flush();

                            for (String t : new String(baos.toByteArray()).split("\n")) {
                                JLabel text = new JLabel(t);

                                fp.add(text);
                            }
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    jScrollPane2.updateUI();
                                }
                            });

                            scanner.removeListener(this);
                            ts.setCancel(true);
                        }
                    }
                    boolean finish = false;

                    if (type == TwainIOMetadata.MEMORY) {
                        finish = true;
//                        metadata.getMemory().
                    }
                    if (type == TwainIOMetadata.ACQUIRED && metadata.getState() == 7) {
                        finish = true;
                    }
                    if (finish) {
                        final BufferedImage img = metadata.getImage();
                        metadata.setImage(null);

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                ImageComponent im = new ImageComponent(210, 290);
                                im.drawScaledImage(img);
                                try {
                                    File f = File.createTempFile("scan", ".png");
                                    try (ImageOutputStream ios = new FileImageOutputStream(f)) {
                                        ImageIO.write(img, "PNG", ios);
                                    }
                                    im.setFileName(f.getAbsolutePath());
                                } catch (Exception e) {

                                }
                                im.applyFile();
                                fp.add(im);
                                jScrollPane2.updateUI();
                            }
                        });
                    }

                    if (type == TwainIOMetadata.STATECHANGE && metadata.getState() == 3) {
                        boolean set = !metadata.getSource().isBusy();
                        if (set) {
                            cancelButton.setEnabled(set);
                            startScanning.setEnabled(set);
                            scanWithDefaultUI.setEnabled(set);
                            set = scanWithDefaultUI.getSelectedObjects() != null;
                            dpi.setEnabled(set);
                            colorMode.setEnabled(set);
                            docSource.setEnabled(set);
                        }
                    }
                }
            });

            scanner.select(scanners.getSelectedValue());
            scanner.acquire();

        } catch (Exception e) {
            e.printStackTrace();
            cancelButton.setEnabled(true);
            startScanning.setEnabled(true);
        }

    }//GEN-LAST:event_startScanningActionPerformed

    private void getCapListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getCapListActionPerformed
        String val = scanners.getSelectedValue();
        if (val == null) {
            return;
        }

        try {
            TwainScanner.getScanner().select(val);

            TwainSource ts = Twain.getSourceManager().selectSource(val);

            JDialog f = new ScannerDefaultsFrame(this, ts);
            f.pack();
            f.setVisible(true);

        } catch (TwainException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_getCapListActionPerformed

    private void scanWithDefaultUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanWithDefaultUIActionPerformed
        boolean set = scanWithDefaultUI.getSelectedObjects() != null;
        dpi.setEnabled(set);
        colorMode.setEnabled(set);
        docSource.setEnabled(set);
    }//GEN-LAST:event_scanWithDefaultUIActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> colorMode;
    private javax.swing.JComboBox<String> docSource;
    private javax.swing.JComboBox<String> dpi;
    private javax.swing.JButton getCapList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox scanWithDefaultUI;
    private javax.swing.JList<String> scanners;
    private javax.swing.JButton selectScanner;
    private javax.swing.JButton startScanning;
    // End of variables declaration//GEN-END:variables

    private FlowPanel fp;
}
