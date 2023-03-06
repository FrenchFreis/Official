import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class registryOfficialGUI implements ActionListener {
    JButton back, register;
    JTextField user, userid, userFirstname, userLastname, emailadd;
    JPasswordField pass, pass2;
    JCheckBox checkBox1;
    JFrame frame;
    JRadioButton rb1, rb2;

    logingui loginObject = new logingui();
    static String accType = " ";

    public void Registerme() {
        frame = new JFrame();
        frame.setTitle("[ACCOUNT REGISTRATION]");

        back = new JButton();

        back.setText("Back");
        back.setBounds(130, 350, 100, 20);
        back.addActionListener(this);

        register = new JButton();
        register.setText("Register");
        register.setBounds(240, 350, 100, 20);
        register.addActionListener(this);

        // user profile
        userid = new JTextField();
        userFirstname = new JTextField();
        userLastname = new JTextField();
        emailadd = new JTextField();

        // user acc
        user = new JTextField();
        pass = new JPasswordField();
        pass2 = new JPasswordField();

        userid.setBounds(130, 90, 210, 20);
        userFirstname.setBounds(130, 110, 210, 20);
        userLastname.setBounds(130, 130, 210, 20);
        emailadd.setBounds(130, 150, 210, 20);

        user.setBounds(130, 230, 210, 20);
        pass.setBounds(130, 250, 210, 20);
        pass2.setBounds(130, 270, 210, 20);

        JLabel idLabel = new JLabel("ID Number:");
        idLabel.setBounds(30, 90, 100, 20);

        JLabel fnameLabel = new JLabel("First Name:");
        fnameLabel.setBounds(30, 110, 100, 20);

        JLabel lnameLabel = new JLabel("Last Name:");
        lnameLabel.setBounds(30, 130, 100, 20);

        JLabel emaiLabel = new JLabel("Email Address:");
        emaiLabel.setBounds(30, 150, 100, 20);


        // Account
        JLabel userL = new JLabel("Username:");
        userL.setBounds(30, 230, 100, 20);

        JLabel passL = new JLabel("Password:");
        passL.setBounds(30, 250, 100, 20);

        JLabel passL2 = new JLabel("Password:");
        passL2.setBounds(30, 270, 100, 20);

        checkBox1 = new JCheckBox("Show Password");
        checkBox1.setBounds(220, 290, 200, 20);
        checkBox1.addActionListener(this);


        JLabel accLabel = new JLabel("Account Type:");
        accLabel.setBounds(30, 170, 100, 20);

        rb1 = new JRadioButton();
        rb1.setBounds(140, 170, 70, 20);
        rb1.setText("Student");
        
        rb2 = new JRadioButton();
        rb2.setBounds(240, 170, 70, 20);
        rb2.setText("Faculty");
        

        ButtonGroup group = new ButtonGroup();

        rb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ie){
                accType = "Student";
            }
        });

        rb2.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent ie){

            accType = "Faculty";

        }});


        group.add(rb1);
        group.add(rb2);

        frame.add(rb2);
        frame.add(rb1);

        // ADDING ELEMENTS
        frame.add(back);
        frame.add(register);

        frame.add(userid);
        frame.add(userFirstname);
        frame.add(userLastname);
        frame.add(emailadd);

        frame.add(user);
        frame.add(pass);
        frame.add(pass2);

        frame.add(idLabel);
        frame.add(fnameLabel);
        frame.add(lnameLabel);
        frame.add(emaiLabel);
        frame.add(accLabel);

        frame.add(userL);
        frame.add(passL);
        frame.add(passL2);
        

        frame.add(checkBox1);

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

    }

    // UNCOMMENT IF YOU WANT TO TEST BY ITSELF

    // public static void main(String[] args) throws Exception {
    // registryOfficialGUI registryObject = new registryOfficialGUI();

    // registryObject.Registerme();

    // }

    
    @Override
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            frame.dispose();
            loginObject.frontGUI();
            frame.setTitle("[XYZ UNIVERSITY LOGIN]");
        }

        if (e.getSource() == register) {

            Boolean valid = false;

            String useridnum = userid.getText();
            String userfname = userFirstname.getText();
            String userLname = userLastname.getText();
            String useremail = emailadd.getText();

            String passText = new String(pass.getPassword());
            String passText2 = new String(pass2.getPassword());
            String username = user.getText();

            String path = "src\\accounts.txt";

            File file = new File(path);

            try {
                Scanner inputBuffer = new Scanner(file);

                while (inputBuffer.hasNext()) {
                    valid = false;

                    String line = inputBuffer.nextLine();
                    String[] users = line.split("; ");

                    String usernameFromFile = users[0];

                    if (usernameFromFile.equals(username)) {
                        System.out.println("Account Username already exists");
                        System.out.println(valid);
                        break;
                    } else {
                        System.out.println("Safe for login");
                        System.out.println(users[0] + "else");

                        valid = true;
                    }
                }
            } catch (FileNotFoundException fe) {
                System.out.println("Something Went Wrong");
                // fe.printStackTrace();
            }
            if (userid.getText().equals("")) {
                useridnum = "none";
            }

            if (userFirstname.getText().equals("")) {
                userfname = "none";
            }

            if (userLastname.getText().equals("")) {
                userLname = "none";
            }

            if (emailadd.getText().equals("")) {
                useremail = "none";
            }

            if (valid == true) {
                if (passText.equals(passText2)) {

                    if (userid.getText().equals("")) {
                        useridnum = "none";
                    }

                    if (userFirstname.getText().equals("")) {
                        userfname = "none";
                    }

                    if (userLastname.getText().equals("")) {
                        userLname = "none";
                    }

                    if (emailadd.getText().equals("")) {
                        useremail = "none";
                    }

                    try {
                        FileWriter accwriter = new FileWriter("src\\accounts.txt", true);
                        accwriter.write(username + "; " + passText + "; " + accType + "; " + useridnum + "; " + userfname + "; " + userLname
                                + "; " + useremail);
                        accwriter.write(System.getProperty("line.separator"));
                        accwriter.close();
                        JOptionPane.showMessageDialog(null, "Success");
                        frame.dispose();
                        loginObject.frontGUI();
                    } catch (IOException error) {
                        System.out.println("An error occurred.");
                        error.printStackTrace();
                    }
                }
            }

        }
        if (checkBox1.isSelected()) {
            pass.setEchoChar((char) 0);
            pass2.setEchoChar((char) 0);
        } else {
            pass.setEchoChar('*');
            pass2.setEchoChar('*');
        }
    }

}
