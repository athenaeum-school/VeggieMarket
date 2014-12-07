describe('BlogListViewテスト', function() {
  beforeEach(function() {
    this.addBlogSpy = spyOn(BlogListView.prototype, 'addBlog').and.callThrough();
    this.blog = new Blog();
    this.blog.save({
      title: 'タイトル仮',
      message: 'メッセージ仮'
    });
    return this.blogListView = new BlogListView();
  });
  afterEach(function() {

    /*@blogListView.remove() */
    return this.blog.destroy();
  });
  it('elテスト', function() {
    return expect(this.blogListView.render()).toEqual(this.blogListView);
  });
  it('renderテスト', function() {
    this.blogListView.render();
    expect($('#blogList div')).toHaveClass('view');
    return expect($('#blogList li')).toContainText('タイトル仮');
  });
  it('renderBlogテスト', function() {
    var blogListView2, renderBlogSpy, renderSpy;
    renderSpy = spyOn(BlogListView.prototype, 'render').and.callThrough();
    renderBlogSpy = spyOn(BlogListView.prototype, 'renderBlog');
    blogListView2 = new BlogListView();
    expect(renderSpy.calls.count()).toBe(1);
    blogListView2.collection = new BlogCollection(this.blogs);
    blogListView2.render();
    return expect(renderBlogSpy.calls.count()).toBe(2);
  });
  return it('addBlogテスト', function() {
    $('#add').trigger('click');
    expect(this.addBlogSpy).toHaveBeenCalled();
    $('#title').val('タイトル4');
    $('#message').val('メッセージ4');
    $('#add').trigger('click');
    expect($('#blogList li')).not.toContainText('タイトル4');
    expect($('#blogList li')).not.toContainText('メッセージ4');
    return $('.delete').trigger('click');
  });
});
