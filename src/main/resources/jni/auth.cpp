#include <jni.h>
#include <stdio.h>
#include "cn_just_do_springboot_bll_UserService.h"

JNIEXPORT void JNICALL Java_cn_just_1do_springboot_bll_UserService_auth(JNIEnv *jniEnv, jobject j){
  	printf("HelloWorld from JAVA JNI!");
  	FILE *fp = NULL;

    fp = fopen("E:\\auth.txt", "w+");
    fprintf(fp, "This is testing for fprintf...\n");
    fputs("This is testing for fputs...\n", fp);
    fclose(fp);
  }

JNIEXPORT void JNICALL Java_cn_just_1do_springboot_bll_UserService_auth2
  (JNIEnv *env, jobject j, jstring s){

    const char *str = (env)->GetStringUTFChars(s, 0);

  	FILE *fp = NULL;

    fp = fopen("E:\\auth2.txt", "w+");
    fputs(str, fp);
    fclose(fp);

    (env)->ReleaseStringUTFChars(s, str);
  }

  JNIEXPORT void JNICALL Java_cn_just_1do_springboot_bll_UserService_auth3
  (JNIEnv *env, jobject obj, jobjectArray objArray){

  	//在java中，String[]类型是对象，所以对应C++中的数组为jobjectArray
	//把jobjectArray数组中的值取出来

//	int size=(env)->GetArrayLength(objArray);//得到数组的长度值
//	int i=0;
//	for(i=0;i<size;i++){
//		jstring obja=(jstring)(env) -> GetObjectArrayElement(objArray,i);
//		const char* chars=(env)->GetStringUTFChars(obja,NULL);//将jstring类型转换成char类型输出
//
//		FILE *fp = NULL;
//
//	    fp = fopen("E:\\auth3.txt", "w+");
//	    fputs(chars, fp);
//	    fclose(fp);
//	}
//    (*env)->ReleaseStringUTFChars(env, obj, objArray);
  }