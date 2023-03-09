package org.prog.util;

import org.w3c.dom.CDATASection;

import java.util.HashMap;

public class DataHolder {

    private static final DataHolder instance = new DataHolder();
    private final ThreadLocal<HashMap<String, Object>> data;

    private DataHolder() {
        data = new ThreadLocal<>();
    }

    public static DataHolder getInstance() {
        return instance;
    }

    public void init(){
        if (data.get() == null){
            data.set(new HashMap<>());
        }
    }

    public void put(String key, Object value) {
        init();
        data.get().put(key, value);
    }

    public Object get(String key) {
        init();
        return data.get().get(key);
    }
}
