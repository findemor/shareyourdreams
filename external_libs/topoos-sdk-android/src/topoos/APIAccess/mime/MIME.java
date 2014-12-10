/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package topoos.APIAccess.mime;

import java.nio.charset.Charset;

// TODO: Auto-generated Javadoc
/**
 * The Class MIME.
 *
 * @since 4.0
 */
public final class MIME {

    /** The Constant CONTENT_TYPE. */
    public static final String CONTENT_TYPE          = "Content-Type";
    
    /** The Constant CONTENT_TRANSFER_ENC. */
    public static final String CONTENT_TRANSFER_ENC  = "Content-Transfer-Encoding";
    
    /** The Constant CONTENT_DISPOSITION. */
    public static final String CONTENT_DISPOSITION   = "Content-Disposition";

    /** The Constant ENC_8BIT. */
    public static final String ENC_8BIT              = "8bit";
    
    /** The Constant ENC_BINARY. */
    public static final String ENC_BINARY            = "binary";

    /** The default character set to be used, i.e. "US-ASCII" */
    public static final Charset DEFAULT_CHARSET      = Charset.forName("US-ASCII");

}
