package cicada.web.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class ControlMonitor {
    private static final Logger log = LoggerFactory.getLogger(ControlMonitor.class);

    public ControlMonitor() {
    }

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController),@within(org.springframework.stereotype.Controller)")
    public void pointCut() {
    }

    @AfterThrowing(
            pointcut = "pointCut()",
            throwing = "ex"
    )
    public void around(Exception ex) {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch sw = new StopWatch(this.getClass().getSimpleName());
        StringBuffer sb = new StringBuffer();
        Object[] paramValues = null;
        String[] paramNames = null;
        Object result = null;

        try {
            Signature signature = joinPoint.getSignature();
            String shortstring = signature.toString();
            sw.start(shortstring);
            paramValues = joinPoint.getArgs();
            paramNames = ((CodeSignature)joinPoint.getSignature()).getParameterNames();
            if (log.isInfoEnabled()) {
                sb = this.getParam(sb, paramNames, paramValues);
            }

            result = joinPoint.proceed();
            if (log.isInfoEnabled()) {
                sb = this.getResult(sb, result);
            }

            sw.stop();
            if (log.isInfoEnabled()) {
                sb = this.getEnd(sb, sw);
                log.info(sb.toString());
            }

            return result;
        } catch (Exception var9) {
            sb = this.getParam(sb, paramNames, paramValues);
            sb = this.getResult(sb, result);
            sb = this.getEnd(sb, sw);
            sb.append("\r\n");
            sb.append(String.format("出现异常:%s", var9.getMessage()));
            if (sw.isRunning()) {
                sw.stop();
            }

            sb.insert(0, "\r\n" + sw.prettyPrint() + "\r\n");
            sb.append("\r\n");
            sb.append("-----------------------------------------");
            log.error(sb.toString(), var9);
            throw var9;
        }
    }

    StringBuffer getParam(StringBuffer sb, String[] paramNames, Object[] paramValues) {
        for(int i = 0; i < paramNames.length; ++i) {
            sb.append("\r\n");
            sb.append(String.format("参数名称:%s", paramNames[i]));
            sb.append(String.format("参数值:%s", paramValues[i]));
        }

        return sb;
    }

    StringBuffer getResult(StringBuffer sb, Object result) {
        sb.append("\r\n");
        sb.append(String.format("返回值:%s", result));
        return sb;
    }

    StringBuffer getEnd(StringBuffer sb, StopWatch sw) {
        sb.insert(0, "\r\n" + sw.prettyPrint());
        sb.append("\r\n");
        sb.append("-----------------------------------------");
        return sb;
    }
}