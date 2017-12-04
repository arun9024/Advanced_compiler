import java.io.PrintWriter;
import java.util.List;
import java.util.Stack;
    
class SyntaxTreePrinter extends Visitor {
  PrintWriter _writer; 
  Stack<AstNode> _stack;

  SyntaxTreePrinter(PrintWriter writer) {
    _writer = writer;
    _stack = new Stack<AstNode>();
  }
  
  // ---------------- helper methods ---------------- 
  SyntaxTreePrinter begin(AstNode ast) {
    return begin(ast, null);
  }
  SyntaxTreePrinter begin(AstNode ast, String attr) {
    for (int i=0, n=_stack.size(); i<n; i++)
      p("  ");
    _stack.push(ast);
    p(ast.getClass().getSimpleName());
    if (null != attr)
      p(" ").p(attr);
    return pln();
  }
  // This can be used for Infix expressions.
  SyntaxTreePrinter begin(AstNode ast, String name, String attr) {
    for (int i=0, n=_stack.size(); i<n; i++)
      p("  ");
    _stack.push(ast);
    p(name);
    if (null != attr)
    {
      if (attr.length() > 0)
        p(" ").p(attr);
    }
    return pln();
  }
  SyntaxTreePrinter end(AstNode ast) {
    AstNode top = _stack.pop();
    assert top == ast; 
    return this;
  }
  
  SyntaxTreePrinter p(AstNode ast) {
    ast.accept(this);
    return this;
  }
  SyntaxTreePrinter p(String s) { 
    assert(-1 == s.indexOf('\n')); 
    _writer.print(s);
    return this;
  }
  SyntaxTreePrinter pln() {
    _writer.println();
    return this;
  }
  

  SyntaxTreePrinter p(List<? extends AstNode> astList, List<? extends InfixOp> infixList, int endIndex) {
      if (endIndex == 1) {
          begin(infixList.get(0), "InfixExpr", infixList.get(0).op());
          p(astList.get(0));
          p(astList.get(1));
          end(infixList.get(0));
      } else {
          begin(infixList.get(endIndex - 1), "InfixExpr", infixList.get(endIndex - 1).op());
          p(astList, infixList, endIndex - 1);
          p(astList.get(endIndex));
          end(infixList.get(endIndex - 1));
      }
      return this;
  }
  // Use this for printing a list of operands separated by infix operators.
  SyntaxTreePrinter p(List<? extends AstNode> astList, List<? extends InfixOp> infixList) {
        return p(astList, infixList, astList.size() - 1);
  }

  SyntaxTreePrinter p(AstNode ast, List<PrefixOp> prefixList, int startIndex) {
      if (startIndex == (prefixList.size() - 1)) {
          begin(prefixList.get(startIndex), "PrefixExpr", prefixList.get(startIndex).op());
          p(ast);
          end(prefixList.get(startIndex));
      } else {
          begin(prefixList.get(startIndex), "PrefixExpr", prefixList.get(startIndex).op());
          p(ast, prefixList, startIndex + 1);
          end(prefixList.get(startIndex));
      }
      return this;
  }

 // Use this for prining a chain of prefix operators
  SyntaxTreePrinter p(AstNode ast, List<PrefixOp> prefixList) {
        return p(ast, prefixList, 0);
  }
  
