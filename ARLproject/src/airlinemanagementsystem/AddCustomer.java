
package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener
{
    JTextField  tfname,tfnationality,tfaadhar,tfaddress,tfnum;
    JRadioButton rbmale,rbfemale,rbtrans;
    public AddCustomer()
    {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220,20,500,35);
        heading.setFont(new Font("Monospaced", Font.BOLD, 32));
        heading.setForeground(Color.black);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,80,150,25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);
        
        tfname =new JTextField();
        tfname.setBounds(250,80,180,25);
        add(tfname);
        
        JLabel lbnationality = new JLabel("Nationality");
        lbnationality.setBounds(60,130,150,25);
        lbnationality.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbnationality);
        
        tfnationality =new JTextField();
        tfnationality.setBounds(250,130,180,25);
        add(tfnationality);
        
        JLabel lbaadhar = new JLabel("Aadhar Number");
        lbaadhar.setBounds(60,180,150,25);
        lbaadhar.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbaadhar);
        
        tfaadhar =new JTextField();
        tfaadhar.setBounds(250,180,180,25);
        add(tfaadhar);
        
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(60,230,150,25);
        lbaddress.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbaddress);
        
        tfaddress =new JTextField();
        tfaddress.setBounds(250,230,180,25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();  //select one button at a time
        
        rbmale= new JRadioButton("Male");
        rbmale.setBounds(200,280,60,25);
        rbmale.setBackground(Color.LIGHT_GRAY);
        add(rbmale);
        
        rbfemale= new JRadioButton("Female");
        rbfemale.setBounds(290,280,70,25);
        rbfemale.setBackground(Color.LIGHT_GRAY);
        add(rbfemale);
        
        rbtrans= new JRadioButton("Transgender");
        rbtrans.setBounds(390,280,100,25);
        rbtrans.setBackground(Color.LIGHT_GRAY);
        add(rbtrans);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        gendergroup.add(rbtrans);
        
        JLabel lblnum = new JLabel("Pnone Number");
        lblnum.setBounds(60,330,150,25);
        lblnum.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblnum);
        
        tfnum =new JTextField();
        tfnum.setBounds(250,330,180,25);
        add(tfnum);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220,450,150,30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(500,80,280,400);
        add(lblimage);
        
       setSize(800,600); 
       setLocation(250,60);
       setVisible(true);
       
    }
     
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
        String name = tfname.getText();
        String nationality= tfnationality.getText();
        String phone = tfnum.getText();
        String address = tfaddress.getText();
         String aadhar= tfaadhar.getText();
         String gender= null;
         if(rbmale.isSelected())
         {  gender="Male";
         }
         else if(rbfemale.isSelected())
         {   gender="Female";
         }else{   gender="Transgender";
         }
        
      try
      {
          Conn conn= new Conn();
          String query="insert into passenger value('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"')";
          conn.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Custumer Details Added Successfully");
          setVisible(false);
       }
      catch(Exception e)
     {
        e.printStackTrace();  
     }
    }
    
   public static void main(String [] args)
   {
       new AddCustomer();
   } 
}
