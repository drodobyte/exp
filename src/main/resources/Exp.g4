grammar Exp;

prog:	exp EOF ;
exp:	exp ('*'|'/') exp   # mulOrDiv
    |	exp ('+'|'-') exp   # addOrSub
    |	'-' exp             # neg
    |	INT                 # num
    |	'(' exp ')'         # par
    ;

WS : [ \t\r\n]+ -> skip;
INT     : [0-9]+ ;
