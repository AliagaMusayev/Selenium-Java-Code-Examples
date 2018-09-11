package com.TelnetConnect;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.ChannelExec;

public class Main {

    public static void main(String[] args) {
        String host="192.168.135.10";//this is remote server - replaced
        String user="abatest";
        String password="p@ssw0rd";
        String command1="EX";
        String command2 = "ALIAGAMU1";
        String command3 = "P@ssw0rd";
        try{
            ByteArrayInputStream stream = new ByteArrayInputStream(command2 .getBytes(StandardCharsets.UTF_8));
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session=jsch.getSession(user, host, 23);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");

            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command1);

            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);
            channel.connect();
            channel.setInputStream(stream);
            InputStream in=channel.getInputStream();

            byte[] tmp=new byte[1024];
            while(true){
                while(in.available()>0){
                    int i=in.read(tmp,0,1);
                    if(i<0)break;
                    System.out.print(new String(tmp, 0, i));
                }

                if(channel.isClosed()){
                    System.out.println("exit-status: "+channel.getExitStatus());
                    break;
                }
                try{Thread.sleep(1000);}catch(Exception ee){}
            }

            channel.disconnect();
            session.disconnect();
            System.out.println("DONE");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}