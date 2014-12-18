describe('モデルテスト', function() {
  return it('defaultTest', function() {
    var blog;
    blog = new Blog();
    expect(blog.has('title')).toBeTruthy();
    expect(blog.get('title')).toBe('');
    return expect(blog.get('message')).toEqual('なし');
  });
});
