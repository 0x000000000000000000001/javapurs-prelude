    public static Object arrayApply = (java.util.function.Function<Object, Object>) (fs) ->
        (java.util.function.Function<Object, Object>) (xs) -> {
            Object[] functions = (Object[]) fs;
            Object[] values = (Object[]) xs;
            Object[] result = new Object[functions.length * values.length];
            int next = 0;
            for (Object function : functions) {
                for (Object value : values) {
                    result[next++] = ((java.util.function.Function<Object, Object>) function).apply(value);
                }
            }
            return result;
        };
