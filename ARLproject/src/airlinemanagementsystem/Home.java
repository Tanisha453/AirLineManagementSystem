
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Home extends JFrame implements ActionListener{
 
    public Home() {
        
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image= new JLabel(il);
        image.setBounds(0,0,1300,700);
        add(image);
        
        JLabel heading  = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(450,40,1000,40);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma",Font.PLAIN,36));
        image.add(heading); // we have first frame then img then our heading 
        
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details= new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
         JMenuItem customerDetails = new JMenuItem("Add Customer Details");
         customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        
         JMenuItem bookFlight = new JMenuItem("Book Flight");
         bookFlight.addActionListener(this);
        details.add(bookFlight);
        
         JMenuItem jouneryDetails = new JMenuItem("Jounrney Details");
         jouneryDetails.addActionListener(this);
        details.add(jouneryDetails);
        
        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        
        JMenu tickets= new JMenu("Ticket");
        menubar.add(tickets);
        
        JMenuItem boardingpass = new JMenuItem("Boarding Pass");
        boardingpass.addActionListener(this);
        tickets.add(boardingpass);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
       
       String text= ae.getActionCommand();
       if(text.equals("Add Customer Details")){
           new AddCustomer();
       }
       else if(text.equals("Flight Details")){
           new FlightInfo();
       }
       else if(text.equals("Book Flight")){
           new BookFlight();
       }
         else if(text.equals("Jounrney Details")){
           new JourneyDetails();
       }
       else if(text.equals("Cancel Ticket")){
          new CancelTicket(); 
       }
       else if(text.equals("Boarding Pass")){
           new BoardingPass();
       }
    }
      public static void main(String[] args) {
        new Home();
    }
    
}


    

