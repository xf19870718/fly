package project.web.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageBeanInterceptorAdapter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        String page = request.getParameter("page");

        if (StringUtils.isNotBlank(page) || StringUtils.isNumeric(page)) {
            System.out.println("coming");
            request.setAttribute("pageNum", Integer.valueOf(page).intValue());
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        Object page = request.getAttribute("pageNum");

        if (null != page && page instanceof Integer) {
            System.out.println("leaving");
            request.setAttribute("page", page);
        }

        super.postHandle(request, response, handler, modelAndView);
    }
}
