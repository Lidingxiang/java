/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.ly.driver;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum GetAppInfoStatus implements org.apache.thrift.TEnum {
  Success(0),
  InvalidUserBaseId(1),
  NoExist(2);

  private final int value;

  private GetAppInfoStatus(int value) {
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
  public static GetAppInfoStatus findByValue(int value) { 
    switch (value) {
      case 0:
        return Success;
      case 1:
        return InvalidUserBaseId;
      case 2:
        return NoExist;
      default:
        return null;
    }
  }
}