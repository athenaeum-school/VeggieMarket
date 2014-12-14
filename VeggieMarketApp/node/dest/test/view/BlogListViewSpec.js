describe('BlogListViewテスト', function() {
  beforeEach(function() {
    this.addBlogSpy = spyOn(BlogListView.prototype, 'addBlog').and.callThrough();
    this.blogListView = new BlogListView();
    this.renderSpy = spyOn(BlogListView.prototype, 'render').and.callThrough();
    return this.renderBlogSpy = spyOn(BlogListView.prototype, 'renderBlog').and.callThrough();
  });
  afterEach(function() {

    /*@blogListView.remove() */
    return $('.delete').trigger('click');
  });
  it('renderテスト', function() {
    return expect(this.blogListView.render()).toEqual(this.blogListView);
  });
  it('renderBlogテスト', function() {
    this.blogListView.collection.create(new Blog());
    this.blogListView.render();
    expect(this.renderSpy.calls.count()).toBe(1);
    return expect(this.renderBlogSpy.calls.count()).toBe(1);
  });
  return it('addBlogテスト', function() {
    $('#add').trigger('click');
    expect(this.addBlogSpy).toHaveBeenCalled();
    $('#title').val('タイトル4');
    $('#message').val('メッセージ4');
    $('#add').trigger('click');
    console.log(this.blogListView);
    expect($('#blogList li')).toContainText('タイトル4');
    return expect($('#blogList li')).toContainText('メッセージ4');
  });
});
