package cn.shmilyms.chainablesql.util;

import java.util.Collection;

import cn.shmilyms.chainablesql.components.IComponent;
public class Utilities {
	public static StringBuilder mergeStrings(Collection<String> strings,String seperator,StringBuilder sb) {
		int count = 0;
		int size = strings.size();
		for (String string : strings) {
			count += 1;
			sb.append(string);
			if (count<size)
				sb.append(seperator);
		}
		return sb;
	}
	
	
	public static StringBuilder mergeStrings(Collection<String> strings,String seperator) {
		
		return mergeStrings(strings,seperator,new StringBuilder());
	}
	
	
	
	public enum BooleanOperator implements IComponent{
		AND,OR;

		@Override
		public void appendToBuilder(StringBuilder sb) {
			// TODO Auto-generated method stub
			sb.append(this.toString());
		}
	}
	public enum CompOperator implements IComponent{
		GT(">"),GE(">="),LT("<"),LE("<="),EQ("="),NE("!=");
		
		private String sqlOperator;
		CompOperator(String sqlOperator) {
			this.sqlOperator=sqlOperator;
		}
		@Override
		public void appendToBuilder(StringBuilder sb) {
			// TODO Auto-generated method stub
			sb.append(this.sqlOperator);
		}
	}
	public enum SqlOrders implements IComponent{
		ASC,DESC;

		@Override
		public void appendToBuilder(StringBuilder sb) {
			// TODO Auto-generated method stub
			sb.append(this.toString());
		}
		
	}
}
