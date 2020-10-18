/**
 *
 * @author rajat
 */

package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class HotelManagementSystem extends JFrame implements ActionListener {
    
    HotelManagementSystem()
    {
        setBounds(100,150,1366,565);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/first.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1366, 565);
        add(l1);
        
        JLabel l2 = new JLabel("HOTEL MANAGEMENT SYSTEM");
        l2.setForeground(Color.BLUE);
        l2.setBounds(20,430,1000,90);
        l2.setFont(new Font("serif",Font.BOLD,50));
        l1.add(l2);
        
        
        
        JButton b1 = new JButton("NEXT");
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(1160,420,120,90);
        b1.addActionListener(this);
        l1.add(b1);
        
        
        setLayout(null);
        setVisible(true);
        
        while(true)
        {
            l2.setVisible(false);
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                
            }
            l2.setVisible(true);
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae){
                new AdminLogin().setVisible(true);
                this.setVisible(false);
            }

    
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
