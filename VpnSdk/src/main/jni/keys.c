#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_beingcoderz_vpnsdk_VpnKey_freeURL(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, "aHR0cHM6Ly9hcHAudnBua2V5Lm9ubGluZS9pbmNsdWRlcy9hcGkucGhwP2ZyZWVTZXJ2ZXJzJnBhY2thZ2VfbmFtZT0=");
}

JNIEXPORT jstring JNICALL
Java_com_beingcoderz_vpnsdk_VpnKey_proURL(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, "aHR0cHM6Ly9hcHAudnBua2V5Lm9ubGluZS9pbmNsdWRlcy9hcGkucGhwP3Byb1NlcnZlcnMmcGFja2FnZV9uYW1lPQ==");
}

JNIEXPORT jstring JNICALL
Java_com_beingcoderz_vpnsdk_VpnKey_apiURL(JNIEnv *env, jobject instance) {
 return (*env)->NewStringUTF(env, "JmFwaV9rZXk9");
}