package com.grateful.demo.frameWork.config;


import com.grateful.demo.content.enums.SexEnum;
import com.grateful.demo.content.enums.StatusEnum;
import com.grateful.demo.frameWork.utils.json.JacksonUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * DESC: mybatis自定义处理枚举类，可自定义如下两个方向的转换：
 * （1）保存数据时：java类型（枚举）---》数据库存储类型（int）
 * （2）从数据库取数据时：数据库存储类型（int）---》java类型（枚举）
 *
 * 本例中：定义数据库存储类型为int与枚举属性之间的转换
 * USER: C.HE
 * DATE: 2018/10/20 19:58
 * VERSION: 0.0.1
 * 参考资料：http://www.cnblogs.com/qnight/p/8997496.html
 */
@MappedTypes({SexEnum.class,StatusEnum.class})//需要将用到的枚举都填在这里面来
public class AutoEnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {
//@MappedTypes({BaseEnum.class})
//public class AutoEnumTypeHandler<E extends Enum<E> & BaseEnum> extends BaseTypeHandler<E> {

    /**
     * 枚举的class
     */
    private Class<E> type;

    /**
     * 枚举的每个子类枚
     */
    private E[] enums;

    /**
     * 一定要有默认的构造函数，不然抛出 not found method 异常
     */
    public AutoEnumTypeHandler() {}

    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     *
     * @param type 配置文件中设置的转换类
     */
    public AutoEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        this.enums = type.getEnumConstants();
//        System.out.println("this.enums==" + JacksonUtil.obj2json(this.enums));
        /**
         * this.enums==["Male","Female","Default"]
         * this.enums==["Success","Fail"]
         */
        if (this.enums == null) {
            throw new IllegalArgumentException(type.getSimpleName()
                    + " does not represent an enum type.");
        }
    }

    /**
     MyBatis提供了 org.apache.ibatis.type.BaseTypeHandler 类用于我们自己扩展类型转换器，上面的EnumTypeHandler和EnumOrdinalTypeHandler 也都实现了这个接口。

     继承 BaseTypeHandler<T> 一共需要实现4个方法：
     1. void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType)
     用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型；
     2. T getNullableResult(ResultSet rs, String columnName)
     用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型；
     3. T getNullableResult(ResultSet rs, int columnIndex)
     用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型；
     4. T getNullableResult(CallableStatement cs, int columnIndex)
     用定义调用存储过程后，如何把数据库类型转换为对应的Java类型。
     */

    /**
     * 自定义：把Java类型的参数转换为对应的数据库类型
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("setNonNullParameter");
        /*
         * BaseTypeHandler已经帮我们做了parameter的null判断
         * 数据库存储的是枚举的值，所以我们这里使用 value ， 如果需要存储 name，可以自定义修改
         */
        if (jdbcType == null) {
            ps.setString(i, Objects.toString(parameter.ordinal()));
        } else {
            ps.setObject(i, parameter.ordinal(), jdbcType.TYPE_CODE);
        }
//        System.out.println("parameter1==" + JacksonUtil.obj2json(parameter));
        //parameter1=="Default"
    }

    //自定义：通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型
    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("getNullableResult1");
        String i = rs.getString(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return locateEnumStatus(i);
        }
    }

    //自定义：通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型；
    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("getNullableResult2");
        String i = rs.getString(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return locateEnumStatus(i);
        }
    }

    //自定义：用定义调用存储过程后，如何把数据库类型转换为对应的Java类型
    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("getNullableResult3");
        String i = cs.getString(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return locateEnumStatus(i);
        }
    }

    /**
     * 枚举类型转换，由于构造函数获取了枚举的子类 enums，让遍历更加高效快捷，
     * <p>
     * 我将取出来的值 全部转换成字符串 进行比较，
     *
     * @param value 数据库中存储的自定义value属性
     * @return value 对应的枚举类
     */
    private E locateEnumStatus(String value) {
        for (E e : enums) {
            if (Objects.toString(e.ordinal()).equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + value + ",请核对"
                + type.getSimpleName());
    }
}
