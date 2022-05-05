package screens;

//import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import repository.DBConnection;

// import com.formdev.flatlaf.FlatLightLaf;
// import java.net.URL;
// import javax.swing.ImageIcon;
// import java.sql.Connection;
// import repository.DBConnection;

public class EvaluateScreen extends javax.swing.JFrame {
    private static int login_id,count=0,maxAnswers,total_marks=0;
    //private static String srn;
    Map<String, Integer> courses = new HashMap<String, Integer>();//coursename:course_id
    //Map<Integer, String> answers = new HashMap<Integer, String>();
    Map<Integer,Map<String,String>> answers = new HashMap<Integer,Map<String,String>>();//q_id:srn:answer
    static Map<Integer,Integer> questions = new HashMap<Integer,Integer>();//index:q_id
    Map<Integer,String> all_questions = new HashMap<Integer,String>();//q_id:question
    Map<Integer, Integer> q_marks = new HashMap<Integer, Integer>();//q_id:marks
    Map<Integer, Integer> q_courses = new HashMap<Integer, Integer>();//q_id:course_id
    Connection conn = new DBConnection().connect();
    public EvaluateScreen(int loginId)
    {
        login_id = loginId;
        getCourses();
        getAnswers();
        System.out.println(all_questions);
        initComponents();
        // System.out.println("q_marks: ");
        // System.out.println(answers);
    }

    public void getCourses()
    {
        String courseID_sql = "SELECT course_id FROM teaching WHERE login_id=?"; 
        PreparedStatement stmt = null;
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
                int i=0,total=0;
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
                        total++;
                    }
                }
                System.out.println(answers);
                maxAnswers=total;
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
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Evaluation");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Select Course :");

        String[] allCourses = new String[courses.size()];
        int i=0;
        for(Map.Entry<String, Integer> e : courses.entrySet())
        {
            allCourses[i] = e.getKey();
            i++;
        }
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setModel(
                new javax.swing.DefaultComboBoxModel<>(allCourses));
        // jComboBox1.addActionListener(new ActionListener(){
        //     public void actionPerformed(ActionEvent e)
        //     {
        //         getCourses;
        //     }
        // });
        int cID=q_courses.get(questions.get(count));
        String cur_course="";
        for(Map.Entry<String, Integer> entry : courses.entrySet())
        {
            if(entry.getValue()==cID)
            {
                cur_course=entry.getKey();
                break;
            }
        }
        jComboBox1.setSelectedItem(cur_course);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Student ID :");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox2.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Q no : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText(Integer.toString(count+1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.setText(all_questions.get(questions.get(count)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Marks :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText(Integer.toString(q_marks.get(questions.get(count))));
        // System.out.println(questions);
        // System.out.println(questions.get(count));
        // System.out.println(questions.get(0));

        //System.out.println(typeof());

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);
        jTextArea2.setText(answers.get(questions.get(count)).get("001"));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Student's Answer");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Prev");
        // jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
        //     public void mousePressed(java.awt.event.MouseEvent evt) {
        //         PrevButtonMousePressed(evt);
        //     }
        //     });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Next");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NextButtonMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Marks Obtained");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Submit");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubmitButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 724,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel1,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        130,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jComboBox1,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(158, 158, 158)
                                                                                .addComponent(jLabel2,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        130,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel3,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        64,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel4,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        51,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel5,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        64,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel6,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        51,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jComboBox2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel8,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                161,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jTextField1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                71,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jButton2)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(jButton3))
                                                                .addComponent(jScrollPane2,
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 724,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(333, 333, 333)
                                                .addComponent(jButton4)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addContainerGap(25, Short.MAX_VALUE)));

        pack();
        jComboBox2.setVisible(false);
        if(count==maxAnswers-1)
        {
            jButton3.setVisible(false);
        }
        if(count!=maxAnswers-1)
        {
            jButton4.setVisible(false);
        }
        jButton2.setVisible(false);
        jLabel2.setVisible(false);
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NextButtonMousePressed(java.awt.event.MouseEvent evt) {
        //this.dispose();
        removeAll();
        String marks = jTextField1.getText();
        total_marks += Integer.parseInt(marks);
        if(count<maxAnswers-1)
        {
            count++;
            this.dispose();
            main(null);
        }
        
        //initComponents(index);
    }

    private void SubmitButtonMousePressed(java.awt.event.MouseEvent evt) {
        //this.dispose();
        removeAll();
        String marks = jTextField1.getText();
        total_marks += Integer.parseInt(marks);
        setMarks();
        System.exit(0);
        //initComponents(index);
    }

    // private void PrevButtonMousePressed(java.awt.event.MouseEvent evt) {
    //     //this.dispose();
    //     removeAll();
    //     //setAnswer(count);
    //     if(count>0)
    //     {
    //         count--;
    //         this.dispose();
    //         main(null);
    //     }
    //     //initComponents(index);
    // }

    private void setMarks()
    {
        
        //answers.put(count,answer);
        //System.out.println(que);
        String insert_sql = "insert into exam values("+courses.get(jComboBox1.getSelectedItem())+",'001',"+total_marks+");"; 
        try{
            //stmt = conn.prepareStatement(insert_sql);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(insert_sql);
            System.out.println("Marks added Successfully");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
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
            java.util.logging.Logger.getLogger(EvaluateScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EvaluateScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EvaluateScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EvaluateScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EvaluateScreen(login_id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration
}
