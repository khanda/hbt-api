package com.hbt.gd.helper;

import com.hbt.gd.constant.MyConstant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateString {
    public static boolean isValidSearchQuery(String query) {
        Pattern pattern = Pattern.compile(MyConstant.validationSearchQuery);
        Matcher matcher = pattern.matcher(query);
        while (matcher.find()) {
            return true;
        }
        return false;
    }
}
