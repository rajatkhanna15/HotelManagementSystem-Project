
/**
 *
 * @author rajat
 */
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener{
    
    JButton b1,b2;
    JTable t1;
    JComboBox c1;
    JCheckBox c2;
    SearchRoom()
    {
        JLabel l1 = new JLabel("SEARCH FOR ROOM");
        l1.setBounds(150,20,250,30);
        l1.setForeground(Color.darkGray);
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        add(l1);
        
        JLabel l2 = new JLabel("Room Bed Type");
        l2.setBounds(30,70,150,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(l2);
        String[] beds = {"Select" , "Single Bed", "Double Bed"};
        c1 = new JComboBox(beds);
        c1.setBounds(190,70,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2 = new JCheckBox("Only Display Available Rooms");
        c2.setBounds(500,70,220,30);
        c2.setForeground(Color.RED);
        c2.setBackground(Color.YELLOW);
        add(c2);
        
        t1 = new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);
        
        JLabel l3 = new JLabel("Room No.");
        l3.setBounds(20,170,150,30);
        add(l3);
        
        JLabel l4 = new JLabel("Availability");
        l4.setBounds(230,170,150,30);
        add(l4);
        
        JLabel l5 = new JLabel("Clean Status");
        l5.setBounds(420,170,150,30);
        add(l5);
        
        JLabel l6 = new JLabel("Price");
        l6.setBounds(640,170,150,30);
        add(l6);
        
        JLabel l7 = new JLabel("Bed Type");
        l7.setBounds(820,170,150,30);
        add(l7);
        
        
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
            String bedtype = (String) c1.getSelectedItem();
            Conn c = new Conn();
            try{
                String st1 = "select * from addRoom where bed_type = '"+bedtype+"'";
                String st2 = "Select * from addRoom where availability = 'Available' and bed_type = '"+bedtype+"'";
                ResultSet rs1 = c.s.executeQuery(st1);
                t1.setModel(DbUtils.resultSetToTableModel(rs1));
                ResultSet rs2;
                if(c2.isSelected())
                {
                    rs2 = c.s.executeQuery(st2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs2));
                }
                else
                {
                    rs2 = c.s.executeQuery(st1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs2));
                }
                
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
        new SearchRoom().setVisible(true);
        
    }
    
}
