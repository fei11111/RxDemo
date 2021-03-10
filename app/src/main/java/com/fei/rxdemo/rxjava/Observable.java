package com.fei.rxdemo.rxjava;

/**
 * @ClassName: Observable
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/10 14:17
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/10 14:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class Observable<T> implements ObservableSource<T> {

    public static <T> Observable<T> just(T value) {
        return onAssembly(new ObservableJust(value));
    }

    private static <T> Observable<T> onAssembly(Observable<T> source) {
        // 留出来了
        return source;
    }

    @Override
    public void subscribe(Observer<T> observer) {
        subscribeActual(observer);
    }

    @Override
    public void subscribe(final Customer<T> customer) {
        subscribe(new Observer<T>() {
            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(T t) {
                customer.onNext(t);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public <R> Observable<R> map(Function<T, R> function) {
        return onAssembly(new ObservableMap(this,function));
    }

    protected abstract void subscribeActual(Observer<T> observer);
}
