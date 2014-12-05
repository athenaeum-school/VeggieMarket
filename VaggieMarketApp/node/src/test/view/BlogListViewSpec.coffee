describe 'ブログコレクションテスト', ->
	beforeEach ->
	  @blogListView = new BlogListView()

	it 'elテスト', ->
		expect(@blogListView.render()).toEqual @blogListView
		expect(@blogListView.collection).toEqual new BlogCollection()
		console.log @blogListView.el