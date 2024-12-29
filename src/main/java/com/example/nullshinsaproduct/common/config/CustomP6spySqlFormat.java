package com.example.nullshinsaproduct.common.config;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.hibernate.engine.jdbc.internal.FormatStyle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class CustomP6spySqlFormat implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        sql = formatSql(category, sql);
        Date currentDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yy.MM.dd HH:mm:ss");

        return format.format(currentDate) + " | " + "OperationTime : " + elapsed + "ms" + sql;
    }

    private String formatSql(String category, String sql) {
        if (sql == null || sql.trim().equals(""))
            return sql;
        if (Category.STATEMENT.getName().equals(category)) {
            String tmpsql = sql.trim().toLowerCase(Locale.ROOT);
            if (tmpsql.startsWith("create") || tmpsql.startsWith("alter") || tmpsql.startsWith("comment")) {
                sql = FormatStyle.DDL.getFormatter().format(sql);
            } else {
                sql = FormatStyle.BASIC.getFormatter().format(sql);
            }
            sql = "\n쿼리 파라미터 포함된 P6Spy 쿼리 : " + sql;
        }

        return sql;
    }
}
