package com.github.shyiko.mysql.binlog.event.deserialization;

import com.github.shyiko.mysql.binlog.event.ColumnDescriptor;
import com.github.shyiko.mysql.binlog.event.TableMetadataEventData;
import com.github.shyiko.mysql.binlog.io.ByteArrayInputStream;

import java.io.IOException;

public class TableMetadataEventDataDeserializer implements EventDataDeserializer<TableMetadataEventData> {

    public TableMetadataEventData deserialize(ByteArrayInputStream inputStream) throws IOException {
        TableMetadataEventData eventData = new TableMetadataEventData();
        eventData.setTableId(inputStream.readLong(6));
        eventData.setNumCols(inputStream.readInteger(2));
        eventData.setReserved(inputStream.readInteger(2));
        for (int i = 0; i < eventData.getNumCols(); i++) {
            eventData.addColumnDescriptor(new ColumnDescriptor(
                inputStream.readInteger(4), // length
                inputStream.readInteger(1), // type
                inputStream.readInteger(4), // display length
                inputStream.readInteger(1), // scale
                inputStream.readInteger(2), // character set
                inputStream.readInteger(2), // flags
                inputStream.readLengthEncodedString(), // name
                inputStream.readLengthEncodedString(), // type name
                inputStream.readLengthEncodedString() // comment
            ));
        }
        return eventData;
    }

}
