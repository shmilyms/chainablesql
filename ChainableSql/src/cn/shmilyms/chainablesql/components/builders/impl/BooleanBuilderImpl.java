package cn.shmilyms.chainablesql.components.builders.impl;

import cn.shmilyms.chainablesql.components.builders.IBooleanBuilder;
import cn.shmilyms.chainablesql.util.Utilities.CompOperator;

public class BooleanBuilderImpl implements IBooleanBuilder {
	String param1;
	String param2;
	CompOperator op;
	boolean not = false;
	@Override
	public StringBuilder toSql(StringBuilder sb) {
		// TODO Auto-generated method stub
		if (not) {
			sb.append("NOT(");
			toSqlAppend(sb);
			sb.append(")");
		}
		else
			toSqlAppend(sb);
		return sb;
	}
	private StringBuilder toSqlAppend(StringBuilder sb) {
		sb.append(param1);
		sb.append(" ");
		sb.append(op.toSql());
		sb.append(" ");
		sb.append(param2);
		return sb;
	}
	
	BooleanBuilderImpl(CompOperator op, String param1, String param2) {
		// TODO Auto-generated method stub
		this.op=op;
		this.param1=param1;
		this.param2=param2;
	}
	@Override
	public IBooleanBuilder not() {
		// TODO Auto-generated method stub
		not=!not;
		return this;
	}
	public static IBooleanBuilder expr(CompOperator op, String param1, String param2) {
		return new BooleanBuilderImpl(op,param1,param2);
		
	}

}
