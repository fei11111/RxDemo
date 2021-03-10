package com.fei.rxdemo.rxjava;

/**
 * @ClassName: ObservableJust
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/10 14:34
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/10 14:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ObservableJust<T> extends Observable<T>{

    private T value;

    public ObservableJust(T value) {
        this.value = value;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        ScalarDisposable<T> tScalarDisposable = new ScalarDisposable<>(observer, value);
        tScalarDisposable.run();
    }

    private class ScalarDisposable<T>{
        private Observer observer;
        private T item;

        public ScalarDisposable(Observer<T> observer, T item) {
            this.observer = observer;
            this.item = item;
        }

        public void run(){
            observer.onSubscribe();
            try {
                observer.onNext(item);
                observer.onComplete();
            }catch (Exception e){
                observer.onError(e);
            }
        }
    }
}
