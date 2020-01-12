package view;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import libraries.FrontController;

public class UserInterface extends javax.swing.JFrame {

    public static int count;
    public static String Display;
    public static boolean random;
    public static boolean repeat;
    
    public String playImageEntered;
    public String playImageExited;
    public String randomImageEntered;
    public String randomImageExited;
    public String repeatImageEntered;
    public String repeatImageExited;
    
    public String playState;
 
    public UserInterface() {
        //start variables
        initComponents();
        this.setLocationRelativeTo(null);
        FrontController.jlistPanel=jList1;
        controller = new FrontController();
        random=false;
        repeat = false;
        playState = "";
        playImageEntered="images/play_h.png";
        playImageExited="images/play.png";
        randomImageEntered = "images/random_h.png";
        randomImageExited = "images/random.png";
        repeatImageEntered = "images/repeat_h.png";
        repeatImageExited = "images/repeat.png";
       
        FrontController.labelDetail=labelDetail;
        FrontController.labelMusicTitle=labelMusicTitle;
        FrontController.labelTimeElapsed=labelTimeElapsed;
        FrontController.labelTimeRemaining=labelTimeRemaining;
        FrontController.lebelImageAlbum=lebelImageAlbum;
        FrontController.jprogressBar=jProgressBar1;
        
        
        
    }

