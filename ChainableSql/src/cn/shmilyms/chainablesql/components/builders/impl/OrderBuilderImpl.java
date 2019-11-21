package cn.shmilyms.chainablesql.components.builders.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.shmilyms.chainablesql.components.builders.IOrderBuilder;
import cn.shmilyms.chainablesql.util.Utilities.SqlOrders;

public class OrderBuilderImpl implements IOrderBuilder {
	private Map<String,SqlOrders> columns = new LinkedHashMap<>();
	@Override
	public StringBuilder toSql(StringBuilder sb) {
		// TODO Auto-generated method stub
		
		boolean first = true;
		for (Map.Entry<String,SqlOrders> entry : columns.entrySet()) {
			if (!first) sb.append(", ");
			sb.append(entry.getKey());
			sb.append(" ");
			entry.getValue().toSql(sb);
			
				
			first = false;
		}
		
		return sb;
	}

	@Override
	public IOrderBuilder orderBy(String column) {
		// TODO Auto-generated method stub
		columns.put(column, SqlOrders.ASC);
		return this;
	}

	@Override
	public IOrderBuilder orderBy(String... columns) {
		// TODO Auto-generated method stub
		for (String column : columns){
			orderBy(column);
		}
		return this;
	}

	@Override
	public IOrderBuilder orderBy(String column, SqlOrders order) {
		// TODO Auto-generated method stub
		columns.put(column,order);
		return this;
	}

}
