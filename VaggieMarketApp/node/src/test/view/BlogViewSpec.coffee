describe 'BlogViewTest', ->
	beforeEach ->
		@blog = new Blog
			title: 'ブログ'
			message: 'メッセージ'
		@blogView = new BlogView
			model: @blog 

	it 'ビューのオブジェクトを返す', ->
		expect(@blogView.render()).toEqual @blogView

	it 'elテスト', ->
		expect(@blogView.el.tagName.toLowerCase()).toEqual 'div'
		expect(@blogView.$el).toHaveClass 'blogContainer'
		@blogView.render()
		expect(@blogView.el).toContainElement 'div.view'
		expect(@blogView.el).toContainElement 'ul'
		expect(@blogView.el).toContainElement 'li'
		expect($(@blogView.el).children()).toHaveLength(1)
		expect(@blogView.el).toContainHtml '<li>ブログ</li>'
		expect(@blogView.el).toContainHtml '<li>メッセージ</li>'