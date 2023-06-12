package monumentossoftware.interfaces.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Window;
import javax.swing.JFrame;
import monumentossoftware.objetcs.ImagesAPI;
import monumentossoftware.objetcs.MapsAPI;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

import monumentossoftware.interfaces.login.FormLogin;
import monumentossoftware.objetcs.Monuments;
import monumentossoftware.objetcs.User;
import monumentossoftware.objetcs.VisitedProfilers;
import monumentossoftware.objetcs.Mysql;
import java.util.Map;
import monumentossoftware.objetcs.VisitedProfile;
import monumentossoftware.objetcs.Monument;



public class FormMenu extends javax.swing.JFrame {
    ImageIcon defaultIcon = new ImageIcon(ImagesAPI.class.getResource("/images/icons/userdefault.png"));
    //Verificar se a foto foi alterada
    boolean changePhoto = false;
    //Guardar a foto alterada
    public static File selectfilemain;
    //Verificar se a foto foi eliminada, del=0 não foi, del=1 foi elimianada
    int del = 0;
    //Guardar o id do User logado para apresentar as informações
    int id = User.user.getId();
    //Map para guardar os ids dos Monumentos pesquisados, a cada pesquisa o Map é resetado para novos valores
    Map<Integer, Integer> idMap = new HashMap<>();
    //Instancia da classe MapsAPI para representar o mapa interativo
    MapsAPI maps = new MapsAPI();
    
