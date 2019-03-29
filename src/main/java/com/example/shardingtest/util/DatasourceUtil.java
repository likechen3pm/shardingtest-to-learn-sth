package com.example.shardingtest.util;



public class DatasourceUtil {

    private static Integer defaultDatasourceId = 0;

    private static ThreadLocal<Integer> datasourceId = new ThreadLocal<>();
    static {datasourceId.set(defaultDatasourceId);}

    public static void changeDatasource(Integer value) {
        datasourceId.set(value);
    }

    public static Integer getDatasource(){
        return datasourceId.get();
    }

}
