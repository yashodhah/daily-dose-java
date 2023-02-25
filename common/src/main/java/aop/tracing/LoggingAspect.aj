package aop.tracing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect LoggingAspect {
    private static final Logger LOG = LoggerFactory.getLogger(TracingAspect.class);
    pointcut traceAnnotatedClasses(): within(@LogOutput *) && execution(* *(..));

    Object around(): traceAnnotatedClasses() {
        try {
            Object a = proceed();
            LOG.info((String) a);

            return a;
        } catch (Exception e) {
            LOG.error("ERROR !!!", e);
        }
    }
}
