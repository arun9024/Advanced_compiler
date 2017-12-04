import java.util.*;
      
//see aho_et_al_2007 Figure 5.13 (Page 321)
class TreeNormalizer extends Visitor {
  Object visit(Program ast) {
    @SuppressWarnings("unchecked")
      List<FunDef> functions = (List<FunDef>)ast._raw.accept(this);
    ast._functions = functions;
    ast._raw = null;
    return ast;
  }   
    
  Object visit(FunDef ast) {
    ast._name = (FunId)ast._name.accept(this);
    ast._type = (FunType)ast._type.accept(this);
    ast._stmt = (BlockStmt)ast._stmt.accept(this);
    return ast;
  }
    
  Object visit(FunDefListHead ast) {
    List<FunDef> result = new ArrayList<FunDef>();
    if (null == ast._first)
      return result;
    result.add((FunDef)ast._first.accept(this));
    ast._tail._inh = result;
    return ast._tail.accept(this);
  }
  Object visit(FunDefListTail ast) {
    if (null == ast._next)
      return ast._inh;
    ast._inh.add((FunDef)ast._next.accept(this));
    ast._tail._inh = ast._inh;
    return ast._tail.accept(this);
  }
    
  Object visit(FunId ast) {
    return ast;
  } 
  
  Object visit(FieldId ast) {
    return ast;
  } 
    
  Object visit(VarId ast) {
    return ast;
  }

  // literals
  Object visit(StringLit ast) {
    return ast;
  } 
    
  Object visit(IntLit ast) {
    return ast;
  }

  Object visit(BoolLit ast) {
    return ast;
  }

  Object visit(NullLit ast) {
    return ast;
  }

  Object visit(ArrayLit ast) {
    ast._exprList.accept(this);
    return ast;
  }

  Object visit(RecordLit ast) {
    ast._fieldLitList.accept(this);
    return ast;
  }

  Object visit(ParenExpr ast) {
    ast._expr.accept(this);
    return ast;
  }

  Object visit(FieldLit ast) {
    ast._id.accept(this);
    ast._expr.accept(this);
    return ast;
  }

  Object visit(FieldLitList ast) {
    ast._inh = new ArrayList<FieldLit>();
    if (ast._lit == null)
      return ast;

    ast._inh.add((FieldLit) ast._lit.accept(this));
    ast._tail._inh = ast._inh;
    ast._tail.accept(this);
    return ast;
  }

  Object visit(FieldLitListTail ast) {
    if (ast._lit == null)
      return ast;

    ast._inh.add((FieldLit) ast._lit.accept(this));
    ast._tail._inh = ast._inh;
    ast._tail.accept(this);
    return ast;
  }

  // primitive types
  Object visit(IntType ast) {
    return ast;
  } 

  Object visit(BoolType ast) {
    return ast;
  }

  Object visit(StringType ast) {
    return ast;
  }

  Object visit(VoidType ast) {
    return ast;
  }

  Object visit(PrimitiveType ast) {
    return ast;
  }

  // Infix Op
  Object visit(SumOp ast) {
    return ast;
  }

  Object visit(SubOp ast) {
    return ast;
  }

  Object visit(ProductOp ast) {
    return ast;
  }

  Object visit(DivOp ast) {
    return ast;
  }
  Object visit(ModOp ast) {
    return ast;
  }

  Object visit(EqualOp ast) {
    return ast;
  }

  Object visit(NotEqualOp ast) {
    return ast;
  }

  Object visit(LessEqualOp ast) {
    return ast;
  }

 Object visit(LessOp ast) {
    return ast;
  }

  Object visit(GreatEqualOp ast) {
    return ast;
  }

  Object visit(GreatOp ast) {
    return ast;
  }

  Object visit(NotOp ast) {
    return ast;
  }

  Object visit(MinusOp ast) {
    return ast;
  }

  Object visit(OrOp ast) {
    return ast;
  }

  Object visit(AndOp ast) {
    return ast;
  }

  Object visit(EqOp ast) {
    return ast;
  }

  Object visit(RelOp ast) {
    return ast;
  }

  Object visit(AddOp ast) {
    return ast;
  }

  Object visit(MultOp ast) {
    return ast;
  }

  Object visit(PrefixOp ast) {
    return ast;
  }

