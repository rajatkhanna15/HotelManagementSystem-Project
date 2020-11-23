/**
 *
 * @author rajat
 */

package hotelmanagementsystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class NewCustomer extends JFrame implements ActionListener {
    
    JComboBox c1,c3;
    Choice c2;
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2;
    
    NewCustomer()
    {
        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        l1.setBounds(100,10,350,30);
        add(l1);
        
        JLabel ID = new JLabel("ID");
        ID.setFont(new Font("Tahoma",Font.PLAIN,17));
        ID.setBounds(30,70,150,30);
        add(ID);
        String[] str={"Select", "Passport", "Aadhar Card", "Driving Licence", "Voter ID"};
        c1 = new JComboBox(str);
        c1.setBounds(210,70,150,25);
        c1.setBackground(Color.white);
        add(c1);
        
        JLabel number = new JLabel("No.");
        number.setFont(new Font("Tahoma",Font.PLAIN,17));
        number.setBounds(30,110,150,30);
        add(number);
        t1 = new JTextField();
        t1.setBounds(210,110,150,25);
        add(t1);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(30,150,150,30);
        add(name);
        t2 = new JTextField();
        t2.setBounds(210,150,150,25);
        add(t2);
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(30,190,150,30);
        add(gender);
        r1 = new JRadioButton("M");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Tahoma",Font.PLAIN,17));
        r1.setBounds(210,190,70,25);
        add(r1);
        r2 = new JRadioButton("F");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Tahoma",Font.PLAIN,17));
        r2.setBounds(290,190,70,25);
        add(r2);
        
        
        JLabel country = new JLabel("Country");
        country.setFont(new Font("Tahoma",Font.PLAIN,17));
        country.setBounds(30,230,150,30);
        add(country);
        t3 = new JTextField();
        t3.setBounds(210,230,150,25);
        add(t3);
        
        JLabel allocate = new JLabel("Allocate Room No.");
        allocate.setFont(new Font("Tahoma",Font.PLAIN,17));
        allocate.setBounds(30,270,150,30);
        add(allocate);
        c2 = new Choice();
        c2.setBounds(210,270,150,25);
        try{
            Conn c = new Conn();
            String s1 = "select * from addroom";
            ResultSet rs = c.s.executeQuery(s1);
            while(rs.next())
            {
                c2.add(rs.getString("Room_Number"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        add(c2);
        JLabel checkedin = new JLabel("Checked in");
        checkedin.setFont(new Font("Tahoma",Font.PLAIN,17));
        checkedin.setBounds(30,310,150,30);
        add(checkedin);
        String[] s1 = {"Select","Yes","No"};
        c3 = new JComboBox(s1);
        c3.setBounds(210,310,150,30);
        c3.setBackground(Color.white);
        add(c3);
        
        JLabel deposit = new JLabel("Deposited Amount");
        deposit.setFont(new Font("Tahoma",Font.PLAIN,17));
        deposit.setBounds(30,350,150,30);
        add(deposit);
        t5 = new JTextField();
        t5.setBounds(210,350,150,25);
        add(t5);
        
        b1 = new JButton("Add Customer");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,400,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back to Reception");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,400,150,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/customer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(400,50,470,380);
        add(icon);
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300,150,900,500);
        setVisible(true);
    }
    
    @Override 
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            String ID = (String) c1.getSelectedItem();
            String No = t1.getText();
            String name = t2.getText();
            String gender = null;
            if(r1.isSelected())
                gender = "Male";

            else
                gender = "Female";

            String country = t3.getText();
            String room_number = c2.getSelectedItem();
            String checkedin = (String) c3.getSelectedItem();
            String deposit = t5.getText();
            
            
            String str1 = "insert into addCustomer values('"+ID+"','"+No+"','"+name+"','"+gender+"',"
                    + "'"+country+"','"+room_number+"','"+checkedin+"','"+deposit+"')";
            String str2 = "update addRoom set availability = 'occupied' where Room_Number = '"+room_number+"'";
            try
            {
                Conn c = new Conn();
                c.s.executeUpdate(str1);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Customer Added Successfully");
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
        
    }
    
    public static void main(String[] args)
    {
        new NewCustomer().setVisible(true);
    }
    
}
