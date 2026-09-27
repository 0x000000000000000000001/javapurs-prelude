    // Port of test/Test/Main.js. AlmostEff = Unit -> Unit, so each foreign
    // effect is a function taking the unit value.
    public static Object testNumberShow = (java.util.function.Function<Object, Object>) (showNumber) ->
        (java.util.function.Function<Object, Object>) (unit) -> {
            Object[][] cases = {
                {0.0, "0.0"},
                {1.0, "1.0"},
                {-1.0, "-1.0"},
                {500.0, "500.0"},
                {1e10, "10000000000.0"},
                {1e10 + 0.5, "10000000000.5"},
                {-1e10, "-10000000000.0"},
                {-1e10 - 0.5, "-10000000000.5"},
                {1e21, "1e+21"},
                {1e-21, "1e-21"},
                {1.5e21, "1.5e+21"},
                {1.5e-10, "1.5e-10"},
                {Double.NaN, "NaN"},
                {Double.POSITIVE_INFINITY, "Infinity"},
                {Double.NEGATIVE_INFINITY, "-Infinity"},
            };
            for (Object[] entry : cases) {
                String actual = (String) ((java.util.function.Function<Object, Object>) showNumber).apply(entry[0]);
                if (!entry[1].equals(actual)) {
                    throw new RuntimeException("For " + entry[0] + ", expected " + entry[1] + ", got: " + actual + ".");
                }
            }
            return unit;
        };

    public static Object makeArray = (java.util.function.Function<Object, Object>) (length) -> {
        int count = ((Number) length).intValue();
        Object[] values = new Object[count];
        for (int index = 0; index < count; index++) values[index] = index;
        return values;
    };