    /**
     * Parte del codigo de la que se encarga .form
     */
    @SuppressWarnings("unchecked")
    // Inicializaci�n de variables
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        labelTimeElapsed = new javax.swing.JLabel();
        labelTimeRemaining = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        labelMusicTitle = new javax.swing.JLabel();
        labelDetail = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lebelImageAlbum = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnRandom = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnRepeat = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnUpload = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnDeleteAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        //Definici�n de los colores que van a formar el gradiente,
        //El m�todo utilizado es Color(R, G, B)
        
        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 0));
        //Color de abajo
        kGradientPanel1.setkGradientFocus(0);
        kGradientPanel1.setkStartColor(new java.awt.Color(13, 165, 95));
        //Color de arriba

        jPanel1.setOpaque(false);
        
        //A�adimos imagen y acci�n al bot�n para cerrar la ventana
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/close.png"))); // NOI18N
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setFocusPainted(false);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeClick(evt);
            }
        });

        //A�adimos imagen y acci�n al bot�n para minimizar la ventana
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/minimize.png"))); // NOI18N
        btnMinimize.setBorderPainted(false);
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setFocusPainted(false);
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeClick(evt);
            }
        });
        //El panel que contiene los botones cerrar y minimizar ventana
        // y que define tama�o y posici�n de estos
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        
        jPanel2.setOpaque(false);
        
        //JList que va a cargar la lista de canciones disponibles
        //para reproducir
        jList1.setBackground(new java.awt.Color(248, 248, 248));
        jList1.setForeground(new java.awt.Color(184, 169, 169));
        jList1.setSelectionBackground(new java.awt.Color(171, 98, 126));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        //JList implementado al JScrollPane para poder subir y bajar
        //en caso de que la lista sacada sea m�s grande que
        //el tama�o de la lista
        jScrollPane1.setViewportView(jList1);

        jPanel7.setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Play List");
        
        
       // JPanel7 es un subpanel contenido en JPanel2, para a�adir el
        //label que tiene como titulo PlayList
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        //Se a�ade el label y se define su tama�o y posici�n
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );
        
        
        //Se a�ade el panel del label recientemente definido y el
        //ScrollPane que contiene a su propio objeto y el JList
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setOpaque(false);

        jPanel8.setOpaque(false);
        
        //Objeto tipo label que va a contener el tiempo que lleva
        //reproduci�ndose una canci�n
        labelTimeElapsed.setForeground(new java.awt.Color(184, 169, 169));
        labelTimeElapsed.setText("00:00:00");

        //Objeto tipo label que va a contener el tiempo que le queda
        //por reproducir a una canci�n
        labelTimeRemaining.setForeground(new java.awt.Color(184, 169, 169));
        labelTimeRemaining.setText("00:00:00");

        
        //Se a�aden los contadores y la progressBar que miden el
        //progreso de las canciones
        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(labelTimeElapsed, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTimeRemaining, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTimeElapsed)
                    .addComponent(labelTimeRemaining))
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setOpaque(false);

        //Objeto tipo label que indica el nombre de la canci�n
        labelMusicTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelMusicTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelMusicTitle.setText("Music Title");

        //Objeto tipo label que indica el nombre del artista
        labelDetail.setForeground(new java.awt.Color(184, 169, 169));
        labelDetail.setText("Artist Name");

        
        //Se a�aden los label de artista y titulo de cancion
        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(labelMusicTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMusicTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(labelDetail))
        );

        jPanel10.setOpaque(false);
        
       //Este JPanel contiene el label que va a cargar la imagen del
        //album de cada canci�n
        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lebelImageAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lebelImageAlbum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        
        //A�adimos los subpaneles 8,9 y 10 al panel3, indicando posici�n
        //y tama�o
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setOpaque(false);

        jPanel5.setOpaque(false); 
        //Va a contener a los botones que influyan sobre las canciones
        
        //Bot�n random implementaci�n de m�todos y dise�o del bot�n
        btnRandom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/random.png"))); // NOI18N
        btnRandom.setBorderPainted(false);
        btnRandom.setContentAreaFilled(false);
        btnRandom.setFocusPainted(false);
        btnRandom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EnteredRandom(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedRandom(evt);
            }
        });
        btnRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomClicked(evt);
            }
        });
      //Bot�n previous implementaci�n de m�todos y dise�o del bot�n
        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/previous.png"))); // NOI18N
        btnPrevious.setBorderPainted(false);
        btnPrevious.setContentAreaFilled(false);
        btnPrevious.setFocusPainted(false);
        btnPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredPrevious(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedPrevious(evt);
            }
        });
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousClicked(evt);
            }
        });
      //Bot�n reproducir implementaci�n de m�todos y dise�o del bot�n
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/play.png"))); // NOI18N
        btnPlay.setBorderPainted(false);
        btnPlay.setContentAreaFilled(false);
        btnPlay.setFocusPainted(false);
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredPlay(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedPlay(evt);
            }
        });
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playClicked(evt);
            }
        });

      //Bot�n siguiente implementaci�n de m�todos y dise�o del bot�n
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/next.png"))); // NOI18N
        btnNext.setBorderPainted(false);
        btnNext.setContentAreaFilled(false);
        btnNext.setFocusPainted(false);
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredNext(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedNext(evt);
            }
        });
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextClicked(evt);
            }
        });

        //Bot�n repetir implementaci�n de m�todos y dise�o del bot�n
        btnRepeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/repeat.png"))); // NOI18N
        btnRepeat.setBorderPainted(false);
        btnRepeat.setContentAreaFilled(false);
        btnRepeat.setFocusPainted(false);
        btnRepeat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredRepeat(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedRepeat(evt);
            }
        });
        btnRepeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeatClicked(evt);
            }
        });
        //A�adimos los botones que van a influir en las canciones
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnRandom, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnRepeat, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRepeat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRandom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnPlay)
                        .addGap(4, 4, 4))))
        );

        jPanel6.setOpaque(false);
        //Va a contener a los botones que influyan sobre la JList
        
        //Bot�n upload implementaci�n de m�todos y dise�o del bot�n
        btnUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/upload.png"))); // NOI18N
        btnUpload.setBorderPainted(false);
        btnUpload.setContentAreaFilled(false);
        btnUpload.setFocusPainted(false);
        btnUpload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredUpload(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedUpload(evt);
            }
        });
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadClicked(evt);
            }
        });

        //Bot�n borrar canci�n implementaci�n de m�todos y dise�o del bot�n
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/delete.png"))); // NOI18N
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setFocusPainted(false);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredDelete(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedDelete(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteClicked(evt);
            }
        });
        
        //Bot�n borrar playlist implementaci�n de m�todos y dise�o del bot�n
        btnDeleteAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/delete-all.png"))); // NOI18N
        btnDeleteAll.setBorderPainted(false);
        btnDeleteAll.setContentAreaFilled(false);
        btnDeleteAll.setFocusPainted(false);
        btnDeleteAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitedDeleteAll(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                enteredDeleteAll(evt);
            }
        });
        btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllClicked(evt);
            }
        });
      //A�adimos los botones que van a influir en las playlists
        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        //A�adimos los paneles que contienen los botones
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        
        //Este es el superpanel que contiene a todos los paneles
        //previamente definidos
        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        //A�adimos a la ventana el superpanel
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

     //=====================================================================================================  hovers
    
    //Cambia la imagen si el cursor se pone encima del bot�n random
    private void EnteredRandom(java.awt.event.MouseEvent evt) {
        changeImage(randomImageEntered, btnRandom);
    }

  //Vuelve a cambiar la imagen si el cursor sale del bot�n random
    private void exitedRandom(java.awt.event.MouseEvent evt) {
        changeImage(randomImageExited, btnRandom);
    }

  //Cambia la imagen si el cursor se pone encima del bot�n canci�n previa
    private void enteredPrevious(java.awt.event.MouseEvent evt) {
        changeImage("images/previous_h.png", btnPrevious);
    }

  //Vuelve a cambiar la imagen si el cursor sale del bot�n canci�n previa
    private void exitedPrevious(java.awt.event.MouseEvent evt) {
         changeImage("images/previous.png", btnPrevious);
    }

    private void enteredPlay(java.awt.event.MouseEvent evt) {
        changeImage(playImageEntered, btnPlay);
    }
    

    private void exitedPlay(java.awt.event.MouseEvent evt) {
        changeImage(playImageExited, btnPlay);
    }

    //Cambia la imagen si el cursor se pone encima del bot�n canci�n siguiente
    private void enteredNext(java.awt.event.MouseEvent evt) {
        changeImage("images/next_h.png", btnNext);
    }

  //Vuelve a cambiar la imagen si el cursor sale del bot�n siguiente canci�n
    private void exitedNext(java.awt.event.MouseEvent evt) {
        changeImage("images/next.png", btnNext);
    }
    
    //Cambia la imagen si el cursor se pone encima del bot�n repetir canci�n
    private void enteredRepeat(java.awt.event.MouseEvent evt) {
        changeImage(repeatImageEntered, btnRepeat);
    }

  //Vuelve a cambiar la imagen si el cursor sale del bot�n repetir cancion
    private void exitedRepeat(java.awt.event.MouseEvent evt) {
        changeImage(repeatImageExited, btnRepeat);
    }

    private void enteredUpload(java.awt.event.MouseEvent evt) {
        changeImage("images/upload_h.png", btnUpload);
    }

    private void exitedUpload(java.awt.event.MouseEvent evt) {
        changeImage("images/upload.png", btnUpload);
    }

    private void enteredDelete(java.awt.event.MouseEvent evt) {
        changeImage("images/delete_h.png", btnDelete);
    }

    private void exitedDelete(java.awt.event.MouseEvent evt) {
        changeImage("images/delete.png", btnDelete);
    }

    private void exitedDeleteAll(java.awt.event.MouseEvent evt) {
        changeImage("images/delete-all_h.png", btnDeleteAll);
    }

    private void enteredDeleteAll(java.awt.event.MouseEvent evt) {
        changeImage("images/delete-all.png", btnDeleteAll);
    }

    //Metodo cambiar foto al que hemos estado llamando
    private void changeImage(String path, JButton button){
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResource(path));
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        button.setIcon(new ImageIcon(img));
    }
