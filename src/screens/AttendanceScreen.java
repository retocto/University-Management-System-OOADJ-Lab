// package screens;

// // import com.formdev.flatlaf.FlatLightLaf;
// // import com.mysql.cj.protocol.Resultset;

// // import java.net.URL;
// // import javax.swing.ImageIcon;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.util.*;

// import repository.DBConnection;

// public class AttendanceScreen extends javax.swing.JFrame {
//     Connection conn = new DBConnection().connect();
//     private static int login_id;
//     Map<String, Integer> courses = new HashMap<String, Integer>();
    
//     public AttendanceScreen(int loginId) {
//         login_id=loginId;
//         // initComponents();
//         // customizeComponents();
//         getAttendance();
//         customizeComponents();
//         initComponents();
//     }

//     public void getAttendance()
//     {
//         String getSRN_sql = "SELECT srn FROM student WHERE login_id=?";
//         String course_sql = "SELECT * from course WHERE srn=?";
            
//         PreparedStatement stmt = null;
//         try{
//             stmt = conn.prepareStatement(getSRN_sql);
//             stmt.setInt(1, login_id);

//             ResultSet resultSet = stmt.executeQuery();

//             resultSet.next();
//             stmt = null;
//             stmt = conn.prepareStatement(course_sql);
//             stmt.setString(1, resultSet.getString("srn"));
//             resultSet = stmt.executeQuery();
//             while(resultSet.next())
//             {
//                 courses.put(resultSet.getString("course_name"),Integer.valueOf(resultSet.getInt("attendance")));
//                 System.out.println(resultSet.getString("course_name")+Integer.valueOf(resultSet.getInt("attendance")));
//             }
            
//         }
//         catch(Exception e)
//         {
//             System.out.println(e);
//         }
//     }
    
//     private void customizeComponents() {
//         setLocationRelativeTo(this);
//     }

//     private void initComponents() {

//         jLabel1 = new javax.swing.JLabel();
//         jLabel2 = new javax.swing.JLabel();
//         jButton1 = new javax.swing.JButton();
//         jScrollPane1 = new javax.swing.JScrollPane();
//         jTextArea1 = new javax.swing.JTextArea();

//         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//         jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
//         jLabel1.setText("Course Name");

//         jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
//         jLabel2.setText("Attendance");

//         jButton1.setBackground(new java.awt.Color(0, 0, 0));
//         jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
//         jButton1.setForeground(new java.awt.Color(255, 255, 255));
//         jButton1.setText("View Attendance");

//         jTextArea1.setEditable(false);
//         jTextArea1.setColumns(20);
//         jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
//         jTextArea1.setLineWrap(true);
//         jTextArea1.setRows(5);
//         String data="";
//         for(Map.Entry<String, Integer> e : courses.entrySet())
//         {
//             data+=e.getKey()+"\t"+Integer.toString(e.getValue())+"\n";
//         }
//         jTextArea1.setText(data);
//         jScrollPane1.setViewportView(jTextArea1);

//         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//         getContentPane().setLayout(layout);
//         layout.setHorizontalGroup(
//                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                         .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
//                                 javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                         .addGroup(layout.createSequentialGroup()
//                                 .addGap(171, 171, 171)
//                                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                         .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230,
//                                                 javax.swing.GroupLayout.PREFERRED_SIZE)
//                                         .addGroup(layout.createSequentialGroup()
//                                                 .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118,
//                                                         javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                 .addGap(18, 18, 18)
//                                                 .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118,
//                                                         javax.swing.GroupLayout.PREFERRED_SIZE)))
//                                 .addContainerGap(202, Short.MAX_VALUE)));
//         layout.setVerticalGroup(
//                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                         .addGroup(layout.createSequentialGroup()
//                                 .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
//                                         javax.swing.GroupLayout.PREFERRED_SIZE)
//                                 .addGap(18, 18, 18)
//                                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                         .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
//                                                 javax.swing.GroupLayout.PREFERRED_SIZE)
//                                         .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
//                                                 javax.swing.GroupLayout.PREFERRED_SIZE))
//                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365,
//                                         javax.swing.GroupLayout.PREFERRED_SIZE)
//                                 .addContainerGap(25, Short.MAX_VALUE)));

//         pack();
//     }

//     public static void main(String args[]) {
//         try {
//             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                 if ("Nimbus".equals(info.getName())) {
//                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                     break;
//                 }
//             }
//         } catch (ClassNotFoundException ex) {
//             java.util.logging.Logger.getLogger(AttendanceScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
//                     ex);
//         } catch (InstantiationException ex) {
//             java.util.logging.Logger.getLogger(AttendanceScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
//                     ex);
//         } catch (IllegalAccessException ex) {
//             java.util.logging.Logger.getLogger(AttendanceScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
//                     ex);
//         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//             java.util.logging.Logger.getLogger(AttendanceScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
//                     ex);
//         }
//         // </editor-fold>

//         /* Create and display the form */
//         java.awt.EventQueue.invokeLater(new Runnable() {
//             public void run() {
//                 new AttendanceScreen(login_id).setVisible(true);
//             }
//         });
//     }

//     private javax.swing.JButton jButton1;
//     private javax.swing.JLabel jLabel1;
//     private javax.swing.JLabel jLabel2;
//     private javax.swing.JScrollPane jScrollPane1;
//     private javax.swing.JTextArea jTextArea1;
// }



package screens;

// import com.formdev.flatlaf.FlatLightLaf;
// import com.mysql.cj.protocol.Resultset;

// import java.net.URL;
// import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import repository.DBConnection;

public class AttendanceScreen extends javax.swing.JFrame {
    Connection conn = new DBConnection().connect();
    private static int login_id;
    Map<String, Integer> courses = new HashMap<String, Integer>();

    public AttendanceScreen(int loginId) {
        login_id = loginId;
        // initComponents();
        // customizeComponents();
        getAttendance();
        customizeComponents();
        initComponents();
    }

    public void getAttendance() {
        String getSRN_sql = "SELECT srn FROM student WHERE login_id=?";
        String course_sql = "SELECT * from course WHERE srn=?";

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(getSRN_sql);
            stmt.setInt(1, login_id);

            ResultSet resultSet = stmt.executeQuery();

            resultSet.next();
            stmt = null;
            stmt = conn.prepareStatement(course_sql);
            stmt.setString(1, resultSet.getString("srn"));
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                courses.put(resultSet.getString("course_name"), Integer.valueOf(resultSet.getInt("attendance")));
                System.out
                        .println(resultSet.getString("course_name") + Integer.valueOf(resultSet.getInt("attendance")));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void customizeComponents() {
        setLocationRelativeTo(this);
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Course Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Attendance");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Attendance");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("sample1\t25/35\nsample2\t23/35");
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        String data = "";
        for (Map.Entry<String, Integer> e : courses.entrySet()) {
            data += e.getKey() + "\t" + Integer.toString(e.getValue()) + "\n";
        }
        jTextArea1.setText(data);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jButton2)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(202, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton2)
                                .addContainerGap(34, Short.MAX_VALUE)));

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        StudentScreen studentscreen = new StudentScreen(login_id);
        studentscreen.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AttendanceScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceScreen(login_id).setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
}
