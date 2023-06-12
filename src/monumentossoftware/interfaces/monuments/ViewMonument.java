
package monumentossoftware.interfaces.monuments;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import monumentossoftware.objetcs.AsyncUpdater;
import monumentossoftware.objetcs.ImagesAPI;
import monumentossoftware.objetcs.MapsAPI;
import monumentossoftware.objetcs.MarkersAPI;
import monumentossoftware.objetcs.Mysql;
import monumentossoftware.objetcs.User;
import monumentossoftware.objetcs.Utils;

public class ViewMonument extends javax.swing.JFrame {
    ImageIcon defaultIconuser = new ImageIcon(ViewMonument.class.getResource("/images/icons/userdefault.png"));
     ImageIcon defaultIconmonument = new ImageIcon(ViewMonument.class.getResource("/images/icons/monumental-logo.png"));
     public int idmonument;
     public int iduser;
     public static File selectfilemainmonument;
     int del = 0;
     boolean changePhoto = false;
     
     public void ReloadRating() {
         double a = Mysql.calculateAverageRatingForMonument(idmonument);
         LabelRating.setText(String.valueOf(a));
     }
     
     public void isRating() {
         if(!Mysql.hasUserRatedMonument(iduser, idmonument)) {
             TxtClassificar.setEditable(true);
         }
     }
    
    public ViewMonument(int id, String name, String year, String desc, String country, String photo, String username, String userdate, String descuser, String photouser, int id2, String monumentStatus) {
        initComponents();
        idmonument = id;
        iduser = id2;
        TextName.setText(name);
        TextYear.setText(year);
        TextDesc.setText(desc);
        TextCountry.setText(country);
        LabelUserName.setText(username);
        TextUserDesc.setText(descuser);
        LabelCriou.setText("Este utilizador é membro desde " + userdate);
        if (monumentStatus.equalsIgnoreCase("abandonado")) {
            ComboBox.setSelectedIndex(0);
        } else if (monumentStatus.equalsIgnoreCase("recuperado")) {
            ComboBox.setSelectedIndex(1);
        } else {
            ComboBox.setSelectedIndex(2);
        }
        isRating();
        ReloadRating();
        //Verifica se tem foto de perfil
        if(!photouser.equals("")) {
            defaultIconuser = ImagesAPI.decodeBase64(photouser);
        }
        //Verifica se o monumento tem foto
        if(!photo.equals("")) {
            defaultIconmonument = ImagesAPI.decodeBase64(photo);
        }
        Image imagemRedimensionada = defaultIconuser.getImage().getScaledInstance(LabelPhoto.getWidth(), LabelPhoto.getHeight(), Image.SCALE_SMOOTH);
        LabelPhoto.setIcon(new ImageIcon(imagemRedimensionada));
        Image imagemRedimensionada2 = defaultIconmonument.getImage().getScaledInstance(LabelPhotoMonument.getWidth(), LabelPhotoMonument.getHeight(), Image.SCALE_SMOOTH);
        LabelPhotoMonument.setIcon(new ImageIcon(imagemRedimensionada2));
        ButtonDel.setVisible(false);
        ButtonEdit.setVisible(false);
        ButtonChangePhoto.setVisible(false);
        ButtonDelPhoto.setVisible(false);
        if(iduser == User.user.getId()) {
            ButtonDel.setVisible(true);
            ButtonEdit.setVisible(true);
            ButtonDelPhoto.setVisible(true);
            ButtonChangePhoto.setVisible(true);
            TextYear.setEditable(true);
            TextDesc.setEditable(true);
            TextCountry.setEditable(true);
            TextName.setEditable(true);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextDesc = new javax.swing.JTextArea();
        TextYear = new javax.swing.JTextField();
        TextCountry = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextUserDesc = new javax.swing.JTextArea();
        LabelCriou = new javax.swing.JLabel();
        LabelUserPhoto = new javax.swing.JLabel();
        LabelUserName = new javax.swing.JLabel();
        LabelPhotoMonument = new javax.swing.JLabel();
        LabelPhoto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LabelRating = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TxtClassificar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ButtonEdit = new javax.swing.JButton();
        ButtonDel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        TextName = new javax.swing.JTextField();
        ButtonChangePhoto = new javax.swing.JButton();
        ButtonDelPhoto = new javax.swing.JButton();
        LabelStatus = new javax.swing.JLabel();
        ComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/cross-icon.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setText("Ano:");

        jLabel3.setText("Descrição:");

        jLabel4.setText("Country");

        TextDesc.setEditable(false);
        TextDesc.setColumns(20);
        TextDesc.setRows(5);
        jScrollPane1.setViewportView(TextDesc);

        TextYear.setEditable(false);

        TextCountry.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Informações monumentos:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("Informações utilizador");

        jLabel8.setText("Descrição");

        TextUserDesc.setColumns(20);
        TextUserDesc.setRows(5);
        TextUserDesc.setEnabled(false);
        jScrollPane2.setViewportView(TextUserDesc);

        LabelCriou.setText("Criou conta:");

        LabelUserName.setText("TextName");

        jLabel7.setText("Media de classificação");

        LabelRating.setText("null");

        jLabel10.setText("Classificar (0-5)");

        TxtClassificar.setEditable(false);

        jButton1.setText("Classificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ButtonEdit.setText("Guardar");
        ButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditActionPerformed(evt);
            }
        });

