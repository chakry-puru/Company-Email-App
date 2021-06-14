package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Mail {
    private String fname;
    private String lname;
    private String password;
    private String job;
    private String email;
    private int mailCapacity = 1000;
    private int defaultPassLength =10;
    private String alternateEmail;

    //Constructor to recieve fname and lname
    public Mail(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
        //System.out.println("Email created: " + this.fname + " " + this.lname );
        //call a method asking for job - return job
        this.job = setJob();
        //System.out.println("Job: " +this.job);
        //call a method returning a random pass
        this.password = randomPass(defaultPassLength);
        System.out.println("your password:"+this.password);
        //print full email fname.lname@job.com
        email = fname.toLowerCase() + lname.toLowerCase() + "@"+ job+".com";
        //System.out.println("YOur EMail is "+email);

    }

    //ask for job
    private String setJob(){
        System.out.println("Enter your job\n1 for developer\n2 for manager\n3 for HR\n0 for none ");
        Scanner in = new Scanner(System.in);
        int jobChoice = in.nextInt();
        if (jobChoice == 1){
            return "developer";
        }
        else if (jobChoice == 2){
            return "manager";
        }
        else if (jobChoice == 3){
            return "HR";
        }
        else { return "";}

    }

    //random pass
    private String randomPass(int length){
        String passSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
        char[] pass = new char[length];
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passSet.length());
            pass[i] = passSet.charAt(rand);

        }
        return new String(pass);

    }

    //set mailcapacity
    public void setMailCapacity(int capacity){
        this.mailCapacity = capacity;
    }

    //set alternate email
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    //change pass
    public void changePass(String pass){
        this.password = pass;
    }

    public int getMailCapacity(){ return mailCapacity;}
    public String getAlternateEmail(){ return alternateEmail;}
    public String getPassword(){ return password;}

    public String showInfo(){
        return "Name:" + fname + " "+ lname +
                "\nemail:" + email +
                "\nMail Capacity:"+ mailCapacity +"gb";
    }




}
