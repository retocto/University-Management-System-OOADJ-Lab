package screens;

// import com.formdev.flatlaf.FlatLightLaf;
// import java.net.URL;
// import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import repository.DBConnection;
import java.util.*;

public class TakeAttendanceScreen extends javax.swing.JFrame {
    Connection conn = new DBConnection().connect();
    private static int login_id;


    Map<String, Integer> courses = new HashMap<String, Integer>();//coursename:course_id
    //Map<Integer, String> answers = new HashMap<Integer, String>();
    Map<Integer,Map<String,String>> answers = new HashMap<Integer,Map<String,String>>();//q_id:srn:answer
    static Map<Integer,Integer> questions = new HashMap<Integer,Integer>();//index:q_id
    Map<Integer,String> all_questions = new HashMap<Integer,String>();//q_id:question
    Map<Integer, Integer> q_marks = new HashMap<Integer, Integer>();//q_id:marks
    Map<Integer, Integer> q_courses = new HashMap<Integer, Integer>();//q_id:course_id
    Map<String, Integer> attendance = new HashMap<String, Integer>();

    public TakeAttendanceScreen(int loginId)
    {
        login_id = loginId;
        getCourses();
        getAnswers();
        initComponents();
    }

    public void getCourses()
    {
        String courseID_sql = "SELECT course_id FROM teaching WHERE login_id=?"; 
        String at_sql = "SELECT * FROM course WHERE course_id=?"; 
        PreparedStatement stmt = null;
        int last=0;
        try{
            stmt = conn.prepareStatement(courseID_sql);
            stmt.setInt(1, login_id);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()) {
                String courseName_sql = "SELECT DISTINCT(course_name) from course where course_id=?";
                PreparedStatement name_stmt = null;
                name_stmt = conn.prepareStatement(courseName_sql);
                int course_id = resultSet.getInt("course_id");
                name_stmt.setInt(1, course_id);

                ResultSet resultSet2 = name_stmt.executeQuery();
                resultSet2.next();
                courses.put(resultSet2.getString("course_name"),course_id);
                last=course_id;
            }
            stmt = conn.prepareStatement(at_sql);
            stmt.setInt(1, last);

            resultSet = stmt.executeQuery();
            while(resultSet.next())
            {
                attendance.put(resultSet.getString("srn"),resultSet.getInt("attendance"));
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }

    public void getAnswers()
    {
        String qID_sql = "SELECT * FROM question WHERE course_id=?"; 
        PreparedStatement stmt = null;
        for(Map.Entry<String,Integer> entry : courses.entrySet())
        {
            try{
                //int t= entry.getValue();
                stmt = conn.prepareStatement(qID_sql);
                stmt.setInt(1, entry.getValue());
        
                ResultSet resultSet = stmt.executeQuery();
                int i=0;
                while(resultSet.next()) {
                    String answer_sql = "SELECT * from answer where q_id=?";
                    PreparedStatement answer_stmt = null;
                    answer_stmt = conn.prepareStatement(answer_sql);
                    int q_id = resultSet.getInt("q_id");
                    questions.put(i,q_id);
                    i++;
                    answer_stmt.setInt(1, q_id);
                    ResultSet resultSet2 = answer_stmt.executeQuery();
                    q_marks.put(q_id,resultSet.getInt("marks"));
                    all_questions.put(q_id,resultSet.getString("que"));
                    q_courses.put(q_id,resultSet.getInt("course_id"));
                    while(resultSet2.next())
                    {
                        Map<String,String> mp = new HashMap<String,String>();
                        mp.put(resultSet2.getString("srn"),resultSet2.getString("answer"));
                        answers.put(q_id,mp);
                        System.out.println(resultSet2.getString("srn"));
                        //total++;
                    }
                }
                System.out.println(answers);
                //System.out.print(resultSet2.getString("srn"));
                //courses.put(resultSet2.getString("course_name"),course_id);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        }



    public void initComponents()
    {
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update Attendance");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setAutoscrolls(true);
        String data="";
        for(Map.Entry<String,Integer> entry : attendance.entrySet())
        {
            data+=entry.getKey()+" \t"+entry.getValue()+"\n";
        }
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText(data);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("+");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("23");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(38, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jButton2)
                                        .addComponent(jLabel3))
                                .addContainerGap(389, Short.MAX_VALUE)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Select Course : ");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "DAA", "OOAD"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(106, 106, 106)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(216, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)));

        pack();
        jButton2.setVisible(false);
        jLabel3.setVisible(false);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(TakeAttendanceScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeAttendanceScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeAttendanceScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeAttendanceScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeAttendanceScreen(login_id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
