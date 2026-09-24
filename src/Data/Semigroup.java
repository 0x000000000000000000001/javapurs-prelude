    public static Object concatString = (java.util.function.Function<Object, Object>) (s1) ->
        (java.util.function.Function<Object, Object>) (s2) -> ((String) s1) + ((String) s2);

    public static Object concatArray = (java.util.function.Function<Object, Object>) (xs) ->
        (java.util.function.Function<Object, Object>) (ys) -> {
            Object[] left = (Object[]) xs;
            Object[] right = (Object[]) ys;
            if (left.length == 0) return ys;
            if (right.length == 0) return xs;
            Object[] combined = new Object[left.length + right.length];
            System.arraycopy(left, 0, combined, 0, left.length);
            System.arraycopy(right, 0, combined, left.length, right.length);
            return combined;
        };
