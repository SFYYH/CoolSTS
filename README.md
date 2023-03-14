# Cool刷题项目制作



## 系统架构

### 后台系统【技术框架】

#### 1.Page:AdminLTE+AJAX+JQuery+zTree

#### 2.Controll[表现层]:Servlet3.0+文件上传下载

#### 3.Service[业务层]:POI

#### 4.Dao[数据层]::MyBatis

#### 5.DB:MySQL

### MYSQL

### 前台系统【技术框架】

#### 1.Page:Vue+Element UI

#### 2.Controll[表现层]:Servlet3.0

#### 3.Service[业务层]:Redis

#### 4.Dao[数据层]:MyBatis

#### 5.DB:MySQL

## 需求分析



![QQ截图20230313185213](./assest/QQ截图20230313185213.png)



## 工程搭建

### 1.创建maven工程（web工程）

### 2.导入项目依赖的坐标（资源）

#### poem.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.colincora</groupId>
    <artifactId>CoolSTS</artifactId>
    <version>1.0-SNAPSHOT</version>


    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
        <!--mybatis_-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.3</version>
        </dependency>
        <!--分页插件-->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.1.2</version>
        </dependency>
        <!--mysql-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.46</version>
        </dependency>
        <!--druid数据源-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.21</version>
        </dependency>
        <!--junit-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <!-- servlet3.0 -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
        <!--jsp-->
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>javax.servlet.jsp-api</artifactId>
            <version>2.3.3</version>
            <scope>provided</scope>
        </dependency>
        <!--bean-utils-->
        <dependency>
            <groupId>commons-beanutils</groupId>
            <artifactId>commons-beanutils</artifactId>
            <version>1.9.4</version>
        </dependency>
        <!--apache工具包-->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.9</version>
        </dependency>
        <!--jstl-->
        <dependency>
            <groupId>jstl</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <!--jackson-->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.9.0</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.9.0</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.0</version>
        </dependency>
        <!--文件上传-->
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.3.1</version>
        </dependency>
        <!--POI-->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>4.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>4.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml-schemas</artifactId>
            <version>4.0.1</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!--tomcat插件-->
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.1</version>
                <configuration>
                    <port>8081</port>
                    <path>/</path>
                </configuration>
            </plugin>
        </plugins>
    </build>
<packaging>war</packaging>

</project>
```

### 3.补全目录结构

### 4.创建三层架构开发的包层次结构



### 导入AdminLTE框架进行页面的快速搭建

![AdminLTE](./assest/Snipaste_2023-03-14_10-15-26.png)





## 企业模块制作 -数据层 

### 实体类制作

##### com.colincora.domain.store.company

```java
package com.colincora.domain.store;

import java.util.Date;

/**
 * @author colincora
 * @date 2023/3/14 10:23
 */
public class company {
    private String id;
    private String name;
    private Date expirationDate;
    private String address;
    private String licenseId;
    private String representative;
    private String phone;
    private String companySize;
    private String industry;
    private String remarks;
    private Integer state;
    private String city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

```

### Dao层制作

> #### 实现层用mybatis 只用写dao接口就可以不用写dao实现 通过自动生成形式去创建实现类

#### com.colincora.dao.store.CompanyDao

```java
package com.colincora.dao.store;

import com.colincora.domain.store.Company;

import java.util.List;

/**
 * @author colincora
 * @date 2023/3/14 10:27
 */
public interface CompanyDao {
    int save(Company company);

    int delete(Company company);

    int update(Company company);

    Company findById(String id);