  SyntaxTreePrinter p(PrimExpr primExpr, List<CommonPostfix> inh, int endIndex) {
    if (endIndex == 0) {
      if (inh.get(endIndex)._exprList != null) begin(inh.get(endIndex)._exprList, inh.get(endIndex)._name, "");
      if (inh.get(endIndex)._type != null) begin(inh.get(endIndex)._type, inh.get(endIndex)._name, "");
      if (inh.get(endIndex)._fieldId != null) begin(inh.get(endIndex)._fieldId, inh.get(endIndex)._name, "");
      if (inh.get(endIndex)._expr != null) begin(inh.get(endIndex)._expr, inh.get(endIndex)._name, "");
	
      p(primExpr);

      if (inh.get(endIndex)._exprList != null) p(inh.get(endIndex)._exprList);
      if (inh.get(endIndex)._type != null) p(inh.get(endIndex)._type);
      if (inh.get(endIndex)._fieldId != null) p(inh.get(endIndex)._fieldId);
      if (inh.get(endIndex)._expr != null) p(inh.get(endIndex)._expr);

      if (inh.get(endIndex)._exprList != null) end(inh.get(endIndex)._exprList);
      if (inh.get(endIndex)._type != null) end(inh.get(endIndex)._type);
      if (inh.get(endIndex)._fieldId != null) end(inh.get(endIndex)._fieldId);
      if (inh.get(endIndex)._expr != null) end(inh.get(endIndex)._expr);
    } else {
      if (inh.get(endIndex)._exprList != null) begin(inh.get(endIndex)._exprList, inh.get(endIndex)._name, "");
      if (inh.get(endIndex)._type != null) begin(inh.get(endIndex)._type, inh.get(endIndex)._name, "");
      if (inh.get(endIndex)._fieldId != null) begin(inh.get(endIndex)._fieldId, inh.get(endIndex)._name, "");
      if (inh.get(endIndex)._expr != null) begin(inh.get(endIndex)._expr, inh.get(endIndex)._name, "");

      p(primExpr, inh, endIndex - 1);      
      if (inh.get(endIndex)._exprList != null) p(inh.get(endIndex)._exprList);
      if (inh.get(endIndex)._type != null) p(inh.get(endIndex)._type);
      if (inh.get(endIndex)._fieldId != null) p(inh.get(endIndex)._fieldId);
      if (inh.get(endIndex)._expr != null) p(inh.get(endIndex)._expr);

      if (inh.get(endIndex)._exprList != null) end(inh.get(endIndex)._exprList);
      if (inh.get(endIndex)._type != null) end(inh.get(endIndex)._type);
      if (inh.get(endIndex)._fieldId != null) end(inh.get(endIndex)._fieldId);
      if (inh.get(endIndex)._expr != null) end(inh.get(endIndex)._expr);
    }
    return this;
  }

  // Use this for posfix
  SyntaxTreePrinter p(PrimExpr primExpr, List<CommonPostfix> inh) {
    return p(primExpr, inh, inh.size() - 1);
  }

  // ---------------- visit methods ----------------
  Object visit(Program ast) {
    begin(ast);
    if (null != ast._raw)
      p(ast._raw);
    else
      for (FunDef f : ast._functions)
        p(f);
    return end(ast);
  }

  Object visit(FunDef ast) {
    begin(ast);
    p(ast._name);
    p(ast._type);
    p(ast._stmt);
    end(ast);
    return ast;
  }

  Object visit(FunDefListHead ast) {
    begin(ast);
    if (null != ast._first)
      p(ast._first).p(ast._tail);
    return end(ast);
  }

  Object visit(FunDefListTail ast) {
    begin(ast);
    if (null != ast._next)
      p(ast._next).p(ast._tail);
    return end(ast);
  }

  Object visit(FunId ast) {
    return begin(ast, ast._id).end(ast);
  }

  Object visit(FieldId ast) {
    return begin(ast, ast._id).end(ast);
  }

  Object visit(VarId ast) {
    return begin(ast, ast._id).end(ast);
  }

  // Literals
  Object visit(IntLit ast) {
    return begin(ast, ast._lit).end(ast);
  }

  Object visit(StringLit ast) {
    return begin(ast, ast._lit).end(ast);
  }

  Object visit(BoolLit ast) {
    return begin(ast, ast._lit).end(ast);
  }

  Object visit(NullLit ast) {
    return begin(ast).end(ast);
  }

  Object visit(ArrayLit ast) {
    begin(ast);
    p(ast._exprList);
    end(ast);
    return ast;
  }

  Object visit(RecordLit ast) {
    begin(ast);
    p(ast._fieldLitList);
    end(ast);
    return ast;
  }

  Object visit(ParenExpr ast) {
    begin(ast);
    p(ast._expr);
    end(ast);
    return ast;
  }

