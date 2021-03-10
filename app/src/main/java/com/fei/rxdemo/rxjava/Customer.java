package com.fei.rxdemo.rxjava;

/**
 * @ClassName: Customer
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/10 15:42
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/10 15:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface Customer<T> {

    void onNext(T t);

}
