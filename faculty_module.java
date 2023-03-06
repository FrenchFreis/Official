import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class faculty_module extends logingui {
    JFrame f;
    JTextField user, coursename;
    JButton b1, b3, b4, backbutton, createcourse, backcourse, viewcourses, deletecourse, b5, backcourse2, viewstudents;
    JPanel main_faculty_panel, infoPanel, createPanel, viewpanel;
    JLabel userFname, userLname, idnumL, accType, useremail, courseLabel, courseviewLabel;
    JComboBox availablecourses, coursesavail;
    JTextArea studsenrolled;

    logingui loginObject = new logingui();

    void facultyInfo() {

        f = new JFrame("[FACULTY][HOME]");

        main_faculty_panel = new JPanel();
        main_faculty_panel.setBounds(0, 0, 300, 500);
        Font font = new Font("Monospaced", Font.BOLD, 20);
        Font font2 = new Font("Monospaced", Font.BOLD, 10);

        b1 = new JButton("Profile Information");
        b1.setBounds(50, 80, 200, 50);
        b1.setBackground(Color.WHITE);
        b1.addActionListener(new b1());

        b3 = new JButton("Edit Available Courses");
        b3.setBounds(50, 140, 200, 50);
        b3.setBackground(Color.WHITE);
        b3.addActionListener(new b3());

        b4 = new JButton("View Enrolled Students");
        b4.setBounds(50, 200, 200, 50);
        b4.setBackground(Color.WHITE);
        b4.addActionListener(new b4());

        b5 = new JButton("Logout");
        b5.setBounds(50, 360, 200, 50);
        b5.setBackground(Color.WHITE);
        b5.addActionListener(new b5());

        main_faculty_panel.add(b1);
        main_faculty_panel.add(b3);
        main_faculty_panel.add(b4);
        main_faculty_panel.add(b5);

        main_faculty_panel.setLayout(null);

        infoPanel = new JPanel();
        infoPanel.setBounds(0, 0, 300, 500);
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setVisible(false);

        accType = new JLabel();
        accType.setText("Account Type: " + userAcc);
        accType.setFont(font2);

        idnumL = new JLabel();
        idnumL.setText("ID Number: " + idnum);
        idnumL.setFont(font2);

        userFname = new JLabel();
        userFname.setText("First Name: " + fname);
        userFname.setFont(font2);

        userLname = new JLabel();
        userLname.setText("Last Name: " + lname);
        userLname.setFont(font2);

        useremail = new JLabel();
        useremail.setText("Email Address: " + email);
        useremail.setFont(font2);

        accType.setBounds(10, 100, 300, 20);
        idnumL.setBounds(10, 150, 300, 20);
        userFname.setBounds(10, 200, 300, 20);
        userLname.setBounds(10, 250, 300, 20);
        useremail.setBounds(10, 300, 300, 20);

        backbutton = new JButton();
        backbutton.setText("Back");
        backbutton.setBounds(45, 400, 200, 30);
        backbutton.setBackground(Color.white);
        backbutton.addActionListener(new returnme());

        infoPanel.add(accType);
        infoPanel.add(idnumL);
        infoPanel.add(userLname);
        infoPanel.add(userFname);
        infoPanel.add(useremail);
        infoPanel.add(backbutton);
        infoPanel.setLayout(null);

        createPanel = new JPanel();
        createPanel.setBounds(0, 0, 300, 500);
        createPanel.setBackground(Color.WHITE);
        createPanel.setVisible(false);
        createPanel.setLayout(null);

        courseLabel = new JLabel("Enter Course Name: ");
        courseLabel.setBounds(40, 25, 210, 20);

        coursename = new JTextField();
        coursename.setBounds(45, 50, 200, 40);

        createcourse = new JButton();
        createcourse.setText("Add Course");
        createcourse.addActionListener(new addcourse());
        createcourse.setBounds(45, 100, 200, 30);

        backcourse = new JButton();
        backcourse.setText("Back");
        backcourse.addActionListener(new returnme());
        backcourse.setBounds(45, 400, 200, 30);

        courseviewLabel = new JLabel("Course List: ");
        courseviewLabel.setBounds(40, 180, 210, 20);

        viewcourses = new JButton();
        viewcourses.setText("View Courses");
        viewcourses.addActionListener(new seecourse());
        viewcourses.setBounds(45, 280, 200, 30);

        deletecourse = new JButton();
        deletecourse.setText("Delete Selected Course");
        deletecourse.addActionListener(new deletecourse());
        deletecourse.setBounds(45, 330, 200, 30);

        availablecourses = new JComboBox();

        availablecourses.setBounds(45, 210, 200, 50);

        createPanel.add(courseviewLabel);
        createPanel.add(courseLabel);
        createPanel.add(availablecourses);
        createPanel.add(coursename);
        createPanel.add(backcourse);
        createPanel.add(createcourse);
        createPanel.add(viewcourses);
        createPanel.add(deletecourse);



        viewpanel = new JPanel();
        viewpanel.setBounds(0, 0, 300, 500);
        viewpanel.setBackground(Color.WHITE);
        viewpanel.setVisible(false);
        viewpanel.setLayout(null);

        coursesavail = new JComboBox();
        coursesavail.setBounds(45, 20, 200, 30);


        backcourse2 = new JButton();
        backcourse2.setText("Back");
        backcourse2.addActionListener(new returnme());
        backcourse2.setBounds(45, 400, 200, 30);

        viewstudents = new JButton();
        viewstudents.setText("View Enrolled");
        viewstudents.addActionListener(new selectcourse());
        viewstudents.setBounds(45, 350, 200, 30);

        studsenrolled = new JTextArea();
        studsenrolled.setBounds(45, 70, 200, 250);
        studsenrolled.setBackground(Color.lightGray);
        studsenrolled.setEditable(false);




        viewpanel.add(studsenrolled);
        viewpanel.add(viewstudents);
        viewpanel.add(coursesavail);
        viewpanel.add(backcourse2);





        f.add(viewpanel);
        f.add(createPanel);
        f.add(main_faculty_panel);
        f.add(infoPanel);

        f.setSize(300, 500);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }

    class seecourse implements ActionListener {
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

    class deletecourse implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String deletepath = "src\\Courses\\";

            deletepath = deletepath + availablecourses.getSelectedItem().toString();

            File courseFolderss = new File(deletepath);

            File[] files = courseFolderss.listFiles();

            for (File file : files) {
                        if (file.isFile()) {
                            System.out.println(file.getName());
                            file.delete();
                        }
                }
            courseFolderss.delete();
            System.out.println(availablecourses.getSelectedItem());
            System.out.println(deletepath);
            System.out.println("Course Deleted Successfully");

            availablecourses.removeAllItems();

        }
    }

    class addcourse implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String directory = "src\\Courses\\";

            directory = directory + coursename.getText();

            File coursefiles = new File(directory);
            coursefiles.mkdirs();

            availablecourses.removeAllItems();
        }
    }

    class returnme implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            createPanel.setVisible(false);
            infoPanel.setVisible(false);
            viewpanel.setVisible(false);
            main_faculty_panel.setVisible(true);
            studsenrolled.setText(null);
            availablecourses.removeAllItems();
            f.setTitle("[FACULTY][HOME]");
        }

    }

    class b1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            f.setTitle("[FACULTY][PROFILE]");

            main_faculty_panel.setVisible(false);
            infoPanel.setVisible(true);

            System.out.println("Email: " + email);
            System.out.println("IDNum: " + idnum);
            System.out.println("Fname: " + fname);
            System.out.println("Last: " + lname);
            System.out.println("renz");

        }
    }

    class b3 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            main_faculty_panel.setVisible(false);
            createPanel.setVisible(true);
            availablecourses.removeAllItems();
            f.setTitle("[FACULTY][EDITOR]");
        }
    }

    class b4 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            main_faculty_panel.setVisible(false);
            viewpanel.setVisible(true);

            coursesavail.removeAllItems();

            String coursespath = "src\\Courses";

            File courseFolders = new File(coursespath);
            File[] files = courseFolders.listFiles();

            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("Folder name: " + file.getName());
                    String item = file.getName();
                    coursesavail.addItem(item);
                }
            }
            f.setTitle("[FACULTY][VIEW ENROLLED]");
        }
    }

    class b5 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            f.dispose();

            logingui loginObject = new logingui();

            loginObject.frontGUI();

            f.setTitle("XYZ UNIVERSITY LOGIN");
        }
    }


    class selectcourse implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            studsenrolled.setText(null);

            String folderpath = coursesavail.getSelectedItem().toString();

            String viewpath = "src\\Courses\\";

            viewpath = viewpath + folderpath;

            File courseFolders = new File(viewpath);

            File[] studentFiles = courseFolders.listFiles();

            for (File file : studentFiles) {

                if (file.isFile()) {
                    String myfile = file.getName();
                    
                    studsenrolled.append(myfile.replace(".txt", "") +"\n");
            

            System.out.println(availablecourses.getSelectedItem());
            
            
        }
    }

        }
}
}