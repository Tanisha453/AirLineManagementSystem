package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.*;
import com.toedter.calendar.*;
import java.util.*;


public class BoardingPass extends JFrame implements ActionListener
{
    JTextField tfpnr;
    JLabel tfname, tfnationality, lblsource, lbldest, labelfname, labelfcode,labeldate;
    JButton fetchButton;
    Choice source, destination;
    JDateChooser dcdate;
    public BoardingPass()
    {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(280,10,450,35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        heading.setForeground(Color.black);
        add(heading);
        
        JLabel subheading = new JLabel("Boardiing Pass");
        subheading.setBounds(275,50,300,30);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 24));
        subheading.setForeground(Color.black);
        add(subheading);
        
        JLabel lbaadhar = new JLabel("PNR DETAILS");
        lbaadhar.setBounds(60,100,150,25);
        lbaadhar.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbaadhar);
        
        tfpnr =new JTextField();
        tfpnr.setBounds(210,100,150,25);
        add(tfpnr);
        
        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(380,100,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,140,150,25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);
        
        tfname =new JLabel();
        tfname.setBounds(220,140,150,25);
        add(tfname);
        
        JLabel lbnationality = new JLabel("NATIONALITY");
        lbnationality.setBounds(60,180,150,25);
        lbnationality.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbnationality);
        
        tfnationality =new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        JLabel lbaddress = new JLabel("SRC");
        lbaddress.setBounds(60,220,150,25);
        lbaddress.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbaddress);
        
        lblsource = new JLabel();
        lblsource.setBounds(220, 220, 150, 25);
        add(lblsource);
        
         JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(330,220,150,25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblgender);
        
        lbldest = new JLabel();
        lbldest.setBounds(450,220,150,25);
        lbldest.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldest);
      
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(330, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(450, 260, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldate);
        
        labeldate= new JLabel();
        labeldate.setBounds(220,300,150,25);
        add(labeldate);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2= i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image= new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(500,0,300,310);
        add(lblimage);
      
       setSize(850,450); 
       setLocation(250,90);
       setVisible(true);
       
    }
     
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== fetchButton){
         String pnr= tfpnr.getText();
      try
      {
          Conn conn= new Conn();
          String query="select * from reservation where PNR= '"+pnr+"'";
          ResultSet rs=conn.s.executeQuery(query);
          
          if(rs.next()){
             tfname.setText(rs.getString("name")); 
                tfnationality.setText(rs.getString("nationality")); 
                lblsource.setText(rs.getString("src")); 
                lbldest.setText(rs.getString("des"));  
                labelfname.setText(rs.getString("flightname"));  
                labelfcode.setText(rs.getString("flightcode"));  
                labeldate.setText(rs.getString("ddate"));
          }else{
              JOptionPane.showMessageDialog(null,"Please enter correct PNR");
          }
       }
      catch(Exception e)
     {
        e.printStackTrace();  
     }
    }
       
    }
    
   public static void main(String [] args)
   {
       new BoardingPass();
   } 
}
