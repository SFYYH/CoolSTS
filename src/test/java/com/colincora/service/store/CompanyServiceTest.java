package com.colincora.service.store;

import com.colincora.domain.store.Company;
import com.colincora.service.store.impl.CompanyServiceImpl;
import com.github.pagehelper.PageInfo;
import org.junit.*;

/**
 * @author colincora
 * @date 2023/3/14 11:10
 */
public class CompanyServiceTest {
    private static CompanyService companyService=null;

    @BeforeClass
    public static void init(){
        companyService=new CompanyServiceImpl();
    }

    @Test
    public void testSave(){
        Company company=new Company();
        company.setName("测试数据");
        companyService.save(company);
    }

    @Test
    public void testFindAll(){
        PageInfo all = companyService.findAll(1, 100);
        System.out.println(all);
    }
    @AfterClass
    public static void destory(){
        companyService=null;
    }
}
