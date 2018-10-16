注册用户：
post  /user/register

参数：
{
		username: "ldx",
		sex: "男",
		age: 18,
		password: 123
		telephone: 10086
		email: Ldixing@163.com
		
}

返回：
{
	code: 0,
	message: "成功"
	"data": {
		
	}
}


好友列表：
post  /friend/list
	参数：
	{
		email: Ldixing@163.com
	}
	返回：
	{
		code:0,
		message:成功,
		{
			pages:3,
			[
				{
					friendEmail:
					remarks:
					createtime:
				}
				...
			]
		}
	}
	
	
增加团队：
post  /team/create

	参数：
	{
		taskname:
		userEmail:
		description:
		startTime:
		endTime:
	}
	返回：
	{
		code:0
		message:成功
		{
			taskname:
			progress:
			substackNumber:
			userEmail:
			description:
			status:
			startTime:
			endTime:
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	