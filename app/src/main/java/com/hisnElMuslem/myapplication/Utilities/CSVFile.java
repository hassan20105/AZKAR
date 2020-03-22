package com.hisnElMuslem.myapplication.Utilities;

import android.util.Log;

import com.hisnElMuslem.myapplication.Model.AzanItems;
import com.hisnElMuslem.myapplication.Model.ZekrItems;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {
    InputStream inputStream;

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public List <ZekrItems> read(){
        List<ZekrItems> resultList = new ArrayList();
        CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
        try {
            String[]eachRow = {};
                List<String[]> rows = reader.readAll();
                for(int i=1;i<rows.size();i++){
                    eachRow = rows.get(i);
                    resultList.add(new ZekrItems(eachRow[0],eachRow[1],eachRow[2],eachRow[3],eachRow[4]));
                }
            Log.d("","");

        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return resultList;
    }
}
