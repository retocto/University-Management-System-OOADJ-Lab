package screens;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class HomeScreen extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);


    public HomeScreen(int login_id,int role) {
        switch(role)
        {
            //case 0:
            case 1:
                FacultyScreen facultyScreen = new FacultyScreen(login_id);
                facultyScreen.setVisible(true);
                break;
            case 2:
                StudentScreen studentScreen = new StudentScreen(login_id);
                studentScreen.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "You Are Not Authorised", "Access Denied", 0);
                break;
        }
    }
}
