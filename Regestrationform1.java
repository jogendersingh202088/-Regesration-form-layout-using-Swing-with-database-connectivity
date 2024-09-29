package com.swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Regestrationform1 extends JFrame{

	// declaring instance variable
	
	JPanel contentpane;
	JTextField firstname;
	JTextField lastname;
	JTextField email;
	JTextField username;
	JTextField mob;
	JPasswordField passwordfield;
	JButton btnNewButton;

	Regestrationform1 (){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450,190,1014,597);
		setResizable(false);
		
		// hidden container Jpanel 
		contentpane = new JPanel();//Creates a new JPanel with a double bufferand a flow layout.

                contentpane.setBorder(new EmptyBorder(5,5,5,5));
                 setContentPane(contentpane);
                 contentpane.setLayout(null);
                 
                 // lable for new user
                 
                 JLabel lblNewUserRegister = new JLabel("New User Register ");
                 lblNewUserRegister.setBounds(362, 52,325,50);
                 lblNewUserRegister.setFont(new Font("Times New Roman",Font.PLAIN,38));
                 contentpane.add(lblNewUserRegister);
                 
                 // lable for First name 
                 
                 JLabel lblName = new JLabel("First Name ");
                 lblName.setFont(new Font("Tahoma",Font.PLAIN,18));
                 lblName.setBounds(58,152,99,43);
                 contentpane.add(lblName);
                 
                 // lable for last name 
                 
                 JLabel NewLable = new JLabel("Last Name ");
                 NewLable.setFont(new Font("Tahoma",Font.PLAIN,18));
                 NewLable.setBounds(58,243,110,29);
                 contentpane.add(NewLable);
                 
                 // lable for email
                 
                 JLabel lblEmail = new JLabel("Email ");
                 lblEmail.setFont(new Font("Tahoma",Font.PLAIN,18));
                 lblEmail.setBounds(58,324,124,36);
                 contentpane.add( lblEmail);
                 
                 
     // lable for username
                 
                 JLabel lblusername = new JLabel("User Name ");
                 lblusername.setFont(new Font("Tahoma",Font.PLAIN,18));
                 lblusername.setBounds(542,159,99,29);
                 contentpane.add(lblusername);
                 
                 //   // lable for password
                 
                 JLabel lblPassword = new JLabel("Password ");
                 lblPassword.setFont(new Font("Tahoma",Font.PLAIN,18));
                 lblPassword.setBounds(542,245,99,24);
                 contentpane.add(lblPassword);
                 
  //   // lable for MObile number 
                 
                 JLabel lblMobileNumber= new JLabel("Mobile Number ");
                 lblMobileNumber.setFont(new Font("Tahoma",Font.PLAIN,18));
                 lblMobileNumber.setBounds(542,329,139,26);
                 contentpane.add(lblMobileNumber);
                 
                 // text field for first name 
                 
                 firstname = new JTextField();
                 firstname.setFont(new Font("Tahoma",Font.PLAIN,25));
                 firstname.setBounds(214, 151, 228, 50);
                 contentpane.add(firstname);
                 firstname.setColumns(10);
                 
                 // text field for last name 
                 
                 lastname = new JTextField();
                 lastname.setFont(new Font("Tahoma",Font.PLAIN,25));
                 lastname.setBounds(214, 235, 228, 50);
                 contentpane.add(lastname);
                 lastname.setColumns(10);
                 
                 // text field for email 
                 
                 email = new JTextField();
                 email.setFont(new Font("Tahoma",Font.PLAIN,25));
                 email.setBounds(214, 320, 228, 50);
                 contentpane.add(email);
                 email.setColumns(10);
                 
                 // username text field 
                 
                 username = new JTextField();
                 username.setFont(new Font("Tahoma",Font.PLAIN,25));
                 username.setBounds(707, 151, 228, 50);
                 contentpane.add(username);
                 username.setColumns(10);
                 
                 
                 // text field for mobile number 
                 
                 mob = new JTextField();
                 mob.setFont(new Font("Tahoma",Font.PLAIN,25));
                 mob.setBounds(707,320,228,50);
                contentpane.add(mob);
                mob.setColumns(10);
                 
                // text field for Password
                
                passwordfield = new JPasswordField();
                passwordfield.setFont(new Font("Tahoma",Font.PLAIN,25));
                passwordfield.setBounds(707,235,228,50);
               contentpane.add(passwordfield);
             
               
               btnNewButton = new JButton("Register");
               btnNewButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					String firstName = firstname.getText();
					String lastName = lastname.getText();
					String emailID = email.getText();
					String password = passwordfield.getText();
					
					String userName = username.getText();
					String mobilenumber = mob.getText();
					int len = mobilenumber.length();
					
					String msg = firstName +" " + lastName ;
					// msg+="\n";
					if(len!=10) {
						JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number ");
					}
					
					// Connecting to database
					
					// load driver class
					try {
					    Class.forName("com.mysql.cj.jdbc.Driver");
					    
					    // get Connection 
					    try {
					        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "9876@zyxA");
					        
					        // make connection 
					        
					        PreparedStatement ps = con.prepareStatement("INSERT INTO account (firstname, lastname, username, password, email, mobilenumber) VALUES (?, ?, ?, ?, ?, ?)");
					        ps.setString(1, firstName);
					        ps.setString(2, lastName);
					        ps.setString(3, userName);
					        ps.setString(4, password);
					        ps.setString(5, emailID);
					        ps.setString(6, mobilenumber);
					        
					        int x = ps.executeUpdate();
					        if (x == 1) {
					            JOptionPane.showMessageDialog(btnNewButton, "Welcome "+msg+ " Your Account is Successfully Created");
					        } else {
					            JOptionPane.showMessageDialog(btnNewButton, "This Account Already Exists");
					        }
					        con.close();
					        
					    } catch (SQLException e1) {
					        e1.printStackTrace();
					    }
					} catch (ClassNotFoundException e1) {
					    e1.printStackTrace();
					}

				}
            	   
               });
               
               btnNewButton.setFont(new Font("Tahoma",Font.BOLD,30));
               btnNewButton.setBounds(399,447,259,74);
               contentpane.add(btnNewButton);
               

                
	}
	
	public static void main(String[] args) {
		
		Regestrationform1 rf = new Regestrationform1();
		rf.setVisible(true);

	}

}
