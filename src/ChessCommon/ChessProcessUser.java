/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessCommon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class ChessProcessUser 
{
    private final HashMap<String, String> users;
    private final String fileLocation;

    public ChessProcessUser() 
    {
        this.users = new HashMap();
        this.fileLocation = "./resources/User_Details.txt";
        this.getUserList(fileLocation);
    }
    
    public void getUserList(String path)
    {
        FileInputStream fin;
        try {
            fin = new FileInputStream(path);
            Scanner fileScanner = new Scanner(fin);
            while (fileScanner.hasNextLine()) 
            {
                String line = fileScanner.nextLine();
                StringTokenizer st = new StringTokenizer(line);
                while(st.hasMoreTokens())
                {
                ChessUser u = new ChessUser(st.nextToken(), st.nextToken());
                this.users.put(u.getUserName(),u.getPassword());
                }
            }
            fin.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean validateUser(String user, String pass)
    {
        String userPassword;
        
        if(this.users.containsKey(user))
        {
            userPassword = this.users.get(user);
            
            if(userPassword.equals(pass))
            {
                System.out.println("Welcome back, " + user + "!");
                return true;
            }
            System.out.println("Incorrect Password!");
        }
        else
        {
            System.out.println("No user found with the name '" + user +"'");
        }
        return false;
    }
    
    public void newUser(String newUser, String newPass)
    {
        this.users.put(newUser,newPass);
        try
        {
            FileOutputStream fOut = new FileOutputStream(this.fileLocation,true);
            PrintWriter pw = new PrintWriter(fOut);
            pw.println(newUser + " " + newPass);
            pw.close();
        }
        catch (FileNotFoundException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
    
}
