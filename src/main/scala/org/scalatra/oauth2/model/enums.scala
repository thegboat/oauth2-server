package org.scalatra
package oauth2
package model

import OAuth2Imports._

object AuthorizationType extends Enumeration("code", "token", "code_and_token") {
  val Code, Token, CodeAndToken = Value
}

object ResponseType extends Enumeration("code", "token", "code_and_token") {
  val Code, Token, CodeAndToken = Value
}

object GrantCode extends Enumeration("none", "authorization_code", "password", "client_credentials", "implicit") {
  val None, AuthorizationCode, Password, ClientCredentials, Implicit = Value

  def fromParam(code: Option[String]) = {
    val c = code.flatMap(_.blankOption) getOrElse "none"
    try {
      withName(c)
    } catch {
      case e: NoSuchElementException ⇒ GrantCode.None
    }
  }
}