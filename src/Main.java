
import javax.swing.text.Document;
import javax.swing.text.Element;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, ArrayList> mapList = null;
        HashMap<String, ArrayList> mapList2 = null;
        DriverClass driverClass = new DriverClass();
        mapList = driverClass.mapper1("NoteBooks.xml");
        mapList2 = driverClass.mapper2("NoteBook2.xml");
        driverClass.reducer1("noutbukiFromXml.csv", mapList);
        driverClass.reducer2("noutbukiFromXml2.csv", mapList2);

        HashMap<String, ArrayList> mapListjson = null;
        HashMap<String, ArrayList> mapListjson2 = null;
        mapListjson = driverClass.mapper1json("NoteBooks.json");
        mapListjson2 = driverClass.mapper2json("NoteBook2.json");
        driverClass.reducer1json("noutbukiFromJson.csv", mapList);
        driverClass.reducer2json("noutbukiFromJson2.csv", mapList2);
    }
}