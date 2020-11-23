/**
 *
 * @author rajat
 */

package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;


public class AddDriver extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;
    
    AddDriver()
    {
        JLabel l1 = new JLabel("ADD DRIVERS");
        l1.setBounds(100,20,180,30);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        add(l1);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,80,120,30);
        add(name);
        t1 = new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);
        
        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,120,120,30);
        add(age);
        t2 = new JTextField();
        t2.setBounds(200,120,150,30);
        add(t2);
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,160,120,30);
        add(gender);
        String[] s1 = {"Select", "Male", "Female"};
        c1 = new JComboBox(s1);
        c1.setBounds(200,160,150,30);
        c1.setBackground(Color.white);
        add(c1);
        
        JLabel car = new JLabel("Car");
        car.setFont(new Font("Tahoma",Font.PLAIN,17));
        car.setBounds(60,200,120,30);
        add(car);
        t3 = new JTextField();
        t3.setBounds(200,200,150,30);
        add(t3);
        
        JLabel model = new JLabel("Model");
        model.setFont(new Font("Tahoma",Font.PLAIN,17));
        model.setBounds(60,240,120,30);
        add(model);
        t4 = new JTextField();
        t4.setBounds(200,240,150,30);
        add(t4);
        
        
        JLabel availability = new JLabel("Availability");
        availability.setFont(new Font("Tahoma",Font.PLAIN,17));
        availability.setBounds(60,280,120,30);
        add(availability);
        String[] s2 = {"Select", "Occupied", "Free"};
        c2 = new JComboBox(s2);
        c2.setBackground(Color.white);
        c2.setBounds(200,280,150,30);
        add(c2);
        
        JLabel location = new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.PLAIN,17));
        location.setBounds(60,320,120,30);
        add(location);
        t5 = new JTextField();
        t5.setBounds(200,320,150,30);
        add(t5);
        
        b1 = new JButton("Add Driver");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        b1.setBounds(70,370,120,30);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        b2.setBounds(200,370,120,30);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/drivers.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(400,50,450,300);
        add(l2);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(400,180,900,450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {   
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String) c1.getSelectedItem();
            String car = t3.getText();
            String model = t4.getText();
            String availability = (String) c2.getSelectedItem();
            String location = t5.getText();
            
            Conn c = new Conn();
            
            try
            {
                
                String str = "insert into addDriver values('"+name+"','"+age+"','"+gender+"','"+car+"',"
                    + "'"+model+"','"+availability+"','"+location+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "Driver Added Successfully.");
                this.setVisible(false);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
        if(ae.getSource() == b2)
        {
            this.setVisible(false);
        }
        
        
    }
    
    public static void main(String[] args)
    {
        new AddDriver().setVisible(true);
    }
    
}
