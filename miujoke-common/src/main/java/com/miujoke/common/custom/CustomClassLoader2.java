package com.miujoke.common.custom;

/**
 * @author miujoke
 * @date 2023/6/14 23:52
 */
public class CustomClassLoader2 extends ClassLoader{

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("com.miujoke.common.bean.MyClass")){
            // 使用CustomClassLoader2 加载com.miujoke.common.bean.MyClass
            return findClass(name);
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 实现类加载器的逻辑，此处省略具体代码
        return super.findClass(name);
    }
}
