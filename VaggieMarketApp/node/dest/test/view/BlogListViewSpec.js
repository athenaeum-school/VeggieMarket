describe('ブログコレクションテスト', function() {
  beforeEach(function() {
    this.blogListView = new BlogListView();
    this.blogs = [
      {
        title: 'タイトル1',
        message: 'メッセージ1'
      }, {
        title: 'タイトル2',
        message: 'メッセージ2'
      }
    ];
    return this.blogListView.collection = new BlogCollection(this.blogs);
  });
  afterEach(function() {

    /*@blogListView.remove() */
    return $('#blogList div').remove();
  });
  it('elテスト', function() {
    return expect(this.blogListView.render()).toEqual(this.blogListView);
  });
  it('renderテスト', function() {
    this.blogListView.render();
    console.log($('#blogList > div').length);
    expect($('#blogList div')).toHaveClass('view');
    return expect($('#blogList li')).toContainText('タイトル2');
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
    var addBlogSpy, blogListView3;
    addBlogSpy = spyOn(BlogListView.prototype, 'addBlog').and.callThrough();
    blogListView3 = new BlogListView();
    $('#add').trigger('click');
    expect(addBlogSpy).toHaveBeenCalled();
    $('#title').val('タイトル4');
    $('#message').val('メッセージ4');
    $('#add').trigger('click');
    expect($('#blogList li')).toContainText('タイトル4');
    return expect($('#blogList li')).toContainText('メッセージ4');
  });
});
