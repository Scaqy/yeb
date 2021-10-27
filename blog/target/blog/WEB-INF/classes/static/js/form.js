$(".ui form")
		.form({
			on: 'blur',
			fields: {
				username: {
					identifier: 'username',
					rules: [
						{
							type: 'empty',
							prompt: '用户名不能为空',
						},
						{
							type: 'minLength[6]',
							prompt: '用户名长度在6~15位数之间'
						},
						{
							type: 'maxLength[15]',
							prompt: '用户名长度在6~15位数之间'
						}
					]
				},
				password: {
					identifier: 'password',
					rules: [
						{
							type: 'empty',
							prompt: '密码不能为空',
						},
						{
							type: 'minLength[6]',
							prompt: '密码长度在6~15位数之间'
						},
						{
							type: 'maxLength[15]',
							prompt: '密码长度在6~15位数之间'
						}
					]
				},
				match: {
					identifier: 'passwordconfirm',
					rules: [
						{
							type: 'match[password]',
							prompt: '密码不一致，请重新输入'
						}
					]
				},
				email: {
					identifier: 'email',
					rules: [
						{
							type : 'empty',
							prompt : '邮箱不能为空'
						},
						{
							type : 'email',
							prompt : '邮箱格式错误，请重新输入'
						}	
					]
				},
				phone: {
					identifier: 'phone',
					rules: [
						{
							type : 'minLength[11]',
							prompt: '电话号码输入错误'
						},
						{
							type: 'maxLength[11]',
							prompt: '电话号码错误,请重新输入'
						}
					]
				}
			}
		});