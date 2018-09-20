package cicada.web.exception;

import cicada.core.Ret;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

@ControllerAdvice
@ResponseBody
public class CicadaExceptionHandler {
    public CicadaExceptionHandler() {
    }

    @ExceptionHandler({Exception.class})
    public Object Adddd(HttpServletRequest request, Exception exception) {
        Ret<String> ret = new Ret();
        ret.setStatus(0);
        ret.setMessage(exception.getMessage());
        return ret;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Object MethodArgumentNotValidHandler(HttpServletRequest request, MethodArgumentNotValidException exception) throws Exception {
        Ret<String> ret = new Ret();
        StringBuffer sBuffer = new StringBuffer();
        Iterator var6 = exception.getBindingResult().getFieldErrors().iterator();

        while(var6.hasNext()) {
            FieldError error = (FieldError)var6.next();
            sBuffer.append(error.getField());
            sBuffer.append(":  ");
            sBuffer.append(error.getDefaultMessage());
        }

        ret.setStatus(0);
        ret.setMessage(sBuffer.toString());
        return ret;
    }
}
