package cn.shmilyms.chainablesql.components.builders.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.shmilyms.chainablesql.components.IComponent;
import cn.shmilyms.chainablesql.components.builders.IBooleanBuilder;
import cn.shmilyms.chainablesql.components.builders.IConditionBuilder;
import cn.shmilyms.chainablesql.util.Utilities.BooleanOperator;

public class ConditionBuilderImpl implements IConditionBuilder{
	List<IComponent> conditions;
	List<BooleanOperator> operators;
	
	public ConditionBuilderImpl() {
		conditions = new ArrayList<>();
		operators = new ArrayList<>();
	}
	@Override
	public void appendToBuilder(StringBuilder sb) {
		// TODO Auto-generated method stub
		Iterator<IComponent> ci = conditions.iterator();
		Iterator<BooleanOperator> bi = operators.iterator();
		
		sb.append(" WHERE ");
		if (ci.hasNext()) {
			sb.append("(");
			sb.append(ci.next().toSql());
			sb.append(")");
			bi.next();
			while(bi.hasNext()) {
				sb.append(" ");
				sb.append(bi.next().toSql());
				sb.append(" (");
				sb.append(ci.next().toSql());
				sb.append(")");
			}
		}
		
	}
	
	@Override
	public IConditionBuilder and(String... conditions) {
		// TODO Auto-generated method stub
		for (String condition : conditions){
			this.conditions.add(new CustomCondition(condition));
			this.operators.add(BooleanOperator.AND);
		}
		return this;
	}

	@Override
	public IConditionBuilder or(String... conditions) {
		// TODO Auto-generated method stub
		for (String condition : conditions){
			this.conditions.add(new CustomCondition(condition));
			this.operators.add(BooleanOperator.OR);
		}
		return this;
	}
	
	public static final String not(String condition) {
		return "NOT("+condition+")";
	}
	public static final IBooleanBuilder not(IBooleanBuilder condition) {
		return condition.not();
	}
	private class CustomCondition implements IComponent{
		String condition;
		CustomCondition(String condition){
			this.condition=condition;
		}
		@Override
		public void appendToBuilder(StringBuilder sb) {
			// TODO Auto-generated method stub
			sb.append(condition);
		}
		
	}
	@Override
	public IConditionBuilder and(IBooleanBuilder... conditions) {
		// TODO Auto-generated method stub
		for (IBooleanBuilder condition : conditions) {
			this.conditions.add(condition);
			this.operators.add(BooleanOperator.AND);
		}
		return this;
	}
	@Override
	public IConditionBuilder or(IBooleanBuilder... conditions) {
		// TODO Auto-generated method stub
		for (IBooleanBuilder condition : conditions) {
			this.conditions.add(condition);
			this.operators.add(BooleanOperator.OR);
		}
		return this;
	}
}
