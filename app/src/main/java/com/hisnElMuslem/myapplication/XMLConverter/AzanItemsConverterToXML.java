package com.hisnElMuslem.myapplication.XMLConverter;

import com.hisnElMuslem.myapplication.Model.AzanItems;
import com.hisnElMuslem.myapplication.Utilities.FileUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AzanItemsConverterToXML {

    public static XStream xstream = null;

    static {
        xstream = new XStream(new DomDriver());
        xstream.alias("com.hisnElMuslem.myapplication.Model.AzanItems", AzanItems.class);
        xstream.autodetectAnnotations(true);
        xstream.alias("list",List.class);

    }

    public static List<AzanItems> getAzanItemsDetails(String filePath) {
        File f = new File(filePath);
        List<AzanItems> azanItems = (List<AzanItems>) xstream.fromXML(f, new AzanItems());
        return azanItems;
    }
    public static boolean deleteAll(List<AzanItems>azanItems,String filePath)throws IOException
    {
        boolean isDeleted = false;
        azanItems.clear();
        String xml = xstream.toXML(azanItems);
        FileUtils.addToFile(xml, filePath);
        isDeleted = true;
        return isDeleted;
    }

    public static boolean isSaveUpdate(List<AzanItems> azanItems, String filePath) throws IOException {
        boolean isUpdate = false;
        String xml = xstream.toXML(azanItems);
        FileUtils.addToFile(xml, filePath);
        isUpdate = true;
        return isUpdate;
    }

}
