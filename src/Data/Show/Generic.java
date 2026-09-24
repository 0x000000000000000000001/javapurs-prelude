    public static Object intercalate = (java.util.function.Function<Object, Object>) (separator) ->
        (java.util.function.Function<Object, Object>) (xs) -> {
            Object[] items = (Object[]) xs;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < items.length; i++) {
                if (i > 0) builder.append((String) separator);
                builder.append(items[i]);
            }
            return builder.toString();
        };
