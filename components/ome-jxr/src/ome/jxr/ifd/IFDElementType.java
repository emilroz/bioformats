/*
 * #%L
 * OME library for reading the JPEG XR file format.
 * %%
 * Copyright (C) 2013 Open Microscopy Environment:
 *   - Board of Regents of the University of Wisconsin-Madison
 *   - Glencoe Software, Inc.
 *   - University of Dundee
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

package ome.jxr.ifd;

/**
 * Enumeration of data types to which each IFD entry must conform. Naming of
 * types follows Rec.ITU-T T.832 (01/2012) - table A.5.
 *
 * @author Blazej Pindelski bpindelski at dundee.ac.uk
 */
public enum IFDElementType {

  BYTE(1, 1),
  UTF8(2, 1),
  USHORT(3, 2),
  ULONG(4, 4),
  URATIONAL(5, 2 * ULONG.getSize()),
  SBYTE(6, 1),
  UNDEFINED(7, 1),
  SSHORT(8, 2),
  SLONG(9, 4),
  SRATIONAL(10, 2 * SLONG.getSize()),
  FLOAT(11, 4),
  DOUBLE(12, 8);

  private final short typeCode;
  private final int size;

  private IFDElementType(int typeCode, int size) {
    this.typeCode = (short) typeCode;
    this.size = size;
  }

  public short getTypeCode() {
    return typeCode;
  }

  public int getSize() {
    return size;
  }

  public static IFDElementType valueOf(short typeCode) {
    for (IFDElementType type : IFDElementType.values()) {
      if (type.getTypeCode() == typeCode) {
        return type;
      }
    }
    throw new IllegalArgumentException("Unspecified type code: " + typeCode);
  }

}