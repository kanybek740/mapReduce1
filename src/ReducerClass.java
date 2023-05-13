import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class ReducerClass {
    FileWriter writer = null;

    public ReducerClass (String fileOut) throws IOException {
        writer = new FileWriter(fileOut);
    }
    public void reducer(HashMap map) throws IOException {
        writer.append("brand,model,processor,storage,display,ram,price,color\n");
        HashMap<String, ArrayList> map1 = map;

        for(Map.Entry entry: map1.entrySet()){
            String brand = (String) entry.getKey();
            String properties = "";
            ArrayList<String> list = (ArrayList<String>) entry.getValue();
            for (String pro: list) {
                properties += pro + ",";
            }
            writer.append(brand).append(",").append(properties).append("\n");
        }
        writer.close();
    }
}
