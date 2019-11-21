package cn.shmilyms.chainablesql.components.builders.impl;

import cn.shmilyms.chainablesql.components.Column;
import cn.shmilyms.chainablesql.components.IComponent;
import cn.shmilyms.chainablesql.components.builders.IBooleanBuilder;
import cn.shmilyms.chainablesql.components.builders.IColumnBuilder;
import cn.shmilyms.chainablesql.components.builders.IConditionBuilder;
import cn.shmilyms.chainablesql.components.builders.IOrderBuilder;
import cn.shmilyms.chainablesql.components.builders.ISelectBuilder;
import cn.shmilyms.chainablesql.util.Utilities.SqlOrders;

public class SelectBuilderImpl implements ISelectBuilder {
	
	private IColumnBuilder cbuilder;
	private IConditionBuilder cobuilder;
	private IOrderBuilder obuilder;
	private IComponent from;
	@Override
	public StringBuilder toSql(StringBuilder sb) {
		// TODO Auto-generated method stub
		sb.append("SELECT ");
		cbuilder.toSqlWithAlias(sb);
		sb.append(" FROM ");
		
		if (from instanceof ISelectBuilder) {
			sb.append("(");
			from.toSql(sb);
			sb.append(")");
		}
		else
			from.toSql(sb);
		if (cobuilder!=null) {
			sb.append(" WHERE ");
			cobuilder.toSql(sb);
		}
		if (obuilder!=null) {
			sb.append(" ORDER BY ");
			obuilder.toSql(sb);
		}
		return sb;
	}

	@Override
	public ISelectBuilder select(String column) {
		// TODO Auto-generated method stub
		if (cbuilder==null)
			cbuilder=new ColumnBuilderImpl();
		cbuilder.column(column);
		return this;
	}

	@Override
	public ISelectBuilder select(String... columns) {
		// TODO Auto-generated method stub
		if (cbuilder==null)
			cbuilder=new ColumnBuilderImpl();
		cbuilder.columns(columns);
		return this;
	}

	@Override
	public ISelectBuilder alias(String alias) {
		// TODO Auto-generated method stub
		if (cbuilder!=null)
			cbuilder.alias(alias);
		return this;
	}
	@Override
	public ISelectBuilder select(String column, String alias) {
		// TODO Auto-generated method stub
		if (cbuilder==null)
			cbuilder=new ColumnBuilderImpl();
		cbuilder.column(column,alias);
		return this;
	}

	@Override
	public ISelectBuilder from(String table) {
		// TODO Auto-generated method stub
		this.from = new Column(table);
		return this;
	}

	@Override
	public ISelectBuilder from(ISelectBuilder builder) {
		// TODO Auto-generated method stub
		this.from = builder;
		return this;
	}

	@Override
	public ISelectBuilder where(String condition) {
		// TODO Auto-generated method stub
		if (cobuilder==null) 
			cobuilder = new ConditionBuilderImpl();
		cobuilder.and(condition);
		return this;
	}

	@Override
	public ISelectBuilder and(String... conditions) {
		// TODO Auto-generated method stub
		cobuilder.and(conditions);
		return this;
	}

	@Override
	public ISelectBuilder or(String... conditions) {
		// TODO Auto-generated method stub
		cobuilder.or(conditions);
		return this;
	}

	@Override
	public ISelectBuilder and(IBooleanBuilder... conditions) {
		// TODO Auto-generated method stub
		cobuilder.and(conditions);
		return this;
	}

	@Override
	public ISelectBuilder or(IBooleanBuilder... conditions) {
		// TODO Auto-generated method stub
		cobuilder.or(conditions);
		return this;
	}

	@Override
	public ISelectBuilder orderBy(String column) {
		// TODO Auto-generated method stub
		if (obuilder==null) {
			obuilder = new OrderBuilderImpl();
		}
		obuilder.orderBy(column);
		return this;
	}

	@Override
	public ISelectBuilder orderBy(String... columns) {
		// TODO Auto-generated method stub
		if (obuilder==null) {
			obuilder = new OrderBuilderImpl();
		}
		obuilder.orderBy(columns);
		return this;
	}

	@Override
	public ISelectBuilder orderBy(String column, SqlOrders order) {
		// TODO Auto-generated method stub
		if (obuilder==null) {
			obuilder = new OrderBuilderImpl();
		}
		obuilder.orderBy(column,order);
		return this;
	}



}
