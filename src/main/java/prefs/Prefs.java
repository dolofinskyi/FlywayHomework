package prefs;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.Map;

public class Prefs {

    public static final String PREFS_FILENAME = "prefs.json";
    public static final String JDBC_CONNECTION_URL = "jdbcUrl";

    private Map<String, Object> prefs;

    public Prefs() {
        this(PREFS_FILENAME);
    }

    public Prefs(String filename) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (InputStream stream = classLoader.getResourceAsStream(filename)){
            JsonElement prefsElement = JsonParser.parseReader(new InputStreamReader(stream));
            TypeToken<?> typeToken = TypeToken.getParameterized(Map.class, String.class, Object.class);
            prefs = new Gson().fromJson(prefsElement, typeToken.getType());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getString(String key){
        return getValue(key).toString();
    }

    public Object getValue(String key){
        return prefs.get(key);
    }

}
