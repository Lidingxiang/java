package cicada.core;


public class StringUtil {
    public StringUtil() {
    }

    public static String DefaultIfNull(String src, String defaultValue) {
        return src == null ? defaultValue : src;
    }

    public static String DefaultIfNullOrEmpty(String src, String defaultValue) {
        return !src.isEmpty() && src != null ? src : defaultValue;
    }

    public static String ReplaceWhiteSpace(String src, String newValue, Boolean repeated) {
        if (!src.isEmpty() && src != null) {
            int num = -2147483648;
            StringBuilder stringBuilder = new StringBuilder();

            for(int i = 0; i < src.length(); ++i) {
                char c = src.charAt(i);
                if (Character.isWhitespace(c)) {
                    if (repeated.booleanValue()) {
                        stringBuilder.append(newValue);
                    } else {
                        if (num != i - 1) {
                            stringBuilder.append(newValue);
                        }

                        num = i;
                    }
                } else {
                    stringBuilder.append(c);
                }
            }

            return stringBuilder.toString();
        } else {
            return src;
        }
    }

    public static String TrimStart(String src, String start, Boolean ignoreCase) {
        String text = src;
        int len = start.length();
        if (ignoreCase.booleanValue()) {
            String startTemp = src.substring(0, len);
            if (startTemp.equalsIgnoreCase(start)) {
                text = src.substring(len);
            }
        } else if (src.startsWith(start)) {
            text = src.substring(len);
        }

        return text;
    }

    public static String TrimEnd(String src, String end, Boolean ignoreCase) {
        String text = src;
        int len = end.length();
        int totalLen = src.length();
        if (ignoreCase.booleanValue()) {
            String endTemp = src.substring(totalLen - len, len);
            if (endTemp.equalsIgnoreCase(end)) {
                text = src.substring(0, totalLen - len);
            }
        } else if (src.endsWith(end)) {
            text = src.substring(0, totalLen - len);
        }

        return text;
    }
}
