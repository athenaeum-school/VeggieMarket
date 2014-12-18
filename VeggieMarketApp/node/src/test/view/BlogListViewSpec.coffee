describe 'BlogListViewテスト', ->
	beforeEach ->
		@addBlogSpy = spyOn(BlogListView.prototype,'addBlog').and.callThrough()
		@blogListView = new BlogListView()
		@renderSpy = spyOn(BlogListView.prototype,'render').and.callThrough()
		@renderBlogSpy = spyOn(BlogListView.prototype, 'renderBlog').and.callThrough()
	  
	afterEach ->
		###@blogListView.remove()###
		$('.delete').trigger 'click'

	it 'renderテスト', ->
		expect(@blogListView.render()).toEqual @blogListView

	it 'renderBlogテスト', ->
		@blogListView.collection.create new Blog()
		@blogListView.render()
		expect(@renderSpy.calls.count()).toBe 1
		expect(@renderBlogSpy.calls.count()).toBe 1

	it 'addBlogテスト', ->
		$('#add').trigger 'click'
		expect(@addBlogSpy).toHaveBeenCalled()
		$('#title').val 'タイトル4'
		$('#message').val 'メッセージ4'
		$('#add').trigger 'click'
		console.log @blogListView
		expect($ '#blogList li').toContainText 'タイトル4'
		expect($ '#blogList li').toContainText 'メッセージ4'
		