package minori.eden.sion.mybook.util

import android.util.Log
import minori.eden.sion.mybook.BuildConfig
import org.json.JSONException
import org.json.JSONObject

/**
 * @author Sion
 * @date 2023/9/8 18:10
 * @description
 * @version 1.0.0
 **/
object HandleResponseUtil {

    fun handleExchangeRateResult(result: String): String?{
        try {
            return JSONObject(result).getJSONArray("result").getJSONObject(0).getJSONObject("日元").getString("bankConversionPri")
        }catch (e: JSONException){
            if(BuildConfig.DEBUG){
                Log.e("Sion" , "${e.cause} : ${e.message}")
            }
        }
        return null
    }
}