package com.miujoke.common.bean;

import com.miujoke.common.custom.CustomClassLoader1;
import com.miujoke.common.custom.CustomClassLoader2;

/**
 * @author miujoke
 * @date 2023/6/14 23:57
 */
public class MyClass {
    public void doSomething() {
        System.out.println(" Hello from MyClass!");
    }

}

class MainClass {

    public static void main(String[] args) {
        // 创建自定义类加载器
        CustomClassLoader1 customClassLoader1 = new CustomClassLoader1();
        CustomClassLoader2 customClassLoader2 = new CustomClassLoader2();
        String className = "com.miujoke.common.bean.MyClass";
        String methodName = "doSomething";

        /*// 创建线程1，使用CustomClassLoader1 加载类
        Thread thread1 = new Thread(()->{
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            Thread.currentThread().setContextClassLoader(customClassLoader1);

            try {
                // 使用上下文加载器加载类
                Class<?> clazz = Class.forName("com.miujoke.common.bean.MyClass");
                Object instance = clazz.newInstance();

                // 调用方法
                clazz.getMethod("doSomething").invoke(instance);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                Thread.currentThread().setContextClassLoader(contextClassLoader);
            }
        });

        // 创建线程1，使用CustomClassLoader1 加载类
        Thread thread2 = new Thread(()->{
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            Thread.currentThread().setContextClassLoader(customClassLoader2);

            try {
                // 使用上下文加载器加载类
                Class<?> clazz = Class.forName("com.miujoke.common.bean.MyClass");
                Object instance = clazz.newInstance();

                // 调用方法
                clazz.getMethod("doSomething").invoke(instance);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                Thread.currentThread().setContextClassLoader(contextClassLoader);
            }
        });*/

        // 启动线程
        call(customClassLoader1, className, methodName).start();
        call(customClassLoader2, className, methodName).start();


    }

    /**
     * 创建线程1，使用CustomClassLoader1 加载类
     *
     * @param classLoader 自定义类加载器
     * @param className   要加载的类名称
     * @param methodName  要执行加载类的方法
     * @return
     */
    public static Thread call(ClassLoader classLoader, String className, String methodName) {
        return new Thread(() -> {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            Thread.currentThread().setContextClassLoader(classLoader);

            try {
                // 使用上下文加载器加载类
                Class<?> clazz = Class.forName(className);
                Object instance = clazz.newInstance();

                // 调用方法
                clazz.getMethod(methodName).invoke(instance);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Thread.currentThread().setContextClassLoader(contextClassLoader);
            }
        });
    }
}

