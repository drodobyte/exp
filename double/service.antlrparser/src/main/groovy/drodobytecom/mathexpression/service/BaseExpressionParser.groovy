package drodobytecom.mathexpression.service

import drodobytecom.mathexpression.service.gen.ExpressionBaseListener
import drodobytecom.mathexpression.service.gen.ExpressionLexer
import drodobytecom.mathexpression.service.gen.ExpressionParser
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import org.antlr.v4.runtime.tree.ParseTreeWalker

abstract class BaseExpressionParser {

    protected abstract void number(ExpressionParser.IntContext ctx)

    protected abstract void addOrSubtract(ExpressionParser.AddOrSubtractContext ctx)

    protected abstract void multiplyOrDivide(ExpressionParser.MultiplyOrDivideContext multiplyOrDivideContext)

    protected abstract void parentheses(ExpressionParser.ParenthesesContext parenthesesContext)

    protected abstract void negate(ExpressionParser.NegateContext negateContext)

    protected abstract void error(RecognitionException e)

    final protected def parseAndListen(String expression) {
        def lexer = createLexerFromExpression expression
        def parser = createParser lexer
        parseAndListenWith parser, lexer
    }

    private static def createLexerFromExpression(String expression) {
        new ExpressionLexer(new ANTLRInputStream(expression))
    }

    private static def createParser(ExpressionLexer lexer) {
        new ExpressionParser(new CommonTokenStream(lexer))
    }

    private def parseAndListenWith(ExpressionParser parser, ExpressionLexer lexer) {
        def listener = new Listener()
        lexer.removeErrorListeners()
        parser.removeErrorListeners()
        lexer.addErrorListener listener
        parser.addErrorListener listener
        new ParseTreeWalker().walk listener, parser.expression()
    }

    private class Listener extends ExpressionBaseListener implements ANTLRErrorListener {

        @Override
        final void exitInt(ExpressionParser.IntContext ctx) {
            number ctx
        }

        @Override
        final void exitAddOrSubtract(ExpressionParser.AddOrSubtractContext ctx) {
            addOrSubtract ctx
        }

        @Override
        final void exitMultiplyOrDivide(ExpressionParser.MultiplyOrDivideContext ctx) {
            multiplyOrDivide ctx
        }

        @Override
        final void exitParentheses(ExpressionParser.ParenthesesContext ctx) {
            parentheses ctx
        }

        @Override
        final void exitNegate(ExpressionParser.NegateContext ctx) {
            negate ctx
        }

        @Override
        final void syntaxError(
                Recognizer<?, ?> recognizer, Object symbol, int line, int pos, String msg, RecognitionException e) {
            error(e)
        }


        @Override
        final void reportAmbiguity(Parser recognizer,
                                   DFA dfa, int startIndex, int stopIndex, boolean exact,
                                   BitSet ambigAlts, ATNConfigSet configs) {
        }

        @Override
        final void reportAttemptingFullContext(Parser recognizer,
                                               DFA dfa, int startIndex, int stopIndex,
                                               BitSet conflictingAlts, ATNConfigSet configs) {
        }

        @Override
        final void reportContextSensitivity(Parser recognizer,
                                            DFA dfa, int startIndex, int stopIndex,
                                            int prediction, ATNConfigSet configs) {
        }
    }
}