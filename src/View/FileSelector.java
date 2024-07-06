package view;

import java.awt.Frame;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;

/**
 * Launch Menu to let the user select the file with correct structure
 *
 * @author Arístides Pérez
 */
public class FileSelector extends javax.swing.JFrame {

    private File chosenFile;
    private int result;

    /**
     * Creates new form FileSelector
     */
    public FileSelector() {
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
        title = new javax.swing.JLabel();
        path = new javax.swing.JTextField();
        pathSep = new javax.swing.JSeparator();
        fileChoose = new javax.swing.JButton();
        continueButton = new javax.swing.JButton();
        minimizeButton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        titleBar = new javax.swing.JPanel();
        helpButton = new javax.swing.JLabel();
        exitButton1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Main.setBackground(new java.awt.Color(255, 252, 255));
        Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Consolas", 1, 25)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("¡Sube tu Archivo!");
        Main.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 260, 70));

        path.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        path.setText("Ruta del Archivo");
        path.setBorder(null);
        path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathActionPerformed(evt);
            }
        });
        path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pathKeyTyped(evt);
            }
        });
        Main.add(path, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 250, 20));

        pathSep.setBackground(new java.awt.Color(255, 255, 255));
        pathSep.setForeground(new java.awt.Color(0, 0, 0));
        Main.add(pathSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 280, 20));

        fileChoose.setBackground(new java.awt.Color(255, 110, 66));
        fileChoose.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fileChoose.setForeground(new java.awt.Color(255, 255, 255));
        fileChoose.setText("...");
        fileChoose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fileChoose.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fileChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooseActionPerformed(evt);
            }
        });
        Main.add(fileChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 30, 20));

        continueButton.setBackground(new java.awt.Color(255, 110, 66));
        continueButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        continueButton.setForeground(new java.awt.Color(255, 255, 255));
        continueButton.setText("Continuar");
        continueButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        continueButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });
        Main.add(continueButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 280, 30));

        minimizeButton.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        minimizeButton.setForeground(new java.awt.Color(51, 51, 51));
        minimizeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizeButton.setText("-");
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });
        Main.add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 30, 40));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icon.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(64, 64));
        jLabel1.setMinimumSize(new java.awt.Dimension(64, 64));
        jLabel1.setPreferredSize(new java.awt.Dimension(64, 64));
        Main.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 260, 260));

        titleBar.setBackground(new java.awt.Color(255, 255, 255));
        titleBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        helpButton.setFont(new java.awt.Font("sansserif", 0, 22)); // NOI18N
        helpButton.setForeground(new java.awt.Color(51, 51, 51));
        helpButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helpButton.setText("?");
        helpButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        helpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpButtonMouseClicked(evt);
            }
        });
        titleBar.add(helpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        exitButton1.setFont(new java.awt.Font("sansserif", 0, 22)); // NOI18N
        exitButton1.setForeground(new java.awt.Color(51, 51, 51));
        exitButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitButton1.setText("X");
        exitButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButton1MouseClicked(evt);
            }
        });
        titleBar.add(exitButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 40, 40));

        Main.add(titleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Verifies if the text file is correct, if true then calls Menu GUI with
     * the graph board
     *
     * @param evt
     */
    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed

        boolean success = true;

        if (success) {
            this.setVisible(false);
            Menu mainMenu = new Menu();
            mainMenu.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error: verifica que tu archivo "
                    + "no está vacío o la ruta es correcta, además de contener la estructura correcta");
        }
    }//GEN-LAST:event_continueButtonActionPerformed

    private void pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathActionPerformed
        continueButtonActionPerformed(evt);
    }//GEN-LAST:event_pathActionPerformed

    private void fileChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooseActionPerformed
        JFileChooser jf = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Texto (.txt)", "txt");
        jf.setAcceptAllFileFilterUsed(false);
        jf.addChoosableFileFilter(filter);

        result = jf.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            chosenFile = jf.getSelectedFile();
            path.setText(chosenFile.getAbsolutePath());
        }
    }//GEN-LAST:event_fileChooseActionPerformed

    private void helpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpButtonMouseClicked
        JOptionPane.showMessageDialog(this, "Las palabras que no tengan al menos "
                + "3 letras o tengan caracteres especiales no serán tomadas en cuenta");
    }//GEN-LAST:event_helpButtonMouseClicked

    private void pathKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pathKeyTyped
        if (path.getText().equals("Ruta del Archivo")) {
            path.setText("");
        }
    }//GEN-LAST:event_pathKeyTyped

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void exitButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButton1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitButton1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Main;
    private javax.swing.JButton continueButton;
    private javax.swing.JLabel exitButton1;
    private javax.swing.JButton fileChoose;
    private javax.swing.JLabel helpButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JTextField path;
    private javax.swing.JSeparator pathSep;
    private javax.swing.JLabel title;
    private javax.swing.JPanel titleBar;
    // End of variables declaration//GEN-END:variables
}
