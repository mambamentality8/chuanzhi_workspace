package myjdbctemplate;

import java.sql.ResultSet;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public interface MyRowMapper {

    Object mapRow(ResultSet rs) throws Exception;
}
