package lw.learning.monitortuning.chapter4;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * @Author lw
 * @Date 2018-12-24 20:13:11
 **/
@BTrace
public class BtraceSimple {
    @OnMethod(
            clazz="lw.learning.monitortuning.chapter4.BtraceController",
            method="test",
            location=@Location(Kind.ENTRY)
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
        BTraceUtils.printArray(args);
        BTraceUtils.println(pcn+","+pmn);
        BTraceUtils.println();
    }
}
