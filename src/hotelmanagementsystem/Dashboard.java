/**
 *
 * @author rajat
 */
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem it1,it2,it3,it4;
    
    Dashboard()
    {
        mb = new JMenuBar();
        mb.setBackground(Color.red);
        add(mb);
        m1 = new JMenu("RECEPTION");
        m1.setForeground(Color.black);
        mb.add(m1);
        
        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.black);
        mb.add(m2);
        
        it1 = new JMenuItem("Login");
        it1.addActionListener(this);
        it1.setBackground(Color.cyan);
        m1.add(it1);
        
        it2 = new JMenuItem("Add Employees");
        it2.addActionListener(this);
        it2.setBackground(Color.cyan);
        m2.add(it2);
        
        it3 = new JMenuItem("Add Rooms");
        it3.addActionListener(this);
        it3.setBackground(Color.cyan);
        m2.add(it3);
        
        it4 = new JMenuItem("Add Drivers");
        it4.addActionListener(this);
        it4.setBackground(Color.cyan);
        m2.add(it4);
        
        mb.setBounds(0,0,1950,30);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/resort.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1950,1060);
        add(l1);
        
        JLabel l2 = new JLabel("HOTEL RAJ PALACE WELCOMES YOU");
        l2.setBounds(400,60,1000,50);
        l2.setForeground(Color.red);
        l2.setFont(new Font("Tahoma",Font.BOLD,46));
        l1.add(l2);
        
        setLayout(null);
        setBounds(0,0,1950,1080);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("RECEPTION"))
        {
            
        }
            
        else if(ae.getActionCommand().equals("Add Employees"))
        {
            new AddEmployee().setVisible(true);
            this.setVisible(false);
        }
        else if (ae.getActionCommand().equals("Add Rooms"))
        {
            new AddRoom().setVisible(true);
            this.setVisible(false);
        }
        
    }
    
    public static void main(String[] args)
    {
        new Dashboard();
    }

    
    
}
