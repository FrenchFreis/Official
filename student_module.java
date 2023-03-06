import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class student_module extends faculty_module {
    JFrame f;
    JButton button1, button2, button4, button5, backbutton, enrollbutton, backbutton2, backbutton3, viewmycourse;
    JLabel accType, idnumL, userfname, userLname, useremail, courseviewLabel, courseviewLabel2;
    JPanel main_student_panel, studentInfo, studentEnroll, studentCourses;
    JComboBox availablecourses, enrolledcourses;

    static final String enrollfile = idnum + " - " + lname + ", " + fname + ".txt";

    void studentInfo() {
        f = new JFrame();
        f.setTitle("[HOME]");

        main_student_panel = new JPanel();
        main_student_panel.setBounds(0, 0, 300, 500);
        main_student_panel.setBackground(Color.WHITE);
        main_student_panel.setLayout(null);

        Font font2 = new Font("Monospaced", Font.BOLD, 10);

        button1 = new JButton("Profile Information");
        button1.setBounds(50, 80, 200, 50);
        button1.setBackground(Color.WHITE);
        button1.addActionListener(new studentinformation());

        button2 = new JButton("Enroll Courses");
        button2.setBounds(50, 140, 200, 50);
        button2.setBackground(Color.WHITE);
        button2.addActionListener(new goenrollbutton());

        button4 = new JButton("View Courses Enrolled");
        button4.setBounds(50, 200, 200, 50);
        button4.setBackground(Color.WHITE);
        button4.addActionListener(new goviewbutton());

        button5 = new JButton("Logout");
        button5.setBounds(50, 360, 200, 50);
        button5.setBackground(Color.WHITE);
        button5.addActionListener(new button5());

        main_student_panel.add(button1);
        main_student_panel.add(button2);
        main_student_panel.add(button4);
        main_student_panel.add(button5);

        // Student Information
        studentInfo = new JPanel();
        studentInfo.setBounds(0, 0, 300, 500);
        studentInfo.setBackground(Color.WHITE);
        studentInfo.setVisible(false);
        studentInfo.setLayout(null);

        accType = new JLabel();
        accType.setText("Account Type: " + userAcc);
        accType.setFont(font2);

        idnumL = new JLabel();
        idnumL.setText("ID Number: " + idnum);
        idnumL.setFont(font2);

        userfname = new JLabel();
        userfname.setText("First Name: " + fname);
        userfname.setFont(font2);

        userLname = new JLabel();
        userLname.setText("Last Name: " + lname);
        userLname.setFont(font2);

        useremail = new JLabel();
        useremail.setText("Email Address: " + email);
        useremail.setFont(font2);

        accType.setBounds(10, 100, 300, 20);
        idnumL.setBounds(10, 150, 300, 20);
        userfname.setBounds(10, 200, 300, 20);
        userLname.setBounds(10, 250, 300, 20);
        useremail.setBounds(10, 300, 300, 20);

        backbutton = new JButton();
        backbutton.setText("Back");
        backbutton.setBounds(45, 400, 200, 30);
        backbutton.setBackground(Color.white);
        backbutton.addActionListener(new returnme());

        studentInfo.add(accType);
        studentInfo.add(idnumL);
        studentInfo.add(userfname);
        studentInfo.add(userLname);
        studentInfo.add(useremail);
        studentInfo.add(backbutton);

        // Course Enrollment

        studentEnroll = new JPanel();
        studentEnroll.setBounds(0, 0, 300, 500);
        studentEnroll.setBackground(Color.WHITE);
        studentEnroll.setVisible(false);
        studentEnroll.setLayout(null);

        enrollbutton = new JButton();
        enrollbutton.setText("Enroll");
        enrollbutton.setBounds(45, 230, 200, 30);
        enrollbutton.setBackground(Color.white);
        enrollbutton.addActionListener(new enrollcourse());

        courseviewLabel = new JLabel("Course List: ");
        courseviewLabel.setBounds(40, 100, 210, 20);

        availablecourses = new JComboBox();

        availablecourses.setBounds(45, 130, 200, 50);

        viewcourses = new JButton();
        viewcourses.setText("View Courses");
        viewcourses.setBackground(Color.WHITE);
        viewcourses.addActionListener(new seecoursestudent());
        viewcourses.setBounds(45, 190, 200, 30);

        backbutton2 = new JButton();
        backbutton2.setText("Back");
        backbutton2.setBounds(45, 400, 200, 30);
        backbutton2.setBackground(Color.white);
        backbutton2.addActionListener(new returnme());

        studentEnroll.add(courseviewLabel);
        studentEnroll.add(backbutton2);
        studentEnroll.add(availablecourses);
        studentEnroll.add(enrollbutton);
        studentEnroll.add(viewcourses);

        // viewenrolled
        studentCourses = new JPanel();
        studentCourses.setBounds(0, 0, 300, 500);
        studentCourses.setBackground(Color.WHITE);
        studentCourses.setVisible(false);
        studentCourses.setLayout(null);

        backbutton3 = new JButton();
        backbutton3.setText("Back");
        backbutton3.setBounds(45, 400, 200, 30);
        backbutton3.setBackground(Color.white);
        backbutton3.addActionListener(new returnme());

        enrolledcourses = new JComboBox();

        enrolledcourses.setBounds(45, 130, 200, 50);

        courseviewLabel2 = new JLabel("My Course List: ");
        courseviewLabel2.setBounds(40, 100, 210, 20);

        viewmycourse = new JButton();
        viewmycourse.setText("Unenroll Selected Course");
        viewmycourse.setBounds(45, 190, 200, 30);
        viewmycourse.setBackground(Color.white);
        viewmycourse.addActionListener(new viewenrolledcourse());

        studentCourses.add(courseviewLabel2);
        studentCourses.add(viewmycourse);
        studentCourses.add(enrolledcourses);
        studentCourses.add(backbutton3);


        f.add(studentCourses);
        f.add(main_student_panel);
        f.add(studentInfo);
        f.add(studentEnroll);

        f.setSize(300, 500);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }


    class seecoursestudent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            availablecourses.removeAllItems();

            String coursespath = "src\\Courses";

            File courseFolders = new File(coursespath);
            File[] files = courseFolders.listFiles();

            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("Folder name: " + file.getName());
                    String item = file.getName();
                    availablecourses.addItem(item);
                }
            }
        }
    }

    class enrollcourse implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            try {

                String coursespath = "src\\Courses\\";
                String folderpath = availablecourses.getSelectedItem().toString();

                coursespath = coursespath + folderpath + "\\" + enrollfile;

                File myFile = new File(coursespath);

                // .createNewFile() method creates a new file if the file in the pathname does
                // not exist
                if (myFile.createNewFile()) {
                    System.out.println(myFile.getName() + " created!");
                    JOptionPane.showMessageDialog(null, "Officially Enrolled");
                } else {
                    System.out.println(myFile.getName() + " already exists!");
                    JOptionPane.showMessageDialog(null, "You have already Enrolled");
                }
            } catch (Exception e) {
                System.out.println("There is an error");
                System.out.println("Error In File Enrollment File Creation | Enrollcourse Action Listerner");
                e.printStackTrace();
            }
        }
    }

    class studentinformation implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            main_student_panel.setVisible(false);
            studentInfo.setVisible(true);
            f.setTitle("[PROFILE]");
        }

    }

    class returnme implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            studentInfo.setVisible(false);
            studentEnroll.setVisible(false);
            studentCourses.setVisible(false);
            main_student_panel.setVisible(true);
            f.setTitle("[HOME]");
        }

    }

    class goenrollbutton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            main_student_panel.setVisible(false);
            studentEnroll.setVisible(true);
            f.setTitle("[ENROLLMENT]");
        }

    }


    class goviewbutton implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            main_student_panel.setVisible(false);
            studentCourses.setVisible(true);

            String maindirpath = "src\\Courses";

            // File object
            File maindir = new File(maindirpath);

            if (maindir.exists() && maindir.isDirectory()) {

                System.out.println("Somthing should be happening");

                enrolledcourses.removeAllItems();

            String coursespath = "src\\Courses";

            File courseFolders = new File(coursespath);

            File[] files = courseFolders.listFiles();

            for (File file : files) {

                if (file.isDirectory()) {

                    System.out.println("Folder name: " + file.getName());

                    String newpath = file.getAbsolutePath();

                    File folder = new File(newpath);
                    File[] listOfFiles = folder.listFiles();

                    for (File file2 : listOfFiles) {
                        if (file2.getName().equals(enrollfile)) {
                            enrolledcourses.addItem(file.getName());
                        }
                    }

                }
            }
        
        } else {

                System.out.println("could not find path");
            }

        }

    }
    class button5 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            enrolledcourses.removeAllItems();
            f.dispose();
            

            logingui loginObject = new logingui();

            loginObject.frontGUI();
        }
    }

    class viewenrolledcourse implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String folderpath = enrolledcourses.getSelectedItem().toString();

            String deletepath = "src\\Courses\\";

            deletepath = deletepath + folderpath + "\\" + enrollfile;

            File coursefile = new File(deletepath);

            coursefile.delete();

            JOptionPane.showMessageDialog(null, "Officially Unenrolled");
            JOptionPane.showMessageDialog(null, "Leave Page and Return to view result");
            System.out.println(enrolledcourses.getSelectedItem());
            System.out.println(deletepath);

            f.setTitle("[MY COURSES]");

        }
    }


}