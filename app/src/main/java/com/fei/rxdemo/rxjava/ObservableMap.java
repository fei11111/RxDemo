package com.fei.rxdemo.rxjava;

import androidx.annotation.NonNull;

/**
 * @ClassName: ObservableMap
 * @Description: 描述
 * @Author: Fei
 * @CreateDate: 2021/3/10 14:54
 * @UpdateUser: Fei
 * @UpdateDate: 2021/3/10 14:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ObservableMap<T, R> extends Observable<R> {

    private final Observable source;
    private final Function function;

    public <R> ObservableMap(Observable<T> source, Function<T, R> function) {
        this.source = source;
        this.function = function;
    }


    @Override
    protected void subscribeActual(Observer<R> observer) {
        //source 上游的对象
        //observer下游给我们封装好的observer对象
        //每次都是调用上游的对象，并将observer包裹一层
        source.subscribe(new ObserverMap(observer,function));
    }

   public class ObserverMap<T,R> implements Observer<T>{


       private Observer<R> observer;
       private Function<T,R> function;

       public ObserverMap(Observer<R> observer, Function<T,R> function) {

           this.observer = observer;
           this.function = function;
       }

       @Override
       public void onSubscribe() {
           observer.onSubscribe();
       }

       @Override
       public void onNext(T t) {
           R r = function.apply(t);
           observer.onNext(r);
       }

       @Override
       public void onError(Throwable e) {
           observer.onError(e);
       }

       @Override
       public void onComplete() {

       }
   }


}
