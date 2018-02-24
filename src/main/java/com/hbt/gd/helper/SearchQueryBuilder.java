package com.hbt.gd.helper;

public class SearchQueryBuilder {
    public static String getEmployeeSearchQuery(String searchTerm) {
        if(searchTerm == null || searchTerm.isEmpty()){
            return "";
        }
        String[] properties = {"firstName", "midName", "lastName"};
        StringBuilder stringBuilder = new StringBuilder(String.join(":" + searchTerm + ",", properties));
        stringBuilder.append(':' + searchTerm);
        return stringBuilder.toString();
    }
}
