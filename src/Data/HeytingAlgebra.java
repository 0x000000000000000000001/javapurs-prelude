    public static Object boolConj = (java.util.function.Function<Object, Object>) (b1) -> (java.util.function.Function<Object, Object>) (b2) -> (Boolean) b1 && (Boolean) b2;
    public static Object boolDisj = (java.util.function.Function<Object, Object>) (b1) -> (java.util.function.Function<Object, Object>) (b2) -> (Boolean) b1 || (Boolean) b2;
    public static Object boolNot = (java.util.function.Function<Object, Object>) (b) -> !(Boolean) b;
