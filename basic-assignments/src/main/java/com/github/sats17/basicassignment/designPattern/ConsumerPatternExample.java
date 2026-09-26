package com.github.sats17.basicassignment.designPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ConsumerPatternExample {

    private String value1;
    private int value2;

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public static <T> void copyIfSet(T value, Consumer<T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }
    }

    @Override
    public String toString() {
        return "ConsumerPatternExample{" +
                "value1='" + value1 + '\'' +
                ", value2=" + value2 +
                '}';
    }

    public static void main(String[] args) {
        Map<String, Object> dataFromCopy = new HashMap<>();
        dataFromCopy.put("value1", "value");
        dataFromCopy.put("value2", 1);

        // Without copyIfSet
        ConsumerPatternExample obj = new ConsumerPatternExample();
        if (dataFromCopy.get("value1") != null) {
            obj.setValue1((String) dataFromCopy.get("value1"));
        }

        if (dataFromCopy.get("value2") != null) {
            obj.setValue1((String) dataFromCopy.get("value1"));
        }

        System.out.println(obj.toString());

        ///  With copyIfSet
        ConsumerPatternExample obj2 = new ConsumerPatternExample();
        copyIfSet((String) dataFromCopy.get("value1"), obj2::setValue1);
        copyIfSet((int) dataFromCopy.get("value2"), obj2::setValue2);

        System.out.println(obj.toString());


    }
}
