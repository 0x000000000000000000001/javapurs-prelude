    // AlmostEff = Unit -> Unit; the JS FFI returns a function that throws.
    public static Object throwErr = (java.util.function.Function<Object, Object>) (msg) ->
        (java.util.function.Function<Object, Object>) (unit) -> {
            throw new RuntimeException((String) msg);
        };
