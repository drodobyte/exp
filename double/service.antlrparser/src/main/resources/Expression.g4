grammar Expression;

INT : [0-9]+ ;
LP  : '(' ;
RP  : ')' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
WS  : [ \t]+ -> channel(HIDDEN);

expression :
                  LP expression RP                  # Parentheses
                | SUB expression                    # Negate
                | expression(MUL|DIV) expression    # MultiplyOrDivide
                | expression(ADD|SUB) expression    # AddOrSubtract
                | INT                               # Int
                ;


