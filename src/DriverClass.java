import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DriverClass {
    public DriverClass(){
    }

    public HashMap<String, ArrayList> mapper1(String str) throws IOException {
        HashMap<String, ArrayList> maplist = null;
        MapperClass mapperClass = new MapperClass(str);
        maplist = mapperClass.superMapper();
        return maplist;
    }

    public HashMap<String, ArrayList> mapper2(String str) throws IOException {
        HashMap<String, ArrayList> maplist = null;
        MapperClass mapperClass = new MapperClass(str);
        maplist = mapperClass.superMapper();
        return maplist;
    }

    public HashMap<String, ArrayList> mapper1json(String str) throws IOException {
        HashMap<String, ArrayList> maplistj = null;
        MapperClass mapperClass = new MapperClass(str);
        maplistj = mapperClass.jsonMapper();
        return maplistj;
    }

    public HashMap<String, ArrayList> mapper2json(String str) throws IOException {
        HashMap<String, ArrayList> maplist = null;
        MapperClass mapperClass = new MapperClass(str);
        maplist = mapperClass.jsonMapper();
        return maplist;
    }

    public void reducer1(String filename, HashMap hashMap) throws IOException {
        ReducerClass reducerClass = new ReducerClass(filename);
        reducerClass.reducer(hashMap);
    }

    public void reducer2(String filename, HashMap hashMap) throws IOException {
        ReducerClass reducerClass = new ReducerClass(filename);
        reducerClass.reducer(hashMap);
    }

    public void reducer1json(String filename, HashMap hashMap) throws IOException {
        ReducerClass reducerClass = new ReducerClass(filename);
        reducerClass.reducer(hashMap);
    }

    public void reducer2json(String filename, HashMap hashMap) throws IOException {
        ReducerClass reducerClass = new ReducerClass(filename);
        reducerClass.reducer(hashMap);
    }
}
