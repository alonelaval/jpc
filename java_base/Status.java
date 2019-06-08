package com.okycz.panasonic.base;

/***
 *
 * @author huawei
 * @create 2018-07-07
 **/
public enum Status implements IEnum {
    ENABLED(0,"正常"),
    DISABLED(1,"禁用"),
    DELETE(2,"删除");

    private final int value;
    private final String desc;

    @Override
    public int value() {
        return value;
    }

    @Override
    public String desc() {
        return this.desc;
    }

    Status(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "状态";
    }

    public static Status valueOf(Integer value) {

        if(Status.ENABLED.value() ==value) {
            return ENABLED;
        }
        else
        if(Status.DISABLED.value() ==value) {
            return DISABLED;
        }
        else{
            return DELETE;
        }
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }
}