  Object visit(InfixOp ast) {
    return ast;
  }

 // Type
  Object visit(ArrayType ast) {
    ast._type.accept(this);
    return ast;
  }

  Object visit(RecordType ast) {
    @SuppressWarnings("unchecked")
      List<FieldType> fields = (List<FieldType>)ast._raw.accept(this);
    ast._fields = fields;
    ast._raw = null;
    return ast;
  }

  Object visit(FieldTypeList ast) {
    List<FieldType> fields = new ArrayList<FieldType>();
    if (null == ast._type)
      return fields;
    fields.add((FieldType)ast._type.accept(this));
    ast._tail._inh = fields;
    return ast._tail.accept(this);
  }

  Object visit(FieldTypeListTail ast) {
    if (null == ast._next)
      return ast._inh;
    ast._inh.add((FieldType)ast._next.accept(this));
    ast._tail._inh = ast._inh;
    return ast._tail.accept(this);
  }

  Object visit(FieldType ast) {
    ast._id.accept(this);
    ast._type.accept(this);
    return ast;
  }

  Object visit(FunType ast) {
    ast._rec.accept(this);
    ast._type.accept(this);
    return ast;
  }

  Object visit(ReturnType ast) {
    if (ast._type != null) ast._type.accept(this);
    if (ast._voidType != null) ast._voidType.accept(this);
    return ast;
  }

  Object visit(Type ast) {
    if (ast._arr != null) ast._arr.accept(this);
    if (ast._rec != null) ast._rec.accept(this);
    if (ast._prim != null) ast._prim.accept(this);
    return ast;
  }

	// Expressions

	// This one is a bit different because Expr is the same as
	// LogicOrExpr, so we just everything copy from children.
	// The rules after this one follow a pattern.
	Object visit(Expr ast) {
    		//@SuppressWarnings("unchecked")

		// Call the child's accept method, so that it gets its
		// inherited values from its subtree.
		ast._raw.accept(this);

		// Copy the list from children
		ast._inh = ast._raw._inh;
		ast._infixOp = ast._raw._infixOp;

		return ast;
  	}   
    
	Object visit(LogicOrExpr ast) {
		// Create the lists.
		ast._inh = new ArrayList<LogicAndExpr>();
		ast._infixOp = new ArrayList<OrOp>();

		// Add the head LogicAndExpr into the list
		// We do not have any operator to add in the list
		// (number of operators is one less than number of operands).
		// Note that, we have to do the typecasting, because accept() returns Object.
		ast._inh.add((LogicAndExpr) ast._andExpr.accept(this));

		// Set the children's list, so that they can put the data there
		ast._tail._inh = ast._inh;
		ast._tail._infixOp = ast._infixOp;

		// Call the child's accept method, so that they fill up the data.
		ast._tail.accept(this);
	
		return ast;	
	}
	
	Object visit(LogicOrExprTail ast) {
		// Nothing to do, return.
		if (ast._andExpr == null)	
			return ast;

		// Tail doesn't need to create a list, because the list was
		// already created by parent and assigned.
		// So we just need to add elements in the list.

		// Add the current element.
		ast._inh.add((LogicAndExpr) ast._andExpr.accept(this));
		ast._infixOp.add((OrOp) ast._orOp.accept(this));

		// Set the child's lists
		ast._tail._inh = ast._inh;
		ast._tail._infixOp = ast._infixOp;

		// Call the child's accept method, so that they fill up the data.
		ast._tail.accept(this);
	
		return ast;	
	}
	
	Object visit(LogicAndExpr ast) {
		ast._inh = new ArrayList<EqExpr>();
		ast._infixOp = new ArrayList<AndOp>();

		ast._inh.add((EqExpr) ast._eqExpr.accept(this));

		ast._tail._inh = ast._inh;
		ast._tail._infixOp = ast._infixOp;

		ast._tail.accept(this);
		return ast;	
	}
	
	Object visit(LogicAndExprTail ast) {
		if (ast._eqExpr == null)	
			return ast;

		ast._inh.add((EqExpr) ast._eqExpr.accept(this));
		ast._infixOp.add((AndOp) ast._andOp.accept(this));

		ast._tail._inh = ast._inh;
		ast._tail._infixOp = ast._infixOp;

		ast._tail.accept(this);
		return ast;	
	}

