package com.mycat.monoeshop.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycat.monoeshop.App;
import com.mycat.monoeshop.model.Result;
import com.mycat.monoeshop.model.ResultEnum;

import java.util.Arrays;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@RestController
public class SessionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @GetMapping("/session/token")
    public Result checkToken(HttpServletRequest request) {
        Result result = null;
        LOGGER.info("session cookied: {}",Arrays.toString(request.getCookies()));
        Stream.of(request.getCookies()).forEach(a -> {System.out.println("xxx cookie "+a.getName()+" "+a.getValue());});
        String sessionToken = (String) request.getSession().getAttribute(App.SESSION_KEY);

        if (StringUtils.isEmpty(sessionToken)) {
        	LOGGER.warn("no session key found ,shoud login ");
            result = new Result(ResultEnum.NOT_LOGIN);
        } else {
        	LOGGER.info(" session key found ,ok , session id "+request.getSession().getId()+" "+sessionToken);
            result = new Result(ResultEnum.SUCCESS);
        }
        return result;
    }
}