//======================================================================================================END hovers
    
    
    
    //Declaraci�n de la funci�n del bot�n minimizar
    private void minimizeClick(java.awt.event.MouseEvent evt) {
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }

    //Declaraci�n de la funci�n del bot�n cerrar
    private void closeClick(java.awt.event.MouseEvent evt) {
        controller.saveMusics();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    
///////////////////////////////////////////////////////////////////////////////////////    
    
    //Evento que se produce a la hora de clicar en random
    private void randomClicked(java.awt.event.ActionEvent evt) {
        random = !random;
        if(random){
            randomImageEntered = "images/random.png";
            randomImageExited =  "images/randomSelected.png";
            changeImage(randomImageExited, btnRandom);
        }
        else{
            randomImageEntered = "images/random_h.png";
            randomImageExited = "images/random.png";
            changeImage(randomImageExited, btnRandom);
        }
        repeat = false;
    }

    //Evento que se produce a la hora de clicar en cancion previa
    private void previousClicked(java.awt.event.ActionEvent evt) {
        controller.preview();
    }
    
    //Evento que se produce a la hora de clicar en reproducir
    private void playClicked(java.awt.event.ActionEvent evt) {

        if(playState.equals("PLAYING")){
            playImageEntered="images/play_h.png";
            playImageExited="images/play.png";
            changeImage(playImageExited, btnPlay);
            controller.pause();
            playState = "PAUSED";
            return;
        }
        
        if(playState.equals("SELECTED")){
            playImageEntered="images/pause_h.png";
            playImageExited="images/pause.png";
            changeImage(playImageExited, btnPlay);
            controller.play(selectedIndex);
            playState = "PLAYING";
            return;
        }
        
        if(playState.equals("PAUSED")){
            playImageEntered="images/pause_h.png";
            playImageExited="images/pause.png";
            changeImage(playImageExited, btnPlay);
            controller.resume();
            playState = "PLAYING";
            return;
        }
    }
    
    //Evento que se produce a la hora de clicar en siguiente canci�n
    private void nextClicked(java.awt.event.ActionEvent evt) {
        controller.next();
    }
    //Evento que se produce a la hora de clicar en repetir canci�n
    private void repeatClicked(java.awt.event.ActionEvent evt) {
        repeat = !repeat;
        if(repeat){
            repeatImageEntered = "images/repeat.png";
            repeatImageExited =  "images/repeatSelected.png";
            changeImage(repeatImageExited, btnRepeat);
        }
        else{
            repeatImageEntered = "images/repeat_h.png";
            repeatImageExited = "images/repeat.png";
            changeImage(repeatImageExited, btnRepeat);
        }
        random = false;
    }

  //Evento que se produce a la hora de clicar en a�adir cancion
    private void uploadClicked(java.awt.event.ActionEvent evt) {
        controller.addFiles(jList1);
    }
  //Evento que se produce a la hora de clicar en borrar cancion
    private void deleteClicked(java.awt.event.ActionEvent evt) {
        controller.deleteMusic(jList1.getSelectedIndex());
        playImageEntered="images/play_h.png";
        playImageExited="images/play.png";
        changeImage(playImageExited, btnPlay);
    }

  //Evento que se produce a la hora de clicar en borrar playlist
    private void deleteAllClicked(java.awt.event.ActionEvent evt) {
        controller.deleteAllMusics();
        playImageEntered="images/play_h.png";
        playImageExited="images/play.png";
        changeImage(playImageExited, btnPlay);
    }

    //Evento que se produce cuando se selecciona una canci�n
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2){ 
            
            selectedIndex = jList1.getSelectedIndex();
            controller.play(selectedIndex);
            playImageEntered="images/pause_h.png";
            playImageExited="images/pause.png";
            changeImage(playImageExited, btnPlay);
            playState = "PLAYING";
        }else{
            selectedIndex = jList1.getSelectedIndex();
            controller.setDetail(selectedIndex);
            playState = "SELECTED";
            
        }
    }

    
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteAll;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnRandom;
    private javax.swing.JButton btnRepeat;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel labelDetail;
    private javax.swing.JLabel labelMusicTitle;
    private javax.swing.JLabel labelTimeElapsed;
    private javax.swing.JLabel labelTimeRemaining;
    private javax.swing.JLabel lebelImageAlbum;
    // End of variables declaration//GEN-END:variables

    
    //variables
    private int selectedIndex;
    
    private FrontController controller;
}