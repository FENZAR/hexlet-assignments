package exercise;

import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Set<String> keySet = storage.toMap().keySet();
        for(String key : keySet) {
            String value = storage.get(key, "default");
            storage.set(value, key);
            storage.unset(key);
        }
    }
}
// END
