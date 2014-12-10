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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import topoos.APIAccess.mime.MIME;

// TODO: Auto-generated Javadoc
/**
 * The Class StringBody.
 *
 * @since 4.0
 */
public class StringBody extends AbstractContentBody {

    /** The content. */
    private final byte[] content;
    
    /** The charset. */
    private final Charset charset;

    /**
     * Creates the.
     *
     * @param text the text
     * @param mimeType the mime type
     * @param charset the charset
     * @return the string body
     * @throws IllegalArgumentException the illegal argument exception
     * @since 4.1
     */
    public static StringBody create(
            final String text,
            final String mimeType,
            final Charset charset) throws IllegalArgumentException {
        try {
            return new StringBody(text, mimeType, charset);
        } catch (UnsupportedEncodingException ex) {
            throw new IllegalArgumentException("Charset " + charset + " is not supported", ex);
        }
    }

    /**
     * Creates the.
     *
     * @param text the text
     * @param charset the charset
     * @return the string body
     * @throws IllegalArgumentException the illegal argument exception
     * @since 4.1
     */
    public static StringBody create(
            final String text, final Charset charset) throws IllegalArgumentException {
        return create(text, null, charset);
    }

    /**
     * Creates the.
     *
     * @param text the text
     * @return the string body
     * @throws IllegalArgumentException the illegal argument exception
     * @since 4.1
     */
    public static StringBody create(final String text) throws IllegalArgumentException {
        return create(text, null, null);
    }

    /**
     * Create a StringBody from the specified text, mime type and character set.
     *
     * @param text to be used for the body, not {@code null}
     * @param mimeType the mime type, not {@code null}
     * @param charset the character set, may be {@code null}, in which case the US-ASCII charset is used
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public StringBody(
            final String text,
            final String mimeType,
            Charset charset) throws UnsupportedEncodingException {
        super(mimeType);
        if (text == null) {
            throw new IllegalArgumentException("Text may not be null");
        }
        if (charset == null) {
            charset = Charset.forName("US-ASCII");
        }
        this.content = text.getBytes(charset.name());
        this.charset = charset;
    }

    /**
     * Create a StringBody from the specified text and character set.
     * The mime type is set to "text/plain".
     *
     * @param text to be used for the body, not {@code null}
     * @param charset the character set, may be {@code null}, in which case the US-ASCII charset is used
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public StringBody(final String text, final Charset charset) throws UnsupportedEncodingException {
        this(text, "text/plain", charset);
    }

    /**
     * Create a StringBody from the specified text.
     * The mime type is set to "text/plain".
     * The hosts default charset is used.
     *
     * @param text to be used for the body, not {@code null}
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public StringBody(final String text) throws UnsupportedEncodingException {
        this(text, "text/plain", null);
    }

    /**
     * Gets the reader.
     *
     * @return the reader
     */
    public Reader getReader() {
        return new InputStreamReader(
                new ByteArrayInputStream(this.content),
                this.charset);
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentBody#writeTo(java.io.OutputStream)
     */
    public void writeTo(final OutputStream out) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream in = new ByteArrayInputStream(this.content);
        byte[] tmp = new byte[4096];
        int l;
        while ((l = in.read(tmp)) != -1) {
            out.write(tmp, 0, l);
        }
        out.flush();
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentDescriptor#getTransferEncoding()
     */
    public String getTransferEncoding() {
        return MIME.ENC_8BIT;
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentDescriptor#getCharset()
     */
    public String getCharset() {
        return this.charset.name();
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentDescriptor#getContentLength()
     */
    public long getContentLength() {
        return this.content.length;
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentBody#getFilename()
     */
    public String getFilename() {
        return null;
    }

}
