/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.view;

import java.awt.Color;
import java.awt.Insets;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import javax.swing.table.DefaultTableModel;
import tacebook.controller.ProfileController;
import tacebook.model.Comment;
import tacebook.model.Message;
import tacebook.model.Post;
import tacebook.model.Profile;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Araceli,Diego,Oscar
 */
public class GUIProfileView extends javax.swing.JFrame implements ProfileView {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIProfileView.class.getName());
    private ProfileController myController;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'ás' HH:mm:ss");
    private int postsShown = 10;

    //Atributos para inicializar las tablas
    private ArrayList<Post> visiblePosts;
    private ArrayList<Profile> visibleFriends;
    private ArrayList<Profile> visibleFriendsRequest;
    private ArrayList<Message> visibleMessages;

    /**
     * Creates new form Gui
     */
    public GUIProfileView(ProfileController myController) {
        this.myController = myController;
        initComponents();
        customizePallete();
        initIconImages();

    }

    /**
     * carga icono y si no encuentra muestra mensaje en terminal
     *
     * usar clean y build para que netbeans copie los recursos a:
     * build/classes/tacebook/img/nombre_imagen.png
     *
     * @param path
     * @return
     */
    private ImageIcon loadIcon(String path) {
        URL url = getClass().getResource("/tacebook/view/images/" + path);

        if (url == null) {
            System.err.println("No se encontro.... " + path);
            return null;
        }

        return new ImageIcon(url);
    }

    private void initIconImages() {
        jTabbedPane1h466.setIconAt(0, loadIcon("persona.png"));
        jTabbedPane1h466.setIconAt(1, loadIcon("personas.png"));
        jTabbedPane1h466.setIconAt(2, loadIcon("mail.png"));

        // 1er panel
        btnPostCreate.setIcon(loadIcon("lapiz.png"));
        btnPostComment.setIcon(loadIcon("mensaje.png"));
        btnPostLike.setIcon(loadIcon("corazon.png"));
        btnOlderPosts.setIcon(loadIcon("mas.png"));

        btnUpdateStatus2.setIcon(loadIcon("bot.png"));
        btnLogout.setIcon(loadIcon("salir.png"));

        // panel amigos
        btnBioSee.setIcon(loadIcon("bandera.png"));
        btnMessageCreate.setIcon(loadIcon("lapiz-2.png"));

        btnAcceptRequest.setIcon(loadIcon("visto.png"));
        btnDenyRequest.setIcon(loadIcon("equis.png"));
        btnNewRequest.setIcon(loadIcon("persona-mas.png"));

        //panel mensajes
        btnMessageRead.setIcon(loadIcon("visto.png"));
        btnMessageDelete.setIcon(loadIcon("equis.png"));
    }

    private void loadPosts() {
        DefaultTableModel postModel = (DefaultTableModel) tablePosts.getModel();
        //llena la tabla de posts
        visiblePosts = myController.getSessionProfile().getPosts();
        postModel.setRowCount(0);
        String nombreAutor = "";
        for (Post p : visiblePosts) {
            if (p.getAuthor() != null) {
                nombreAutor = p.getAuthor().getName();
            } else {
                nombreAutor = "Autor desconocido";
            }

            postModel.addRow(new Object[]{
                formatter.format(p.getDate()),
                nombreAutor,
                p.getText(),
                p.getLikeProfiles().size()
            });
            tablePosts.getSelectionModel().addListSelectionListener(e -> {
                //Comprueba si hay cambios en el listener
                if (!e.getValueIsAdjusting()) {
                    int filaSelecionada = tablePosts.getSelectedRow();
                    //Fila selecionada distinto a -1 es que tenga alguna selecionada
                    if (filaSelecionada != -1) {
                        int indiceModelo = tablePosts.convertRowIndexToModel(filaSelecionada);
                        Post postSelecionado = visiblePosts.get(indiceModelo);
                        loadComments(postSelecionado);
                    }
                }

            });
        };

    }

    private void loadMensajes() {
        DefaultTableModel model = (DefaultTableModel) tableMessages.getModel();
        model.setRowCount(0);
        visibleMessages = myController.getSessionProfile().getMessages();
        for (Message m : visibleMessages) {
            model.addRow(new Object[]{"prueba",formatter.format(m.getDate()),m.getDestProfile().getName(),m.getText()});
        }

    }

    private void loadFriendsRequest() {
        //llena la tabla de comentarios
        //Creas un estilo y añades todos los elemento y lo seteas al list model
        DefaultListModel listModel = new DefaultListModel();
        visibleFriendsRequest = myController.getSessionProfile().getFriendshipsRequest();
        listModel.removeAllElements();
        for (Profile p : visibleFriendsRequest) {
            listModel.addElement(p);
        }
        listFriendRequests.setModel(listModel);
    }

    private void loadComments(Post post) {

        DefaultTableModel model = (DefaultTableModel) tableComments.getModel();
        model.setRowCount(0);
        for (Comment c : post.getComments()) {
            model.addRow(new Object[]{
                c.getText(),
                c.getSourceProfile().getName(),
                formatter.format(c.getDate())
            });
        }

    }

    private void loadFriends() {
    
        DefaultTableModel postModel = (DefaultTableModel) tableFriends.getModel();
        // limpia la tabla de comentarios
        postModel.setRowCount(0);
        visibleFriends = myController.getShownProfile().getFriends();
        //llena la tabla de comentarios
        for (Profile p : visibleFriends) {
            postModel.addRow(new Object[]{
                p.getName(), p.getStatus()
            });

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1h586 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jTabbedPane1h466 = new javax.swing.JTabbedPane();
        contenedor1 = new javax.swing.JPanel();
        jSplitPane1h550 = new javax.swing.JSplitPane();
        FIRST = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePosts = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnPostCreate = new javax.swing.JButton();
        btnPostComment = new javax.swing.JButton();
        btnPostLike = new javax.swing.JButton();
        btnOlderPosts = new javax.swing.JButton();
        SECOND = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableComments = new javax.swing.JTable();
        contenedor2 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        FIRST1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableFriends = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        btnBioSee = new javax.swing.JButton();
        btnMessageCreate = new javax.swing.JButton();
        SECOND1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listFriendRequests = new javax.swing.JList<>();
        BTNS_DOS1 = new javax.swing.JPanel();
        btnAcceptRequest = new javax.swing.JButton();
        btnDenyRequest = new javax.swing.JButton();
        btnNewRequest = new javax.swing.JButton();
        contenedor3 = new javax.swing.JPanel();
        SECOND8 = new javax.swing.JPanel();
        jScrollPane10h369 = new javax.swing.JScrollPane();
        tableMessages = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        btnMessageRead = new javax.swing.JButton();
        btnMessageDelete = new javax.swing.JButton();
        BTNS_DOS3 = new javax.swing.JPanel();
        btnUpdateStatus2 = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1h586.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1h586.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1h586.setPreferredSize(new java.awt.Dimension(800, 660));

        jPanel5.setMaximumSize(new java.awt.Dimension(800, 50));
        jPanel5.setMinimumSize(new java.awt.Dimension(800, 50));
        jPanel5.setName(""); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(800, 50));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setText("Perfil de usuario:");
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel3);

        lblUsername.setText("...");
        jPanel1.add(lblUsername);

        logo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setText("Tacebook");

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        jPanel2.setLayout(flowLayout1);

        jLabel2.setText("Estado actual:");
        jPanel2.add(jLabel2);

        lblStatus.setText("...");
        jPanel2.add(lblStatus);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1h466.setPreferredSize(new java.awt.Dimension(800, 444));

        jSplitPane1h550.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1h550.setMaximumSize(new java.awt.Dimension(800, 500));
        jSplitPane1h550.setMinimumSize(new java.awt.Dimension(800, 500));
        jSplitPane1h550.setPreferredSize(new java.awt.Dimension(800, 550));

        FIRST.setPreferredSize(new java.awt.Dimension(800, 455));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("10 últimas publicaciones"));
        jScrollPane4.setMaximumSize(new java.awt.Dimension(800, 200));
        jScrollPane4.setMinimumSize(new java.awt.Dimension(0, 77));

        tablePosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "autor", "texto", "me gustas"
            }
        ));
        tablePosts.setMaximumSize(new java.awt.Dimension(800, 200));
        tablePosts.setPreferredSize(new java.awt.Dimension(800, 200));
        jScrollPane4.setViewportView(tablePosts);

        jPanel8.setMinimumSize(new java.awt.Dimension(0, 0));

        btnPostCreate.setText("nueva publicacion");
        btnPostCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostCreateActionPerformed(evt);
            }
        });
        jPanel8.add(btnPostCreate);

        btnPostComment.setText("comentar");
        btnPostComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostCommentActionPerformed(evt);
            }
        });
        jPanel8.add(btnPostComment);

        btnPostLike.setText("dar \"me gusta\"");
        btnPostLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostLikeActionPerformed(evt);
            }
        });
        jPanel8.add(btnPostLike);

        btnOlderPosts.setText("ver publicaciones anteriores");
        btnOlderPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOlderPostsActionPerformed(evt);
            }
        });
        jPanel8.add(btnOlderPosts);

        javax.swing.GroupLayout FIRSTLayout = new javax.swing.GroupLayout(FIRST);
        FIRST.setLayout(FIRSTLayout);
        FIRSTLayout.setHorizontalGroup(
            FIRSTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FIRSTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(FIRSTLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        FIRSTLayout.setVerticalGroup(
            FIRSTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FIRSTLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jSplitPane1h550.setTopComponent(FIRST);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Comentarios"));
        jScrollPane2.setMaximumSize(new java.awt.Dimension(800, 200));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(0, 77));

        tableComments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "texto", "de", "data"
            }
        ));
        tableComments.setMaximumSize(new java.awt.Dimension(800, 200));
        tableComments.setPreferredSize(new java.awt.Dimension(800, 200));
        jScrollPane2.setViewportView(tableComments);

        javax.swing.GroupLayout SECONDLayout = new javax.swing.GroupLayout(SECOND);
        SECOND.setLayout(SECONDLayout);
        SECONDLayout.setHorizontalGroup(
            SECONDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SECONDLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        SECONDLayout.setVerticalGroup(
            SECONDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SECONDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jSplitPane1h550.setBottomComponent(SECOND);

        javax.swing.GroupLayout contenedor1Layout = new javax.swing.GroupLayout(contenedor1);
        contenedor1.setLayout(contenedor1Layout);
        contenedor1Layout.setHorizontalGroup(
            contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 812, Short.MAX_VALUE)
            .addGroup(contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedor1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSplitPane1h550, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        contenedor1Layout.setVerticalGroup(
            contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
            .addGroup(contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedor1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSplitPane1h550, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1h466.addTab("biografía", contenedor1);

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setMaximumSize(new java.awt.Dimension(800, 500));
        jSplitPane2.setMinimumSize(new java.awt.Dimension(800, 500));

        FIRST1.setPreferredSize(new java.awt.Dimension(800, 250));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de amigos"));
        jScrollPane5.setMaximumSize(new java.awt.Dimension(800, 200));
        jScrollPane5.setMinimumSize(new java.awt.Dimension(0, 77));

        tableFriends.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nombre", "estado"
            }
        ));
        tableFriends.setMaximumSize(new java.awt.Dimension(800, 200));
        tableFriends.setMinimumSize(new java.awt.Dimension(60, 0));
        tableFriends.setPreferredSize(new java.awt.Dimension(800, 200));
        jScrollPane5.setViewportView(tableFriends);

        jPanel9.setMinimumSize(new java.awt.Dimension(0, 0));

        btnBioSee.setText("ver biografia");
        btnBioSee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBioSeeActionPerformed(evt);
            }
        });
        jPanel9.add(btnBioSee);

        btnMessageCreate.setText("enviar mensaje privado");
        btnMessageCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageCreateActionPerformed(evt);
            }
        });
        jPanel9.add(btnMessageCreate);

        javax.swing.GroupLayout FIRST1Layout = new javax.swing.GroupLayout(FIRST1);
        FIRST1.setLayout(FIRST1Layout);
        FIRST1Layout.setHorizontalGroup(
            FIRST1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FIRST1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(FIRST1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        FIRST1Layout.setVerticalGroup(
            FIRST1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FIRST1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jSplitPane2.setTopComponent(FIRST1);

        SECOND1.setPreferredSize(new java.awt.Dimension(787, 268));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createTitledBorder("Tus solicitudes de amistad"));
        jScrollPane6.setMaximumSize(new java.awt.Dimension(32767, 200));
        jScrollPane6.setPreferredSize(new java.awt.Dimension(0, 350));

        jScrollPane6.setViewportView(listFriendRequests);

        BTNS_DOS1.setMinimumSize(new java.awt.Dimension(0, 0));

        btnAcceptRequest.setText("aceptar solicitud");
        btnAcceptRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptRequestActionPerformed(evt);
            }
        });
        BTNS_DOS1.add(btnAcceptRequest);

        btnDenyRequest.setText("rechazar solicitud");
        btnDenyRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDenyRequestActionPerformed(evt);
            }
        });
        BTNS_DOS1.add(btnDenyRequest);

        btnNewRequest.setText("nueva solicitud");
        btnNewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRequestActionPerformed(evt);
            }
        });
        BTNS_DOS1.add(btnNewRequest);

        javax.swing.GroupLayout SECOND1Layout = new javax.swing.GroupLayout(SECOND1);
        SECOND1.setLayout(SECOND1Layout);
        SECOND1Layout.setHorizontalGroup(
            SECOND1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BTNS_DOS1, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
            .addGroup(SECOND1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SECOND1Layout.createSequentialGroup()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        SECOND1Layout.setVerticalGroup(
            SECOND1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SECOND1Layout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addComponent(BTNS_DOS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(SECOND1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SECOND1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(113, Short.MAX_VALUE)))
        );

        jSplitPane2.setBottomComponent(SECOND1);

        javax.swing.GroupLayout contenedor2Layout = new javax.swing.GroupLayout(contenedor2);
        contenedor2.setLayout(contenedor2Layout);
        contenedor2Layout.setHorizontalGroup(
            contenedor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 799, Short.MAX_VALUE)
            .addGroup(contenedor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedor2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        contenedor2Layout.setVerticalGroup(
            contenedor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
            .addGroup(contenedor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedor2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1h466.addTab("amigos", contenedor2);

        SECOND8.setMaximumSize(new java.awt.Dimension(800, 200));
        SECOND8.setMinimumSize(new java.awt.Dimension(800, 200));

        jScrollPane10h369.setBorder(javax.swing.BorderFactory.createTitledBorder("Mensajes privados"));
        jScrollPane10h369.setMaximumSize(new java.awt.Dimension(800, 200));
        jScrollPane10h369.setMinimumSize(new java.awt.Dimension(800, 200));

        tableMessages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "leida", "data", "de", "texto"
            }
        ));
        tableMessages.setMaximumSize(new java.awt.Dimension(800, 200));
        tableMessages.setPreferredSize(new java.awt.Dimension(800, 500));
        jScrollPane10h369.setViewportView(tableMessages);

        javax.swing.GroupLayout SECOND8Layout = new javax.swing.GroupLayout(SECOND8);
        SECOND8.setLayout(SECOND8Layout);
        SECOND8Layout.setHorizontalGroup(
            SECOND8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10h369, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SECOND8Layout.setVerticalGroup(
            SECOND8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SECOND8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10h369, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout();
        flowLayout2.setAlignOnBaseline(true);
        jPanel12.setLayout(flowLayout2);

        btnMessageRead.setText("leer mensaje");
        btnMessageRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageReadActionPerformed(evt);
            }
        });
        jPanel12.add(btnMessageRead);

        btnMessageDelete.setText("eliminar mensaje");
        btnMessageDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageDeleteActionPerformed(evt);
            }
        });
        jPanel12.add(btnMessageDelete);

        javax.swing.GroupLayout contenedor3Layout = new javax.swing.GroupLayout(contenedor3);
        contenedor3.setLayout(contenedor3Layout);
        contenedor3Layout.setHorizontalGroup(
            contenedor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(contenedor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedor3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SECOND8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );
        contenedor3Layout.setVerticalGroup(
            contenedor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedor3Layout.createSequentialGroup()
                .addContainerGap(392, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(contenedor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenedor3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(SECOND8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(44, Short.MAX_VALUE)))
        );

        jTabbedPane1h466.addTab("mensajes privados", contenedor3);

        BTNS_DOS3.setMinimumSize(new java.awt.Dimension(0, 0));

        btnUpdateStatus2.setText("cambiar estado");
        btnUpdateStatus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStatus2ActionPerformed(evt);
            }
        });
        BTNS_DOS3.add(btnUpdateStatus2);

        btnLogout.setText("cerrar sesión");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        BTNS_DOS3.add(btnLogout);

        javax.swing.GroupLayout jPanel1h586Layout = new javax.swing.GroupLayout(jPanel1h586);
        jPanel1h586.setLayout(jPanel1h586Layout);
        jPanel1h586Layout.setHorizontalGroup(
            jPanel1h586Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1h586Layout.createSequentialGroup()
                .addGroup(jPanel1h586Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1h466, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1h586Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1h586Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(BTNS_DOS3, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1h586Layout.setVerticalGroup(
            jPanel1h586Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1h586Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1h466, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1h586Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1h586Layout.createSequentialGroup()
                    .addContainerGap(547, Short.MAX_VALUE)
                    .addComponent(BTNS_DOS3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1h586, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1h586, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMessageReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageReadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMessageReadActionPerformed

    private void btnMessageDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMessageDeleteActionPerformed
    ///////////////////////////
    /// TODO NO VA ///////////
    ////////////////////////
    private void btnBioSeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBioSeeActionPerformed
            int filaSelecionada = tableFriends.getSelectedRow();
            //Fila selecionada distinto a -1 es que tenga alguna selecionada
            if (filaSelecionada != -1) {
                int indiceModelo = tableFriends.convertRowIndexToModel(filaSelecionada);
                Profile friend = visibleFriends.get(indiceModelo);
                myController.setShownProfile(friend);
                showProfileMenu(friend);
            }
    }//GEN-LAST:event_btnBioSeeActionPerformed

    private void btnMessageCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageCreateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMessageCreateActionPerformed

    private void btnAcceptRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptRequestActionPerformed
        Profile profilefilaSelecionada = listFriendRequests.getSelectedValue();
        //Fila selecionada distinto a -1 es que tenga alguna selecionada
        myController.acceptFriendshipRequest(profilefilaSelecionada);
        loadFriendsRequest();
        loadFriends();
    }//GEN-LAST:event_btnAcceptRequestActionPerformed

    private void btnDenyRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDenyRequestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDenyRequestActionPerformed

    private void btnNewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRequestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewRequestActionPerformed

    private void btnUpdateStatus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStatus2ActionPerformed
        String seleccion = JOptionPane.showInputDialog(
                this,
                "Escribe tu nuevo estatus : ",
                JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante

        // Si seleccion es null es que el usuario ha pulsado Cancelar.
        if (seleccion != null) {
            Profile profile = myController.getShownProfile();
            profile.setStatus(seleccion);
            loadStatus(profile);
        }
    }//GEN-LAST:event_btnUpdateStatus2ActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        myController.closeSession();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnOlderPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOlderPostsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOlderPostsActionPerformed

    private void btnPostLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostLikeActionPerformed
        int filaSelecionada = tablePosts.getSelectedRow();
        //Fila selecionada distinto a -1 es que tenga alguna selecionada
        if (filaSelecionada != -1) {
            int indiceModelo = tablePosts.convertRowIndexToModel(filaSelecionada);
            Post postSelecionado = visiblePosts.get(indiceModelo);
            myController.newLike(postSelecionado);
        };
    }//GEN-LAST:event_btnPostLikeActionPerformed

    private void btnPostCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostCommentActionPerformed
        String seleccion = JOptionPane.showInputDialog(
                this,
                "Escribe el comentario del post : ",
                JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante

        // Si seleccion es null es que el usuario ha pulsado Cancelar.
        if (seleccion != null) {

            //Comprueba si hay cambios en el listener
            int filaSelecionada = tablePosts.getSelectedRow();
            //Fila selecionada distinto a -1 es que tenga alguna selecionada
            if (filaSelecionada != -1) {
                int indiceModelo = tablePosts.convertRowIndexToModel(filaSelecionada);
                Post postSelecionado = visiblePosts.get(indiceModelo);
                myController.newComment(postSelecionado, seleccion);
                loadComments(postSelecionado);
            }
        };
    }//GEN-LAST:event_btnPostCommentActionPerformed

    private void btnPostCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostCreateActionPerformed
        String seleccion = JOptionPane.showInputDialog(
                this,
                "Escribe el texto del post : ",
                JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante

        // Si seleccion es null es que el usuario ha pulsado Cancelar.
        if (seleccion != null) {
            myController.newPost(seleccion, myController.getShownProfile());
            loadPosts();
        }
    }//GEN-LAST:event_btnPostCreateActionPerformed

    public static void customizePallete() {
        //cambio de lookandfeel
        try {
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Color PURPLE_LIGHT = new Color(230, 220, 255);
        Color PURPLE = new Color(227, 190, 247);
        Color PURPLE_DARK = new Color(230, 220, 255);

        //fondo de j option panes
        UIManager.put("control", PURPLE_LIGHT);
        UIManager.put("nimbusLightBackground", PURPLE_LIGHT);
        UIManager.put("OptionPane.background", PURPLE_LIGHT);
        UIManager.put("OptionPane.messageArea.background", PURPLE_LIGHT);
        UIManager.put("OptionPane.buttonArea.background", PURPLE_LIGHT);

        // quita los bordes externos de los JSplitPane 
        UIManager.put("SplitPane.border", new EmptyBorder(0, 0, 0, 0));

        //fondo de paneles
        UIManager.put("Panel.background", PURPLE_LIGHT);
        //fondo de scroll pane
        UIManager.put("ScrollPane.background", PURPLE_LIGHT);
        UIManager.put("Viewport.background", PURPLE_LIGHT);

        //botones
        UIManager.put("Button.background", PURPLE_DARK);
        UIManager.put("Button.foreground", Color.BLACK);

        //encabezado de las tablas:
        UIManager.put("TableHeader.background", PURPLE);
        UIManager.put("TableHeader.foreground", Color.BLACK);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BTNS_DOS1;
    private javax.swing.JPanel BTNS_DOS3;
    private javax.swing.JPanel FIRST;
    private javax.swing.JPanel FIRST1;
    private javax.swing.JPanel SECOND;
    private javax.swing.JPanel SECOND1;
    private javax.swing.JPanel SECOND8;
    private javax.swing.JButton btnAcceptRequest;
    private javax.swing.JButton btnBioSee;
    private javax.swing.JButton btnDenyRequest;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMessageCreate;
    private javax.swing.JButton btnMessageDelete;
    private javax.swing.JButton btnMessageRead;
    private javax.swing.JButton btnNewRequest;
    private javax.swing.JButton btnOlderPosts;
    private javax.swing.JButton btnPostComment;
    private javax.swing.JButton btnPostCreate;
    private javax.swing.JButton btnPostLike;
    private javax.swing.JButton btnUpdateStatus2;
    private javax.swing.JPanel contenedor1;
    private javax.swing.JPanel contenedor2;
    private javax.swing.JPanel contenedor3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel1h586;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10h369;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1h550;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1h466;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JList<Profile> listFriendRequests;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tableComments;
    private javax.swing.JTable tableFriends;
    private javax.swing.JTable tableMessages;
    private javax.swing.JTable tablePosts;
    // End of variables declaration//GEN-END:variables

    /**
     * obtiene el numero de posts mostrados
     *
     * @return
     */
    public int getPostsShown() {
        return postsShown;
    }

    public void loadStatus(Profile profile) {
        lblStatus.setText(profile.getStatus());
    }

    @Override
    public void showProfileMenu(Profile profile) {
        //Actualiza textos: username y status en interfaz
        lblUsername.setText(profile.getName());
        loadStatus(profile);
        loadPosts();
        loadFriends();
        loadFriendsRequest();
        
        this.setVisible(true);
    }

    @Override
    public void showProfileNotFoundMessage() {
        JOptionPane.showMessageDialog(this, "Profile not found", "No se ha encontrado el perfil", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void showCannotLikeOwnPostMessage() {
        JOptionPane.showMessageDialog(this, "No te puedes dar like sobre ti mismo", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showAlreadyLikedPostMessage() {
        JOptionPane.showMessageDialog(this, "No te puedes dar like dos vezes al mismo post", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showIsAlreadyFriendMessage(String profileName) {
        JOptionPane.showMessageDialog(this, "Ya eres amigo de : " + profileName, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showExistsFrienshipRequestMessage(String profileName) {
        JOptionPane.showMessageDialog(this, "Ya existe una solicitud de amistad de  : " + profileName, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showDuplicateFrienshipRequestMessage(String profileName) {
        JOptionPane.showMessageDialog(this, "Ya le enviaste una solicitud de amistad a : " + profileName, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showConnectionErrorMessage() {
        JOptionPane.showMessageDialog(this, "Error", "Erro na conexión co almacén de datos!", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void showReadErrorMessage() {
        JOptionPane.showMessageDialog(this, "Error", "Erro na lectura de datos!", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void showWriteErrorMessage() {
        JOptionPane.showMessageDialog(this, "Error", "Erro na escritura de datos!", JOptionPane.WARNING_MESSAGE);
    }
}
