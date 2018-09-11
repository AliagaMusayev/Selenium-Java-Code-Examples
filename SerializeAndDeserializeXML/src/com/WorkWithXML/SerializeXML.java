package com.WorkWithXML;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class SerializeXML {

    public static <T> void  serializeDataAndWriteToXMLFile(T t){

        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream( new FileOutputStream("myStudents.xml")));
            encoder.writeObject(t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            encoder.close();
        }

    }

    public  static <T> T deserializeXMLFileAndReturnAsObject(T t){

        XMLDecoder decoder = null;

        try {
            decoder = new XMLDecoder( new BufferedInputStream(new FileInputStream("myStudents.xml")));
            t = (T) decoder.readObject();
        }

        catch (FileNotFoundException ex){

            ex.printStackTrace();
        }

        finally {
            decoder.close();
        }


        return t;
    }
}
