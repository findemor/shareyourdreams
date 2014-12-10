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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import topoos.APIAccess.mime.MIME;

// TODO: Auto-generated Javadoc
/**
 * The Class FileBody.
 *
 * @since 4.0
 */
public class FileBody extends AbstractContentBody {

    /** The file. */
    private final File file;
    
    /** The filename. */
    private final String filename;
    
    /** The charset. */
    private final String charset;

    /**
     * Instantiates a new file body.
     *
     * @param file the file
     * @param filename the filename
     * @param mimeType the mime type
     * @param charset the charset
     * @since 4.1
     */
    public FileBody(final File file,
                    final String filename,
                    final String mimeType,
                    final String charset) {
        super(mimeType);
        if (file == null) {
            throw new IllegalArgumentException("File may not be null");
        }
        this.file = file;
        if (filename != null)
            this.filename = filename;
        else
            this.filename = file.getName();
        this.charset = charset;
    }

    /**
     * Instantiates a new file body.
     *
     * @param file the file
     * @param mimeType the mime type
     * @param charset the charset
     * @since 4.1
     */
    public FileBody(final File file,
                    final String mimeType,
                    final String charset) {
        this(file, null, mimeType, charset);
    }

    /**
     * Instantiates a new file body.
     *
     * @param file the file
     * @param mimeType the mime type
     */
    public FileBody(final File file, final String mimeType) {
        this(file, mimeType, null);
    }

    /**
     * Instantiates a new file body.
     *
     * @param file the file
     */
    public FileBody(final File file) {
        this(file, "application/octet-stream");
    }

    /**
     * Gets the input stream.
     *
     * @return the input stream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentBody#writeTo(java.io.OutputStream)
     */
    public void writeTo(final OutputStream out) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream in = new FileInputStream(this.file);
        try {
            byte[] tmp = new byte[4096];
            int l;
            while ((l = in.read(tmp)) != -1) {
                out.write(tmp, 0, l);
            }
            out.flush();
        } finally {
            in.close();
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
        return charset;
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentDescriptor#getContentLength()
     */
    public long getContentLength() {
        return this.file.length();
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentBody#getFilename()
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Gets the file.
     *
     * @return the file
     */
    public File getFile() {
        return this.file;
    }

}
