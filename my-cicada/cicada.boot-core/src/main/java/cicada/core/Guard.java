package cicada.core;

public class Guard {
    public Guard() {
    }

    public static void ThrowIfArgumentIsNull(Object argumentValue, String argumentName) throws Exception {
        if (argumentValue == null) {
            throw new Exception(String.format("参数:%s 不能为空值", argumentName));
        }
    }

    public static void ThrowIfArgumentIsNull(Object argumentValue, String argumentName, String message) throws Exception {
        if (argumentValue == null) {
            throw new Exception(String.format("参数:%s 触发异常:%s", argumentName, message));
        }
    }

    public static void ThrowIfArgumentIsNullOrEmpty(String argumentValue, String argumentName) throws Exception {
        if (argumentValue == null || argumentValue.length() == 0) {
            throw new Exception(String.format("参数:%s 不能为空值", argumentName));
        }
    }

    public static void ThrowIfArgumentLessThanZero(int argumentValue, String argumentName) throws Exception {
        if (argumentValue < 0) {
            throw new Exception(String.format("参数:%s 不能小于0", argumentName));
        }
    }
}
