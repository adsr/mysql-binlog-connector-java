package com.github.shyiko.mysql.binlog.event;

import java.util.ArrayList;
import java.util.List;

public class TableMetadataEventData implements EventData {

    private long tableId;
    private int reserved;
    private int numCols;
    private List<ColumnDescriptor> columnDescriptors = new ArrayList<ColumnDescriptor>();
    private TableMapEventData tableMapEventData;

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    public List<ColumnDescriptor> getColumnDescriptors() {
        return columnDescriptors;
    }

    public void addColumnDescriptor(ColumnDescriptor columnMetadata) {
        this.columnDescriptors.add(columnMetadata);
    }

    public TableMapEventData getTableMapEventData() { return tableMapEventData; }

    public boolean hasTableMapEventData() { return tableMapEventData != null; }

    public void setTableMapEventData(TableMapEventData tableMapEventData, int depth) {
        this.tableMapEventData = tableMapEventData;
        if (depth == 0) {
            tableMapEventData.setMetadataEventData(this, depth + 1);
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TableMetadataEvent")
            .append("{tableId=").append(tableId)
            .append(",reserved=").append(reserved)
            .append(",numCols=").append(numCols)
            .append(",columnDescriptors=");
        for (ColumnDescriptor descriptor : columnDescriptors) {
            sb.append(descriptor);
            sb.append(",");
        }
        sb.append("}");
        return sb.toString();
    }
}
