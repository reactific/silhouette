/**
 * Copyright 2015 Mohiva Organisation (license at mohiva dot com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mohiva.silhouette.util

import java.security.MessageDigest
import java.util.Base64

import play.api.libs.json.JsValue

/**
 * Cryptography helper.
 */
object Crypto {

  /**
   * Creates a SHA1 hash from the given string.
   *
   * @param str The string to create a hash from.
   * @return The SHA1 hash of the string.
   */
  def sha1(str: String): String = sha1(str.getBytes("UTF-8"))

  /**
   * Creates a SHA1 hash from the given byte array.
   *
   * @param bytes The bytes to create a hash from.
   * @return The SHA1 hash of the bytes.
   */
  def sha1(bytes: Array[Byte]): String = {
    MessageDigest.getInstance("SHA-1").digest(bytes).map("%02x".format(_)).mkString
  }

  def encryptAES(str: String): String = str

  def decryptAES(str: String): String = str

  /**
   * Decodes a Base64 string.
   *
   * @param str The string to decode.
   * @return The decoded string.
   */
  def decodeBase64(str: String): String = new String(Base64.getDecoder.decode(str), "UTF-8")

  /**
   * Encodes a string as Base64.
   *
   * @param str The string to encode.
   * @return The encodes string.
   */
  def encodeBase64(str: String): String = Base64.getEncoder.encodeToString(str.getBytes("UTF-8"))

  /**
   * Encodes a Json value as Base64.
   *
   * @param json The json value to encode.
   * @return The encoded value.
   */
  def encodeBase64(json: JsValue): String = encodeBase64(json.toString())
}
