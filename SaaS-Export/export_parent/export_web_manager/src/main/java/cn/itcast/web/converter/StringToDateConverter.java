package cn.itcast.web.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String source) {
        Date result = null;
        try {
            result = new SimpleDateFormat("yyyy-MM-dd").parse(source);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
