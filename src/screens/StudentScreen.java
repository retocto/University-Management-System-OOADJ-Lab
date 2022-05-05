// package screens;

// import com.formdev.flatlaf.FlatLightLaf;
// import java.net.URL;
// import javax.swing.ImageIcon;
// //import javax.swing.JOptionPane;

// public class StudentScreen extends javax.swing.JFrame {

//     private static final long serialVersionUID = 1L;

//     URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
//     ImageIcon icon = new ImageIcon(iconURL);
    
//     private static int login_id;

//     private void customizeComponents() {
//         setLocationRelativeTo(this);
//     }

//     public StudentScreen(int loginId)
//     {
//         login_id=loginId;
//         initComponents();
//         customizeComponents();
//     }
    

//     //@SuppressWarnings("unchecked")
//     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//     private void initComponents() {

//         TitlePanel = new javax.swing.JPanel();
//         AppNameLabel = new javax.swing.JLabel();
//         BannerPanel = new javax.swing.JPanel();
//         BannerLabel = new javax.swing.JLabel();
//         LogoutButton = new javax.swing.JButton();
//         ControlPanel = new javax.swing.JPanel();
//         ButtonPanel = new javax.swing.JPanel();
//         MenuOne = new javax.swing.JPanel();
//         //StudentButton = new javax.swing.JButton();
//         MenuTwo = new javax.swing.JPanel();
//         AttendanceButton = new javax.swing.JButton();
//         ExamsButton = new javax.swing.JButton();

//         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//         java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
//         setTitle(bundle.getString("APP_NAME")); // NOI18N
//         setIconImage(icon.getImage());
//         setMinimumSize(new java.awt.Dimension(1200, 800));
//         setName("HomeFrame"); // NOI18N
//         setResizable(false);
//         setSize(new java.awt.Dimension(0, 0));

//         TitlePanel.setBackground(new java.awt.Color(51, 51, 51));

//         AppNameLabel.setFont(AppNameLabel.getFont().deriveFont(AppNameLabel.getFont().getStyle() | java.awt.Font.BOLD, AppNameLabel.getFont().getSize()+29));
//         AppNameLabel.setForeground(new java.awt.Color(255, 255, 255));
//         AppNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//         AppNameLabel.setText(bundle.getString("APP_NAME")); // NOI18N
//         AppNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

//         javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
//         TitlePanel.setLayout(TitlePanelLayout);
//         TitlePanelLayout.setHorizontalGroup(
//             TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(TitlePanelLayout.createSequentialGroup()
//                 .addContainerGap()
//                 .addComponent(AppNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                 .addContainerGap())
//         );
//         TitlePanelLayout.setVerticalGroup(
//             TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(TitlePanelLayout.createSequentialGroup()
//                 .addContainerGap()
//                 .addComponent(AppNameLabel)
//                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//         );

//         BannerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//         BannerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/home_banner.png"))); // NOI18N

//         LogoutButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
//         LogoutButton.setForeground(new java.awt.Color(255, 255, 255));
//         LogoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn.png"))); // NOI18N
//         LogoutButton.setText("Logout");
//         LogoutButton.setBorder(null);
//         LogoutButton.setBorderPainted(false);
//         LogoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         LogoutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
//         LogoutButton.setOpaque(false);
//         LogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
//             public void mousePressed(java.awt.event.MouseEvent evt) {
//                 LogoutButtonMousePressed(evt);
//             }
//         });

//         javax.swing.GroupLayout BannerPanelLayout = new javax.swing.GroupLayout(BannerPanel);
//         BannerPanel.setLayout(BannerPanelLayout);
//         BannerPanelLayout.setHorizontalGroup(
//             BannerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(BannerPanelLayout.createSequentialGroup()
//                 .addGap(250, 250, 250)
//                 .addComponent(BannerLabel)
//                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                 .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
//                 .addContainerGap())
//         );
//         BannerPanelLayout.setVerticalGroup(
//             BannerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(BannerPanelLayout.createSequentialGroup()
//                 .addGap(5, 5, 5)
//                 .addComponent(BannerLabel))
//             .addGroup(BannerPanelLayout.createSequentialGroup()
//                 .addContainerGap()
//                 .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
//         );

