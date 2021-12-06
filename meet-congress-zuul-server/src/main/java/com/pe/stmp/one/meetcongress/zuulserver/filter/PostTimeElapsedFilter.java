package com.pe.stmp.one.meetcongress.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PostTimeElapsedFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(PostTimeElapsedFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("Entrando a post filter");

        Long startTime = (Long) request.getAttribute("startTime");
        Long finishTime = System.currentTimeMillis();
        Long elapsedTime = finishTime-startTime;

        log.info(String.format("Tiempo transcurrido en segundos %s seg.", elapsedTime.doubleValue()/1000.00));
        log.info(String.format("Tiempo transcurrido en miliseg %s ms.", elapsedTime));
        return null;
    }
}
