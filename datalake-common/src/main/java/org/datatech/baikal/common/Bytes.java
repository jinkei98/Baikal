/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.datatech.baikal.common;

import java.nio.charset.Charset;

/**
 * Byte array related functions.
 */
public class Bytes {
    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    public static byte[] toBytes(String s) {
        return s.getBytes(UTF8_CHARSET);
    }

    public static String toString(byte[] b) {
        return b == null ? null : toString(b, 0, b.length);
    }

    public static String toString(byte[] b, int off, int len) {
        if (b == null) {
            return null;
        } else {
            return len == 0 ? "" : new String(b, off, len, UTF8_CHARSET);
        }
    }

    public static byte[] toBytes(int val) {
        byte[] b = new byte[4];

        for (int i = 3; i > 0; --i) {
            b[i] = (byte) val;
            val >>>= 8;
        }

        b[0] = (byte) val;
        return b;
    }
}
