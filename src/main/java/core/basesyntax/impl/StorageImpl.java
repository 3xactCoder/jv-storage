package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keys = new Object[MAX_SIZE];
    private Object[] values = new Object[MAX_SIZE];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (key == null ? keys[i] == null : key.equals(keys[i])) {
                values[i] = value; // перезапис значення
                return;
            }
        }


        if (count < MAX_SIZE) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            throw new RuntimeException("Storage is already full");
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    return (V) values[i];
                }
            } else {
                if (key.equals(keys[i])) {
                    return (V) values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
