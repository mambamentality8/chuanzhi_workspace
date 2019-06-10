package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class StringToDateConverter implements Converter<String,Date> {

    private DateFormat format;

    public void setPattern(String pattern){
        format = new SimpleDateFormat(pattern);
    }
    /**
     * 类型转换
     * @param source
     * @return
     */
    @Override
    public Date convert(String source) {
        try{
            if(StringUtils.isEmpty(source)){
                throw new NullPointerException("没有数据");
            }


            return format.parse(source);
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }
}
