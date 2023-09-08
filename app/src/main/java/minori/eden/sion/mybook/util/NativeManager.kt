package minori.eden.sion.mybook.util

import javax.inject.Inject

/**
 * @author Sion
 * @date 2023/9/5 15:07
 * @description
 * @version 1.0.0
 **/
class NativeManager @Inject constructor(){

    init {
        System.loadLibrary("mybook")
    }


    external fun getExchangeRateKey(): String
}