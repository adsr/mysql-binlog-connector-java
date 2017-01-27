/*
 * Copyright 2013 Stanley Shyiko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.shyiko.mysql.binlog.event.deserialization;

import com.github.shyiko.mysql.binlog.event.GtidEventData;
import com.github.shyiko.mysql.binlog.io.ByteArrayInputStream;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * @author <a href="https://github.com/adsr">Adam Saponara</a>
 */
public class GtidEventDataDeserializerTest {
    private static final byte[] DATA = {
        0x42, // flags
        0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10, // sid
        0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18 // gno
    };

    @Test
    public void deserialize() throws IOException {
        GtidEventDataDeserializer deserializer = new GtidEventDataDeserializer();
        GtidEventData data = deserializer.deserialize(new ByteArrayInputStream(DATA));

        assertEquals(0x42, data.getFlags());
        assertEquals("01020304-0506-0708-090a-0b0c0d0e0f10:1735880461161533969", data.getGtid());
    }
}
