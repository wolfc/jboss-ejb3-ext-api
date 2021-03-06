/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2006, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.ejb3.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation for specifying the transaction timeout of a newly started
 * transaction when invoking an EJB business method.
 * 
 * @author <a href="mailto:bill.decoste@jboss.org">William DeCoste</a>
 */
@Target({METHOD, TYPE})
@Retention(RUNTIME)
public @interface TransactionTimeout {
    /**
     * The new timeout value, in seconds. If this parameter
     * is <code>0</code>, the timeout value is reset to the default
     * value.
     *
     * @see javax.transaction.TransactionManager#setTransactionTimeout(int) 
     */
    long value() default 0;

    /**
     * Units used for the specified value. The minimum granularity is
     * <code>SECONDS</code>, specifying a lower one will result in a deployment
     * failure.
     * @since 2.0
     */
    TimeUnit unit() default TimeUnit.SECONDS;
}
