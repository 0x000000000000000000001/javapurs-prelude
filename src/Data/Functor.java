    public static Object arrayMap = (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Function<Object, Object>) (arr) -> {
            Object[] source = (Object[]) arr;
            Object[] result = new Object[source.length];
            for (int i = 0; i < source.length; i++) {
                result[i] = ((java.util.function.Function<Object, Object>) f).apply(source[i]);
            }
            return result;
        };
