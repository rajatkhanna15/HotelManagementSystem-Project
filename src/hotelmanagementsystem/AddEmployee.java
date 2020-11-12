/**
 *
 * @author rajat
 */
package hotelmanagementsystem;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;
    
    AddEmployee()
    {
        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("Tahoma",Font.BOLD,17));
        name.setBounds(60,30,120,30);
        add(name);
        
        t1 = new JTextField();
        t1.setForeground(Color.red);
        t1.setBackground(Color.yellow);
        t1.setBounds(200,30,150,30);
        add(t1);
        
        JLabel age = new JLabel("AGE:");
        age.setFont(new Font("Tahoma",Font.BOLD,17));
        age.setBounds(60,80,120,30);
        add(age);
        
        t2 = new JTextField();
        t2.setForeground(Color.red);
        t2.setBackground(Color.yellow);
        t2.setBounds(200,80,150,30);
        add(t2);
        
        JLabel gender = new JLabel("GENDER:");
        gender.setFont(new Font("Tahoma",Font.BOLD,17));
        gender.setBounds(60,130,120,30);
        add(gender);
        
        r1 = new JRadioButton("M");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Tahoma",Font.PLAIN,17));
        r1.setBounds(200,130,70,30);
        add(r1);
        r2 = new JRadioButton("F");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Tahoma",Font.PLAIN,17));
        r2.setBounds(280,130,70,30);
        add(r2);
        
        JLabel job = new JLabel("JOB:");
        job.setFont(new Font("Tahoma",Font.BOLD,17));
        job.setBounds(60,180,120,30);
        add(job);
        
        String[] designations = {"Select","Clerks","Porters","HouseKeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        c1 = new JComboBox(designations);
        c1.setForeground(Color.red);
        c1.setBackground(Color.YELLOW);
        c1.setBounds(200,180,150,30);
        add(c1);
        
        JLabel salary = new JLabel("SALARY:");
        salary.setFont(new Font("Tahoma",Font.BOLD,17));
        salary.setBounds(60,230,120,30);
        add(salary);
        
        t3 = new JTextField();
        t3.setForeground(Color.red);
        t3.setBackground(Color.yellow);
        t3.setBounds(200,230,150,30);
        add(t3);
        
        JLabel phone = new JLabel("CONTACT NO:");
        phone.setFont(new Font("Tahoma",Font.BOLD,17));
        phone.setBounds(60,280,120,30);
        add(phone);
        
        t4 = new JTextField();
        t4.setForeground(Color.red);
        t4.setBackground(Color.yellow);
        t4.setBounds(200,280,150,30);
        add(t4);
        
        
        JLabel email = new JLabel("EMAIL ID:");
        email.setFont(new Font("Tahoma",Font.BOLD,17));
        email.setBounds(60,330,120,30);
        add(email);
        
        t5 = new JTextField();
        t5.setForeground(Color.red);
        t5.setBackground(Color.yellow);
        t5.setBounds(200,330,150,30);
        add(t5);
        
        
        JLabel aadhaar = new JLabel("AADHAAR NO:");
        aadhaar.setFont(new Font("Tahoma",Font.BOLD,17));
        aadhaar.setBounds(60,380,120,30);
        add(aadhaar);
        
        t6 = new JTextField();
        t6.setForeground(Color.red);
        t6.setBackground(Color.yellow);
        t6.setBounds(200,380,150,30);
        add(t6);
        
        b1 = new JButton("SUBMIT");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(200, 420, 150, 30);
        b1.addActionListener(this);
        add(b1);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/hotelemployee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,50,400,400);
        add(l1);
        
        getContentPane().setBackground(Color.white);
        
        
        JLabel l2 = new JLabel("ADD NEW EMPLOYEE");
        l2.setFont(new Font("Tahoma",Font.BOLD,35));
        l2.setForeground(Color.red);
        l2.setBounds(420,50,400,30);
        add(l2);
         
        
        
        
        
        
        setLayout(null);
        setBounds(400,150,900,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {   
        String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phoneno = t4.getText();
        String email = t5.getText();
        String aadhaar = t6.getText();
        
        String gender = null;
        if(r1.isSelected())
            gender = "Male";
        
        else
            gender = "Female";
        
        String job = (String) c1.getSelectedItem();
        
        Conn c = new Conn();
        String str = "insert into addEmployee values('"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"',"
                + " '"+phoneno+"','"+email+"', '"+aadhaar+"')";
        
        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "New Employee Added");
            this.setVisible(false);
            
            
        }
        catch(Exception e)
        {
            
        }
    }
    
    
    public static void main(String[] args)
    {
        new AddEmployee().setVisible(true);
    }
    
}
