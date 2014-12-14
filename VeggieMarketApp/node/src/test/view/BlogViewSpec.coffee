describe 'BlogViewTest', ->
	beforeEach ->
		@deleteBlogSpy = spyOn(BlogView.prototype,'deleteBlog').and.callThrough()
		@removeSpy = spyOn(BlogView.prototype, 'remove').and.callThrough()
		@editSpy = spyOn(BlogView.prototype,'edit').and.callThrough()
		@saveBlogSpy = spyOn(BlogView.prototype, 'saveBlog').and.callThrough()
		@closeSpy = spyOn(BlogView.prototype,'close').and.callThrough()

		@blog = new Blog()
		@blog.save
			title: 'ブログ'
			message: 'メッセージ'
		@blogView = new BlogView
			model: @blog 

	afterEach ->
		$('#blogList div').remove()
		@blog.destroy()


	it 'ビューのオブジェクトを返す', ->
		expect(@blogView.render()).toEqual @blogView

	it 'elテスト', ->
		expect(@blogView.$el).toHaveClass 'blogContainer'
		@blogView.render()
		expect(@blogView.el).toContainElement 'div.view'
		expect(@blogView.el).toContainElement 'ul'
		expect(@blogView.el).toContainElement 'li'
		expect(@blogView.el.tagName.toLowerCase()).toEqual 'div'
		expect(@blogView.el).toContainHtml '<li>ブログ</li>'
		expect(@blogView.el).toContainHtml '<li>メッセージ</li>'

	it 'deleteBlogテスト', ->
		$('#blogList').append @blogView.render().el
		$('.delete').trigger 'click'
		expect(@deleteBlogSpy.calls.count()).toBe 1
		expect($('.view')).not.toExist()

	it 'removeテスト', ->
		@blogView.model.destroy()
		expect(@removeSpy.calls.count()).toBe 1
	  
	it 'editテスト', ->
		$('#blogList').append @blogView.render().el
		$('.view').trigger 'dblclick'
		expect(@editSpy.calls.count()).toBe 1
		expect($('#blogList > div')).toHaveClass 'editing'
		expect($('[name="title"]')).toBeFocused() 

	it '編集ボタンを押すと編集画面になる', ->
		$('#blogList').append @blogView.render().el
		$('.editbutton').trigger 'click'
		expect(@editSpy.calls.count()).toBe 1
	  
	it '編集を終了を押すとデータが更新する', ->
		$('#blogList').append @blogView.render().el
		$('.editbutton').trigger 'click'
		$('[name="title"]').val 'ブログ更新'
		$('[name="message"]').val 'メッセージ更新'
		$('[name="save"]').trigger 'click'
		expect(@saveBlogSpy.calls.count()).toBe 1
		expect($('#blogList > div')).not.toHaveClass 'editing'
		expect($('div.view li')).toContainText 'ブログ更新'
		expect($('div.view li')).toContainText 'メッセージ更新'

	it 'キャンセルを押すとデータが更新されないで編集が終了する', ->
		$('#blogList').append @blogView.render().el
		$('.editbutton').trigger 'click'
		$('[name="title"]').val 'ブログ更新'
		$('[name="message"]').val 'メッセージ更新'
		$('[name="cancel"]').trigger 'click'
		expect(@closeSpy.calls.count()).toBe 1
		expect($('#blogList > div')).not.toHaveClass 'editing'
		expect($('div.view li')).not.toContainText 'ブログ更新'
		expect($('div.view li')).not.toContainText 'メッセージ更新'