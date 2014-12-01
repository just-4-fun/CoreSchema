package project.config.logging

object Logger {
	val VERBOSE = 2
	val DEBUG = 3
	val INFO = 4
	val WARN = 5
	val ERROR = 6

	val tagRoot = ""
	val debug = true

	/** The only def to re-implement  */
	private def log(level: Int, msg: String, tag: LogTag = null) = {
		println(if (tag == null) s"[$tag] ::  $msg" else msg)
	}


	def logv(method: => String, msg: => String = null)(implicit tag: LogTag = null) = if (debug) {
		val what = if (msg == null) method else s"[$method] :: $msg"
		log(VERBOSE, what, tag)
	}
	def logd(method: => String, msg: => String = null)(implicit tag: LogTag = null) = if (debug) {
		val what = if (msg == null) method else s"[$method] :: $msg"
		log(DEBUG, what, tag)
	}
	def logi(method: => String, msg: => String = null)(implicit tag: LogTag = null) = if (debug) {
		val what = if (msg == null) method else s"[$method] :: $msg"
		log(INFO, what, tag)
	}
	def logw(method: => String, msg: => String = null)(implicit tag: LogTag = null) = if (debug) {
		val what = if (msg == null) method else s"[$method] :: $msg"
		log(WARN, what, tag)
	}
	def loge(error: => Throwable = null, msg: => String = null)(implicit tag: LogTag = null) = if (debug) {
		val what = (if (msg == null) "" else msg) + (if (error == null) "" else "\n"+ error.getStackTraceString)
		log(ERROR, what, tag)
	}


	/* CLASSES */

	trait Loggable {
		implicit lazy val TAG = LogTag(this)
	}

	case class LogTag(thisOrName: AnyRef) {
		val name = thisOrName match {
			case s: String => s
			case _ => thisOrName.getClass.getSimpleName
		}
	}

}