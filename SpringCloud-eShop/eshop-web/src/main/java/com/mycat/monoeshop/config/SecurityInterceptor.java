package com.mycat.monoeshop.config;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.mycat.monoeshop.App;
import com.mycat.monoeshop.model.Result;
import com.mycat.monoeshop.service.rest.SessionService;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@Component
public class SecurityInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityInterceptor.class);
	private static final String REDIRECT_PAGE = "/login.html";
	ApplicationContext applicationContext;

	@EventListener
	public void setApplicationContext(ContextRefreshedEvent event) {
		applicationContext = event.getApplicationContext();
	}

	SessionService sessionService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		if (ArrayUtils.isEmpty(cookies)) {
			LOGGER.warn("no cookie ,to login ," + request.getRequestURL());
			response.sendRedirect(REDIRECT_PAGE);
			return false;
		}
		Optional<Cookie> opt = Stream.of(cookies)
				.filter(cookie -> cookie != null && App.SESSION_KEY.equals(cookie.getName())).findFirst();

		if (opt.isPresent()) {
			Cookie cookie = opt.get();
			String token = cookie.getValue();
			LOGGER.info("check  SESSION_KEY cookie  " + token);
			try {
				Result sessionResult = getSessionSrv().tokenCheck("SESSION=" + token);
				if (sessionResult != null && sessionResult.getCode() == SessionService.RESULT_SUCCESS) {
					return true;
				}
			} catch (Exception e) {
				LOGGER.warn("check token error", e);
			}
		}
		LOGGER.warn("no SESSION_KEY cookie ,to login ");
		response.sendRedirect(REDIRECT_PAGE);
		return false;
	}

	private SessionService getSessionSrv()
    {
    	if(sessionService!=null)
    	{
    		return sessionService;
    	}else
    	{
    		sessionService=this.applicationContext.getBean(SessionService.class);
    		return sessionService;
    	}    }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
