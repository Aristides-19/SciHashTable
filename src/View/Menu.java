package view;

import java.awt.Frame;

/**
 * Main Menu where the user can interact with the scientific summaries
 *
 * @author Arístides Pérez
 */
public class Menu extends javax.swing.JFrame {


    /**
     * Creates new form Menu
     *
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        titleBar = new javax.swing.JPanel();
        exitButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        helpButton = new javax.swing.JLabel();
        pathSep = new javax.swing.JSeparator();
        pathField = new javax.swing.JTextField();
        summaryAddButton = new javax.swing.JButton();
        keyWordSearchButton = new javax.swing.JButton();
        keyWordField = new javax.swing.JTextField();
        keyWordSep = new javax.swing.JSeparator();
        authorSearchButton = new javax.swing.JButton();
        analizeSummaryButton = new javax.swing.JButton();
        scrollSummaries = new javax.swing.JScrollPane();
        summariesList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Main.setBackground(new java.awt.Color(255, 255, 255));
        Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleBar.setBackground(new java.awt.Color(255, 255, 255));

        exitButton.setFont(new java.awt.Font("sansserif", 0, 22)); // NOI18N
        exitButton.setForeground(new java.awt.Color(51, 51, 51));
        exitButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitButton.setText("X");
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        minimizeButton.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        minimizeButton.setForeground(new java.awt.Color(51, 51, 51));
        minimizeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizeButton.setText("-");
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });

        helpButton.setFont(new java.awt.Font("sansserif", 0, 22)); // NOI18N
        helpButton.setForeground(new java.awt.Color(51, 51, 51));
        helpButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helpButton.setText("?");
        helpButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        helpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout titleBarLayout = new javax.swing.GroupLayout(titleBar);
        titleBar.setLayout(titleBarLayout);
        titleBarLayout.setHorizontalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 550, Short.MAX_VALUE)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        titleBarLayout.setVerticalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addGroup(titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(titleBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Main.add(titleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 40));

        pathSep.setBackground(new java.awt.Color(255, 255, 255));
        pathSep.setForeground(new java.awt.Color(0, 0, 0));
        Main.add(pathSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 260, 20));

        pathField.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        pathField.setText("Ruta del Resumen");
        pathField.setBorder(null);
        pathField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathFieldActionPerformed(evt);
            }
        });
        pathField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pathFieldKeyTyped(evt);
            }
        });
        Main.add(pathField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 260, 20));

        summaryAddButton.setBackground(new java.awt.Color(0, 51, 153));
        summaryAddButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        summaryAddButton.setForeground(new java.awt.Color(255, 255, 255));
        summaryAddButton.setText("Añadir Resumen");
        summaryAddButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        summaryAddButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        summaryAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summaryAddButtonActionPerformed(evt);
            }
        });
        Main.add(summaryAddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 260, 30));

        keyWordSearchButton.setBackground(new java.awt.Color(0, 51, 153));
        keyWordSearchButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        keyWordSearchButton.setForeground(new java.awt.Color(255, 255, 255));
        keyWordSearchButton.setText("Buscar por Palabra Clave");
        keyWordSearchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        keyWordSearchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        keyWordSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyWordSearchButtonActionPerformed(evt);
            }
        });
        Main.add(keyWordSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 260, 30));

        keyWordField.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        keyWordField.setText("Palabra Clave");
        keyWordField.setBorder(null);
        keyWordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyWordFieldActionPerformed(evt);
            }
        });
        keyWordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keyWordFieldKeyTyped(evt);
            }
        });
        Main.add(keyWordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 260, 20));

        keyWordSep.setBackground(new java.awt.Color(255, 255, 255));
        keyWordSep.setForeground(new java.awt.Color(0, 0, 0));
        Main.add(keyWordSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 260, 20));

        authorSearchButton.setBackground(new java.awt.Color(0, 51, 153));
        authorSearchButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        authorSearchButton.setForeground(new java.awt.Color(255, 255, 255));
        authorSearchButton.setText("Buscar por Autor");
        authorSearchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        authorSearchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        authorSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorSearchButtonActionPerformed(evt);
            }
        });
        Main.add(authorSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 260, 30));

        analizeSummaryButton.setBackground(new java.awt.Color(0, 51, 153));
        analizeSummaryButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        analizeSummaryButton.setForeground(new java.awt.Color(255, 255, 255));
        analizeSummaryButton.setText("Analizar Resumen");
        analizeSummaryButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        analizeSummaryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        analizeSummaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizeSummaryButtonActionPerformed(evt);
            }
        });
        Main.add(analizeSummaryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 260, 30));

        summariesList.setModel(dictionaryModel);
        scrollSummaries.setViewportView(summariesList);

        Main.add(scrollSummaries, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 260, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitButtonMouseClicked

    private void pathFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathFieldActionPerformed

    }//GEN-LAST:event_pathFieldActionPerformed

    private void pathFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pathFieldKeyTyped
        if (pathField.getText().equals("Ruta del Resumen")) {
            pathField.setText("");
        }
    }//GEN-LAST:event_pathFieldKeyTyped

    private void summaryAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summaryAddButtonActionPerformed

    }//GEN-LAST:event_summaryAddButtonActionPerformed

    private void helpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpButtonMouseClicked
        this.setVisible(false);
        Help helpGUI = new Help(this);
    }//GEN-LAST:event_helpButtonMouseClicked

    private void keyWordSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyWordSearchButtonActionPerformed

    }//GEN-LAST:event_keyWordSearchButtonActionPerformed

    private void keyWordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyWordFieldActionPerformed

    }//GEN-LAST:event_keyWordFieldActionPerformed

    private void keyWordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyWordFieldKeyTyped
        if (pathField.getText().equals("Palabra Clave")) {
            pathField.setText("");
        }
    }//GEN-LAST:event_keyWordFieldKeyTyped

    private void authorSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorSearchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorSearchButtonActionPerformed

    private void analizeSummaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizeSummaryButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_analizeSummaryButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Main;
    private javax.swing.JButton analizeSummaryButton;
    private javax.swing.JButton authorSearchButton;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel helpButton;
    private javax.swing.JTextField keyWordField;
    private javax.swing.JButton keyWordSearchButton;
    private javax.swing.JSeparator keyWordSep;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JTextField pathField;
    private javax.swing.JSeparator pathSep;
    private javax.swing.JScrollPane scrollSummaries;
    private javax.swing.JList<String> summariesList;
    private javax.swing.JButton summaryAddButton;
    private javax.swing.JPanel titleBar;
    // End of variables declaration//GEN-END:variables

}
