/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.dingxiang.userservicedriver;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum AuthedType implements org.apache.thrift.TEnum {
  WaitingComplete(0),
  WaitingAuth(1),
  PartAuth(2),
  AllAuthed(3),
  All(4);

  private final int value;

  private AuthedType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static AuthedType findByValue(int value) { 
    switch (value) {
      case 0:
        return WaitingComplete;
      case 1:
        return WaitingAuth;
      case 2:
        return PartAuth;
      case 3:
        return AllAuthed;
      case 4:
        return All;
      default:
        return null;
    }
  }
}