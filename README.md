# MyLogger
一个简单的超链接的日志打印log    

使用    
-------------------------    
Application初始化控制debug&release版打印：
```    
@Override
public void onCreate() {
    super.onCreate();
    Logger.init(BuildConfig.DEBUG);
}
```    
>     如果使用了依赖library方式：
>     主module对library module的依赖都是release依赖，所以library中BuildConfig.DEBUG始终为true，解决如下：
>     library.gradle：
>     android {
>         publishNonDefault true
>     }
>     app.gradle：
>     dependencies {
>         releaseCompile project(path: ':library', configuration: 'release')
>         debugCompile project(path: ':library', configuration: 'debug')
>     }
>     参考：http://www.jianshu.com/p/1907bffef0a3
>    

![image](https://github.com/XYScience/MyLogger/raw/master/screenshots/java_code.png)
![image](https://github.com/XYScience/MyLogger/raw/master/screenshots/result.png)    

引用  
-------------------------     
Step 1. Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			jcenter()
			maven { url "https://jitpack.io" }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.XYScience:MyLogger:0.2.1'
	}       
[![](https://jitpack.io/v/XYScience/MyLogger.svg)](https://jitpack.io/#XYScience/MyLogger)
