package com.colincora.web.controller.company;

import com.colincora.domain.store.Company;
import com.colincora.service.store.CompanyService;
import com.colincora.service.store.impl.CompanyServiceImpl;
import com.colincora.utils.BeanUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author colincora
 * @date 2023/3/14 21:32
 */

/**
 * doGet doPost方法覆盖
 * 一个servlet只能完成一种功能的请求 如果像完成多个 需要加标志
 * uri:/store/company?operation=list
 */

@WebServlet("/store/company") //访问路径
public class CompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("run.....");
        String operation = request.getParameter("operation");
        //常量写前面变量写后面，有时候变量是空的
        if("list".equals(operation)){
            this.list(request,response);
        }else if("toAdd".equals(operation)){
            this.toAdd(request,response);
        }else if("save".equals(operation)){
            this.save(request,response);
        }else if("list".equals(operation)){

        }else if("list".equals(operation)){

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    private void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //进入列表页面
        //1.获取数据
        CompanyService companyService=new CompanyServiceImpl();
        //判断页面是否传值 默认page=1，size=5
        int page=1;
        int size=5;
        //StringUtils.isNoneBlank()判断如果你输值了 即点分页进来的
        if(StringUtils.isNoneBlank(request.getParameter("page"))){
//            System.out.println("你获取到了page的数值"+request.getParameter("page"));
            page=Integer.parseInt(request.getParameter("page"));
            System.out.println(page);
        }
        if(StringUtils.isNoneBlank(request.getParameter("size"))){
            size=Integer.parseInt(request.getParameter("size"));
        }
        PageInfo all = companyService.findAll(page,size);
        //2.将数据保存到指定位置
        request.setAttribute("page",all);
        //3跳转页面
        request.getRequestDispatcher("/WEB-INF/pages/store/Company/list.jsp").forward(request,response);
        System.out.println("这里是跳转list页面哦~【src/main/webapp/WEB-INF/pages/store/Company/list.jsp】");
    }
    private void toAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/store/Company/add.jsp").forward(request,response);
        System.out.println("这里是添加数据页面哦~【src/main/webapp/WEB-INF/pages/store/Company/add.jsp】");
    }
    private void save(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //将数据获取到，封装成一个对象
        Company company= BeanUtil.fillBean(request,Company.class,"yyy-MM-dd");
        //调用业务层接口save
        CompanyService companyService=new CompanyServiceImpl();
        companyService.save(company);
        //跳转回到列表页面
        //list(request,response);
        response.sendRedirect(request.getContextPath()+"/store/company?operation=list");
    }
}
