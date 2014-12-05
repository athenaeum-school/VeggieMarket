describe('BlogViewTest', function() {
  beforeEach(function() {
    return this.blogView = new BlogView();
  });
  it('ビューのオブジェクトを返す', function() {
    return expect(this.blogView.render()).toEqual(this.blogView);
  });
  return it('elテスト', function() {
    expect(this.blogView.el.tagName.toLowerCase()).toEqual('div');
    expect(this.blogView.$el).toHaveClass('blogContainer');
    this.blogView.render();
    return expect(this.blogView.el.innerHTML).toHaveClass('view');
  });
});
