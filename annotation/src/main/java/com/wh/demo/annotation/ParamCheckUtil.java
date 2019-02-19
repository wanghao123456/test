package com.wh.demo.annotation;

import java.lang.reflect.Field;

public class ParamCheckUtil {
    public static CheckResult check(Object object) {
        Class objectClass = object.getClass();
        CheckResult checkResult = new CheckResult();
        if (object == null) {
            checkResult.setPass(false);
            checkResult.addDesc("校验的对象为空；");
            return checkResult;
        }

        Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ParamCheck.class)) {
                ParamCheck paramCheck = field.getAnnotation(ParamCheck.class);
                field.setAccessible(true);
                if (paramCheck.type() == ParamType.BO) {
                    CheckResult checkResultBo = null;
                    try {
                        checkResultBo = check(field.get(object));
                    } catch (IllegalAccessException e) {
                        checkResult.addDesc(field.getName() + ": 字段获取失败；");
                    }
                    if (!checkResultBo.isPass()) {
                        checkResultBo.getDesc().insert(0, field.getName() + "->{");
                        checkResultBo.getDesc().append("}");
                        return checkResultBo;
                    }
                } else if (paramCheck.type() == ParamType.STRING) {
                    try {
                        String str = (String) field.get(object);
                        if (str == null) {
                            checkResult.setPass(false);
                            checkResult.addDesc(field.getName() + ": 字段为空；");
                        } else if (str.length() > paramCheck.length()) {
                            checkResult.setPass(false);
                            checkResult.addDesc(field.getName() + ": 字段超长；");
                        }
                    } catch (IllegalAccessException e) {
                        checkResult.addDesc(field.getName() + ": 字段获取失败；");
                    }
                } else if (paramCheck.type() == ParamType.INTEGER) {

                }
            }
        }
        return checkResult;
    }
}