	Object visit(EqExpr ast) {
		ast._inh = new ArrayList<RelExpr>();
		ast._infixOp = new ArrayList<EqOp>();

		ast._inh.add((RelExpr) ast._relExpr.accept(this));

		ast._tail._inh = ast._inh;
		ast._tail._infixOp = ast._infixOp;

		ast._tail.accept(this);
		return ast;	
	}
	
	Object visit(EqExprTail ast) {
		if (ast._relExpr == null)	
			return ast;

		ast._inh.add((RelExpr) ast._relExpr.accept(this));
		ast._infixOp.add((EqOp) ast._eqOp.accept(this));

		ast._tail._inh = ast._inh;
		ast._tail._infixOp = ast._infixOp;

		ast._tail.accept(this);
		return ast;	
	}

	Object visit(RelExpr ast) {
		ast._inh = new ArrayList<AddExpr>();
		ast._infixOp = new ArrayList<RelOp>();

		ast._inh.add((AddExpr) ast._addExpr.accept(this));

		ast._tail._inh = ast._inh;
		ast._tail._infixOp = ast._infixOp;

		ast._tail.accept(this);
		return ast;	
	}
	
	Object visit(RelExprTail ast) {
		if (ast._addExpr == null)	
			return ast;

		ast._inh.add((AddExpr) ast._addExpr.accept(this));
		ast._infixOp.add((RelOp) ast._relOp.accept(this));

		ast._tail._inh = ast._inh;
		ast._tail._infixOp = ast._infixOp;

		ast._tail.accept(this);
		return ast;	
	}

	Object visit(AddExpr ast) {
		ast._inh = new ArrayList<MultExpr>();
		ast._infixOp = new ArrayList<AddOp>();

		ast._inh.add((MultExpr) ast._multExpr.accept(this));

		ast._tail._inh = ast._inh;
		ast._tail._infixOp = ast._infixOp;

		ast._tail.accept(this);
		return ast;	
	}
	
	Object visit(AddExprTail ast) {
		if (ast._multExpr == null)	
			return ast;

		ast._inh.add((MultExpr) ast._multExpr.accept(this));
		ast._infixOp.add((AddOp) ast._addOp.accept(this));

		ast._tail._inh = ast._inh;
		ast._tail._infixOp = ast._infixOp;

		ast._tail.accept(this);
		return ast;	
	}

	Object visit(MultExpr ast) {
		ast._inh = new ArrayList<PrefixExpr>();
		ast._infixOp = new ArrayList<MultOp>();

		ast._inh.add((PrefixExpr) ast._prefixExpr.accept(this));

		ast._tail._inh = ast._inh;
		ast._tail._infixOp = ast._infixOp;

		ast._tail.accept(this);
		return ast;	
	}
	
	Object visit(MultExprTail ast) {
		if (ast._prefixExpr == null)	
			return ast;

		ast._inh.add((PrefixExpr) ast._prefixExpr.accept(this));
		ast._infixOp.add((MultOp) ast._multOp.accept(this));

		ast._tail._inh = ast._inh;
		ast._tail._infixOp = ast._infixOp;

		ast._tail.accept(this);
		return ast;	
	}

	Object visit(PrefixExpr ast) {
		if (ast._inh == null)
			ast._inh = new ArrayList<PrefixOp>();

		if (ast._prefixOp == null) {
			ast._actPostfixExpr = (PostfixExpr) ast._postfixExpr.accept(this);
			return ast;
		}

		ast._inh.add((PrefixOp) ast._prefixOp.accept(this));
		ast._tail._inh = ast._inh;

		ast._tail.accept(this);
		ast._actPostfixExpr = ast._tail._actPostfixExpr;

		return ast;
	}

	Object visit(CallExpr ast) {
                ast._id.accept(this);
                ast._callActuals.accept(this);
                return ast;
        }

        Object visit(CallActuals ast) {
                ast._exprList.accept(this);
                return ast;
        }

