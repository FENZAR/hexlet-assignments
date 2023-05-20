package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage{

    private final Map<String, String> keyValueStorage;

    InMemoryKV(Map<String, String> keyValueStorage) {
        this.keyValueStorage = new HashMap<>(keyValueStorage);
    }

    @Override
    public void set(String key, String value) {
        this.keyValueStorage.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.keyValueStorage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.keyValueStorage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(this.keyValueStorage);
    }
}
// END