    List<Company> findAll();
}
```

#### CompanyDao配置文件

##### jdbc.properties

```xml
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/coolsts
jdbc.username=root
jdbc.password=root
```

##### SqlMapConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!--mybatis的主配置文件-->
<configuration>
    <!--定义property的配置-->
    <properties resource="jdbc.properties"></properties>


    <!--配置别名:别名配置是给实体类用的，不能用在dao上-->
    <typeAliases>
        <!--指定实体类所在的包，此时包下所有类都会注册别名，别名就是类名称-->
        <package name="com.colincora.domain"></package>
    </typeAliases>

    <!--配置分页插件，plugins标签有出现顺序要求，必须在environments之前，同时要在properties和typeAliases之后 -->
    <plugins>
        <!-- com.github.pagehelper.PageInterceptor -->
        <plugin interceptor="com.github.pagehelper.PageInterceptor">
            <property name="helperDialect" value="mysql"/>
            <property name="reasonable" value="true"/>
        </plugin>
    </plugins>

    <!--配置默认环境-->
    <environments default="mysql">
        <!--配置mysql的环境-->
        <environment id="mysql">
            <!--配置事务的类型-->
            <transactionManager type="JDBC"></transactionManager>
            <!--配置数据源信息-->
            <dataSource type="POOLED">
                <!--配置连接数据库的四个基本信息-->
                <property name="driver" value="${jdbc.driver}"></property>
                <property name="url" value="${jdbc.url}"></property>
                <property name="username" value="${jdbc.username}"></property>
                <property name="password" value="${jdbc.password}"></property>
            </dataSource>
        </environment>
    </environments>


    <!--配置映射配置文件的位置-->
    <mappers>
        <!--指定实体映射配置文件所在的包，指定的是dao接口所在的包-->
        <package name="com.colincora.dao"></package>
    </mappers>


</configuration>
```

##### CompanyDao.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.itheima.dao.store.CompanyDao">

    <!--配置实体类属性和数据库表中列的对应关系-->
    <resultMap id="BaseResultMap" type="com.itheima.domain.store.Company">
        <id column="id" jdbcType="VARCHAR" property="id"/>
        <result column="name" jdbcType="VARCHAR" property="name"/>
        <result column="expiration_date" jdbcType="TIMESTAMP" property="expirationDate"/>
        <result column="address" jdbcType="VARCHAR" property="address"/>
        <result column="license_id" jdbcType="VARCHAR" property="licenseId"/>
        <result column="representative" jdbcType="VARCHAR" property="representative"/>
        <result column="phone" jdbcType="VARCHAR" property="phone"/>
        <result column="company_size" jdbcType="VARCHAR" property="companySize"/>
        <result column="industry" jdbcType="VARCHAR" property="industry"/>
        <result column="remarks" jdbcType="VARCHAR" property="remarks"/>
        <result column="state" jdbcType="INTEGER" property="state"/>
        <result column="city" jdbcType="VARCHAR" property="city"/>
    </resultMap>

    <!--配置查询的列名公共SQL语句-->
    <sql id="Base_Column_List">
        id, name, expiration_date, address, license_id, representative, phone, company_size,industry, remarks, state, city
    </sql>

    <!--配置查询所有，带条件-->
    <select id="findAll" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from st_company
    </select>

    <!--配置根据ID查询-->
    <select id="findById" parameterType="java.lang.String" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from st_company
        where id = #{id,jdbcType=VARCHAR}
    </select>

    <!--配置根据id删除-->
    <delete id="delete" parameterType="java.lang.String">
        delete
        from st_company
        where id = #{id,jdbcType=VARCHAR}
    </delete>

    <!--配置全字段插入-->
    <insert id="save" parameterType="com.itheima.domain.store.Company">
        insert into st_company (id, name, expiration_date,
                                address, license_id, representative,
                                phone, company_size, industry,
                                remarks, state,
                                city)
        values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{expirationDate,jdbcType=TIMESTAMP},
                #{address,jdbcType=VARCHAR}, #{licenseId,jdbcType=VARCHAR}, #{representative,jdbcType=VARCHAR},
                #{phone,jdbcType=VARCHAR}, #{companySize,jdbcType=VARCHAR}, #{industry,jdbcType=VARCHAR},
                #{remarks,jdbcType=VARCHAR}, #{state,jdbcType=INTEGER},
                #{city,jdbcType=VARCHAR})
    </insert>

