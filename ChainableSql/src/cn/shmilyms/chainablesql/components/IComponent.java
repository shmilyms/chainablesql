package cn.shmilyms.chainablesql.components;

public interface IComponent {

	
	public void appendToBuilder(StringBuilder sb);
	
	public default String toSql() {
		StringBuilder sb = new StringBuilder();
		appendToBuilder(sb);
		return sb.toString();
	}
	public default String toFinishedSql() {
		StringBuilder sb = new StringBuilder();
		appendToBuilder(sb);
		sb.append(";");
		return sb.toString();
	}
}
