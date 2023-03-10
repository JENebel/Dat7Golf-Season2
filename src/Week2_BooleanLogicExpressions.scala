object Week2_BooleanLogicExpressions extends App {
  sealed abstract class BoolExp
  case object TrueLiteral extends BoolExp
  case object FalseLiteral extends BoolExp
  case class NotLogicGate(booleanExpression: BoolExp) extends BoolExp
  case class AndLogicGate(leftHandSide: BoolExp, rightHandSide: BoolExp) extends BoolExp
  case class OrLogicGate(leftHandSide: BoolExp, rightHandSide: BoolExp) extends BoolExp
  case class XorLogicGate(leftHandSide: BoolExp, rightHandSide: BoolExp) extends BoolExp

  def evaluateExpression(boolExp: BoolExp): Boolean = {
    // Lasses 173 char løsning. Skrevet lidt pænere
    lazy val f:Any⇒Boolean={
      case NotLogicGate(b)⇒ !f(b)
      case AndLogicGate(l,r)⇒f(l)&f(r)
      case OrLogicGate(l,r)⇒f(l)|f(r)
      case XorLogicGate(l,r)⇒f(l)^f(r)
      case n⇒n.## %2<0
    }
    f(boolExp)
  }

  // Vejledende test
  assert( evaluateExpression(AndLogicGate(TrueLiteral, TrueLiteral)))
  assert(!evaluateExpression(AndLogicGate(FalseLiteral, TrueLiteral)))
  assert( evaluateExpression(OrLogicGate(TrueLiteral, FalseLiteral)))
  assert(!evaluateExpression(OrLogicGate(FalseLiteral, FalseLiteral)))
  assert( evaluateExpression(XorLogicGate(TrueLiteral, FalseLiteral)))
  assert(!evaluateExpression(XorLogicGate(TrueLiteral, TrueLiteral)))
  assert(!evaluateExpression(NotLogicGate(TrueLiteral)))
  assert( evaluateExpression(NotLogicGate(FalseLiteral)))

  assert(evaluateExpression(
    AndLogicGate(
      OrLogicGate(
        NotLogicGate(TrueLiteral),
        XorLogicGate(
          AndLogicGate(TrueLiteral, FalseLiteral),
          NotLogicGate(FalseLiteral)
        )
      ),
      OrLogicGate(
        XorLogicGate(
          FalseLiteral,
          OrLogicGate(FalseLiteral, TrueLiteral)
        ),
        AndLogicGate(
          TrueLiteral,
          AndLogicGate(
            TrueLiteral,
            OrLogicGate(FalseLiteral, TrueLiteral)
          )
        )
      )
    )
  ))

  assert(!evaluateExpression(
    XorLogicGate(
      OrLogicGate(
        XorLogicGate(
          OrLogicGate(
            NotLogicGate(TrueLiteral),
            XorLogicGate(
              AndLogicGate(TrueLiteral, FalseLiteral),
              NotLogicGate(FalseLiteral)
            )
          ),
          OrLogicGate(FalseLiteral, TrueLiteral)
        ),
        AndLogicGate(
          TrueLiteral,
          AndLogicGate(
            TrueLiteral,
            OrLogicGate(FalseLiteral, TrueLiteral)
          )
        )
      ),
      TrueLiteral
    )
  ))

  assert(!evaluateExpression(
    AndLogicGate(
      OrLogicGate(TrueLiteral, TrueLiteral),
      AndLogicGate(
        OrLogicGate(
          AndLogicGate(
            TrueLiteral,
            OrLogicGate(
              XorLogicGate(TrueLiteral, FalseLiteral),
              FalseLiteral
            )
          ),
          XorLogicGate(
            TrueLiteral,
            XorLogicGate(
              NotLogicGate(NotLogicGate(FalseLiteral)),
              NotLogicGate(TrueLiteral)
            )
          )
        ),
        NotLogicGate(
          XorLogicGate(
            OrLogicGate(
              TrueLiteral,
              OrLogicGate(TrueLiteral, FalseLiteral)
            ),
            AndLogicGate(
              XorLogicGate(
                NotLogicGate(TrueLiteral),
                FalseLiteral
              ),
              AndLogicGate(FalseLiteral, TrueLiteral)
            )
          )
        )
      )
    )
  ))

  println("All tests passed succesfully!")
}
