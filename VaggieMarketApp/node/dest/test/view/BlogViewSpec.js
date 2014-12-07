describe('BlogViewTest', function() {
  beforeEach(function() {
    this.deleteBlogSpy = spyOn(BlogView.prototype, 'deleteBlog').and.callThrough();
    this.removeSpy = spyOn(BlogView.prototype, 'remove').and.callThrough();
    this.editSpy = spyOn(BlogView.prototype, 'edit').and.callThrough();
    this.saveBlogSpy = spyOn(BlogView.prototype, 'saveBlog').and.callThrough();
    this.closeSpy = spyOn(BlogView.prototype, 'close').and.callThrough();
    this.blog = new Blog();
    this.blog.save({
      title: 'ブログ',
      message: 'メッセージ'
    });
    return this.blogView = new BlogView({
      model: this.blog
    });
  });
  afterEach(function() {
    $('#blogList div').remove();
    return this.blog.destroy();
  });
  it('ビューのオブジェクトを返す', function() {
    return expect(this.blogView.render()).toEqual(this.blogView);
  });
  it('elテスト', function() {
    expect(this.blogView.$el).toHaveClass('blogContainer');
    this.blogView.render();
    expect(this.blogView.el).toContainElement('div.view');
    expect(this.blogView.el).toContainElement('ul');
    expect(this.blogView.el).toContainElement('li');
    expect(this.blogView.el.tagName.toLowerCase()).toEqual('div');
    expect(this.blogView.el).toContainHtml('<li>ブログ</li>');
    return expect(this.blogView.el).toContainHtml('<li>メッセージ</li>');
  });
  it('deleteBlogテスト', function() {
    $('#blogList').append(this.blogView.render().el);
    $('.delete').trigger('click');
    expect(this.deleteBlogSpy.calls.count()).toBe(1);
    return expect($('.view')).not.toExist();
  });
  it('removeテスト', function() {
    this.blogView.model.destroy();
    return expect(this.removeSpy.calls.count()).toBe(1);
  });
  it('editテスト', function() {
    $('#blogList').append(this.blogView.render().el);
    $('.view').trigger('dblclick');
    expect(this.editSpy.calls.count()).toBe(1);
    expect($('#blogList > div')).toHaveClass('editing');
    return expect($('[name="title"]')).toBeFocused();
  });
  it('編集ボタンを押すと編集画面になる', function() {
    $('#blogList').append(this.blogView.render().el);
    $('.editbutton').trigger('click');
    return expect(this.editSpy.calls.count()).toBe(1);
  });
  it('編集を終了を押すとデータが更新する', function() {
    $('#blogList').append(this.blogView.render().el);
    $('.editbutton').trigger('click');
    $('[name="title"]').val('ブログ更新');
    $('[name="message"]').val('メッセージ更新');
    $('[name="save"]').trigger('click');
    expect(this.saveBlogSpy.calls.count()).toBe(1);
    expect($('#blogList > div')).not.toHaveClass('editing');
    expect($('div.view li')).toContainText('ブログ更新');
    return expect($('div.view li')).toContainText('メッセージ更新');
  });
  return it('キャンセルを押すとデータが更新されないで編集が終了する', function() {
    $('#blogList').append(this.blogView.render().el);
    $('.editbutton').trigger('click');
    $('[name="title"]').val('ブログ更新');
    $('[name="message"]').val('メッセージ更新');
    $('[name="cancel"]').trigger('click');
    expect(this.closeSpy.calls.count()).toBe(1);
    expect($('#blogList > div')).not.toHaveClass('editing');
    expect($('div.view li')).not.toContainText('ブログ更新');
    return expect($('div.view li')).not.toContainText('メッセージ更新');
  });
});
