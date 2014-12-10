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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.ByteArrayBuffer;

import topoos.APIAccess.mime.content.ContentBody;

// TODO: Auto-generated Javadoc
/**
 * HttpMultipart represents a collection of MIME multipart encoded content bodies. This class is
 * capable of operating either in the strict (RFC 822, RFC 2045, RFC 2046 compliant) or
 * the browser compatible modes.
 *
 * @since 4.0
 */
public class HttpMultipart {

    /**
     * Encode.
     *
     * @param charset the charset
     * @param string the string
     * @return the byte array buffer
     */
    private static ByteArrayBuffer encode(
            final Charset charset, final String string) {
        ByteBuffer encoded = charset.encode(CharBuffer.wrap(string));
        ByteArrayBuffer bab = new ByteArrayBuffer(encoded.remaining());
        bab.append(encoded.array(), encoded.position(), encoded.remaining());
        return bab;
    }

    /**
     * Write bytes.
     *
     * @param b the b
     * @param out the out
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static void writeBytes(
            final ByteArrayBuffer b, final OutputStream out) throws IOException {
        out.write(b.buffer(), 0, b.length());
    }

    /**
     * Write bytes.
     *
     * @param s the s
     * @param charset the charset
     * @param out the out
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static void writeBytes(
            final String s, final Charset charset, final OutputStream out) throws IOException {
        ByteArrayBuffer b = encode(charset, s);
        writeBytes(b, out);
    }

    /**
     * Write bytes.
     *
     * @param s the s
     * @param out the out
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static void writeBytes(
            final String s, final OutputStream out) throws IOException {
        ByteArrayBuffer b = encode(MIME.DEFAULT_CHARSET, s);
        writeBytes(b, out);
    }

    /**
     * Write field.
     *
     * @param field the field
     * @param out the out
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static void writeField(
            final MinimalField field, final OutputStream out) throws IOException {
        writeBytes(field.getName(), out);
        writeBytes(FIELD_SEP, out);
        writeBytes(field.getBody(), out);
        writeBytes(CR_LF, out);
    }

    /**
     * Write field.
     *
     * @param field the field
     * @param charset the charset
     * @param out the out
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static void writeField(
            final MinimalField field, final Charset charset, final OutputStream out) throws IOException {
        writeBytes(field.getName(), charset, out);
        writeBytes(FIELD_SEP, out);
        writeBytes(field.getBody(), charset, out);
        writeBytes(CR_LF, out);
    }

    /** The Constant FIELD_SEP. */
    private static final ByteArrayBuffer FIELD_SEP = encode(MIME.DEFAULT_CHARSET, ": ");
    
    /** The Constant CR_LF. */
    private static final ByteArrayBuffer CR_LF = encode(MIME.DEFAULT_CHARSET, "\r\n");
    
    /** The Constant TWO_DASHES. */
    private static final ByteArrayBuffer TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");


    /** The sub type. */
    private final String subType;
    
    /** The charset. */
    private final Charset charset;
    
    /** The boundary. */
    private final String boundary;
    
    /** The parts. */
    private final List<FormBodyPart> parts;

    /** The mode. */
    private final HttpMultipartMode mode;

    /**
     * Creates an instance with the specified settings.
     *
     * @param subType mime subtype - must not be {@code null}
     * @param charset the character set to use. May be {@code null}, in which case {@link MIME#DEFAULT_CHARSET} - i.e. US-ASCII - is used.
     * @param boundary to use  - must not be {@code null}
     * @param mode the mode to use
     */
    public HttpMultipart(final String subType, final Charset charset, final String boundary, HttpMultipartMode mode) {
        super();
        if (subType == null) {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        }
        if (boundary == null) {
            throw new IllegalArgumentException("Multipart boundary may not be null");
        }
        this.subType = subType;
        this.charset = charset != null ? charset : MIME.DEFAULT_CHARSET;
        this.boundary = boundary;
        this.parts = new ArrayList<FormBodyPart>();
        this.mode = mode;
    }