  Object visit(FieldLit ast) {
    begin(ast);
    p(ast._id);
    p(ast._expr);
    end(ast);
    return ast;
  }

  Object visit(FieldLitList ast) {
	if (ast._inh == null) {
		if (ast._lit != null) {
			begin(ast);
			p(ast._lit);
			p(ast._tail);
			end(ast);
		}
	} else {
      		for (FieldLit f : ast._inh)
       			 p(f);
	}
	return ast;
  }

  Object visit(FieldLitListTail ast) {
	if (ast._lit != null) {
		begin(ast);
		p(ast._lit);
		p(ast._tail);
		end(ast);
	}
	return ast;
  }

 // Primitive Types
  Object visit(IntType ast) {
    return begin(ast, ast.attr()).end(ast);
  }

  Object visit(BoolType ast) {
    return begin(ast, ast.attr()).end(ast);
  }

  Object visit(StringType ast) {
    return begin(ast, ast.attr()).end(ast);
  }

  Object visit(VoidType ast) {
    return begin(ast, ast.attr()).end(ast);
  }

  Object visit(PrimitiveType ast) {
    return begin(ast, ast.attr()).end(ast);
  }

  // Infix op
  Object visit(SumOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(SubOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(ProductOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(DivOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(ModOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(EqualOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(NotEqualOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(LessEqualOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

 Object visit(LessOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(GreatEqualOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(GreatOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(NotOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(MinusOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(OrOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(AndOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(EqOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(RelOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(AddOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(MultOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  Object visit(PrefixOp ast) {
    return begin(ast, ast.op()).end(ast);
  }
 Object visit(InfixOp ast) {
    return begin(ast, ast.op()).end(ast);
  }

  // Type
  Object visit(ArrayType ast) {
    begin(ast);
    p(ast._type);
    return end(ast);
  }

  Object visit(RecordType ast) {
    begin(ast);
    if (null != ast._raw)
    {
      p(ast._raw);
    }
    else
      for (FieldType f : ast._fields)
        p(f);
    return end(ast);
  }

  Object visit(FieldTypeList ast) {
    begin(ast);
    if (null != ast._type) {
      p(ast._type);
      p(ast._tail);
    }
    return end(ast);
  }

  Object visit(FieldTypeListTail ast) {
    begin(ast);
    if (null != ast._next) {
      p(ast._next);
      p(ast._tail);
    }
    return end(ast);
  }

  Object visit(FieldType ast) {
    begin(ast);
    p(ast._id);
    p(ast._type);
    return end(ast);
  }

  Object visit(FunType ast) {
    begin(ast);
    p(ast._rec);
    p(ast._type);
    return end(ast);
  }

Object visit(ReturnType ast) {
    if (ast._type != null) p(ast._type);
    if (ast._voidType != null) p(ast._voidType);
    return ast;
  }

  Object visit(Type ast) {
    if (ast._arr != null) p(ast._arr);
    if (ast._rec != null) p(ast._rec);
    if (ast._prim != null) p(ast._prim);
    return ast;
  }

  // Expressions
	Object visit(Expr ast) {
		if (ast._inh == null) {
			begin(ast);
			p(ast._raw);
			end(ast);
		} else {
			if (ast._inh.size() == 1) {
				// There is no || opeartor, we just have a single LogicAndExpr
				// Let's just print that
				p(ast._inh.get(0));
			} else {
				// We have more than one LogicAndExprs separated by ||,
				// Use our helper function to print them in left associative order.
				p(ast._inh, ast._infixOp);
			}
		}
		return ast;
  	}

	Object visit(LogicOrExpr ast) {
		// We will never print this in normalized form,
		// so let's ignore the case when we have inherited values in _inh, ...
		// as these values exist only after normalization.
		begin(ast);
		p(ast._andExpr);
		p(ast._tail);
		end(ast);
		return ast;
	}
	
	Object visit(LogicOrExprTail ast) {
		// This also won't be printed in normalized form, so ignore that case.
		if (ast._andExpr != null) {
			begin(ast);
			p(ast._andExpr);
			p(ast._tail);
			end(ast);
		}
		return ast;
	}
	

        Object visit(LogicAndExpr ast) {
            if (ast._inh == null) {
                begin(ast);
                p(ast._eqExpr);
                p(ast._tail);
                end(ast);
            } else {
                if (ast._inh.size() == 1) {
                    p(ast._inh.get(0));
                } else {
                    p(ast._inh, ast._infixOp);
                }
            }
            return ast;
        }
        
	
	Object visit(LogicAndExprTail ast) {
		if (ast._eqExpr != null) {
			begin(ast);
			p(ast._eqExpr);
			p(ast._tail);
			end(ast);
		}
		return ast;
	}

	Object visit(EqExpr ast) {
		if (ast._inh == null) {
			begin(ast);
			p(ast._relExpr);
			p(ast._tail);
			end(ast);
		} else {
			if (ast._inh.size() == 1) {
				p(ast._inh.get(0));
			} else {
				p(ast._inh, ast._infixOp);
			}
		}
		return ast;
	}
	
	Object visit(EqExprTail ast) {
		if (ast._relExpr != null) {
			begin(ast);
			p(ast._relExpr);
			p(ast._tail);
			end(ast);
		}
		return ast;
	}

	Object visit(RelExpr ast) {
		if (ast._inh == null) {
			begin(ast);
			p(ast._addExpr);
			p(ast._tail);
			end(ast);
		} else {
			if (ast._inh.size() == 1) {
				p(ast._inh.get(0));
			} else {
				p(ast._inh, ast._infixOp);
			}
		}
		return ast;
	}
	
	Object visit(RelExprTail ast) {
		if (ast._addExpr != null) {
			begin(ast);
			p(ast._addExpr);
			p(ast._tail);
			end(ast);
		}
		return ast;
	}

	Object visit(AddExpr ast) {
		if (ast._inh == null) {
			begin(ast);
			p(ast._multExpr);
			p(ast._tail);
			end(ast);
		} else {
			if (ast._inh.size() == 1) {
				p(ast._inh.get(0));
			} else {
				p(ast._inh, ast._infixOp);
			}
		}
		return ast;
	}
	
	Object visit(AddExprTail ast) {
		if (ast._multExpr != null) {
			begin(ast);
			p(ast._multExpr);
			p(ast._tail);
			end(ast);
		}
		return ast;
	}

	Object visit(MultExpr ast) {
		if (ast._inh == null) {
			begin(ast);
			p(ast._prefixExpr);
			p(ast._tail);
			end(ast);
		} else {
			if (ast._inh.size() == 1) {
				p(ast._inh.get(0));
			} else {
				p(ast._inh, ast._infixOp);
			}
		}
		return ast;
	}
	
	Object visit(MultExprTail ast) {
		if (ast._prefixExpr != null) {
			begin(ast);
			p(ast._prefixExpr);
			p(ast._tail);
			end(ast);
		}
		return ast;
	}

	Object visit(PrefixExpr ast) {
		if (ast._inh == null) {
			begin(ast);
			if (ast._prefixOp == null) {
				p(ast._postfixExpr);
			} else {
				begin(ast._prefixOp, "PrefixExpr", ast._prefixOp.op());
				p(ast._tail);
				end(ast._prefixOp);
			}
			end(ast);
		} else {
			if (ast._inh.size() == 0) {
				p(ast._actPostfixExpr);
			} else {
				p(ast._actPostfixExpr, ast._inh);
			}
		}
		return ast;
	}

	Object visit(CallExpr ast) {
                begin(ast);
                p(ast._id);
                p(ast._callActuals);
                end(ast);
                return ast;
        }

        Object visit(CallActuals ast) {
                p(ast._exprList);
                return ast;
        }
	
	Object visit(PrimExpr ast) {
     		if (ast._varId != null) p(ast._varId);
		if (ast._arrayLit != null) p(ast._arrayLit);
		if (ast._recordLit != null) p(ast._recordLit);
		if (ast._parenExpr != null) p(ast._parenExpr);
		if (ast._boolLit != null) p(ast._boolLit);
		if (ast._intLit != null) p(ast._intLit);
		if (ast._nullLit != null) p(ast._nullLit);
		if (ast._stringLit != null) p(ast._stringLit);
		return ast;
	}

	Object visit(ExprList ast) {
		if (ast._inh == null) {
			begin(ast);
			p(ast._expr);
			p(ast._tail);
			end(ast);
		} else {
      			for (Expr f : ast._inh)
        			p(f);
		}
		return ast;
	}

	Object visit(ExprListTail ast) {
		if (ast._expr != null) {
			begin(ast);
			p(ast._expr);
			p(ast._tail);
			end(ast);
		}
		return ast;
	}

	Object visit(PostfixExpr ast) {
		if (ast._inh == null) {
			begin(ast);
			p(ast._primExpr);
			p(ast._tail);
			end(ast);
		} else {
			if (ast._inh.size() == 0) {
				p(ast._primExpr);
			} else {
				p(ast._primExpr, ast._inh);				
			}
		}
		return ast;	
	}

	Object visit(PostfixExprTail ast) {
		if (ast._next != null) {
			begin(ast);
			if (ast._next._exprList != null) p(ast._next._exprList);
			if (ast._next._type != null) p(ast._next._type);
			if (ast._next._fieldId != null) p(ast._next._fieldId);
			if (ast._next._expr != null) p(ast._next._expr);
			p(ast._tail);
			end(ast);
		}
		return ast;
	}

// Statements
        Object visit(VarDef ast) {
            begin(ast);
            p(ast._id);
            p(ast._expr);
            end(ast);
            return ast;
        }

        Object visit(AssignStmt ast) {
            begin(ast);
            p(ast._expr1);
            p(ast._expr2);
            end(ast);
            return ast;
        }

        Object visit(CallStmt ast) {
            begin(ast);
            p(ast._callExpr);
            end(ast);
            return ast;
        }

  Object visit(StmtList ast) {
        if (ast._inh == null) {
                if (ast._stmt != null) {
                        begin(ast);
                        p(ast._stmt);
                        p(ast._tail);
                        end(ast);
                }
        } else {
                for (Stmt f : ast._inh)
                         p(f);
        }
        return ast;
  }

Object visit(StmtListTail ast) {
        if (ast._stmt != null) {
                begin(ast);
                p(ast._stmt);
                p(ast._tail);
                end(ast);
        }
        return ast;
  }

  Object visit(BlockStmt ast) {
    begin(ast);
    p(ast._stmtList);
    end(ast);
    return ast;
  }

  Object visit(ForStmt ast) {
    begin(ast);
    p(ast._id);
    p(ast._expr);
    p(ast._blockStmt);
    end(ast);
    return ast;
  }

  Object visit(WhileStmt ast) {
    begin(ast);
    p(ast._expr);
    p(ast._blockStmt);
    end(ast);
    return ast;
  }

 Object visit(IfStmt ast) {
    begin(ast);
    if (ast._expr1 != null) {
        p(ast._expr1);
        p(ast._blockStmt1);
        p(ast._blockStmt2);
    } else {
        p(ast._expr2);
        p(ast._blockStmt3);
    } end(ast);
   
    return ast;
  }

  Object visit(ReturnStmt ast) {
    begin(ast);
    if (ast._expr != null)
        p(ast._expr);

    end(ast);

    return ast;
  }

        Object visit(Stmt ast) {
                if (ast._varDef != null) p(ast._varDef);
                if (ast._assignStmt != null) p(ast._assignStmt);
                if (ast._blockStmt != null) p(ast._blockStmt);
                if (ast._callStmt != null) p(ast._callStmt);
                if (ast._forStmt != null) p(ast._forStmt);
                if (ast._ifStmt != null) p(ast._ifStmt);
                if (ast._returnStmt != null) p(ast._returnStmt);
                if (ast._whileStmt != null) p(ast._whileStmt);
                return ast;
        }

  //Tester
  Object visit(Tester ast) {
    begin(ast);
    p(ast._raw);
    return end(ast);
  }
}

