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
