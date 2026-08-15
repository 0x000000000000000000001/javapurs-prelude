    public static Object unsafeCompareImpl = (java.util.function.Function<Object, Object>) (lt) -> (java.util.function.Function<Object, Object>) (eq) -> (java.util.function.Function<Object, Object>) (gt) -> (java.util.function.Function<Object, Object>) (x) -> (java.util.function.Function<Object, Object>) (y) -> {
        int cmp;
        if (x instanceof String && y instanceof String) {
            cmp = ((String) x).compareTo((String) y);
        } else if (x instanceof Integer && y instanceof Integer) {
            cmp = ((Integer) x).compareTo((Integer) y);
        } else if (x instanceof Double && y instanceof Double) {
            cmp = ((Double) x).compareTo((Double) y);
        } else if (x instanceof Boolean && y instanceof Boolean) {
            cmp = ((Boolean) x).compareTo((Boolean) y);
        } else {
            throw new RuntimeException("unsafeCompareImpl: Unsupported types " + x.getClass() + " and " + y.getClass());
        }
        if (cmp < 0) return lt;
        if (cmp > 0) return gt;
        return eq;
    };

    public static Object ordBooleanImpl = unsafeCompareImpl;
    public static Object ordIntImpl = unsafeCompareImpl;
    public static Object ordNumberImpl = unsafeCompareImpl;
    public static Object ordStringImpl = unsafeCompareImpl;
    public static Object ordCharImpl = unsafeCompareImpl;

    public static Object ordArrayImpl = (java.util.function.Function<Object, Object>) (f) -> (java.util.function.Function<Object, Object>) (xs) -> (java.util.function.Function<Object, Object>) (ys) -> {
        Object[] arr1 = (Object[]) xs;
        Object[] arr2 = (Object[]) ys;
        int xlen = arr1.length;
        int ylen = arr2.length;
        int i = 0;
        while (i < xlen && i < ylen) {
            Object x = arr1[i];
            Object y = arr2[i];
            int o = (Integer) ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) f).apply(x)).apply(y);
            if (o != 0) {
                return o;
            }
            i++;
        }
        if (xlen == ylen) {
            return 0;
        } else if (xlen > ylen) {
            return -1;
        } else {
            return 1;
        }
    };
