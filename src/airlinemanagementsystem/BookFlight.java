package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.*;
import com.toedter.calendar.*;
import java.util.*;


public class BookFlight extends JFrame implements ActionListener
{
    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress, labelgender, labelfname, labelfcode;
    JButton bookflight, fetchButton, flight;
    Choice source, destination;
    JDateChooser dcdate;
    public BookFlight()
    {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(280,20,500,35);
        heading.setFont(new Font("Monospaced", Font.BOLD, 32));
        heading.setForeground(Color.black);
        add(heading);
        
        JLabel lbaadhar = new JLabel("Aadhar Number");
        lbaadhar.setBounds(60,80,150,25);
        lbaadhar.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbaadhar);
        
        tfaadhar =new JTextField();
        tfaadhar.setBounds(210,80,180,25);
        add(tfaadhar);
        
        fetchButton = new JButton("Fetch");
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
        
        JLabel lbnationality = new JLabel("Nationality");
        lbnationality.setBounds(60,180,150,25);
        lbnationality.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbnationality);
        
        tfnationality =new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(60,230,150,25);
        lbaddress.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbaddress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
         JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblgender);
        
        labelgender = new JLabel("Gender");
        labelgender.setBounds(220,280,150,25);
        labelgender.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labelgender);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60,330,150,25);
        lblsource.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblsource);
        
        source = new Choice();      //for drop down
        source.setBounds(220,330,150,25);
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60,380,150,25);
        lbldest.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldest);
        
        destination = new Choice();      //for drop down
        destination.setBounds(220,380,150,25);
        add(destination);
        
        try{
            Conn conn =new Conn();
            String query="select * from flight";
            ResultSet rs = conn.s.executeQuery(query);
            
            while(rs.next())
            {
              source.add(rs.getString("source"));
              destination.add(rs.getString("destination"));        
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        flight = new JButton("Fetch Flight");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380,380,120,25);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldate);
        
        dcdate= new JDateChooser();
        dcdate.setBounds(220,530,150,25);
        add(dcdate);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2= i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image= new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550,80,500,410);
        add(lblimage);
        
        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220,580,150,25);
        bookflight.addActionListener(this);
        add(bookflight);
        
       setSize(1100,650); 
       setLocation(100,20);
       setVisible(true);
       
    }
     
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== fetchButton){
         String aadhar= tfaadhar.getText();
      try
      {
          Conn conn= new Conn();
          String query="select * from passenger where aadhar='"+aadhar+"'";
          ResultSet rs=conn.s.executeQuery(query);
          
          if(rs.next()){
              tfname.setText(rs.getString("name"));
              tfnationality.setText(rs.getString("nationality"));
              tfaddress.setText(rs.getString("address"));
              labelgender.setText(rs.getString("gender"));
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
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            try {
                Conn conn = new Conn();

                String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    labelfname.setText(rs.getString("f_name")); 
                    labelfcode.setText(rs.getString("f_code")); 
                }else {
                    JOptionPane.showMessageDialog(null, "No Flights Found");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Random random = new Random();
            
            String aadhar = tfaadhar.getText();
            String name = tfname.getText(); 
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText(); 
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem(); 
            String des = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
             try {
                Conn conn = new Conn();

                String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+aadhar+"', '"+name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+des+"', '"+ddate+"')";

                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
   public static void main(String [] args)
   {
       new BookFlight();
   } 
}
