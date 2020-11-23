/**
 *
 * @author rajat
 */

package hotelmanagementsystem;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.sql.*;

import net.proteanit.sql.*;

public class ManagerDetails extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    ManagerDetails()
    {
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30,10,70,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(150,10,70,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(270,10,70,20);
        add(l3);
        
        JLabel l4 = new JLabel("Department");
        l4.setBounds(400,10,70,20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(520,10,70,20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone");
        l6.setBounds(650,10,70,20);
        add(l6);
        
        JLabel l7 = new JLabel("Email");
        l7.setBounds(780,10,70,20);
        add(l7);
        
        JLabel l8 = new JLabel("Aadhaar");
        l8.setBounds(900,10,70,20);
        add(l8);
        
        
        t1 = new JTable();
        t1.setBounds(0,40,1000,490);
        add(t1);
        
        b1 = new JButton("Load Data");
        b1.setBounds(350,530,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back to Reception");
        b2.setBounds(530,530,150,30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        add(b2);
        
        setLayout(null);
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try{
                Conn c = new Conn();
                String str = "select * from addEmployee where job = 'Manager'";
                ResultSet rs = c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }    
        else if(ae.getSource() == b2)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        
        
    }
    
    public static void main(String[] args)
    {
        new ManagerDetails().setVisible(true);
    }
    
}
