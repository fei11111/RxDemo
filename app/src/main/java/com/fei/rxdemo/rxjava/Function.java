package com.fei.rxdemo.rxjava;

/**
 * @ClassName: Function
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/10 14:51
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/10 14:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface Function<T, R> {

    R apply(T t);

}
