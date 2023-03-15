package com.colincora.web.controller;

import com.colincora.service.store.CompanyService;
import com.colincora.service.store.impl.CompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author colincora
 * @date 2023/3/15 9:27
 */
public class BaseServlet extends HttpServlet {
    protected CompanyService companyService;

    @Override
    public void init() throws ServletException {
        companyService=new CompanyServiceImpl();
    }
}
