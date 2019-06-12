package cn.itcast.service.company;

import cn.itcast.domain.company.Company;

import java.util.List;

public interface CompanyService {
    //查询所有企业
    List<Company> findAll();
}
