package screens;

// import com.formdev.flatlaf.FlatLightLaf;
// import java.net.URL;
// import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import repository.DBConnection;

public class ExamScreen extends javax.swing.JFrame {
    Connection conn = new DBConnection().connect();
    List<Integer> attended = new ArrayList<Integer>();
    List<Integer> pending = new ArrayList<Integer>();
    Map<String,Integer> questions = new HashMap<String,Integer>();
    Map<Integer,String> indices = new HashMap<Integer,String>();
    static Map<Integer,String> answers = new HashMap<Integer,String>();
    Map<Integer,Integer> questionID = new HashMap<Integer,Integer>();
    private static int login_id;
    private static int count=0,maxQuestions;
    private static String srn;

    private void customizeComponents() {
        setLocationRelativeTo(this);
    }

    public ExamScreen(int loginId)
    {
        login_id = loginId;
        getQuestions();
        customizeComponents();
        initComponents(count);
    }

    public void getQuestions()
    {
        String getSRN_sql = "SELECT srn FROM student WHERE login_id=?";
        String attend_sql = "SELECT DISTINCT(course_id) from exam WHERE srn=?";
        String exam_sql = "SELECT DISTINCT(course_id) from question";
        String questions_sql = "SELECT * from question where course_id=?";
        PreparedStatement stmt = null;
        try{
            stmt = conn.prepareStatement(getSRN_sql);
            stmt.setInt(1, login_id);

            ResultSet resultSet = stmt.executeQuery();

            resultSet.next();
            stmt = null;
            stmt = conn.prepareStatement(attend_sql);
            srn = resultSet.getString("srn");
            stmt.setString(1, srn);
            resultSet = stmt.executeQuery();

            while(resultSet.next())
            {
                attended.add(resultSet.getInt("course_id"));
            }
            stmt = conn.prepareStatement(exam_sql);
            ResultSet QuestionSet = stmt.executeQuery();
            while(QuestionSet.next())
            {
                int cid = QuestionSet.getInt("course_id");
                if(!attended.contains(cid))
                {
                    pending.add(cid);
                }
            }
            stmt = conn.prepareStatement(questions_sql);
            stmt.setInt(1, pending.get(0));

            resultSet = stmt.executeQuery();
            int i=0;
            while(resultSet.next())
            {
                String que = resultSet.getString("que");
                questions.put(que,resultSet.getInt("marks"));
                indices.put(i,que);
                questionID.put(i,resultSet.getInt("q_id"));
                i++;
            }
            maxQuestions = i;
            //System.out.println(questions);
            // if(pending.size()==0)
            // {
            //     System.out.println("No exams Scheduled");
            //     System.exit(0);
            // }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void initComponents(int index){
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Computer based test");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setText("Course ID : ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel2.setText(Integer.toString(pending.get(0)));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText(indices.get(index));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel3.setText("Q no : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel4.setText(Integer.toString(index+1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel5.setText("Marks :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel6.setText(Integer.toString(questions.get(indices.get(index))));

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel7.setText("Write your answer below");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Next");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            NextButtonMousePressed(evt,index+1);
        }
        });
        
        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Submit");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubmitButtonMousePressed(evt);
            }
        });
        
        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Prev");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PrevButtonMousePressed(evt,index-1);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(99, 99, 99))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 86,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 87,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jButton4,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        92,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(jButton2,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        92,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                683, Short.MAX_VALUE)
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                layout.createSequentialGroup()
                                                                                        .addGap(6, 6, 6)
                                                                                        .addComponent(jLabel7,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                448,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.Alignment.LEADING))))
                                                .addGap(14, 46, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton4))
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addContainerGap(64, Short.MAX_VALUE)));

        pack();
        if(index==maxQuestions-1)
        {
            jButton2.setVisible(false);
        }
        if(index!=maxQuestions-1)
        {
            jButton3.setVisible(false);
        }
        if(index<=0)
        {
            jButton4.setVisible(false);
        }
        if(answers.get(count)!=null)
            jTextArea2.setText(answers.get(count));
    }

    private void NextButtonMousePressed(java.awt.event.MouseEvent evt,int index) {
        //this.dispose();
        removeAll();
        setAnswer(count);
        if(count<maxQuestions-1)
        {
            count++;
            this.dispose();
            main(null);
        }
        
        //initComponents(index);
    }

    private void PrevButtonMousePressed(java.awt.event.MouseEvent evt,int index) {
        //this.dispose();
        removeAll();
        setAnswer(count);
        if(count>0)
        {
            count--;
            this.dispose();
            main(null);
        }
        //initComponents(index);
    }

    private void SubmitButtonMousePressed(java.awt.event.MouseEvent evt)
    {
        String answer = (String)jTextArea2.getText();
        answers.put(count,answer);
        for(Map.Entry<Integer,String> entry : answers.entrySet())
        {
            String insert_sql = "insert into answer values("+questionID.get(entry.getKey())+",'"+srn+"','"+entry.getValue()+"');"; 
            try{
                //stmt = conn.prepareStatement(insert_sql);
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(insert_sql);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        System.out.println("Submitted Successfully");
        System.exit(0);
    }

    private void setAnswer(int count)
    {
        String answer = (String)jTextArea2.getText();
        answers.put(count,answer);
        System.out.println(answers.get(count));
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
            java.util.logging.Logger.getLogger(ExamScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamScreen(login_id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
}
