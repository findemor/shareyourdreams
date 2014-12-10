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

package topoos.APIAccess.mime.content;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import topoos.APIAccess.mime.MIME;

// TODO: Auto-generated Javadoc
/**
 * The Class InputStreamBody.
 *
 * @since 4.0
 */
public class InputStreamBody extends AbstractContentBody {

    /** The in. */
    private final InputStream in;
    
    /** The filename. */
    private final String filename;

    /**
     * Instantiates a new input stream body.
     *
     * @param in the in
     * @param mimeType the mime type
     * @param filename the filename
     */
    public InputStreamBody(final InputStream in, final String mimeType, final String filename) {
        super(mimeType);
        if (in == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        }
        this.in = in;
        this.filename = filename;
    }

    /**
     * Instantiates a new input stream body.
     *
     * @param in the in
     * @param filename the filename
     */
    public InputStreamBody(final InputStream in, final String filename) {
        this(in, "application/octet-stream", filename);
    }

    /**
     * Gets the input stream.
     *
     * @return the input stream
     */
    public InputStream getInputStream() {
        return this.in;
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentBody#writeTo(java.io.OutputStream)
     */
    public void writeTo(final OutputStream out) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            byte[] tmp = new byte[4096];
            int l;
            while ((l = this.in.read(tmp)) != -1) {
                out.write(tmp, 0, l);
            }
            out.flush();
        } finally {
            this.in.close();
        }
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentDescriptor#getTransferEncoding()
     */
    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentDescriptor#getCharset()
     */
    public String getCharset() {
        return null;
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentDescriptor#getContentLength()
     */
    public long getContentLength() {
        return -1;
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentBody#getFilename()
     */
    public String getFilename() {
        return this.filename;
    }

}
