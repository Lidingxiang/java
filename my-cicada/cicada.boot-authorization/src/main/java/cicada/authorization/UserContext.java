package cicada.authorization;


import javax.servlet.http.HttpServletRequest;

class UserContext {
    private final String UserIdKey = "LY_UserSession_UserId";
    private final String UserTypeKey = "LY_UserType";
    private String userId;
    private UserTypeEnum userType;

    UserContext() {
    }

    public String getUserId(HttpServletRequest request) throws Exception {
        if (request.getAttribute("LY_UserSession_UserId") != null) {
            return request.getAttribute("LY_UserSession_UserId").toString();
        } else {
            throw new Exception("请为方法添加UserAuthorizationAttribute标签");
        }
    }

    public void setUserId(String userId, HttpServletRequest request) {
        request.setAttribute("LY_UserSession_UserId", userId);
    }

    public UserTypeEnum getUserType(HttpServletRequest request) throws Exception {
        if (request.getAttribute("LY_UserType") != null) {
            return (UserTypeEnum)request.getAttribute("LY_UserType");
        } else {
            throw new Exception("请为方法添加UserAuthorizationAttribute标签");
        }
    }

    public void setUserType(UserTypeEnum userType, HttpServletRequest request) {
        request.setAttribute("LY_UserType", userType);
    }
}