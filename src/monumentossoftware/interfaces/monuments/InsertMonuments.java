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
import monumentossoftware.objetcs.Monuments;
import monumentossoftware.objetcs.Mysql;
import monumentossoftware.objetcs.User;
import org.jxmapviewer.viewer.GeoPosition;


public class InsertMonuments extends javax.swing.JFrame {
    
    public boolean changephoto = false;
    public File selectfilemain;
    ImageIcon defaultIconmonument = new ImageIcon(ViewMonument.class.getResource("/images/icons/monumental-logo.png"));

    public static GeoPosition loc;

    public InsertMonuments() {
        initComponents();
        Image imagemRedimensionada = defaultIconmonument.getImage().getScaledInstance(LabelPhotoMonument.getWidth(), LabelPhotoMonument.getHeight(), Image.SCALE_SMOOTH);
        LabelPhotoMonument.setIcon(new ImageIcon(imagemRedimensionada));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextTitle = new javax.swing.JTextField();
        LabelDesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextDesc = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        ComboEstado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        TextAno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TextLocal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        LabelPhotoMonument = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Inserir Monumento");

        jLabel2.setText("Titulo");

        LabelDesc.setText("Descrição");

        TextDesc.setColumns(20);
        TextDesc.setRows(5);
        jScrollPane1.setViewportView(TextDesc);

        jLabel3.setText("Estado");

        ComboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abandonado", "Recuperado", "Precisa ajuda" }));

        jLabel4.setText("Ano");

        jLabel5.setText("Local");

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/cross-icon.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LabelDesc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(TextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextAno)
                            .addComponent(TextLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabelPhotoMonument, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(LabelPhotoMonument, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelDesc)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Codigo para adicionar um monumento à base de dados
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String title = TextTitle.getText();
        String desc = TextDesc.getText();
        String year = TextAno.getText();
        String country = TextLocal.getText();
        String estado = (String) ComboEstado.getSelectedItem();
        //Verificar se algum campo é vazio
        if(title.isEmpty() || desc.isEmpty() || year.isEmpty() || country.isEmpty() || estado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Campos vazios!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Verificar se o utilizador logado é null
        if (User.user == null) {
            JOptionPane.showMessageDialog(null, "Ocorreu um problema interno, tente outra vez!", "User inválido", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }
        int owner = User.user.getId();
        //Verificar se as coordenadas são nulas
        if(loc.getLatitude() == 0.0 || loc.getLongitude() == 0.0) {
            JOptionPane.showMessageDialog(null, "Ocorreu um problema interno, tente outra vez!", "Loc inválida", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }
        //Pegar a imagem
        String base64Image = "";
        if(changephoto) {
            base64Image = ImagesAPI.encodeImageToBase64(selectfilemain);
        }
        //Retorna true se foi inserido com sucesso na base de dados
        if(Mysql.insertMonument(title, desc, country, estado, year, loc.getLatitude(), loc.getLongitude(), owner, base64Image)){
            //Atualiza o cache 
            System.out.println("Monumentos antes na lista é " + Monuments.monumentMap.size());
            AsyncUpdater.updateMonumentsInList();
            //Atualiza a lista dos marcadores
            MarkersAPI.loadMarkers(MapsAPI.view);
            System.out.println("Adicionado com sucesso!");
            dispose();
            System.out.println("Monumentos agora na lista é " + Monuments.monumentMap.size());
            return;
        }
        //Se não adicionou com sucesso o monumento à db
        JOptionPane.showMessageDialog(null, "Não foi possivel adicionar este monumento à base de dados", "Erro interno", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    //Codigo de inserir uma imagem
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Código alterar foto de perfil
        JFileChooser fileChooser = new JFileChooser();
        //Filtrar os arquivos para apenas extensões de imagens
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png"));
        int result = fileChooser.showOpenDialog(InsertMonuments.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile.isFile()) {
                        String fileName = selectedFile.getName();
                        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
                        if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("png")) {
                            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                                Image imagemRedimensionada = imageIcon.getImage().getScaledInstance(LabelPhotoMonument.getWidth(), LabelPhotoMonument.getHeight(), Image.SCALE_SMOOTH);
                                LabelPhotoMonument.setIcon(new ImageIcon(imagemRedimensionada));
                                if(!changephoto) changephoto = true;
                                selectfilemain = selectedFile;
                        } else {
                            // Não é uma imagem válida
                            JOptionPane.showMessageDialog(InsertMonuments.this, "O arquivo selecionado não é uma imagem válida.");
                        }
                    }
                    
                }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(InsertMonuments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertMonuments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertMonuments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertMonuments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertMonuments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboEstado;
    private javax.swing.JLabel LabelDesc;
    private javax.swing.JLabel LabelPhotoMonument;
    private javax.swing.JTextField TextAno;
    private javax.swing.JTextArea TextDesc;
    private javax.swing.JTextField TextLocal;
    private javax.swing.JTextField TextTitle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
