import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class logingui implements ActionListener {
    JButton login, register;
    JTextField user;
    JPasswordField pass;
    JFrame frame;
    JCheckBox checkBox1;

    static String fname = "";
    static String lname = "";
    static String email = "";
    static String idnum = "";
    static String userAcc = "";



    void frontGUI() {
        frame = new JFrame();
        frame.setTitle("[XYZ UNIVERSITY LOGIN]");

        login = new JButton();
        register = new JButton();

        login.setText("Login");
        login.setBounds(130, 110, 100, 20);

        login.addActionListener(new loginAction());

        register.setText("Register");
        register.setBounds(240, 110, 100, 20);

        register.addActionListener(this);

        user = new JTextField();
        pass = new JPasswordField();

        user.setBounds(130, 30, 210, 20);
        pass.setBounds(130, 55, 210, 20);

        JLabel userL = new JLabel("Username");
        userL.setBounds(30, 30, 100, 20);

        JLabel passL = new JLabel("Password");
        passL.setBounds(30, 55, 100, 20);
        
        checkBox1 = new JCheckBox("Show Password");
        checkBox1.setBounds(130, 80, 200, 20);
        checkBox1.addActionListener(this);

        // ADDING ELEMENTS
        frame.add(checkBox1);
        frame.add(login);
        frame.add(register);
        frame.add(user);
        frame.add(pass);
        frame.add(userL);
        frame.add(passL);

        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            frame.dispose();
            registryOfficialGUI registryObject = new registryOfficialGUI();
            registryObject.Registerme();
        }

        if (checkBox1.isSelected()) {
            pass.setEchoChar((char) 0);
        } else {
            pass.setEchoChar('*');
        }

    }

    class loginAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String path = "src\\accounts.txt";

            File file = new File(path);

            try {
                Scanner inputBuffer = new Scanner(file);

                while (inputBuffer.hasNext()) {
                    String line = inputBuffer.nextLine();
                    String[] values = line.split("; ");
                    if (values[0].equals(user.getText()) && values[1].equals(new String(pass.getPassword()))) {
                        if (values[2].equals("Student")) {
                            JOptionPane.showMessageDialog(null, "Welcome Student");
                            System.out.println("ID Number: " + values[3]);
                            System.out.println("First Name: " + values[4]);
                            System.out.println("Last Name: " + values[5]);
                            System.out.println("Email Address: " + values[6]);
                            userAcc = values[2];
                            idnum = values[3];
                            fname = values[4];
                            lname = values[5];
                            email = values[6];
                            frame.dispose();
                            student_module studentObject = new student_module();
                            studentObject.studentInfo();
                            
                        }
                        else if (values[2].equals("Faculty")) {
                            JOptionPane.showMessageDialog(null, "Welcome Faculty");
                            System.out.println("ID Number: " + values[3]);
                            System.out.println("First Name: " + values[4]);
                            System.out.println("Last Name: " + values[5]);
                            System.out.println("Email Address: " + values[6]);
                            userAcc = values[2];
                            idnum = values[3];
                            fname = values[4];
                            lname = values[5];
                            email = values[6];
                            frame.dispose();
                            faculty_module runObject = new faculty_module();
                            runObject.facultyInfo();
                        }
                    }
                }
            } catch (FileNotFoundException fe) {
                System.out.println("Something Went Wrong");
                // fe.printStackTrace();

            }
            

        }

    }
}
