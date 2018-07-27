/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.dingxiang.userservicedriver;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUserExtendInfoRet implements org.apache.thrift.TBase<GetUserExtendInfoRet, GetUserExtendInfoRet._Fields>, java.io.Serializable, Cloneable, Comparable<GetUserExtendInfoRet> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GetUserExtendInfoRet");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField USER_EXTEND_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("userExtendInfo", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GetUserExtendInfoRetStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GetUserExtendInfoRetTupleSchemeFactory());
  }

  /**
   * 
   * @see GetUserInfoStatus
   */
  public GetUserInfoStatus status; // required
  public UserExtendInfo userExtendInfo; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see GetUserInfoStatus
     */
    STATUS((short)1, "status"),
    USER_EXTEND_INFO((short)2, "userExtendInfo");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // STATUS
          return STATUS;
        case 2: // USER_EXTEND_INFO
          return USER_EXTEND_INFO;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, GetUserInfoStatus.class)));
    tmpMap.put(_Fields.USER_EXTEND_INFO, new org.apache.thrift.meta_data.FieldMetaData("userExtendInfo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, UserExtendInfo.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GetUserExtendInfoRet.class, metaDataMap);
  }

  public GetUserExtendInfoRet() {
  }

  public GetUserExtendInfoRet(
    GetUserInfoStatus status,
    UserExtendInfo userExtendInfo)
  {
    this();
    this.status = status;
    this.userExtendInfo = userExtendInfo;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GetUserExtendInfoRet(GetUserExtendInfoRet other) {
    if (other.isSetStatus()) {
      this.status = other.status;
    }
    if (other.isSetUserExtendInfo()) {
      this.userExtendInfo = new UserExtendInfo(other.userExtendInfo);
    }
  }

  public GetUserExtendInfoRet deepCopy() {
    return new GetUserExtendInfoRet(this);
  }

  @Override
  public void clear() {
    this.status = null;
    this.userExtendInfo = null;
  }

  /**
   * 
   * @see GetUserInfoStatus
   */
  public GetUserInfoStatus getStatus() {
    return this.status;
  }

  /**
   * 
   * @see GetUserInfoStatus
   */
  public GetUserExtendInfoRet setStatus(GetUserInfoStatus status) {
    this.status = status;
    return this;
  }

  public void unsetStatus() {
    this.status = null;
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return this.status != null;
  }

  public void setStatusIsSet(boolean value) {
    if (!value) {
      this.status = null;
    }
  }

  public UserExtendInfo getUserExtendInfo() {
    return this.userExtendInfo;
  }

  public GetUserExtendInfoRet setUserExtendInfo(UserExtendInfo userExtendInfo) {
    this.userExtendInfo = userExtendInfo;
    return this;
  }

  public void unsetUserExtendInfo() {
    this.userExtendInfo = null;
  }

  /** Returns true if field userExtendInfo is set (has been assigned a value) and false otherwise */
  public boolean isSetUserExtendInfo() {
    return this.userExtendInfo != null;
  }

  public void setUserExtendInfoIsSet(boolean value) {
    if (!value) {
      this.userExtendInfo = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((GetUserInfoStatus)value);
      }
      break;

    case USER_EXTEND_INFO:
      if (value == null) {
        unsetUserExtendInfo();
      } else {
        setUserExtendInfo((UserExtendInfo)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return getStatus();

    case USER_EXTEND_INFO:
      return getUserExtendInfo();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case STATUS:
      return isSetStatus();
    case USER_EXTEND_INFO:
      return isSetUserExtendInfo();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GetUserExtendInfoRet)
      return this.equals((GetUserExtendInfoRet)that);
    return false;
  }

  public boolean equals(GetUserExtendInfoRet that) {
    if (that == null)
      return false;

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (!this.status.equals(that.status))
        return false;
    }

    boolean this_present_userExtendInfo = true && this.isSetUserExtendInfo();
    boolean that_present_userExtendInfo = true && that.isSetUserExtendInfo();
    if (this_present_userExtendInfo || that_present_userExtendInfo) {
      if (!(this_present_userExtendInfo && that_present_userExtendInfo))
        return false;
      if (!this.userExtendInfo.equals(that.userExtendInfo))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(GetUserExtendInfoRet other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserExtendInfo()).compareTo(other.isSetUserExtendInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserExtendInfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userExtendInfo, other.userExtendInfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("GetUserExtendInfoRet(");
    boolean first = true;

    sb.append("status:");
    if (this.status == null) {
      sb.append("null");
    } else {
      sb.append(this.status);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("userExtendInfo:");
    if (this.userExtendInfo == null) {
      sb.append("null");
    } else {
      sb.append(this.userExtendInfo);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (userExtendInfo != null) {
      userExtendInfo.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class GetUserExtendInfoRetStandardSchemeFactory implements SchemeFactory {
    public GetUserExtendInfoRetStandardScheme getScheme() {
      return new GetUserExtendInfoRetStandardScheme();
    }
  }

  private static class GetUserExtendInfoRetStandardScheme extends StandardScheme<GetUserExtendInfoRet> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GetUserExtendInfoRet struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.status = GetUserInfoStatus.findByValue(iprot.readI32());
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USER_EXTEND_INFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.userExtendInfo = new UserExtendInfo();
              struct.userExtendInfo.read(iprot);
              struct.setUserExtendInfoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, GetUserExtendInfoRet struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.status != null) {
        oprot.writeFieldBegin(STATUS_FIELD_DESC);
        oprot.writeI32(struct.status.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.userExtendInfo != null) {
        oprot.writeFieldBegin(USER_EXTEND_INFO_FIELD_DESC);
        struct.userExtendInfo.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GetUserExtendInfoRetTupleSchemeFactory implements SchemeFactory {
    public GetUserExtendInfoRetTupleScheme getScheme() {
      return new GetUserExtendInfoRetTupleScheme();
    }
  }

  private static class GetUserExtendInfoRetTupleScheme extends TupleScheme<GetUserExtendInfoRet> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GetUserExtendInfoRet struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetStatus()) {
        optionals.set(0);
      }
      if (struct.isSetUserExtendInfo()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetStatus()) {
        oprot.writeI32(struct.status.getValue());
      }
      if (struct.isSetUserExtendInfo()) {
        struct.userExtendInfo.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GetUserExtendInfoRet struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.status = GetUserInfoStatus.findByValue(iprot.readI32());
        struct.setStatusIsSet(true);
      }
      if (incoming.get(1)) {
        struct.userExtendInfo = new UserExtendInfo();
        struct.userExtendInfo.read(iprot);
        struct.setUserExtendInfoIsSet(true);
      }
    }
  }

}

