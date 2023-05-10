/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package monumentossoftware.interfaces.login;
import java.awt.Color;
import javax.swing.JOptionPane;
import monumentossoftware.objetcs.SQLite;
import monumentossoftware.objetcs.Utils;
import java.util.*;

public class FormRegister extends javax.swing.JFrame {
    public FormRegister() {
        initComponents();
        Utils.createGradientPanel(PanelGradient, new Color(186,79,84), new Color(255,204,102));
        Utils.setImageIcon("/images/icons/monumental-logo.png", LogoImage);
        Utils.setImageIcon("/images/icons/lock-icon.png", LockImage);
        Utils.setImageIcon("/images/icons/email-icon.png", EmailImage);
        Utils.setImageIcon("/images/icons/user-icon.png", NameImage);
        Utils.setImageIcon("/images/icons/lock-icon.png", LockImage1);
        TextPassword.setEchoChar('\0');
        TextConfirmPassword.setEchoChar('\0');
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LogoImage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        TextEmail = new javax.swing.JTextField();
        TextPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        LockImage = new javax.swing.JLabel();
        TextLogo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        EmailImage = new javax.swing.JLabel();
        TextName = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        NameImage = new javax.swing.JLabel();
        TextConfirmPassword = new javax.swing.JPasswordField();
        jSeparator4 = new javax.swing.JSeparator();
        LockImage1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PanelGradient = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));

        LogoImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/monumental-logo.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("SimSun", 1, 27)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("História Viva");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Já tem conta aqui? Faça login");

        jPanel6.setBackground(new java.awt.Color(255, 204, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel6.setOpaque(false);
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 204, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Login");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/cross-icon.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(LogoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(LogoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jPanel3.setBackground(new java.awt.Color(186, 79, 84));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextEmail.setBackground(new java.awt.Color(186, 79, 84));
        TextEmail.setBorder(null);
        TextEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextEmailFocusLost(evt);
            }
        });
        jPanel3.add(TextEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 215, 22));

        TextPassword.setBackground(new java.awt.Color(186, 79, 84));
        TextPassword.setBorder(null);
        TextPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextPasswordFocusLost(evt);
            }
        });
        jPanel3.add(TextPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 215, 22));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 210, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 210, 10));

        LockImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/lock-icon.png"))); // NOI18N
        jPanel3.add(LockImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 20, 20));

        TextLogo.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        TextLogo.setForeground(new java.awt.Color(255, 255, 255));
        TextLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextLogo.setText("Register");
        jPanel3.add(TextLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 190, 60));

        jPanel7.setBackground(new java.awt.Color(186, 79, 84));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel7.setOpaque(false);
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(186, 79, 84));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Register");
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        EmailImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/email-icon.png"))); // NOI18N
        jPanel3.add(EmailImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 20, 20));

        TextName.setBackground(new java.awt.Color(186, 79, 84));
        TextName.setBorder(null);
        TextName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextNameFocusLost(evt);
            }
        });
        jPanel3.add(TextName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 215, 22));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 210, 10));

        NameImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/user-icon.png"))); // NOI18N
        jPanel3.add(NameImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 20, 20));

        TextConfirmPassword.setBackground(new java.awt.Color(186, 79, 84));
        TextConfirmPassword.setBorder(null);
        TextConfirmPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextConfirmPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextConfirmPasswordFocusLost(evt);
            }
        });
        jPanel3.add(TextConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 215, 22));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 210, 10));

        LockImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/lock-icon.png"))); // NOI18N
        jPanel3.add(LockImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 20, 20));

        jLabel1.setText("Nome");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jLabel2.setText("Email");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel5.setText("Senha");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel8.setText("Confirmar senha");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        javax.swing.GroupLayout PanelGradientLayout = new javax.swing.GroupLayout(PanelGradient);
        PanelGradient.setLayout(PanelGradientLayout);
        PanelGradientLayout.setHorizontalGroup(
            PanelGradientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        PanelGradientLayout.setVerticalGroup(
            PanelGradientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(PanelGradient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PanelGradient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TextPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextPasswordFocusLost


    }//GEN-LAST:event_TextPasswordFocusLost

    private void TextPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextPasswordFocusGained
        if(TextPassword.getText().equals("Senha")) {
            TextPassword.setText("");
            TextPassword.setEchoChar('*');
        }

    }//GEN-LAST:event_TextPasswordFocusGained

    private void TextEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextEmailFocusLost


    }//GEN-LAST:event_TextEmailFocusLost

    private void TextEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextEmailFocusGained
        if(TextEmail.getText().equals("Email")) {
            TextEmail.setText("");
        }
    }//GEN-LAST:event_TextEmailFocusGained

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setBackground(new Color(186,79,84));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited

    }//GEN-LAST:event_jPanel6MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
            jLabel10.setBackground(new Color(255,204,102));
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        jPanel7.setBackground(new Color(186,79,84));
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered

    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        jPanel7.setBackground(Color.BLUE);
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jLabel10.setBackground(new Color(186,79,84));
    }//GEN-LAST:event_jLabel10MouseExited

    private void TextNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextNameFocusGained
        if(TextName.getText().equals("Nome")) {
            TextName.setText("");
        }
    }//GEN-LAST:event_TextNameFocusGained

    private void TextNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNameFocusLost

    private void TextConfirmPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextConfirmPasswordFocusGained
        if(TextConfirmPassword.getText().equals("Confirmar Senha")) {
            TextConfirmPassword.setText("");
            TextConfirmPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_TextConfirmPasswordFocusGained

    private void TextConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextConfirmPasswordFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TextConfirmPasswordFocusLost

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
        FormLogin formlogin = new FormLogin();
        formlogin.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
    String name = TextName.getText();
    String email = TextEmail.getText();
    char[] password = TextPassword.getPassword();
    char[] confirmpassword = TextConfirmPassword.getPassword();

    if(name.isEmpty() || email.isEmpty() || password.length == 0 || confirmpassword.length == 0) {
        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os dados", "Campos Vazios", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!Arrays.equals(password, confirmpassword)) {
        JOptionPane.showMessageDialog(null, "As senhas não são iguais!", "Senhas erradas", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if(!Utils.isValidEmail(email)) {
        JOptionPane.showMessageDialog(null, "Por favor, coloque um email válido", "Email inválido", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if(password.length < 5) {
        JOptionPane.showMessageDialog(null, "Por favor, crie uma senha com pelo menos 5 caracteres", "Senha inválida", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if(SQLite.emailExists(email)) {
        JOptionPane.showMessageDialog(null, "Esse email já foi registrado!", "Email em uso", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    SQLite.registerUser(name, email, new String(password), "visitante");
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setBackground(new Color(255,204,102));
    }//GEN-LAST:event_jLabel3MouseExited

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
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmailImage;
    private javax.swing.JLabel LockImage;
    private javax.swing.JLabel LockImage1;
    private javax.swing.JLabel LogoImage;
    private javax.swing.JLabel NameImage;
    private javax.swing.JPanel PanelGradient;
    private javax.swing.JPasswordField TextConfirmPassword;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JLabel TextLogo;
    private javax.swing.JTextField TextName;
    private javax.swing.JPasswordField TextPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
