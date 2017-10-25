package com.mycat.monoeshop.filter;

import java.util.stream.Stream;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.mycat.monoeshop.App;
import com.mycat.monoeshop.model.Account;
import com.mycat.monoeshop.model.Result;
import com.mycat.monoeshop.model.ResultEnum;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
public class SecurityPreFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityPreFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -100;
    }

    @Override
    public boolean shouldFilter() {
        String uri = getContext().getRequest().getRequestURI();
        return uri.startsWith("/cart/");
    }

    @Override
    public Object run() {
        LOGGER.info("security pre filter");
        
        HttpSession session = getContext().getRequest().getSession();
        Stream.of(getContext().getRequest().getCookies()).forEach(a -> {System.out.println("yyy cookie "+a.getName()+" "+a.getValue());});
        String accountStr = (String) session.getAttribute(App.SESSION_KEY);
        Account account = JacksonUtil.decode(accountStr, Account.class);
        LOGGER.info("sessionid "+session.getId()+"  account: {}", account);
        if (account != null) {
            getContext().addZuulRequestHeader("accountName", account.getName());
           
        } else {
            LOGGER.warn("account no login, send response directly");
            getContext().setSendZuulResponse(true);
            getContext().setResponseStatusCode(400);
            getContext().setResponseBody(JacksonUtil.encode(new Result(ResultEnum.NOT_LOGIN)));
        }
        LOGGER.info("session id: {}", session.getId());
        return null;
    }

    private RequestContext getContext() {
        return RequestContext.getCurrentContext();
    }
}
