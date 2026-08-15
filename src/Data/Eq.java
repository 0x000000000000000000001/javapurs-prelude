    public static Object eqBooleanImpl = (java.util.function.Function<Object, Object>) (a) -> (java.util.function.Function<Object, Object>) (b) -> ((Boolean) a).equals((Boolean) b);
    public static Object eqIntImpl = (java.util.function.Function<Object, Object>) (a) -> (java.util.function.Function<Object, Object>) (b) -> ((Integer) a).equals((Integer) b);
    public static Object eqStringImpl = (java.util.function.Function<Object, Object>) (a) -> (java.util.function.Function<Object, Object>) (b) -> ((String) a).equals((String) b);
    public static Object eqCharImpl = (java.util.function.Function<Object, Object>) (a) -> (java.util.function.Function<Object, Object>) (b) -> ((String) a).equals((String) b);
    public static Object eqNumberImpl = (java.util.function.Function<Object, Object>) (a) -> (java.util.function.Function<Object, Object>) (b) -> ((Double) a).equals((Double) b);
    public static Object eqArrayImpl = (java.util.function.Function<Object, Object>) (f) -> (java.util.function.Function<Object, Object>) (xs) -> (java.util.function.Function<Object, Object>) (ys) -> {
        Object[] arr1 = (Object[]) xs;
        Object[] arr2 = (Object[]) ys;
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            Boolean res = (Boolean) ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) f).apply(arr1[i])).apply(arr2[i]);
            if (!res) return false;
        }
        return true;
    };
