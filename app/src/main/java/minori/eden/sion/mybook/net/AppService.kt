package minori.eden.sion.mybook.net

import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Sion
 * @date 2023/9/5 14:15
 * @description
 * @version 1.0.0
 **/
interface AppService {

    @GET(AppUrl.EXCHANGE_RATE_URL)
    fun getExchangeRate(
        // 	两种格式(0或者1,默认为1)
        @Query("type") type: Int = 1,
        // 	(1:招商银行,2:建设银行,3:中国银行,4:交通银行,5:农业银行,默认为:3:中国银行)
        @Query("bank") bank: Int = 3,
        @Query("key") key: String
    ): Observable<ResponseBody>
}