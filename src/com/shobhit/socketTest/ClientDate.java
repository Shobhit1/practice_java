package com.shobhit.socketTest;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientDate {
    public static void main(String[] args) throws IOException, IOException {
        
        String serveraddress = JOptionPane.showInputDialog("Enter IP Address of machine");
        
        Socket s = new Socket(serveraddress, 9090);
        
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        String date = input.readLine();
        
        JOptionPane.showMessageDialog(null, date);
            
        System.exit(0);
        
        s.close();
        
    }
}
