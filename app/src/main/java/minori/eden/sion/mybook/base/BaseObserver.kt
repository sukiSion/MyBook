package minori.eden.sion.mybook.base

import android.util.Log
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import minori.eden.sion.mybook.BuildConfig


/**
 * @author Sion
 * @date 2023/9/8 16:29
 * @description
 * @version 1.0.0
 **/
abstract class BaseObserver<T:Any>: Observer<T> {

    abstract fun onSuccess(t: T)
    open fun onFail(e: Throwable){
        if(BuildConfig.DEBUG){
            Log.e("Sion" , "错误原因：${e.cause}")
            Log.e("Sion" , "错误信息：${e.message}")
        }
    }
    open fun onStart(){
        if(BuildConfig.DEBUG){
            Log.e("Sion" , "开始进行网络请求")
        }
    }

    override fun onSubscribe(d: Disposable) {
        onStart()
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        onFail(e)
    }

    override fun onComplete() {
    }
}