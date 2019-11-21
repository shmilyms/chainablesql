README
===========================
Chainable sql - turn sql into chainable functions. Currently working in progress.

Code Example: 

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
