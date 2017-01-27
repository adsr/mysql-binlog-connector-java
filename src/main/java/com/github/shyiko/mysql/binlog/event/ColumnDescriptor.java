package com.github.shyiko.mysql.binlog.event;

import java.io.Serializable;

public class ColumnDescriptor implements Serializable {
    private int length;
    private int type;
    private int displayLength;
    private int scale;
    private int characterSet;
    private int flags;
    private String name;
    private String typeName;
    private String comment;

    public ColumnDescriptor(
        int length,
        int type,
        int displayLength,
        int scale,
        int characterSet,
        int flags,
        String name,
        String typeName,
        String comment
    ) {
        this.length = length;
        this.type = type;
        this.displayLength = displayLength;
        this.scale = scale;
        this.characterSet = characterSet;
        this.flags = flags;
        this.name = name;
        this.typeName = typeName;
        this.comment = comment;
    }

    public int getLength() {
        return length;
    }

    public int getType() {
        return type;
    }

    public int getDisplayLength() {
        return displayLength;
    }

    public int getScale() {
        return scale;
    }

    public int getCharacterSet() {
        return characterSet;
    }

    public int getFlags() {
        return flags;
    }

    public String getName() {
        return name;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        return sb.append("ColumnDescriptor")
            .append("{length=").append(length)
            .append(",type=").append(type)
            .append(",displayLength=").append(displayLength)
            .append(",scale=").append(scale)
            .append(",characterSet=").append(characterSet)
            .append(",flags=").append(flags)
            .append(",name=").append(name)
            .append(",typeName=").append(typeName)
            .append(",comment=").append(comment)
            .append("}")
            .toString();
    }
}
