package Project;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


public class DoctorDashboard extends JFrame implements ActionListener{
    
    //container
    Container container = getContentPane();
    
    //logo
    ImageIcon logo = new ImageIcon("logo.png");
    
    //Panel
    JPanel greetPanel = new JPanel();
    JPanel dashboardPanel = new JPanel();
    
    JPanel leftSpacer = new JPanel();
    JPanel rightSpacer = new JPanel();
    JPanel center = new JPanel();
    JPanel topSpacer = new JPanel();
    JPanel bottomSpacer = new JPanel();
    
    JPanel photoPanel = new JPanel();
    JPanel welcomePanel = new JPanel();
    JPanel logoutPanel = new JPanel();
    
    JPanel personalInfoPanel = new JPanel();

    JPanel searchPatientPanel = new JPanel();
    
    JLabel personalInfoLabel = new JLabel("Personal Information");

    JLabel searchPatientLabel = new JLabel("Search Patient");
    
    JLabel welcomeLabel = new JLabel("WELCOME");

    
    
    JButton personalInfoButton = new JButton(new ImageIcon("profile.png"));

    JButton searchPatientButton = new JButton(new ImageIcon("search.png"));
    
    JButton logoutButton = new JButton("LOGOUT");
    
    JLabel patLogoLabel = new JLabel(new ImageIcon("docs 2.png"));
    

    Person person;
    
    DoctorDashboard(Person getperson){
    
        this.setTitle("Medical History Management System");//title name
        this.setBounds(300, 100, 720, 600);//size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close 
        this.setResizable(true);//resizable

        //icon
        this.setIconImage(logo.getImage());
        
        Initialize();
        addActionEvent();
        person = getperson;
        
    }
    public void Initialize(){
        
        container.setLayout(new GridLayout(2,1));
        container.setSize(720,600);
        container.setBackground(new Color(94, 191, 244));
        
        greetPanel.setLayout(new BorderLayout());
        greetPanel.setBackground(new Color(13, 64, 93));
        container.add(greetPanel);
        
        photoPanel.add(patLogoLabel);
        
        photoPanel.setPreferredSize(new Dimension(150,150));
        photoPanel.setOpaque(false);
        greetPanel.add(photoPanel,BorderLayout.NORTH);
        
        logoutPanel.add(logoutButton);
        
        logoutPanel.setLayout(new FlowLayout());
        logoutPanel.setOpaque(false);
        logoutPanel.setPreferredSize(new Dimension(50,50));
        greetPanel.add(logoutPanel,BorderLayout.SOUTH);
        
        welcomePanel.setOpaque(false);
        welcomePanel.setLayout(new GridLayout(2,1));
        greetPanel.add(welcomePanel,BorderLayout.CENTER);
        
        
        
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(255,255,255));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        welcomePanel.add(welcomeLabel);
        
        

        
        center.setLayout(new BorderLayout());
        center.setOpaque(false);
        container.add(center);
        
        personalInfoPanel.setLayout(new BorderLayout(10,10));
        personalInfoPanel.setOpaque(false);
        labelDesign(personalInfoLabel);
        personalInfoPanel.add(personalInfoLabel,BorderLayout.SOUTH);
        personalInfoButton.setContentAreaFilled(false);
        personalInfoPanel.add(personalInfoButton,BorderLayout.CENTER);
        dashboardPanel.add(personalInfoPanel);
        

        
        searchPatientPanel.setLayout(new BorderLayout(10,10));
        searchPatientPanel.setOpaque(false);
        labelDesign(searchPatientLabel);
        searchPatientPanel.add(searchPatientLabel,BorderLayout.SOUTH);
        
        searchPatientButton.setContentAreaFilled(false);
        searchPatientPanel.add(searchPatientButton,BorderLayout.CENTER);
        dashboardPanel.add(searchPatientPanel);
       
   
        
        dashboardPanel.setLayout(new GridLayout(1,2,20,20));
        dashboardPanel.setOpaque(false);
        center.add(dashboardPanel,BorderLayout.CENTER);
        
        leftSpacer.setPreferredSize(new Dimension(20,20));
        leftSpacer.setOpaque(false);
        center.add(leftSpacer,BorderLayout.EAST);
        rightSpacer.setOpaque(false);
        rightSpacer.setPreferredSize(new Dimension(20,20));
        center.add(rightSpacer,BorderLayout.WEST);
        topSpacer.setOpaque(false);
        topSpacer.setPreferredSize(new Dimension(20,20));
        center.add(topSpacer,BorderLayout.NORTH);
        bottomSpacer.setOpaque(false);
        bottomSpacer.setPreferredSize(new Dimension(20,20));
        center.add(bottomSpacer,BorderLayout.SOUTH);
        
        
    }
    public void labelDesign(JLabel x){
        x.setHorizontalAlignment(SwingConstants.CENTER);
        x.setFont(new Font("Arial", Font.BOLD, 14));
        x.setForeground(new Color(255,255,255));
    }
    public void addActionEvent(){
        logoutButton.addActionListener(this);
        personalInfoButton.addActionListener(this);

        searchPatientButton.addActionListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logoutButton){
            this.setVisible(false);
            LoginFrame lframe = new LoginFrame();
            lframe.setVisible(true);
            
        }
        else if(e.getSource() == personalInfoButton){
            
            this.setVisible(false);
            Doctor test = new Doctor(person);
            test.setVisible(true);
           
        }
        else if(e.getSource() == searchPatientButton){
            
            this.setVisible(false);
            SearchPanel test = new SearchPanel(person);
            test.setVisible(true);
           
        }
    }
    
    
}
