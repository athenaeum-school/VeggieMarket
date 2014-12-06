describe 'ブログコレクションテスト', ->
	beforeEach ->
		
		@blogListView = new BlogListView()
		@blogs = [
	  	{title: 'タイトル1', message: 'メッセージ1'}
	  	{title: 'タイトル2', message: 'メッセージ2'}
	  ]
	  	
		@blogListView.collection = new BlogCollection @blogs

	afterEach ->
		###@blogListView.remove()###
		$('#blogList div').remove()
		
	it 'elテスト', ->
		expect(@blogListView.render()).toEqual @blogListView

	it 'renderテスト', ->
		@blogListView.render()
		console.log $('#blogList > div').length
		expect($ '#blogList div').toHaveClass 'view' 
		expect($ '#blogList li').toContainText 'タイトル2' 

	it 'renderBlogテスト', ->
		renderSpy = spyOn(BlogListView.prototype,'render').and.callThrough()
		renderBlogSpy = spyOn BlogListView.prototype, 'renderBlog'
		blogListView2 = new BlogListView()
		expect(renderSpy.calls.count()).toBe 1
		blogListView2.collection = new BlogCollection @blogs
		blogListView2.render()
		expect(renderBlogSpy.calls.count()).toBe 2

	it 'addBlogテスト', ->
		addBlogSpy = spyOn(BlogListView.prototype,'addBlog').and.callThrough()
		blogListView3 = new BlogListView()
		$('#add').trigger 'click'
		expect(addBlogSpy).toHaveBeenCalled()
		$('#title').val 'タイトル4'
		$('#message').val 'メッセージ4'
		$('#add').trigger 'click'
		expect($ '#blogList li').toContainText 'タイトル4'
		expect($ '#blogList li').toContainText 'メッセージ4'
