lexer grammar TextExpLexer;

//左括号
LPAREN : '(';
//右括号
RPAREN : ')';
//与
AND : '&';
//或
OR : '|';
//非
NOT : '!';
//近
AFTER: '#';

ROLE_WORD : UPPERCASE '-' WORD;

// 匹配中文字符 英文字符和数字
WORD : [\u4e00-\u9fa5_a-zA-Z]+;

// 匹配数字
INT : [0-9]+;

STAR : '*';

UPPERCASE: [A-Z];

// 跳过空白字符
WS : [ \t\n\r]+ -> skip;
