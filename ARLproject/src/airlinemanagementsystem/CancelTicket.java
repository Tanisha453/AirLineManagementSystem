package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.*;
import com.toedter.calendar.*;
import java.util.*;


public class CancelTicket extends JFrame implements ActionListener
{
    JTextField tfpnr;
    JLabel tfname, cancellationno, lblflcod, lbldate;
    JButton  fetchButton, flight;
    
    public CancelTicket()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180,20,250,35);
        heading.setFont(new Font("Monospaced", Font.BOLD, 32) );
        add(heading);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2= i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470,120,250,250);
        add(image);
    
        
        JLabel lbaadhar = new JLabel("PNR Number");
        lbaadhar.setBounds(60,80,150,25);
        lbaadhar.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbaadhar);
        
        tfpnr =new JTextField();
        tfpnr.setBounds(210,80,180,25);
        add(tfpnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(450,80,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,130,150,25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);
        
        tfname =new JLabel();
        tfname.setBounds(220,130,150,25);
        add(tfname);
        
        JLabel lbnationality = new JLabel("Cancellation No");
        lbnationality.setBounds(60,180,150,25);
        lbnationality.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbnationality);
        
        cancellationno =new JLabel(""+random.nextInt(1000000));
        cancellationno.setBounds(220,180,150,25);
        add(cancellationno);
        
        JLabel lbaddress = new JLabel("Flight Code");
        lbaddress.setBounds(60,230,150,25);
        lbaddress.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbaddress);
        
       lblflcod = new JLabel();
        lblflcod.setBounds(220, 230, 150, 25);
        add(lblflcod);
        
         JLabel lblgender = new JLabel("Date");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblgender);
        
         lbldate = new JLabel();
        lbldate.setBounds(220, 280, 150, 25);
        add(lbldate);
      
        flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220,330,120,25);
        flight.addActionListener(this);
        add(flight);
        
       setSize(800,450); 
       setLocation(300,80);
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
          String query="select * from reservation where PNR='"+pnr+"'";
          ResultSet rs=conn.s.executeQuery(query);
          
          if(rs.next()){
              tfname.setText(rs.getString("name"));
              lblflcod.setText(rs.getString("flightcode"));
              lbldate.setText(rs.getString("ddate"));
          }else{
              JOptionPane.showMessageDialog(null,"Please Enter correct Aadhar Number");
          }
       }
      catch(Exception e)
     {
        e.printStackTrace();  
     }
    }
        else if (ae.getSource() == flight) {
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno= cancellationno.getText();
            String fcode= lblflcod.getText();
            String date = lbldate.getText();
            try {
                Conn conn = new Conn();

                String query = "insert into cancel values('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+date+"')";

                conn.s.executeUpdate(query);
                conn.s.execute("delete from reservation where PNR = '"+pnr+"'");
                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);
               
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }
    
   public static void main(String [] args)
   {
       new CancelTicket();
   } 
}

