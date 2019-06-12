package cn.itcast.dao.company;
import cn.itcast.domain.company.Company;

import java.util.List;

public interface CompanyDao {

    //查询全部企业
    List<Company> findAll();
}
