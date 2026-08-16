    public static Object intDegree = (java.util.function.Function<Object, Object>) (x) -> Math.abs((Integer) x);
    public static Object intDiv = (java.util.function.Function<Object, Object>) (x) -> (java.util.function.Function<Object, Object>) (y) -> {
        int xInt = (Integer) x;
        int yInt = (Integer) y;
        if (yInt == 0) return 0;
        if (yInt > 0) return (int) Math.floor((double) xInt / yInt);
        return -(int) Math.floor((double) xInt / -yInt);
    };
    public static Object intMod = (java.util.function.Function<Object, Object>) (x) -> (java.util.function.Function<Object, Object>) (y) -> {
        int xInt = (Integer) x;
        int yInt = (Integer) y;
        if (yInt == 0) return 0;
        int yy = Math.abs(yInt);
        return ((xInt % yy) + yy) % yy;
    };
    public static Object numDiv = (java.util.function.Function<Object, Object>) (x) -> (java.util.function.Function<Object, Object>) (y) -> (Double) x / (Double) y;