    <!--配置全字段更新-->
    <update id="update" parameterType="com.itheima.domain.store.Company">
        update st_company
        set name            = #{name,jdbcType=VARCHAR},
            expiration_date = #{expirationDate,jdbcType=TIMESTAMP},
            address         = #{address,jdbcType=VARCHAR},
            license_id      = #{licenseId,jdbcType=VARCHAR},
            representative  = #{representative,jdbcType=VARCHAR},
            phone           = #{phone,jdbcType=VARCHAR},
            company_size    = #{companySize,jdbcType=VARCHAR},
            industry        = #{industry,jdbcType=VARCHAR},
            remarks         = #{remarks,jdbcType=VARCHAR},
            state           = #{state,jdbcType=INTEGER},
            city            = #{city,jdbcType=VARCHAR}
        where id = #{id,jdbcType=VARCHAR}
    </update>
</mapper>
```

#### mybatis session工厂初始化

##### com.colincora.factory.MapperFactory 

> ##### 用于生成dao接口代理实现类的工厂

```java
package com.colincora.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 用于生成dao接口代理实现类的工厂
 * @author ColinCora
 * @Company http://www.github.com/SFYYH
 */
public class MapperFactory {

    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();

    static {
        InputStream in = null;
        try {
            //1.读取mybatis主配置文件
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.创建构建者对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.使用构建者创建SqlSessionFactory工厂
            factory = builder.build(in);
        }catch (Exception e){
            //打印异常信息到控制台
            e.printStackTrace();
            //抛出错误提示程序终止执行
            throw new ExceptionInInitializerError("初始化SqlSessionFactory失败");
        }finally {
            //释放流对象
            if(in != null){
                try{
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取SqlSession对象
     * @return
     * 保留此方法是为了后面对业务层方法增强，利用AOP添加事务
     */
    public static SqlSession getSqlSession(){
         return factory.openSession(false);
    }

    /**
     * 获取Dao接口的代理实现类
     * @param daoClass dao接口字节码
     * @return
     */
    public static <T> T getMapper(SqlSession sqlSession,Class<T> daoClass){
        //1.判断传入的SqlSession是否为null
        if(sqlSession == null){
            return null;
        }
        //2.不为null，创建代理实现类
        return sqlSession.getMapper(daoClass);
    }
}

```

##### com.colincora.utils.TransactionUtil.java

> ##### 用于数据提交、回滚、单独释放

```java
package com.colincora.utils;

import org.apache.ibatis.session.SqlSession;

/**
 * 事务控制类
 * @author ColinCora
 * @Company http://www.github.com/SFYYH
 */
public class TransactionUtil {

    /**
     * 提交释放
     * @param sqlSession
     */
    public static void commit(SqlSession sqlSession){
        if(sqlSession!=null) {
            sqlSession.commit();
        }
    }

    /**
     * 回滚释放
     * @param sqlSession
     */
    public static void rollback(SqlSession sqlSession){
        if(sqlSession!=null) {
            sqlSession.rollback();
        }
    }

    /**
     * 单独释放
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession){
        if(sqlSession!=null) sqlSession.close();
    }
}

```



## 企业模块制作-业务层

> 基础功能：增、删、改、查、分页查
>
> 主要是转调我们的数据层

##### com.colincora.service.store.CompanyService.java

> 业务层调用接口

```java
package com.colincora.service.store;

import com.colincora.domain.store.Company;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CompanyService {
    /**
     * 添加
     * @param company
     * @return
     */
    void save(Company company);

    /**
     * 删除
     * @param company
     * @return
     */
    void delete(Company company);

    /**
     * 更新
     * @param company
     * @return
     */
    void update(Company company);

    /**
     * 查询单个
     * @param id 查询的跳进啊
     * @return 查询的结果
     */
    Company findById(String id);

    /**
     * 查询全部的数据
     * @return 全部数据的列表对象
     */
    List<Company> findAll();

    /**
     * 分页查询数据
     * @param page 页码
     * @param size 每页显示数
     * @return
     */
    PageInfo findAll(int page,int size);
}
```

##### com.colincora.service.store.imp.CompanyServiceImp.java

> 接口实现层

```java
package com.colincora.service.store.impl;

import com.colincora.dao.store.CompanyDao;
import com.colincora.domain.store.Company;
import com.colincora.factory.MapperFactory;
import com.colincora.service.store.CompanyService;
import com.colincora.utils.TransactionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

/**
 * @author colincora
 * @date 2023/3/14 11:01
 */
public class CompanyServiceImpl implements CompanyService {

    @Override
    public void save(Company company) {
        SqlSession sqlSession = null;
        try {
            //1.获取 sqlsession对象
            sqlSession = MapperFactory.getSqlSession();
            //2.获取dao
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            //id使用UUID的生成策略来获取
            String id= UUID.randomUUID().toString();
            company.setId(id);
            //3.调用Dao层的操作
            companyDao.save(company);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Company company) {
        SqlSession sqlSession = null;
        try {
            //1.获取 sqlsession对象
            sqlSession = MapperFactory.getSqlSession();
            //2.获取dao
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            //3.调用Dao层的操作
            companyDao.delete(company);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Company company) {
        SqlSession sqlSession = null;
        try {
            //1.获取 sqlsession对象
            sqlSession = MapperFactory.getSqlSession();
            //2.获取dao
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            //3.调用Dao层的操作
            companyDao.update(company);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    public Company findById(String id) {
        SqlSession sqlSession = null;
        try {
            //1.获取 sqlsession对象
            sqlSession = MapperFactory.getSqlSession();
            //2.获取dao
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            //3.调用Dao层的操作
            return companyDao.findById(id);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Company> findAll() {
        SqlSession sqlSession = null;
        try {
            //1.获取 sqlsession对象
            sqlSession = MapperFactory.getSqlSession();
            //2.获取dao
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            //3.调用Dao层的操作
            return companyDao.findAll();
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public PageInfo findAll(int page, int size) {
        SqlSession sqlSession = null;
        try {
            //1.获取 sqlsession对象
            sqlSession = MapperFactory.getSqlSession();
            //2.获取dao
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            //3.调用Dao层的操作
            PageHelper.startPage(page,size);
            List<Company> all = companyDao.findAll();
            PageInfo pageInfo=new PageInfo(all);
            return pageInfo;
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

##### 对业务层代码进行测试

##### com/colincora/service/store/CompanyServiceTest.java

```java
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
```



## 企业模块制作-表现层

> 表现出需要实现的七个功能
>
> 1.列表功能
>
> 2.跳转添加页
>
> 3.新增功能
>
> 4.跳转修改页
>
> 5.修改功能
>
> 6.分页功能
>
> 7.删除功能

#### 企业管理页面的补充完整

##### src/main/webapp/WEB-INF/pages/store/Company/list.jsp

```java
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../base.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>CoolSTS管理系统</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- 页面meta /-->
    <script src="${ctx}/plugins/jQuery/jquery-2.2.3.min.js"></script>
</head>
<script>
    function deleteById() {
        var id = getCheckId()
        if(id) {
            if(confirm("你确认要删除此条记录吗？")) {
                location.href="${ctx}/store/company?operation=delete&id="+id;
            }
        }else{
            alert("请勾选待处理的记录，且每次只能勾选一个")
        }
    }
</script>
<body>
<div id="frameContent" class="content-wrapper" style="margin-left:0px;">
<section class="content-header">
    <h1>
        企业管理
        <small>企业列表</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
    </ol>
</section>
<!-- 内容头部 /-->

<!-- 正文区域 -->
<section class="content">

    <!-- .box-body -->
    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">列表</h3>
        </div>

        <div class="box-body">

            <!-- 数据表格 -->
            <div class="table-box">

                <!--工具栏-->
                <div class="pull-left">
                    <div class="form-group form-inline">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default" title="新建" onclick='location.href="${ctx}/store/company?operation=toAdd"'><i class="fa fa-file-o"></i> 新建</button>
                            <button type="button" class="btn btn-default" title="删除" onclick='deleteById()'><i class="fa fa-trash-o"></i> 删除</button>
                            <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>
                        </div>
                    </div>
                </div>
                <div class="box-tools pull-right">
                    <div class="has-feedback">
                        <input type="text" class="form-control input-sm" placeholder="搜索">
                        <span class="glyphicon glyphicon-search form-control-feedback"></span>
                    </div>
                </div>
                <!--工具栏/-->

                <!--数据列表-->
                <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                    <thead>
                    <tr>
                        <th class="" style="padding-right:0px;">

                        </th>
                        <th class="sorting">企业名称</th>
                        <th class="sorting">所在地</th>
                        <th class="sorting">地址</th>
                        <th class="sorting">企业法人</th>
                        <th class="sorting">联系方式</th>
                        <th class="sorting">所属行业</th>
                        <th class="sorting">状态</th>
                        <th class="text-center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="item">
                    <tr>
                        <td><input name="ids" value="${item.id}" type="checkbox"></td>
                        <td>
                            ${item.name}
                        </td>
                        <td>${item.city}</td>
                        <td>${item.address}</td>
                        <td>${item.representative}</td>
                        <td>${item.phone}</td>
                        <td>${item.industry}</td>
                        <td>${item.state ==0?'未审核':'已审核'}</td>
                        <td class="text-center">
                            <button type="button" class="btn bg-olive btn-xs" onclick='location.href="${ctx}/store/company?operation=toEdit&id=${item.id}"'>编辑</button>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- /.box-body -->

         <!-- .box-footer-->
        <%--  <form action="${ctx}/company/list.do" method="post">
         <div class="box-footer">
             <div class="pull-left">
                 <div class="form-group form-inline">
                     总共${page.totalPage} 页，共${page.total}条数据。 每页
                     <select class="form-control">
                         <option ${page.size==5?'selected':''}>5</option>
                         <option ${page.size==10?'selected':''}>10</option>
                         <option ${page.size==15?'selected':''}>25</option>
                         <option ${page.size==20?'selected':''}>20</option>
                     </select> 条
                </div>
            </div>

            <div class="box-tools pull-right">
                <ul class="pagination">
                    <li>
                        <a href="javascript:toPage('1')" aria-label="Previous">首页</a>
                    </li>
                    <li><a href="javascript:toPage('${page.pre}')">上一页</a></li>
                    <c:forEach begin="${page.beg}" end="${page.end}" var="index">
                        <li><a href="javascript:toPage('${index}')">${index}</a></li>
                    </c:forEach>
                    <li><a href="javascript:toPage('${page.next}')">下一页</a></li>
                    <li>
                        <a href="javascript:toPage('${page.totalPage}')" aria-label="Next">尾页</a>
                    </li>
                </ul>
            </div>
        </div>
        <script type="text/javascript">
            function toPage(pageNum){
                document.getElementById("page").value = pageNum;
                document.forms[0].submit();
            }
        </script>
        <input type="hidden" name="page" id="page" value="">
        </form>--%>

         <div class="box-footer">
             <jsp:include page="../../common/page.jsp">
                 <jsp:param value="${ctx}/store/company?operation=list" name="pageUrl"/>
             </jsp:include>
         </div>
        <!-- /.box-footer-->

    </div>
</section>
</div>
</body>

</html>
```

##### src/main/webapp/WEB-INF/pages/common/page.jsp

```java
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<%--<div class="pull-left">
    <div class="form-group form-inline">
        总共${page.totalPage} 页，共${page.total} 条数据。
    </div>
</div>

<div class="box-tools pull-right">
    <ul class="pagination" style="margin: 0px;">
        <li >
            <a href="javascript:goPage(1)" aria-label="Previous">首页</a>
        </li>
        <li><a href="javascript:goPage(${page.pre})">上一页</a></li>
        <c:forEach begin="${page.beg}" end="${page.end}" var="i">
            <li class="paginate_button ${page.page==i ? 'active':''}"><a href="javascript:goPage(${i})">${i}</a></li>
        </c:forEach>
        <li><a href="javascript:goPage(${page.next})">下一页</a></li>
        <li>
            <a href="javascript:goPage(${page.totalPage})" aria-label="Next">尾页</a>
        </li>
    </ul>
</div>
<form id="pageForm" action="${param.pageUrl}" method="post">
    <input type="hidden" name="page" id="pageNum">
</form>
<script>
    function goPage(page) {
        document.getElementById("pageNum").value = page
        document.getElementById("pageForm").submit()
    }
</script>
</body>--%>


<body>
<div class="pull-left">
    <div class="form-group form-inline">
        总共${page.pages} 页，共${page.total} 条数据。
    </div>
</div>

<div class="box-tools pull-right">
    <ul class="pagination" style="margin: 0px;">
        <li >
            <a href="javascript:goPage(1)" aria-label="Previous">首页</a>
        </li>
        <li><a href="javascript:goPage(${page.prePage})">上一页</a></li>
        <c:forEach begin="${page.navigateFirstPage}" end="${page.navigateLastPage}" var="i">
            <li class="paginate_button ${page.pageNum==i ? 'active':''}"><a href="javascript:goPage(${i})">${i}</a></li>
        </c:forEach>
        <li><a href="javascript:goPage(${page.nextPage})">下一页</a></li>
        <li>
            <a href="javascript:goPage(${page.pages})" aria-label="Next">尾页</a>
        </li>
    </ul>
</div>
<form id="pageForm" action="${param.pageUrl}" method="post">
    <input type="hidden" name="page" id="pageNum">
</form>
<script>
    function goPage(page) {
        document.getElementById("pageNum").value = page
        document.getElementById("pageForm").submit()
    }
</script>
</body>
</html>
```

> 在home里的侧边菜单位置要记得更改和对应文件位置

#### 表现层Servlet代码实现

##### com/colincora/web/controller/company/CompanyServlet.java

```java
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

```

> 关于pages页面：我们需要把`src/main/webapp/pages`里的`common`和`store`文件夹复制到WEB-INF，为了安全起见
>
> 在进行`private void save`编写的时候要注意导入BeanUtil类获取封装对象
>
> #### src/main/java/com/colincora/utils/BeanUtil.java
>
> ```java
> package com.colincora.utils;
> 
> import javax.servlet.http.HttpServletRequest;
> 
> import org.apache.commons.beanutils.BeanUtils;
> import org.apache.commons.beanutils.ConvertUtils;
> import org.apache.commons.beanutils.converters.DateConverter;
> import org.apache.commons.fileupload.FileItem;
> import org.apache.commons.fileupload.servlet.ServletFileUpload;
> 
> import java.beans.PropertyDescriptor;
> import java.io.File;
> import java.lang.reflect.Method;
> import java.util.Date;
> import java.util.List;
> 
> /**
>  * 填充表单数据到javabean的工具类
>  * @author zhy
>  *
>  */
> public class BeanUtil {
> 	/**
> 	 * 封装表单中的数据到javabean中
> 	 * @param request	表单中的数据
> 	 * @param clazz		封装到哪个javabean
> 	 * @return	封装好的javabean对象
> 	 * 使用的是泛型。泛型必须先声明再使用。声明必须在返回值之前
> 	 * T指的就是泛型，它可以是任意字符，只是作为一个占位符。
> 	 * 声明时用什么字符，使用时就得用什么
> 	 */
> 	public static <T> T fillBean(HttpServletRequest request,Class<T> clazz){
> 		//1.定义一个T类型的javabean
> 		T bean = null;
> 		try{
> 			//2.实例化bean对象
> 			bean = clazz.newInstance();
> 			//3.使用BeanUtils的方法进行封装
> 			BeanUtils.populate(bean, request.getParameterMap());
> 			//4.返回
> 			return bean;
> 		}catch(Exception e){
> 			throw new RuntimeException(e);
> 		}
> 	}
> 
> 
> 
> 	/**
> 	 * 封装表单中的数据到javabean中,带有日期格式数据
> 	 * @param request	表单中的数据
> 	 * @param clazz		封装到哪个javabean
> 	 * @return	封装好的javabean对象
> 	 * 使用的是泛型。泛型必须先声明再使用。声明必须在返回值之前
> 	 * T指的就是泛型，它可以是任意字符，只是作为一个占位符。
> 	 * 声明时用什么字符，使用时就得用什么
> 	 */
> 	public static <T> T fillBean(HttpServletRequest request,Class<T> clazz,String datePattern){
> 		//1.定义一个T类型的javabean
> 		T bean = null;
> 		try{
> 			//2.实例化bean对象
> 			bean = clazz.newInstance();
> 			//3.创建日期转换器对象
> 			DateConverter converter = new DateConverter();
> 			converter.setPattern(datePattern);
> 			//4.设置转换器
> 			ConvertUtils.register(converter, Date .class);
> 			//5.使用BeanUtils的方法进行封装
> 			BeanUtils.populate(bean, request.getParameterMap());
> 			//6.返回
> 			return bean;
> 		}catch(Exception e){
> 			throw new RuntimeException(e);
> 		}
> 	}
> 
> 	/**
> 	 * 文件上传的表单填充
> 	 * @param items	文件上传的表单项
> 	 * @param clazz	要封装的实体类字节码
> 	 * @param <T>	泛型
> 	 * @return		返回封装好的对象
> 	 */
> 	public static <T> T fillBean(List<FileItem> items,Class<T> clazz){
> 		//1.定义一个T类型的javabean
> 		T bean = null;
> 		try{
> 			//2.实例化Bean
> 			bean = clazz.newInstance();
> 			//3.遍历文件项集合
> 			for(FileItem item : items){
> 				//4.判断是不是文件
> 				if(item.isFormField()){//表单字段，不是文件
> 					//5.取出表单中的name属性取值
> 					String fieldName = item.getFieldName();
> 					//6.使用UTF-8字符集取出表单数据
> 					String fieldValue = item.getString("UTF-8");
> 					//7.创建属性描述器对象
> 					PropertyDescriptor pd = new PropertyDescriptor(fieldName,clazz);
> 					//8.获取写方法(setXXX方法）
> 					Method method = pd.getWriteMethod();
> 					//9.把数据填充到bean中
> 					method.invoke(bean,fieldValue);
> 				}
> 			}
> 			//10.返回
> 			return bean;
> 		}catch(Exception e){
> 			throw new RuntimeException(e);
> 		}
> 	}
> }
> ```

##### src/main/webapp/WEB-INF/pages/store/Company/add.jsp

> 添加功能的实现

```java
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../base.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>CoolSTS管理系统</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- 页面meta /-->
</head>
<body>
<div id="frameContent">
    <!-- 内容头部 -->
    <section class="content-header" class="content-wrapper" style="margin-left:0px;">
        <h1>
            企业管理
            <small>企业表单</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="all-order-manage-list.html">企业管理</a></li>
            <li class="active">企业表单</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!--添加内容信息-->
        <div class="panel panel-default">
            <div class="panel-heading">企业信息</div>
            <form id="editForm" action="${ctx}/store/company?operation=save" method="post">
                <input type="hidden" name="id" value="${company.id}">
                <div class="row data-type" style="margin: 0px">
                    <div class="col-md-2 title">企业名称</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="企业名称" name="name" value="${company.name}">
                    </div>

                    <div class="col-md-2 title">营业执照</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="营业执照" name="licenseId" value="${company.licenseId}">
                    </div>

                    <div class="col-md-2 title">所在城市</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="所在地" name="city" value="${company.city}">
                    </div>

                    <div class="col-md-2 title">企业地址</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="企业地址" name="address" value="${company.address}">
                    </div>

                    <div class="col-md-2 title">法人代表</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="法人代表" name="representative" value="${company.representative}">
                    </div>

                    <div class="col-md-2 title">联系电话</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="联系电话" name="phone" value="${company.phone}">
                    </div>

                    <div class="col-md-2 title">公司规模</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="公司规模" name="companySize" value="${company.companySize}">
                    </div>

                    <div class="col-md-2 title">所属行业</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="所属行业" name="industry" value="${company.industry}">
                    </div>
                    <div class="col-md-2 title">状态</div>
                    <div class="col-md-4 data">
                        <select class="form-control select2" name="state" style="width: 100%;">
                            <option value="0" ${company.state==0 ? 'selected':''}>未审核</option>
                            <option value="1" ${company.state==1 ? 'selected':''}>已审核</option>
                        </select>
                        <input type="text" class="form-control" placeholder="状态" name="state" value="${company.state}">
                    </div>


                    <div class="col-md-2 title">到期时间</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" placeholder="到期时间"  name="expirationDate" class="form-control pull-right"
                                   value="<fmt:formatDate value="${company.expirationDate}" pattern="yyyy-MM-dd"/>" id="expirationDate">
                        </div>
                    </div>

                    <div class="col-md-2 title rowHeight2x">备注</div>
                    <div class="col-md-10 data rowHeight2x">
                        <textarea class="form-control" rows="3" name="remarks">${company.remarks}</textarea>
                    </div>
                </div>
            </form>
        </div>
        <!--添加内容信息/-->

        <!--工具栏-->
        <div class="box-tools text-center">
            <button type="button" onclick='document.getElementById("editForm").submit()' class="btn bg-maroon">保存</button>
            <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
        </div>
        <!--工具栏/-->

    </section>
    <!-- 正文区域 /-->

</div>
<!-- 内容区域 /-->
</body>
<script src="${ctx}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${ctx}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<link rel="stylesheet" href="${ctx}/css/style.css">
<script>
    $('#expirationDate').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd'
    });
</script>

</html>
```