    /**
     * Creates an instance with the specified settings.
     * Mode is set to {@link HttpMultipartMode#STRICT}
     *
     * @param subType mime subtype - must not be {@code null}
     * @param charset the character set to use. May be {@code null}, in which case {@link MIME#DEFAULT_CHARSET} - i.e. US-ASCII - is used.
     * @param boundary to use  - must not be {@code null}
     */
    public HttpMultipart(final String subType, final Charset charset, final String boundary) {
        this(subType, charset, boundary, HttpMultipartMode.STRICT);
    }

    /**
     * Instantiates a new http multipart.
     *
     * @param subType the sub type
     * @param boundary the boundary
     */
    public HttpMultipart(final String subType, final String boundary) {
        this(subType, null, boundary);
    }

    /**
     * Gets the sub type.
     *
     * @return the sub type
     */
    public String getSubType() {
        return this.subType;
    }

    /**
     * Gets the charset.
     *
     * @return the charset
     */
    public Charset getCharset() {
        return this.charset;
    }

    /**
     * Gets the mode.
     *
     * @return the mode
     */
    public HttpMultipartMode getMode() {
        return this.mode;
    }

    /**
     * Gets the body parts.
     *
     * @return the body parts
     */
    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    /**
     * Adds the body part.
     *
     * @param part the part
     */
    public void addBodyPart(final FormBodyPart part) {
        if (part == null) {
            return;
        }
        this.parts.add(part);
    }

    /**
     * Gets the boundary.
     *
     * @return the boundary
     */
    public String getBoundary() {
        return this.boundary;
    }

    /**
     * Do write to.
     *
     * @param mode the mode
     * @param out the out
     * @param writeContent the write content
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void doWriteTo(
        final HttpMultipartMode mode,
        final OutputStream out,
        boolean writeContent) throws IOException {

        ByteArrayBuffer boundary = encode(this.charset, getBoundary());
        for (FormBodyPart part: this.parts) {
            writeBytes(TWO_DASHES, out);
            writeBytes(boundary, out);
            writeBytes(CR_LF, out);

            Header header = part.getHeader();

            switch (mode) {
            case STRICT:
                for (MinimalField field: header) {
                    writeField(field, out);
                }
                break;
            case BROWSER_COMPATIBLE:
                // Only write Content-Disposition
                // Use content charset
                MinimalField cd = part.getHeader().getField(MIME.CONTENT_DISPOSITION);
                writeField(cd, this.charset, out);
                String filename = part.getBody().getFilename();
                if (filename != null) {
                    MinimalField ct = part.getHeader().getField(MIME.CONTENT_TYPE);
                    writeField(ct, this.charset, out);
                }
                break;
            }
            writeBytes(CR_LF, out);

            if (writeContent) {
                part.getBody().writeTo(out);
            }
            writeBytes(CR_LF, out);
        }
        writeBytes(TWO_DASHES, out);
        writeBytes(boundary, out);
        writeBytes(TWO_DASHES, out);
        writeBytes(CR_LF, out);
    }

    /**
     * Writes out the content in the multipart/form encoding. This method
     * produces slightly different formatting depending on its compatibility
     * mode.
     *
     * @param out the out
     * @throws IOException Signals that an I/O exception has occurred.
     * @see #getMode()
     */
    public void writeTo(final OutputStream out) throws IOException {
        doWriteTo(this.mode, out, true);
    }

    /**
     * Determines the total length of the multipart content (content length of
     * individual parts plus that of extra elements required to delimit the parts
     * from one another). If any of the @{link BodyPart}s contained in this object
     * is of a streaming entity of unknown length the total length is also unknown.
     * <p/>
     * This method buffers only a small amount of data in order to determine the
     * total length of the entire entity. The content of individual parts is not
     * buffered.
     *
     * @return total length of the multipart entity if known, <code>-1</code>
     *   otherwise.
     */
    public long getTotalLength() {
        long contentLen = 0;
        for (FormBodyPart part: this.parts) {
            ContentBody body = part.getBody();
            long len = body.getContentLength();
            if (len >= 0) {
                contentLen += len;
            } else {
                return -1;
            }
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            doWriteTo(this.mode, out, false);
            byte[] extra = out.toByteArray();
            return contentLen + extra.length;
        } catch (IOException ex) {
            // Should never happen
            return -1;
        }
    }

}
