/**
 *
 * @author rajat
 */
package hotelmanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;


public class CheckOut extends JFrame implements ActionListener
{
    JTextField t1;
    JButton b1,b2,b3;
    Choice c1;
    CheckOut()
    {
        JLabel l1 = new JLabel("CHECK OUT");
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        l1.setForeground(Color.ORANGE);
        l1.setBounds(50,20,150,30);
        add(l1);
        
        JLabel guestid = new JLabel("ID");
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
        c1.setBounds(150,70,150,30);
        add(c1);
        
        JLabel roomno = new JLabel("Room No.");
        roomno.setFont(new Font("Tahoma",Font.PLAIN,17));
        roomno.setBounds(30,120,120,30);
        add(roomno);
        t1 = new JTextField();
        t1.setBounds(150,120,150,30);
        add(t1);
        
        b1 = new JButton("Check Out");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,250,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back To Reception");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180,250,150,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(310,70,20,20);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/checkout.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel icon = new JLabel(i6);
        icon.setBounds(370,30,400,300);
        add(icon);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300,200,800,400);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            String id = c1.getSelectedItem();
            String roomnumber = t1.getText();
            String s1 = "Delete from addCustomer where number = '"+id+"'";
            String s2 = "Update addroom set availability = 'available' where room_number = '"+roomnumber+"'";
            Conn c = new Conn();
            try{
                c.s.executeUpdate(s1);
                c.s.executeUpdate(s2);
                JOptionPane.showMessageDialog(null,"Check out Successful");
                new Reception().setVisible(true);
                this.setVisible(false);
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
        else if(ae.getSource() == b3)
        {
            Conn c = new Conn();
            String id = c1.getSelectedItem();
            try{
                String st = "select * from addcustomer where number = '"+id+"'";
                ResultSet rs = c.s.executeQuery(st);
                while(rs.next())
                {
                    t1.setText(rs.getString("room_number"));
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
    }
    
    public static void main(String[] args)
    {
        new CheckOut().setVisible(true);
    }
    
}
