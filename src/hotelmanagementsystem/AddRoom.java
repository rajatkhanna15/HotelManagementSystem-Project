/**
 *
 * @author rajat
 */

package hotelmanagementsystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;


public class AddRoom extends JFrame implements ActionListener{
    
    JButton b1,b2;
    JComboBox c1,c2,c3;
    JTextField t1,t2;
    
    AddRoom()
    {
        JLabel l1 = new JLabel("ADD ROOMS");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        l1.setBounds(150,20,180,40);
        add(l1);
        
        JLabel room = new JLabel("Room No.");
        room.setFont(new Font("Tahoma",Font.PLAIN,17));
        room.setBounds(60,80,120,30);
        add(room);
        t1 = new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);
        
        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,17));
        available.setBounds(60,130,120,30);
        add(available);
        String[] s1 = {"Select","Available","Occupied"};
        c1 = new JComboBox(s1);
        c1.setBounds(200,130,150,30);
        c1.setBackground(Color.white);
        add(c1);
        
        JLabel status = new JLabel("Cleaning Status");
        status.setFont(new Font("Tahoma",Font.PLAIN,17));
        status.setBounds(60,180,120,30);
        add(status);
        String[] s2 = {"Select","Cleaned","Dirty"};
        c2 = new JComboBox(s2);
        c2.setBounds(200,180,150,30);
        c2.setBackground(Color.white);
        add(c2);
        
        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.PLAIN,17));
        price.setBounds(60,230,120,30);
        add(price);
        t2 = new JTextField();
        t2.setBounds(200,230,150,30);
        add(t2);
        
        JLabel bedType = new JLabel("Bed Type");
        bedType.setFont(new Font("Tahoma",Font.PLAIN,17));
        bedType.setBounds(60,280,120,30);
        add(bedType);
        String[] s3 = {"Select","Double Bed","Single Bed"};
        c3 = new JComboBox(s3);
        c3.setBounds(200,280,150,30);
        c3.setBackground(Color.white);
        add(c3);
        
        b1 = new JButton("SUBMIT");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(60,350,130,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("CANCEL");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(220,350,130,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/hotelroom.jpg"));
        JLabel l5 = new JLabel(i1);
        l5.setBounds(400,30,500,400);
        add(l5);
        
        
        
        
        getContentPane().setBackground(Color.white);
        setBounds(350,200,1000,500);
        setLayout(null);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {   
        if(ae.getSource() == b1)
        {
            String room = t1.getText();
            String available = (String) c1.getSelectedItem();
            String status = (String) c2.getSelectedItem();
            String price = t2.getText();
            String bedType = (String) c3.getSelectedItem();
            
            Conn c = new Conn();
            
            try
            {
                String str = "insert into addroom values('"+room+"','"+available+"','"+status+"',"
                        + "'"+price+"','"+bedType+"')";
                
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Room Added");
                this.setVisible(false);
            }
            catch(Exception e)
            {
                
            }
            
            
        }
        else if(ae.getSource() == b2)
        {
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new AddRoom().setVisible(true);
                
    }
    
}
