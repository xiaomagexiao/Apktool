/**
 *  Copyright 2010 Ryszard Wiśniewski <brut.alll@gmail.com>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package brut.util;

import java.io.DataInput;
import java.io.IOException;

/**
 * @author Ryszard Wiśniewski <brut.alll@gmail.com>
 */
abstract public class DataInputDelegate implements DataInput {
    protected final DataInput mDelegate;
    public int pos;
    public DataInputDelegate(DataInput delegate) {
        this.mDelegate = delegate;
        pos = 0;
    }

    public int skipBytes(int n) throws IOException {
    	pos += n;
        return mDelegate.skipBytes(n);
    }

    public int readUnsignedShort() throws IOException {
    	pos += 2;
        return mDelegate.readUnsignedShort();
    }

    public int readUnsignedByte() throws IOException {
    	pos += 1;
        return mDelegate.readUnsignedByte();
    }

    public String readUTF() throws IOException {
    	String ret = mDelegate.readUTF();
    	if(ret != null)pos += ret.getBytes().length;
        return ret;
    }

    public short readShort() throws IOException {
    	pos += 2;
        return mDelegate.readShort();
    }

    public long readLong() throws IOException {
    	pos += 8;
        return mDelegate.readLong();
    }

    public String readLine() throws IOException {
        String ret = mDelegate.readLine();
        pos += ret.getBytes().length + 1;
        return ret;
    }

    public int readInt() throws IOException {
    	pos += 4;
        return mDelegate.readInt();
    }

    public void readFully(byte[] b, int off, int len) throws IOException {
    	pos += len;
        mDelegate.readFully(b, off, len);
    }

    public void readFully(byte[] b) throws IOException {
    	pos += b.length;
        mDelegate.readFully(b);
    }

    public float readFloat() throws IOException {
    	pos += 4;
        return mDelegate.readFloat();
    }

    public double readDouble() throws IOException {
    	pos += 8;
        return mDelegate.readDouble();
    }

    public char readChar() throws IOException {
    	pos += 2;
        return mDelegate.readChar();
    }

    public byte readByte() throws IOException {
    	pos += 1;
        return mDelegate.readByte();
    }

    public boolean readBoolean() throws IOException {
    	pos += 1;
        return mDelegate.readBoolean();
    }
}