//         ButtonPanel.setMinimumSize(new java.awt.Dimension(1180, 349));
//         ButtonPanel.setOpaque(false);
//         ButtonPanel.setLayout(new java.awt.GridLayout(2, 1, 10, 10));

//         MenuOne.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

//         // StudentButton.setFont(StudentButton.getFont().deriveFont(StudentButton.getFont().getStyle() | java.awt.Font.BOLD, StudentButton.getFont().getSize()+3));
//         // StudentButton.setForeground(new java.awt.Color(80, 180, 140));
//         // StudentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/student.png"))); // NOI18N
//         // StudentButton.setText("STUDENT");
//         // StudentButton.setBorder(null);
//         // StudentButton.setBorderPainted(false);
//         // StudentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         // StudentButton.setFocusable(false);
//         // StudentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
//         // StudentButton.setOpaque(false);
//         // StudentButton.setPreferredSize(new java.awt.Dimension(160, 160));
//         // StudentButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
//         // StudentButton.addMouseListener(new java.awt.event.MouseAdapter() {
//         //     public void mousePressed(java.awt.event.MouseEvent evt) {
//         //         StudentButtonMousePressed(evt);
//         //     }
//         // });
//         // MenuOne.add(StudentButton);

//         ButtonPanel.add(MenuOne);

//         MenuTwo.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

//         AttendanceButton.setFont(AttendanceButton.getFont().deriveFont(AttendanceButton.getFont().getStyle() | java.awt.Font.BOLD, AttendanceButton.getFont().getSize()+3));
//         AttendanceButton.setForeground(new java.awt.Color(80, 180, 140));
//         AttendanceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/attendance.png"))); // NOI18N
//         AttendanceButton.setText("Attendance");
//         AttendanceButton.setBorder(null);
//         AttendanceButton.setBorderPainted(false);
//         AttendanceButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         AttendanceButton.setFocusable(false);
//         AttendanceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
//         AttendanceButton.setOpaque(false);
//         AttendanceButton.setPreferredSize(new java.awt.Dimension(160, 160));
//         AttendanceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
//         AttendanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
//             public void mousePressed(java.awt.event.MouseEvent evt) {
//                 AttendanceButtonMousePressed(evt);
//             }
//         });
//         MenuTwo.add(AttendanceButton);

//         ExamsButton.setFont(ExamsButton.getFont().deriveFont(ExamsButton.getFont().getStyle() | java.awt.Font.BOLD, ExamsButton.getFont().getSize()+3));
//         ExamsButton.setForeground(new java.awt.Color(80, 180, 140));
//         ExamsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/accounts.png"))); // NOI18N
//         ExamsButton.setText("Exams");
//         ExamsButton.setBorder(null);
//         ExamsButton.setBorderPainted(false);
//         ExamsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         ExamsButton.setFocusable(false);
//         ExamsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
//         ExamsButton.setOpaque(false);
//         ExamsButton.setPreferredSize(new java.awt.Dimension(160, 160));
//         ExamsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
//         ExamsButton.addMouseListener(new java.awt.event.MouseAdapter() {
//             public void mousePressed(java.awt.event.MouseEvent evt) {
//                 ExamsButtonMousePressed(evt);
//             }
//         });
//         MenuTwo.add(ExamsButton);

//         ButtonPanel.add(MenuTwo);

//         ControlPanel.add(ButtonPanel);

//         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//         getContentPane().setLayout(layout);
//         layout.setHorizontalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//             .addGroup(layout.createSequentialGroup()
//                 .addContainerGap()
//                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//                     .addComponent(BannerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                     .addComponent(ControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE))
//                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//         );
//         layout.setVerticalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(layout.createSequentialGroup()
//                 .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                 .addGap(18, 18, 18)
//                 .addComponent(BannerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                 .addGap(18, 18, 18)
//                 .addComponent(ControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                 .addContainerGap(28, Short.MAX_VALUE))
//         );

//         pack();
//     }

//     // private void StudentButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentButtonMousePressed
//     //     this.dispose();

//     //     System.out.println("student");
//     // }

