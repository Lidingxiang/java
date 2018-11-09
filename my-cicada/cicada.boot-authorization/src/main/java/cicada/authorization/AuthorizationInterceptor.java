package cicada.authorization;


import cicada.authorization.config.GetUserIdRet;
import cicada.authorization.config.GetUserIdStatus;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    private UserTypeEnum UserType;

    public AuthorizationInterceptor() {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    public UserTypeEnum getUserType() {
        return this.UserType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.UserType = userType;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            Class<?> controller = method.getBeanType();
            UserAuthorization userAuthorization = controller == null ? null : controller.getAnnotation(UserAuthorization.class);
            if (userAuthorization == null) {
                userAuthorization = method.getMethod().getAnnotation(UserAuthorization.class);
            }

            if (userAuthorization != null) {
                String token = DefaultGetToken.get(request);
                if (token == null || token.length() == 0) {
                    this.UnAuthorize(request, response, 801);
                    return false;
                }

                GetUserIdRet userId = UserAuthClient.getUserId(token);
                if (userId == null) {
                    throw new Exception("不能根据token正确的获取用户ID");
                }

                if (userId != null && userId.status != GetUserIdStatus.Success) {
                    this.UnAuthorize(request, response, userId.status != GetUserIdStatus.InvalidSessionId ? 802 : 804);
                    return false;
                }

                boolean flag = false;
                boolean flag2 = this.UserType == UserTypeEnum.UserTypeRegister;
                if (!flag && flag2) {
                    this.UnAuthorize(request, response, 803);
                    return false;
                }

                request.setAttribute("userId", userId.getUserId());
            }
        }

        return true;
    }

    void UnAuthorize(HttpServletRequest request, HttpServletResponse response, int status) throws IOException {
        String content = String.format("Status:%s", status);
        response.getWriter().print(content);
    }
}

