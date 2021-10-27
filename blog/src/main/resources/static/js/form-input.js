$('.ui.form')
    .form({
        on: 'blur',
        fields: {
            title: {
                identifier: 'title',
                rules: [
                    {
                        type: 'empty',
                        prompt: '标题:标题不能为空'
                    }
                ]
            },
            content: {
                identifier: 'content',
                rules: [
                    {
                        type: 'empty',
                        prompt: '内容:内容不能为空'
                    }
                ]
            },
            blogimage: {
                identifier: 'blogimage',
                rules: [
                    {
                        type: 'empty',
                        prompt: '首图:首图引用地址不能为空'
                    }
                ]
            }
        }
    })