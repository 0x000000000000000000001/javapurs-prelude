    public static Object arrayBind = (java.util.function.Function<Object, Object>) (arrObj) -> (java.util.function.Function<Object, Object>) (f) -> {
        Object[] arr = (Object[]) arrObj;
        java.util.List<Object> result = new java.util.ArrayList<>();
        for (Object item : arr) {
            Object[] mapped = (Object[]) ((java.util.function.Function<Object, Object>) f).apply(item);
            for (Object mappedItem : mapped) {
                result.add(mappedItem);
            }
        }
        return result.toArray(new Object[0]);
    };
