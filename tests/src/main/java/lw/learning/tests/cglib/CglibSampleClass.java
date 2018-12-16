package lw.learning.tests.cglib;

import net.sf.cglib.core.ReflectUtils;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author lw
 * @Date 2018-12-16 18:17:29
 **/

public class CglibSampleClass extends SampleClass implements Factory {
    private boolean cglibBound;
    public static Object cglibFactoryData;
    private static  ThreadLocal cglibThreadCallbacks;
    private static  Callback[] cglibStaticCallbacks;
    private MethodInterceptor methodInterceptor;
    private static Object cglibCallbackFilter;
    private static  Method cglibTestMethod;
    private static  MethodProxy cglibTestProxy;
    private static  Object[] cglibEmptyargs;
    private static  Method cglibEqualsMethod;
    private static  MethodProxy cglibEqualsProxy;
    private static  Method cglibTostringMethod;
    private static  MethodProxy cglibTostringProxy;
    private static  Method cglibHashcodeMethod;
    private static  MethodProxy cglibHashcodeProxy;
    private static  Method cglibCloneMethod;
    private static  MethodProxy cglibCloneProxy;
    public CglibSampleClass() {
        cglibBindCallbacks(this);
    }
    static {
        cglibStatichook1();
    }
    static void cglibStatichook1() {
        cglibThreadCallbacks = new ThreadLocal();
        cglibEmptyargs = new Object[0];
        Class var0 = null;
        try {
            var0 = Class.forName("lw.learning.tests.cglib.CglibSampleClass");

            Class var1;
            cglibTestMethod = ReflectUtils.findMethods(new String[]{"test", "()V"}, (var1 = Class.forName("lw.learning.tests.cglib.SampleClass")).getDeclaredMethods())[0];
            cglibTestProxy = MethodProxy.create(var1, var0, "()V", "test", "cglibTest");
            Method[] var10000 = ReflectUtils.findMethods(new String[]{"equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "clone", "()Ljava/lang/Object;"}, (var1 = Class.forName("java.lang.Object")).getDeclaredMethods());
            cglibEqualsMethod = var10000[0];
            cglibEqualsProxy = MethodProxy.create(var1, var0, "(Ljava/lang/Object;)Z", "equals", "CGLIB$equals$1");
            cglibTostringMethod = var10000[1];
            cglibTostringProxy = MethodProxy.create(var1, var0, "()Ljava/lang/String;", "toString", "CGLIB$toString$2");
            cglibHashcodeMethod = var10000[2];
            cglibHashcodeProxy = MethodProxy.create(var1, var0, "()I", "hashCode", "CGLIB$hashCode$3");
            cglibCloneMethod = var10000[3];
            cglibCloneProxy = MethodProxy.create(var1, var0, "()Ljava/lang/Object;", "clone", "CGLIB$clone$4");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    final void cglibTest() throws Throwable {
        super.test();
    }

    public final void test() throws Throwable {
        MethodInterceptor var10000 = this.methodInterceptor;
        if (var10000 == null) {
            cglibBindCallbacks(this);
            var10000 = this.methodInterceptor;
        }

        if (var10000 != null) {
            var10000.intercept(this, cglibTestMethod, cglibEmptyargs, cglibTestProxy);
        } else {
            super.test();
        }
    }

    private static final void cglibBindCallbacks(Object var0) {
        CglibSampleClass var1 = (CglibSampleClass) var0;
        if (!var1.cglibBound) {
            var1.cglibBound = true;
            Object var10000 = cglibThreadCallbacks.get();
            if (var10000 == null) {
                var10000 = cglibStaticCallbacks;
                if (var10000 == null) {
                    return;
                }
            }

            var1.methodInterceptor = (MethodInterceptor) ((Callback[]) var10000)[0];
        }

    }

    public static MethodProxy cglibFindmethodproxy(Signature var0) {
        String var10000 = var0.toString();
        switch (var10000.hashCode()) {
            case -1422510685:
                if (var10000.equals("test()V")) {
                    return cglibTestProxy;
                }
                break;
            case -508378822:
                if (var10000.equals("clone()Ljava/lang/Object;")) {
                    return cglibCloneProxy;
                }
                break;
            case 1826985398:
                if (var10000.equals("equals(Ljava/lang/Object;)Z")) {
                    return cglibEqualsProxy;
                }
                break;
            case 1913648695:
                if (var10000.equals("toString()Ljava/lang/String;")) {
                    return cglibTostringProxy;
                }
                break;
            case 1984935277:
                if (var10000.equals("hashCode()I")) {
                    return cglibHashcodeProxy;
                }
        }

        return null;
    }



    public static void cglibSetThreadCallbacks(Callback[] var0) {
        cglibThreadCallbacks.set(var0);
    }

    public static void cglibSetStaticCallbacks(Callback[] var0) {
        cglibStaticCallbacks = var0;
    }



    public Object newInstance(Callback[] var1) {
        cglibSetThreadCallbacks(var1);
        CglibSampleClass var10000 = new CglibSampleClass();
        cglibSetThreadCallbacks((Callback[]) null);
        return var10000;
    }

    public Object newInstance(Callback var1) {
        cglibSetThreadCallbacks(new Callback[]{var1});
        CglibSampleClass var10000 = new CglibSampleClass();
        cglibSetThreadCallbacks((Callback[]) null);
        return var10000;
    }

    public Object newInstance(Class[] var1, Object[] var2, Callback[] var3) {
        cglibSetThreadCallbacks(var3);
        CglibSampleClass var10000 = new CglibSampleClass();
        switch (var1.length) {
            case 0:
                var10000.newInstance(var3);
                cglibSetThreadCallbacks((Callback[]) null);
                return var10000;
            default:
                throw new IllegalArgumentException("Constructor not found");
        }
    }

    public Callback getCallback(int var1) {
        cglibBindCallbacks(this);
        MethodInterceptor var10000;
        switch (var1) {
            case 0:
                var10000 = this.methodInterceptor;
                break;
            default:
                var10000 = null;
        }

        return var10000;
    }

    public void setCallback(int var1, Callback var2) {
        switch (var1) {
            case 0:
                this.methodInterceptor = (MethodInterceptor) var2;
            default:
        }
    }

    public Callback[] getCallbacks() {
        cglibBindCallbacks(this);
        return new Callback[]{this.methodInterceptor};
    }

    public void setCallbacks(Callback[] var1) {
        this.methodInterceptor = (MethodInterceptor) var1[0];
    }

    final boolean cglibEquals(Object var1) {
        return super.equals(var1);
    }

    public final boolean equals(Object var1) {
        MethodInterceptor var10000 = this.methodInterceptor;
        if (var10000 == null) {
            cglibBindCallbacks(this);
            var10000 = this.methodInterceptor;
        }

        if (var10000 != null) {
            Object var2 = null;
            try {
                var2 = var10000.intercept(this, cglibEqualsMethod, new Object[]{var1}, cglibEqualsProxy);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return var2 == null ? false : (Boolean) var2;
        } else {
            return super.equals(var1);
        }
    }

    final String cglibTostring() {
        return super.toString();
    }

    public final String toString() {
        MethodInterceptor var10000 = this.methodInterceptor;
        if (var10000 == null) {
            cglibBindCallbacks(this);
            var10000 = this.methodInterceptor;
        }

        try {
            return var10000 != null ? (String) var10000.intercept(this, cglibTostringMethod, cglibEmptyargs, cglibTostringProxy) : super.toString();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw  new RuntimeException(throwable);
        }
    }

    final int cglibHashcode() {
        return super.hashCode();
    }

    public final int hashCode() {
        MethodInterceptor var10000 = this.methodInterceptor;
        if (var10000 == null) {
            cglibBindCallbacks(this);
            var10000 = this.methodInterceptor;
        }

        if (var10000 != null) {
            Object var1 = null;
            try {
                var1 = var10000.intercept(this, cglibHashcodeMethod, cglibEmptyargs, cglibHashcodeProxy);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return var1 == null ? 0 : ((Number) var1).intValue();
        } else {
            return super.hashCode();
        }
    }

    final Object cglibClone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected final Object clone() throws CloneNotSupportedException {
        MethodInterceptor var10000 = this.methodInterceptor;
        if (var10000 == null) {
            cglibBindCallbacks(this);
            var10000 = this.methodInterceptor;
        }

        try {
            return var10000 != null ? var10000.intercept(this, cglibCloneMethod, cglibEmptyargs, cglibCloneProxy) : super.clone();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        }
    }

}
