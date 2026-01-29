package ch08;

public class MyCalculator<T extends Number> {

    public T add(T a, T b){
        if(a instanceof Byte && b instanceof Byte){
            return (T) Byte.valueOf((byte) (a.byteValue() + b.byteValue()));
        }
        else if(a instanceof Short && b instanceof Short){
            return (T) Short.valueOf((short) (a.shortValue() + b.shortValue()));
        }
        else if(a instanceof Integer && b instanceof Integer){
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        }
        else if(a instanceof Long && b instanceof Long){
            return (T) Long.valueOf(a.longValue() + b.longValue());
        }
        else if(a instanceof Float && b instanceof Float){
            return (T) Float.valueOf(a.floatValue() + b.floatValue());
        }
        else if(a instanceof Double && b instanceof Double){
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        }
        return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
    }

    public T sub(T a, T b){
        if(a instanceof Byte && b instanceof Byte){
            return (T) Byte.valueOf((byte) (a.byteValue() - b.byteValue()));
        }
        else if(a instanceof Short && b instanceof Short){
            return (T) Short.valueOf((short) (a.shortValue() - b.shortValue()));
        }
        else if(a instanceof Integer && b instanceof Integer){
            return (T) Integer.valueOf(a.intValue() - b.intValue());
        }
        else if(a instanceof Long && b instanceof Long){
            return (T) Long.valueOf(a.longValue() - b.longValue());
        }
        else if(a instanceof Float && b instanceof Float){
            return (T) Float.valueOf(a.floatValue() - b.floatValue());
        }
        else if(a instanceof Double && b instanceof Double){
            return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
        }
        return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
    }
}

