package com.hisnElMuslem.myapplication.Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileUtils {
    public static void addToFile(String xml, String path) throws IOException {
        try {
            File xml_file_name = new File(path);
            if(!xml_file_name.exists())
            {
                xml_file_name.createNewFile();
            }
            FileOutputStream is = new FileOutputStream(xml_file_name);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(xml);
            w.flush();
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
    }

}