    public FormMenu() {
        initComponents();
        //Form Maximizada
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    //Função de preencher com os dados do user

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelMap = new javax.swing.JTabbedPane();
        FormInicio = new javax.swing.JPanel();
        LabelPhoto = new javax.swing.JLabel();
        ButtonChange = new javax.swing.JButton();
        ButtonDel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TextNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextSobre = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        TextEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxCargo = new javax.swing.JComboBox<>();
        LabelData = new javax.swing.JLabel();
        ButtonSave = new javax.swing.JButton();
        FormShowMapp = new javax.swing.JPanel();
        PanelMapInteract = new javax.swing.JPanel();
        PanelSearchAll = new javax.swing.JPanel();
        PanelButtonSearch = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ComboSearchType = new javax.swing.JComboBox<>();
        TextSearchMonument = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMonuments = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelMap.setBackground(new java.awt.Color(255, 255, 255));
        PanelMap.setForeground(new java.awt.Color(153, 153, 0));

        FormInicio.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                FormInicioComponentShown(evt);
            }
        });

        ButtonChange.setText("Alterar foto");
        ButtonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonChangeActionPerformed(evt);
            }
        });

        ButtonDel.setText("Eliminar foto");
        ButtonDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDelActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Sobre");

        TextSobre.setColumns(20);
        TextSobre.setRows(5);
        jScrollPane1.setViewportView(TextSobre);

        jLabel4.setText("Email");

        jLabel5.setText("Cargo");

        ComboBoxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Visitante", "Explorador" }));

        LabelData.setText("DataCreated");

        ButtonSave.setText("Guardar");
        ButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FormInicioLayout = new javax.swing.GroupLayout(FormInicio);
        FormInicio.setLayout(FormInicioLayout);
        FormInicioLayout.setHorizontalGroup(
            FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormInicioLayout.createSequentialGroup()
                        .addComponent(LabelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ButtonChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonDel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(FormInicioLayout.createSequentialGroup()
                        .addGroup(FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FormInicioLayout.createSequentialGroup()
                                .addComponent(LabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                                .addComponent(ButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FormInicioLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(FormInicioLayout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextNome))
                                    .addGroup(FormInicioLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(FormInicioLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboBoxCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(FormInicioLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        FormInicioLayout.setVerticalGroup(
            FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormInicioLayout.createSequentialGroup()
                .addGroup(FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormInicioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FormInicioLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(ButtonChange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonDel)))
                .addGap(34, 34, 34)
                .addGroup(FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormInicioLayout.createSequentialGroup()
                        .addGroup(FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FormInicioLayout.createSequentialGroup()
                        .addGroup(FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ComboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addGroup(FormInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSave)
                    .addComponent(LabelData))
                .addGap(95, 95, 95))
        );

        PanelMap.addTab("Inicio", FormInicio);

        FormShowMapp.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                FormShowMappComponentShown(evt);
            }
        });

        javax.swing.GroupLayout PanelMapInteractLayout = new javax.swing.GroupLayout(PanelMapInteract);
        PanelMapInteract.setLayout(PanelMapInteractLayout);
        PanelMapInteractLayout.setHorizontalGroup(
            PanelMapInteractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );
        PanelMapInteractLayout.setVerticalGroup(
            PanelMapInteractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jLabel6.setText("Pesquisar por:");

        ComboSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Ano", "Localidade", "Top Ranking", " " }));

        jButton2.setText("Pesquisar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelButtonSearchLayout = new javax.swing.GroupLayout(PanelButtonSearch);
        PanelButtonSearch.setLayout(PanelButtonSearchLayout);
        PanelButtonSearchLayout.setHorizontalGroup(
            PanelButtonSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelButtonSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelButtonSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelButtonSearchLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(PanelButtonSearchLayout.createSequentialGroup()
                        .addComponent(TextSearchMonument)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        PanelButtonSearchLayout.setVerticalGroup(
            PanelButtonSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelButtonSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelButtonSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ComboSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(PanelButtonSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(TextSearchMonument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        TableMonuments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Localidade", "Ano", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableMonuments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMonumentsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableMonuments);

        jLabel7.setText("Visualizar Monumento: LeftClick");

        jLabel8.setText("Adicionar Monumento: RightClick");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout PanelSearchAllLayout = new javax.swing.GroupLayout(PanelSearchAll);
        PanelSearchAll.setLayout(PanelSearchAllLayout);
        PanelSearchAllLayout.setHorizontalGroup(
            PanelSearchAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSearchAllLayout.createSequentialGroup()
                .addComponent(PanelButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelSearchAllLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelSearchAllLayout.setVerticalGroup(
            PanelSearchAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSearchAllLayout.createSequentialGroup()
                .addComponent(PanelButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FormShowMappLayout = new javax.swing.GroupLayout(FormShowMapp);
        FormShowMapp.setLayout(FormShowMappLayout);
        FormShowMappLayout.setHorizontalGroup(
            FormShowMappLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FormShowMappLayout.createSequentialGroup()
                .addComponent(PanelSearchAll, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelMapInteract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FormShowMappLayout.setVerticalGroup(
            FormShowMappLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FormShowMappLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelMapInteract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(FormShowMappLayout.createSequentialGroup()
                .addComponent(PanelSearchAll, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelMap.addTab("Mapa", FormShowMapp);

        jPanel13.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Garamond", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("História Viva");

        jButton1.setText("Desconectar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMap)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelMap))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FormShowMappComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_FormShowMappComponentShown
    maps.loadMap();
    // Configurar o layout da FormShowMapp como BorderLayout
    FormShowMapp.setLayout(new BorderLayout());
    // Calcular a largura do PanelMapInteract como 80% da largura da FormShowMapp
    int panelWidth = (int) (FormShowMapp.getWidth() * 0.8);
    int panelHeight = FormShowMapp.getHeight();
    // Criar o PanelMapInteract com o layout BorderLayout
    PanelMapInteract.setLayout(new BorderLayout());
    // Definir a largura preferida do PanelMapInteract
    PanelMapInteract.setPreferredSize(new Dimension(panelWidth, panelHeight));
    // Adicionar o PanelMapInteract à FormShowMapp, na posição oeste (esquerda)
    FormShowMapp.add(PanelMapInteract, BorderLayout.EAST);
    // Adicionar o objeto view do MapsAPI ao PanelMapInteract
    PanelMapInteract.add(maps.view, BorderLayout.CENTER);
    // Criar o PanelSearchAll com o layout BorderLayout
    PanelSearchAll.setLayout(new BorderLayout());
    // Calcular a largura do PanelSearchAll como 20% da largura da FormShowMapp
    int searchPanelWidth = (int) (FormShowMapp.getWidth() * 0.2);
    // Definir a largura preferida do PanelSearchAll
    PanelSearchAll.setPreferredSize(new Dimension(searchPanelWidth, panelHeight));
    // Adicionar o PanelSearchAll à FormShowMapp, na posição leste (direita)
    FormShowMapp.add(PanelSearchAll, BorderLayout.WEST);
    // Criar o PanelButtonSearch e adicionar ao PanelSearchAll
    PanelSearchAll.add(PanelButtonSearch, BorderLayout.NORTH);
    // Criar o PanelListMonument e adicionar ao PanelSearchAll
    PanelSearchAll.add(jPanel2, BorderLayout.CENTER);
    // Redesenhar o FormShowMapp para atualizar o layout
    FormShowMapp.revalidate();
    FormShowMapp.repaint();
    }//GEN-LAST:event_FormShowMappComponentShown

    private void ButtonDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDelActionPerformed
        //Eliminar foto de perfil
        ImageIcon imageIcon = defaultIcon;
        Image imagemRedimensionada = imageIcon.getImage().getScaledInstance(LabelPhoto.getWidth(), LabelPhoto.getHeight(), Image.SCALE_SMOOTH);
        LabelPhoto.setIcon(new ImageIcon(imagemRedimensionada));
        del = 1;
        if(!changePhoto) changePhoto = true;   
    }//GEN-LAST:event_ButtonDelActionPerformed

    
    public void setLabel() {
    User currentUser = User.user;

    TextEmail.setText(currentUser.getEmail());
    TextNome.setText(currentUser.getName());
    TextSobre.setText(currentUser.getAbout());
    LabelData.setText("Esta conta foi criada em " + currentUser.getCreatedAtAsString());

    // Setar foto
    ImageIcon imageIcon = ImagesAPI.decodeBase64(currentUser.getPhoto());
    Image imagemRedimensionada = imageIcon.getImage().getScaledInstance(LabelPhoto.getWidth(), LabelPhoto.getHeight(), Image.SCALE_SMOOTH);
    LabelPhoto.setIcon(new ImageIcon(imagemRedimensionada));

    // Setar combo
    ComboBoxCargo.setSelectedIndex(currentUser.getRole().equalsIgnoreCase("visitante") ? 0 : 1);
}

    
    private void FormInicioComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_FormInicioComponentShown
        setLabel();
    }//GEN-LAST:event_FormInicioComponentShown

    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSaveActionPerformed
        if(TextNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Adicione um nome válido", "Nome vazio", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String name = TextNome.getText();
        String about = TextSobre.getText();
        String role = (String) ComboBoxCargo.getSelectedItem();
        String base64Image;
        
        //Pegar a imagem
            if(del == 0 && changePhoto){
                base64Image = ImagesAPI.encodeImageToBase64(selectfilemain);
            }else {
                base64Image = "";
            }
            //Retorna true se atualizou os dados do user na db com sucesso
            if(Mysql.UpdateUserFields(id, name, role, about, base64Image, changePhoto)) {
                //Atualizar o cache
                //Verificar se o user é o utilizador da aplicação, se sim atualizar os dados da classe User
                if(User.user.getId()== id) {
                    User.user.updateFields(name, about, role, base64Image, changePhoto);
                }
                //Atualiza a classe os utilizadores visitados
                VisitedProfilers profile = new VisitedProfilers();
                VisitedProfile profile1 = profile.getVisitedProfileById(id);
                profile1.updateFields(name, about, role, base64Image, changePhoto);
                
                //Atualiza o user logado
                User.user.updateFields(name, about, role, base64Image, changePhoto);
            }
            changePhoto = false;
            JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ButtonSaveActionPerformed

    private void ButtonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChangeActionPerformed
        //Código alterar foto de perfil
        JFileChooser fileChooser = new JFileChooser();
        //Filtrar os arquivos para apenas extensões de imagens
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png"));
        int result = fileChooser.showOpenDialog(FormMenu.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile.isFile()) {
                        String fileName = selectedFile.getName();
                        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
                        if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("png")) {
                            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                                Image imagemRedimensionada = imageIcon.getImage().getScaledInstance(LabelPhoto.getWidth(), LabelPhoto.getHeight(), Image.SCALE_SMOOTH);
                                LabelPhoto.setIcon(new ImageIcon(imagemRedimensionada));
                                if(!changePhoto) changePhoto = true;
                                selectfilemain = selectedFile;
                                if(del == 1) del=0;
                        } else {
                            // Não é uma imagem válida
                            JOptionPane.showMessageDialog(FormMenu.this, "O arquivo selecionado não é uma imagem válida.");
                        }
                    }
                    
                }
    }//GEN-LAST:event_ButtonChangeActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        int resposta = JOptionPane.showConfirmDialog(null, "Você deseja desconectar da sua conta?", "Deslogar", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            User.user.clearUser();
            
            // Fecha todas as janelas abertas
            Window[] janelasAbertas = Window.getWindows();
            for (Window janela : janelasAbertas) {
                if (janela instanceof JFrame) {
                janela.dispose();
                }
            }
            //Depois de fechar tudo, abre a login
            FormLogin login = new FormLogin();
            login.show();
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
            DefaultTableModel tableModel = (DefaultTableModel) TableMonuments.getModel();
        tableModel.setRowCount(0);
        if (!idMap.isEmpty()) {
            idMap.clear();
        }

        String selectedValue = ComboSearchType.getSelectedItem().toString();
        String searchTerm = TextSearchMonument.getText().toLowerCase();

        int rowIndex = 0;
        for (Monument monument : Monuments.monumentMap.values()) {
            boolean matchesSearch;

            if (selectedValue.equals("Nome")) {
                matchesSearch = monument.getName().toLowerCase().contains(searchTerm);
            } else if (selectedValue.equals("Ano")) {
                matchesSearch = monument.getYear().equalsIgnoreCase(searchTerm);
            } else if (selectedValue.equals("Localidade")) {
                matchesSearch = monument.getCountry().equalsIgnoreCase(searchTerm);
            } else {
                matchesSearch = false; // Tipo de pesquisa inválido
            }

            if (matchesSearch) {
                Object[] rowData = {
                        monument.getName(),
                        monument.getCountry(),
                        monument.getYear(),
                        monument.getStatus()
                };
                TableMonuments.setRowHeight(50);
                tableModel.addRow(rowData);
                idMap.put(rowIndex, monument.getId());
                rowIndex++;
            }
}

tableModel.fireTableDataChanged();
    }//GEN-LAST:event_jButton2MouseClicked

    private void TableMonumentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMonumentsMouseClicked
        int row = TableMonuments.getSelectedRow();
        if(row >= 0) {
            int idmonument = idMap.get(row);
            MapsAPI.zoomToMonument(idmonument);
        }
    }//GEN-LAST:event_TableMonumentsMouseClicked







    
    
    public void ViewProfileUser() {
        System.out.println("Foi AHAHAHAHAH");
        PanelMap.setSelectedIndex(0);
    }

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
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonChange;
    private javax.swing.JButton ButtonDel;
    private javax.swing.JButton ButtonSave;
    private javax.swing.JComboBox<String> ComboBoxCargo;
    private javax.swing.JComboBox<String> ComboSearchType;
    private javax.swing.JPanel FormInicio;
    private javax.swing.JPanel FormShowMapp;
    private javax.swing.JLabel LabelData;
    private javax.swing.JLabel LabelPhoto;
    private javax.swing.JPanel PanelButtonSearch;
    private javax.swing.JTabbedPane PanelMap;
    private javax.swing.JPanel PanelMapInteract;
    private javax.swing.JPanel PanelSearchAll;
    private javax.swing.JTable TableMonuments;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JTextField TextNome;
    private javax.swing.JTextField TextSearchMonument;
    private javax.swing.JTextArea TextSobre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
