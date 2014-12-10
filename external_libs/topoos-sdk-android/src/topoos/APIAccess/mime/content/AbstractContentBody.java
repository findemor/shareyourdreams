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

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractContentBody.
 *
 * @since 4.0
 */
public abstract class AbstractContentBody implements ContentBody {

    /** The mime type. */
    private final String mimeType;
    
    /** The media type. */
    private final String mediaType;
    
    /** The sub type. */
    private final String subType;

    /**
     * Instantiates a new abstract content body.
     *
     * @param mimeType the mime type
     */
    public AbstractContentBody(final String mimeType) {
        super();
        if (mimeType == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        this.mimeType = mimeType;
        int i = mimeType.indexOf('/');
        if (i != -1) {
            this.mediaType = mimeType.substring(0, i);
            this.subType = mimeType.substring(i + 1);
        } else {
            this.mediaType = mimeType;
            this.subType = null;
        }
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentDescriptor#getMimeType()
     */
    public String getMimeType() {
        return this.mimeType;
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentDescriptor#getMediaType()
     */
    public String getMediaType() {
        return this.mediaType;
    }

    /* (non-Javadoc)
     * @see topoos.APIAccess.mime.content.ContentDescriptor#getSubType()
     */
    public String getSubType() {
        return this.subType;
    }

}
