/**
 *
 * @author rajat
 */

package hotelmanagementsystem;

import java.awt.Choice;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {
     
    Choice c1;
    JButton b1,b2,b3;
    JTextField t1,t2,t3;
    UpdateRoom()
    {
        JLabel l1 = new JLabel("Update Customer Details");
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        l1.setBounds(70,20,350,30);
        l1.setForeground(Color.RED);
        add(l1);
        
        JLabel guestid = new JLabel("Guest ID");
        guestid.setFont(new Font("Tahoma",Font.PLAIN,17));
        guestid.setBounds(30,70,120,30);
        add(guestid);
        c1 = new Choice();
        try{
            Conn c = new Conn();
            String st = "Select * from addCustomer";
            ResultSet rs = c.s.executeQuery(st);
            while(rs.next())
            {
                c1.add(rs.getString("number"));
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        c1.setBounds(170,70,150,30);
        add(c1);
        
        JLabel roomno = new JLabel("Room No.");
        roomno.setFont(new Font("Tahoma",Font.PLAIN,17));
        roomno.setBounds(30,120,120,30);
        add(roomno);
        t1 = new JTextField();
        t1.setBounds(170,120,150,30);
        add(t1);
        
        JLabel availability = new JLabel("Availability");
        availability.setFont(new Font("Tahoma",Font.PLAIN,17));
        availability.setBounds(30,170,120,30);
        add(availability);
        t2 = new JTextField();
        t2.setBounds(170,170,150,30);
        add(t2);
        
        JLabel cleanstatus = new JLabel("Clean Status");
        cleanstatus.setFont(new Font("Tahoma",Font.PLAIN,17));
        cleanstatus.setBounds(30,220,120,30);
        add(cleanstatus);
        t3 = new JTextField();
        t3.setBounds(170,220,150,30);
        add(t3);
        
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,270,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180,270,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back to Reception");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(80,320,180,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/roomupdate.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(370,70,400,320);
        add(icon);
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(350,200,800,500);
        setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1 )
        {
            String room = null;
            String s1 = c1.getSelectedItem();
            Conn c = new Conn();
            try{
                String st1 = "select * from addCustomer where number = '"+s1+"'";
                ResultSet rs1 = c.s.executeQuery(st1);
                while(rs1.next())
                {
                    t1.setText(rs1.getString("room_number"));
                    room = rs1.getString("room_number");
                }
                String st2 = "select * from addRoom where room_number = '"+room+"'";
                ResultSet rs2 = c.s.executeQuery(st2);
                while(rs2.next())
                {
                    t2.setText(rs2.getString("availability"));
                    t3.setText(rs2.getString("clean_status"));
                }
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
                    
            
        }
        else if (ae.getSource() == b2)
        {
            try{
                Conn c = new Conn();
                String room = t1.getText();
                String available = t2.getText();
                String status = t3.getText();
                
                String s = "Update addroom set availability = '"+available+"', clean_status = '"+status+"'"
                        + " where room_number = '"+room+"'";         
                c.s.executeUpdate(s);
                JOptionPane.showMessageDialog(null,"Room updated Successfully");
                new Reception().setVisible(true);
                this.setVisible(false);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == b3)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
            
        
    }
    
    public static void main(String[] args)
    {
        new UpdateRoom().setVisible(true);
    }
    
}
