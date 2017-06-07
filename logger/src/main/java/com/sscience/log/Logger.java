package com.sscience.log;

import android.util.Log;

import java.text.SimpleDateFormat;

/**
 * @author 幸运Science-陈土燊
 * @description 显示超链接、养眼log
 * @email chentushen.science@gmail.com,274240671@qq.com
 * @data 2016/4/20
 */
public class Logger {
    public static boolean IS_DEBUG = true;
    public static String DEFAULT_TAG = ">>>>>";

    public void init(boolean isDebug) {
        IS_DEBUG = isDebug;
    }

    private static void takeLogE(String tag, String msg) {
        Log.e(tag, msg);
    }

    private static void takeLogD(String tag, String msg) {
        Log.d(tag, msg);
    }

    private static void takeLogI(String tag, String msg) {
        Log.i(tag, msg);
    }

    private static void takeLogV(String tag, String msg) {
        Log.v(tag, msg);
    }

    private static void takeLogW(String tag, String msg) {
        Log.w(tag, msg);
    }

    private static String lastMsg(Object msg) {
        return ("".equals(msg) ? "" : ": " + msg.toString());
    }

    /**
     * 打印内容：">>>>>: method(xxx.java:line)"
     *
     */
    public static void e() {
        if (IS_DEBUG) {
            takeLogE(DEFAULT_TAG, getMethodAndLink() + lastMsg(""));
        }
    }

    /**
     * 打印内容：">>>>>: method(xxx.java:line): msg"
     *
     * @param msg 信息
     */
    public static void e(Object msg) {
        if (IS_DEBUG) {
            takeLogE(DEFAULT_TAG, getMethodAndLink() + lastMsg(msg));
        }
    }

    /**
     * 打印内容："tag: method(xxx.java:line): msg"
     *
     * @param msg 信息
     */
    public static void e(Object tag, Object msg) {
        if (IS_DEBUG) {
            takeLogE(String.valueOf(tag), getMethodAndLink() + lastMsg(msg));
        }
    }

    public static void d(Object msg) {
        if (IS_DEBUG) {
            takeLogD(DEFAULT_TAG, getMethodAndLink() + lastMsg(msg));
        }
    }

    public static void d(Object tag, Object msg) {
        if (IS_DEBUG) {
            takeLogD(String.valueOf(tag), getMethodAndLink() + lastMsg(msg));
        }
    }

    public static void i(Object msg) {
        if (IS_DEBUG) {
            takeLogI(DEFAULT_TAG, getMethodAndLink() + lastMsg(msg));
        }
    }

    public static void i(Object tag, Object msg) {
        if (IS_DEBUG) {
            takeLogI(String.valueOf(tag), getMethodAndLink() + lastMsg(msg));
        }
    }

    public static void v(Object msg) {
        if (IS_DEBUG) {
            takeLogV(DEFAULT_TAG, getMethodAndLink() + lastMsg(msg));
        }
    }

    public static void v(Object tag, Object msg) {
        if (IS_DEBUG) {
            takeLogV(String.valueOf(tag), getMethodAndLink() + lastMsg(msg));
        }
    }

    public static void w(Object msg) {
        if (IS_DEBUG) {
            takeLogW(DEFAULT_TAG, getMethodAndLink() + lastMsg(msg));
        }
    }

    public static void w(Object tag, Object msg) {
        if (IS_DEBUG) {
            takeLogW(String.valueOf(tag), getMethodAndLink() + lastMsg(msg));
        }
    }

    /**
     * 打印方法的类名
     *
     * @return 类名前缀
     */
    public static String getClassName() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[2];
        String className = traceElement.getFileName();
        //去除文件名中的后缀
        if (className.contains(".java")) {
            className = className.substring(0, className.length() - 5);
        }
        return className;
    }

    /**
     * 打印的方法+类名+所在行数(显示超链)
     */
    private static String getMethodAndLink() {
        String result = "";
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[2];
        result += traceElement.getMethodName();
        result += "(" + traceElement.getFileName();
        result += ":" + traceElement.getLineNumber() + ")";
        return result;
    }

    /**
     * 打印分割线,主要用于程序启动或销毁时在log中做标记
     *
     */
    public static void line() {
        if (IS_DEBUG) {
            takeLogE("---====================================---\n" +
                    "\t我是一个小小小小的分割线-" + getCurrentTime() +
                    "\n---====================================---", null);
        }
    }

    public static void line(String msg) {
        if (IS_DEBUG) {
            takeLogE("---====================================---\n" +
                    "\t我是" + msg + "的分割线-" + getCurrentTime() +
                    "\n---====================================---", null);
        }
    }

    public static String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(System.currentTimeMillis());
    }
}
