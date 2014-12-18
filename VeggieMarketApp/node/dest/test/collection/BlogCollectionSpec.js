describe('コレクションテスト', function() {
  return it('コレクションにモデルがセットされているか', function() {
    var blogCollection;
    blogCollection = new BlogCollection();
    return expect(blogCollection.model).toBe(Blog);
  });
});
