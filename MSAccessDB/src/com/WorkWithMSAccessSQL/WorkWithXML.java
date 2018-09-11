package com.WorkWithMSAccessSQL;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class WorkWithXML {

    public static <T> void WriteDataToXML(T type){
        XMLEncoder encoder =null;

        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("DataFromMsAcess.xml")));
            encoder.writeObject(type);
        }

        catch (FileNotFoundException ex){

        }

        finally {
            encoder.close();
        }
    }
}