//     private void AttendanceButtonMousePressed(java.awt.event.MouseEvent evt) {
//         this.dispose();
//         AttendanceScreen attendanceScreen = new AttendanceScreen(login_id);
//         attendanceScreen.setVisible(true);
//         System.out.println("Attendance");
//     }

//     private void ExamsButtonMousePressed(java.awt.event.MouseEvent evt) {
//         this.dispose();
//         ExamScreen examScreen = new ExamScreen(login_id);
//         examScreen.setVisible(true);
//         System.out.println("Exams");
//     }

//     private void LogoutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButtonMousePressed
//         this.dispose();
//         LoginScreen loginScreen = new LoginScreen();
//         loginScreen.setVisible(true);
//     }

//     public static void main(String args[]) {

//         try {
//             javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
//         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//             java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         }

//         java.awt.EventQueue.invokeLater(() -> {
//             new StudentScreen(login_id).setVisible(true);
//         });
//     }

//     // Variables declaration - do not modify//GEN-BEGIN:variables
//     private javax.swing.JButton ExamsButton;
//     //private javax.swing.JButton ExamsButton;
//     private javax.swing.JLabel AppNameLabel;
//     private javax.swing.JButton AttendanceButton;
//     private javax.swing.JLabel BannerLabel;
//     private javax.swing.JPanel BannerPanel;
//     private javax.swing.JPanel ButtonPanel;
//     private javax.swing.JPanel ControlPanel;
//     private javax.swing.JButton LogoutButton;
//     private javax.swing.JPanel MenuOne;
//     private javax.swing.JPanel MenuTwo;
//     //private javax.swing.JButton StudentButton;
//     private javax.swing.JPanel TitlePanel;
// }


package screens;

import com.formdev.flatlaf.FlatLightLaf;
import java.net.URL;
import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;

