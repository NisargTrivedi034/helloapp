#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_exm_bhavin_hellodemo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}extern "C"
JNIEXPORT jstring JNICALL
Java_exm_bhavin_hellodemo_aes_Init_pKeyU(JNIEnv *env, jclass clazz, jstring mKey_) {
    const char *mKey = env->GetStringUTFChars(mKey_, NULL);
    std::string hello = mKey + std::string("pubgspecialist");
    return env->NewStringUTF(hello.c_str());
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_helloapp_security_Crypto_key(JNIEnv *env, jclass clazz) {
    return env->NewStringUTF("4Uo0BLN+r/i74ysX93/x5g/8NU4F7Wq6M8yLZ1P7u6Y=]x0SKrz/eAp2dsU7cb1xrng==]xyXZQ0aIpSt+govSzC6h4A=="); // debug
}
extern "C"
JNIEXPORT jstring JNICALL
Java_exm_bhavin_hellodemo_retrofit_Urls_BASE_1URL(JNIEnv *env, jclass clazz) {
    return env->NewStringUTF("x2d+x8tvsRb1GJcIZFm53LWsTqAvgF28KkcFDfEZHYY=]ziztaSZKaa0RytoOyK1XhA==]2CKAy5Nu3gSiDJBUi7GlHbKTNKGmLLXfbkdoU6HCLc0=");//debug
}
extern "C"
JNIEXPORT jstring JNICALL
Java_exm_bhavin_hellodemo_retrofit_Urls_Pinnig(JNIEnv *env, jclass clazz) {
    return env->NewStringUTF("api.dilhindustani.co");
}
//JNIEXPORT jstring JNICALL
//Java_exm_bhavin_hellodemo_retrofit_Urls_Pinnig(JNIEnv *env, jclass clazz) {
//    return env->NewStringUTF("http://ip-api.com/");
//}