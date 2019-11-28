package cn.shmilyms.chainablesql.components.builders.impl;

import cn.shmilyms.chainablesql.components.IAliasListener;
import cn.shmilyms.chainablesql.components.IComponent;
import cn.shmilyms.chainablesql.components.builders.IBooleanBuilder;
import cn.shmilyms.chainablesql.components.builders.IColumnBuilder;
import cn.shmilyms.chainablesql.components.builders.IConditionBuilder;
import cn.shmilyms.chainablesql.components.builders.IOrderBuilder;
import cn.shmilyms.chainablesql.components.builders.ISelectBuilder;
import cn.shmilyms.chainablesql.util.Utilities.SqlOrders;

public class SelectBuilderImpl implements ISelectBuilder {
	
	private IColumnBuilder cbuilder;
	private IConditionBuilder whereBuilder;
	private IOrderBuilder obuilder;
	
	private IComponent from;
	private IAliasListener aliasListener;
	
	@Override
	public void appendToBuilder(StringBuilder sb) {
		// TODO Auto-generated method stub
		sb.append("SELECT ");
		cbuilder.appendToBuilder(sb);
		sb.append(" FROM ");
		
		if (from!=null) {
			
			from.appendToBuilder(sb);
		}
			
		if (whereBuilder!=null) {
			
			whereBuilder.appendToBuilder(sb);
		}
		if (obuilder!=null) {
			
			obuilder.appendToBuilder(sb);
		}
	}

	@Override
	public ISelectBuilder select(String column) {
		// TODO Auto-generated method stub
		if (cbuilder==null)
			cbuilder=new ColumnBuilderImpl();
		cbuilder.column(column);
		aliasListener=cbuilder;
		return this;
	}

	@Override
	public ISelectBuilder select(String... columns) {
		// TODO Auto-generated method stub
		if (cbuilder==null)
			cbuilder=new ColumnBuilderImpl();
		cbuilder.columns(columns);
		aliasListener=cbuilder;
		return this;
	}

	@Override
	public ISelectBuilder alias(String alias) {
		// TODO Auto-generated method stub
		if (aliasListener == null) {
			
		}
		else
			aliasListener.listen(alias);
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
		AliasStringWrapper wrapper = new AliasStringWrapper(table);
		this.from = wrapper;
		this.aliasListener = wrapper;
		return this;
	}

	@Override
	public ISelectBuilder from(ISelectBuilder builder) {
		// TODO Auto-generated method stub
		AliasSubSelectWrapper wrapper = new AliasSubSelectWrapper(builder);
		this.from = wrapper;
		aliasListener = wrapper;
		return this;
	}

	@Override
	public ISelectBuilder where(String condition) {
		// TODO Auto-generated method stub
		if (whereBuilder==null) 
			whereBuilder = new ConditionBuilderImpl();
		whereBuilder.and(condition);
		return this;
	}

	@Override
	public ISelectBuilder and(String... conditions) {
		// TODO Auto-generated method stub
		whereBuilder.and(conditions);
		return this;
	}

	@Override
	public ISelectBuilder or(String... conditions) {
		// TODO Auto-generated method stub
		whereBuilder.or(conditions);
		return this;
	}

	@Override
	public ISelectBuilder and(IBooleanBuilder... conditions) {
		// TODO Auto-generated method stub
		whereBuilder.and(conditions);
		return this;
	}

	@Override
	public ISelectBuilder or(IBooleanBuilder... conditions) {
		// TODO Auto-generated method stub
		whereBuilder.or(conditions);
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

	private class AliasStringWrapper implements IComponent,IAliasListener{
		String table;
		String alias;
		AliasStringWrapper(String table){
			this.table=table;
		}
		@Override
		public void listen(String alias) {
			// TODO Auto-generated method stub
			this.alias = alias;
		}

		@Override
		public void appendToBuilder(StringBuilder sb) {
			// TODO Auto-generated method stub
			sb.append(table);
			if (alias!=null) {
				sb.append(" ");
				sb.append(alias);
			}
		}
		
	}
	private class AliasSubSelectWrapper implements IComponent,IAliasListener{
		IComponent builder;
		String alias;
		AliasSubSelectWrapper(IComponent builder){
			this.builder=builder;
		}
		@Override
		public void listen(String alias) {
			// TODO Auto-generated method stub
			this.alias = alias;
		}

		@Override
		public void appendToBuilder(StringBuilder sb) {
			// TODO Auto-generated method stub
			sb.append("(");
			builder.appendToBuilder(sb);
			sb.append(")");
			if (alias!=null) {
				sb.append(" ");
				sb.append(alias);
			}
			else
				;
		}
		
	}

}
