package com.fei.rxdemo.rxjava;


/**
 * @ClassName: Observer
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/10 14:17
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/10 14:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface Observer<T> {

    void onSubscribe();

    void onNext(T t);

    void onError(Throwable e);

    void onComplete();

}
