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

public enum RegisterTypeEnum implements org.apache.thrift.TEnum {
  Personal(0),
  PrivateEnterPrise(1),
  NationalEnterPrise(2),
  ForeignEnterPrise(3),
  Organization(4);

  private final int value;

  private RegisterTypeEnum(int value) {
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
  public static RegisterTypeEnum findByValue(int value) { 
    switch (value) {
      case 0:
        return Personal;
      case 1:
        return PrivateEnterPrise;
      case 2:
        return NationalEnterPrise;
      case 3:
        return ForeignEnterPrise;
      case 4:
        return Organization;
      default:
        return null;
    }
  }
}
