package spring.cloud.zuul.fitter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 网关拦截，可以做一些安全验证
 *
 * @author wanghongfu
 * @create 2018-01-26 15:27
 **/
//@Service
public class ZuulFitter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(ZuulFitter.class);

    /**
         filterOrder：过滤的顺序
         shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
         run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
     * @return
     */

    /**
     * pre：路由之前
       routing：路由之时
       post： 路由之后
       error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        //return "pre";
        return "error";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * zuul 不仅只是路由，并且还能过滤，做一些安全验证
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}
            return ctx;
        }
        log.info("ok");
        return null;
    }
}
