
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

public class Department extends JFrame implements ActionListener{
    
    JButton b1,b2;
    JTable t1;
    
    Department()
    {
        t1 = new JTable();
        t1.setBounds(0,40,900,350);
        add(t1);
        
        JLabel l3 = new JLabel("Department");
        l3.setBounds(80,10,150,30);
        add(l3);
        
        JLabel l4 = new JLabel("Budget");
        l4.setBounds(470,10,150,30);
        add(l4);
        
        b1 = new JButton("Load Data");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(150,420,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back to Reception");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(350,420,180,30);
        b2.addActionListener(this);
        add(b2);
        
        
        //getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300,200,800,500);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            String st = "select * from department";
            Conn c = new Conn();
            try{
                
                ResultSet rs1 = c.s.executeQuery(st);
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
        new Department().setVisible(true);
        
    }
    
}
