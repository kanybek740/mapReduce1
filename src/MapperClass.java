import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MapperClass {
    FileReader fileReader = null;

    //BufferedReader reader1 = new BufferedReader(fileReaderJson);
    public MapperClass(String filename) throws IOException {
        fileReader = new FileReader(filename);
    }

    public HashMap<String, ArrayList> superMapper() throws IOException {
        BufferedReader reader = new BufferedReader(fileReader);

        HashMap<String, ArrayList> listOfMaps = null;

        String allInOneString = "";

        while(reader.ready()){
            String str = reader.readLine();
            allInOneString += str;
        }
        reader.close();
        listOfMaps = xmlSchemaToCsv(allInOneString);
        //fileReader.close();
        return listOfMaps;
    }

    public HashMap<String, ArrayList> jsonMapper() throws IOException {

        BufferedReader reader1 = new BufferedReader(fileReader);
        HashMap<String, ArrayList> listOfMaps = null;

        String allInOneString = "";

        while(reader1.ready()){
            String str = reader1.readLine();
            allInOneString += str;
        }
        reader1.close();
        listOfMaps = jsonShemaToCsv(allInOneString);
        fileReader.close();
        return listOfMaps;
    }

    public HashMap<String, ArrayList> xmlSchemaToCsv(String mainString) throws IOException {
        String[] noutbuki = mainString.split("</laptop>");
        HashMap<String, ArrayList> maplist2 = new HashMap<>();
        for (String noutbuk : noutbuki) {

            if (noutbuk.trim().isEmpty()) {
                continue;
            }
            String ram = extractValueFromXml(noutbuk, "ram");
            String storage = extractValueFromXml(noutbuk, "storage");
            String graphics = extractValueFromXml(noutbuk, "graphics");
            String display = extractValueFromXml(noutbuk, "display");
            String operatingSystem = extractValueFromXml(noutbuk, "operating_system");
            String price = extractValueFromXml(noutbuk, "price");
            String weight = extractValueFromXml(noutbuk, "weight");
            String color = extractValueFromXml(noutbuk, "color");
            String bluetooth = extractValueFromXml(noutbuk, "bluetooth");
            String brand = extractValueFromXml(noutbuk, "brand");
            String model = extractValueFromXml(noutbuk, "model");
            String processor = extractValueFromXml(noutbuk, "processor");

            ArrayList<String> listof = new ArrayList<>();
            listof.add(model);
            listof.add(processor);
            listof.add(storage);
            listof.add(display);
            listof.add(ram);
            listof.add(price);
            listof.add(color);
            maplist2.put(brand, listof);
        }
        return maplist2;
    }

    public HashMap<String, ArrayList> jsonShemaToCsv(String mainString) throws IOException {
        String[] noutbuki2 = mainString.split("}");
        HashMap<String, ArrayList> mapList = new HashMap<>();
        for (String noutbuk1 : noutbuki2) {

            if (noutbuk1.trim().isEmpty()) {
                continue;
            }
            String ram = getValueFromJson(noutbuk1, "ram");
            String storage = getValueFromJson(noutbuk1, "storage");
            String graphics = getValueFromJson(noutbuk1, "graphics");
            String display = getValueFromJson(noutbuk1, "display");
            String operatingSystem = getValueFromJson(noutbuk1, "operating_system");
            String price = getValueFromJson(noutbuk1, "price");
            String weight = getValueFromJson(noutbuk1, "weight");
            String color = getValueFromJson(noutbuk1, "color");
            String bluetooth = getValueFromJson(noutbuk1, "bluetooth");
            String brand = getValueFromJson(noutbuk1, "brand");
            String model = getValueFromJson(noutbuk1, "model");
            String processor = getValueFromJson(noutbuk1, "processor");

            ArrayList<String> listi = new ArrayList<>();
            listi.add(model);
            listi.add(processor);
            listi.add(storage);
            listi.add(display);
            listi.add(ram);
            listi.add(price);
            listi.add(color);
            mapList.put(brand, listi);
        }
        return mapList;
    }
    public static String getValueFromJson(String jsonString, String key) {
        int startIndex = jsonString.indexOf(key);
        if (startIndex == -1) {
            return null;
        }
        int endIndex = jsonString.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = jsonString.indexOf("}", startIndex);
        }
        if (endIndex == -1) {
            return null;
        }
        String jsonValue = jsonString.substring(startIndex + key.length() + 4, endIndex - 1).trim();
        if (jsonValue.startsWith("\"") && jsonValue.endsWith("\"")) {
            return jsonValue.substring(1, jsonValue.length() - 1);
        }
        return jsonValue;
    }

    public static String extractValueFromXml(String input, String tagName) {
        String regex = "<" + tagName + ">(.*?)</" + tagName + ">";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
