package cicada.authorization;

import javax.servlet.http.HttpServletRequest;

class DefaultGetToken {
    DefaultGetToken() {
    }

    public static String get(HttpServletRequest request) {
        return request.getHeader("Authentication");
    }
}
