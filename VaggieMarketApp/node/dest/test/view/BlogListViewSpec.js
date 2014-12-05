describe('ブログコレクションテスト', function() {
  beforeEach(function() {
    return this.blogListView = new BlogListView();
  });
  return it('elテスト', function() {
    expect(this.blogListView.render()).toEqual(this.blogListView);
    expect(this.blogListView.collection).toEqual(new BlogCollection());
    return console.log(this.blogListView.el);
  });
});
