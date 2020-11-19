parser grammar TextExpParser;

options {
    tokenVocab = TextExpLexer;
    language = Java;
}

root :  expression ((AND | OR) expression)+ | expression EOF | STAR EOF;

expression :
        leftExpr = expression operator = (AND | OR) rightExpr = expression                      # binaryExpression
        | NOT expression                                                                        # notExpression
        | LPAREN expression RPAREN                                                              # rparenExpression
        | WORD                                                                                  # singleWordExpression
        | ROLE_WORD                                                                             # roleWordExpression
        | (WORD | ROLE_WORD) ((AFTER) (WORD | ROLE_WORD))+                                      # afterWordExpression
;