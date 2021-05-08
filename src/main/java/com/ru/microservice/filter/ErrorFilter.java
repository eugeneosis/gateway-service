package com.ru.microservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 4;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    @SneakyThrows
    public Object run() {
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
        log.info("ErrorFilter: " + String.format("response status is %d", response.getStatus()));
        return null;
    }
}
