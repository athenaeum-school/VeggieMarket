describe 'BlogViewTest', ->
	beforeEach ->
	  @blogView = new BlogView()

	it 'ビューのオブジェクトを返す', ->
		expect(@blogView.render()).toEqual @blogView

	it 'elテスト', ->
		expect(@blogView.el.tagName.toLowerCase()).toEqual 'div'
		expect(@blogView.$el).toHaveClass 'blogContainer'
		@blogView.render()
		expect(@blogView.el.innerHTML).toHaveClass 'view'