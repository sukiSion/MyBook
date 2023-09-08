// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("mybook");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("mybook")
//      }
//    }
#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_minori_eden_sion_mybook_util_NativeManager_getExchangeRateKey(JNIEnv *env, jobject thiz) {
    std::string key = "dbf7b648da08eaa208774bffb0c97fc9";
    return env ->NewStringUTF(key.c_str());
}