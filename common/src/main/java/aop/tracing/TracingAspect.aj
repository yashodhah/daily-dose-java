package aop.tracing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect TracingAspect {
    private static final Logger LOG = LoggerFactory.getLogger(TracingAspect.class);
    pointcut traceAnnotatedClasses(): within(@Trace *) && execution(* *(..));

    Object around(): traceAnnotatedClasses() {
//        String signature = thisJoinPoint.getStaticPart().getSignature().toShortString();
//        LOG.trace("Entering " + signature);
        try {
            return proceed();
        } finally {
//            LOG.trace("Exiting " + signature);
        }
    }
}
