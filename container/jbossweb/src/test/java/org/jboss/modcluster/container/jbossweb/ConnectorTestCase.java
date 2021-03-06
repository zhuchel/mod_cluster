/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
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
package org.jboss.modcluster.container.jbossweb;

import org.junit.Assert;
import org.junit.Test;

public class ConnectorTestCase extends org.jboss.modcluster.container.catalina.ConnectorTestCase {

    @Test
    public void getMaxThreads() {
        /* it is 32 * processor if APR and 512 if not */
        int maxjiothreads = 512 * Runtime.getRuntime().availableProcessors();
        int maxaprthreads = 32 * Runtime.getRuntime().availableProcessors();
        if (maxaprthreads != this.httpConnector.getMaxThreads() && maxjiothreads != this.httpConnector.getMaxThreads())
        	Assert.fail("expected:<" + maxjiothreads + "> or <" + maxaprthreads + "  but was:" + this.httpConnector.getMaxThreads());
        
        if (maxaprthreads != this.ajpConnector.getMaxThreads() && maxjiothreads != this.ajpConnector.getMaxThreads())
        	Assert.fail("expected:<" + maxjiothreads + "> or <" + maxaprthreads + "  but was:" + this.ajpConnector.getMaxThreads());

        if (maxaprthreads != this.httpsConnector.getMaxThreads() && maxjiothreads != this.httpsConnector.getMaxThreads())
        	Assert.fail("expected:<" + maxjiothreads + "> or <" + maxaprthreads + "  but was:" + this.httpsConnector.getMaxThreads());
        
        if (maxaprthreads != this.ajpConnector.getMaxThreads() && maxjiothreads != this.ajpConnector.getMaxThreads())
        	Assert.fail("expected:<" + maxjiothreads + "> or <" + maxaprthreads + "  but was:" + this.ajpConnector.getMaxThreads());
    }

    @Test
    public void getBusyThreads() {
        Assert.assertEquals(0, this.httpConnector.getBusyThreads());
        Assert.assertEquals(0, this.httpsConnector.getBusyThreads());
        Assert.assertEquals(0, this.ajpConnector.getBusyThreads());
    }
}
