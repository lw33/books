package lw.learning.monitortuning.chapter4;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * @Author lw
 * @Date 2018-12-24 20:25:47
 **/
@BTrace
public class BtraceConstructor {

    @OnMethod(
            clazz="lw.learning.monitortuning.entity.User",
            method="<init>"
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
        BTraceUtils.println(pcn+","+pmn);
        BTraceUtils.printArray(args);
        BTraceUtils.println();
    }
}
