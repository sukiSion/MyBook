package minori.eden.sion.mybook.util

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * @author Sion
 * @date 2023/9/8 16:30
 * @description
 * @version 1.0.0
 **/
object RxjavaUtil {

    fun <T : Any> transform(): ObservableTransformer<T , T> {
        return ObservableTransformer{
            upstream ->
            upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}