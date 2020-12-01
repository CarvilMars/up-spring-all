package com.up.jdbc.domain;

import org.springframework.util.StringUtils;

/**
 * 数据库驱动枚举类
 */
public enum DataBaseDriverEnum {

    UNKNOWN(null, null),
    MYSQL("MySQL", "com.mysql.cj.jdbc.Driver", "") {
        @Override
        public String getProductName() {
            return super.getProductName();
        }
    };
    private String productName;
    private String driverClassName;
    private String dataSourceName;

    DataBaseDriverEnum(String productName, String driverClassName) {
        this(productName, driverClassName, null);
    }

    DataBaseDriverEnum(String productName, String driverClassName, String dataSourceName) {
        this.productName = productName;
        this.driverClassName = driverClassName;
        this.dataSourceName = dataSourceName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (StringUtils.hasText(productName)) {
            this.productName = productName.toUpperCase();
        }
        this.productName = productName;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }
}
