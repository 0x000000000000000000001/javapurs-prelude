    public static final Object showIntImpl = (java.util.function.Function<Object, Object>) (value) -> ((Integer) value).toString();

    public static final Object showNumberImpl = (java.util.function.Function<Object, Object>) (value) -> {
        double number = ((Number) value).doubleValue();
        if (!Double.isFinite(number)) return Double.toString(number);
        if (number == 0.0) return "0.0";
        java.math.BigDecimal decimal = java.math.BigDecimal.valueOf(number).stripTrailingZeros();
        double magnitude = Math.abs(number);
        if (magnitude >= 1e-6 && magnitude < 1e21) {
            String result = decimal.toPlainString();
            return decimal.scale() <= 0 ? result + ".0" : result;
        }
        return decimal.toString().replace('E', 'e');
    };

    public static final Object showCharImpl = (java.util.function.Function<Object, Object>) (value) -> {
        char code = value instanceof Character ? (Character) value : ((String) value).charAt(0);
        return "'" + (code == '\'' ? "\\'" : showEscape(code, false)) + "'";
    };

    public static final Object showStringImpl = (java.util.function.Function<Object, Object>) (value) -> {
        String string = (String) value;
        StringBuilder result = new StringBuilder("\"");
        for (int i = 0; i < string.length(); i++) {
            char code = string.charAt(i);
            String escaped = showEscape(code, true);
            result.append(escaped);
            if (escaped.length() > 1 && Character.isDigit(escaped.charAt(1)) && i + 1 < string.length()) {
                char next = string.charAt(i + 1);
                if (next >= '0' && next <= '9') result.append("\\&");
            }
        }
        return result.append('"').toString();
    };

    private static String showEscape(char code, boolean string) {
        switch (code) {
            case '\\': return "\\\\";
            case '"': return string ? "\\\"" : "\"";
            case 7: return "\\a";
            case '\b': return "\\b";
            case '\f': return "\\f";
            case '\n': return "\\n";
            case '\r': return "\\r";
            case '\t': return "\\t";
            case 11: return "\\v";
            default: return code < 0x20 || code == 0x7f ? "\\" + (int) code : String.valueOf(code);
        }
    }

    public static final Object showArrayImpl = (java.util.function.Function<Object, Object>) (show) -> (java.util.function.Function<Object, Object>) (value) -> {
        Object[] array = (Object[]) value;
        java.util.function.Function<Object, Object> showElement = (java.util.function.Function<Object, Object>) show;
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) result.append(',');
            result.append((String) showElement.apply(array[i]));
        }
        return result.append(']').toString();
    };
