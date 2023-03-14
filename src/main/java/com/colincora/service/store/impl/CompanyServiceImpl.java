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
