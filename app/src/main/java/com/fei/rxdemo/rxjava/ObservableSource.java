package com.fei.rxdemo.rxjava;

/**
 * @ClassName: ObservableSource
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/10 14:32
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/10 14:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ObservableSource<T> {

    void subscribe(Observer<T> observer);

    public void subscribe(Customer<T> customer);
}
