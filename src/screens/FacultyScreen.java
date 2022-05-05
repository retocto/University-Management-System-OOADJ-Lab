package screens;

import com.formdev.flatlaf.FlatLightLaf;
import java.net.URL;
import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;

public class FacultyScreen extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    
    private static int login_id;

    private void customizeComponents() {
        setLocationRelativeTo(this);
    }

    public FacultyScreen(int loginId)
    {
        login_id=loginId;
        initComponents();
        customizeComponents();
    }
    

    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitlePanel = new javax.swing.JPanel();
        AppNameLabel = new javax.swing.JLabel();
        BannerPanel = new javax.swing.JPanel();
        BannerLabel = new javax.swing.JLabel();
        LogoutButton = new javax.swing.JButton();
        ControlPanel = new javax.swing.JPanel();
        ButtonPanel = new javax.swing.JPanel();
        MenuOne = new javax.swing.JPanel();
        EvaluateButton = new javax.swing.JButton();
        MenuTwo = new javax.swing.JPanel();
        TakeAttendanceButton = new javax.swing.JButton();
        SetPaperButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setName("HomeFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        TitlePanel.setBackground(new java.awt.Color(51, 51, 51));

        AppNameLabel.setFont(AppNameLabel.getFont().deriveFont(AppNameLabel.getFont().getStyle() | java.awt.Font.BOLD, AppNameLabel.getFont().getSize()+29));
        AppNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        AppNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AppNameLabel.setText(bundle.getString("APP_NAME")); // NOI18N
        AppNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AppNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AppNameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BannerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BannerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/home_banner.png"))); // NOI18N

        LogoutButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn.png"))); // NOI18N
        LogoutButton.setText("Logout");
        LogoutButton.setBorder(null);
        LogoutButton.setBorderPainted(false);
        LogoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LogoutButton.setOpaque(false);
        LogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LogoutButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout BannerPanelLayout = new javax.swing.GroupLayout(BannerPanel);
        BannerPanel.setLayout(BannerPanelLayout);
        BannerPanelLayout.setHorizontalGroup(
            BannerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BannerPanelLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(BannerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BannerPanelLayout.setVerticalGroup(
            BannerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BannerPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(BannerLabel))
            .addGroup(BannerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ButtonPanel.setMinimumSize(new java.awt.Dimension(1180, 349));
        ButtonPanel.setOpaque(false);
        ButtonPanel.setLayout(new java.awt.GridLayout(2, 1, 10, 10));

        MenuOne.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        EvaluateButton.setFont(EvaluateButton.getFont().deriveFont(EvaluateButton.getFont().getStyle() | java.awt.Font.BOLD, EvaluateButton.getFont().getSize()+3));
        EvaluateButton.setForeground(new java.awt.Color(80, 180, 140));
        EvaluateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/student.png"))); // NOI18N
        EvaluateButton.setText("Evaluate");
        EvaluateButton.setBorder(null);
        EvaluateButton.setBorderPainted(false);
        EvaluateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EvaluateButton.setFocusable(false);
        EvaluateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EvaluateButton.setOpaque(false);
        EvaluateButton.setPreferredSize(new java.awt.Dimension(160, 160));
        EvaluateButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EvaluateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EvaluateButtonMousePressed(evt);
            }
        });
        MenuOne.add(EvaluateButton);

        ButtonPanel.add(MenuOne);

        MenuTwo.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        TakeAttendanceButton.setFont(TakeAttendanceButton.getFont().deriveFont(TakeAttendanceButton.getFont().getStyle() | java.awt.Font.BOLD, TakeAttendanceButton.getFont().getSize()+3));
        TakeAttendanceButton.setForeground(new java.awt.Color(80, 180, 140));
        TakeAttendanceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/attendance.png"))); // NOI18N
        TakeAttendanceButton.setText("Attendance");
        TakeAttendanceButton.setBorder(null);
        TakeAttendanceButton.setBorderPainted(false);
        TakeAttendanceButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TakeAttendanceButton.setFocusable(false);
        TakeAttendanceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TakeAttendanceButton.setOpaque(false);
        TakeAttendanceButton.setPreferredSize(new java.awt.Dimension(160, 160));
        TakeAttendanceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TakeAttendanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TakeAttendanceButtonMousePressed(evt);
            }
        });
        MenuTwo.add(TakeAttendanceButton);

        SetPaperButton.setFont(SetPaperButton.getFont().deriveFont(SetPaperButton.getFont().getStyle() | java.awt.Font.BOLD, SetPaperButton.getFont().getSize()+3));
        SetPaperButton.setForeground(new java.awt.Color(80, 180, 140));
        SetPaperButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/accounts.png"))); // NOI18N
        SetPaperButton.setText("SetPaper");
        SetPaperButton.setBorder(null);
        SetPaperButton.setBorderPainted(false);
        SetPaperButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SetPaperButton.setFocusable(false);
        SetPaperButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SetPaperButton.setOpaque(false);
        SetPaperButton.setPreferredSize(new java.awt.Dimension(160, 160));
        SetPaperButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        SetPaperButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SetPaperButtonMousePressed(evt);
            }
        });
        MenuTwo.add(SetPaperButton);

        ButtonPanel.add(MenuTwo);

        ControlPanel.add(ButtonPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BannerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BannerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EvaluateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluateButtonMousePressed
        this.dispose();
        EvaluateScreen evaluateScreen =  new EvaluateScreen(login_id);
        evaluateScreen.setVisible(true);
        System.out.println("Evaluate");
    }

    private void SetPaperButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluateButtonMousePressed
        this.dispose();
        SetPaperScreen setPaperScreen =  new SetPaperScreen(login_id);
        setPaperScreen.setVisible(true);
        System.out.println("Set PAper");
    }

    private void TakeAttendanceButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluateButtonMousePressed
        this.dispose();
        TakeAttendanceScreen takeAttendanceScreen =  new TakeAttendanceScreen(login_id);
        takeAttendanceScreen.setVisible(true);
        System.out.println("attend");
    }

    private void LogoutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButtonMousePressed
        this.dispose();
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FacultyScreen(login_id).setVisible(true);
        });
    }

    private javax.swing.JButton SetPaperButton;
    private javax.swing.JLabel AppNameLabel;
    private javax.swing.JButton TakeAttendanceButton;
    private javax.swing.JLabel BannerLabel;
    private javax.swing.JPanel BannerPanel;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JPanel MenuOne;
    private javax.swing.JPanel MenuTwo;
    private javax.swing.JButton EvaluateButton;
    private javax.swing.JPanel TitlePanel;
}