	Object visit(PrimExpr ast) {
		if (ast._varId != null) ast._varId.accept(this);
		if (ast._arrayLit != null) ast._arrayLit.accept(this);
		if (ast._recordLit != null) ast._recordLit.accept(this);
		if (ast._parenExpr != null) ast._parenExpr.accept(this);
		if (ast._boolLit != null) ast._boolLit.accept(this);
		if (ast._intLit != null) ast._intLit.accept(this);
		if (ast._nullLit != null) ast._nullLit.accept(this);
		if (ast._stringLit != null) ast._stringLit.accept(this);
		return ast;
	}

	Object visit(ExprList ast) {
		ast._inh = new ArrayList<Expr>();
		ast._inh.add((Expr) ast._expr.accept(this));
		ast._tail._inh = ast._inh;
		ast._tail.accept(this);
		return ast;
	}

	Object visit(ExprListTail ast) {
		if (ast._expr == null)
			return ast;

		ast._inh.add((Expr) ast._expr.accept(this));
		ast._tail._inh = ast._inh;
		ast._tail.accept(this);
		return ast;
	}

	Object visit(PostfixExpr ast) {
		ast._inh = new ArrayList<CommonPostfix>();
		ast._primExpr.accept(this);
		
		ast._tail._inh = ast._inh;

		ast._tail.accept(this);
		return ast;
	}

 	Object visit(PostfixExprTail ast) {
		if (ast._next == null)
			return ast;
		
		if (ast._next._exprList != null) ast._next._exprList = (ExprList) ast._next._exprList.accept(this);
		if (ast._next._type != null) ast._next._type = (Type) ast._next._type.accept(this);
		if (ast._next._fieldId != null) ast._next._fieldId = (FieldId) ast._next._fieldId.accept(this);
		if (ast._next._expr != null) {ast._next._expr = (Expr) ast._next._expr.accept(this); }

		ast._inh.add(ast._next);

		ast._tail._inh = ast._inh;
		ast._tail.accept(this);

		return ast;
	}

	       // Statements
        Object visit(VarDef ast) {
            ast._id.accept(this);
            ast._expr.accept(this);
            return ast;
        }

        Object visit(AssignStmt ast) {
            ast._expr1.accept(this);
            ast._expr2.accept(this);
            return ast;
        }

        Object visit(CallStmt ast) {
            ast._callExpr.accept(this);
            return ast;
        }

        Object visit(StmtList ast) {
                ast._inh = new ArrayList<Stmt>();
                 if (ast._stmt == null)
                return ast;

         ast._inh.add((Stmt) ast._stmt.accept(this));
           ast._tail._inh = ast._inh;
         ast._tail.accept(this);
         return ast;
        }

        Object visit(StmtListTail ast) {
        if (ast._stmt == null)
        return ast;

        ast._inh.add((Stmt) ast._stmt.accept(this));
        ast._tail._inh = ast._inh;
        ast._tail.accept(this);
        return ast;
        }

 Object visit(BlockStmt ast) {
    ast._stmtList.accept(this);
    return ast;
  }

  Object visit(ForStmt ast) {
    ast._id.accept(this);
    ast._expr.accept(this);
    ast._blockStmt.accept(this);
    return ast;
  }

  Object visit(WhileStmt ast) {
    ast._expr.accept(this);
    ast._blockStmt.accept(this);
    return ast;
  }


        Object visit(IfStmt ast) {
            if (ast._expr1 != null) {
            ast._expr1.accept(this);
            ast._blockStmt1.accept(this);
            ast._blockStmt2.accept(this);
            } else {
            ast._expr2.accept(this);
            ast._blockStmt3.accept(this);
            }

            return ast;
        }

        Object visit(ReturnStmt ast) {
            if (ast._expr != null)
            ast._expr.accept(this);

            return ast;
        }

       Object visit(Stmt ast) {
                if (ast._varDef != null) ast._varDef.accept(this);
                if (ast._assignStmt != null) ast._assignStmt.accept(this);
                if (ast._blockStmt != null) ast._blockStmt.accept(this);
                if (ast._callStmt != null) ast._callStmt.accept(this);
                if (ast._forStmt != null) ast._forStmt.accept(this);
                if (ast._ifStmt != null) ast._ifStmt.accept(this);
                if (ast._returnStmt != null) ast._returnStmt.accept(this);
                if (ast._whileStmt != null) ast._whileStmt.accept(this);
                return ast;
        }


         Object visit(Tester ast) {
                ast._raw.accept(this);
                return ast;
        }
}


