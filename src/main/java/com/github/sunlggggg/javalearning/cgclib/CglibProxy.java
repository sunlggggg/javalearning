package com.github.sunlggggg.javalearning.cgclib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sunligang
 * @date 2019/08/17
 */

interface Work {
    /**
     * 干活
     *
     * @param task
     * @return 结果
     */
    String doThis(String task);
}

class DefaultWork implements Work {
    @Override
    public String doThis(String task) {
        System.out.println("coding ..." + task);
        return "finished";
    }
}

public class CglibProxy implements MethodInterceptor {
    private Object target;

    public Object getInstance(final Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("open ide");
        String ret = (String) methodProxy.invokeSuper(o, args);
        System.out.println("commit that");
        return ret;
    }


    public static void main(String[] args) {
        DefaultWork work = new DefaultWork();
        CglibProxy cglibProxy = new CglibProxy();
        DefaultWork buyHouseCglibProxy = (DefaultWork) cglibProxy.getInstance(work);
        System.out.println(buyHouseCglibProxy.doThis("java"));
    }
}
