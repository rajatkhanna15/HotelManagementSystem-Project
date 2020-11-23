/**
 *
 * @author rajat
 */

package hotelmanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    
    Reception()
    {
        b1 = new JButton("New Customer Form");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(50,20,200,30);
        b1.addActionListener(this);
        add(b1);
       
        b2 = new JButton("Room");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(50,60,200,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Department");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(50,100,200,30);
        b3.addActionListener(this);
        add(b3);
        
        b4 = new JButton("All Employees Info.");
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.setBounds(50,140,200,30);
        b4.addActionListener(this);
        add(b4);
        
        b5 = new JButton("Customer Info.");
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.setBounds(50,180,200,30);
        b5.addActionListener(this);
        add(b5);
        
        b6 = new JButton("Manager Info.");
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.setBounds(50,220,200,30);
        b6.addActionListener(this);
        add(b6);
        
        b7 = new JButton("Check Out.");
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.setBounds(50,260,200,30);
        b7.addActionListener(this);
        add(b7);
        
        b8 = new JButton("Update Check Status.");
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        b8.setBounds(50,300,200,30);
        b8.addActionListener(this);
        add(b8);
        
        b9 = new JButton("Update Room Status.");
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        b9.setBounds(50,340,200,30);
        b9.addActionListener(this);
        add(b9);
        
        b10 = new JButton("Pickup Service.");
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);
        b10.setBounds(50,380,200,30);
        b10.addActionListener(this);
        add(b10);
        
        b11 = new JButton("Search Room.");
        b11.setBackground(Color.black);
        b11.setForeground(Color.white);
        b11.setBounds(50,420,200,30);
        b11.addActionListener(this);
        add(b11);
        
        b12 = new JButton("Log out.");
        b12.setBackground(Color.black);
        b12.setForeground(Color.white);
        b12.setBounds(50,460,200,30);
        b12.addActionListener(this);
        add(b12);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/fourth.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(280,20,490,470);
        add(l1);
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(450,200,820,550);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            new NewCustomer().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource() == b2)
        {
            new Room().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource() == b3)
        {
            new Department().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource() == b4)
        {
            new EmployeeDetails().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource() == b5)
        {
            new CustomerDetails().setVisible(true);
            this.setVisible(false);
            
        }
        if(ae.getSource() == b6)
        {
            new ManagerDetails().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource() == b7)
        {
            new CheckOut().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource() == b8)
        {
            new UpdateCheck().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource() == b9)
        {
            new UpdateRoom().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource() == b10)
        {
            new Pickup().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource() == b11)
        {
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource() == b12)
        {
            setVisible(false);
        }
            
    }
    
    public static void main(String[] args)
    {
        new Reception().setVisible(true);
    }
}
