package cn.shmilyms.chainablesql.util;

import static cn.shmilyms.chainablesql.components.builders.impl.BooleanBuilderImpl.expr;
import static cn.shmilyms.chainablesql.components.builders.impl.ConditionBuilderImpl.not;

import cn.shmilyms.chainablesql.components.builders.ISqlBuilder;
import cn.shmilyms.chainablesql.components.builders.impl.SqlBuilderImpl;
import cn.shmilyms.chainablesql.util.Utilities.CompOperator;
import cn.shmilyms.chainablesql.util.Utilities.SqlOrders;
import junit.framework.TestCase;
public class Test extends TestCase{

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		ISqlBuilder sb = new SqlBuilderImpl();
		String sql = sb
				.select("user")
				.select("DOB").alias("birthday")
				.from(sb
						.select("user")
						.select("sales")
						.select("DOB")
						.select("VIP")
						.select("vipExpired")
						.from("users")
						.where("VIP = 1")
						.and("DOB != NULL")
						.and(expr(CompOperator.GE,"sales","10000000"),not(expr(CompOperator.EQ,"vipExpired","1"))))
				.orderBy("birthday", SqlOrders.DESC)
				.finishSql();

		System.out.println(sql);
		
		//SELECT user, DOB AS birthday FROM (SELECT user, sales, DOB, VIP, vipExpired FROM users WHERE (VIP = 1) AND (DOB != NULL) AND (sales >= 10000000) AND (NOT(vipExpired = 1)));

	}

}