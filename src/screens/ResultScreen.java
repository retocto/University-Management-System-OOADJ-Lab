package screens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.*;

import repository.DBConnection;

public class ResultScreen extends javax.swing.JFrame {
    Connection conn = new DBConnection().connect();
    Map<Integer,Integer> results = new HashMap<Integer,Integer>();//course_id:marks
    Map<Integer,String> courses = new HashMap<Integer,String>();//course_id:course
    private static int login_id;

    public ResultScreen(int LoginID) {
        login_id = LoginID;
        getResults();
        System.out.println(courses);
        initComponents();
    }

    private void getResults()
    {
        String getSRN_sql = "SELECT srn FROM student WHERE login_id=?";
        String exam_sql = "SELECT * from exam WHERE srn=?";
        String course_sql = "SELECT * from course WHERE course_id=?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(getSRN_sql);
            stmt.setInt(1, login_id);

            ResultSet resultSet = stmt.executeQuery();

            resultSet.next();
            stmt = null;
            stmt = conn.prepareStatement(exam_sql);
            stmt.setString(1, resultSet.getString("srn"));
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                results.put(resultSet.getInt("course_id"), Integer.valueOf(resultSet.getInt("marks")));
            }
            stmt = conn.prepareStatement(course_sql);
            for(Map.Entry<Integer,Integer> entry : results.entrySet())
            {
                stmt.setInt(1, entry.getKey());
                resultSet = stmt.executeQuery();
                resultSet.next();
                courses.put(entry.getKey(),resultSet.getString("course_name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //@SuppressWarnings("unchecked")
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Results");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        String data="";
        for(Map.Entry<Integer,Integer> entry : results.entrySet())
        {
            data+=entry.getKey()+" : "+courses.get(entry.getKey())+"\t"+entry.getValue()+"\n";
        }
        jTextArea1.setText(data);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("back");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 182, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(106, 106, 106)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22,
                                        Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(21, 21, 21)));

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.MouseEvent evt) {
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
            java.util.logging.Logger.getLogger(ResultScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultScreen(login_id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration
}
