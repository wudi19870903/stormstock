/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class stormstock_ori_capi_CATHSAccount */

#ifndef _Included_stormstock_ori_capi_CATHSAccount
#define _Included_stormstock_ori_capi_CATHSAccount
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     stormstock_ori_capi_CATHSAccount
 * Method:    initialize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_stormstock_ori_capi_CATHSAccount_initialize
  (JNIEnv *, jclass);

/*
 * Class:     stormstock_ori_capi_CATHSAccount
 * Method:    getAvailableMoney
 * Signature: ()Lstormstock/ori/capi/CATHSAccount/ResultAvailableMoney;
 */
JNIEXPORT jobject JNICALL Java_stormstock_ori_capi_CATHSAccount_getAvailableMoney
  (JNIEnv *, jclass);

/*
 * Class:     stormstock_ori_capi_CATHSAccount
 * Method:    getTotalAssets
 * Signature: ()Lstormstock/ori/capi/CATHSAccount/ResultTotalAssets;
 */
JNIEXPORT jobject JNICALL Java_stormstock_ori_capi_CATHSAccount_getTotalAssets
  (JNIEnv *, jclass);

/*
 * Class:     stormstock_ori_capi_CATHSAccount
 * Method:    getAllStockMarketValue
 * Signature: ()Lstormstock/ori/capi/CATHSAccount/ResultAllStockMarketValue;
 */
JNIEXPORT jobject JNICALL Java_stormstock_ori_capi_CATHSAccount_getAllStockMarketValue
  (JNIEnv *, jclass);

/*
 * Class:     stormstock_ori_capi_CATHSAccount
 * Method:    getHoldStockList
 * Signature: ()Lstormstock/ori/capi/CATHSAccount/ResultHoldStockList;
 */
JNIEXPORT jobject JNICALL Java_stormstock_ori_capi_CATHSAccount_getHoldStockList
  (JNIEnv *, jclass);

/*
 * Class:     stormstock_ori_capi_CATHSAccount
 * Method:    getCommissionOrderList
 * Signature: ()Lstormstock/ori/capi/CATHSAccount/ResultCommissionOrderList;
 */
JNIEXPORT jobject JNICALL Java_stormstock_ori_capi_CATHSAccount_getCommissionOrderList
  (JNIEnv *, jclass);

/*
 * Class:     stormstock_ori_capi_CATHSAccount
 * Method:    getDealOrderList
 * Signature: ()Lstormstock/ori/capi/CATHSAccount/ResultDealOrderList;
 */
JNIEXPORT jobject JNICALL Java_stormstock_ori_capi_CATHSAccount_getDealOrderList
  (JNIEnv *, jclass);

/*
 * Class:     stormstock_ori_capi_CATHSAccount
 * Method:    buyStock
 * Signature: (Ljava/lang/String;IF)I
 */
JNIEXPORT jint JNICALL Java_stormstock_ori_capi_CATHSAccount_buyStock
  (JNIEnv *, jclass, jstring, jint, jfloat);

/*
 * Class:     stormstock_ori_capi_CATHSAccount
 * Method:    sellStock
 * Signature: (Ljava/lang/String;IF)I
 */
JNIEXPORT jint JNICALL Java_stormstock_ori_capi_CATHSAccount_sellStock
  (JNIEnv *, jclass, jstring, jint, jfloat);

#ifdef __cplusplus
}
#endif
#endif
