
/**
 *
 * @author rajat
 */
package hotelmanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener{
    
    JButton b1,b2;
    JTable t1;
    Choice c1;
    Pickup()
    {
        JLabel l1 = new JLabel("PICK UP SERVICE");
        l1.setBounds(150,20,250,30);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        add(l1);
        
        JLabel l2 = new JLabel("Type of Car");
        l2.setBounds(30,70,150,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(l2);
        c1 = new Choice();
        Conn c = new Conn();
        try
        {
            String st = "Select * from addDriver";
            ResultSet rs = c.s.executeQuery(st);
            while(rs.next())
            {   
                c1.add(rs.getString("brand"));
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        c1.setBounds(200,70,150,30);
        add(c1);
        
        t1 = new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(20,170,150,30);
        add(l3);
        
        JLabel l4 = new JLabel("Age");
        l4.setBounds(180,170,150,30);
        add(l4);
        
        JLabel l5 = new JLabel("Gender");
        l5.setBounds(320,170,150,30);
        add(l5);
        
        JLabel l6 = new JLabel("Company");
        l6.setBounds(460,170,150,30);
        add(l6);
        
        JLabel l7 = new JLabel("Brand");
        l7.setBounds(600,170,150,30);
        add(l7);
        
        JLabel l8 = new JLabel("Availability");
        l8.setBounds(730,170,150,30);
        add(l8);
        
        JLabel l9 = new JLabel("Location");
        l9.setBounds(880,170,150,30);
        add(l9);
        
        
        b1 = new JButton("Search");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(80,550,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back to Reception");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(380,550,180,30);
        b2.addActionListener(this);
        add(b2);
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300,100,1000,700);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            String brand = (String) c1.getSelectedItem();
            Conn c = new Conn();
            try{
                String st1 = "select * from addDriver where brand = '"+brand+"'";
                ResultSet rs1 = c.s.executeQuery(st1);
                t1.setModel(DbUtils.resultSetToTableModel(rs1));
                
                
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
        new Pickup().setVisible(true);
        
    }
    
}
