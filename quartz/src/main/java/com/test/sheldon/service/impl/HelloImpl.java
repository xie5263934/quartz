package com.test.sheldon.service.impl;

import com.test.sheldon.service.HelloService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author JINRUN.XIE
 * @since 2017/5/23
 */
@Service
public class HelloImpl implements HelloService {

    private static final Logger logger = Logger.getLogger(HelloImpl.class);

    @Override
    public void hello() {
        logger.error("hello World1!");
        logger.debug("hello World2!");
        logger.info("hello World3!");
    }
}
