package org.csystem.samples.passdatatootheractivity

import java.io.Serializable

data class UserInfo(val fullname: String, val username: String, val email: String, val isFemale: Boolean) : Serializable
