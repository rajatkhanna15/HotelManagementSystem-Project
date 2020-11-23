/**
 *
 * @author rajat
 */

package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    Room()
    {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(500,0,500,600);
        add(icon);
        
        
        t1 = new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);
        
        JLabel l1 = new JLabel("Room No.");
        l1.setBounds(10,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(120,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(230,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(330,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(400,10,100,20);
        add(l5);
        
        b1 = new JButton("Load Data");
        b1.setBounds(100,460,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back to Reception");
        b2.setBounds(260,460,150,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(450,200,1000,550);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try{
                Conn c = new Conn();
                String str = "select * from addRoom";
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
        new Room().setVisible(true);
    }
    
}