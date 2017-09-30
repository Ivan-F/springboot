#include "jni.h"
#include <stdio.h>
#include "cn_just_do_springboot_bll_UserService.h" 

JNIEXPORT void JNICALL Java_cn_just_1do_springboot_bll_UserService_auth(JNIEnv *jniEnv, jobject j){
  	printf("HelloWorld from JAVA JNI!");
  	 FILE *fp = NULL;

       fp = fopen("E:\\test.txt", "w+");
       fprintf(fp, "This is testing for fprintf...\n");
       fputs("This is testing for fputs...\n", fp);
       fclose(fp);
  }
