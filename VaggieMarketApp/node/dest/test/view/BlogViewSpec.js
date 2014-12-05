describe('BlogViewTest', function() {
  beforeEach(function() {
    this.blog = new Blog({
      title: 'ブログ',
      message: 'メッセージ'
    });
    return this.blogView = new BlogView({
      model: this.blog
    });
  });
  it('ビューのオブジェクトを返す', function() {
    return expect(this.blogView.render()).toEqual(this.blogView);
  });
  return it('elテスト', function() {
    expect(this.blogView.el.tagName.toLowerCase()).toEqual('div');
    expect(this.blogView.$el).toHaveClass('blogContainer');
    this.blogView.render();
    expect(this.blogView.el).toContainElement('div.view');
    expect(this.blogView.el).toContainElement('ul');
    expect(this.blogView.el).toContainElement('li');
    expect($(this.blogView.el).children()).toHaveLength(1);
    expect(this.blogView.el).toContainHtml('<li>ブログ</li>');
    return expect(this.blogView.el).toContainHtml('<li>メッセージ</li>');
  });
});
