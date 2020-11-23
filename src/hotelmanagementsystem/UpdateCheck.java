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

public class UpdateCheck extends JFrame implements ActionListener {
     
    Choice c1;
    JButton b1,b2,b3;
    JTextField t1,t2,t3,t4,t5;
    UpdateCheck()
    {
        JLabel l1 = new JLabel("CHECK IN DETAILS");
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        l1.setBounds(70,20,350,30);
        l1.setForeground(Color.magenta);
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
        c1.setBounds(170,70,150,30);
        add(c1);
        
        JLabel roomno = new JLabel("Room No.");
        roomno.setFont(new Font("Tahoma",Font.PLAIN,17));
        roomno.setBounds(30,120,120,30);
        add(roomno);
        t1 = new JTextField();
        t1.setBounds(170,120,150,30);
        add(t1);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(30,170,120,30);
        add(name);
        t2 = new JTextField();
        t2.setBounds(170,170,150,30);
        add(t2);
        
        JLabel checkinstatus = new JLabel("Checked in");
        checkinstatus.setFont(new Font("Tahoma",Font.PLAIN,17));
        checkinstatus.setBounds(30,220,120,30);
        add(checkinstatus);
        t3 = new JTextField();
        t3.setBounds(170,220,150,30);
        add(t3);
        
        JLabel amountpaid = new JLabel("Amount Paid");
        amountpaid.setFont(new Font("Tahoma",Font.PLAIN,17));
        amountpaid.setBounds(30,270,120,30);
        add(amountpaid);
        t4 = new JTextField();
        t4.setBounds(170,270,150,30);
        add(t4);
        
        JLabel amountpending = new JLabel("Pending Amount");
        amountpending.setFont(new Font("Tahoma",Font.PLAIN,17));
        amountpending.setBounds(30,320,140,30);
        add(amountpending);
        t5 = new JTextField();
        t5.setBounds(170,320,150,30);
        add(t5);
        
        
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,360,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180,360,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back to Reception");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(80,400,180,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/checkincheckout.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,370,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(370,70,600,370);
        add(icon);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(350,200,1000,500);
        setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1 )
        {
            
            String id = c1.getSelectedItem();
            Conn c = new Conn();
            try{
                String room_number = null;
                String deposit = null;
                String price = null;
                int amountpending;
                String st1 = "select * from addCustomer where number = '"+id+"'";
                ResultSet rs1 = c.s.executeQuery(st1);
                while(rs1.next())
                {
                    
                    t1.setText(rs1.getString("room_number"));
                    t2.setText(rs1.getString("name"));
                    t3.setText(rs1.getString("status"));
                    t4.setText(rs1.getString("deposit"));
                    room_number = rs1.getString("room_number");
                    deposit = rs1.getString("deposit");
                }
                String st2 = "select * from addRoom where room_number = '"+room_number+"'";
                ResultSet rs2 = c.s.executeQuery(st2);
                while(rs2.next())
                {
                    price = rs2.getString("price");
                    amountpending = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountpending));
                    
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
        new UpdateCheck().setVisible(true);
    }
    
}
