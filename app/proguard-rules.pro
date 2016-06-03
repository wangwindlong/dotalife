# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /home/wangyl/work/tools/android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /opt/android-sdk-linux/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

#-dontwarn android.support.v4.**
-dontwarn okio.*
-dontwarn com.baidu.**
-dontwarn com.google.**

-keep class cn.jpush.** { *; }
#-keep class com.google.gson.jpush.** { *; }
-keep class com.google.gson.** {*;}
-keep class com.baidu.** { *; }
-keep class vi.com.gdi.bgl.android.**{*;}
-keep class com.google.protobuf.** {*;}
-keep class de.greenrobot.** {*;}
-keepclassmembers class ** {
	public <fields>;
    public void onEvent*(**);
}
#-keep class okhttp3.** { *;}

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
#-keep class com.yxg.worker.model.** { *; }
-keep class com.yxg.worker.** { *; }
-keep class com.yxg.worker.adapter.** { *; }

##---------------End: proguard configuration for Gson  ----------


