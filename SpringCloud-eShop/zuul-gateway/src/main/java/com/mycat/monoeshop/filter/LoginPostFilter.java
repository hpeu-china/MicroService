package com.mycat.monoeshop.filter;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.google.common.base.Charsets;
import com.mycat.monoeshop.App;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
public class LoginPostFilter extends ZuulFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginPostFilter.class);

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return 10;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext context = RequestContext.getCurrentContext();
		String uri = context.getRequest().getRequestURI();
		if (uri.startsWith("/account/login")) {
			LOGGER.info("filter login url "+uri.toString());
			return true;
		}
		return false;
	}

	@Override
	public Object run() {
		LOGGER.info("security post filter");

		RequestContext context = RequestContext.getCurrentContext();
		String result = null;

		if (context.getResponseBody() != null) {
			result = context.getResponseBody();
			context.setResponseBody(wrapResult(context, result));
		} else if (context.getResponseDataStream() != null) {
			InputStream is = context.getResponseDataStream();
			try {
				result = IOUtils.toString(is, Charsets.UTF_8.name());
				String tokenId = wrapResult(context, result);
				if (StringUtils.isNotEmpty(tokenId)) {
					context.setResponseDataStream(IOUtils.toInputStream(tokenId));
				}
			} catch (IOException e) {
				LOGGER.error("error to handle response "+e);
			}
		}

		return null;
	}

	private String wrapResult(RequestContext context, String result) {
		String tokenId = null;
		if (StringUtils.isNotEmpty(result)) {
			HttpSession session = context.getRequest().getSession();
			tokenId = session.getId();
			session.setAttribute(App.SESSION_KEY, result);
			session.setMaxInactiveInterval(60 * 60 * 12);
			LOGGER.info("login post filter result: {}, tokenId: {}", result, tokenId);
		}
		return tokenId;
	}
}
