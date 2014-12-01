package just4fun.core.xpression.test

import System.{currentTimeMillis => now, nanoTime => nnow}
import Predef.{println => prn, _}
import just4fun.core.xpression._

object Test1 extends App {

	class Tab extends Table[Tab] {
		val c0 = newProp(0, "c0", StringType)
		val c1 = newProp(1, "c1", IntType)
		val c2 = newProp(2, "c2", FloatType)
		val c3 = newProp(3, "c3", BooleanType)
	}
	val tab = new Tab
	import tab._
	import XNode._

	var expr: XNode = null
	//
	//	expr = 1 + c1 / 2 * c3 - (1 - c2)
	//	prn(s"= ${expr.toExpression(4) }")
	//	// CONCAT, LIKE, CAST
	//	expr = c0 +| "bla" === "_bla" || (c2 + 5).toStr() =| "$$$" && c0 =| "ba"
	//	prn(s"= ${expr.toExpression() }")
	//	// NOT
	//	expr = !(c3 + 2 === 0)
	//	prn(s"= ${expr.toExpression() }")
	//	// IN, NOT IN
	//	expr = !c1.in(1, 2, 3) && ("bla_" +| c0).in("a", "b", "c")
	//	prn(s"= ${expr.toExpression(1) }")
	//	// IS NULL, IS NOT NULL
	//	expr = c1 === null && c3 ==! null
	//	prn(s"= ${expr.toExpression() }")
	//	// NOT IN,  BETWEEN, NOT BETWEEN
	//	expr = !(c0 =| "bla") || !c2.between(0.5, 5.5) && (!c3.in(1, 2, 3) || c2.notBetween(1.1, 1.2))
	//	prn(s"= ${expr.toExpression(1) }")
	//	// CASE WHEN THAN ELSE
	//	expr = "try_" +| when_s()((c0 =| "bla", "?1"))() +| "ok"
	//	prn(s"= ${expr.toExpression(1) }")
	//	expr = when_s(c0 +| "bla")(("bla", "?1"), ("hla", "?2"))("???")
	//	prn(s"= ${expr.toExpression(1) }")
	//	expr = 100 - when_n(c0 +| "bla")(("bla", 1), ("hla", 2))(3) * 5
	//	prn(s"= ${expr.toExpression(1) }")
	//	//



	def test(times: Int = 1)(code: => Unit) = {
		val t = nnow
		for (n <- 0 until times) code
		prn(s"TIME= ${(nnow - t) / times.toDouble} ns")
	}

	test(1) {
	}

	def testTuple(tpl: (Int, String)) = { prn(s"int= ${tpl._1}   str=${tpl._2}") }
	testTuple((100, "ko"))
	// TODO WOW!!!
	testTuple(100, "ko")

	def put(n: java.lang.Long) = prn(s"Long=$n")
	def put(n: java.lang.Double) = prn(s"Double=$n")
	def put(n: java.lang.Float) = prn(s"Float=$n")
	def put(n: java.lang.Integer) = prn(s"Float=$n")

	def get(): Long = 111L

	put(1L: java.lang.Float)
//	put(1)
//	put(get)
//	put(1D)
//	put(1F)


}


