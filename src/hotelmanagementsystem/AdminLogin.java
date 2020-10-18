/**
 *
 * @author rajat
 */

package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;


public class AdminLogin extends JFrame {
    
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    AdminLogin()
    {
        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        
        b1 = new JButton("Login");
        b1.setBounds(40,140,100,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
       // b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,100,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,10,150,150);
        add(l3);
        
        getContentPane().setBackground(Color.WHITE);

        
        setBounds(600,300,600,300);
        setLayout(null);
        setVisible(true);
        
    }
    
    public static void main(String[] args)
    {
        new AdminLogin();
    }
    
}
