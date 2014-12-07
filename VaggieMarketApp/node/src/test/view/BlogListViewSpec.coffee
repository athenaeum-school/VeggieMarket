describe 'BlogListViewテスト', ->
	beforeEach ->
		@addBlogSpy = spyOn(BlogListView.prototype,'addBlog').and.callThrough()
		@blog = new Blog()
		@blog.save
			title: 'タイトル仮'
			message: 'メッセージ仮'
		@blogListView = new BlogListView()
	  
	afterEach ->
		###@blogListView.remove()###
		@blog.destroy()

	it 'elテスト', ->
		expect(@blogListView.render()).toEqual @blogListView

	it 'renderテスト', ->
		@blogListView.render()
		expect($ '#blogList div').toHaveClass 'view' 
		expect($ '#blogList li').toContainText 'タイトル仮' 

	it 'renderBlogテスト', ->
		renderSpy = spyOn(BlogListView.prototype,'render').and.callThrough()
		renderBlogSpy = spyOn BlogListView.prototype, 'renderBlog'
		blogListView2 = new BlogListView()
		expect(renderSpy.calls.count()).toBe 1
		blogListView2.collection = new BlogCollection @blogs
		blogListView2.render()
		expect(renderBlogSpy.calls.count()).toBe 2

	it 'addBlogテスト', ->
		$('#add').trigger 'click'
		expect(@addBlogSpy).toHaveBeenCalled()
		$('#title').val 'タイトル4'
		$('#message').val 'メッセージ4'
		$('#add').trigger 'click'
		expect($ '#blogList li').not.toContainText 'タイトル4'
		expect($ '#blogList li').not.toContainText 'メッセージ4'
		$('.delete').trigger 'click'