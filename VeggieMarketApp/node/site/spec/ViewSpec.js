describe("ビューテスト", function() {
	afterEach(function(){
	});
	it("spec1", function() {
		spyOn(BlogListView.prototype,'render')/*.and.callThrough()*/;
		spyOn(BlogListView.prototype,'renderBlog');
		var blog3 = new Blog();
		var blogListView = new BlogListView(blog3);
		expect(blogListView.render).toHaveBeenCalled();

	});
	
	it("spec2", function(){
		spyOn(BlogListView.prototype,'addBlog');
		var blogListView = new BlogListView({title:"aaa",message:"abc"});
		$('#add').trigger('click');
		expect(blogListView.addBlog).toHaveBeenCalled();
	});

	it("spec3", function() {
		var blogListView = new BlogListView();
		$('#title').val('タイトル');
		$('#message').val('メッセージ');
		/*$('#add').trigger('click');*/
		$('#title').val('');
		$('#message').val('');

	});
});
