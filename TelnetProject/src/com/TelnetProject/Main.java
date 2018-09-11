package com.TelnetProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
	 Main mainCls = new Main();
	 mainCls.exec("192.168.135.10");
    }

    void exec(String ip) throws IOException {

        Socket sock = null;
        BufferedReader br = null;
        PrintWriter pw = null;

        try
        {
            sock = new Socket(ip, 23);

            br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            pw = new PrintWriter(sock.getOutputStream());

            this.read(br);


            System.out.println("Sending username");
            this.read(br);
            //Thread.sleep(5000L);
            pw.println();
            this.read(br);
            pw.println();
            pw.println("abatest");

            this.read(br);  // Always blocks here
            System.out.println("Sending password");
            pw.println("p@ssw0rd");
            this.read(br);

            pw.println("EX");

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        finally {
            pw.close();
            br.close();
            sock.close();
        }
    }

    void read(BufferedReader br) throws IOException
    {
        char[] ca = new char[1024];
        int rc = br.read(ca);
        String s = new String(ca).trim();

        Arrays.fill(ca, (char)0);

        System.out.println("RC=" + rc + ":" + s);

//String s = br.readLine();
//
//while(s != null)
//{
//  if(s.equalsIgnoreCase("username:"))
//    break;
//
//  s = br.readLine();
//
//  System.out.println(s);
}
}
