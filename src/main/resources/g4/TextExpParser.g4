parser grammar TextExpParser;

options {
    tokenVocab = TextExpLexer;
    language = Java;
}

root :  expression | STAR EOF;

expression :
        NOT expression                                                                          # notExpression
        | LPAREN expression RPAREN                                                              # rparenExpression
        | leftExpr = expression operator = (AND | OR) rightExpr = expression                    # binaryExpression
        | WORD                                                                                  # singleWordExpression
        | ROLE_WORD                                                                             # roleWordExpression
        | afterword                                                                             # afterWordExpression
;

afterword :
       (WORD | ROLE_WORD) ((AFTER) (WORD | ROLE_WORD))+                   # defaultDistanceAfter
       |  (WORD | ROLE_WORD) ((AFTER) (WORD | ROLE_WORD))+ (AFTER) (INT)  # distanceAfter
;
