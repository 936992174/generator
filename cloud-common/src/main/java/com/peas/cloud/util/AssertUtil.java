package com.peas.cloud.util;

import com.peas.cloud.exception.AppException;
import com.peas.cloud.web.ResponseHeader;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * Created by 6212 on 2018/4/13.
 * author  shengzhipeng
 */
public abstract class AssertUtil {

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    private static final SpringValidatorAdapter VALIDATOR_ADAPTER = new SpringValidatorAdapter(VALIDATOR);

    private static BindingResult getConfiguration(Object param) {
        BindingResult errors = new BeanPropertyBindingResult(param, "configuration");
        return errors;
    }

    private static void valid(Object param) {
        BindingResult errors = getConfiguration(param);
        ValidationUtils.invokeValidator(VALIDATOR_ADAPTER, param, errors);
        if (!errors.hasErrors()) {
            return ; // 没有错误，直接返回
        }
        for (FieldError fieldError : errors.getFieldErrors()) {
            throw new AppException(fieldError.getDefaultMessage());
        }
    }

    public static void valid(ResponseHeader responseHeader, Object... objects) {
        for (Object object : objects) {
            if (ObjectUtils.isEmpty(object)) {
                throw new AppException(responseHeader);
            }
            // 如果不为空额外验证JSR-303's
            Validated validated = AnnotationUtils.findAnnotation(object.getClass(), Validated.class);
            if (ObjectUtils.isEmpty(validated)) {
                continue; // 如果没有验证注解，
            }
            valid(object);
        }
    }


    /**
     * 为真断言，不为真就抛出异常
     * @param expression  = false 抛出异常
     * @param responseHeader
     */
    public static void isTrue(boolean expression, ResponseHeader responseHeader)  {
        if (!expression) {
            throw new AppException(responseHeader);
        }
    }

    /**
     * 为空断言，不为空抛出异常
     * @param object
     * @param responseHeader
     */
    public static void isBlank(String object, ResponseHeader responseHeader) {
        if (StringUtil.isNotBlank(object)) {
            throw new AppException(responseHeader);
        }
    }


    /**
     * 不为空断言，为空抛出异常
     * @param object
     * @param responseHeader
     */
    public static void isNotBlank(String object, ResponseHeader responseHeader) {
        if (StringUtil.isBlank(object)) {
            throw new AppException(responseHeader);
        }
    }

    /**
     * 为空断言，不为空抛出异常
     * @param object
     * @param responseHeader
     */
    public static void isNull(Object object, ResponseHeader responseHeader) {
        if (Objects.nonNull(object)) {
            throw new AppException(responseHeader);
        }
    }

    /**
     * 不为空断言，为空抛出异常
     * @param object
     * @param responseHeader
     */
    public static void notNull(Object object, ResponseHeader responseHeader) {
        if (Objects.isNull(object)) {
            throw new AppException(responseHeader);
        }
    }

    /**
     * 数组不为空断言 为空抛出异常
     * @param array
     * @param responseHeader
     */
    public static void notEmpty(Object[] array, ResponseHeader responseHeader) {
        if (ObjectUtils.isEmpty(array)) {
            throw new AppException(responseHeader);
        }
    }

    /**
     * 数组元素不为空断言 为空抛出异常
     * @param array
     * @param responseHeader
     */
    public static void noNullElements(Object[] array, ResponseHeader responseHeader) {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    throw new AppException(responseHeader);
                }
            }
        }
    }

    /**
     * 集合不为空断言 为空抛出异常
     * @param collection
     * @param responseHeader
     */
    public static void notEmpty(Collection<?> collection, ResponseHeader responseHeader) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new AppException(responseHeader);
        }
    }

    /**
     * 集合为空断言 不为空抛出异常
     * @param collection
     * @param responseHeader
     */
    public static void isEmpty(Collection<?> collection, ResponseHeader responseHeader) {
        if (!CollectionUtils.isEmpty(collection)) {
            throw new AppException(responseHeader);
        }
    }

    /**
     * map不为空断言 为空抛出异常
     * @param map
     * @param responseHeader
     */
    public static void notEmpty(Map<?, ?> map, ResponseHeader responseHeader) {
        if (CollectionUtils.isEmpty(map)) {
            throw new AppException(responseHeader);
        }
    }

    /**
     * 比较匹配断言，equals 结果不为真抛出异常
     * @param a
     * @param b
     * @param responseHeader
     */
    public static void isEqualsTrue(Object a, Object b, ResponseHeader responseHeader) {
        if(Objects.nonNull(a)) {
            if(!a.equals(b)) {
                throw new AppException(responseHeader);
            }
        }
    }

    public static void isEqualsTrue(Object a, Object b, String message) {
        if(Objects.nonNull(a)) {
            if (!a.equals(b)) {
                throw new AppException(message);
            }
        }
    }

    /**
     * 断言都不为空，有一个为空直接抛出异常
     * @param responseHeader
     * @param objects
     */
    public static void isAllNotNull(ResponseHeader responseHeader,  Object... objects) {
        if(Objects.nonNull(objects)) {
            for (Object o : objects) {
                if(Objects.isNull(o)) {
                    throw new AppException(responseHeader);
                }
            }
        }
    }
}
