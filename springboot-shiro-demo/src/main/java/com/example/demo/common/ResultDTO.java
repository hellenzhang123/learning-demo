/**
 * @author zhangyuxuan
 * @date 2019年5月23日
 */
package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 */

public class ResultDTO {

  private int resultCode;

  private String message;

  @JsonInclude(Include.NON_EMPTY)
  private String subMessage;

  private Object data;

  public ResultDTO() {
    super();
  };

  /**
   * 该方法已过时，我们建议您使用 new ResultDTO(int resultCode, String message,String subMessage)，同时返回详细的错误信息
   * 
   * @param resultCode 返回码
   * @param message 提示信息
   */
  @Deprecated
  public ResultDTO(int resultCode, String message) {
    this(resultCode, message, null, null);
  };

  /**
   *
   * @param resultCode 返回码
   * @param message 提示信息
   * @param subMessage 详细信息
   */
  public ResultDTO(int resultCode, String message, String subMessage) {
    this(resultCode, message, null, subMessage);
  };

  /**
   *
   * @param resultCode 返回码
   * @param message 提示信息
   * @param data 返回数据
   */
  public ResultDTO(int resultCode, String message, Object data) {
    this(resultCode, message, data, null);
  };

  /**
   *
   * @param resultCode 返回码
   * @param message 提示信息
   * @param data 数据
   * @param subMessage 详细信息
   */
  public ResultDTO(int resultCode, String message, Object data, String subMessage) {
    this.resultCode = resultCode;
    this.message = message;
    this.data = data;
    this.subMessage = subMessage;
  };

  /**
   * @return the resultCode
   */
  public int getResultCode() {
    return resultCode;
  }

  /**
   * @param resultCode the resultCode to set
   */
  public void setResultCode(int resultCode) {
    this.resultCode = resultCode;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }


  /**
   * @return the subMessage
   */
  public String getSubMessage() {
    return subMessage;
  }

  /**
   * @param subMessage the subMessage to set
   */
  public void setSubMessage(String subMessage) {
    this.subMessage = subMessage;
  }

  /**
   * @return the data
   */
  public Object getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(Object data) {
    this.data = data;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "ResultDTO [resultCode=" + resultCode + ", message=" + message + ", subMessage=" + subMessage + ", data=" + data + "]";
  }

}