        ButtonDel.setText("Eliminar");
        ButtonDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDelActionPerformed(evt);
            }
        });

        jLabel9.setText("Nome:");

        TextName.setEditable(false);

        ButtonChangePhoto.setText("Alterar foto");
        ButtonChangePhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonChangePhotoActionPerformed(evt);
            }
        });

        ButtonDelPhoto.setText("Eliminar");
        ButtonDelPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDelPhotoActionPerformed(evt);
            }
        });

        LabelStatus.setText("Status:");

        ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abandonado", "Recuperado", "Precisa ajuda" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(LabelPhotoMonument, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ButtonChangePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonDelPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtClassificar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addContainerGap(465, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelRating, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonDel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(TextYear)
                            .addComponent(TextCountry, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(TextName)
                            .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LabelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelUserPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6))
                    .addComponent(LabelCriou, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(ButtonChangePhoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonDelPhoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(LabelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LabelUserPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(LabelStatus)
                                            .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(TextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(25, 25, 25)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(LabelCriou))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(TextYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(TextCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LabelUserName)
                                .addGap(203, 203, 203))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(LabelPhotoMonument, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(LabelRating)
                    .addComponent(ButtonEdit)
                    .addComponent(ButtonDel))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TxtClassificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!TxtClassificar.isEditable()) {
            JOptionPane.showMessageDialog(null, "Você já classificou este monumento!","Já classificou", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!Utils.isInteger(TxtClassificar.getText())) {
            JOptionPane.showMessageDialog(null, "Tem que colocar um inteiro!","Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int rate = Integer.parseInt(TxtClassificar.getText());
        if(rate > 5 || rate < 1) {
            JOptionPane.showMessageDialog(null, "Coloque dentro do intervalo [1,5]","Intervalo errado", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Mysql.rateMonument(iduser, idmonument, rate);
        JOptionPane.showMessageDialog(null, "Classificado com sucesso!","Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        TxtClassificar.setEditable(false);
        ReloadRating();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditActionPerformed
        String name = TextName.getText();
        String desc = TextDesc.getText();
        String country = TextCountry.getText();
        String year = TextYear.getText();
        String status = (String) ComboBox.getSelectedItem();
        if(name.isEmpty() || desc.isEmpty() || country.isEmpty() || year.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos vazios", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String base64Image;
        //Pegar a imagem
            if(del == 0 && changePhoto){
                base64Image = ImagesAPI.encodeImageToBase64(selectfilemainmonument);
            }else {
                base64Image = "";
            }
            if(Mysql.UpdateMonumentFields(idmonument, name, desc, country, status, year, base64Image, changePhoto)) {
                AsyncUpdater.monuments.getMonumentById(idmonument).updateFields(name, desc, country, status, year, base64Image, changePhoto);
            }
            changePhoto = false;
            JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_ButtonEditActionPerformed

    private void ButtonDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDelActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Você deseja eliminar este monumento?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            if(Mysql.deleteMonument(idmonument)) {
                //Remove o monumento do cache
                AsyncUpdater.monuments.removeMonument(idmonument);
                //Remove o marcador do monumento do cache
                MarkersAPI.DelMarker(idmonument);
                //Carrega os marcadores (para o eliminado desaparecer)
                MarkersAPI.loadMarkers(MapsAPI.view);
                //Fecha a form
                dispose();
            }
        }
    }//GEN-LAST:event_ButtonDelActionPerformed

    private void ButtonChangePhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChangePhotoActionPerformed
       //Código alterar foto de perfil
        JFileChooser fileChooser = new JFileChooser();
        //Filtrar os arquivos para apenas extensões de imagens
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png"));
        int result = fileChooser.showOpenDialog(ViewMonument.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile.isFile()) {
                        String fileName = selectedFile.getName();
                        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
                        if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("png")) {
                            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                                Image imagemRedimensionada = imageIcon.getImage().getScaledInstance(LabelPhotoMonument.getWidth(), LabelPhotoMonument.getHeight(), Image.SCALE_SMOOTH);
                                LabelPhotoMonument.setIcon(new ImageIcon(imagemRedimensionada));
                                if(!changePhoto) changePhoto = true;
                                selectfilemainmonument = selectedFile;
                                if(del == 1) del=0;
                        } else {
                            // Não é uma imagem válida
                            JOptionPane.showMessageDialog(ViewMonument.this, "O arquivo selecionado não é uma imagem válida.");
                        }
                    }
                    
                }
    }//GEN-LAST:event_ButtonChangePhotoActionPerformed

    private void ButtonDelPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDelPhotoActionPerformed
        ImageIcon imageIcon = new ImageIcon(ViewMonument.class.getResource("/images/icons/monumental-logo.png"));
        System.out.println("Apagou a foto!");
        Image imagemRedimensionada = imageIcon.getImage().getScaledInstance(LabelPhotoMonument.getWidth(), LabelPhotoMonument.getHeight(), Image.SCALE_SMOOTH);
        LabelPhotoMonument.setIcon(new ImageIcon(imagemRedimensionada));
        del = 1;
        if(!changePhoto) changePhoto = true;  
    }//GEN-LAST:event_ButtonDelPhotoActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMonument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMonument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMonument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMonument.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonChangePhoto;
    private javax.swing.JButton ButtonDel;
    private javax.swing.JButton ButtonDelPhoto;
    private javax.swing.JButton ButtonEdit;
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JLabel LabelCriou;
    private javax.swing.JLabel LabelPhoto;
    private javax.swing.JLabel LabelPhotoMonument;
    private javax.swing.JLabel LabelRating;
    private javax.swing.JLabel LabelStatus;
    private javax.swing.JLabel LabelUserName;
    private javax.swing.JLabel LabelUserPhoto;
    private javax.swing.JTextField TextCountry;
    private javax.swing.JTextArea TextDesc;
    private javax.swing.JTextField TextName;
    private javax.swing.JTextArea TextUserDesc;
    private javax.swing.JTextField TextYear;
    private javax.swing.JTextField TxtClassificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