public class StudentScreen extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);

    private static int login_id;

    private void customizeComponents() {
        setLocationRelativeTo(this);
    }

    public StudentScreen(int loginId) {
        login_id = loginId;
        initComponents();
        customizeComponents();
    }

    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitlePanel = new javax.swing.JPanel();
        AppNameLabel = new javax.swing.JLabel();
        BannerPanel = new javax.swing.JPanel();
        BannerLabel = new javax.swing.JLabel();
        LogoutButton = new javax.swing.JButton();
        ControlPanel = new javax.swing.JPanel();
        ButtonPanel = new javax.swing.JPanel();
        MenuOne = new javax.swing.JPanel();
        // StudentButton = new javax.swing.JButton();
        MenuTwo = new javax.swing.JPanel();
        AttendanceButton = new javax.swing.JButton();
        ExamsButton = new javax.swing.JButton();
        ResultsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setName("HomeFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        TitlePanel.setBackground(new java.awt.Color(51, 51, 51));

        AppNameLabel.setFont(AppNameLabel.getFont().deriveFont(AppNameLabel.getFont().getStyle() | java.awt.Font.BOLD,
                AppNameLabel.getFont().getSize() + 29));
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
                                .addComponent(AppNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        TitlePanelLayout.setVerticalGroup(
                TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TitlePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(AppNameLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        BannerPanelLayout.setVerticalGroup(
                BannerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BannerPanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(BannerLabel))
                        .addGroup(BannerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));

        ButtonPanel.setMinimumSize(new java.awt.Dimension(1180, 349));
        ButtonPanel.setOpaque(false);
        ButtonPanel.setLayout(new java.awt.GridLayout(2, 1, 10, 10));

        MenuOne.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        // StudentButton.setFont(StudentButton.getFont().deriveFont(StudentButton.getFont().getStyle()
        // | java.awt.Font.BOLD, StudentButton.getFont().getSize()+3));
        // StudentButton.setForeground(new java.awt.Color(80, 180, 140));
        // StudentButton.setIcon(new
        // javax.swing.ImageIcon(getClass().getResource("/assets/student.png"))); //
        // NOI18N
        // StudentButton.setText("STUDENT");
        // StudentButton.setBorder(null);
        // StudentButton.setBorderPainted(false);
        // StudentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        // StudentButton.setFocusable(false);
        // StudentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        // StudentButton.setOpaque(false);
        // StudentButton.setPreferredSize(new java.awt.Dimension(160, 160));
        // StudentButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        // StudentButton.addMouseListener(new java.awt.event.MouseAdapter() {
        // public void mousePressed(java.awt.event.MouseEvent evt) {
        // StudentButtonMousePressed(evt);
        // }
        // });
        // MenuOne.add(StudentButton);

        ButtonPanel.add(MenuOne);

        MenuTwo.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        AttendanceButton.setFont(AttendanceButton.getFont().deriveFont(
                AttendanceButton.getFont().getStyle() | java.awt.Font.BOLD, AttendanceButton.getFont().getSize() + 3));
        AttendanceButton.setForeground(new java.awt.Color(80, 180, 140));
        AttendanceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/attendance.png"))); // NOI18N
        AttendanceButton.setText("Attendance");
        AttendanceButton.setBorder(null);
        AttendanceButton.setBorderPainted(false);
        AttendanceButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AttendanceButton.setFocusable(false);
        AttendanceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AttendanceButton.setOpaque(false);
        AttendanceButton.setPreferredSize(new java.awt.Dimension(160, 160));
        AttendanceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AttendanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AttendanceButtonMousePressed(evt);
            }
        });

        MenuTwo.add(AttendanceButton);

        ExamsButton.setFont(ExamsButton.getFont().deriveFont(ExamsButton.getFont().getStyle() | java.awt.Font.BOLD,
                ExamsButton.getFont().getSize() + 3));
        ExamsButton.setForeground(new java.awt.Color(80, 180, 140));
        ExamsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/accounts.png"))); // NOI18N
        ExamsButton.setText("Exams");
        ExamsButton.setBorder(null);
        ExamsButton.setBorderPainted(false);
        ExamsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExamsButton.setFocusable(false);
        ExamsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ExamsButton.setOpaque(false);
        ExamsButton.setPreferredSize(new java.awt.Dimension(160, 160));
        ExamsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ExamsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExamsButtonMousePressed(evt);
            }
        });

        ResultsButton.setFont(ResultsButton.getFont().deriveFont(
                ResultsButton.getFont().getStyle() | java.awt.Font.BOLD, ResultsButton.getFont().getSize() + 3));
        ResultsButton.setForeground(new java.awt.Color(80, 180, 140));
        ResultsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/result.png"))); // NOI18N
        ResultsButton.setText("Results");
        ResultsButton.setBorder(null);
        ResultsButton.setBorderPainted(false);
        ResultsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultsButton.setFocusable(false);
        ResultsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ResultsButton.setOpaque(false);
        ResultsButton.setPreferredSize(new java.awt.Dimension(160, 160));
        ResultsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ResultsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResultButtonMousePressed(evt);
            }
        });

        MenuTwo.add(ExamsButton);
        MenuTwo.add(ResultsButton);

        ButtonPanel.add(MenuTwo);

        ControlPanel.add(ButtonPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(BannerPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1180,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BannerPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE)));

        pack();
    }

    private void AttendanceButtonMousePressed(java.awt.event.MouseEvent evt) {
        this.dispose();
        AttendanceScreen attendanceScreen = new AttendanceScreen(login_id);
        attendanceScreen.setVisible(true);
        System.out.println("Attendance");
    }

    private void ExamsButtonMousePressed(java.awt.event.MouseEvent evt) {
        this.dispose();
        ExamScreen examScreen = new ExamScreen(login_id);
        examScreen.setVisible(true);
        System.out.println("Exams");
    }

    private void LogoutButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_LogoutButtonMousePressed
        this.dispose();
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
    }

    private void ResultButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_LogoutButtonMousePressed
        this.dispose();
        ResultScreen resultscreen = new ResultScreen(login_id);
        resultscreen.setVisible(true);
    }

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new StudentScreen(login_id).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExamsButton;
    private javax.swing.JButton ResultsButton;
    // private javax.swing.JButton ExamsButton;
    private javax.swing.JLabel AppNameLabel;
    private javax.swing.JButton AttendanceButton;
    private javax.swing.JLabel BannerLabel;
    private javax.swing.JPanel BannerPanel;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JPanel MenuOne;
    private javax.swing.JPanel MenuTwo;
    // private javax.swing.JButton StudentButton;
    private javax.swing.JPanel TitlePanel;
}
