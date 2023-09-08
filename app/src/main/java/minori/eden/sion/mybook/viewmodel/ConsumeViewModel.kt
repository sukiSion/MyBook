package minori.eden.sion.mybook.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import minori.eden.sion.mybook.base.BaseObserver
import minori.eden.sion.mybook.net.AppService
import minori.eden.sion.mybook.repo.ConsumeRepo
import minori.eden.sion.mybook.util.HandleResponseUtil
import minori.eden.sion.mybook.util.NativeManager
import minori.eden.sion.mybook.util.RxjavaUtil
import okhttp3.ResponseBody
import javax.inject.Inject

/**
 * @author Sion
 * @date 2023/9/8 10:14
 * @description
 * @version 1.0.0
 **/
@HiltViewModel
class ConsumeViewModel @Inject constructor(
    private val nativeManager: NativeManager,
    private val service: AppService,
    private val consumeRepo: ConsumeRepo,
    @ApplicationContext private val context: Context
): ViewModel() {

    fun getExchangeRate(
        onStart: () -> Unit,
        onResult: (String?) -> Unit
    ){
        service.getExchangeRate(
            key = nativeManager.getExchangeRateKey()
        ).compose(RxjavaUtil.transform())
            .subscribe(
                object : BaseObserver<ResponseBody>(){

                    override fun onStart() {
                        super.onStart()
                        onStart()
                    }

                    override fun onSuccess(t: ResponseBody) {
                        onResult(HandleResponseUtil.handleExchangeRateResult(t.string()))
                    }
                }
            )
    }
}